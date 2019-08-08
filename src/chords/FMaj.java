package chords;

public class FMaj extends ThreeNoteChord {

	public static int baseNote = 29;
	
	public FMaj(int octave) {
		super(baseNote, octave);
		int baseNoteInOctave = baseNote + (octave * 12);
		notes[0] = baseNoteInOctave;
		notes[1] = baseNoteInOctave + 4;
		notes[2] = baseNoteInOctave + 7;
	}

}
