/**
 * @author	Julian-Chris Reyes
 * JamGen
 * 
 * Creates and displays the GUI.
 */

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.sound.midi.InvalidMidiDataException;
import javax.sound.midi.MidiUnavailableException;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.SwingConstants;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class JamGen {
	final String [] ALL_INSTRUMENTS =
		{"000 Acoustic Grand Piano", "001 Bright Acoustic", "002 Electric Grand Piano", "003 Honkey Tonk", "004 Electric Piano 1", "005 Electric Piano 2", "006 HarpsiChord", "007 Clavinet",
		 "008 Celesta", "009 Glockenspiel", "010 Music Box", "011 Vibraphone", "012 Marimba", "013 Xylophone", "014 Tubular Bells", "015 Dulcimer",
		 "016 Drawbar Organ", "017 Percussive Organ", "018 Rock Organ", "019 Church Organ", "020 Reed Organ", "021 Accordian", "022 Harmonica", "023 Tango Accordian",
		 "024 Nylon String Guitar", "025 Steel String Guitar", "026 Electric Jazz Guitar", "027 Electric Clean Guitar", "028 Electric Muted Guitar", "029 Overdriven Guitar", "030 Distortian Guitar", "031 Guitar Harmonics",
		 "032 Acoustic Bass", "033 Electric Fingered Bass", "034 Electric Picked Bass", "035 Fretless Bass", "036 Slap Bass 1", "037 Slap Bass 2", "038 Synth Bass 1", "039 Synth Bass 2",
		 "040 Violin", "041 Viola", "042 Cello", "043 Contrabass", "044 Tremelo Strings", "045 Pizzicato Strings", "046 Orchestral Strings", "047 Timpani",
		 "048 String Ensemble 1", "049 String Ensemble 2", "050 Synth Strings 1", "051 Synth Strings 2", "052 Choir Ahs", "053 Choir Oos", "054 Synth Voice", "055 Orchestra Hit",
		 "056 Trumpet", "057 Trombone", "058 Tuba", "059 Muted Trumpet", "060 French Horn", "061 Brass Section", "062 Synth Brass 1", "063 Synth Brass 2",
		 "064 Soprano Saxophone", "065 Alto Saxophone", "066 Tenor Saxophone", "067 Baritone Saxophone", "068 Oboe", "069 English Horn", "070 Bassoon", "071 Clarinet",
		 "072 Piccolo", "073 Flute", "074 Recorder", "075 Pan Flute", "076 Blow Bottle", "077 Shakuhachi", "078 Whistle", "079 Ocarina",
		 "080 Square", "081 Sawtooth", "082 Calliope", "083 Chiff", "084 Charang", "085 Voices", "086 Fifths", "087 Basslead",
		 "088 New Age", "089 Warm", "090 Polysynth", "091 Choir", "092 Bowed", "093 Metallic", "094 Halo", "095 Sweep",
		 "096 Rain", "097 Soundtrack", "098 Crystal", " 099 Atmosphere", "100 Brightness", "101 Goblin Darts", "102 Echoes", "103 Sci-Fi",
		 "104 Sitar", "105 Banjo", "106 Shamisen", "107 Koto", "108 Kalimba", "109 Bagpipe", "110 Fiddle", "111 Shanai",
		 "112 Tinkle Bell", "113 Agogo", "114 Steel Drums", "115 Wood Block", "116 Taiko Drum", "117 Melodic Tom", "118 Synth Drum", "119 Reverse Cymbal",
		 "120 Guitar Fret Noise", "121 Breath Noise", "122 Seashore", "123 Bird Chirp", "124 Telephone Ring", "125 Helicoptor", "126 Applause", "127 Gunshot"};
	static boolean playing;

	public void displayGUI() {
		// Song to be generated, played, and exported
		final SongGenerator songGen = new SongGenerator();

		// FRAME
		JFrame frame = new JFrame("JamGen");
		frame.setVisible(true);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// COMPONENT INITIALIZATION

		// Action buttons
		final JButton gen = new JButton("Generate");
		final JButton export = new JButton("Export");
		final JButton play = new JButton("Play");
		final JButton stop = new JButton("Stop");
		export.setEnabled(false);
		play.setEnabled(false);
		stop.setEnabled(false);

		gen.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				songGen.generate();
				export.setEnabled(true);
				play.setEnabled(true);
			}
		});

		export.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				songGen.export();
			}
		});

		play.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					songGen.play();
				} catch (InvalidMidiDataException e1) {
					e1.printStackTrace();
				} catch (MidiUnavailableException e1) {
					e1.printStackTrace();
				}

				play.setEnabled(false);
				stop.setEnabled(true);
			}
		});

		stop.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				songGen.stop();

				play.setEnabled(true);
				stop.setEnabled(false);
			}
		});

		// Instruments
		final JLabel melodyLabel = new JLabel("Melody", SwingConstants.CENTER);
		final JLabel chordsLabel = new JLabel("Chords", SwingConstants.CENTER);
		String []melodyVals = ALL_INSTRUMENTS.clone();
		String []chordsVals = ALL_INSTRUMENTS.clone();
		final JComboBox<String> melody = new JComboBox<String>(melodyVals);
		final JComboBox<String> chords = new JComboBox<String>(chordsVals);

		melody.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				songGen.setMelodyInstrument(melody.getSelectedIndex());
			}
		});

		chords.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				songGen.setChordsInstrument(chords.getSelectedIndex());
			}
		});

	    // Key
	    final JLabel keyLabel = new JLabel("Key", SwingConstants.CENTER);
		String []keyVals = {"A", "A# / Bb", "B", "C", "C# / Db", "D",
				            "D# / Eb", "E", "F", "F# / Gb", "G", "G# / Ab"};
		final JComboBox<String> key = new JComboBox<String>(keyVals);

		key.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				songGen.setKey(key.getSelectedIndex());
			}
		});

		// Tempo
		final JLabel tempoLabel = new JLabel("BPM", SwingConstants.CENTER);
		final SpinnerNumberModel m1 = new SpinnerNumberModel(90, 40, 220, 5);
		final JSpinner tempo = new JSpinner(m1);

		m1.addChangeListener(new ChangeListener() {
			@Override
			public void stateChanged(ChangeEvent e) {
				songGen.setTempo((int)tempo.getValue());
			}
		});

		// PANELS & LAYOUT
		JPanel buttons = new JPanel(new GridLayout(2, 2));
		JPanel instruments = new JPanel(new GridLayout(2, 2));
		JPanel details = new JPanel(new GridLayout(2, 2));
		buttons.setBorder(BorderFactory.createTitledBorder("Actions"));
		instruments.setBorder(BorderFactory.createTitledBorder("Instruments"));
		details.setBorder(BorderFactory.createTitledBorder("Song Details"));

		// Add buttons
		buttons.add(gen);
		buttons.add(export);
		buttons.add(play);
		buttons.add(stop);

		// Add instruments
		instruments.add(melodyLabel);
		instruments.add(melody);
		instruments.add(chordsLabel);
		instruments.add(chords);

		// Add key and tempo
		details.add(keyLabel);
		details.add(key);
		details.add(tempoLabel);
		details.add(tempo);

		// Display GUI
		frame.add(buttons, BorderLayout.NORTH);
		frame.add(instruments, BorderLayout.CENTER);
		frame.add(details, BorderLayout.SOUTH);
		frame.pack();
		frame.setLocationRelativeTo(null);
	}

	/**
	 * Dumps temp files in directory: JamGen/temp before program exits.
	 */
	public void attachShutDownHook() {
		Runtime.getRuntime().addShutdownHook(new Thread() {
			@Override
			public void run() {
				dumpTemp();
			}
		});
	}

	/**
	 * Recursively deletes all temp files created by SongGenerator. 
	 */
	public void dumpTemp() {
		File index = new File("temp");
		String []files = index.list();

		for(String s: files) {
			File currentFile = new File(index.getPath(), s);
			currentFile.delete();
		}
	}

	/**
	 * Main method
	 * 
	 * @param args		Command-line arguments
	 */
	public static void main(String []args) {
		JamGen jg = new JamGen();
		jg.attachShutDownHook();
		jg.displayGUI();
	}
}