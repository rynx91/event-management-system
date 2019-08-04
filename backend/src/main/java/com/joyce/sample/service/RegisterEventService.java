package com.joyce.sample.service;

import com.joyce.sample.entity.RegisterEventBean;

import java.util.List;
import java.util.Map;

public interface RegisterEventService {

    public Map<String,String> createRegister(RegisterEventBean registerEventBean);

    public List<RegisterEventBean> findAllRegisterByEventId(int eventId);

}
