
package com.jsfspring.curddemo.service;

import java.util.List;

import com.jsfspring.curddemo.uito.BrandUITO;

public interface BrandService {

    List<BrandUITO> getAllBrand();

    BrandUITO getBrand(BrandUITO brandUITO);

}