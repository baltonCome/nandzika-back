package nandzika.com.nandzika.repositories;

import nandzika.com.nandzika.entities.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Integer> {
    
}
