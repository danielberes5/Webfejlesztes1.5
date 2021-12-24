package com.jsfspring.curddemo.utills;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jsfspring.curddemo.service.BrandService;
import com.jsfspring.curddemo.uito.BrandUITO;

@Service
public class BrandConverter implements Converter {

    @Autowired
    private BrandService brandService;

    private static final Logger LOG = LoggerFactory.getLogger(BrandConverter.class.getName());

    @Override
    public Object getAsObject(FacesContext fc, UIComponent uic, String string) {
        LOG.info("getAsObject: " + brandService);

        BrandUITO brandUITO = new BrandUITO();
        brandUITO.setBrandName(string);
        brandUITO = brandService.getBrand(brandUITO);
        System.out.println(brandUITO.toString());
        return brandUITO;
    }

    @Override
    public String getAsString(FacesContext fc, UIComponent uic, Object obj) {
        LOG.info("getAsString obj class: " + obj.getClass().getName());
        if (obj instanceof BrandUITO) {
            BrandUITO brand = (BrandUITO) obj;
            LOG.info("getAsString def name: " + brand.getBrandName());
            return brand.getBrandName();
        } else {
            StringBuilder sbError = new StringBuilder("The object of class ");
            sbError.append(obj.getClass().getName()).append(" is not of BrandUITO");
            throw new ClassCastException(sbError.toString());
        }
    }
}