import {Injectable} from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';

import {EventModel} from '../models/event.model';


const httpOptions = {
  headers: new HttpHeaders({ 'Content-Type': 'application/json' })
};

@Injectable()
export class EventService {

  constructor(private http:HttpClient) {}

  private eventUrl = 'http://localhost:8080/event-management/event';

  public findAllEvents() {
    return this.http.get<EventModel[]>(this.eventUrl);
  }

  public deleteEvent(eventModel:EventModel) {
    return this.http.delete(this.eventUrl + "/"+ eventModel.eventId);
  }

  public createEvent(eventModel:EventModel) {
    return this.http.post<EventModel>(this.eventUrl, eventModel);
  }

  public getEventByEventId(eventId) {
    return this.http.get<EventModel>(this.eventUrl + "/" + eventId);
  }

  public updateEvent(eventModel:EventModel) {
    return this.http.post<EventModel>(this.eventUrl + "/update/" + eventModel.eventId, eventModel);
  }

  public findUpcomingEventsByUserId(userId){
    return this.http.post<EventModel[]>(this.eventUrl+"/upcoming", userId);
  }

}
