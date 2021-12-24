package com.jsfspring.curddemo.repositry;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jsfspring.curddemo.entity.BrandDTO;

@Repository
public interface BrandRepo extends JpaRepository<BrandDTO, Long> {

    BrandDTO findTitleByBrandName(String brandName);
}