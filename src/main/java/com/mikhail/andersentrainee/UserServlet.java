package com.mikhail.andersentrainee;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/")
public class UserServlet extends HttpServlet {
    private static final UserDAO userDAO = UserDAO.getInctance();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("users", userDAO.findAll());
        req.getRequestDispatcher("WEB-INF/index.jsp")
                .forward(req, resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        User user = User.builder()
                .id(0)
                .firstName(req.getParameter("firstName"))
                .lastName(req.getParameter("lastName"))
                .age(Integer.valueOf(req.getParameter("age")))
                .build();
        userDAO.save(user);
    }
}
