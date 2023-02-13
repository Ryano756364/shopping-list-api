package com.ryanpodell.shoppinglistapi;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository  //lets framework know this is a repository
public interface ItemRepo extends MongoRepository<Item, ObjectId> {
    Optional<Item> findItemBySku(String sku);
}

// ItemRepo does all the talking with db and getting data back
// Data access layer for API
