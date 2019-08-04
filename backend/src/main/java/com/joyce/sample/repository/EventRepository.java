package com.joyce.sample.repository;

import com.joyce.sample.entity.EventBean;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;

public interface EventRepository extends Repository<EventBean, Integer> {

    public void delete(EventBean eventBean);

    @Query("SELECT e FROM EventBean e WHERE e.eventDate > :currentDate")
    public List<EventBean> findAll(@Param("currentDate") Date currentDate);

    public EventBean getByEventId(int eventId);

    public EventBean save(EventBean eventBean);

    @Query("SELECT e FROM EventBean e INNER JOIN e.registerEventBeanSet r WHERE r.userId= :userId")
    public List<EventBean> findUpcomingEventsByUserId(@Param("userId") String userId);


}
