package com.example.MovieList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovieListRepository extends JpaRepository<MovieList, String> {


    MovieList findMovieByid(int id);

    String deleteMovieByid(int id);


}
