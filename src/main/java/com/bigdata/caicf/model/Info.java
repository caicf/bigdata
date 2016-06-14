package com.bigdata.caicf.model;

/**
 * Created by caicf on 2016/6/14.
 */
public class Info {
    private int id;
    private String breadcrumbText;
    private String movieName;
    private String comments;
    private String playtimes;
    private String tags;
    private String director;
    private String starring;
    private String summary;

    public Info() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBreadcrumbText() {
        return breadcrumbText;
    }

    public void setBreadcrumbText(String breadcrumbText) {
        this.breadcrumbText = breadcrumbText;
    }

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public String getPlaytimes() {
        return playtimes;
    }

    public void setPlaytimes(String playtimes) {
        this.playtimes = playtimes;
    }

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getStarring() {
        return starring;
    }

    public void setStarring(String starring) {
        this.starring = starring;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }
}
