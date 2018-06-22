package service;

import dao.ExpenseDAO;
import model.Expense;

import java.sql.Date;
import java.util.List;

public class ExpenseService {

    public void addExpense(String name, String type, Date date, float value, String description, int userId){
        Expense expense = new Expense(name, value, type, description, date, userId);
        ExpenseDAO expenseDAO = new ExpenseDAO();
        expenseDAO.create(expense);
    }
    public Expense getExpense(int expenseId){
        ExpenseDAO expenseDAO = new ExpenseDAO();
        Expense expense = expenseDAO.read(expenseId);
        return expense;
    }
    public void updateExpense(Expense expense){
        ExpenseDAO expenseDAO = new ExpenseDAO();
        expenseDAO.update(expense);
    }
    public void deleteExpense(int expenseId){
        ExpenseDAO expenseDAO = new ExpenseDAO();
        expenseDAO.delete(expenseId);
    }
    public List<Expense> getAllExpenses(int userId){
        ExpenseDAO expenseDAO = new ExpenseDAO();
        List<Expense> expenseList = expenseDAO.getAll(userId);
        return expenseList;
    }
}
