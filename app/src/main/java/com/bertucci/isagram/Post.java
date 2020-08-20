package com.bertucci.isagram;

import android.graphics.drawable.Drawable;

public class Post {
    String userName;
    String description;
    int imagePost;

    public Post(String userName, String description, int image) {
        this.userName = userName;
        this.description = description;
        this.imagePost = image;
    }
}
