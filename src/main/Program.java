package main;

public class Program {

	public static void main(String[] args) {
//		DB.connect();
//		DB.create_user("Aaron","123",1);
//		String[] attempts = {"Aaron","null","null","null","null","null"};
//		DB.upload_attempt(1, attempts, 1000, 0, "Aaron");
		Game user_game = new Game();
		user_game.start_game();
	}

}