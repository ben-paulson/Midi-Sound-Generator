package generate;

import java.util.ArrayList;
import java.util.HashMap;

import javax.sound.midi.Track;

import music.Note;
import music.Note.Type;
import music.Song;
import scales.Scale;

public class LHGenMethods implements GenerationAlgorithm {


	@Override
	public void callRH(int currentPhrase, Song song, Track track, Scale scale, int volume) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int callLH(int numPhrase, int measure, int startingNote, ArrayList<HashMap<int[], Type>> phrase) {
		return 0;
		
	}
	
	public void generateMainMeasure(int[] chordNotes, int measure, ArrayList<HashMap<int[], Type>> phrase) {
		
		HashMap<int[], Note.Type> notesInMeasure = new HashMap<int[], Note.Type>();
		
		int ticksSinceStart = measure * 16;
		
		notesInMeasure.put(new int[] {chordNotes[0], ticksSinceStart + 0}, Note.Type.HALF);	
		
		notesInMeasure.put(new int[] {chordNotes[1], ticksSinceStart + 4}, Note.Type.QUARTER);
		notesInMeasure.put(new int[] {chordNotes[2], ticksSinceStart + 4}, Note.Type.QUARTER);
		
		notesInMeasure.put(new int[] {chordNotes[0], ticksSinceStart + 6}, Note.Type.EIGHTH);
		notesInMeasure.put(new int[] {chordNotes[2], ticksSinceStart + 8}, Note.Type.EIGHTH);
		
		notesInMeasure.put(new int[] {chordNotes[0], ticksSinceStart + 12}, Note.Type.EIGHTH);
		notesInMeasure.put(new int[] {chordNotes[1], ticksSinceStart + 14}, Note.Type.EIGHTH);
		notesInMeasure.put(new int[] {chordNotes[2], ticksSinceStart + 14}, Note.Type.EIGHTH);

		phrase.add(notesInMeasure);
		
	}
	
	public void generateTransitionMeasure(int chordNotes, int measure, String key, ArrayList<HashMap<int[], Type>> phrase) {
		
		HashMap<int[], Note.Type> notesInMeasure = new HashMap<int[], Note.Type>();
		
		int ticksSinceStart = measure * 16;
		
		notesInMeasure.put(new int[] {chordNotes, ticksSinceStart + 0}, Note.Type.EIGHTH);
		notesInMeasure.put(new int[] {chordNotes, ticksSinceStart + 2}, Note.Type.EIGHTH);

		if (key == "major") {
			notesInMeasure.put(new int[] {chordNotes + 2, ticksSinceStart + 4}, Note.Type.EIGHTH); // baseNote + 2
			notesInMeasure.put(new int[] {chordNotes + 4, ticksSinceStart + 6}, Note.Type.EIGHTH); // baseNote + 4
		} else if (key == "minor") {
			notesInMeasure.put(new int[] {chordNotes, ticksSinceStart + 4}, Note.Type.EIGHTH); // baseNote + 2
			notesInMeasure.put(new int[] {chordNotes + 3, ticksSinceStart + 6}, Note.Type.EIGHTH); // baseNote + 4
		}
		
		notesInMeasure.put(new int[] {chordNotes + 5, ticksSinceStart + 8}, Note.Type.HALF);
		
		phrase.add(notesInMeasure);
	}

	@Override
	public void playFinalChord(int currentPhrase, Song song, Track track, Scale scale, int volume) {
		// TODO Auto-generated method stub
		
	}
	
}
