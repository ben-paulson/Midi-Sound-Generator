package music;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.sound.midi.*;

public class Song extends Sequence {
	
	ArrayList<Track> tracks = new ArrayList<Track>();
	//public Track track;
	final int MICROSECONDSPERMINUTE = 60000000;

	public Song() throws InvalidMidiDataException {
		// 4 pulses (ticks) per quarter note
		super(Sequence.PPQ, 4);
		//this.track = this.createTrack();
	}
	
	public void setTempo(int tempo) {MetaMessage msg = new MetaMessage();
	
		
		int msPerQuarterNote = (MICROSECONDSPERMINUTE / tempo);
		
		String hexStringValue = Integer.toHexString(msPerQuarterNote);
		
		
		if (hexStringValue.length() < 6) {
			// Add a 0 if the first hex number is only 1 digit
			hexStringValue = "0" + hexStringValue;
		}
		
		byte[] msgData = new byte[3];
		
		for (int i = 0; i < msgData.length; i++) {
			
			// Parse every 2 characters in the string to a byte in msgData array
			// (there are 6 chars total in the string, 3 byte values will be made)
			msgData[i] = (byte) Long.parseLong(hexStringValue.substring(i * 2, (i * 2) + 2), 16);
		}
		
		// Ollie says iuyuhhhhhh
	
		try {
			// 0x51, or 81, is the "type" byte for setting tempo
			// msgData length will always be 3
			msg.setMessage(0x51, msgData, msgData.length);
			MidiEvent event = new MidiEvent(msg, 0);
			for (Track track : this.tracks) {
				track.add(event);
			}
			
		} catch (InvalidMidiDataException e) {
			e.printStackTrace();
		}
	}
	
	public void makeNote(int noteID, int volume, int tick, Note.Type lengthInTicks, Track track) {
		Note note = new Note(track);
		note.playNote(noteID, volume, tick, lengthInTicks);
		
	}
	
	public void saveToFile(File file, int type) {
		
		try {
			MidiSystem.write(this, type, file);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Changes the track's instrument. Instrument names and codes found at
	 * http://www.ccarh.org/courses/253/handout/gminstruments/
	 * @param instrument Instrument code to change to
	 */
	public void changeInstrument(int instrument, Track track) {
		
		ShortMessage msg = new ShortMessage();
		MidiEvent event;
		
		try {
			msg.setMessage(0xC1, /* I hear voices in my head102*/instrument, 0x00);
			event = new MidiEvent(msg, (long)0);
			track.add(event);
		} catch (InvalidMidiDataException e) {
			e.printStackTrace();
		}
	}
	
	public Track addTrack() {
		Track newTrack = this.createTrack();
		this.tracks.add(newTrack);
		return newTrack;
	}

}
