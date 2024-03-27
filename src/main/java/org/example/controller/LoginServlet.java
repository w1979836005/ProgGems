package org.example.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.model.pojo.Result;
import org.example.service.UserService;
import org.example.service.impl.UserServiceImpl;
import org.example.util.JsonUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

            resp.setContentType("application/json");
            resp.setCharacterEncoding("UTF-8");

            ObjectMapper mapper = new ObjectMapper();


            String username = req.getParameter("username");
            String password = req.getParameter("password");

            System.out.println(username);
            System.out.println(password);

            UserService userService = new UserServiceImpl();
            Result result = userService.login(username,password);

            if(result.isSuccess()) {
                System.out.println("success");
                //
                String redirectURL = "http://localhost:8080/myApp_war/html/homepage.html";
                // 发送重定向响应
                resp.sendRedirect(redirectURL);
            } else {
                System.out.println("false");

                //重定向url
                String redirectURL = "http://localhost:8080/myApp_war/";
                // 发送重定向响应
                resp.sendRedirect(redirectURL);

            }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}
