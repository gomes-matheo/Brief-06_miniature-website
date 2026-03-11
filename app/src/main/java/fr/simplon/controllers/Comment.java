package fr.simplon.controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;

import fr.simplon.models.User;
import fr.simplon.models.*;
@WebServlet("/comment")
public class Comment extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        HttpSession session = req.getSession(false);
        if (session == null || session.getAttribute("currentUser") == null) {
            resp.sendRedirect(req.getContextPath() + "/login");
            return;
        }

        User currentUser = (User) session.getAttribute("currentUser");
        String postIdParam = req.getParameter("postId");
        String content = req.getParameter("content");

        if (postIdParam == null || content == null || content.isBlank()) {
            resp.sendRedirect(req.getContextPath() + "/feed");
            return;
        }

        long postId = Long.parseLong(postIdParam);
        Comment comment = new Comment();
        comment.setId(++DataStore.commentIdSeq);
        DataStore.comments.add(comment);

        resp.sendRedirect(req.getContextPath() + "/post?id=" + postId);
    }

    private void setId(long l) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setId'");
    }
}
