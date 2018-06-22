package controller;

import model.Expense;
import model.User;
import org.springframework.dao.EmptyResultDataAccessException;
import service.ExpenseService;
import service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/deleteExpense")
public class DeleteExpenseController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        ExpenseService expenseService = new ExpenseService();
        int expenseToDeleteId = Integer.parseInt(req.getParameter("expId"));
        expenseService.deleteExpense(expenseToDeleteId);
        resp.sendRedirect("expenseList");

    }
}
