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

    private final String JDBC_URL = "jdbc:mysql://172.16.61.117:3306/book_lover";
    private final String DB_USER = "unic01";
    private final String DB_PASS = "unic01pass";

    public List<Book> findAllDAO() {

        String sql = "SELECT * FROM booklover";
        List<Book> myList = new ArrayList<Book>();
        Book book;

        try (Connection con = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS);
                PreparedStatement pStmt = con.prepareStatement(sql)) {

            ResultSet rs = pStmt.executeQuery();

            while (rs.next()) {
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

                book = new Book(title, publisher, authors, thumbnail, identifier, selfLink, description, fun, summary,
                        alReadB, have);
                myList.add(book);

            }

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }

        return myList;

    }

    public List<Book> findHaveDAO() {

        String sql = "SELECT * FROM booklover WHERE have = '2'";
        Book book;
        List<Book> myList = new ArrayList<Book>();

        try (Connection con = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS);
                PreparedStatement pStmt = con.prepareStatement(sql)) {

            ResultSet rs = pStmt.executeQuery();

            while (rs.next()) {
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

                book = new Book(title, publisher, authors, thumbnail, identifier, selfLink, description, fun, summary,
                        alReadB, have);
                myList.add(book);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }

        return myList;
    }

    public List<Book> findWantDAO() {

        String sql = "SELECT * FROM booklover WHERE have = '1'";
        Book book;
        List<Book> myList = new ArrayList<Book>();

        try (Connection con = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS);
                PreparedStatement pStmt = con.prepareStatement(sql)) {

            ResultSet rs = pStmt.executeQuery();

            while (rs.next()) {
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

                book = new Book(title, publisher, authors, thumbnail, identifier, selfLink, description, fun, summary,
                        alReadB, have);
                myList.add(book);

            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
        return myList;
    }

    public boolean deleteDAO(String identifier) {

        String sql = "DELETE FROM booklover WHERE identifier = ?";
        boolean bool = false;
        int num;

        try (Connection con = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS);
                PreparedStatement pStmt = con.prepareStatement(sql)) {

            pStmt.setString(1, identifier);

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

    public Book infomationDAO(String identifier) {

        String sql = "SELECT * FROM booklover WHERE identifier = ?";
        Book book = null;

        try (Connection con = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS);
                PreparedStatement pStmt = con.prepareStatement(sql)) {
            pStmt.setString(1, identifier);
            ResultSet rs = pStmt.executeQuery();

            while (rs.next()) {
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

                book = new Book(title, publisher, authors, thumbnail, identifierISBN, selfLink, description, fun,
                        summary, alReadB, have);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return book;

    }

    public int existDbDAO(String identifier) {

        String sql = "SELECT have FROM booklover WHERE identifier = ?";
        int have = 0;
        try (Connection con = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS);
                PreparedStatement pStmt = con.prepareStatement(sql)) {
            pStmt.setString(1, identifier);
            ResultSet rs = pStmt.executeQuery();
            have = rs.getInt("have");

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return have;

    }

    public boolean buyDAO(String identifier) {
        String sql = "UPDATE booklover SET have = 2 WHERE identifier = ?";
        boolean bool = false;

        try (Connection con = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS);
                PreparedStatement pStmt = con.prepareStatement(sql)) {
            pStmt.setString(1, identifier);
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

    public boolean newBuyDAO(Book book) {
        int num;
        boolean bool = false;
        String sql = "INSERT INTO booklover VALUES(?,?,?,?,?,?,?,?,?,?,?) ";
        try (Connection con = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS);
                PreparedStatement pStmt = con.prepareStatement(sql)) {
            pStmt.setString(1, book.getTitle());
            pStmt.setString(2, book.getPublisher());
            pStmt.setString(3, book.getAuthors());
            pStmt.setString(4, book.getThumbnail());
            pStmt.setString(5, book.getIdentifier());
            pStmt.setString(6, book.getSelfLink());
            pStmt.setString(7, book.getDescription());
            pStmt.setInt(8, book.getFun());
            pStmt.setString(9, book.getSummary());
            pStmt.setBoolean(10, book.isAlreadyRead());
            pStmt.setInt(11, 2);

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

    public boolean newWantDAO(Book book) {
        int num;
        boolean bool = false;
        String sql = "INSERT INTO booklover VALUES(?,?,?,?,?,?,?,?,?,?,?) ";
        try (Connection con = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS);
                PreparedStatement pStmt = con.prepareStatement(sql)) {
            pStmt.setString(1, book.getTitle());
            pStmt.setString(2, book.getPublisher());
            pStmt.setString(3, book.getAuthors());
            pStmt.setString(4, book.getThumbnail());
            pStmt.setString(5, book.getIdentifier());
            pStmt.setString(6, book.getSelfLink());
            pStmt.setString(7, book.getDescription());
            pStmt.setInt(8, book.getFun());
            pStmt.setString(9, book.getSummary());
            pStmt.setBoolean(10, book.isAlreadyRead());
            pStmt.setInt(11, 1);

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

    public boolean updateDAO(String identifire, int fun, boolean alreadyRead, String summary) {
        int num;
        boolean bool = false;
        String sql = "UPDATE booklover SET fun =?,  alreadyRead =? ,summary=? WHERE identifier =?";
        try (Connection con = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS);
                PreparedStatement pStmt = con.prepareStatement(sql)) {

            // 数字変更
            pStmt.setInt(1, fun);
            pStmt.setBoolean(2, alreadyRead);
            pStmt.setString(3, summary);
            pStmt.setString(4, identifire);

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

    public List<Book> findTitleDAO(String word) {
        String sql = "SELECT * FROM booklover WHERE title like ?";
        Book book;
        List<Book> myList = new ArrayList<Book>();

        try (Connection con = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS);
                PreparedStatement pStmt = con.prepareStatement(sql)) {
            pStmt.setString(1, "%" + word + "%");
            ResultSet rs = pStmt.executeQuery();

            if (rs != null) {
                while (rs.next()) {
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

                    book = new Book(title, publisher, authors, thumbnail, identifierISBN, selfLink, description, fun,
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
