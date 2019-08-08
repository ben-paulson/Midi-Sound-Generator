package chords;

public class ASharp5th extends ThreeNoteChord {

	public static int baseNote = 22;
	
	public ASharp5th(int octave) {
		super(baseNote, octave);
		int baseNoteInOctave = baseNote + (octave * 12);
		notes[0] = baseNoteInOctave;
		notes[1] = baseNoteInOctave + 7;
		notes[2] = baseNoteInOctave + 12;
	}

}
