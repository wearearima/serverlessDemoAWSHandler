package eu.arima.serverlessDemo.beans;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class Reservation {
    
    private String itemName;

    private int number;
}
