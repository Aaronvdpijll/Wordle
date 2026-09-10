package main;

public class Scoring {
	public static int score1(int user_attempts, long final_time) {
		int score = (int) (user_attempts*final_time);
		return score;
	}
	public static int score2(int user_attempts) {
		return user_attempts;
	}
	public static int score3(int user_attempts, long final_time) {
		int score = (int) ((user_attempts-1)*10);
		score = score + ((int) (((double) final_time/900)*100));
		score = score >= 100 ? 100 : score;
		return score;
	}
}
