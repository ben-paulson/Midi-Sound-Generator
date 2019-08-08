package scales;

public class PentatonicMajor extends Scale {
	
	int length = 11;

	public PentatonicMajor(int baseNote) {
		super(baseNote);
		
		// Initialize notes
		notes = new int[this.length];
		
		notes[0] = baseNote;
		notes[1] = baseNote + 2;
		notes[2] = baseNote + 4;
		notes[3] = baseNote + 7;
		notes[4] = baseNote + 9;
		notes[5] = baseNote + 12;
		notes[6] = baseNote + 14;
		notes[7] = baseNote + 16;
		notes[8] = baseNote + 19;
		notes[9] = baseNote + 21;
		notes[10] = baseNote + 24;
	}
	
	@Override
	public int getLength() {
		return this.length;
	}

}
