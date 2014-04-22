/**
 * @author	Julian-Chris Reyes
 * JamGen	Melody
 * 
 * Randomly generates a rhythm, and then randomly chooses tones for those notes.
 */

import java.util.Random;

public class Melody {
	final Random r = new Random();

	/**
	 * Generates a string representation of the song's melody.
	 */
	public String generate(int introLength, int verseLength, int chorusLength,
						   int bridgeLength, int endingLength) {
		String intro = randomMelody(introLength);
		String verse = randomMelody(verseLength);
		String chorus = randomMelody(chorusLength);
		String bridge = randomMelody(bridgeLength);
		String ending = randomMelody(endingLength);

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
		int prevTone = 0;
		int currTone = 0;
		int prevLength = 0;
		int currLength = 0;

		// Randomize note duration
		while(count < length)
		{
			currTone = randomTone(prevTone);
			currLength = randomLength(prevLength);

			s += convertTone(currTone) + convertLength(currLength);

			count += currLength;

			prevTone = currTone;
			prevLength = currLength;
		}

		// Remove white space to tie 16ths
		s = s.substring(0, s.length() - 1);

		// Increase length to allow for leading tone
		length += 8;

		// Tie 16ths until whole note
		for(int i = count; i < length; i++) {
			s += "s";
			count++;
		}

		// Add white space after tied sixteenths
		s += " ";

		// Add leading tone for rest of the measure
		length += 8;
		s += leadingTone();

		for(int i = count; i < length; i++) {
			s += "s";
			count++;
		}

		return s + " ";
	}

	/**
	 * 
	 * @param previous
	 * @return
	 */
	private int randomLength(int previous) {
		switch(previous) {
			case 0:
				switch(r.nextInt(8)) {
					case 0: return 1;
					case 1:	return 2;
					case 2: return 3;
					case 3: return 4;
					case 4: return 6;
					case 5: return 8;
					case 6: return 12;
					case 7: return 16;
				}
			case 1:
				switch(r.nextInt(7)) {
					case 0: case 1: case 2 : case 3:
						return 1;
					case 4:
						return 8;
					case 5:
						return 12;
					case 6:
						return 16;
				}
			case 2:
				switch(r.nextInt(8)) {
					case 0: case 1: case 2: case 3:
						return 2;
					case 4:
						return 4;
					case 5:
						return 6;
					case 6:
						return 8;
					case 7:
						return 16;
			}
			case 3:
				return 1;
			case 4:
				switch(r.nextInt(10)) {
					case 0: case 1:
						return 2;
					case 2: case 3:
						return 4;
					case 4: case 5:
						return 3;
					case 6:
						return 4;
					case 7:
						return 8;
					case 8:
						return 12;
					case 9:
						return 16;
			}
			case 6:
				switch(r.nextInt(5)) {
					case 0: case 1: case 2: case 3:
						return 2;
					case 4:
						return 1;
			}
			case 8:
				switch(r.nextInt(8)) {
					case 0: case 1: case 2: case 3:
						return 8;
					case 4: case 5:
						return 4;
					case 6:
						return 16;
					case 7:
						return 2;
						
			}
			case 12:
				switch(r.nextInt(5)) {
					case 0: case 1: case 2: case 3:
						return 4;
					case 4:
						return 2;
			}
			case 16:
				switch(r.nextInt(8)) {
					case 0: return 1;
					case 1: return 2;
					case 2: return 3;
					case 3: return 4;
					case 4: return 6;
					case 5: return 8;
					case 6: return 12;
					case 7: return 16;
			}
		}

		return 0;
	}

	/**
	 * 
	 */
	private int randomTone(int previous) {
		switch(previous) {
			case 0:
				switch(r.nextInt(5)) {
					case 0: return 1;
					case 1: return 2;
					case 2: return 3;
					case 3: return 4;
					case 4: return 5;
				}
			case 1:
				switch(r.nextInt(4)) {
					case 0: return 2;
					case 1: return 3;
					case 2: return 4;
					case 3: return 5;
				}
			case 2:
				switch(r.nextInt(3)) {
					case 0: return 1;
					case 1: return 3;
					case 2: return 4;
				}
			case 3:
				switch(r.nextInt(4)) {
					case 0: return 1;
					case 1: return 2;
					case 2: return 4;
					case 3: return 5;
				}
			case 4:
				switch(r.nextInt(3)) {
					case 0: return 1;
					case 1: return 3;
					case 2: return 5;
				}
			case 5:
				switch(r.nextInt(4)) {
					case 0: return 1;
					case 1: return 3;
					case 2: return 4;
					case 3: return 6;
				}
			case 6:
				switch(r.nextInt(2)) {
					case 0: return 5;
					case 1: return 7;
				}
			case 7: return 1;
		}

		return 0;
	}

	/**
	 * 
	 */
	private String leadingTone() {
		switch(r.nextInt(4)) {
			case 0: return "second";
			case 1: return "fourth";
			case 2: return "fifth";
			case 3: return "seventh";
		}

		return "";
	}

	/**
	 * 
	 */
	private String convertTone(int i) {
		switch(i) {
			case 1: return "first";
			case 2: return "second";
			case 3: return "third";
			case 4: return "fourth";
			case 5: return "fifth";
			case 6: return "sixth";
			case 7: return "seventh";
		}

		return "";
	}

	/**
	 * 
	 */
	private String convertLength(int i) {
		switch(i) {
			case 1: return "s ";
			case 2: return "i ";
			case 3: return "i. ";
			case 4: return "q ";
			case 6: return "q. ";
			case 8: return "h ";
			case 12: return "h. ";
			case 16: return "w ";
		}

		return "";
	}
}
