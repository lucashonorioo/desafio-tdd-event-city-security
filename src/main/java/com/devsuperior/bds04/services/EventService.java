package com.devsuperior.bds04.services;

import com.devsuperior.bds04.dto.EventDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface EventService {

    Page<EventDTO> findAll(Pageable pageable);
}
