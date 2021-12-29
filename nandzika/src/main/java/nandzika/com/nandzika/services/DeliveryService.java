package nandzika.com.nandzika.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import nandzika.com.nandzika.entities.Delivery;
import nandzika.com.nandzika.repositories.DeliveryRepository;

@Service
public class DeliveryService {
    
    @Autowired
    private DeliveryRepository repository;

    public List <Delivery> listAll(){
        
        return repository.findAll();
    }

    public void save (Delivery client){
        
        repository.save(client);
    }

    public Delivery get(int id){

        return repository.findById(id).get();
    }

    public void delete (int id){

        repository.deleteById(id);
    }
}