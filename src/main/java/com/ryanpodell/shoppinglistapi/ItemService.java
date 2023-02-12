package com.ryanpodell.shoppinglistapi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemService {  //This class will hold db access methods
    @Autowired //lets framework know we want it to instantiate class for us
    private ItemRepo itemRepo;
    public List<Item> allItems() {
        return itemRepo.findAll(); //.findAll() is described inside MongoRepository class
    }
}
