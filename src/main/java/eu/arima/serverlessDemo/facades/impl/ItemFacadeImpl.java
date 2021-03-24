package eu.arima.serverlessDemo.facades.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import eu.arima.serverlessDemo.beans.Item;
import eu.arima.serverlessDemo.facades.ItemFacade;
import eu.arima.serverlessDemo.repositories.ItemRepository;

@Service
public class ItemFacadeImpl implements ItemFacade {

    @Autowired
    private ItemRepository itemRepository;

    @Override
    public Item saveItem(Item item) {
        Item dbItem = this.selectItem(item.getItemName());
        if (dbItem == null) {
            return itemRepository.save(item);
        } else {
            dbItem.setNumber(dbItem.getNumber() + item.getNumber());
            return itemRepository.save(dbItem);
        }
    }

    @Override
    @Transactional
    public boolean reserveItem(Item item) {
        Item dbItem = this.selectItem(item.getItemName());
        if (dbItem == null) {
            return false;
        }
        if ((dbItem.getNumber() - item.getNumber()) < 0) {
            return false;
        }
        dbItem.setNumber(dbItem.getNumber() - item.getNumber());
        itemRepository.save(dbItem);
        return true;
    }

    private Item selectItem(String name) {
        return itemRepository.findByItemName(name);
    }
}
