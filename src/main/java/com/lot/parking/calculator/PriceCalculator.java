package com.lot.parking.calculator;

import com.google.inject.Inject;
import com.lot.parking.repositories.PricingRepository;
import com.lot.parking.utils.DateUtils;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class PriceCalculator {

  private PricingRepository pricingRepository;
  private DateUtils dateUtils;

  @Inject
  public PriceCalculator(PricingRepository pricingRepository, DateUtils dateUtils) {
    this.pricingRepository = pricingRepository;
    this.dateUtils = dateUtils;
  }

  public long calculate(Timestamp startDateTimeStamp) throws ParseException {

    long totalTime = getTotalTime(startDateTimeStamp);

    return 100;
  }

  private long getTotalTime(Timestamp startDateTimeStamp) throws ParseException {
    Date startDateTime = new Date(startDateTimeStamp.getTime());
    Date endDateTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(dateUtils.getCurrentDateAndTime());

    return TimeUnit.MILLISECONDS.toHours(endDateTime.getTime() - startDateTime.getTime());
  }


}
