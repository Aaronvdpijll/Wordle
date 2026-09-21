package main;

import java.sql.*;

public class DB {
	static PreparedStatement SQL_Query;
	static String connection = "jdbc:sqlserver://localhost:1433;" + "databaseName=master;" + "encrypt=true;"
			+ "trustServerCertificate=true;" + "integratedSecurity=true;";
	static Connection db_connection;

	public static void connect() {
		try {
			db_connection = DriverManager.getConnection(connection);
			System.out.println("Connected Successfully");
		} catch (SQLException e) {
			System.out.println("Failed to connect to database");
		}
	}

	public static void sql_update(String Query, Object... parameters) {

		try {
			PreparedStatement SQL_Query = db_connection.prepareStatement(Query);
			for (int i = 0; i < parameters.length; i++) {
				SQL_Query.setObject(i + 1, parameters[i]);
			}
			SQL_Query.executeUpdate();
			System.out.println("SQL Query Executed Successfully");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Failed to update database");
			System.out.println("Query: " + Query);
			for (Object parameter : parameters) {
				System.out.println("Parameter: " + parameter);
			}
		}
	}

	public static void create_user(String login, String password, int group) {
		String Query = "INSERT INTO wordle_users (login, password, group_id) VALUES (?, ?, ?)";
		sql_update(Query, login, password, group);
	}

	public static void create_group(String group_name, String group_code) {
		String Query = "INSERT INTO wordle_group (group_name,group_code) VALUES (?,?)";
		sql_update(Query, group_name, group_code);
	}

	public static void create_device(String device_ip, String user_id) {
		String Query = "INSERT INTO wordle_devices (device_ip,user_id) VALUES (?,?)";
		sql_update(Query, device_ip, user_id);
	}

	public static void upload_attempt(int user_id, String[] attempts, int score, int game_type, String correct_word) {
		String query = "INSERT INTO wordle_attempt (user_id,word1,word2,word3,word4,word5,word6,score,game_type,correct_word) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		sql_update(query, user_id, attempts[0], attempts[1], attempts[2], attempts[3], attempts[4], attempts[5], score,
				game_type, correct_word);
	}

}
