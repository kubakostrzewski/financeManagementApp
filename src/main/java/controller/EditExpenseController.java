package controller;

import model.Expense;
import model.User;
import service.ExpenseService;
import service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

@WebServlet("/editExpense")
public class EditExpenseController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        ExpenseService expenseService = new ExpenseService();
        int expenseToEditId = Integer.parseInt(req.getParameter("expId"));
        Expense expenseToEdit = expenseService.getExpense(expenseToEditId);
            req.setAttribute("expense", expenseToEdit);
            req.getRequestDispatcher("WEB-INF/editExpense.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        ExpenseService expenseService = new ExpenseService();
        try {
            String expenseToEditId = req.getParameter("expId");
            Expense expenseToEdit = expenseService.getExpense(Integer.parseInt(expenseToEditId));
            expenseToEdit.setName(req.getParameter("inputName"));
            expenseToEdit.setValue(Float.parseFloat(req.getParameter("inputValue")));
            expenseToEdit.setType(req.getParameter("inputType"));
            expenseToEdit.setDescription(req.getParameter("inputDescription"));
            String stringDate = req.getParameter("inputDate");
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            Date date = new Date(dateFormat.parse(stringDate).getTime());
            expenseToEdit.setDate(date);
            expenseService.updateExpense(expenseToEdit);
            resp.sendRedirect("/expenseList");
        }catch (ParseException e) {
            req.setAttribute("dateFail", true);
            req.getRequestDispatcher("WEB-INF/editExpense.jsp").forward(req,resp);
        } catch (NumberFormatException e){
            req.setAttribute("valueFail", true);
            req.getRequestDispatcher("WEB-INF/editExpense.jsp").forward(req,resp);
        }

    }

}
