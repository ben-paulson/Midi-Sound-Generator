package generate;

import java.util.ArrayList;
import java.util.HashMap;

import javax.sound.midi.Track;

import music.Note;
import music.Song;
import scales.Scale;

public interface GenerationAlgorithm {
	
	/**
	 * Method used to call the right hand melodies using the algorithm chosen
	 * @param currentPhrase the current phrase number (1st, 5th, 4th, etc)
	 * @param song song associated with the right hand
	 * @param scale scale to use when generating notes
	 * @param volume self explanatory
	 */
	public void callRH(int currentPhrase, Song song, Track track, Scale scale, int volume);
	
	/**
	 * Method used to call the various left hand accompaniments based on the algorithm chosen
	 * @param numPhrase The current phrase number (1st, 5th, 7th, etc)
	 * @param measure measure number to create the note. It is also the return value
	 * @param startingNote note to start on and transpose the chords to
	 * @param phrase contains the note pitches and lengths to be written in this phrase
	 * @return the measure number so that it is not reset to 0 every time this method is called in LeftHand's loop
	 */
	public int callLH(int numPhrase, int measure, int startingNote, ArrayList<HashMap<int[], Note.Type>> phrase);
	
	public void playFinalChord(int currentPhrase, Song song, Track track, Scale scale, int volume);
}
