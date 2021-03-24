package eu.arima.serverlessDemo.functions;

import java.util.function.Function;

import org.springframework.stereotype.Component;

import eu.arima.serverlessDemo.beans.Reservation;
import eu.arima.serverlessDemo.beans.Response;

@Component
public class ReserveMock implements Function<Reservation, Response> {

    @Override
	public Response apply(Reservation res) {
        return new Response(res.getNumber() + " " +  res.getItemName() + " reserved.");
    }
}
