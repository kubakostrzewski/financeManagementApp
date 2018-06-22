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
        UserService userService = new UserService();
        ExpenseService expenseService = new ExpenseService();

        String activeUserName = req.getUserPrincipal().getName();
        User activeUser = userService.getUser(activeUserName);
        int expenseToDeleteId = Integer.parseInt(req.getParameter("delExpId"));
        try {
            Expense expenseToDelete = expenseService.getExpense(expenseToDeleteId);
            if (activeUser.getId() == expenseToDelete.getUserId()){
                expenseService.deleteExpense(expenseToDeleteId);
                resp.sendRedirect("expenseList");
            }else {
                resp.sendError(403);
            }
        }catch (EmptyResultDataAccessException e){
            resp.sendError(400);
        }

    }
}
