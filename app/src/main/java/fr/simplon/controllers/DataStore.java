package fr.simplon.controllers;

import java.util.ArrayList;
import java.util.List;



import fr.simplon.models.Post;
import fr.simplon.models.User;

public class DataStore {
    public static final List<User> users = new ArrayList<>();
    public static final List<Post> posts = new ArrayList<>();
    public static final List<Comment> comments = new ArrayList<>();

    public static final List<long[]> likes = new ArrayList<>();

    public static final List<long[]> follows = new ArrayList<>();

    public static long userIdSeq = 0;
    public static long postIdSeq = 0;
    public static long commentIdSeq = 0;

     private DataStore() {
    }
}
