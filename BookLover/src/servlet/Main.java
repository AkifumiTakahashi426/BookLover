package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.AccountDAO;
import dao.AccountRegisterDAO;
import model.User;

/**
 * Servlet implementation class Main
 */
@WebServlet("/Main")
public class Main extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public Main() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // TODO Auto-generated method stub
        // response.getWriter().append("Served at: ").append(request.getContextPath());
        String forwardPath = "";
        request.setCharacterEncoding("utf-8");
        String menu = request.getParameter("menu");
        HttpSession session = request.getSession();

        switch (menu) {
        case "4":
            forwardPath = "/WEB-INF/jsp/newUser.jsp";
            break;
        case "1":
            // register.jspの中でremoveAttribute()で実行
            forwardPath = "/WEB-INF/jsp/register.jsp";
            break;
        case "2":

            forwardPath = "/WEB-INF/jsp/management.jsp";
            break;
        case "3":

            forwardPath = "/WEB-INF/jsp/want.jsp";
        case "5"://ログアウト
            session.invalidate();
            forwardPath="/BookLover";
            break;
        default:

        }
        RequestDispatcher dispatcher = request.getRequestDispatcher(forwardPath);
        dispatcher.forward(request, response);

    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // TODO Auto-generated method stub
        // doGet(request, response);
        String forwardPath = "";
        request.setCharacterEncoding("utf-8");
        String menu = request.getParameter("menu");

        switch (menu) {
        case "1":
            // 入力されたnameとパスワードを取得
            String name = request.getParameter("userName");
            String pass = request.getParameter("pass");

            User ab = new User();
            ab.setName(name);
            ab.setPass(pass);
            AccountDAO ad = new AccountDAO();
            User returnAb = ad.findAccount(ab);
            if (returnAb != null) {
                HttpSession session = request.getSession();
                session.setAttribute("account", returnAb);
                // フォワード先(成功)
                forwardPath = "/WEB-INF/jsp/top.jsp";
            } else {
                // 失敗
                forwardPath = "/WEB-INF/jsp/loginError.jsp";
            }

            // ログイン処理

//            LoginLogic loginLogic = new LoginLogic();
//            boolean isLogin = loginLogic.execute(user);// isLoginにtrue or falseが入っている。
//
//            if (isLogin) {// isLoginがtrueなら中のtop.jspへフォワード。
//                forwardPath = "/WEB-INF/jsp/top.jsp";
//            } else {
//                forwardPath = "/WEB-INF/jsp/loginError.jsp";
//            }
            break;
        case "2":
            // 新規登録
            String userName = request.getParameter("userName");
            String newPass = request.getParameter("newPass");
            // jspから受けっとった値をBeans(User)にセット
            User abc=new User();
            abc.setName(userName);
            abc.setPass(newPass);

            AccountRegisterDAO ard=new AccountRegisterDAO(abc);
//            UserDAO userDAO=new UserDAO();
//            userDAO.Entry(userName,newPass);
            HttpSession session = request.getSession();
            session.setAttribute("userName", userName);
            session.setAttribute("newPass", newPass);
            forwardPath = "/WEB-INF/jsp/completion.jsp";

            break;
        case "3":
        default:

        }
        RequestDispatcher dispatcher = request.getRequestDispatcher(forwardPath);
        dispatcher.forward(request, response);
    }

}