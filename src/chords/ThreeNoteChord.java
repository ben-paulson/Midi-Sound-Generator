package chords;

public class ThreeNoteChord extends Chord{
	
	public int[] notes = new int[3];

	public ThreeNoteChord(int baseNote, int octave) {
		super(baseNote, octave);
	}
	
	@Override
	public int[] transpose(int note) {
		int difference = Math.abs(this.notes[0] - note);
		int[] transposedNotes = {};
		if (notes[0] > note) {
			transposedNotes = new int[]{this.notes[0] - difference, this.notes[1] - difference, this.notes[2] - difference};
		} else {
			transposedNotes = new int[]{this.notes[0] + difference, this.notes[1] + difference, this.notes[2] + difference};
		}
		return transposedNotes;
	}

}
