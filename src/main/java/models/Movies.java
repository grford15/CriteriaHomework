package models;

import javax.persistence.*;

@Entity
@Table(name="movies")
public class Movies {

    private int id;
    private String title;
    private int yearRealesed;
    private String genre;

    public Movies(){}

    public Movies(String title, int yearRealesed, String genre) {
        this.title = title;
        this.yearRealesed = yearRealesed;
        this.genre = genre;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Column(name="title")

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Column(name="year_realesed")

    public int getYearRealesed() {
        return yearRealesed;
    }

    public void setYearRealesed(int yearRealesed) {
        this.yearRealesed = yearRealesed;
    }

    @Column(name="genre")

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }
}
