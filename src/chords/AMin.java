package chords;

public class AMin extends ThreeNoteChord {

	public static int baseNote = 21;
	
	public AMin(int octave) {
		super(baseNote, octave);
		int baseNoteInOctave = baseNote + (octave * 12);
		notes[0] = baseNoteInOctave;
		notes[1] = baseNoteInOctave + 3;
		notes[2] = baseNoteInOctave + 7;
	}

}
