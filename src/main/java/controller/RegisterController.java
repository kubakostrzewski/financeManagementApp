package controller;

import org.springframework.dao.DuplicateKeyException;
import service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/register")
public class RegisterController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.getRequestDispatcher("WEB-INF/register.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.setAttribute("duplicate", false);
        req.setAttribute("passMatch", false);
        req.setAttribute("passTooShort", false);
        req.setCharacterEncoding("UTF-8");
        String username = req.getParameter("inputName");
        String password = req.getParameter("inputPassword");
        String passwordConfirm = req.getParameter("inputPasswordConfirm");

         if(password.length()<6){
            req.setAttribute("passTooShort", true);
            req.setAttribute("name", username);
            req.getRequestDispatcher("WEB-INF/register.jsp").forward(req, resp);
        }else if (password.equals(passwordConfirm)) {
            UserService userService = new UserService();
            try {
                userService.addUser(username, password);
                req.getRequestDispatcher("WEB-INF/registrationSuccess.jsp").forward(req, resp);
            } catch (DuplicateKeyException dke) {
                req.setAttribute("duplicate", true);
                req.setAttribute("name", username);
                req.getRequestDispatcher("WEB-INF/register.jsp").forward(req, resp);
            }
        }else {
            req.setAttribute("passMatch", true);
             req.setAttribute("name", username);
            req.getRequestDispatcher("WEB-INF/register.jsp").forward(req,resp);
        }
    }


}
