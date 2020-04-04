package com.volio.entity;

public class ItemVideo {
    private int imgItemVideo;
    private String txtNameVideo, txtAuthor,txtView,txtTimePost,txtTimeVideo,txtTimeVideoFake;

    public ItemVideo(int imgItemVideo, String txtNameVideo, String txtAuthor, String txtView, String txtTimePost, String txtTimeVideo, String txtTimeVideoFake) {
        this.imgItemVideo = imgItemVideo;
        this.txtNameVideo = txtNameVideo;
        this.txtAuthor = txtAuthor;
        this.txtView = txtView;
        this.txtTimePost = txtTimePost;
        this.txtTimeVideo = txtTimeVideo;
        this.txtTimeVideoFake = txtTimeVideoFake;
    }

    public int getImgItemVideo() {
        return imgItemVideo;
    }

    public void setImgItemVideo(int imgItemVideo) {
        this.imgItemVideo = imgItemVideo;
    }

    public String getTxtNameVideo() {
        return txtNameVideo;
    }

    public void setTxtNameVideo(String txtNameVideo) {
        this.txtNameVideo = txtNameVideo;
    }

    public String getTxtAuthor() {
        return txtAuthor;
    }

    public void setTxtAuthor(String txtAuthor) {
        this.txtAuthor = txtAuthor;
    }

    public String getTxtView() {
        return txtView;
    }

    public void setTxtView(String txtView) {
        this.txtView = txtView;
    }

    public String getTxtTimePost() {
        return txtTimePost;
    }

    public void setTxtTimePost(String txtTimePost) {
        this.txtTimePost = txtTimePost;
    }

    public String getTxtTimeVideo() {
        return txtTimeVideo;
    }

    public void setTxtTimeVideo(String txtTimeVideo) {
        this.txtTimeVideo = txtTimeVideo;
    }

    public String getTxtTimeVideoFake() {
        return txtTimeVideoFake;
    }

    public void setTxtTimeVideoFake(String txtTimeVideoFake) {
        this.txtTimeVideoFake = txtTimeVideoFake;
    }
}
