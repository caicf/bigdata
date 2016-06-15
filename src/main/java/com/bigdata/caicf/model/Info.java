package com.bigdata.caicf.model;

public class Info {
    private Integer id;

    private String breadcrumbtext;

    private String moviename;

    private String comments;

    private String playtimes;

    private String tags;

    private String director;

    private String starring;

    private String summary;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBreadcrumbtext() {
        return breadcrumbtext;
    }

    public void setBreadcrumbtext(String breadcrumbtext) {
        this.breadcrumbtext = breadcrumbtext == null ? null : breadcrumbtext.trim();
    }

    public String getMoviename() {
        return moviename;
    }

    public void setMoviename(String moviename) {
        this.moviename = moviename == null ? null : moviename.trim();
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments == null ? null : comments.trim();
    }

    public String getPlaytimes() {
        return playtimes;
    }

    public void setPlaytimes(String playtimes) {
        this.playtimes = playtimes == null ? null : playtimes.trim();
    }

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags == null ? null : tags.trim();
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director == null ? null : director.trim();
    }

    public String getStarring() {
        return starring;
    }

    public void setStarring(String starring) {
        this.starring = starring == null ? null : starring.trim();
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary == null ? null : summary.trim();
    }
}