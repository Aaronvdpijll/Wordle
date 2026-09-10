package main;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Game {
	public static final String GREEN = "\u001B[42m";
	public static final String YELLOW = "\u001B[43m";
	public static final String ANSI_RESET_FG = "\u001B[0m";
	static int attempt_count = 0;
	static String[][] words_display = new String[6][5];
	static String[] attempt_words = new String[6];
	String word;
	ArrayList<String> words = new ArrayList<String>();

	public void start_game() {
		try {
			get_word();
		} catch (IOException e) {
			System.exit(0);
		}
		boolean found = false;
		Scanner scan = new Scanner(System.in);
		Instant time_start = Instant.now();
		while ((found == false) && (attempt_count < 6)) {
			String word_attempt = scan.nextLine();
			if ((word_attempt.length() == 5) && this.words.contains(word_attempt)) {
				found = check_word(word_attempt);
				if (found == true) {
					System.out.println("Congrats thats the correct word");
					System.out.println("Score: " + (attempt_count));
					break;
				} else if (found == false && attempt_count >= 6) {
					attempt_count++;
					System.out.println(
							"Sorry you failed, Score: " + attempt_count + " \nThe correct word was: " + this.word);
				}
			} else {
				System.out.println("Try again, word needs to be 5 letters long and a real word");
			}
		}
		scan.close();
		Instant time_stop = Instant.now();
		long time_elapsed = Duration.between(time_start, time_stop).toSeconds();
		System.out.println(Scoring.score3(attempt_count, time_elapsed) + " Score 3");

	}

	public boolean check_word(String word_attempt) {

		int index = 0;
		for (char letter : word_attempt.toCharArray()) {
			if (this.word.contains(String.valueOf(letter))) {
				if (this.word.charAt(index) == word_attempt.charAt(index)) {
					words_display[attempt_count][index] = (GREEN + " " + letter + " " + ANSI_RESET_FG);
				} else {
					words_display[attempt_count][index] = (YELLOW + " " + letter + " " + ANSI_RESET_FG);
				}
			} else {
				words_display[attempt_count][index] = (" " + letter + " ");
			}
			index++;
		}
		display(words_display);
		attempt_count++;
		return this.word.equals(word_attempt.strip()) ? true : false;
	}

	public void display(String[][] words_display) {
		for (int word = 0; word < attempt_count + 1; word++) {
			for (int letter = 0; letter < words_display[word].length; letter++) {
				if (words_display[word][letter] != null) {
					System.out.print(words_display[word][letter] + " ");
				}
			}
			System.out.println();
		}

	}

	public void get_word() throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("5-letter-words.txt"));
		String line = br.readLine();
		while (line != null) {
			this.words.add(line);
			line = br.readLine();
		}
		Random random_index = new Random();
		int index = random_index.nextInt(words.size() - 1);
		br.close();
		this.word = this.words.get(index);
	}

}
