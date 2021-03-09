package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.Book;
import dao.BookLoverDAO;
import model.SearchBooks;

@WebServlet("/Management")
public class Management extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public Management() {
        super();
        // TODO Auto-generated constructor

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // 取得文字列の文字エンコード指定
        request.setCharacterEncoding("UTF-8");

        //画面遷移後に表示するメッセージ
        String msg ="";

        // JSPページを呼び出すためのRequestDispatcher
        RequestDispatcher dispatcher = null;
        String forwardPath;

        String action = request.getParameter("action");
        String identifier = request.getParameter("identifier");
        String title = request.getParameter("title");

        List<Book> bookList = null;
        Book book = null;

        SearchBooks searchBooks = new SearchBooks();
        BookLoverDAO blDAO =new BookLoverDAO();

        // セッション作成
        request.setCharacterEncoding("UTF-8");
        HttpSession session = request.getSession();

        switch (action) {
        case "search":// 検索の時

            // identifierが入力されていたらidentifierで検索
            if (identifier != null && identifier.length() > 0) {
                book = blDAO.informationDAO(identifier);
                bookList.add(book);

            // identifierが無ければタイトルで検索
            } else if (title != null && title.length() > 0) {
                bookList = blDAO.findTitleDAO(title);
            }else {//入力が無ければ
                msg="入力がありませんでした";

            }

          //一つも見つからなければ
            if(bookList.size()<=0) {
                msg="検索結果が見つかりませんでした";
            }

            // セッションスコープに格納
            session.setAttribute("bookList", bookList);

            // フォワード先の指定
            forwardPath = "/WEB-INF/jsp/Management.jsp";

            break;

        case "edit":
            //book = blDAO.newBuyDAO();
            request.setAttribute("book", book);
            forwardPath = "/WEB-INF/jsp/edit.jsp";
            break;


            ////////ここからまだ作ってない


        case "delete":
            break;

        case "update":
            break;

        }

    }

}
