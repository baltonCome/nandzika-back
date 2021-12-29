package nandzika.com.nandzika.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import nandzika.com.nandzika.entities.OrderedItem;
import nandzika.com.nandzika.repositories.ItemRepository;
import nandzika.com.nandzika.repositories.OrderRepository;
import nandzika.com.nandzika.repositories.OrderedItemRepository;

@RestController
public class OrderedItemController {
    

    @Autowired
    private OrderedItemRepository oItemRepo;
    
    @Autowired 
    private OrderRepository orderRepo;

    @Autowired
    private ItemRepository itemRepo;
   
    @PostMapping("/orderedItems")
    public ResponseEntity<OrderedItem> saveOrderedItem(@RequestBody OrderedItem orderedItem){

        return new ResponseEntity<>(oItemRepo.save(orderedItem), HttpStatus.CREATED);
    }

    @PutMapping("/orderedItems/{orderedItemId}/order/{orderId}/item/{itemId}")
    public ResponseEntity<OrderedItem> attachOrderAndItem(@PathVariable Integer orderedItemId, @PathVariable Integer orderId, @PathVariable Integer itemId){

        OrderedItem oItem = oItemRepo.findById(orderedItemId).get();

        if(orderRepo.findById(orderId).get() == null || itemRepo.findById(itemId).get() == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }else{
            oItem.setOrder(orderRepo.findById(orderId).get());
            oItem.setItem(itemRepo.findById(itemId).get());
            return new ResponseEntity<>(oItemRepo.save(oItem), HttpStatus.OK);
        }
    }

    @GetMapping("/orderedItems")
    public ResponseEntity<List<OrderedItem>> getAllOrderedItems(){

        List<OrderedItem> orderedItemsList = oItemRepo.findAll();
        if(orderedItemsList.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }else{
            return new ResponseEntity<>(orderedItemsList, HttpStatus.OK);
        }
    }

    @GetMapping("/orderedItems/{id}")
    public ResponseEntity<OrderedItem> getOne(@PathVariable Integer id){

        Optional<OrderedItem> orderedItem = oItemRepo.findById(id);
        if(!orderedItem.isPresent()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }else{
            return new ResponseEntity<OrderedItem>(orderedItem.get(), HttpStatus.OK);
        }
    }

}
