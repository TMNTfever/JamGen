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

	/**
	 * Constructor calls to create the melody, chords and beat.
	 * 
	 * @param key		Key C = 0, and each increment is a half step.
	 */
	public Song(int key) {
		this.melody = new Melody(key);
		this.chords = new Chords();
		this.beat = new Beat();
	}

	/**
	 * Calls functions to generate the separate channels of a song.
	 *
	 * @return
	 */
	String generate(String melodyInstr, String chordsInstr, int percusInstr, int key,
					boolean melodyEnable, boolean chordsEnable, boolean percusEnable) {
		this.introLength = (r.nextInt(5) * 2) + 4;
		this.verseLength = (r.nextInt(5) * 2) + 4;
		this.chorusLength = (r.nextInt(5) * 2) + 4;
		this.bridgeLength = (r.nextInt(5) * 2) + 4;
		this.endingLength = (r.nextInt(5) * 2) + 4;

// Testing purposes
System.out.println("intro: " + introLength);
System.out.println("verse1: " + verseLength);
System.out.println("chorus1: " + chorusLength);
System.out.println("verse2: " + verseLength);
System.out.println("chorus2: " + chorusLength);
System.out.println("bridge: " + bridgeLength);
System.out.println("chorus3: " + chorusLength);
System.out.println("ending: " + endingLength);

		return (percusEnable ? ("V9 " + 
				beat.generate(this.introLength,
							  this.verseLength,
							  this.chorusLength,
							  this.bridgeLength,
							  this.endingLength,
							  percusInstr)) : "") +
			   (chordsEnable ? ("V0 " +
				chordsInstr +
				chords.generate(this.introLength,
								this.verseLength,
								this.chorusLength,
								this.bridgeLength,
								this.endingLength)) : "") +
			   (melodyEnable ? ("V1 " +
				melodyInstr +
				melody.generate(this.introLength,
	   							this.verseLength,
	   							this.chorusLength,
	   							this.bridgeLength,
	   							this.endingLength,
	   							key)) : "");
	}
}
