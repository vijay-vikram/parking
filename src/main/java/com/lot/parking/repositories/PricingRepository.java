package com.lot.parking.repositories;

import com.google.inject.Inject;
import com.lot.parking.DataBaseManager;

public class PricingRepository {

  private DataBaseManager dataBaseManager;

  @Inject
  public PricingRepository(DataBaseManager dataBaseManager) {
    this.dataBaseManager = dataBaseManager;
  }


}
