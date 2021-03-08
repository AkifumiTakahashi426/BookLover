package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import model.User;

public class AccountRegisterDAO {
    private String name="";
    private String pass="";

public AccountRegisterDAO(User ab) {
        // TODO 自動生成されたコンストラクター・スタブ
    this.name=ab.getName();
    this.pass=ab.getPass();
    }

    //新規登録のDAO
    public class newAccountDAO {
        private final String JDBC_URL = "Jdbc:mysql://localhost:3306/training";
        private final String DB_USER = "user02";
        private final String DB_PASS = "user02pass";
        public void newAccount() {}

        public void newAccount(User ab) {
            User returnAb = new User();
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
            } catch (ClassNotFoundException e1) {
                e1.printStackTrace();
            }
            try (Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)) {
                String sql = "INSERT INTO User (id,name,pass,table)VALUES(0,?,?,?)";
                PreparedStatement pStmt = conn.prepareStatement(sql);
                String nameTable=name+"table";
                pStmt.setString(1,name);
                pStmt.setString(2,pass);
                pStmt.setString(3,nameTable);
                int r=pStmt.executeUpdate();
                if(r!=0) {
                    //登録成功 個人のtable作成
                    String sqlTable="CREATE TABLE ？(book_name text NOT NULL,publisher text NOT NULL,writer text,isbn VARCHAR(20) NOT NULL,price INT,fun INT,summary VARCHAR(300),already_read boolean NOT NULL,have INT NOT NULL,PRIMARY KEY(isbn))";
                   PreparedStatement pStmttable = conn.prepareStatement(sqlTable);
                   pStmttable.setString(1,nameTable);
                }else {
                    //登録失敗 フォワード
                }
                }catch(SQLException e){
                    e.printStackTrace();
                }
            }
        }
    }

