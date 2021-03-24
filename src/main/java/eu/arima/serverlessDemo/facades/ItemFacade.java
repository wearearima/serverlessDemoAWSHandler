package eu.arima.serverlessDemo.facades;

import eu.arima.serverlessDemo.beans.Item;

public interface ItemFacade {

    Item saveItem(Item item);

    boolean reserveItem(Item item);

}
