/**
 * @author	Julian-Chris Reyes
 * JamGen	Beat
 * 
 * Randomly chooses a drumming pattern as well as a fill-in.
 */

import java.util.Random;

public class Beat {
	final Random r = new Random();
	String bass;
	String snare;
	String openHiHat;
	String closedHiHat;
	String hiTom;
	String hiMidTom;
	String loMidTom;
	String loTom;
	String cymbal;

	/**
	 * Generates a string representation of the song's rhythm track.
	 */
	public String generate(int introLength, int verseLength, int chorusLength,
			   			   int bridgeLength, int endingLength, int percusInstr) {
		setInstruments(percusInstr);
		String intro = randomBeat(introLength);
		String verse = randomBeat(verseLength);
		String chorus = randomBeat(chorusLength);
		String bridge = randomBeat(bridgeLength);
		String ending = randomBeat(endingLength);

		return intro + verse + chorus + verse + chorus +
			   bridge + chorus + ending + this.cymbal + "w ";
	}

	/**
	 * Sets the instruments for chosen style. 
	 * 
	 * @param percusInstr
	 */
	public void setInstruments(int percusInstr) {
		switch(percusInstr) {
			case 0: // Rock
				this.bass = "[acoustic_bass_drum]";
				this.snare = "[acoustic_snare]";
				this.openHiHat = "[open_hi_hat]";
				this.closedHiHat = "[closed_hi_hat]";
				this.hiTom = "[hi_tom]";
				this.hiMidTom = "[hi_mid_tom]";
				this.loMidTom = "[lo_mid_tom]";
				this.loTom = "[lo_tom]";
				this.cymbal = "[crash_cymbal_2]";
				break;
			case 1: // Hip-Hop
				this.bass = "[bass_drum]";
				this.snare = "[electric_snare]";
				this.openHiHat = "[open_hi_hat]";
				this.closedHiHat = "[closed_hi_hat]";
				this.hiTom = "[lo_mid_tom]";
				this.hiMidTom = "[lo_tom]";
				this.loMidTom = "[hi_floor_tom]";
				this.loTom = "[lo_floor_tom]";
				this.cymbal = "[ride_cymbal_1]";
				break;
			case 2: // Electric
				this.bass = "[open_cuica]";
				this.snare = "[vibraslap]";
				this.openHiHat = "[hi_wood_block]";
				this.closedHiHat = "[lo_wood_block]";
				this.hiTom = "[electric_snare]";
				this.hiMidTom = "[electric_snare]";
				this.loMidTom = "[electric_snare]";
				this.loTom = "electric_snare[]";
				this.cymbal = "[long_whistle]";
				break;
			case 3: // Ethnics
				this.bass = "[open_cuica]";
				this.snare = "[claves]";
				this.openHiHat = "[maracas]";
				this.closedHiHat = "[cabasa]";
				this.hiTom = "[hi_timbale]";
				this.hiMidTom = "[lo_timbale]";
				this.loMidTom = "[hi_bongo]";
				this.loTom = "[lo_bongo]";
				this.cymbal = "[ride_bell]";
				break;
		}
	}

	/**
	 * Chooses a random beat.
	 * 
	 * @param length	The number of measures to loop for.
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
				s += fill04();
				break;
		}

		return s;
	}

	private String drum00(int length) {
		String s = "";
		length --;

		for(int i = 0; i < length; i++) {
			s += this.closedHiHat + "i+" + this.bass + "i ";
			s += this.closedHiHat + "i+" + this.bass + "i ";

			s += this.closedHiHat + "i+" + this.snare + "i ";
			s += this.closedHiHat + "i+" + this.bass + "i ";

			s += this.closedHiHat + "i+" + this.bass + "i ";
			s += this.closedHiHat + "i+" + this.bass + "i ";

			s += this.closedHiHat + "i+" + this.snare + "i ";
			s += this.closedHiHat + "i ";
		}

		// 3/4th measure of beat and 1/4 of fill-in
		s += this.closedHiHat + "i+" + this.bass + "i ";
		s += this.closedHiHat + "i+" + this.bass + "i ";

		s += this.closedHiHat + "i+" + this.snare + "i ";
		s += this.closedHiHat + "i+" + this.bass + "i ";

		s += this.closedHiHat + "i+" + this.bass + "i ";
		s += this.closedHiHat + "i+" + this.bass + "i ";

		return s;
	}

	private String drum01(int length) {
		String s = "";
		length --;

		for(int i = 0; i < length; i++) {
			s += this.closedHiHat + "i+" + this.bass + "i ";
			s += this.openHiHat + "i ";

			s += this.closedHiHat + "i+" + this.snare + "i ";
			s += this.openHiHat + "i ";

			s += this.closedHiHat + "i+" + this.bass + "i ";
			s += this.openHiHat + "i ";

			s += this.closedHiHat + "i+" + this.snare + "i ";
			s += this.openHiHat + "i ";
		}

		// 3/4th measure of beat and 1/4 of fill-in
		s += this.closedHiHat + "i+" + this.bass + "i ";
		s += this.openHiHat + "i ";

		s += this.closedHiHat + "i+" + this.snare + "i ";
		s += this.openHiHat + "i ";

		s += this.closedHiHat + "i+" + this.bass + "i ";
		s += this.openHiHat + "i ";

		return s;
	}

	private String drum02(int length) {
		String s = "";
		length --;

		for(int i = 0; i < length; i++) {
			s += this.bass + "i ";
			s += this.snare + "s ";
			s += this.snare + "s ";
			s += "Rs ";
			s += this.bass + "s ";
			s += this.snare + "i ";

			s += this.bass + "i ";
			s += this.snare + "s ";
			s += this.snare + "s ";
			s += "Rs ";
			s += this.bass + "s ";
			s += this.snare + "i ";
		}

		// 3/4th measure of beat and 1/4 of fill-in
		s += this.bass + "i ";
		s += this.snare + "s ";
		s += this.snare + "s ";
		s += "Rs ";
		s += this.bass + "s ";
		s += this.snare + "i ";

		s += this.bass + "i ";
		s += this.snare + "s ";
		s += this.snare + "s ";

		return s;
	}

	private String drum03(int length) {
		String s = "";
		length --;

		for(int i = 0; i < length; i++) {
			s += this.bass + "q ";
			s += this.bass + "q ";
			s += this.bass + "q ";
			s += this.bass + "q ";
		}

		// 3/4th measure of beat and 1/4 of fill-in
		s += this.bass + "q ";
		s += this.bass + "q ";
		s += this.bass + "q ";

		return s;
	}

	private String drum04(int length) {
		String s = "";
		length --;

		for(int i = 0; i < length; i++) {
			s += this.closedHiHat + "s+" + this.bass + "s ";
			s += this.closedHiHat + "s ";
			s += this.closedHiHat + "s ";
			s += this.closedHiHat + "s ";

			s += this.closedHiHat + "s+" + this.snare + "s ";
			s += this.closedHiHat + "s ";
			s += this.closedHiHat + "s ";
			s += this.closedHiHat + "s+" + this.snare + "s ";

			s += this.closedHiHat + "s ";
			s += this.closedHiHat + "s+" + this.snare + "s ";
			s += this.closedHiHat + "s ";
			s += this.openHiHat + "s+" + this.bass + "s ";

			s += this.closedHiHat + "s+" + this.snare + "s ";
			s += this.closedHiHat + "s ";
			s += this.closedHiHat + "s ";
			s += this.closedHiHat + "s ";
		}

		// 3/4th measure of beat and 1/4 of fill-in
		s += this.closedHiHat + "s+" + this.bass + "s ";
		s += this.closedHiHat + "s ";
		s += this.closedHiHat + "s ";
		s += this.closedHiHat + "s ";

		s += this.closedHiHat + "s+" + this.snare + "s ";
		s += this.closedHiHat + "s ";
		s += this.closedHiHat + "s ";
		s += this.closedHiHat + "s+" + this.snare + "s ";

		s += this.closedHiHat + "s ";
		s += this.closedHiHat + "s+" + this.snare + "s ";
		s += this.closedHiHat + "s ";
		s += this.openHiHat + "s+" + this.bass + "s ";

		return s;
	}

	private String fill00() {
		String s = "";

		s += this.hiTom + "t* " + this.hiTom + "t* " + this.hiTom + "t* ";
		s += this.hiMidTom + "t* " + this.hiMidTom + "t* " + this.hiMidTom + "t* ";
		s += this.loMidTom + "t* " + this.loMidTom + "t* " + this.loMidTom + "t* ";
		s += this.loTom + "t* " + this.loTom + "t* " + this.loTom + "t* ";

		return s;
	}

	private String fill01() {
		String s = "";

		s += this.snare + "s ";
		s += this.snare + "s ";
		s += this.snare + "s ";
		s += this.snare + "s ";

		return s;
	}

	private String fill02() {
		return this.hiTom + "i* " + this.hiMidTom + "i* " + this.loTom + "i* ";
	}

	private String fill03() {
		String s = "";

		s += "[hi_tom]s+[crash_cymbal_1]s ";
		s += "[hi_mid_tom]s ";
		s += "[lo_mid_tom]s ";
		s += "[lo_tom]s+[crash_cymbal_2]s ";

		s += this.hiTom + "s+" + this.cymbal + "s ";
		s += this.hiMidTom + "s ";
		s += this.loMidTom + "s ";
		s += this.loTom + "s+" + this.cymbal + "s ";
		return s;
	}

	private String fill04() {
		String s = "";

		s += this.hiTom + "s ";
		s += this.hiTom + "s ";
		s += this.hiMidTom + "s ";
		s += this.hiMidTom + "s ";

		return s;
	}
}
