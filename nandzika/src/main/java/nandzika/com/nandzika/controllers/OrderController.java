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

import nandzika.com.nandzika.entities.Order;
import nandzika.com.nandzika.repositories.ClientRepository;
import nandzika.com.nandzika.repositories.OrderRepository;

@RestController
public class OrderController {


    @Autowired
    private OrderRepository orderRepo;

    @Autowired
    private ClientRepository clientRepo;

    @PostMapping("/orders")
    public ResponseEntity<Order> saveOrder(@RequestBody Order order) {

        return new ResponseEntity<>(orderRepo.save(order), HttpStatus.CREATED);
    }

    @PutMapping("/orders/{orderId}/client/{clientId}")
    public ResponseEntity<Order> attachtClient(@PathVariable Integer orderId, @PathVariable Integer clientId){
        
        Order order = orderRepo.findById(orderId).get();
        
        if(clientRepo.findById(clientId).get() == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }else{
            order.setClient(clientRepo.findById(clientId).get());      
            return new ResponseEntity<> (orderRepo.save(order), HttpStatus.OK);
        }
    }

    @GetMapping("/orders")
    public ResponseEntity<List<Order>> getAllOrders(){
        
        List<Order> ordersList = orderRepo.findAll();
        if(ordersList.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }else{
            return new ResponseEntity<>(ordersList, HttpStatus.OK);
        }
    }

    @GetMapping("/orders/{id}")
    public ResponseEntity<Order> getOne(@PathVariable(value="id") Integer id) {

        Optional<Order> order = orderRepo.findById(id);
        if (!order.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(order.get(), HttpStatus.OK);
        }
    }
}
