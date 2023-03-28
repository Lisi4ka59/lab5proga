package models;

import com.github.cliftonlabs.json_simple.JsonObject;
import com.github.cliftonlabs.json_simple.Jsonable;

import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;

public class Coordinates implements Jsonable {
    private Double x; //Значение поля должно быть больше -25, Поле не может быть null
    private Float y; //Поле не может быть null
    public Coordinates (double x, Float y){
        this.x = x;
        this.y = y;
    }
    public double getX(){

        return x;
    }
    public Float getY(){

        return y;
    }
    @Override
    public String toJson() {
        final StringWriter writable = new StringWriter();
        try {
            this.toJson(writable);
        } catch (final IOException e) {
        }
        return writable.toString();
    }

    @Override
    public void toJson(Writer writer) throws IOException {
        final JsonObject json = new JsonObject();
        json.put("x", this.getX());
        json.put("y", this.getY());
        json.toJson(writer);
    }
}