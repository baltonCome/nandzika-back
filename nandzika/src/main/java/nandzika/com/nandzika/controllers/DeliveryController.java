package nandzika.com.nandzika.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import nandzika.com.nandzika.entities.Delivery;
import nandzika.com.nandzika.repositories.DeliveryRepository;
import nandzika.com.nandzika.repositories.OrderRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
public class DeliveryController {
    
    @Autowired
    private DeliveryRepository deliveryRepo;

    @Autowired
    private OrderRepository orderRepo;

    @PostMapping("/deliveries")
    public ResponseEntity<Delivery> saveDelivery(@RequestBody Delivery delivery){

        return new ResponseEntity<>(deliveryRepo.save(delivery), HttpStatus.CREATED);
    }

    @PutMapping("/deliveries/{deliveryId}/order/{orderId}")
    public ResponseEntity<Delivery> attachOrder(@PathVariable Integer deliveryId , @PathVariable Integer orderId){

        Delivery delivery = deliveryRepo.findById(deliveryId).get();

        if(orderRepo.findById(orderId).get() == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }else{
            delivery.setOrders(orderRepo.findById(orderId).get());
            return new ResponseEntity<>(deliveryRepo.save(delivery), HttpStatus.OK);
        }
    }

    @GetMapping("deliveries")
    public ResponseEntity<List<Delivery>> getAllDeliverys() {
        
        List<Delivery> deliveriesList = deliveryRepo.findAll();
        if (deliveriesList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(deliveriesList, HttpStatus.OK);
        }
    }

    @GetMapping("deliveries/{id}")
    public ResponseEntity<Delivery> getOne(@RequestParam Integer id) {

        Optional<Delivery> delivery = deliveryRepo.findById(id);
        if(!delivery.isPresent()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }else{
            return new ResponseEntity<>(delivery.get(), HttpStatus.OK);
        }
    }
}
