package com.joyce.sample.repository;

import com.joyce.sample.entity.RegisterEventBean;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface RegisterEventRepository extends Repository<RegisterEventBean, Integer> {

    @Query("SELECT r FROM RegisterEventBean r WHERE r.eventId = :eventId")
    public List<RegisterEventBean> findAllByEventId(@Param("eventId") int eventId);

    public RegisterEventBean save(RegisterEventBean registerEventBean);

    @Query("SELECT r FROM RegisterEventBean r WHERE r.userId = :userId AND r.eventId = :eventId")
    public RegisterEventBean getByUserIdAndEventId(@Param("userId") String userId, @Param("eventId") int eventId);
}
