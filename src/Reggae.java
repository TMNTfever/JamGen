/**
 * @author	Julian-Chris Reyes
 * JamGen	Reggae
 * 
 * Uses reggae-based music theory to generate a reggae song.
 */

public class Reggae extends Genre {
	public Reggae() {
	}

	public String genBeat() {
		return "V0 ";
	}

	public String genChords() {
		return "V1 ";
	}

	public String genMelody() {
		return "V2 ";
	}
}
