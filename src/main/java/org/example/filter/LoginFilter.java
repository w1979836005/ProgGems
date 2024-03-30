package org.example.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

@WebFilter("/*") // 应用到 /secure/ 路径下的所有请求
public class LoginFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        // 初始化方法，可以在这里进行一些初始设置
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {

        System.out.println("filter");
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpServletResponse httpResponse = (HttpServletResponse) response;

        String []urls = {"/myApp_war/","/js/","/myApp_war/image/1.jpg","/myApp_war/css/81.css","/myApp_war/login","/myApp_war/register"};
        String url = ((HttpServletRequest) request).getRequestURI();
        System.out.println(url);

        for(String u:urls) {
            if(url.equals(u))  {
                chain.doFilter(request,response);
                return;
            }
        }
        // 检查用户是否已登录，这里假设是通过 Session 来检查的
        if (httpRequest.getSession().getAttribute("user") == null) {
            System.out.println("重定向");
            // 用户未登录，重定向到登录页面
            httpResponse.sendRedirect(httpRequest.getContextPath() );
        } else {
            System.out.println(httpRequest.getSession().getAttribute("user"));
            // 用户已登录，继续处理请求
            chain.doFilter(request, response);
        }
    }

    @Override
    public void destroy() {
        // 销毁方法，在 Filter 生命周期结束时调用
    }
}
