package nandzika.com.nandzika.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import nandzika.com.nandzika.entities.Order;
import nandzika.com.nandzika.repositories.OrderRepository;

@Service
public class OrderService {

    @Autowired
    private OrderRepository repository;

    public List <Order> listAll(){
        
        return repository.findAll();
    }

    public Order save(Order client) {

        return repository.save(client);
    }

    public Order get(int id) {

        return repository.findById(id).get();
    }

    public void delete(int id) {

        repository.deleteById(id);
    }
}