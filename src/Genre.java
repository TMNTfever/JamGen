import java.util.Random;

/**
 * @author	Julian-Chris Reyes
 * JamGen	Genre
 * 
 * Abstract class to easily add in more music genres. Each genre contains
 * specific generating algorithms, and implemented best by being factored out.
 */

public abstract class Genre {
	// Used as a random int/boolean generator for all music generation
	final Random r = new Random();

	// Number of chords within the song's chord progression (4, 8, 12)
	int chordNum;

	/* The number of measures consisting in each section of the song. This
	 * number is dependent on the @chordnum and a random int.
	 */
	int introLength;
	int verseLength;
	int chorusLength;
	int bridgeLength;
	int endingLength;

	String generate() {
		return genBeat() + genChords() + genMelody();
	}

	abstract String genBeat();
	abstract String genChords();
	abstract String genMelody();
}
