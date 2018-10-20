package com.lot.parking.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class DateUtils {

  private long timeDifference;

  public String getCurrentDateAndTime(){
    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    return dtf.format(LocalDateTime.now());
  }


  public long getTimeDifference(Date date1, Date date2) throws ParseException {
    SimpleDateFormat format = new SimpleDateFormat("HH:mm:ss");
    long difference = date2.getTime() - date1.getTime();
    return  TimeUnit.MILLISECONDS.toDays(difference);
  }
}
