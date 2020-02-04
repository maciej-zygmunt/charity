package pl.coderslab.charity.converters;

import org.springframework.core.convert.converter.Converter;
import java.sql.Time;

public class TimeConverter implements Converter<String, Time> {
    @Override
    public Time convert(String s) {
        try {
            return  Time.valueOf(s+":00");
        } catch (Exception e) {
            return null;
        }
    }
}
