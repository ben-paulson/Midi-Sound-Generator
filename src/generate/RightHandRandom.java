package generate;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

import javax.sound.midi.Track;

import music.Note;
import music.Note.Type;
import music.Song;
import scales.Scale;

public class RightHandRandom implements GenerationAlgorithm {

	private Random r = new Random();

	@Override
	public void callRH(int currentPhrase, Song song, Track track, Scale scale, int volume) {
		
		int currentTicks = currentPhrase * 5 * 16;
		int ticksToNextPhrase = 16 * 5 * (currentPhrase + 1);
		Note.Type[] noteTypeChoices = {Note.Type.EIGHTH, Note.Type.QUARTER,
										Note.Type.DOTTED_QUARTER, Note.Type.HALF};
		
		
		while (currentTicks < ticksToNextPhrase) {
			// Scale has list of notes inside it, no longer need to list notes in this class
			int note = scale.notes[r.nextInt(scale.getLength())];
			
			Note.Type randomTypeChoice = noteTypeChoices[r.nextInt(noteTypeChoices.length)];
			
			
			song.makeNote(note, volume, currentTicks, randomTypeChoice, track);
			currentTicks += Note.getNoteTime(randomTypeChoice);
		}
		
	}

	@Override
	public int callLH(int numPhrase, int measure, int startingNote, ArrayList<HashMap<int[], Type>> phrase) {
		return 0;
	}

	@Override
	public void playFinalChord(int currentPhrase, Song song, Track track, Scale scale, int volume) {
		// TODO Auto-generated method stub
		
	}

}
