package com.example.MovieList;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class MovieList {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private int id;
    private String imageURL;
    private String movieName;
    private String releaseDate;
    private double rating;
    private int dateCreated;

    public MovieList() {
        this.dateCreated = 14/01/2022;

    }

    public MovieList(String imageURL, String movieName, String releaseDate, double rating) {
        this.imageURL = imageURL;
        this.movieName = movieName;
        this.releaseDate = releaseDate;
        this.rating = rating;
    }




    public String getImageURL() {
        return imageURL;
    }

    public String getMovieName() {
        return movieName;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public double getRating() {
        return rating;
    }
}
