package generate;


import javax.sound.midi.Track;

import music.Main;
import music.Song;
import scales.Scale;

public class RightHand {

	int numPhrases;
	int volume;
	Song song;
	Track track;
	Scale scale;
	GenerationAlgorithm generationAlgorithm;
	
	@SuppressWarnings("static-access")
	public RightHand(Song song, Track track, int startingNote, int numPhrases, int volume, Scale scale,
					GenerationAlgorithm generationAlgorithm) {
		
		this.numPhrases = numPhrases;
		this.song = song;
		this.track = track;
		this.volume = volume;
		this.scale = scale;
		this.generationAlgorithm = generationAlgorithm;
		
		
		for (int i = 0; i < this.numPhrases; i++) {
			//generateRandomPhrases(i);
			// Start generating the right hand notes at the last filled spot, according to Main.phrasesFilled
			generationAlgorithm.callRH(i + Main.phrasesFilled, this.song, this.track, this.scale, this.volume);
		}
		generationAlgorithm.playFinalChord(Main.phrasesFilled + this.numPhrases, this.song, this.track, this.scale, this.volume);
		
	}
	
//	public void generateRandomPhrases(int currentPhrase) {
//		
//		int currentTicks = currentPhrase * 5 * 16;
//		int ticksToNextPhrase = 16 * 5 * (currentPhrase + 1);
//		Note.Type[] noteTypeChoices = {Note.Type.EIGHTH, Note.Type.QUARTER,
//										Note.Type.DOTTED_QUARTER, Note.Type.HALF};
//		
//		
//		while (currentTicks < ticksToNextPhrase) {
//			// Scale has list of notes inside it, no longer need to list notes in this class
//			int note = this.scale.notes[r.nextInt(this.scale.getLength())];
//			
//			Note.Type randomTypeChoice = noteTypeChoices[r.nextInt(noteTypeChoices.length)];
//			
//			
//			this.song.makeNote(note, this.volume, currentTicks, randomTypeChoice, track);
//			currentTicks += Note.getNoteTime(randomTypeChoice);
//		}
//		
//		
//	}
}
