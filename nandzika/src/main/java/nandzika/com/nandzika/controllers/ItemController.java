package nandzika.com.nandzika.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import nandzika.com.nandzika.entities.Item;
import nandzika.com.nandzika.repositories.ItemRepository;

@RestController
public class ItemController {
    
    @Autowired
    private ItemRepository repository;

    @PostMapping("/items")
    public ResponseEntity<Item> saveItem(@RequestBody Item item){

        return new ResponseEntity<>(repository.save(item), HttpStatus.CREATED);
    }

    @GetMapping("/items")
    public ResponseEntity<List<Item>> listItems(){

        return new ResponseEntity<>(repository.findAll(), HttpStatus.OK);
    }

    @GetMapping("items/{id}")
    public ResponseEntity<Item> getItem(@RequestParam (name = "id") Integer id){

        return new ResponseEntity<>(repository.findById(id).get(), HttpStatus.OK);
    }
} 
