package com.joyce.sample.entity;

import javax.persistence.*;

@Entity
@Table(name = "register_event")
public class RegisterEventBean {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int registerId;

    @Column
    private String userId;

    @Column
    private int eventId;

    public int getRegisterId() {
        return registerId;
    }

    public void setRegisterId(int registerId) {
        this.registerId = registerId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public int getEventId() {
        return eventId;
    }

    public void setEventId(int eventId) {
        this.eventId = eventId;
    }
}

