package com.devsuperior.bds04.services.impl;

import com.devsuperior.bds04.dto.CityDTO;
import com.devsuperior.bds04.entities.City;
import com.devsuperior.bds04.repositories.CityRepository;
import com.devsuperior.bds04.services.CityService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CityServiceImpl implements CityService {

    private final CityRepository cityRepository;

    public CityServiceImpl(CityRepository cityRepository) {
        this.cityRepository = cityRepository;
    }

    @Transactional
    @Override
    public CityDTO create(CityDTO cityDTO) {
        City city =  new City();
        toDto(cityDTO, city);
        city = cityRepository.save(city);
        return new CityDTO(city);
    }

    @Transactional(readOnly = true)
    @Override
    public List<CityDTO> findAll() {
        List<City> cities = cityRepository.findAllByOrderByNameAsc();
        return cities.stream().map(CityDTO::new).toList();
    }
    private void toDto(CityDTO cityDTO, City city) {
        city.setName(cityDTO.getName());
    }
}
