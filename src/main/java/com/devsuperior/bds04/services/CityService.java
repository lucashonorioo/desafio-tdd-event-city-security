package com.devsuperior.bds04.services;

import com.devsuperior.bds04.dto.CityDTO;

import java.util.List;

public interface CityService {

    CityDTO create(CityDTO cityDTO);
    List<CityDTO> findAll();

}
