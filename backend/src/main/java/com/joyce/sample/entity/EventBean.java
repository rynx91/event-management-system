package com.joyce.sample.entity;


import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "event")
public class EventBean {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int eventId;

    @Column
    private String eventTitle;

    @Column
    private String location;

    @Column
    private String description;

    @Column
    private int maxPax;

    @Column
    private Date eventDate;

    @Column
    private Date createdDate;

    @Column
    private Date lastUpdatedDate;

    @Column
    private String createdBy;

    public Set<RegisterEventBean> getRegisterEventBeanSet() {
        return registerEventBeanSet;
    }

    public void setRegisterEventBeanSet(Set<RegisterEventBean> registerEventBeanSet) {
        this.registerEventBeanSet = registerEventBeanSet;
    }

    @OneToMany(targetEntity = RegisterEventBean.class, mappedBy = "eventId", orphanRemoval = false, fetch = FetchType.LAZY)
    private Set<RegisterEventBean> registerEventBeanSet;

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public int getEventId() {
        return eventId;
    }

    public void setEventId(int eventId) {
        this.eventId = eventId;
    }

    public String getEventTitle() {
        return eventTitle;
    }

    public void setEventTitle(String eventTitle) {
        this.eventTitle = eventTitle;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getMaxPax() {
        return maxPax;
    }

    public void setMaxPax(int maxPax) {
        this.maxPax = maxPax;
    }

    public Date getEventDate() {
        return eventDate;
    }

    public void setEventDate(Date eventDate) {
        this.eventDate = eventDate;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Date getLastUpdatedDate() {
        return lastUpdatedDate;
    }

    public void setLastUpdatedDate(Date lastUpdatedDate) {
        this.lastUpdatedDate = lastUpdatedDate;
    }
}

