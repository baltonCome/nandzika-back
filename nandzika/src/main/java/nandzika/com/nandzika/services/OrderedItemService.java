package nandzika.com.nandzika.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import nandzika.com.nandzika.entities.OrderedItem;
import nandzika.com.nandzika.repositories.OrderedItemRepository;

@Service
public class OrderedItemService {

    @Autowired
    private OrderedItemRepository repository;

    public List <OrderedItem> listAll(){
        
        return repository.findAll();
    }

    public void save(OrderedItem client) {

        repository.save(client);
    }

    public OrderedItem get(int id) {

        return repository.findById(id).get();
    }

    public void delete(int id) {

        repository.deleteById(id);
    }
}