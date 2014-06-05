/**
 * @author	Julian-Chris Reyes
 * JamGen	Melody
 * 
 * Randomly generates a rhythm, and then randomly chooses tones for those notes.
 */

import java.util.Random;

public class Melody {
	final Random r = new Random();
	int key;

	/**
	 * Creates a melody based on a certain key.
	 * 
	 * @param key		Key of C starts at 60.
	 */
	public Melody(int key) {
		this.key = key;
	}

	/**
	 * Generates a string representation of the song's melody, given the length
	 * of each section.
	 */
	public String generate(int introLength, int verseLength, int chorusLength,
						   int bridgeLength, int endingLength, int key) {
		String intro = randomMelody(introLength);
		String verse = randomMelody(verseLength);
		String chorus = randomMelody(chorusLength);
		String bridge = randomMelody(bridgeLength);
		String ending = randomMelody(endingLength);

		return intro + verse + chorus + verse + chorus +
			   bridge + chorus + ending + "firstw ";
	}

	/**
	 * Creates the melody.
	 * 
	 * @param length		The length of the 
	 */
	private String randomMelody(int length) {
		// Shortest length of note is 1/16th
		length *= 16;
		int count = 0;
		String s = "";
		int prevInt = 0;
		int currInt = 1;
		int currTone = this.key + 60;
		int prevLength = 0;
		int currLength = 0;

		while(count < length) {
			prevLength = currLength;
			currLength = randomLength(prevLength);
			count += currLength;

			prevInt = currInt;
			currInt = randomTone(prevInt);
			currTone += closest(prevInt, currInt);

			if(currTone > 80)
				currTone -= 12;

			if(currTone < 40)
				currTone += 12;

			s += (currTone + convertLength(currLength));
		}

		if(count > length) {
			count -= currLength;
			s = truncateLength(s);
			
			for(int i = count; i < length; i++) {
				s += "s";
				count++;
			}
		}

		return s + " ";
	}

	/**
	 * Return music string with undefined length for last note.
	 * 
	 * @param s
	 * @return "12345. "
	 */
	private String truncateLength(String s) {
		int index = s.length() - 1;

		// Locate most previous note length.
		while(s.charAt(index) == ' ' || s.charAt(index) == '.') {
			index--;
		}

		return s.substring(0, index);
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

	/**
	 * 
	 */
	private int closest(int curr, int next){
		switch(curr) {
			case 1:
				switch(next) {
					case 2: return 2;
					case 3: return 4;
					case 4: return r.nextInt(3) == 0 ? -7 : 5;
					case 5: return r.nextInt(3) == 0 ? 7 : -5;
					case 6: return -3;
					case 7: return -1;
				}
			case 2:
				switch(next) {
					case 1: return -2;
					case 3:	return 2;
					case 4: return 3;
					case 5: return r.nextInt(3) == 0 ? -7 : 5;
					case 6: return r.nextInt(3) == 0 ? 7 : -5;
					case 7: return -3;
				}
			case 3:
				switch(next) {
					case 1: return -4;
					case 2: return -2;
					case 4: return 1;
					case 5: return 3;
					case 6: return r.nextInt(3) == 0 ? -7 : 5;
					case 7: return r.nextInt(3) == 0 ? 7 : -5;
				}
			case 4:
				switch(next) {
					case 1: return r.nextInt(3) == 0 ? 7 : -5;
					case 2: return -3;
					case 3: return -1;
					case 5: return 2;
					case 6: return 4;
					case 7: return r.nextInt(2) == 0 ? 6 : -6;
				}
			case 5:
				switch(next) {
					case 1: return r.nextInt(3) == 0 ? -7 : 5;
					case 2: return r.nextInt(3) == 0 ? 7 : -5;
					case 3: return -3;
					case 4: return -2;
					case 6: return 2;
					case 7: return 4;
				}
			case 6:
				switch(next) {
					case 1: return 3;
					case 2: return r.nextInt(3) == 0 ? -7 : 5;
					case 3: return r.nextInt(3) == 0 ? 7 : 5;
					case 4: return -4;
					case 5: return -2;
					case 7: return 2;
				}
			case 7:
				switch(next) {
					case 1: return 1;
					case 2: return 3;
					case 3: return r.nextInt(3) == 0 ? -7 : 5;
					case 4: return r.nextInt(2) == 0 ? 6 : -6;
					case 5: return -4;
					case 6: return -2;
				}
		}

		return 0;
	}
}
