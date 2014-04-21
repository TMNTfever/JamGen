import java.util.Random;

/**
 * @author	Julian-Chris Reyes
 * JamGen	Song
 * 
 */

public class Song {
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
		return "V9 " + genBeat() +
			   "V0 " + chordsInstr + genChords() +
			   "V1 " + melodyInstr + genMelody();
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

		return intro + verse + chorus + verse + chorus +
			   bridge + chorus + ending + "[crash_cymbal_1]w ";
	}

	/**
	 * 
	 * @return
	 */
	private String randomBeat(int length) {
		String s = "";

		switch(r.nextInt(5)) {
			case 0:
				s = drum00(length);
				break;
			case 1:
				s = drum01(length);
				break;
			case 2:
				s = drum02(length);
				break;
			case 3:
				s = drum03(length);
				break;
			case 4:
				s = drum04(length);
				break;
		}

		switch(r.nextInt(5)) {
			case 0:
				s += fill00();
				break;
			case 1:
				s += fill01();
				break;
			case 2:
				s += fill02();
				break;
			case 3:
				s += fill03();
				break;
			case 4:
				s += fill00();//s += fill04();
				break;
		}

		return s;
	}

	private String drum00(int length) {
		String s = "";
		// Remove one measure to have space for fill
		length -= 1;

		for(int i = 0; i < length; i++) {
			s += "[closed_hi_hat]i+[bass_drum]i ";
			s += "[closed_hi_hat]i+[bass_drum]i ";

			s += "[closed_hi_hat]i+[acoustic_snare]i ";
			s += "[closed_hi_hat]i+[bass_drum]i ";

			s += "[closed_hi_hat]i+[bass_drum]i ";
			s += "[closed_hi_hat]i+[bass_drum]i ";

			s += "[closed_hi_hat]i+[acoustic_snare]i ";
			s += "[closed_hi_hat]i ";
		}

		// 3/4th measure of beat and 1/4 of fill-in
		s += "[closed_hi_hat]i+[bass_drum]i ";
		s += "[closed_hi_hat]i+[bass_drum]i ";

		s += "[closed_hi_hat]i+[acoustic_snare]i ";
		s += "[closed_hi_hat]i+[bass_drum]i ";

		s += "[closed_hi_hat]i+[bass_drum]i ";
		s += "[closed_hi_hat]i+[bass_drum]i ";

		return s;
	}

	private String drum01(int length) {
		String s = "";
		// Remove one measure to have space for fill
		length -= 1;

		for(int i = 0; i < length; i++) {
			s += "[closed_hi_hat]i+[bass_drum]i ";
			s += "[open_hi_hat]i ";

			s += "[closed_hi_hat]i+[acoustic_snare]i ";
			s += "[open_hi_hat]i ";

			s += "[closed_hi_hat]i+[bass_drum]i ";
			s += "[open_hi_hat]i ";

			s += "[closed_hi_hat]i+[acoustic_snare]i ";
			s += "[open_hi_hat]i ";
		}

		// 3/4th measure of beat and 1/4 of fill-in
		s += "[open_hi_hat]i+[bass_drum]i ";
		s += "[open_hi_hat]i ";

		s += "[open_hi_hat]i+[acoustic_snare]i ";
		s += "[open_hi_hat]i ";

		s += "[open_hi_hat]i+[bass_drum]i ";
		s += "[open_hi_hat]i ";

		return s;
	}

	private String drum02(int length) {
		String s = "";
		// Remove one measure to have space for fill
		length -= 1;

		for(int i = 0; i < length; i++) {
			s += "[bass_drum]i ";
			s += "[acoustic_snare]s ";
			s += "[acoustic_snare]s ";
			s += "Rs ";
			s += "[bass_drum]s ";
			s += "[acoustic_snare]i ";

			s += "[bass_drum]i ";
			s += "[acoustic_snare]s ";
			s += "[acoustic_snare]s ";
			s += "Rs ";
			s += "[bass_drum]s ";
			s += "[acoustic_snare]i ";
		}

		// 3/4th measure of beat and 1/4 of fill-in
		s += "[bass_drum]i ";
		s += "[acoustic_snare]s ";
		s += "[acoustic_snare]s ";
		s += "Rs ";
		s += "[bass_drum]s ";
		s += "[acoustic_snare]i ";

		s += "[bass_drum]i ";
		s += "[acoustic_snare]s ";
		s += "[acoustic_snare]s ";

		return s;
	}

	private String drum03(int length) {
		String s = "";
		// Remove one measure to have space for fill
		length -= 1;

		for(int i = 0; i < length; i++) {
			s += "[bass_drum]q ";
			s += "[bass_drum]q ";
			s += "[bass_drum]q ";
			s += "[bass_drum]q ";
		}

		// 3/4th measure of beat and 1/4 of fill-in
		s += "[bass_drum]q ";
		s += "[bass_drum]q ";
		s += "[bass_drum]q ";

		return s;
	}

	private String drum04(int length) {
		String s = "";
		// Remove one measure to have space for fill
		length -= 1;

		for(int i = 0; i < length; i++) {
			s += "[closed_hi_hat]s+[bass_drum]s ";
			s += "[closed_hi_hat]s ";
			s += "[closed_hi_hat]s ";
			s += "[closed_hi_hat]s ";

			s += "[closed_hi_hat]s+[acoustic_snare]s ";
			s += "[closed_hi_hat]s ";
			s += "[closed_hi_hat]s ";
			s += "[closed_hi_hat]s+[acoustic_snare]s ";

			s += "[closed_hi_hat]s ";
			s += "[closed_hi_hat]s+[acoustic_snare]s ";
			s += "[closed_hi_hat]s ";
			s += "[open_hi_hat]s+[bass_drum]s ";

			s += "[closed_hi_hat]s+[acoustic_snare]s ";
			s += "[closed_hi_hat]s ";
			s += "[closed_hi_hat]s ";
			s += "[closed_hi_hat]s ";
		}

		// 3/4th measure of beat and 1/4 of fill-in

		return s;
	}

	private String fill00() {
		String s = "";

		s += "[high_tom]s* [high_tom]s* [high_tom]s* ";
		s += "[hi_mid_tom]s* [hi_mid_tom]s* [hi_mid_tom]s* ";
		s += "[low_mid_tom]s* [low_mid_tom]s* [low_mid_tom]s* ";
		s += "[low_tom]s* [low_tom]s* [low_tom]s* ";

		return s;
	}

	private String fill01() {
		String s = "";

		s += "[acoustic_snare]s ";
		s += "[acoustic_snare]s ";
		s += "[acoustic_snare]s ";
		s += "[acoustic_snare]s ";

		return s;
	}

	private String fill02() {
		return "[high_tom]q* [hi_mid_tom]q* [low_mid_tom]q* ";
	}

	private String fill03() {
		String s = "";

		s += "[high_tom]s+[crash_cymbal_1]s ";
		s += "[hi_mid_tom]s ";
		s += "[low_mid_tom]s ";
		s += "[low_tom]s+[crash_cymbal_2]s ";

		return s;
	}

	/**
	 * Generates a string representation of the song's chord pattern.
	 */
	public String genChords() {
		String intro = randomChords(this.introLength);
		String verse = randomChords(this.verseLength);
		String chorus = randomChords(this.chorusLength);
		String bridge = randomChords(this.bridgeLength);
		String ending = randomChords(this.endingLength);
	
		return intro + verse + chorus + verse + chorus +
			   bridge + chorus + ending + "FIRSTw ";
	}

	/**
	 * 
	 * @return
	 */
	private String randomChords(int length) {
		String []chords = {};
		// Return string "chords in pattern"
		String cp = "";

		// Determine chord progression

		switch(r.nextInt(7)) {
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
			break;
		case 7:
			// Canon
			chords = new String[]{"FIRST", "FIFTH", "SIXTH", "THIRD", "FOURTH", "FIRST", "FOURTH", "FIFTH"};
			break;
		case 8:
			// Blues
			chords = new String[]{"FIRST", "FIRST", "FIRST", "FIRST", "FOURTH", "FOURTH", "FIRST", "FIRST", "FIFTH", "FOURTH", "FIRST", "FIFTH"};
			break;
		}

		// Determine and write chords with strumming pattern
		// Note: chords change every half a measure
		switch(r.nextInt(9)) {
			case 0:
				cp = strum00(chords, length);
				break;
			case 1:
				cp = strum01(chords, length);
				break;
			case 2:
				cp = strum02(chords, length);
				break;
			case 3:
				cp = strum03(chords, length);
				break;
			case 4:
				cp = strum04(chords, length);
				break;
			case 5:
				cp = strum05(chords, length);
				break;
			case 6:
				cp = strum06(chords, length);
				break;
			case 7:
				cp = strum07(chords, length);
				break;
			case 8:
				cp = strum08(chords, length);
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
				s += ("Ri ");
				s += (c[i] + "i ");
				s += ("Ri ");
				s += (c[i] + "i ");
				count++;
			}
		}
		
		return s;
	}

	private String strum01(String []c, int length) {
		String s = "";
		// Counts number of sixteenths added so far
		int count = 0;

		// Loop for all measures
		while(count < length) {
			// Loop for each chord
			for(int i = 0; i < c.length; i++) {
				s += ("Ri ");
				s += (c[i] + "i ");
				s += ("Ri ");
				s += (c[i] + "i ");
				s += ("Ri ");
				s += (c[i] + "i ");
				s += ("Ri ");
				s += (c[i] + "i ");
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
				s += (c[i] + "h ");
				count++;
			}
		}
		
		return s;
	}

	private String strum03(String []c, int length) {
		String s = "";
		// Counts number of sixteenths added so far
		int count = 0;

		// Loop for all measures
		while(count < length) {
			// Loop for each chord
			for(int i = 0; i < c.length; i++) {
				s += (c[i] + "w ");
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
				s += (c[i] + "q ");
				s += (c[i] + "q ");
				count++;
			}
		}
		
		return s;
	}

	private String strum05(String []c, int length) {
		String s = "";
		// Counts number of sixteenths added so far
		int count = 0;

		// Loop for all measures
		while(count < length) {
			// Loop for each chord
			for(int i = 0; i < c.length; i++) {
				s += (c[i] + "q ");
				s += (c[i] + "q ");
				s += (c[i] + "q ");
				s += (c[i] + "q ");
				count++;
			}
		}
		
		return s;
	}

	private String strum06(String []c, int length) {
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
	
	private String strum07(String []c, int length) {
		String s = "";
		// Counts number of sixteenths added so far
		int count = 0;

		// Loop for all measures
		while(count < length) {
			// Loop for each chord
			for(int i = 0; i < c.length; i++) {
				s += (c[i] + "i ");
				s += (c[i] + "i ");
				s += (c[i] + "i ");
				s += (c[i] + "i ");
				s += ("Ri ");
				s += (c[i] + "i ");
				s += (c[i] + "i ");
				s += ("Ri ");
				count++;
			}
		}
		
		return s;
	}
	
	private String strum08(String []c, int length) {
		String s = "";
		// Counts number of sixteenths added so far
		int count = 0;

		// Loop for all measures
		while(count < length) {
			// Loop for each chord
			for(int i = 0; i < c.length; i++) {
				s += (c[i] + "i ");
				s += ("Ri ");
				s += (c[i] + "i ");
				s += (c[i] + "i ");
				s += ("Ri ");
				s += (c[i] + "i ");
				s += (c[i] + "i ");
				s += ("Ri ");
				count++;
			}
		}
		
		return s;
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

		return intro + verse + chorus + verse + chorus +
			   bridge + chorus + ending + "firstw ";
	}

	/**
	 * 
	 */
	private String randomMelody(int length) {
		// Shortest length of note is 1/16th
		// Leave one measure for whole note
		length *= 16;
		length -= 16;
		int count = 0;
		String s = "";
		int previous = 0;
		int current = 0;

		while(count < length)
		{
			current = randomNote(previous);

			switch(r.nextInt(37)) {
				case 0:
					s += convert(current) + "w ";
					count += 16;
					break;
				case 1: case 2:
					s += convert(current) + "h. ";
					count += 12;
					break;
				case 3: case 4:
					s += convert(current) + "h ";
					count += 8;
					break;
				case 5: case 6: case 7: case 8:
					s += convert(current) + "q. ";
					count += 6;
					break;
				case 9: case 10: case 11: case 12:
					s += convert(current) + "q ";
					count += 4;
					break;
				case 13: case 14: case 15: case 16:
				case 17: case 18: case 19: case 20:
					s += convert(current) + "i. ";
					count += 3;
					break;
				case 21: case 22: case 23: case 24:
				case 25: case 26: case 27: case 28:
					s += convert(current) + "i ";
					count += 2;
					break;
				case 29: case 30: case 31: case 32:
				case 33: case 34: case 35: case 36:
					s += convert(current) + "s ";
					count += 1;
					break;
			}

			previous = current;
		}

		// Tie 16ths until whole note
		for(int i = count; i < length; i++) {
			s += "s";
		}

		// Add whole note
		s += leadingTone() + "w ";

		return s;
	}
	
	/**
	 * 
	 */
	private int randomNote(int previous) {
		switch(previous) {
			case 0:
				switch(r.nextInt(6)) {
					case 0:
						return 0;
					case 1:
						return 1;
					case 2:
						return 2;
					case 3:
						return 3;
					case 4:
						return 4;
					case 5:
						return 5;
				}
				return 1;
			case 1:
				switch(r.nextInt(5)) {
					case 0:
						return 0;
					case 1:
						return 2;
					case 2:
						return 3;
					case 3:
						return 4;
					case 4:
						return 5;
				}
			case 2:
				switch(r.nextInt(3)) {
					case 0:
						return 1;
					case 1:
						return 3;
					case 2:
						return 4;
				}
			case 3:
				switch(r.nextInt(5)) {
					case 0:
						return 0;
					case 1:
						return 1;
					case 2:
						return 2;
					case 3:
						return 4;
					case 4:
						return 5;
				}
			case 4:
				switch(r.nextInt(3)) {
					case 0:
						return 1;
					case 1:
						return 3;
					case 2:
						return 5;
				}
			case 5:
				switch(r.nextInt(5)) {
					case 0:
						return 0;
					case 1:
						return 1;
					case 2:
						return 3;
					case 3:
						return 4;
					case 4:
						return 6;
				}
			case 6:
				switch(r.nextInt(2)) {
					case 0:
						return 5;
					case 1:
						return 7;
				}
			case 7:
				return 1;
		}

		return 0;
	}
	
	/**
	 * 
	 */
	private String leadingTone() {
		switch(r.nextInt(4)) {
			case 0:
				return "second";
			case 1:
				return "fourth";
			case 2:
				return "fifth";
			case 3:
				return "seventh";
		}

		return "";
	}

	/**
	 * 
	 */
	private String convert(int i) {
		switch(i) {
			case 0:
				return "rest";
			case 1:
				return "first";
			case 2:
				return "second";
			case 3:
				return "third";
			case 4:
				return "fourth";
			case 5:
				return "fifth";
			case 6:
				return "sixth";
			case 7:
				return "seventh";
		}

		return "";
	}
}
