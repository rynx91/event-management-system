package com.joyce.sample.mvc;

import com.joyce.sample.entity.RegisterEventBean;
import com.joyce.sample.service.RegisterEventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping({"/register-event"})
public class RegisterEventController {

    @Autowired
    private RegisterEventService registerEventService;

    @PostMapping
    public Map<String,String > createEvent(@RequestBody RegisterEventBean registerEventBean){
        return registerEventService.createRegister(registerEventBean);
    }

    @GetMapping(path = {"/{eventId}"})
    public List<RegisterEventBean> findRegisterByEventId(@PathVariable("eventId") int eventId){
        return registerEventService.findAllRegisterByEventId(eventId);
    }

}
