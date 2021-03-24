package eu.arima.serverlessDemo.beans;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(schema = "public")
@Getter
@Setter
@AllArgsConstructor
public class Item {

    @Id
    private String itemName;

    private int number;

    protected Item() {};

    public Item(Reservation res) {
        this.itemName = res.getItemName();
        this.number = res.getNumber();
    }
    
}
