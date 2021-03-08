package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.Book;
import dao.BookLoverDAO;
import googleBooksAPI.googleSearch;

/**
 * Servlet implementation class Control
 */
@WebServlet("/Register")
public class Register extends HttpServlet implements EnvSet {
    private static final long serialVersionUID = 1L;

    public Register() {
        super();
        // TOD Auto-generated constructor stub
    }

    public void init(ServletConfig config) throws ServletException {
        // proxyの設定
        System.setProperty("https.proxyHost", J504_HTTPS_PROXY_ADDRESS);
        System.setProperty("https.proxyPort", J504_HTTPS_PROXY_PORT);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // TODO Auto-generated method stub
        response.getWriter().append("Served at: ").append(request.getContextPath());
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // 取得文字列の文字エンコード指定
        request.setCharacterEncoding("UTF-8");

        // JSPページを呼び出すためのRequestDispatcher
        RequestDispatcher dispatcher = null;
        String forwardPath;

        String action = request.getParameter("action");
        String identifier = request.getParameter("identifier");
        String title = request.getParameter("title");

        googleSearch search = new googleSearch();

        BookLoverDAO bookLoverDAO = new BookLoverDAO();


        switch (action) {
        case "search":

            //ちゃんと検索出来てたらここに配列で検索結果が入る
            List<Book> bookList =search.search(identifier,title) ;


                // セッション作成
                request.setCharacterEncoding("UTF-8");
                HttpSession session = request.getSession();

                // disp.jspへ渡すデータを格納
                session.setAttribute("bookList", bookList);


            dispatcher = request.getRequestDispatcher("/WEB-INF/Register.jsp");
            break;



            /////////

            //サーチをメソッド分けして外に出してる。
            //検索がちゃんとできるかの確認と、
            //buyがちゃんと動くかの確認。

            ////////

        ///////////////// ↑search↑//////////////
        ////////
        ////////
        ////////
        ////////
        ///////////////// ↓buy↓/////////////////

        case "buy":


//boolean done = bookLoverDAO.newBuyDAO(identifier);

            break;

        case "want":
            break;

        default:
            // NOT REACHED
        }

        // フォワード先へフォワードする
        dispatcher.forward(request, response);
    }

}
