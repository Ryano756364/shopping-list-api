package com.ryanpodell.shoppinglistapi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

@Service
public class ReviewService {

    @Autowired
    private ReviewRepo reviewRepo;
    @Autowired
    private MongoTemplate mongoTemplate; //Another way to talk to DB other than repository
    public Review createReview(String reviewBody, String sku) {
        //first find the sku, then create review based on found item
        Review review = reviewRepo.insert(new Review(reviewBody));  //returns data we just pushed into db

        mongoTemplate.update(Item.class)
                .matching(Criteria.where("sku").is(sku))
                .apply(new Update().push("reviews").value(review))
                .first();

        return review;
    }
}