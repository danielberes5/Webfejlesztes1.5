package com.jsfspring.curddemo.repositry;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jsfspring.curddemo.entity.CarDTO;

@Repository
public interface CarRepo extends JpaRepository<CarDTO, Long> {
}