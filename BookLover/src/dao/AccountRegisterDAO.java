package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.User;

public class AccountRegisterDAO {
    private String name="";
    private String pass="";

public AccountRegisterDAO(User abc) {
        // TODO 自動生成されたコンストラクター・スタブ
    this.name=abc.getName();
    this.pass=abc.getPass();


    }

    public String getName() {
    return name;
}

public String getPass() {
    return pass;
}

    //新規登録のDAO

        private final String JDBC_URL = "Jdbc:mysql://172.16.61.117:3306/book_lover";
        private final String DB_USER = "unic01";
        private final String DB_PASS = "unic01pass";
        public void newAccount() {}

        public boolean newAccount(User abc) {
            User returnAb = new User();
            boolean check=false;
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
            } catch (ClassNotFoundException e1) {
                e1.printStackTrace();
            }
            try (Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)) {
                String sql = "INSERT INTO login (id,name,pass,table_name)VALUES(0,?,?,?)";
                PreparedStatement pStmt = conn.prepareStatement(sql);
                String nameTable=name+"table";
                pStmt.setString(1,name);
                pStmt.setString(2,pass);
                pStmt.setString(3,nameTable);
                int r=pStmt.executeUpdate();//ここでエラー
                if(r!=0) {
                    //登録成功 個人のtable作成
                    String sqlTable="CREATE TABLE ?(title text NOT NULL,publisher text,authors text,thumbnail text,identifier text NOT NULL,selfLink text,description text,fun INT,summary text,alreadyRead boolean,have INT,PRIMARY KEY(identifier(20)));";
                    PreparedStatement pStmttable = conn.prepareStatement(sqlTable);
                    pStmttable.setString(1,nameTable);
                    ResultSet rs =pStmttable.executeQuery();
                    check=true;
                 }else {
                     check=false;
                     //登録失敗 フォワード
                 }
                 }catch(SQLException e){
                     e.printStackTrace();
                 }
             return check;
             }
         }

