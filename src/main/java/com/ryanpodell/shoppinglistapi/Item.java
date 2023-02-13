package com.ryanpodell.shoppinglistapi;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;

import java.util.List;

@Document(collection = "items")
@Data //takes care of getters, setters, and toString methods
@AllArgsConstructor //takes care of constructor that takes all fields
@NoArgsConstructor //takes care of no param constructor
public class Item {

    @Id // lets db know that the 'id' is unique identifier in db
    private ObjectId id;
    private String StringId;
    private String sku;
    private String name;
    private List<String> brand;
    private String price;
    private String picture;
    private List<String> category;
    @DocumentReference  //stores only id of reviews and will be in separate collection -> manual ref relationship
    private List<Review> reviewIds;  //embedded relationship with one to many setup in db
    private String description;
    private String weightInGrams;
}
