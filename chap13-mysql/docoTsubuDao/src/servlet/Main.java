package servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.GetMutterListLogic;
import model.Mutter;
import model.PostMutterLogic;
import model.User;

@WebServlet("/Main")
public class Main extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet (HttpServletRequest request,
                          HttpServletResponse response)
        throws ServletException, IOException {

        // つぶやきリストを取得して、リクエストスコープに保存
        GetMutterListLogic getMutterListLogic =
             new GetMutterListLogic();
        List<Mutter> mutterList = getMutterListLogic.execute();
        request.setAttribute("mutterList", mutterList);
        if (mutterList.size() > 0) {
            System.out.println("空ではない!");
        }

        // セッションスコープからユーザー情報(loginUser)を取得
        HttpSession session = request.getSession();
        User loginUser = (User) session.getAttribute("loginUser");

        if (loginUser == null) {
            // ユーザー情報が空なら新規作成画面へリダイレクト
            response.sendRedirect("/docoTsubuDao");
        } else {
            RequestDispatcher dispatcher =
                request.getRequestDispatcher("/WEB-INF/jsp/main.jsp");
            dispatcher.forward( request, response );
        }
    }

    @SuppressWarnings("unchecked")
    public static List<Mutter> automaticCast( Object src ) {
        List<Mutter> castedObject = (List<Mutter>) src;
        return castedObject;
    }

    protected void doPost (HttpServletRequest request,
                           HttpServletResponse response)
        throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");
        String text = request.getParameter("text");

        // check
        if (text != null && text.length() != 0) {

            // User info
            HttpSession session = request.getSession();
            User loginUser = (User) session.getAttribute("loginUser");

            // added Tsubuyaki List
            Mutter mutter = new Mutter( loginUser.getName(), text );
            PostMutterLogic postMutterLogic = new PostMutterLogic();
            postMutterLogic.execute(mutter);
            
        } else {
            // textが 空だった場合
            request.setAttribute("errorMsg", "つぶやきが入力されていません");
        }

        GetMutterListLogic getMutterListLogic =
            new GetMutterListLogic ();
        List<Mutter> mutterList = getMutterListLogic.execute();
        request.setAttribute("mutterList", mutterList);

        // forward to main
        RequestDispatcher dispatcher =
            request.getRequestDispatcher("/WEB-INF/jsp/main.jsp");
        dispatcher.forward( request, response );
    }
}

// 修正時刻： Sat Jul  4 09:13:42 2020
