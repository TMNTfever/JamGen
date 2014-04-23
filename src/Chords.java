/**
 * @author	Julian-Chris Reyes
 * JamGen	Chords
 * 
 * Randomly chooses a strumming pattern and chord progression.
 */

import java.util.Random;

public class Chords {
	final Random r = new Random();

	/**
	 * Generates a string representation of the song's chord pattern.
	 */
	public String generate(int introLength, int verseLength, int chorusLength,
			   			   int bridgeLength, int endingLength) {
		String intro = randomChords(introLength);
		String verse = randomChords(verseLength);
		String chorus = randomChords(chorusLength);
		String bridge = randomChords(bridgeLength);
		String ending = randomChords(endingLength);
	
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
		switch(r.nextInt(9)) {
			case 0:
				chords = new String[]{"FIRST", "FIFTH", "SIXTH", "FOURTH"};
				break;
			case 1:
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
				chords = new String[]{"SIXTH", "FOURTH", "FIRST", "FIFTH"};
				break;
			case 6:
				chords = new String[]{"SIXTH", "FIFTH", "FOURTH", "FIFTH"};
				break;
			case 7:
				chords = new String[]{"FIRST", "FIFTH", "SIXTH", "THIRD", "FOURTH", "FIRST", "FOURTH", "FIFTH"};
				break;
			case 8:
				chords = new String[]{"FIRST", "FIRST", "FIRST", "FIRST", "FOURTH", "FOURTH", "FIRST", "FIRST", "FIFTH", "FOURTH", "FIRST", "FIFTH"};
				break;
		}

		// Determine and write chords with strumming pattern
		// Note: chords change every half a measure
		switch(r.nextInt(11)) {
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
			case 9:
				cp = strum09(chords, length);
				break;
			case 10:
				cp = strum10(chords, length);
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

		// Loop for all measures
		while(count < length) {
			// Loop for each chord
			for(int i = 0; i < c.length; i++) {
				s += (c[i] + "i ");
				s += (c[i] + "i ");
				s += (c[i] + "i ");
				s += (c[i] + "i ");
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

	private String strum09(String []c, int length) {
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
				s += (c[i] + "s ");
				s += (c[i] + "s ");
				s += ("Ri ");
				s += (c[i] + "i ");
				count++;
			}
		}
		
		return s;
	}

	private String strum10(String []c, int length) {
		String s = "";
		// Counts number of sixteenths added so far
		int count = 0;

		// Loop for all measures
		while(count < length) {
			// Loop for each chord
			for(int i = 0; i < c.length; i++) {
				s += ("Ri ");
				s += (c[i] + "s ");
				s += (c[i] + "s ");
				s += ("Ri ");
				s += (c[i] + "i ");

				s += ("Ri ");
				s += (c[i] + "s ");
				s += (c[i] + "s ");
				s += ("Ri ");
				s += (c[i] + "i ");
				count++;
			}
		}
		
		return s;
	}
}
