package controller;

import model.User;
import service.ExpenseService;
import service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.sql.Date;

@WebServlet("/addExpense")
public class AddExpenseController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("WEB-INF/addExpense.jsp").forward(req,resp);
        req.setAttribute("dateFail", false);
        req.setAttribute("valueFail", false);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String name = req.getParameter("inputName");
        String type = req.getParameter("inputType");
        try {
            float value = Float.parseFloat(req.getParameter("inputValue"));
            String description = req.getParameter("inputDescription");
            String stringDate = req.getParameter("inputDate");
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            Date date = new Date(dateFormat.parse(stringDate).getTime());
            UserService userService = new UserService();
            User user = userService.getUser(req.getUserPrincipal().getName());
            int userId = user.getId();
            ExpenseService expenseService = new ExpenseService();
            expenseService.addExpense(name, type, date, value, description, userId);
            resp.sendRedirect("expenseList");
        } catch (ParseException e) {
            req.setAttribute("dateFail", true);
            req.getRequestDispatcher("WEB-INF/addExpense.jsp").forward(req,resp);
        } catch (NumberFormatException e){
            req.setAttribute("valueFail", true);
            req.getRequestDispatcher("WEB-INF/addExpense.jsp").forward(req,resp);
        }



    }
}
