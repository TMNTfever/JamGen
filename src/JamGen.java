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

		// COMPONENTS
		
		// Action buttons
		final JButton gen = new JButton("Generate");
		final JButton play = new JButton("Play");
		final JButton export = new JButton("Export");

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

		// Genre buttons
		final JRadioButton reggae = new JRadioButton("Reggae");
		final JRadioButton rock = new JRadioButton("Rock");
	    ButtonGroup genreGroup = new ButtonGroup();
	    genreGroup.add(reggae);
	    genreGroup.add(rock);

	    reggae.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(reggae.isSelected())
					songGen.setGenre(0);
			}
		});
	    
	    rock.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(rock.isSelected())
					songGen.setGenre(1);
			}
		});

	    // Key
	    JLabel keyLabel = new JLabel("Key");
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
		final SpinnerNumberModel model = new SpinnerNumberModel(120, 40, 220, 5);
		final JSpinner tempo = new JSpinner(model);

		model.addChangeListener(new ChangeListener() {
			@Override
			public void stateChanged(ChangeEvent e) {
				songGen.setTempo((int)tempo.getValue());
			}
		});

		// PANELS & LAYOUT
		JPanel buttons = new JPanel(new GridLayout(2, 2));
		JPanel genre = new JPanel(new GridLayout(0, 3)); // Infinite rows
		JPanel details = new JPanel(new GridBagLayout());
		buttons.setBorder(BorderFactory.createTitledBorder("Actions"));
		genre.setBorder(BorderFactory.createTitledBorder("Genre"));
		details.setBorder(BorderFactory.createTitledBorder("Song Details"));
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.insets = new Insets(5, 5, 5, 5);

		// Add buttons
		buttons.add(gen);
		buttons.add(export);
		buttons.add(play);
		buttons.add(new JLabel("by: J.C. Reyes", JLabel.CENTER));

		// Add genres
		genre.add(reggae);
		genre.add(rock);

		// Add key, scale, tempo, swing, time signature
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
		frame.add(genre, BorderLayout.CENTER);
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