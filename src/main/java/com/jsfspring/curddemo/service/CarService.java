
package com.jsfspring.curddemo.service;

import java.util.List;

import com.jsfspring.curddemo.uito.CarUITO;

public interface CarService {
    CarUITO doSaveCar(CarUITO carUiTO);

    List<CarUITO> doFetchAllCar();

    CarUITO doGetCar(CarUITO carUiTO);

    void doDeleteCar(CarUITO carUiTO);
}