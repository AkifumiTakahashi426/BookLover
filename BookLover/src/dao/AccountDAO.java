package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AccountDAO {
    private final String JDBC_URL = "Jdbc:mysql://172.16.61.117:3306/book_lover";
    private final String DB_USER = "unic01";
    private final String DB_PASS = "unic01pass";

    public List<String> findAccount(String name,String pass) {
        //User returnAb = new User();
        List<String> accountList = new ArrayList<>();
        // データベース接続
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e1) {
            e1.printStackTrace();
        }
        try (Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)) {
            String sql = "SELECT name,pass FROM login WHERE name=? AND pass=?";

            PreparedStatement pStmt = conn.prepareStatement(sql);
            pStmt.setString(1, name);
            pStmt.setString(2, pass);

            ResultSet rs = pStmt.executeQuery();
            while (rs.next()) {
                // 見つかったアカウント情報を戻り値にセット
                name = rs.getString("name");
                pass = rs.getString("pass");
                accountList.add(name);
                accountList.add(pass);
//              returnAb.setName(rs.getString("name"));
//              returnAb.setPass(rs.getString("pass"));

            }

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
        return accountList;
    }

}
