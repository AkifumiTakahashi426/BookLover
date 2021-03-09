package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import beans.Book;

public class BookLoverDAO {
    //user専用のテーブル名の取得


    private final String JDBC_URL = "jdbc:mysql://172.16.61.117:3306/book_lover";
    private final String DB_USER = "unic01";
    private final String DB_PASS = "unic01pass";

    public List<Book> findAllDAO(String id) {

        String sql = "SELECT * FROM booklover WHERE id = ?";
        List<Book> myList = new ArrayList<Book>();
        Book book;

        try (Connection con = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS);
                PreparedStatement pStmt = con.prepareStatement(sql)) {

            pStmt.setString(1, id);

            ResultSet rs = pStmt.executeQuery();

            while (rs.next()) {
                String iD = rs.getString("id");
                String title = rs.getString("title");
                String publisher = rs.getString("publisher");
                String authors = rs.getString("authors");
                String thumbnail = rs.getString("thumbnail");
                String identifier = rs.getString("identifier");
                String selfLink = rs.getString("selfLink");
                String description = rs.getString("description");
                int fun = rs.getInt("fun");
                String summary = rs.getString("summary");
                int alRead = rs.getInt("alreadyRead");
                boolean alReadB;
                if (alRead == 0) {
                    alReadB = false;
                } else {
                    alReadB = true;
                }
                int have = rs.getInt("have");

                book = new Book(iD, title, publisher, authors, thumbnail, identifier, selfLink, description, fun, summary,
                        alReadB, have);
                myList.add(book);

            }

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }

        return myList;

    }

    public List<Book> findHaveDAO(String id) {

        String sql = "SELECT * FROM booklover WHERE have = '2' AND id =?";
        Book book;
        List<Book> myList = new ArrayList<Book>();

        try (Connection con = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS);
                PreparedStatement pStmt = con.prepareStatement(sql)) {

            pStmt.setString(1, id);
            ResultSet rs = pStmt.executeQuery();

            while (rs.next()) {
                String iD = rs.getString("id");
                String title = rs.getString("title");
                String publisher = rs.getString("publisher");
                String authors = rs.getString("authors");
                String thumbnail = rs.getString("thumbnail");
                String identifier = rs.getString("identifier");
                String selfLink = rs.getString("selfLink");
                String description = rs.getString("description");
                int fun = rs.getInt("fun");
                String summary = rs.getString("summary");
                int alRead = rs.getInt("alreadyRead");
                boolean alReadB;
                if (alRead == 0) {
                    alReadB = false;
                } else {
                    alReadB = true;
                }
                int have = rs.getInt("have");

                book = new Book(iD, title, publisher, authors, thumbnail, identifier, selfLink, description, fun, summary,
                        alReadB, have);
                myList.add(book);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }

        return myList;
    }

    public List<Book> findWantDAO(String id) {

        String sql = "SELECT * FROM booklover WHERE have = '1' AND id =?";
        Book book;
        List<Book> myList = new ArrayList<Book>();

        try (Connection con = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS);
                PreparedStatement pStmt = con.prepareStatement(sql)) {

            pStmt.setString(1, id);
            ResultSet rs = pStmt.executeQuery();

            while (rs.next()) {
                String iD = rs.getString("id");
                String title = rs.getString("title");
                String publisher = rs.getString("publisher");
                String authors = rs.getString("authors");
                String thumbnail = rs.getString("thumbnail");
                String identifier = rs.getString("identifier");
                String selfLink = rs.getString("selfLink");
                String description = rs.getString("description");
                int fun = rs.getInt("fun");
                String summary = rs.getString("summary");
                int alRead = rs.getInt("alreadyRead");
                boolean alReadB;
                if (alRead == 0) {
                    alReadB = false;
                } else {
                    alReadB = true;
                }
                int have = rs.getInt("have");

                book = new Book(iD, title, publisher, authors, thumbnail, identifier, selfLink, description, fun, summary,
                        alReadB, have);
                myList.add(book);

            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
        return myList;
    }

    public boolean deleteDAO(String identifier, String id) {

        String sql = "DELETE FROM booklover WHERE identifier = ? AND id = ?";
        boolean bool = false;
        int num;

        try (Connection con = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS);
                PreparedStatement pStmt = con.prepareStatement(sql)) {

            pStmt.setString(1, identifier);
            pStmt.setString(2, id);

            num = pStmt.executeUpdate();
            if (num == 1) {
                bool = true;
            } else {
                bool = false;
            }

        } catch (SQLException e) {
            e.printStackTrace();

        }
        return bool;
    }

    public Book informationDAO(String identifier, String id) {

        String sql = "SELECT * FROM booklover WHERE identifier = ? AND id =?";
        Book book = null;

        try (Connection con = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS);
                PreparedStatement pStmt = con.prepareStatement(sql)) {
            pStmt.setString(1, identifier);
            pStmt.setString(2, id);
            ResultSet rs = pStmt.executeQuery();

            while (rs.next()) {
                String iD = rs.getString("id");
                String title = rs.getString("title");
                String publisher = rs.getString("publisher");
                String authors = rs.getString("authors");
                String thumbnail = rs.getString("thumbnail");
                String identifierISBN = rs.getString("identifier");
                String selfLink = rs.getString("selfLink");
                String description = rs.getString("description");
                int fun = rs.getInt("fun");
                String summary = rs.getString("summary");
                int alRead = rs.getInt("alreadyRead");
                boolean alReadB;
                if (alRead == 0) {
                    alReadB = false;
                } else {
                    alReadB = true;
                }
                int have = rs.getInt("have");

                book = new Book(iD, title, publisher, authors, thumbnail, identifierISBN, selfLink, description, fun,
                        summary, alReadB, have);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return book;

    }

    public int existDbDAO(String identifier, String id) {

        String sql = "SELECT have FROM booklover WHERE identifier = ? AND id = ?";
        int have = 0;
        try (Connection con = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS);
                PreparedStatement pStmt = con.prepareStatement(sql)) {
            pStmt.setString(1, identifier);
            pStmt.setString(2, id);
            ResultSet rs = pStmt.executeQuery();

            while (rs.next()) {
            have = rs.getInt("have");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return have;

    }

    public boolean buyDAO(String identifier, String id) {
        String sql = "UPDATE booklover SET have = 2 WHERE identifier = ? AND id= ?";
        boolean bool = false;

        try (Connection con = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS);
                PreparedStatement pStmt = con.prepareStatement(sql)) {
            pStmt.setString(1, identifier);
            pStmt.setString(2, id);
            int num = pStmt.executeUpdate();

            num = pStmt.executeUpdate();
            if (num >= 1) {
                bool = true;
            } else {
                bool = false;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return bool;
    }

    public boolean newBuyDAO(Book book, String id) {
        int num;
        boolean bool = false;
        String sql = "INSERT INTO booklover VALUES(?,?,?,?,?,?,?,?,?,?,?,?) ";
        try (Connection con = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS);
                PreparedStatement pStmt = con.prepareStatement(sql)) {
            pStmt.setString(1, id);
            pStmt.setString(2, book.getTitle());
            pStmt.setString(3, book.getPublisher());
            pStmt.setString(4, book.getAuthors());
            pStmt.setString(5, book.getThumbnail());
            pStmt.setString(6, book.getIdentifier());
            pStmt.setString(7, book.getSelfLink());
            pStmt.setString(8, book.getDescription());
            pStmt.setInt(9, book.getFun());
            pStmt.setString(10, book.getSummary());
            pStmt.setBoolean(11, book.isAlreadyRead());
            pStmt.setInt(12, 2);

            num = pStmt.executeUpdate();
            if (num >= 1) {
                bool = true;
            } else {
                bool = false;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return bool;
    }

    public boolean newWantDAO(Book book, String id) {
        int num;
        boolean bool = false;
        String sql = "INSERT INTO booklover VALUES(?,?,?,?,?,?,?,?,?,?,?,?) ";
        try (Connection con = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS);
                PreparedStatement pStmt = con.prepareStatement(sql)) {
            pStmt.setString(1, id);
            pStmt.setString(2, book.getTitle());
            pStmt.setString(3, book.getPublisher());
            pStmt.setString(4, book.getAuthors());
            pStmt.setString(5, book.getThumbnail());
            pStmt.setString(6, book.getIdentifier());
            pStmt.setString(7, book.getSelfLink());
            pStmt.setString(8, book.getDescription());
            pStmt.setInt(9, book.getFun());
            pStmt.setString(10, book.getSummary());
            pStmt.setBoolean(11, book.isAlreadyRead());
            pStmt.setInt(12, 1);

            num = pStmt.executeUpdate();
            if (num >= 1) {
                bool = true;
            } else {
                bool = false;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return bool;
    }

    public boolean updateDAO(String id, String identifire, int fun, boolean alreadyRead, String summary) {
        int num;
        boolean bool = false;
        String sql = "UPDATE booklover SET fun =?,  alreadyRead =? ,summary=? WHERE identifier =? AND id =?";
        try (Connection con = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS);
                PreparedStatement pStmt = con.prepareStatement(sql)) {

            // 数字変更
            pStmt.setInt(1, fun);
            pStmt.setBoolean(2, alreadyRead);
            pStmt.setString(3, summary);
            pStmt.setString(4, identifire);
            pStmt.setString(5, id);

            num = pStmt.executeUpdate();
            if (num == 1) {
                bool = true;
            } else {
                bool = false;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return bool;

    }

    public List<Book> findTitleDAO(String word, String id) {
        String sql = "SELECT * FROM booklover WHERE id = ? AND title like ?";
        Book book;
        List<Book> myList = new ArrayList<Book>();

        try (Connection con = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS);
                PreparedStatement pStmt = con.prepareStatement(sql)) {
            pStmt.setString(1, id);
            pStmt.setString(2, "%" + word + "%");
            ResultSet rs = pStmt.executeQuery();

            if (rs != null) {
                while (rs.next()) {
                    String iD = rs.getString("id");
                    String title = rs.getString("title");
                    String publisher = rs.getString("publisher");
                    String authors = rs.getString("authors");
                    String thumbnail = rs.getString("thumbnail");
                    String identifierISBN = rs.getString("identifier");
                    String selfLink = rs.getString("selfLink");
                    String description = rs.getString("description");
                    int fun = rs.getInt("fun");
                    String summary = rs.getString("summary");
                    int alRead = rs.getInt("alreadyRead");
                    boolean alReadB;
                    if (alRead == 0) {
                        alReadB = false;
                    } else {
                        alReadB = true;
                    }
                    int have = rs.getInt("have");

                    book = new Book(iD, title, publisher, authors, thumbnail, identifierISBN, selfLink, description, fun,
                            summary, alReadB, have);
                    myList.add(book);
                }
            } else {

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return myList;
    }

}
