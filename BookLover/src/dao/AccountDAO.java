package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.User;

public class AccountDAO {
    private final String JDBC_URL = "Jdbc:mysql://172.16.61.117:3306/book_lover";
    private final String DB_USER = "unic01";
    private final String DB_PASS = "unic01pass";

    public User findAccount(User ab) {
        User returnAb = new User();
        //データベース接続
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e1) {
            e1.printStackTrace();
        }
        try (Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)) {
            String sql = "SELECT name,pass from User WHERE name=? AND pass=?";
            PreparedStatement pStmt = conn.prepareStatement(sql);
            pStmt.setString(1, ab.getName());
            pStmt.setString(2, ab.getPass());

            ResultSet rs = pStmt.executeQuery();
            if (rs.next()) {
                //見つかったアカウント情報を戻り値にセット
                returnAb.setName(rs.getString("name"));
                returnAb.setPass(rs.getString("pass"));
            } else {
                return null;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
        return returnAb;
    }

}
