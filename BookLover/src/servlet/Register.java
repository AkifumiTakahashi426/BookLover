package servlet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import beans.Book;
import model.SearchBooks;

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

        //書籍検索用モデルのインスタンス生成
        SearchBooks searchBooks = new SearchBooks();

        // actionの文字列により分岐。
        switch (action) {
        case "search":
         // セッション作成
            request.setCharacterEncoding("UTF-8");
            HttpSession session = request.getSession();
            try {
                List<Book> bookList=searchBooks.searchBooks(identifier, title);


                // disp.jspへ渡すデータを格納
                session.setAttribute("bookList", bookList);

            } catch (Exception e) {
                // 例外発生時、error.jspへフォワードする
                request.setAttribute("error", e.toString());
                forwardPath = "/error.jsp";
                dispatcher = request.getRequestDispatcher(forwardPath);

             }
            dispatcher = request.getRequestDispatcher("/WEB-INF/Register.jsp");
            break;

        ///////////////// ↑search↑//////////////
        ////////
        ////////
        ////////
        ////////
        ///////////////// ↓buy↓/////////////////

        case "buy":
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
