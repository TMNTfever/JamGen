/** 
 * @author	Julian-Chris Reyes
 * JamGen	Song
 * 
 * Song generates the music, plays it, and exports it.
 */

import java.util.LinkedList;
import java.util.Queue;

import org.jfugue.*;


public class SongGenerator {
	Player player;
	Pattern pattern;
	Genre genre;
	String song;
	String tempo;
	int key;

	public SongGenerator() {
		this.player = new Player();
		// Default
		this.genre = new Rock();
		this.tempo = "T[Allegro]";
		this.key = 0;
	}

	public void generate() {
		this.song = this.genre.generate();
		this.song = translate(this.song);
		this.pattern = new Pattern(this.tempo + this.song);
	}

	/**
	 * Takes a generic-key song (consists of chord numbers) and translates the
	 * string into a readable format for JFugue.
	 * 
	 * @param s		Generated song string in generic format, which is not in
	 * 				a specific key.
	 * 
	 * @return		Returns a JFugue formatted string.
	 */
	private String translate(String s) {
		Queue<String> q = new LinkedList<String>();
		q.add("A");
		q.add("Bb");
		q.add("B");
		q.add("C");
		q.add("Db");
		q.add("D");
		q.add("Eb");
		q.add("E");
		q.add("F");
		q.add("Gb");
		q.add("G");
		q.add("Ab");

		// Rotate elements of queue, such that they match up to current key
		for(int i = 0; i < key; i++) {
			q.add(q.poll());
		}

		String replace1 = q.poll() + "maj";
		q.poll();
		String replace2 = q.poll() + "min";
		q.poll();
		String replace3 = q.poll() + "min";
		String replace4 = q.poll() + "maj";
		q.poll();
		String replace5 = q.poll() + "maj";
		q.poll();
		String replace6 = q.poll() + "min";
		q.poll();
		String replace7 = q.poll() + "dim";

		// Inefficient way to substitute chord
		for(int i = 0; i < s.length(); i++) {
			s = s.replace("FIRST", replace1);
			s = s.replace("SECOND", replace2);
			s = s.replace("THIRD", replace3);
			s = s.replace("FOURTH", replace4);
			s = s.replace("FIFTH", replace5);
			s = s.replace("SIXTH", replace6);
			s = s.replace("SEVENTH", replace7);
		}

		return s;
	}

	/**
	 * Saves the current generated song as a .midi file.
	 */
	public void export() {
		// To-do
	}

	/**
	 * Plays the song through the JFugue player.
	 */
	public void play() {
		System.out.println(this.song);
		player.play(this.pattern);
	}

	/** 
	 * Determines what the genre is based on GUI selection.
	 * 
	 * @param i	= 0: Reggae
	 * 		 	= 1: Rock
	 */
	public void setGenre(int i) {
		switch(i) {
			case 0: this.genre = new Reggae(); break;
			case 1: this.genre = new Rock(); break;
		}
	}

	/**
	 * Setter function for key.
	 * 
	 * @param i
	 */
	public void setKey(int i) {
		this.key = i;
	}

	/**
	 * Setter function for bpm.
	 * 
	 * @param i
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
				this.tempo = "T[Moderato]"; break;
			case 110: case 115:
				this.tempo = "T[Allegrato] "; break;
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
}