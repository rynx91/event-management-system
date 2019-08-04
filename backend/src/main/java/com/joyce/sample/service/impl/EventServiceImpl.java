package com.joyce.sample.service.impl;

import com.joyce.sample.entity.EventBean;
import com.joyce.sample.repository.EventRepository;
import com.joyce.sample.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class EventServiceImpl implements EventService {

    @Autowired
    private EventRepository eventRepository;


    @Override
    public EventBean createEvent(EventBean eventBean) {
        return eventRepository.save(eventBean);
    }

    @Override
    public void deleteEvent(EventBean eventBean) {
        eventRepository.delete(eventBean);
    }

    @Override
    public List<EventBean> findAllEvents() {
        return eventRepository.findAll(new Date());
    }

    @Override
    public EventBean getEventByEventId(int eventId) {
        return eventRepository.getByEventId(eventId);
    }

    @Override
    public EventBean updateEvent(EventBean eventBean) {
        return eventRepository.save(eventBean);
    }

    @Override
    public List<EventBean> findUpcomingEventsByUserId(String userId) { return eventRepository.findUpcomingEventsByUserId(userId); }
}
