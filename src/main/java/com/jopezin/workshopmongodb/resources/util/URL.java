package com.jopezin.workshopmongodb.resources.util;

import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class URL {
    public static String decodeParam(String text){
        return URLDecoder.decode(text, StandardCharsets.UTF_8);
    }

    public static LocalDate convertDate(String textDate, LocalDate defaultValue){
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        try{
            return LocalDate.from(dtf.parse(textDate));
        }catch (DateTimeParseException e){
            return defaultValue;
        }
    }
}
