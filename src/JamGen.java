/**
 * @author	Julian-Chris Reyes
 * JamGen
 * 
 * Creates a basic song with the following structure: intro, verse 1, chorus,
 * verse 2, chorus, bridge, chorus, ending. Takes in account music theory to
 * generate different genres of music. All songs are in 4/4 time-signature.
 */

import java.awt.BorderLayout;
import java.awt.GridLayout;
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
	public static void main(String []args) {
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
		play.setEnabled(false);

		gen.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				songGen.generate();
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
	}
}