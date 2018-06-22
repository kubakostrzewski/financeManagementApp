package filter;

import model.Expense;
import model.User;
import service.ExpenseService;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AccessFilter implements Filter {


    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        User user = (User) req.getSession().getAttribute("user");
        ExpenseService expenseService = new ExpenseService();
        int expenseId = Integer.parseInt(req.getParameter("expId"));
        Expense expense = expenseService.getExpense(expenseId);
        if (user.getId() == expense.getUserId()){
            chain.doFilter(request,response);
        }else {
            HttpServletResponse resp = (HttpServletResponse)response;
            resp.sendError(403);
        }
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }
    @Override
    public void destroy() {

    }
}
