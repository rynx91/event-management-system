package com.joyce.sample.mvc;

import com.joyce.sample.entity.EventBean;
import com.joyce.sample.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping({"/event"})
public class EventController {

    @Autowired
    private EventService eventService;

    @PostMapping
    public EventBean createEvent(@RequestBody EventBean eventBean){
        eventBean.setCreatedDate(new Date());
        eventBean.setLastUpdatedDate(new Date());
        return eventService.createEvent(eventBean);
    }

    @GetMapping(path = {"/{eventId}"})
    public EventBean getEventByEventId(@PathVariable("eventId") int eventId){
        return eventService.getEventByEventId(eventId);
    }

    @PostMapping(path = {"/update/{eventId}"})
    public EventBean updateEvent(@PathVariable("eventId") int eventId, @RequestBody EventBean eventBean){
        eventBean.setEventId(eventId);
        return eventService.updateEvent(eventBean);
    }

    @DeleteMapping(path ={"/{eventId}"})
    public void deleteEvent(@PathVariable("eventId") int eventId) {
        EventBean eventBean = eventService.getEventByEventId(eventId);
        if(eventBean!=null){
            eventService.deleteEvent(eventBean);
        }
    }

    @GetMapping
    public List<EventBean> findAllEvents(){
        return eventService.findAllEvents();
    }

    @PostMapping(path = {"/upcoming"})
    public List<EventBean> findUpcomingEventsByUserId(@RequestBody String userId){
        List<EventBean> e = eventService.findUpcomingEventsByUserId("joyce");
        for(int i=0; i<e.size(); i++){
            System.out.println(e.get(i).getEventTitle());
        }
        return e;
    }
}
