
package com.jsfspring.curddemo.uito;

import java.io.Serializable;


public class CarUITO implements Serializable {


    private static final long serialVersionUID = 4840260415183676656L;
    private Long carId;
    private String carNumber;
    private BrandUITO brandUITO;

    public Long getCarId() {
        return carId;
    }

    public void setCarId(Long carId) {
        this.carId = carId;
    }

    public String getCarNumber() {
        return carNumber;
    }

    public void setCarName(String carNumber) {
        this.carNumber = carNumber;
    }



    public BrandUITO getBrandUITO() {
        return brandUITO;
    }

    public void setBrandUITO(BrandUITO brandUITO) {
        this.brandUITO = brandUITO;
    }

    @Override
    public String toString() {
        return "CarUITO [carId=" + carId + ", carNumber=" + carNumber + ", brandUITO=" + brandUITO + "]";
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((carNumber == null) ? 0 : carNumber.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        CarUITO other = (CarUITO) obj;
        if (carNumber == null) {
            if (other.carNumber != null)
                return false;
        } else if (!carNumber.equals(other.carNumber))
            return false;
        return true;
    }

}
