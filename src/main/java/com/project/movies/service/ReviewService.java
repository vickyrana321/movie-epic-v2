package com.project.movies.service;

import com.project.movies.model.Movie;
import com.project.movies.model.Review;
import com.project.movies.repository.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

@Service
public class ReviewService {

    @Autowired
    private ReviewRepository reviewRepository;

    @Autowired
    private MongoTemplate mongoTemplate;
    public Review createReview(String reviewBody,String imdbId){
        //first look for the movie with the given imdbId and then create new review and associate that review with
        //found movie.
        Review review=reviewRepository.insert(new Review(reviewBody));

        //Here we are updating the Movie class where imdbId of movie in database matches with imdbdId provided
        //by the user then we apply the update and it will be pushed in reviewIds array and value will be review objects
        mongoTemplate.update(Movie.class)
                .matching(Criteria.where("imdbId").is(imdbId))
                .apply(new Update().push("reviews").value(review))
                .first();
        return review;
    }
}
