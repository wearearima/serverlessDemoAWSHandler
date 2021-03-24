package eu.arima.serverlessDemo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import eu.arima.serverlessDemo.beans.Item;

public interface ItemRepository extends JpaRepository<Item, String>{
    
    Item findByItemName(String itemName);
}
