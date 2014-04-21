/**
 * @author	Julian-Chris Reyes
 * JamGen
 * 
 * Creates a basic song with the following structure: intro, verse 1, chorus,
 * verse 2, chorus, bridge, chorus, ending. Takes in account music theory to
 * generate different genres of music. All songs are in 4/4 time-signature.
 */

import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class JamGen {
	SongGenerator songGen; // Song to be generated, played, and exported

	/**
	 * Empty constructor instantiates the song.
	 */
	public JamGen() {
		this.songGen = new SongGenerator();
	}

	/**
	 * Creates the JamGen GUI.
	 */
	public void createGUI() {
		// FRAME
		JFrame frame = new JFrame("JamGen");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// COMPONENT INITIALIZATION

		// Action buttons
		final JButton gen = new JButton("Generate");
		final JButton export = new JButton("Export");
		final JButton play = new JButton("Play");
		final JButton stop = new JButton("Stop");

		gen.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				songGen.generate();
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
				songGen.play();
			}
		});

		stop.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				//songGen.stop();
			}
		});

		// Instruments
		final JLabel melodyLabel = new JLabel("Melody");
		final JLabel chordsLabel = new JLabel("Chords");
		String []melodyVals = {"Piano", "Guitar", "Electric Piano", "Jazz Guitar",
							   "Violin", "Choir", "Trumpet", "French Horn",
							   "Saxophone", "Clarinet", "Flute", "Square"};
		String []chordsVals = {"Guitar", "Piano", "Organ", "Strings"};
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
	    final JLabel keyLabel = new JLabel("Key");
		String []keyVals = {"A", "A# / Bb", "B", "C", "C# / Db", "D",
				            "D# / Eb", "E", "F", "F# / Gb", "G", "G# / Ab"};
		final JComboBox<String> key = new JComboBox<String>(keyVals);
		final JRadioButton major = new JRadioButton("Major");
		final JRadioButton minor = new JRadioButton("Minor");
		ButtonGroup scaleGroup = new ButtonGroup();
		scaleGroup.add(major);
		scaleGroup.add(minor);

		key.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				songGen.setKey(key.getSelectedIndex());
			}
		});

		// Rhythm
		final JLabel tempoLabel = new JLabel("BPM");
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
		JPanel instruments = new JPanel(new GridLayout(3, 2));
		JPanel details = new JPanel(new GridBagLayout());
		buttons.setBorder(BorderFactory.createTitledBorder("Actions"));
		instruments.setBorder(BorderFactory.createTitledBorder("Instruments"));
		details.setBorder(BorderFactory.createTitledBorder("Song Details"));
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.insets = new Insets(5, 5, 5, 5);

		// Add buttons
		buttons.add(gen);
		buttons.add(export);
		buttons.add(play);
		buttons.add(stop);

		// Add instruments
		gbc.gridx = 0;
		gbc.gridy = 0;
		instruments.add(melodyLabel, gbc);
		gbc.gridx = 1;
		gbc.gridy = 0;
		instruments.add(melody, gbc);
		gbc.gridx = 0;
		gbc.gridy = 1;
		instruments.add(chordsLabel, gbc);
		gbc.gridx = 1;
		gbc.gridy = 1;
		instruments.add(chords, gbc);

		// Add key and tempo
		gbc.gridx = 0;
		gbc.gridy = 0;
		details.add(keyLabel, gbc);
		gbc.gridx = 1;
		gbc.gridy = 0;
		details.add(key, gbc);

		gbc.gridx = 0;
		gbc.gridy = 1;
		details.add(tempoLabel, gbc);
		gbc.gridx = 1;
		gbc.gridy = 1;
		details.add(tempo, gbc);

		// FRAME COMPLETE
		frame.add(buttons, BorderLayout.NORTH);
		frame.add(instruments, BorderLayout.CENTER);
		frame.add(details, BorderLayout.SOUTH);
		frame.pack();
		frame.setVisible(true);
	}

	/**
	 * Runs the program
	 * @param args
	 */
	public static void main(String []args) {
		JamGen jg = new JamGen();
		jg.createGUI();
	}
}