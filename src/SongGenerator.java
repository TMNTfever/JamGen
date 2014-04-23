/** 
 * @author	Julian-Chris Reyes
 * JamGen	Song
 * 
 * Utilizes JFugue's Player class to interpret the randomly generated music,
 * and to also playback and save the song as a midi file.
 */

import java.io.File;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;

import javax.sound.midi.InvalidMidiDataException;
import javax.sound.midi.MidiSystem;
import javax.sound.midi.MidiUnavailableException;
import javax.sound.midi.Sequence;

import org.jfugue.midi.MidiFileManager;
import org.jfugue.pattern.Pattern;
import org.jfugue.player.ManagedPlayer;

public class SongGenerator {
	ManagedPlayer player;
	Pattern pattern;
	Song song;
	String songString;
	String tempo;
	String melodyInstr;
	String chordsInstr;
	int key;

	public SongGenerator() {
		this.player = new ManagedPlayer();
		this.song = new Song();
		this.tempo = "T[Andantino] ";
		this.melodyInstr = "I0 ";
		this.chordsInstr = "I0 ";
		this.key = 0;
	}
	
	/**
	 * Calls methods to generate a string that represents the song and
	 * translates that to a JFugue readable format
	 */
	public void generate() {
		this.songString = this.song.generate(this.melodyInstr, this.chordsInstr);
		this.songString = translate(this.songString);
		this.pattern = new Pattern(this.tempo + this.songString);
		System.out.println(pattern.toString());
	}

	/**
	 * Takes a generic-key song (consists of chord numbers) and translates the
	 * string into a readable format for JFugue.
	 * 
	 * @param s		Generated music string in generic format, which is not in
	 * 				any specific key.
	 * 
	 * @return		Returns a JFugue formatted string.
	 */
	private String translate(String s) {
		Queue<String> q1 = new LinkedList<String>();
		Queue<String> q2 = new LinkedList<String>();

		q1.add("A");
		q1.add("Bb");
		q1.add("B");
		q1.add("C");
		q1.add("C#");
		q1.add("D");
		q1.add("Eb");
		q1.add("E");
		q1.add("F");
		q1.add("F#");
		q1.add("G");
		q1.add("G#");

		q2.add("A");
		q2.add("Bb");
		q2.add("B");
		q2.add("C");
		q2.add("C#");
		q2.add("D");
		q2.add("Eb");
		q2.add("E");
		q2.add("F");
		q2.add("F#");
		q2.add("G");
		q2.add("G#");

		// Rotate elements of queue, such that they match up to current key
		for(int i = 0; i < key; i++) {
			q1.add(q1.poll());
			q2.add(q2.poll());
		}

		String replace1 = q1.poll() + "maj";
		String sub1 = q2.poll();
		q1.poll();
		q2.poll();
		String replace2 = q1.poll() + "min";
		String sub2 = q2.poll();
		q1.poll();
		q2.poll();
		String replace3 = q1.poll() + "min";
		String sub3 = q2.poll();
		String replace4 = q1.poll() + "maj";
		String sub4 = q2.poll();
		q1.poll();
		q2.poll();
		String replace5 = q1.poll() + "maj";
		String sub5 = q2.poll();
		q1.poll();
		q2.poll();
		String replace6 = q1.poll() + "min";
		String sub6 = q2.poll();
		q1.poll();
		q2.poll();
		String replace7 = q1.poll() + "dim";
		String sub7 = q2.poll();

		// Inefficient way to substitute chords
		for(int i = 0; i < s.length(); i++) {
			s = s.replace("FIRST", replace1);
			s = s.replace("SECOND", replace2);
			s = s.replace("THIRD", replace3);
			s = s.replace("FOURTH", replace4);
			s = s.replace("FIFTH", replace5);
			s = s.replace("SIXTH", replace6);
			s = s.replace("SEVENTH", replace7);
		}

		// Inefficient way to substitute melody
		for(int i = 0; i < s.length(); i++) {
			s = s.replace("first", sub1);
			s = s.replace("second", sub2);
			s = s.replace("third", sub3);
			s = s.replace("fourth", sub4);
			s = s.replace("fifth", sub5);
			s = s.replace("sixth", sub6);
			s = s.replace("seventh", sub7);
		}
		return s;
	}

	/**
	 * Saves the current generated song as a .midi file.
	 */
	public void export() {
		export("JamGen", 0);
	}

	/**
	 * Creates temporary .midi files for playback.
	 * 
	 * @return		The name of the temp file created.
	 */
	public String createTemp() {
		return export("temp/t", 0);
	}

	/**
	 * Recursive method for export() to avoid rewriting previously saved files.
	 * 
	 * @param i		The number of files under the same name.
	 */
	private String export(String name, int i) {
		File f = new File(name + i + ".mid");

		try {
			if(f.exists()) {
				return export(name, i + 1);
			}
			else {
				MidiFileManager.savePatternToMidi(this.pattern, f);
				return f.getAbsolutePath();
			}
		}
		catch (IOException e) {
			System.out.println("Save unsuccessful: " + e);
		}

		return "";
	}

	/**
	 * Plays the song through the JFugue player.
	 * @throws MidiUnavailableException 
	 * @throws InvalidMidiDataException 
	 */
	public void play() throws InvalidMidiDataException, MidiUnavailableException {
		String name = createTemp();
		final File f = new File(name);
		Sequence s;

		try {
			s = MidiSystem.getSequence(f);
			this.player.start(s);
		} catch (IOException e) {
			System.out.println("Failed playback: " + e);
		}
	}

	/**
	 * Stops playing the song through the JFugue player.
	 */
	public void stop() {
		player.pause();
	}

	/**
	 * Setter function for key.
	 * 
	 * @param i		Key of A = 0, A# = 1, B = 2, etc.
	 */
	public void setKey(int i) {
		this.key = i;
	}

	/**
	 * Setter function for bpm.
	 * 
	 * @param i		Beats per minute that will be turned into a tempo string.
	 */
	public void setTempo(int i) {
		switch(i) {
			case 40: this.tempo = "T[Grave] "; break;
			case 45: this.tempo = "T[Largo] "; break;
			case 50: this.tempo = "T[Larghetto] "; break;
			case 55: this.tempo = "T[Lento] "; break;
			case 60: this.tempo = "T[Adagio] "; break;
			case 65: this.tempo = "T[Adagietto] "; break;
			case 70: case 75:
				this.tempo = "T[Andante] "; break;
			case 80: case 85: case 90:
				this.tempo = "T[Andantino] "; break;
			case 95: case 100:
				this.tempo = "T[Moderato] "; break;
			case 110: case 115:
				this.tempo = "T[Allegretto] "; break;
			case 120: case 125: case 130: case 135:
				this.tempo = "T[Allegro] "; break;
			case 145: case 150: case 155: case 160: 
			case 165: case 170: case 175:
				this.tempo = "T[Vivace] "; break;
			case 180: case 185: case 190: case 195: case 200:
			case 205: case 210: case 215:
				this.tempo = "T[Presto] "; break;
			case 220: this.tempo = "T[Pretissimo] "; break;
		}
	}

	/**
	 * Setter function for melody instrument.
	 * 
	 * @param i		Instrument index from GUI
	 */
	public void setMelodyInstrument(int i) {
		this.melodyInstr = "I" + i + " ";
	}

	/**
	 * Setter function for chords instrument.
	 * 
	 * @param i		Instrument index from GUI.
	 */
	public void setChordsInstrument(int i) {
		this.chordsInstr = "I" + i + " ";
	}
}