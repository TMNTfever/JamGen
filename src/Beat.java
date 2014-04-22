/**
 * @author	Julian-Chris Reyes
 * JamGen	Beat
 * 
 */

import java.util.Random;

public class Beat {
	final Random r = new Random();

	/**
	 * Generates a string representation of the song's rhythm track.
	 */
	public String generate(int introLength, int verseLength, int chorusLength,
			   			   int bridgeLength, int endingLength) {
		String intro = randomBeat(introLength);
		String verse = randomBeat(verseLength);
		String chorus = randomBeat(chorusLength);
		String bridge = randomBeat(bridgeLength);
		String ending = randomBeat(endingLength);

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
}
