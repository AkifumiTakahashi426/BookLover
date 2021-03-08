package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import model.User;

public class AccountRegisterDAO {
    private String name = "";
    private String pass = "";

<<<<<<< HEAD
    public AccountRegisterDAO(User abc) {
=======
public AccountRegisterDAO(User ab) {
>>>>>>> branch 'master' of https://github.com/AkifumiTakahashi426/BookLover
        // TODO 自動生成されたコンストラクター・スタブ
<<<<<<< HEAD
        this.name = abc.getName();
        this.pass = abc.getPass();

=======
    this.name=ab.getName();
    this.pass=ab.getPass();
>>>>>>> branch 'master' of https://github.com/AkifumiTakahashi426/BookLover
    }

<<<<<<< HEAD
    public String getName() {
        return name;
    }

    public String getPass() {
        return pass;
    }

    // 新規登録のDAO

    private final String JDBC_URL = "Jdbc:mysql://172.16.61.117:3306/book_lover";
    private final String DB_USER = "unic01";
    private final String DB_PASS = "unic01pass";
=======
    //新規登録のDAO
    public class newAccountDAO {
        private final String JDBC_URL = "Jdbc:mysql://localhost:3306/training";
        private final String DB_USER = "user02";
        private final String DB_PASS = "user02pass";
        public void newAccount() {}
>>>>>>> branch 'master' of https://github.com/AkifumiTakahashi426/BookLover

<<<<<<< HEAD
    public void newAccount() {
    }

    public boolean newAccount(User abc) {
        // User returnAb = new User();
        boolean check = false;
        int r = 0;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e1) {
            e1.printStackTrace();
        }
        try (Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)) {
            String sql = "INSERT INTO login (id,name,pass,table_name)VALUES(0,?,?,?)";
            PreparedStatement pStmt = conn.prepareStatement(sql);
            String nameTable = name + "table";
            pStmt.setString(1, name);
            pStmt.setString(2, pass);
            pStmt.setString(3, nameTable);
            conn.setAutoCommit(false);
            r = pStmt.executeUpdate();
            conn.commit();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        if (r != 0) {
            check = true;

        } else {
            check = false;
            // 登録失敗 フォワード
        }
        return check;
    }
    public void createTable() {
        try (Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)) {
            // 登録成功 個人のtable作成
            String nameTable = name + "table";
            String sqlTable = "CREATE TABLE ?(title text NOT NULL,publisher text,authors text,thumbnail text,identifier text NOT NULL,selfLink text,description text,fun INT,summary text,alreadyRead boolean,have INT,PRIMARY KEY(identifier(20)));";
            PreparedStatement pStmttable = conn.prepareStatement(sqlTable);
            pStmttable.setString(1, nameTable);
            pStmttable.executeQuery();
            }catch (SQLException e) {
                e.printStackTrace();
=======
        public void newAccount(User ab) {
            User returnAb = new User();
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
            } catch (ClassNotFoundException e1) {
                e1.printStackTrace();
>>>>>>> branch 'master' of https://github.com/AkifumiTakahashi426/BookLover
            }
<<<<<<< HEAD
    }
}
//PreparedStatement psCreate = null;
//final String SQL_CREATE = "CREATE TABLE TABLE_TEST( NAME VARCHAR, VALUE INT )";
//psCreate = conn.prepareStatement( SQL_CREATE );
//psCreate.execute();
=======
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

>>>>>>> branch 'master' of https://github.com/AkifumiTakahashi426/BookLover
