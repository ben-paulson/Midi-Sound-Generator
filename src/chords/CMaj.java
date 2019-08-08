package chords;

public class CMaj extends ThreeNoteChord {

	public static int baseNote = 24;
	
	public CMaj(int octave) {
		super(baseNote, octave);
		int baseNoteInOctave = baseNote + (octave * 12);
		notes[0] = baseNoteInOctave;
		notes[1] = baseNoteInOctave + 4;
		notes[2] = baseNoteInOctave + 7;
	}

}
