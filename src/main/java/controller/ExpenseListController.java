package controller;

import dao.UserDAO;
import model.Expense;
import model.User;
import service.ExpenseService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/expenseList")
public class ExpenseListController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String username = req.getUserPrincipal().getName();
        User user = new UserDAO().getUserByUsername(username);
        List<Expense> expenseList = new ExpenseService().getAllExpenses(user.getId());
        req.setAttribute("expenses", expenseList);
        req.getRequestDispatcher("WEB-INF/expenseList.jsp").forward(req,resp);

    }
}
