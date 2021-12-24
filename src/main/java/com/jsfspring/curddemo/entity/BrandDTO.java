package com.jsfspring.curddemo.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.ArrayList;

@Entity
@Table(name = "BRAND_MASTER")
public class BrandDTO implements Serializable {
    /**
     *
     */
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "BRAND_ID")
    private Long brandId;
    @Column(name = "Brand_Name")
    private String brandName;

    @OneToMany(mappedBy = "brandDTO")
    private List<CarDTO> cardtolst;

    public Long getBrandId() {
        return brandId;
    }

    public void setBrandId(Long brandId) {
        this.brandId = brandId;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public List<CarDTO> getCardtolst() {
        if (null == cardtolst) {
            cardtolst = new ArrayList<>();
        }
        return cardtolst;
    }

    public void setCardtolst(List<CarDTO> cardtolst) {
        this.cardtolst = cardtolst;
    }
}
