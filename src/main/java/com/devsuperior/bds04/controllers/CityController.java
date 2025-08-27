package com.devsuperior.bds04.controllers;

import com.devsuperior.bds04.dto.CityDTO;
import com.devsuperior.bds04.services.impl.CityServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/cities")
public class CityController {

    private final CityServiceImpl cityService;

    public CityController(CityServiceImpl cityService) {
        this.cityService = cityService;
    }

    @GetMapping
    ResponseEntity<List<CityDTO>> findAll(){
        List<CityDTO> cityDTOS = cityService.findAll();
        return ResponseEntity.ok().body(cityDTOS);
    }
}
