/** 
 * @author	Julian-Chris Reyes
 * JamGen	SoundSample
 * 
 * Creates a singleton that plays a major C chords with the instrument defined
 * by the argument in the constructor.
 */

import org.jfugue.player.Player;

public class SoundSample {
	final String []ALL_INSTRUMENTS =
		{"Piano", "Bright_Acoustic", "Electric_Grand", "Honkey_Tonk", "Electric_Piano", "Electric_Piano2", "Harpischord", "Clavinet",
		 "Celesta", "Glockenspiel", "Music_Box", "Vibraphone", "Marimba", "Xylophone", "Tubular_Bells", "Dulcimer",
		 "Drawbar_Organ", "Percussive_Organ", "Rock_Organ", "Church_Organ", "Reed_Organ", "Accordian", "Harmonica", "Tango_Accordian",
		 "Guitar", "Steel_String_Guitar", "Electric_Jazz_Guitar", "Electric_Clean_Guitar", "Electric_Muted_Guitar", "Overdriven_Guitar", "Distortion_Guitar", "Guitar_Harmonics",
		 "Acoustic_Bass", "Electric_Bass_Finger", "Electric_Bass_Pick", "Fretless_Bass", "Slap_Bass_1", "Slap_Bass_2", "Synth_Bass_1", "Synth_Bass_2",
		 "Violin", "Viola", "Cello", "Contrabass", "Tremelo_Strings", "Pizzicato_Strings", "Orchestral_Strings", "Timpani",
		 "String_ Ensemble_1", "String_Ensemble_2", "Synth_Strings_1", "Synth Strings_2", "Choir_Aahs", "Choir_Oohs", "Synth_Voice", "Orchestra_Hit",
		 "Trumpet", "Trombone", "Tuba", "Muted_Trumpet", "French_Horn", "Brass_Section", "Synthbrass_1", "Synthbrass_2",
		 "Soprano_Sax", "Alto_Sax", "Tenor_Sax", "Baritone_Sax", "Oboe", "English _Horn", "Bassoon", "Clarinet",
		 "Piccolo", "Flute", "Recorder", "Pan_Flute", "Blown_Bottle", "Shakuhachi", "Whistle", "Ocarina",
		 "Square", "Sawtooth", "Calliope", "Chiff", "Charang", "Voice", "Fifths", "Basslead",
		 "New_Age", "Warm", "Polysynth", "Choir", "Bowed", "Metallic", "Halo", "Sweep",
		 "Rain", "Soundtrack", "Crystal", "Atmosphere", "Brightness", "Goblins", "Echoes", "Sci-Fi",
		 "Sitar", "Banjo", "Shamisen", "Koto", "Kalimba", "Bagpipe", "Fiddle", "Shanai",
		 "Tinkle_Bell", "Agogo", "Steel_Drums", "WoodBlock", "Taiko_Drum", "Melodic_Tom", "Synth_Drum", "Reverse_Cymbal",
		 "Guitar_Fret_Noise", "Breath_Noise", "Seashore", "Bird_Tweet", "Telephone_Ring", "Helicoptor", "Applause", "Gunshot"};
	final Player player = new Player();
	final String sample = "60i 64i 67i 72i 67i 64i 60h";

	/**
	 * Constructor that creates a singleton, which plays a short arpeggio.
	 * 
	 * @param i		The instrument to be sampled.
	 */
	public SoundSample(int i) {
		String instrument = "I[" + ALL_INSTRUMENTS[i] + "] ";

		this.player.play(instrument + this.sample);
	}
}
