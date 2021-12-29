package nandzika.com.nandzika.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import nandzika.com.nandzika.entities.Item;
import nandzika.com.nandzika.repositories.ItemRepository;

@Service
public class ItemService {

    @Autowired
    private ItemRepository repository;

    public List <Item> listAll(){
        
        return repository.findAll();
    }

    public void save(Item client) {

        repository.save(client);
    }

    public Item get(int id) {

        return repository.findById(id).get();
    }

    public void delete(int id) {

        repository.deleteById(id);
    }
}