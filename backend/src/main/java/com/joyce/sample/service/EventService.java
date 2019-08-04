package com.joyce.sample.service;

import com.joyce.sample.entity.EventBean;

import java.util.List;

public interface EventService {

    public EventBean createEvent(EventBean eventBean);

    public void deleteEvent(EventBean eventBean);

    public List<EventBean> findAllEvents();

    public EventBean getEventByEventId(int eventId);

    public EventBean updateEvent(EventBean eventBean);

    public List<EventBean> findUpcomingEventsByUserId(String userId);
}
