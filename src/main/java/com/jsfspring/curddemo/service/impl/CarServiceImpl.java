
package com.jsfspring.curddemo.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jsfspring.curddemo.entity.BrandDTO;
import com.jsfspring.curddemo.entity.CarDTO;
import com.jsfspring.curddemo.repositry.CarRepo;
import com.jsfspring.curddemo.service.CarService;
import com.jsfspring.curddemo.uito.BrandUITO;
import com.jsfspring.curddemo.uito.CarUITO;

@Service
@Transactional
public class CarServiceImpl implements CarService {
    @Autowired
    CarRepo carRepo;

    @Override
    @Transactional(readOnly = false)
    public CarUITO doSaveCar(CarUITO carUiTO) {
        CarDTO dto = UiToToDto(carUiTO);
        dto = carRepo.save(dto);
        BeanUtils.copyProperties(dto, carUiTO);

        dtoToUito(carUiTO, dto);
        return carUiTO;
    }

    private void dtoToUito(CarUITO carUiTO, CarDTO dto) {
        BrandUITO uitTO = new BrandUITO();
        BeanUtils.copyProperties(dto.getBrandDTO(), uitTO);
        carUiTO.setBrandUITO(uitTO);
    }

    private CarDTO UiToToDto(CarUITO carUiTO) {
        CarDTO dto = new CarDTO();
        BrandDTO brandDto = new BrandDTO();
        BeanUtils.copyProperties(carUiTO, dto);
        BeanUtils.copyProperties(carUiTO.getBrandUITO(), brandDto);
        dto.setBrandDTO(brandDto);
        List<CarDTO> lst = new ArrayList<>();
        lst.add(dto);
        brandDto.getCardtolst().addAll(lst);
        return dto;
    }

    @Override
    public List<CarUITO> doFetchAllCar() {
        List<CarDTO> dtoLst = carRepo.findAll();
        List<CarUITO> uiTOLst = new ArrayList<>();
        dtoLst.forEach(dto -> {
            CarUITO tmpUiTO = new CarUITO();
            System.out.println(dto.getBrandDTO());
            BeanUtils.copyProperties(dto, tmpUiTO);

            dtoToUito(tmpUiTO, dto);
            uiTOLst.add(tmpUiTO);
        });
        return uiTOLst;
    }

    @Override
    public CarUITO doGetCar(CarUITO carUiTO) {
        if (null != carUiTO.getCarNumber()) {
            CarDTO dto = new CarDTO();

            BeanUtils.copyProperties(carUiTO, dto);
            dto = carRepo.getOne(dto.getCarId());

            BeanUtils.copyProperties(dto, carUiTO);
        }
        return carUiTO;
    }

    @Override
    @Transactional
    public void doDeleteCar(CarUITO carUiTO) {

        carRepo.deleteById(carUiTO.getCarId());
    }

}