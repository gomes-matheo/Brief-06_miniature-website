package fr.simplon.models;

import java.util.Date;

public class Post {
    private int id = 0;
    private int nbrPosts=0;
    private User owner;
    private Post parent;
    private String content;
    private Date createdAt;
    private boolean isDraft = false;
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public int getNbrPosts() {
        return nbrPosts;
    }
    public void setNbrPosts(int nbrPosts) {
        this.nbrPosts = nbrPosts;
    }
    public User getOwner() {
        return owner;
    }
    public void setOwner(User owner) {
        this.owner = owner;
    }
    public Post getParent() {
        return parent;
    }
    public void setParent(Post parent) {
        this.parent = parent;
    }
    public String getContent() {
        return content;
    }
    public void setContent(String content) {
        this.content = content;
    }
    public Date getCreatedAt() {
        return createdAt;
    }
    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }
    public boolean isDraft() {
        return isDraft;
    }
    public void setDraft(boolean isDraft) {
        this.isDraft = isDraft;
    }
    public void setLikeCount(int countLikes) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setLikeCount'");
    }
    
}
