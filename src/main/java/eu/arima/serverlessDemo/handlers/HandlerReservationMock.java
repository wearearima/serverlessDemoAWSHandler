package eu.arima.serverlessDemo.handlers;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;

import eu.arima.serverlessDemo.beans.Reservation;
import eu.arima.serverlessDemo.beans.Response;

// Handler value: eu.arima.serverlessDemo.handlers.HandlerReservationMock
public class HandlerReservationMock implements RequestHandler<Reservation, Response> {

    public HandlerReservationMock() {
    }

    @Override
    public Response handleRequest(Reservation res, Context context) {
        return new Response(res.getNumber() + " " +  res.getItemName() + " reserved.");
    }
}