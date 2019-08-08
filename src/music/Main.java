package music;
import java.io.File;
import java.util.Arrays;

import javax.sound.midi.InvalidMidiDataException;
import javax.sound.midi.Track;

import generate.*;
import scales.*;

public class Main {
	
	// Used for keeping track of how many measures/phrases have notes in them.
	// If multiple RightHand or LeftHand objects are created, you can use this to place
	// them after each other in the song. For changing keys, instruments, etc. halfway through the song
	public static int phrasesFilled = 0;

	@SuppressWarnings("unused")
	public static void main(String[] args) throws InvalidMidiDataException {
		
		Song song = new Song();
		
		Track rhTrack = song.addTrack();
		Track lhTrack = song.addTrack();
		Track daTrack = song.addTrack();
		
		song.setTempo(120); // 120
		
		song.changeInstrument(28, daTrack);
		LeftHand da = new LeftHand(song, daTrack, 48, 10, 70, new LHPentatonicRandomChords("major"));
		
		song.changeInstrument(16, rhTrack);
		RightHand ra = new RightHand(song, rhTrack, 48, 10, 70, new PentatonicMajor(48), new RightHandFastOrder());
		
/*		song.changeInstrument(0, lhTrack);
		LeftHand lh = new LeftHand(song, lhTrack, 48, 10, 100, new LeftHandPentatonicMajor()); // volume 30
		
		song.changeInstrument(0, rhTrack);
		RightHand rh = new RightHand(song, rhTrack, 60, 10, 120, new PentatonicMajor(60), new RightHandRandom()); // volume 120
		
		phrasesFilled += 10;
		
		song.changeInstrument(0, lhTrack);
		LeftHand lh1 = new LeftHand(song, lhTrack, 42, 10, 100, new LeftHandPentatonicMajor()); // volume 30
		
		song.changeInstrument(0, rhTrack);
		RightHand rh1 = new RightHand(song, rhTrack, 54, 10, 120, new PentatonicMajor(54), new RightHandRandom());
		
		phrasesFilled += 10;
		
		song.changeInstrument(0, lhTrack);
		LeftHand lh2 = new LeftHand(song, lhTrack, 52, 10, 100, new LeftHandPentatonicMajor()); // volume 30
		
		song.changeInstrument(0, rhTrack);
		RightHand rh2 = new RightHand(song, rhTrack, 64, 10, 120, new PentatonicMajor(64), new RightHandRandom());
*/		
		
//		RightHand anotherRH = new RightHand(song, rhTrack, 60, 5, 120, new PentatonicMajor(60), new RightHandRandom());
		
//		RightHand anotherRH = new RightHand(song, lhTrack, 60, 10, 120, new PentatonicMajor(60), new RightHandRandom());
//		LeftHand anotherLH = new LeftHand(song, lhTrack, 50, 1, 100, new LeftHandPentatonicMajor());
		
		song.saveToFile(new File("testMidi2.mid"), 1);
	}
}
