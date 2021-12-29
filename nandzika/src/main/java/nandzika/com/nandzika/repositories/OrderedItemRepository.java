package nandzika.com.nandzika.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import nandzika.com.nandzika.entities.OrderedItem;

public interface OrderedItemRepository extends JpaRepository<OrderedItem, Integer> {
    
    
}
