package com.volio.entity;

public class ItemNews {
    private int imgItemNews;
    private String txtContentNews,txtSpec,txtTimePostNews;

    public ItemNews(int imgItemNews, String txtContentNews, String txtSpec, String txtTimePostNews) {
        this.imgItemNews = imgItemNews;
        this.txtContentNews = txtContentNews;
        this.txtSpec = txtSpec;
        this.txtTimePostNews = txtTimePostNews;
    }

    public int getImgItemNews() {
        return imgItemNews;
    }

    public void setImgItemNews(int imgItemNews) {
        this.imgItemNews = imgItemNews;
    }

    public String getTxtContentNews() {
        return txtContentNews;
    }

    public void setTxtContentNews(String txtContentNews) {
        this.txtContentNews = txtContentNews;
    }

    public String getTxtSpec() {
        return txtSpec;
    }

    public void setTxtSpec(String txtSpec) {
        this.txtSpec = txtSpec;
    }

    public String getTxtTimePostNews() {
        return txtTimePostNews;
    }

    public void setTxtTimePostNews(String txtTimePostNews) {
        this.txtTimePostNews = txtTimePostNews;
    }
}
