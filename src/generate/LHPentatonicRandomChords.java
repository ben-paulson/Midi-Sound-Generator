package generate;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

import chords.*;
import music.Note;

public class LHPentatonicRandomChords extends LHGenMethods {
	
	Random r = new Random();
	String key;
	
	public LHPentatonicRandomChords(String key) {
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
			for (int note : thisMeasureChord) {
				notesInMeasure.put(new int[] {note, ticksSinceStart}, Note.Type.WHOLE);
			}
			notesInMeasure.put(new int[] {thisMeasureChord[0], ticksSinceStart + 4}, Note.Type.QUARTER);
			notesInMeasure.put(new int[] {thisMeasureChord[1], ticksSinceStart + 8}, Note.Type.QUARTER);
			notesInMeasure.put(new int[] {thisMeasureChord[2], ticksSinceStart + 12}, Note.Type.QUARTER);
			measure++;
			phrase.add(notesInMeasure);
		}
		
		
		measure = numPhrase * measuresPerPhrase;
		return measure;
		
	}

}
