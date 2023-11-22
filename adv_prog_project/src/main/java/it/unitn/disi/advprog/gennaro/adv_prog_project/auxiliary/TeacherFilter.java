package it.unitn.disi.advprog.gennaro.adv_prog_project.auxiliary;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

public class TeacherFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        Filter.super.init(filterConfig);
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
            throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) servletRequest;
        HttpSession session = httpRequest.getSession();
        session.getAttribute("userAccountDto");
        if(session.getAttribute("userAccountDto") == null) {
            RequestDispatcher rd = httpRequest.getRequestDispatcher("LoginServlet");
            rd.forward(servletRequest, servletResponse);
        }
        else {
            String role = (String) session.getAttribute("role");
            if(role.equals("teacher")) {
                filterChain.doFilter(servletRequest, servletResponse);
            }
            else {
                RequestDispatcher rd = httpRequest.getRequestDispatcher("LoginServlet");
                rd.forward(servletRequest, servletResponse);
            }
        }
    }

    @Override
    public void destroy() {
        Filter.super.destroy();
    }
}
