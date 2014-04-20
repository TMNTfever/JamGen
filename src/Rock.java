/**
 * @author	Julian-Chris Reyes
 * JamGen	Rock
 * 
 * Uses reggae-based music theory to generate a rock song.
 */

public class Rock extends Genre {
	public Rock() {
		// Number of chords in progression (4, 8, 12)
		this.chordNum = (r.nextInt(2) * 4) + 4;

		if(this.chordNum == 12) {
			// Either 6 or 12 measures
			this.introLength = (r.nextInt(1) * 6) + 6;
			this.verseLength = (r.nextInt(1) * 6) + 6;
			this.chorusLength = (r.nextInt(1) * 6) + 6;
			this.bridgeLength = (r.nextInt(1) * 6) + 6;
			this.endingLength = (r.nextInt(1) * 6) + 6;
		}
		else {
			// Either 4, 8, or 12 measures
			this.introLength = (r.nextInt(2) * 4) + 4;
			this.verseLength = (r.nextInt(2) * 4) + 4;
			this.chorusLength = (r.nextInt(2) * 4) + 4;
			this.bridgeLength = (r.nextInt(2) * 4) + 4;
			this.endingLength = (r.nextInt(2) * 4) + 4;
		}
	}

	/**
	 * Generates a string representation of the song's rhythm track.
	 */
	public String genBeat() {
		String intro = randomBeat(this.introLength);
		String verse = randomBeat(this.verseLength);
		String chorus = randomBeat(this.chorusLength);
		String bridge = randomBeat(this.bridgeLength);
		String ending = randomBeat(this.endingLength);

		return "V0 " + intro + verse + chorus + verse + chorus
				+ bridge + chorus + ending;
	}

	/**
	 * Generates a string representation of the song's chord pattern.
	 */
	public String genChords() {
		// Randomly choose a rock instrument
		String instrument = chooseInstrument();
		
		String intro = randomChords(this.introLength);
		String verse = randomChords(this.verseLength);
		String chorus = randomChords(this.chorusLength);
		String bridge = randomChords(this.bridgeLength);
		String ending = randomChords(this.endingLength);

		return "V1 " + instrument + intro + verse + chorus + verse + chorus
				+ bridge + chorus + ending;
	}

	private String chooseInstrument() {
		switch(r.nextInt(4)) {
			case 0:
				return "I4 ";
			case 1:
				return "I5 ";
			case 2:
				return "I29 ";
			case 3:
				return "I30 ";
			case 4:
				return "I27 ";
		}

		return "";
	}

	/**
	 * Generates a string representation of the song's melody.
	 */
	public String genMelody() {
		String intro = randomMelody(this.introLength);
		String verse = randomMelody(this.verseLength);
		String chorus = randomMelody(this.chorusLength);
		String bridge = randomMelody(this.bridgeLength);
		String ending = randomMelody(this.endingLength);

		return "V2 " + intro + verse + chorus + verse + chorus
				+ bridge + chorus + ending;
	}

	/**
	 * 
	 * @return
	 */
	private String randomBeat(int length) {
		return "";
	}

	/**
	 * 
	 * @return
	 */
	private String randomChords(int length) {
		String []chords = {};
		String cp = "";

		// Determine instrument
		switch(r.nextInt(4)) {
		
		}

		// Determine chord progression
		switch(this.chordNum) {
		case 4:
			switch(r.nextInt(6)) {
			case 0:
				// Don't Stop Believing
				chords = new String[]{"FIRST", "FIFTH", "SIXTH", "FOURTH"};
				break;
			case 1:
				// 50s
				chords = new String[]{"FIRST", "SIXTH", "FOURTH", "FIFTH"};
				break;
			case 2:
				chords = new String[]{"SECOND", "FOURTH", "FIFTH", "FIFTH"};
				break;
			case 3:
				chords = new String[]{"FIRST", "FOURTH", "FIFTH", "FOURTH"};
				break;
			case 4:
				chords = new String[]{"FIFTH", "FOURTH", "FIRST", "FIRST"};
				break;
			case 5:
				// Alt on Don't Stop Believing
				chords = new String[]{"SIXTH", "FOURTH", "FIRST", "FIFTH"};
				break;
			case 6:
				// Decending Flamenco
				chords = new String[]{"SIXTH", "FIFTH", "FOURTH", "FIFTH"};
			}

			break;
		case 8:
			// Canon
			chords = new String[]{"FIRST", "FIFTH", "SIXTH", "THIRD", "FOURTH", "FIRST", "FOURTH", "FIFTH"};
			break;
		case 12:
			// Blues
			chords = new String[]{"FIRST", "FIRST", "FIRST", "FIRST", "FOURTH", "FOURTH", "FIRST", "FIRST", "FIFTH", "FOURTH", "FIRST", "FIFTH"};
			break;
		}

		// Determine and write chords with strumming pattern
		// Note: chords change every half a measure
		switch(r.nextInt(5)) {
			case 0:
				// DUduduDUdudu
				cp = strum00(chords, length);
				break;
			case 1:
				// Half notes
				cp = strum01(chords, length);
				break;
			case 2:
				// Quarter notes
				cp = strum02(chords, length);
				break;
			case 3:
				// Eighth notes
				cp = strum03(chords, length);
				break;
			case 4:
				// DUDU-UDU
				cp = strum04(chords, length);
				break;
			case 5:
				// D-DU-UD-
				cp = strum05(chords, length);
				break;
		}

		return cp;
	}

	private String strum00(String []c, int length) {
		String s = "";
		// Counts number of sixteenths added so far
		int count = 0;
		// Length doubled since each chord only lasts half a measure
		length *= 2;

		// Loop for all measures
		while(count < length) {
			// Loop for each chord
			for(int i = 0; i < c.length; i++) {
				s += (c[i] + "i ");
				s += (c[i] + "i ");
				s += (c[i] + "s ");
				s += (c[i] + "s ");
				s += (c[i] + "s ");
				s += (c[i] + "s ");
				count++;
			}
		}
		
		return s;
	}

	private String strum01(String []c, int length) {
		String s = "";
		// Counts number of sixteenths added so far
		int count = 0;
		// Length doubled since each chord only lasts half a measure
		length *= 2;

		// Loop for all measures
		while(count < length) {
			// Loop for each chord
			for(int i = 0; i < c.length; i++) {
				s += (c[i] + "h ");
				count++;
			}
		}
		
		return s;
	}
	
	private String strum02(String []c, int length) {
		String s = "";
		// Counts number of sixteenths added so far
		int count = 0;
		// Length doubled since each chord only lasts half a measure
		length *= 2;

		// Loop for all measures
		while(count < length) {
			// Loop for each chord
			for(int i = 0; i < c.length; i++) {
				s += (c[i] + "q ");
				s += (c[i] + "q ");
				count++;
			}
		}
		
		return s;
	}
	
	private String strum03(String []c, int length) {
		String s = "";
		// Counts number of sixteenths added so far
		int count = 0;
		// Length doubled since each chord only lasts half a measure
		length *= 2;

		// Loop for all measures
		while(count < length) {
			// Loop for each chord
			for(int i = 0; i < c.length; i++) {
				s += (c[i] + "i ");
				s += (c[i] + "i ");
				s += (c[i] + "i ");
				s += (c[i] + "i ");
				count++;
			}
		}
		
		return s;
	}
	
	private String strum04(String []c, int length) {
		String s = "";
		// Counts number of sixteenths added so far
		int count = 0;
		// Length doubled since each chord only lasts half a measure
		length *= 2;

		// Loop for all measures
		while(count < length) {
			// Loop for each chord
			for(int i = 0; i < c.length; i++) {
				count++;
			}
		}
		
		return s;
	}
	
	private String strum05(String []c, int length) {
		String s = "";
		// Counts number of sixteenths added so far
		int count = 0;
		// Length doubled since each chord only lasts half a measure
		length *= 2;

		// Loop for all measures
		while(count < length) {
			// Loop for each chord
			for(int i = 0; i < c.length; i++) {
				s += (c[i] + "i ");
				s += ("R" + "i ");
				s += (c[i] + "i ");
				s += (c[i] + "i ");
				s += ("R" + "s ");
				s += (c[i] + "i ");
				s += (c[i] + "i ");
				s += ("R" + "i ");
				count++;
			}
		}
		
		return s;
	}

	/**
	 * 
	 */
	private String randomMelody(int length) {
		return "";
	}
}
