package sg.edu.rp.c346.id21013643.problemstatementl09;

import java.io.Serializable;

public class Song implements Serializable {
    private String title;
    private String singers;
    private int year;
    private int stars;
    private int id;


    public Song(int id, String title, String singers, int year, int stars) {
        this.id = id;
        this.title = title;
        this.singers = singers;
        this.year = year;
        this.stars = stars;
    }

    public String getTitle() {
    return title;
    }

    public String getSingers() {
    return singers;
    }

    public int getYearReleased() {
        return year;
    }

    public int getStars() {
        return stars;
    }

    public int getId() {
        return id;
    }

    public void setTitle(String trim) {
    }

    public void setSingers(String trim) {
    }

    public void setYearReleased(int year) {
    }

    public void setStars(int rating) {
    }
}
