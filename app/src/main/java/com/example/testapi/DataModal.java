package com.example.testapi;

public class DataModal {
    private int postID;
    private String postTitle, postBody;

    public DataModal(int postID, String postTitle, String postBody) {
        this.postID = postID;
        this.postTitle = postTitle;
        this.postBody = postBody;
    }

    public int getPostID() {
        return postID;
    }

    public void setPostID(int postID) {
        this.postID = postID;
    }

    public String getPostTitle() {
        return postTitle;
    }

    public void setPostTitle(String postTitle) {
        this.postTitle = postTitle;
    }

    public String getPostBody() {
        return postBody;
    }

    public void setPostBody(String postBody) {
        this.postBody = postBody;
    }
}