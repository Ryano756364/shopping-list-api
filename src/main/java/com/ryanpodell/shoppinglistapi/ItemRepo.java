package com.ryanpodell.shoppinglistapi;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository  //lets framework know this is a repository
public interface ItemRepo extends MongoRepository<Item, ObjectId> {
}
