package eu.arima.serverlessDemo.functions;

import java.util.function.Function;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import eu.arima.serverlessDemo.beans.Item;
import eu.arima.serverlessDemo.beans.Reservation;
import eu.arima.serverlessDemo.beans.Response;
import eu.arima.serverlessDemo.facades.ItemFacade;

@Component
public class Reserve implements Function<Reservation, Response> {
    
    @Autowired
    private ItemFacade itemFacade;

    @Override
    public Response apply(Reservation res) {
        if (res.getNumber() <= 0) {
            return new Response("Invalid number of items.", 402);
        }
        boolean reserved = itemFacade.reserveItem(new Item(res.getItemName(), res.getNumber()));
        if (!reserved) {
            return new Response("No " + res.getItemName() + " available.");
        }
        return new Response(res.getNumber() + " " + res.getItemName() + " reserved.");
    }
}
