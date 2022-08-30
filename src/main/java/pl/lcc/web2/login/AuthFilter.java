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
//https://www.digitalocean.com/community/tutorials/java-servlet-filter-example-tutorial
@WebFilter("/AuthenticationFilter")
public class AuthFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        Filter.super.init(filterConfig);
        System.out.println("Filter Started");
    }

    @Override
    public void doFilter(ServletRequest sr, ServletResponse sr1, FilterChain fc) throws IOException, ServletException {
        System.out.println("Filter Filtering");

        //((HttpServletRequest) sr).getSession().getAttributeNames().asIterator().forEachRemaining(System.out::println);
        var userLogged = !(((HttpServletRequest) sr).getSession().getAttribute("user") == null);
        System.out.println(((HttpServletRequest) sr).getRequestURI());
        var isLoginUri = ((HttpServletRequest) sr).getRequestURI().endsWith("login.xhtml");
        if ( userLogged || isLoginUri){
             fc.doFilter(sr, sr1);
        } else {
           ((HttpServletResponse) sr1).sendRedirect("login.xhtml");
        }
    }

    @Override
    public void destroy() {
        System.out.println("Filter Will  Stop");
        Filter.super.destroy();
    }

}
