package com.ryanpodell.shoppinglistapi;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class ItemService {
    @Autowired //lets framework know we want it to instantiate class for us
    private ItemRepo itemRepo;
    public List<Item> allItems() {
        return itemRepo.findAll(); //.findAll() is described inside MongoRepository class
    }

    public Optional<Item> singleItem(int sku) {  //returning optional here in the even and id doesn't exist in db
        return itemRepo.findItemBySku(sku);
    }
}

//This class will hold db access methods. Most business logic goes here.
