package fr.simplon.controller;

import java.io.IOException;
import java.net.http.HttpRequest;
import java.util.ArrayList;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import fr.simplon.models.User;

@WebServlet("/register")
public class registerController extends HttpServlet {

    @Override
    public void init() throws ServletException {
        List<User> users = new ArrayList<>();
    }
    
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String username = req.getParameter("username");
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        String passwordConfirm = req.getParameter("password-confirm");

        /*switch (req) {
            case String u when username == null -> System.err.println("Username cannot be empty");
            default -> System.out.println("test");
        }*/

        if (username == null) {
            System.err.println("Invalid username");
            return;
        }

        if (!password.equals(passwordConfirm)) {
            System.err.println("Passwords must be the same");
            return;
        }

        User newUser = new User(username, password, email);
        newUser.getId();

        User.showAllUsers();

        HttpSession session = req.getSession();
        session.setAttribute("usersession", newUser);
        resp.sendRedirect("/index.jsp");
    }
}