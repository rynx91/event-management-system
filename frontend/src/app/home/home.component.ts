import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import {EventModel} from '../models/event.model';
import {EventService} from '../service/event.service';
import {LocalStorageService} from 'angular-2-local-storage';
import {RegisterEventService} from '../service/registerEvent.service';
import {RegisterEventModel} from '../models/registerEvent.model';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styles: []
})
export class HomeComponent implements OnInit {

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
    this.eventService.findAllEvents().subscribe(data=>{
      this.form.data.eventModels = data;
    });
  };

  deleteEvent(eventModel:EventModel){
    this.eventService.deleteEvent(eventModel).subscribe(data=>{
      alert("Event has been deleted successfully.");
      this.eventService.findAllEvents().subscribe(events=>{
        this.form.data.eventModels = events;
      })
    })
  };

  editEvent(eventId){
    this.router.navigateByUrl('/event/edit/'+eventId);
  }

  viewEvent(eventId){
    this.router.navigateByUrl('event/view/'+eventId);
  }

  registerEvent(eventModel:EventModel){
    if(confirm("Are you sure to register for event:"+eventModel.eventTitle+"?")) {
      let registerModel = new RegisterEventModel();
      registerModel.userId = this.localStorageService.get('userId');
      registerModel.eventId = eventModel.eventId;
      this.registerService.createEvent(registerModel).subscribe(data=>{
        if(data['error']){
          alert(data['error']);
        }else if(data['success']){
          alert(data["success"]);
        }
      });
    }
  }

}


