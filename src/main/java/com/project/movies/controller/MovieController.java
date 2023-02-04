package com.project.movies.controller;

import com.project.movies.model.Movie;
import com.project.movies.service.MovieService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin
@RestController
@RequestMapping("/api/v1/movies")
public class MovieController {

    @Autowired
    private MovieService movieService;
    @GetMapping()
    public ResponseEntity<List<Movie>> getAllMovies(){
        List<Movie> allMovies = movieService.getAllMovies();
        return new ResponseEntity<List<Movie>>(allMovies,HttpStatus.OK);
    }

//    @GetMapping("/{id}")
//    public ResponseEntity<Optional<Movie>> getSingleMovie(@PathVariable ObjectId id){
//        Optional<Movie> singleMovie = movieService.getSingleMovie(id);
//        return new ResponseEntity<Optional<Movie>>(singleMovie,HttpStatus.OK);
//    }

    @GetMapping("/{ImdbId}")
    public ResponseEntity<Optional<Movie>> getMovieByImdbId(@PathVariable String ImdbId){
        Optional<Movie> movieByImdb = movieService.getMovieByImdb(ImdbId);
        return new ResponseEntity<Optional<Movie>>(movieByImdb,HttpStatus.OK);
    }




}
