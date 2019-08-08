package generate;

import java.util.ArrayList;
import java.util.HashMap;

import javax.sound.midi.Track;

import music.Main;
import music.Note;
import music.Song;

public class LeftHand {
	
	ArrayList<HashMap<int[], Note.Type>> phrase = new ArrayList<HashMap<int[], Note.Type>>();
	
	int startingNote;
	int previousBaseNote, measure, numPhrases;
	int volume;
	Song song;
	Track track;
	GenerationAlgorithm generationAlgorithm;
	
	public LeftHand(Song song, Track track, int startingNote, int numPhrases, int volume, GenerationAlgorithm generationAlgorithm) {
		this.startingNote = startingNote;
		this.song = song;
		this.track = track;
		this.previousBaseNote = startingNote;
		// Must be multiplied by 5 because there are 5 measures per phrase
		this.measure = Main.phrasesFilled * 5; // Starts at 0 when the song starts
		this.numPhrases = numPhrases;
		this.volume = volume;
		this.generationAlgorithm = generationAlgorithm;
		
		for (int i = 0; i <= this.numPhrases; i++) {
			// Must increase measure count each loop, otherwise only one phrase will be played
			this.measure = generationAlgorithm.callLH(i + Main.phrasesFilled, this.measure, this.startingNote, this.phrase);
			//playPhrase(i);
		}
		this.createMeasures();
		
	}
	
	public void createMeasures() {
		
		for (int i = 0; i < this.phrase.size(); i++) {
			
			for (int j = 0; j < this.phrase.get(i).size(); j++) {
			
				for (int[] key : this.phrase.get(i).keySet()) {
					
					this.song.makeNote(key[0], this.volume, key[1], this.phrase.get(i).get(key), track);
				}
			}
		}
	}

//	public void generateMainMeasure(int[] chordNotes, int measure) {
//		
//		HashMap<int[], Note.Type> notesInMeasure = new HashMap<int[], Note.Type>();
//		
//		int ticksSinceStart = measure * 16;
//		
//		notesInMeasure.put(new int[] {chordNotes[0], ticksSinceStart + 0}, Note.Type.HALF);	
//		
//		notesInMeasure.put(new int[] {chordNotes[1], ticksSinceStart + 4}, Note.Type.QUARTER);
//		notesInMeasure.put(new int[] {chordNotes[2], ticksSinceStart + 4}, Note.Type.QUARTER);
//		
//		notesInMeasure.put(new int[] {chordNotes[0], ticksSinceStart + 6}, Note.Type.EIGHTH);
//		notesInMeasure.put(new int[] {chordNotes[2], ticksSinceStart + 8}, Note.Type.EIGHTH);
//		
//		notesInMeasure.put(new int[] {chordNotes[0], ticksSinceStart + 12}, Note.Type.EIGHTH);
//		notesInMeasure.put(new int[] {chordNotes[1], ticksSinceStart + 14}, Note.Type.EIGHTH);
//		notesInMeasure.put(new int[] {chordNotes[2], ticksSinceStart + 14}, Note.Type.EIGHTH);
//
//		this.phrase.add(notesInMeasure);
//		
//	}
//	
//	public void generateTransitionMeasure(int chordNotes, int measure) {
//		
//		HashMap<int[], Note.Type> notesInMeasure = new HashMap<int[], Note.Type>();
//		
//		int ticksSinceStart = measure * 16;
//		
//		notesInMeasure.put(new int[] {chordNotes, ticksSinceStart + 0}, Note.Type.EIGHTH);
//		notesInMeasure.put(new int[] {chordNotes, ticksSinceStart + 2}, Note.Type.EIGHTH);
//
//		
//		notesInMeasure.put(new int[] {chordNotes, ticksSinceStart + 4}, Note.Type.EIGHTH); // baseNote + 2
//
//		notesInMeasure.put(new int[] {chordNotes + 3, ticksSinceStart + 6}, Note.Type.EIGHTH); // baseNote + 4
//		
//		notesInMeasure.put(new int[] {chordNotes + 5, ticksSinceStart + 8}, Note.Type.HALF);
//		
//		this.phrase.add(notesInMeasure);
//	}
//	
//	
//	
//	public void playPhrase(int numPhrase) {
//		
//		int measuresPerPhrase = 5;
//		this.previousBaseNote = this.startingNote;
//		
////		for (int i = 0; i < measuresPerPhrase - 1; i++) {
////			generateMainMeasure(this.startingNote - (i * 3), this.measure);
////			this.previousBaseNote -= i;
////			this.measure++;
////		}
////		generateMainMeasure(new CMaj(3).transpose(this.startingNote)[0], this.measure);
////		this.measure++;
////		generateMainMeasure(new AMaj(3).transpose(this.startingNote - 3)[0], this.measure); // this.startingNote -3
////		this.measure++;
////		generateMainMeasure(new FMaj(2).transpose(this.startingNote - 7)[0], this.measure); // -7
////		this.measure++;
////		generateMainMeasure(new GMaj(2).transpose(this.startingNote - 5)[0], this.measure); // -5
//		
//		
//		generateMainMeasure(new DSharpMaj(2).transpose(this.startingNote + 3), this.measure);
//		this.measure++;
//		generateMainMeasure(new CMin(2).transpose(this.startingNote), this.measure); // this.startingNote -3
//		this.measure++;
//		generateMainMeasure(new ASharp5th(2).transpose(this.startingNote - 2), this.measure); // -7
//		this.measure++;
//		generateMainMeasure(new CMin(2).transpose(this.startingNote), this.measure); // -5
//		
//		
//		this.previousBaseNote -= 5; // -= 5
//		this.measure++;
//		generateTransitionMeasure(this.previousBaseNote, this.measure);
//		
//		this.measure = numPhrase * measuresPerPhrase;
//	}
}
