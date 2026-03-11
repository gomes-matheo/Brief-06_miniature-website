package fr.simplon.controllers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import fr.simplon.models.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet(name = "AuthController")

public class Login extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        HttpSession session = req.getSession(false);
        if (session != null && session.getAttribute("currentUser") != null) {
            resp.sendRedirect(req.getContextPath() + "/feed");
            return;
        }
        req.getRequestDispatcher("/index").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        String username  = req.getParameter("username");
        String password = req.getParameter("password");

        if (username == null || username.isBlank() || password == null || password.isBlank()) {
            req.setAttribute("error", "Email et mot de passe requis.");
            req.getRequestDispatcher("/index").forward(req, resp);
            return;
        }

        User found = null;
        for (User u : DataStore.users) {
            if (u.getUsername().equalsIgnoreCase(username)) {
                found = u;
                break;
            }
        }

        if (found == null || !BCrypt.checkpw(password, found.getPassword())) {
            req.setAttribute("error", "Identifiants invalides.");
            req.getRequestDispatcher("/index").forward(req, resp);
            return;
        }

        HttpSession old = req.getSession(false);
        if (old != null) old.invalidate();

        HttpSession session = req.getSession(true);
        session.setAttribute("currentUser", found);
        session.setMaxInactiveInterval(60 * 30);

        resp.sendRedirect(req.getContextPath() + "/feed");
    }
}

