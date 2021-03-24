package eu.arima.serverlessDemo.functions;

import java.util.function.Function;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import eu.arima.serverlessDemo.beans.Item;
import eu.arima.serverlessDemo.beans.Response;
import eu.arima.serverlessDemo.facades.ItemFacade;

@Component
public class SaveItem implements Function<Item, Response> {

    @Autowired
    private ItemFacade itemFacade;

    @Override
    public Response apply(Item item) {
        try {
            Item newItem = itemFacade.saveItem(item);
            if (newItem != null) {
                return new Response("Saved item: [" + item.getItemName() + ", " + item.getNumber() + "]");
            } else {
                return new Response("Error saving item", 500);
            }
        } catch (IllegalArgumentException e) {
            return new Response("Error saving item", 500);
        }
    }
}
