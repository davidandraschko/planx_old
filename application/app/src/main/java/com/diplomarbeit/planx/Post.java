package com.diplomarbeit.planx;

import android.net.Uri;

import java.sql.Time;
import java.util.Date;

public class Post {

    private String caption;
    private String hashtagPreset;
    private String postDate;
    private String postTime;
    private Uri imageUri;
    private Boolean instagram;
    private Boolean facebook;
    private Boolean removeInstagram;
    private Boolean removeFacebook;

    public Post(String caption, String hashtagPreset, String postDate, String postTime, Boolean instagram, Boolean facebook, Boolean removeInstagram, Boolean removeFacebook, Uri imageUri) {
        this.caption = caption;
        this.hashtagPreset = hashtagPreset;
        this.postDate = postDate;
        this.postTime = postTime;
        this.instagram = instagram;
        this.facebook = facebook;
        this.removeInstagram = removeInstagram;
        this.removeFacebook = removeFacebook;
        this.imageUri = imageUri;
    }

    public Post(){

    }

    public Uri getImageUri() {
        return imageUri;
    }

    public void setImageUri(Uri imageUri) {
        this.imageUri = imageUri;
    }

    public String getCaption() {
        return caption;
    }

    public void setCaption(String caption) {
        this.caption = caption;
    }

    public String getHashtagPreset() {
        return hashtagPreset;
    }

    public void setHashtagPreset(String hashtagPreset) {
        this.hashtagPreset = hashtagPreset;
    }

    public String getPostDate() {
        return postDate;
    }

    public void setPostDate(String postDate) {
        this.postDate = postDate;
    }

    public String getPostTime() {
        return postTime;
    }

    public void setPostTime(String postTime) {
        this.postTime = postTime;
    }

    public Boolean getInstagram() {
        return instagram;
    }

    public void setInstagram(Boolean instagram) {
        this.instagram = instagram;
    }

    public Boolean getFacebook() {
        return facebook;
    }

    public void setFacebook(Boolean facebook) {
        this.facebook = facebook;
    }

    public Boolean getRemoveInstagram() {
        return removeInstagram;
    }

    public void setRemoveInstagram(Boolean removeInstagram) {
        this.removeInstagram = removeInstagram;
    }

    public Boolean getRemoveFacebook() {
        return removeFacebook;
    }

    public void setRemoveFacebook(Boolean removeFacebook) {
        this.removeFacebook = removeFacebook;
    }
}
