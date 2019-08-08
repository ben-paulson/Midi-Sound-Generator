package chords;

public class DSharpMaj extends ThreeNoteChord{

	public static int baseNote = 27;
	
	public DSharpMaj(int octave) {
		super(baseNote, octave);
		int baseNoteInOctave = baseNote + (octave * 12);
		notes[0] = baseNoteInOctave;
		notes[1] = baseNoteInOctave + 4;
		notes[2] = baseNoteInOctave + 7;
	}

}
