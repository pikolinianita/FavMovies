/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pl.lcc.web2.login;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 *
 * @author Teresa
 */

@WebFilter("/AuthenticationFilter")
public class AuthFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        Filter.super.init(filterConfig);
    }

    @Override
    public void doFilter(ServletRequest sr, ServletResponse sr1, FilterChain fc) throws IOException, ServletException {

        boolean userLogged = (((HttpServletRequest) sr).getSession().getAttribute("user") != null);
        boolean isLoginUri = ((HttpServletRequest) sr).getRequestURI().endsWith("login.xhtml");
        if ( userLogged || isLoginUri){
             fc.doFilter(sr, sr1);
        } else {
           ((HttpServletResponse) sr1).sendRedirect("login.xhtml");
        }
    }

    @Override
    public void destroy() {
        Filter.super.destroy();
    }

}
