package chords;

public class GMaj extends ThreeNoteChord {

	public static int baseNote = 31;
	
	public GMaj(int octave) {
		super(baseNote, octave);
		int baseNoteInOctave = baseNote + (octave * 12);
		notes[0] = baseNoteInOctave;
		notes[1] = baseNoteInOctave + 4;
		notes[2] = baseNoteInOctave + 7;
	}
	
//	@Override
//	public int[] transpose(int note) {
//		int difference = Math.abs(this.notes[0] - note);
//		int[] transposedNotes = {};
//		if (notes[0] > note) {
//			transposedNotes = new int[]{this.notes[0] - difference, this.notes[1] - difference, this.notes[2] - difference};
//		} else {
//			transposedNotes = new int[]{this.notes[0] + difference, this.notes[1] + difference, this.notes[2] + difference};
//		}
//		return transposedNotes;
//	}

}
