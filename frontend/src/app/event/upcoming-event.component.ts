import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import {EventModel} from '../models/event.model';
import {EventService} from '../service/event.service';
import {LocalStorageService} from 'angular-2-local-storage';
import {RegisterEventService} from '../service/registerEvent.service';
import {RegisterEventModel} from '../models/registerEvent.model';

@Component({
  selector: 'app-upcoming-event',
  templateUrl: './upcoming-event.component.html',
  styles: []
})
export class UpcomingEventComponent implements OnInit {

  form =
  {
    data:
    {
      eventModels: <EventModel[]> []
    }
  };

  constructor(private router: Router, private eventService:EventService, private localStorageService:LocalStorageService, private registerService:RegisterEventService) {

  }

  ngOnInit() {
    this.eventService.findUpcomingEventsByUserId(this.localStorageService.get('userId')).subscribe(data=>{
      this.form.data.eventModels = data;
      console.log(data);
    });
  };


  viewEvent(eventId){
    this.router.navigateByUrl('event/view/'+eventId);
  }

}


