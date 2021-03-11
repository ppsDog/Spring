package com.converter;


import org.springframework.core.convert.converter.Converter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DataConverter implements Converter<String, Date> {

    public Date convert(String dataStr) {
        // 将日期字符串转换成真正日期对象
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date date = null;
        try {
            date = simpleDateFormat.parse(dataStr);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }


}
