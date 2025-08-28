package com.devsuperior.bds04.services.impl;

import com.devsuperior.bds04.dto.EventDTO;
import com.devsuperior.bds04.entities.City;
import com.devsuperior.bds04.entities.Event;
import com.devsuperior.bds04.repositories.CityRepository;
import com.devsuperior.bds04.repositories.EventRepository;
import com.devsuperior.bds04.services.EventService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class EventServiceImpl implements EventService {

    private final EventRepository eventRepository;
    private final CityRepository cityRepository;

    public EventServiceImpl(EventRepository eventRepository, CityRepository cityRepository) {
        this.eventRepository = eventRepository;
        this.cityRepository = cityRepository;
    }

    @Transactional
    @Override
    public EventDTO create(EventDTO eventDTO) {
        Event event = new Event();
        toDto(eventDTO, event);
        event = eventRepository.save(event);
        return new EventDTO(event);
    }

    @Transactional(readOnly = true)
    @Override
    public Page<EventDTO> findAll(Pageable pageable) {
        Page<Event> eventDTOS = eventRepository.findAll(pageable);
        return eventDTOS.map(EventDTO::new);
    }

    private void toDto(EventDTO eventDTO, Event event) {
        City city = cityRepository.getReferenceById(eventDTO.getCityId());

        event.setName(eventDTO.getName());
        event.setUrl(eventDTO.getUrl());
        event.setDate(eventDTO.getDate());
        event.setCity(new City(city.getId(), null));

    }
}
