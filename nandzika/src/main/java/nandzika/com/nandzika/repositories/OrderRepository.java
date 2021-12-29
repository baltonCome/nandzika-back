package nandzika.com.nandzika.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import nandzika.com.nandzika.entities.Order;

public interface OrderRepository extends JpaRepository<Order, Integer> {
    
}
