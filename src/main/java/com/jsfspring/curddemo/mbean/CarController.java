
package com.jsfspring.curddemo.mbean;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;

import org.primefaces.context.RequestContext;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.context.annotation.SessionScope;

import com.jsfspring.curddemo.service.BrandService;
import com.jsfspring.curddemo.service.CarService;
import com.jsfspring.curddemo.uito.BrandUITO;
import com.jsfspring.curddemo.uito.CarUITO;

@Controller("carlController")
@SessionScope
public class CarController {
    @Autowired
    private CarService carService;

    @Autowired
    private BrandService brandService;

    private String actionLabel;
    private CarUITO carUiTO;
    private List<CarUITO> carUiToList;

    private List<BrandUITO> brandUiToList;

    /**
     * add or update new Record in DB
     *
     * @return
     */
    public void doSaveInfoCar() {
        System.out.println(this.getCarUiTO());
        carService.doSaveCar(this.getCarUiTO());
        getAllCar();
        this.setCarUiTO(new CarUITO());
        RequestContext.getCurrentInstance().showMessageInDialog(new FacesMessage(FacesMessage.SEVERITY_INFO,
                "Car Details", "Car Details added/Updated Successfully."));

    }

    /**
     * Default load all the Car info
     */
    @PostConstruct
    public void getAllCar() {
        if (!this.getCarUiToList().isEmpty()) {
            this.getCarUiToList().clear();
            this.getBrandUiToList().clear();
        }
        System.out.println(" >>>>>>>>>>>>> " + carService);
        this.getCarUiToList().addAll(carService.doFetchAllCar());
        this.getBrandUiToList().addAll(brandService.getAllBrand());
        this.setActionLabel("Add");
    }

    /**
     * Remove selected Car info
     *
     * @return
     */

    public void deleteCar(CarUITO carUiTO) {
        carService.doDeleteCar(carUiTO);
        getAllCar();
    }

    public void editCar(CarUITO carUiTO) {
        this.setActionLabel("Update");
        BeanUtils.copyProperties(carUiTO, this.getCarUiTO());
        System.out.println(this.getCarUiTO());
    }

    public CarUITO getCarUiTO() {
        if (carUiTO == null) {
            carUiTO = new CarUITO();
        }
        return carUiTO;
    }

    public void setCarUiTO(CarUITO carUiTO) {
        this.carUiTO = carUiTO;
    }

    public List<CarUITO> getCarUiToList() {
        if (null == carUiToList) {
            carUiToList = new ArrayList<>();
        }
        return carUiToList;
    }

    public String getActionLabel() {
        return actionLabel;
    }

    public void setActionLabel(String actionLabel) {
        this.actionLabel = actionLabel;
    }

    public List<BrandUITO> getBrandUiToList() {
        if (brandUiToList == null) {
            brandUiToList = new ArrayList<>();
        }
        return brandUiToList;
    }

    public void setBrandUiToList(List<BrandUITO> brandUiToList) {
        this.brandUiToList = brandUiToList;
    }
}