package kadai_004;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Employee_table {

	public static void main(String[] args) {
		
		Connection con = null;
		Statement statement = null;
		
		try {
			con = DriverManager.getConnection(
					"jdbc:mysql://localhost/challenge_java",
					"root",
					"Ae86,trueno"
					);
			
		System.out.println("データベース接続成功:" + con);
			
			statement = con.createStatement();
			String sql = """
					CREATE TABLE users (
					id INT(11) NOT NULL AUTO_INCREMENT PRIMARY KEY,
					name VARCHAR(60) NOT NULL
					);
					""";
		
			
			int rowCnt = statement.executeUpdate(sql);
			System.out.println("社員テーブルを作成:更新レコード数=" + rowCnt);
		}catch (SQLException e) {
			System.out.println("エラー発生:" + e.getMessage());
		}finally {
			if (statement != null) {
				try {statement.close();} catch (SQLException ignore) {}
			}
			if (con != null) {
				try {con.close();} catch (SQLException ignore) {}
			}
		}

	}

}
