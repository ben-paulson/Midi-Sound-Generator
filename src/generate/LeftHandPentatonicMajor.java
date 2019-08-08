package generate;

import java.util.ArrayList;
import java.util.HashMap;

import chords.*;
import music.Note;

public class LeftHandPentatonicMajor extends LHGenMethods {

	@Override
	public int callLH(int numPhrase, int measure, int startingNote, ArrayList<HashMap<int[], Note.Type>> phrase) {

		int measuresPerPhrase = 5;
		int previousBaseNote = startingNote;
		
		
		generateMainMeasure(new CMaj(3).transpose(startingNote), measure, phrase);
		measure++;
		generateMainMeasure(new AMin(3).transpose(startingNote - 3), measure, phrase); // this.startingNote -3
		measure++;
		generateMainMeasure(new FMaj(2).transpose(startingNote - 7), measure, phrase); // -7
		measure++;
		generateMainMeasure(new GMaj(2).transpose(startingNote - 5), measure, phrase); // -5
		
		
		previousBaseNote -= 5; // -= 5
		measure++;
		generateTransitionMeasure(previousBaseNote, measure, "major", phrase);
		
		measure = numPhrase * measuresPerPhrase;
		return measure;
		
	}

}
