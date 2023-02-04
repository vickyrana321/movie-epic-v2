package com.project.movies.service;

import com.project.movies.model.Movie;
import com.project.movies.repository.MovieRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MovieService {

    @Autowired
    private MovieRepository movieRepository;

    public List<Movie> getAllMovies(){
        return movieRepository.findAll();
    }

    public Optional<Movie> getSingleMovie(ObjectId id) {
        Optional<Movie> moviesById = movieRepository.findById(id);
        return moviesById;
    }

    public Optional<Movie> getMovieByImdb(String imdbdId) {
        Optional<Movie> moviesById = movieRepository.findMovieByImdbId(imdbdId);
        return moviesById;
    }
}
