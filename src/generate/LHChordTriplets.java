package generate;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

import chords.AMin;
import chords.ASharp5th;
import chords.CMaj;
import chords.CMin;
import chords.CSus;
import chords.DSharpMaj;
import chords.ESus4Sharp5;
import music.Note;

public class LHChordTriplets extends LHGenMethods {

	Random r = new Random();
	String key;
	
	public LHChordTriplets(String key) {
		this.key = key;
	}
	
	@Override
	public int callLH(int numPhrase, int measure, int startingNote, ArrayList<HashMap<int[], Note.Type>> phrase) {

		int measuresPerPhrase = 5;
		HashMap<int[], Note.Type> notesInMeasure = new HashMap<int[], Note.Type>();
		
		int[][] chordChoices = null;
		
		if (key == "major") {
			chordChoices = new int[][]{new AMin(3).transpose(startingNote - 3), new CMaj(3).transpose(startingNote),
									new ESus4Sharp5(3).transpose(startingNote - 8), new CSus(3).transpose(startingNote)};
		} else if (key == "minor") {
			chordChoices = new int[][]{new CMin(3).transpose(startingNote), new DSharpMaj(3).transpose(startingNote + 2),
										new ASharp5th(3).transpose(startingNote - 2)};
		}
		
		int ticksSinceStart;
		
		for (int i = 0; i < 5; i++) {
			ticksSinceStart = measure * 16;
			int[] thisMeasureChord = chordChoices[r.nextInt(chordChoices.length)];
			int[] secondChord = chordChoices[r.nextInt(chordChoices.length)];
			for (int note : thisMeasureChord) {
				notesInMeasure.put(new int[] {note, ticksSinceStart}, Note.Type.HALF);
			}
			for (int note : secondChord) {
				notesInMeasure.put(new int[] {note, ticksSinceStart + 8}, Note.Type.HALF);
			}
			
			notesInMeasure.put(new int[] {thisMeasureChord[0] + 12, ticksSinceStart + 4}, Note.Type.TRIPLET);
			notesInMeasure.put(new int[] {thisMeasureChord[1] + 12, ticksSinceStart + 8}, Note.Type.TRIPLET);
			notesInMeasure.put(new int[] {thisMeasureChord[2] + 12, ticksSinceStart + 12}, Note.Type.TRIPLET);
			notesInMeasure.put(new int[] {thisMeasureChord[1] + 12, ticksSinceStart + 16}, Note.Type.TRIPLET);
//			notesInMeasure.put(new int[] {thisMeasureChord[0] + 12, ticksSinceStart + 20/3}, Note.Type.TRIPLET);
			
//			notesInMeasure.put(new int[] {secondChord[0] + 12, ticksSinceStart + 28/3}, Note.Type.TRIPLET);
//			notesInMeasure.put(new int[] {secondChord[1] + 12, ticksSinceStart + 32/3}, Note.Type.TRIPLET);
//			notesInMeasure.put(new int[] {secondChord[2] + 12, ticksSinceStart + 36/3}, Note.Type.TRIPLET);
//			notesInMeasure.put(new int[] {secondChord[1] + 12, ticksSinceStart + 40/3}, Note.Type.TRIPLET);
//			notesInMeasure.put(new int[] {secondChord[0] + 12, ticksSinceStart + 44/3}, Note.Type.TRIPLET);
			measure++;
			phrase.add(notesInMeasure);
		}
		
		
		measure = numPhrase * measuresPerPhrase;
		return measure;
		
	}

}
