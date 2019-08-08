package chords;

public class CMin extends ThreeNoteChord{

	public static int baseNote = 24;
	
	public CMin(int octave) {
		super(baseNote, octave);
		int baseNoteInOctave = baseNote + (octave * 12);
		notes[0] = baseNoteInOctave;
		notes[1] = baseNoteInOctave + 3;
		notes[2] = baseNoteInOctave + 7;
	}

}
