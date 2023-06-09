package models;

import com.github.cliftonlabs.json_simple.JsonObject;
import com.github.cliftonlabs.json_simple.Jsonable;

import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;
import java.text.SimpleDateFormat;

public class Human implements Jsonable {
    public Human (long age, java.util.Date birthday){
        this.age = age;
        this.birthday = birthday;
    }
    private final long age; //Значение поля должно быть больше 0
    private final java.util.Date birthday;
    public long getAge(){
        return age;
    }
    public java.util.Date getBirthday(){
        return birthday;
    }
    public String getStringBirthday(){
        return new SimpleDateFormat("dd.MM.yyyy").format(getBirthday());
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
        json.put("age", this.getAge());
        json.put("birthday", getStringBirthday());
        json.toJson(writer);
    }
    @Override
    public String toString (){
        return String.format("Age = %d, birthday = %s\n", getAge(), getStringBirthday());
    }
}