package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UserDAO {
    private final String JDBC_URL = "jdbc:mysql://172.16.61.117:3306/book_lover";
    private final String DB_USER = "unic01";
    private final String DB_PASS = "unic01pass";

    // UserDAOクラス用
    public void Entry(String userName, String newPass) {
        String sql = "INSERT INTO BookLover VALUES (0,?,?)";
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e1) {
            e1.printStackTrace();
        }
        try (Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)) {
            PreparedStatement pstm = conn.prepareStatement(sql);

            pstm.setString(1, userName);
            pstm.setString(2, newPass);
            conn.setAutoCommit(false);

            pstm.executeUpdate();
            conn.commit();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

}
