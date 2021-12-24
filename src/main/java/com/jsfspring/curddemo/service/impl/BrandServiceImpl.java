
package com.jsfspring.curddemo.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jsfspring.curddemo.entity.BrandDTO;
import com.jsfspring.curddemo.repositry.BrandRepo;
import com.jsfspring.curddemo.service.BrandService;
import com.jsfspring.curddemo.uito.BrandUITO;

@Service
@Transactional
public class BrandServiceImpl implements BrandService {
    @Autowired
    private BrandRepo brandRepo;

    @Override
    public List<BrandUITO> getAllBrand() {
        List<BrandUITO> brandUITOLst = new ArrayList<>();
        List<BrandDTO> brandDTOLst = brandRepo.findAll();

        brandDTOLst.forEach(dto -> {
            BrandUITO tmpUiTO = new BrandUITO();

            BeanUtils.copyProperties(dto, tmpUiTO);
            brandUITOLst.add(tmpUiTO);
        });

        return brandUITOLst;
    }

    @Override
    public BrandUITO getBrand(BrandUITO brandUITO) {
        System.out.println(">>>>> "+brandUITO.getBrandName());
        BrandDTO dto = brandRepo.findTitleByBrandName(brandUITO.getBrandName());
        BrandUITO uito = new BrandUITO();

        BeanUtils.copyProperties(dto, uito);
        return uito;
    }
}