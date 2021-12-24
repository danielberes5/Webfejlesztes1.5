package com.jsfspring.curddemo.uito;

import java.io.Serializable;
import java.util.List;

public class BrandUITO implements Serializable {


    private static final long serialVersionUID = 1L;
    private Long brandId;
    private String brandName;

    private List<CarUITO> carUITOLst;

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

    public List<CarUITO> getCarUITOLst() {
        return carUITOLst;
    }

    public void setCarUITOLst(List<CarUITO> carUITOLst) {
        this.carUITOLst = carUITOLst;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((brandId == null) ? 0 : brandId.hashCode());
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
        BrandUITO other = (BrandUITO) obj;
        if (brandId == null) {
            if (other.brandId != null)
                return false;
        } else if (!brandId.equals(other.brandId))
            return false;
        return true;
    }

}
