package nandzika.com.nandzika.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import nandzika.com.nandzika.entities.Client;
import nandzika.com.nandzika.repositories.ClientRepository;

@RestController
public class ClientController {

    @Autowired
    private ClientRepository repository;

    @PostMapping("/clients")
    @ResponseBody
    public ResponseEntity<Client> saveClient(@RequestBody Client client){

        return new ResponseEntity<>(repository.save(client), HttpStatus.CREATED);
    }

    @GetMapping("/clients")
    @ResponseBody
    public ResponseEntity<List<Client>> listClients(){

        return new ResponseEntity<>(repository.findAll(), HttpStatus.OK);
    }

    @GetMapping("/clients/{id}")
    @ResponseBody
    public ResponseEntity<Client> getClient(@RequestParam (name = "id") int id){

        return new ResponseEntity<>(repository.findById(id).get(), HttpStatus.OK);
    }
}
