package fr.simplon.models;

import java.util.ArrayList;
import java.util.List;

public class User {
    private static int nbUsers = 0;
    private static List<User> allUsers = new ArrayList<>();

    private String username;
    private String password;
    private String email;

    private int id;

    private List<User> followed;
    private List<Post> posts;

    public User(String username, String password, String email) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.id = ++nbUsers;
        allUsers.add(this);
    }

    public int getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getNbUsers() {
        return nbUsers;
    }

    public void setNbUsers(int nbUsers) {
        this.nbUsers = nbUsers;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<User> getFollowed() {
        return followed;
    }

    public void setFollowed(List<User> followed) {
        this.followed = followed;
    }

    public List<Post> getPosts() {
        return posts;
    }

    public void setPosts(List<Post> posts) {
        this.posts = posts;
    }

    public static void showAllUsers() {
        for (User user : allUsers) {
            System.out.println("User : " + user.username + " | ID : " + user.id);
        }
    }
}
