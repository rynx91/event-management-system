package com.joyce.sample.service.impl;

import com.joyce.sample.entity.EventBean;
import com.joyce.sample.entity.RegisterEventBean;
import com.joyce.sample.repository.EventRepository;
import com.joyce.sample.repository.RegisterEventRepository;
import com.joyce.sample.service.RegisterEventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class RegisterEventEventServiceImpl implements RegisterEventService {

    @Autowired
    private RegisterEventRepository registerEventRepository;

    @Autowired
    private EventRepository eventRepository;


    @Override
    public Map<String,String> createRegister(RegisterEventBean registerEventBean) {
        Map<String, String> result = new HashMap<>();
        RegisterEventBean rb = registerEventRepository.getByUserIdAndEventId(registerEventBean.getUserId(), registerEventBean.getEventId());
        if(rb!=null){
            result.put("error", "You have already registered for this event.");
        }else{
            EventBean eb = eventRepository.getByEventId(registerEventBean.getEventId());
            List rbList = registerEventRepository.findAllByEventId(eb.getEventId());
            if(eb!=null){
                if(!rbList.isEmpty() && eb.getMaxPax()>0 && rbList.size()>=eb.getMaxPax()){
                    result.put("error", "Sorry, the event has been fully registered.");
                }else if(eb.getEventDate().compareTo(new Date())<=0){
                    result.put("error", "This is event is already expired");
                }
                else{
                    registerEventRepository.save(registerEventBean);
                    result.put("success", "You have successfully registered for this event.");

                }
            }else{
                result.put("error", "Event not found.");
            }
        }
        return result;
    }

    @Override
    public List<RegisterEventBean> findAllRegisterByEventId(int eventId) {
        return registerEventRepository.findAllByEventId(eventId);
    }

}
