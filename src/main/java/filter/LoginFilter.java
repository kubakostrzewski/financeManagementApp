package filter;

import model.User;
import service.UserService;

import javax.jws.soap.SOAPBinding;
import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

public class LoginFilter implements Filter {


    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest servletRequest = (HttpServletRequest) request;
        if (servletRequest.getUserPrincipal()!= null && servletRequest.getSession().getAttribute("user") == null){
            saveUserInSession(servletRequest);
        }
        chain.doFilter(request,response);
    }
    private void saveUserInSession(HttpServletRequest servletRequest){
        UserService userService = new UserService();
        String username = servletRequest.getUserPrincipal().getName();
        User user = userService.getUser(username);
        servletRequest.getSession(true).setAttribute("user", user);
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }
    @Override
    public void destroy() {

    }
}
