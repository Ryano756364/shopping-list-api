package com.ryanpodell.shoppinglistapi;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/api/v1/items")  //request made to this point will be handled by this controller (instead of local host)
//First REST Api setup of program
public class ItemController {
    @Autowired
    private ItemService itemService;

    @GetMapping
    public ResponseEntity<List<Item>> getAllItems() {
        return new ResponseEntity<List<Item>>(itemService.allItems(), HttpStatus.OK);  //Task here is to get input from user and return response. No other concern here.
        // uses service level to grab data and return to API layer
    }

    @GetMapping("/{sku}") //search it by ID
    public ResponseEntity<Optional<Item>> getSingleItem(@PathVariable int sku) { //See service class on optional return
        return new ResponseEntity<Optional<Item>>(itemService.singleItem(sku), HttpStatus.OK);
    }
}
