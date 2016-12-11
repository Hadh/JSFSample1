package com.jsf.filters;

import com.jsf.hello.Student;

import java.io.IOException;
import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by HDMI on 12/11/2016.
 */
public class LoginFilter implements javax.servlet.Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        Student session = (Student) request.getSession().getAttribute("student");
        String url = request.getRequestURI();

        if(session == null || !session.isLogged){
            if(url.indexOf("forum.xhtml")>=0 || url.indexOf("logout.xhtml")>= 0){
                response.sendRedirect(request.getServletContext().getContextPath()+ "/login.xhtml");
            }
            else {
                filterChain.doFilter(servletRequest,servletResponse);
            }
        } else {
            if(url.indexOf("register.xhtml")>=0 || url.indexOf("login.xhtml")>= 0){
                response.sendRedirect(request.getServletContext().getContextPath()+ "/forum.xhtml");
            }
            else if(url.indexOf("logout.xhtml")>=0){
                request.getSession().removeAttribute("student");
                response.sendRedirect(request.getServletContext().getContextPath()+ "/login.xhtml");
            } else {
                filterChain.doFilter(servletRequest,servletResponse);
            }
        }
    }

    @Override
    public void destroy() {
    }
}
