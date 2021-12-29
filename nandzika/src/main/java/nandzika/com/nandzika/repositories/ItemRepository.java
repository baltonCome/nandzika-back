package nandzika.com.nandzika.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import nandzika.com.nandzika.entities.Item;

public interface ItemRepository extends JpaRepository <Item, Integer> {
    
}
