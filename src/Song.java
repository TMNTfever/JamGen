/**
 * @author	Julian-Chris Reyes
 * JamGen	Song
 *
 * Each song consists of three major tracks. This class determines the length
 * of the song.
 */

import java.util.Random;

public class Song {
	Melody melody;
	Chords chords;
	Beat beat;

	// Used as a random int/boolean generator for all music generation
	final Random r = new Random();

	/* The number of measures consisting in each section of the song. This
	 * number is dependent on the @chordnum and a random int.
	 */
	int introLength;
	int verseLength;
	int chorusLength;
	int bridgeLength;
	int endingLength;

	public Song() {
		this.melody = new Melody();
		this.chords = new Chords();
		this.beat = new Beat();
		this.introLength = (r.nextInt(2) * 4) + 4;
		this.verseLength = (r.nextInt(2) * 4) + 4;
		this.chorusLength = (r.nextInt(2) * 4) + 4;
		this.bridgeLength = (r.nextInt(2) * 4) + 4;
		this.endingLength = (r.nextInt(2) * 4) + 4;
	}

	/**
	 * Calls functions to generate the separate channels of a song.
	 *
	 * @return
	 */
	String generate(String melodyInstr, String chordsInstr) {
		return "V9 " + beat.generate(this.introLength,
									 this.verseLength,
									 this.chorusLength,
									 this.bridgeLength,
									 this.endingLength) +
			   "V0 " + chordsInstr + chords.generate(this.introLength,
							 this.verseLength,
							 this.chorusLength,
							 this.bridgeLength,
							 this.endingLength) +
			   "V1 " + melodyInstr + melody.generate(this.introLength,
					   								 this.verseLength,
					   								 this.chorusLength,
					   								 this.bridgeLength,
					   								 this.endingLength);
	}

}
