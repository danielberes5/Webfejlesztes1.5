
package com.jsfspring.curddemo.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.NamedQuery;



@Entity
@Table(name = "CAR_INFO")
@NamedQuery(name = "CarDTO.findAll", query = "SELECT a FROM CarDTO a")
public class CarDTO implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long carId;
    @Column(name = "CAR_NUMBER", nullable = false)
    private String carNumber;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "BRAND_ID")
    private BrandDTO brandDTO;

    public Long getCarId() {
        return carId;
    }

    public void setCarId(Long carId) {
        this.carId = carId;
    }

    public String getCarNumber() {
        return carNumber;
    }

    public void setCarNumber(String carNumber) {
        this.carNumber = carNumber;
    }



    public BrandDTO getBrandDTO() {

        return brandDTO;
    }

    public void setBrandDTO(BrandDTO brandDTO) {
        this.brandDTO = brandDTO;
    }

}
