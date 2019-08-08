package generate;

import java.util.ArrayList;
import java.util.HashMap;

import chords.ASharp5th;
import chords.CMin;
import chords.DSharpMaj;
import music.Note;

public class LeftHandPentatonicMinor extends LHGenMethods {

	@Override
	public int callLH(int numPhrase, int measure, int startingNote, ArrayList<HashMap<int[], Note.Type>> phrase) {

		int measuresPerPhrase = 5;
		int previousBaseNote = startingNote;
		
		
		generateMainMeasure(new DSharpMaj(2).transpose(startingNote + 3), measure, phrase);
		measure++;
		generateMainMeasure(new CMin(2).transpose(startingNote), measure, phrase); // this.startingNote -3
		measure++;
		generateMainMeasure(new ASharp5th(2).transpose(startingNote - 2), measure, phrase); // -7
		measure++;
		generateMainMeasure(new CMin(2).transpose(startingNote), measure, phrase); // -5
		
		
		previousBaseNote -= 5; // -= 5
		measure++;
		generateTransitionMeasure(previousBaseNote, measure, "minor", phrase);
		
		measure = numPhrase * measuresPerPhrase;
		return measure;
		
	}

	

}
