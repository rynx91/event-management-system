import {Component, OnInit} from '@angular/core';
import {ActivatedRoute, Router} from '@angular/router';
import {EventModel} from '../models/event.model';
import {EventService} from '../service/event.service';

@Component({
  templateUrl: './view-event.component.html'
})
export class ViewEventComponent implements OnInit{

  form =
  {
    data:
    {
      eventModel: <EventModel> new EventModel()
    }
  };

  constructor(private router: Router, private eventService:EventService, private route:ActivatedRoute) {

  }

  ngOnInit(){
    let eventId = this.route.snapshot.paramMap.get('eventId');
    if(eventId!=null){
      this.eventService.getEventByEventId(eventId).subscribe(data=>{
        this.form.data.eventModel = data;
      });
    }

  }

}
