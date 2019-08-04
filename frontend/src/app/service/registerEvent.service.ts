import {Injectable} from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';

import {RegisterEventModel} from '../models/registerEvent.model';

const httpOptions = {
  headers: new HttpHeaders({ 'Content-Type': 'application/json' })
};

@Injectable()
export class RegisterEventService {

  constructor(private http:HttpClient) {}

  private eventUrl = 'http://localhost:8080/event-management/register-event';

  public createEvent(registerModel:RegisterEventModel) {
    return this.http.post<Map<string,string>>(this.eventUrl, registerModel);
  }

  public findRegisterByEventId(eventId) {
    return this.http.get<RegisterEventModel>(this.eventUrl + "/" + eventId);
  }

}
