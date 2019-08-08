package generate;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

import javax.sound.midi.Track;

import music.Note;
import music.Song;
import music.Note.Type;
import scales.Scale;

public class RightHandFastOrder implements GenerationAlgorithm {
	
	private Random r = new Random();
	public boolean playFinalNote = true;

	@Override
	public void callRH(int currentPhrase, Song song, Track track, Scale scale, int volume) {
		
		int currentTicks = currentPhrase * 5 * 16;
		int ticksToNextPhrase = 16 * 5 * (currentPhrase + 1);
		Note.Type[] noteTypeChoices = {Note.Type.EIGHTH, Note.Type.QUARTER,
										Note.Type.SIXTEENTH};//, Note.Type.TRIPLET};
		
		HashMap<Note.Type, int[]> noteTypeMaxRepeat = new HashMap<Note.Type, int[]>();
		noteTypeMaxRepeat.put(Note.Type.EIGHTH, new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8}); //8
		noteTypeMaxRepeat.put(Note.Type.QUARTER, new int[]{0, 1, 2, 3}); //3
		noteTypeMaxRepeat.put(Note.Type.SIXTEENTH, new int[]{2, 4, 6, 8, 10, 12, 14, 16});
		//noteTypeMaxRepeat.put(Note.Type.TRIPLET, 12);
		
		Note.Type prevType = null;
		Note.Type typeChoice;
		int sameTypeCount = 0;
		int nextTypeRepeat = 0;
		
		
		while (currentTicks < ticksToNextPhrase) {
			// Scale has list of notes inside it, no longer need to list notes in this class
			int note = scale.notes[r.nextInt(scale.getLength())];
			
			if (sameTypeCount < nextTypeRepeat) {
				typeChoice = prevType;
			} else {
				typeChoice = noteTypeChoices[r.nextInt(noteTypeChoices.length)];
			}
			
			
			
			if (typeChoice == prevType) {
				sameTypeCount++;
			} else {
				sameTypeCount = 0;
				//Sixteenth notes will only appear in groups of 4
				nextTypeRepeat = noteTypeMaxRepeat.get(typeChoice)[r.nextInt(noteTypeMaxRepeat.get(typeChoice).length)];
				
			}
			
			prevType = typeChoice;
			
			
			song.makeNote(note, volume, currentTicks, typeChoice, track);
			currentTicks += Note.getNoteTime(typeChoice);
		}
		
	}

	@Override
	public int callLH(int numPhrase, int measure, int startingNote, ArrayList<HashMap<int[], Type>> phrase) {
		return 0;
	}

	@Override
	public void playFinalChord(int currentPhrase, Song song, Track track, Scale scale, int volume) {
		int currentTicks = currentPhrase * 5 * 16;
		int[] chordNotes = {scale.notes[0], scale.notes[3], scale.notes[scale.notes.length - 1]};
		for (int note : chordNotes) {
			song.makeNote(note, volume, currentTicks, Note.Type.WHOLE, track);
		}
	}
}
