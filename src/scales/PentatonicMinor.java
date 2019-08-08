package scales;

public class PentatonicMinor extends Scale {
	
	int length = 11;

	public PentatonicMinor(int baseNote) {
		super(baseNote);
		
		// Initialize notes
		notes = new int[this.length];
		
		notes[0] = baseNote;
		notes[1] = baseNote + 3;
		notes[2] = baseNote + 5;
		notes[3] = baseNote + 7;
		notes[4] = baseNote + 10;
		notes[5] = baseNote + 12;
		notes[6] = baseNote + 15;
		notes[7] = baseNote + 17;
		notes[8] = baseNote + 19;
		notes[9] = baseNote + 22;
		notes[10] = baseNote + 24;
	}
	
	@Override
	public int getLength() {
		return this.length;
	}
}
