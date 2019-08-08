package chords;

public class ESus4Sharp5 extends ThreeNoteChord {

	public static int baseNote = 28;
	
	public ESus4Sharp5(int octave) {
		super(baseNote, octave);
		int baseNoteInOctave = baseNote + (octave * 12);
		notes[0] = baseNoteInOctave;
		notes[1] = baseNoteInOctave + 5;
		notes[2] = baseNoteInOctave + 8;
	}

}
