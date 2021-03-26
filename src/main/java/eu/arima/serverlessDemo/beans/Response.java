package eu.arima.serverlessDemo.beans;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Response {
    
    private String message;

    private String date;

    private String code;

    public Response(String message) {
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        this.message = message;
        this.date = dateFormat.format(new Date());
        this.code = "200";
    }

    public Response(String message, int code) {
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        this.message = message;
        this.date = dateFormat.format(new Date());
        this.code = Integer.toString(code);
    }
}
