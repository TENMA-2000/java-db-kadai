package kadai_007;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Posts_Chapter07 {

	public static void main(String[] args) {

		Connection con = null;
		Statement statement = null;

		try {
			con = DriverManager.getConnection(
					"jdbc:mysql://localhost/challenge_java",
					"root",
					"Ae86,trueno");

			System.out.println("データベース接続成功");

			statement = con.createStatement();

			String add = """
					INSERT INTO posts (user_id, posted_at, post_content, likes) VALUES
					("1003", "2023-02-08", "昨日は徹夜でした・・", "13"),
					("1002", "2023-02-08", "お疲れ様です！", "12"),
					("1003", "2023-02-09", "今日も頑張ります！", "18"),
					("1001", "2023-02-09", "無理は禁物ですよ！", "17"),
					("1002", "2023-02-10", "明日から連休ですね！", "20");
					""";

			int rowCnt = 0;

			System.out.println("レコードの追加を実行します");
			rowCnt = statement.executeUpdate(add);
			System.out.println(rowCnt + "件のレコードが追加されました");
			
			
			
			
			String search = "SELECT post_content, likes, posted_at FROM posts WHERE user_id = 1002";

			ResultSet result = statement.executeQuery(search);

			while (result.next()) {
				String post_content = result.getString("post_content");
				int likes = result.getInt("likes");
				Date postedAt = result.getDate("posted_at");
				
				System.out.println("ユーザーIDが" + search + "のレコードが追加されました");

				System.out
						.println(result.getRow() + "件目：投稿日時=" + postedAt + "／投稿内容=" + post_content + "／いいね数=" + likes);
			}
			

		} catch (SQLException e) {
			System.out.println("エラー発生：" + e.getMessage());
		} finally {
			if (statement != null) {
				try {statement.close();} catch (SQLException ignore) {}
			}
			if (con != null) {
				try {con.close();} catch (SQLException ignore) {}
			}
		}

	}

}
