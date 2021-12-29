package nandzika.com.nandzika.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import nandzika.com.nandzika.entities.Delivery;

public interface DeliveryRepository extends JpaRepository<Delivery, Integer> {
    
}
