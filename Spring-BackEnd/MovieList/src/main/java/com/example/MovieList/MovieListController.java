package com.example.MovieList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins  =  "http://localhost:3000")
public class MovieListController {
    @Autowired
    MovieListRepository repository;

    @GetMapping("movielist")
    public ResponseEntity<List<MovieList>> getMovieList(){
        return ResponseEntity.status(HttpStatus.OK).body(repository.findAll());
    }

    @GetMapping("movielist/{id}")
    public ResponseEntity<MovieList> getMovieById(@PathVariable String id){
        return ResponseEntity.status(HttpStatus.OK).body(repository.findMovieByid(Integer.parseInt(id)));
    }

    @GetMapping("/movielist/random")
    public ResponseEntity<MovieList> getRandomGreeting(){
        List<MovieList> movieList = repository.findAll();

        int randomNum = (int) Math.floor(Math.random() * movieList.size());

        return ResponseEntity.status(HttpStatus.OK).body(movieList.get(randomNum));
    }

    @PostMapping("/movie")
    public ResponseEntity<String>  createMovieListing(@RequestBody MovieList movieList){
        repository.save(movieList);
        return ResponseEntity.status(HttpStatus.CREATED).body(movieList.getMovieName() + " added!" );
    }   

    @DeleteMapping("/movielist/{id}")
    @Transactional
    public ResponseEntity<String> deleteGreeting(@PathVariable String id) {
        repository.deleteMovieByid(Integer.parseInt(id));
        return ResponseEntity.status(HttpStatus.OK).body("The Movie with ID" + id + "has been deleted.");
    }




}
