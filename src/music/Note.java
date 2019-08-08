package music;
import java.util.HashMap;
import java.util.Random;
import javax.sound.midi.*;

public class Note {
	
	public enum Type {
		TRIPLET, SIXTEENTH, EIGHTH, QUARTER, HALF, DOTTED_QUARTER, WHOLE, RANDOM;
	}

	Track track;
	static HashMap<Type, Double> noteLength = new HashMap<Type, Double>();
	
	public Note(Track track) {
		this.track = track;
		noteLength.put(Type.TRIPLET, 4.0 / 3.0);
		noteLength.put(Type.SIXTEENTH, 1.0);
		noteLength.put(Type.EIGHTH, 2.0);
		noteLength.put(Type.QUARTER, 4.0);
		noteLength.put(Type.HALF, 8.0);
		noteLength.put(Type.DOTTED_QUARTER, 6.0);
		noteLength.put(Type.WHOLE, 16.0);
		
		Random r = new Random();
		int randomValue = r.nextInt(noteLength.size());
		noteLength.put(Type.RANDOM, (double)noteLength.values().toArray()[randomValue]);
	}
	
	public void playNote(int note, int volume, int tick, Type lengthInTicks) {
		
		ShortMessage msg = new ShortMessage();
		MidiEvent event;
		
		try {
			// 0x90 is the number for "play"
			msg.setMessage(0x90, 1, note, volume);
			event = new MidiEvent(msg, tick);
			this.track.add(event);
			stopNote(note, volume, tick + noteLength.get(lengthInTicks));
			
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}
	
	private void stopNote(int note, int volume, double tick) {
		
		ShortMessage msg = new ShortMessage();
		MidiEvent event;
		
		try {
			// 0x80 is the number for "stop"
			msg.setMessage(0x80, 1, note, volume);
			event = new MidiEvent(msg, (long) tick);
			this.track.add(event);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static double getNoteTime(Type typeOfNote) {
		return noteLength.get(typeOfNote);
	}
}
