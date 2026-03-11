package fr.simplon.controllers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import fr.simplon.models.Post;
import fr.simplon.models.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class Feed {
    @WebServlet("/feed")
    public class FeedController extends HttpServlet {

        @Override
        protected void doGet(HttpServletRequest req, HttpServletResponse resp)
                throws ServletException, IOException {

            // Vérification de session
            HttpSession session = req.getSession(false);
            if (session == null || session.getAttribute("currentUser") == null) {
                resp.sendRedirect(req.getContextPath() + "/login");
                return;
            }

            User currentUser = (User) session.getAttribute("currentUser");
            String feedType = req.getParameter("type");
            List<Post> posts = new ArrayList<>();

            if ("subscriptions".equals(feedType)) {
                // Récupérer les IDs des utilisateurs suivis
                List<Long> followedIds = new ArrayList<>();
                for (long[] follow : DataStore.follows) {
                    if (follow[0] == currentUser.getId()) {
                        followedIds.add(follow[1]);
                    }
                }
                // Garder seulement les posts de ces utilisateurs
                for (Post p : DataStore.posts) {
                    if (!p.isDraft() && followedIds.contains(p.getOwner().getId())) {
                        p.setLikeCount(countLikes(p.getId()));
                        posts.add(p);
                    }
                }
            } else {
                feedType = "recommendations";
                for (Post p : DataStore.posts) {
                    if (!p.isDraft()) {
                        p.setLikeCount(countLikes(p.getId()));
                        posts.add(p);
                    }
                }
            }

            // Tri du plus récent au plus vieux
            posts.sort(Comparator.comparing(Post::getCreatedAt).reversed());

            req.setAttribute("posts", posts);
            req.setAttribute("feedType", feedType);
            req.getRequestDispatcher("/views/feed.jsp").forward(req, resp);
        }

        /** Compte le nombre de likes d'un post depuis la liste DataStore.likes. */
        private int countLikes(long postId) {
            int count = 0;
            for (long[] like : DataStore.likes) {
                if (like[1] == postId)
                    count++;
            }
            return count;
        }
    }
}
