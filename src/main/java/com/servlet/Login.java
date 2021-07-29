package com.servlet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@WebServlet(
        description = "Login Servlet Testing",
        urlPatterns = {"/Login"}
)
public class Login extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //get request parameters for userId and password
        String user = request.getParameter("user");
        String pass = request.getParameter("pwd");

        String nameRegex = "^[A-Z][a-z]{3}";
        String passRegex = "(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&*-+=()]).{8,}$";

        if (validate(nameRegex,user) && validate(passRegex,pass)){
            request.setAttribute("user",user);
            request.getRequestDispatcher("LoginSuccess.jsp").forward(request,response);
        }else {
            RequestDispatcher requestDispatcher = request.getServletContext().getRequestDispatcher("login.html");
            PrintWriter printWriter = response.getWriter();
            printWriter.println("<h3>Invalid Credentials</h3>");
            requestDispatcher.include(request,response);
            printWriter.close();
        }
    }

    private boolean validate(String regex, String input) {
        Pattern pattern  = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);
        return matcher.matches();
    }
}
