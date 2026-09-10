package main;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

public class Simulated_tests {

	public static void main(String[] args) {
		System.out.println("How many simualted tests would you like to run? \n");
		Scanner scan = new Scanner(System.in);
		int simulation_count = scan.nextInt();
		Random random = new Random();
		try {
			FileWriter fw = new FileWriter("Simulated_Test.txt", false);
			BufferedWriter bw = new BufferedWriter(fw);
			bw.write("Attempts Time Scoring 1 Scoring 2 Scoring 3 \n");
			for (int i = 0; i < simulation_count; i++) {
				int simulated_attempts = random.nextInt(1, 8);
				int simulated_time_taken = random.nextInt(0, 900);
				bw.write(simulated_attempts + "\t" + simulated_time_taken + "\t"
						+ Scoring.score1(simulated_attempts, simulated_time_taken) + "\t"
						+ Scoring.score2(simulated_attempts) + "\t"
						+ Scoring.score3(simulated_attempts, simulated_time_taken));
				bw.newLine();

			}
			bw.close();
		} catch (IOException e) {
			System.out.println("Cannot create/find file");
			System.exit(0);
		}
	}

}
