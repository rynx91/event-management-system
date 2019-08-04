import {Component, OnInit} from '@angular/core';
import {ActivatedRoute, Router} from '@angular/router';
import {EventModel} from '../models/event.model';
import {EventService} from '../service/event.service';
import {LocalStorageService} from 'angular-2-local-storage';

@Component({
  templateUrl: './add-event.component.html'
})
export class AddEventComponent implements OnInit{

  minDate = Date.now();
  isEdit = false;
  form =
  {
    data:
    {
      eventModel: <EventModel> new EventModel()
    },
    error:
    {
      eventTitle: <string> null,
      location: <string> null,
      eventDate: <string> null
    }
  };

  constructor(private router: Router, private eventService:EventService, private route:ActivatedRoute, private localStorageService:LocalStorageService) {

  }

  ngOnInit(){
    let eventId = this.route.snapshot.paramMap.get('eventId');
    if(eventId!=null){
      this.isEdit = true;
      this.eventService.getEventByEventId(eventId).subscribe(data=>{
        this.form.data.eventModel = data;
        this.form.data.eventModel.eventDate = new Date(this.form.data.eventModel.eventDate);
      });
    }

  }

  createEvent() {
    this.form.data.eventModel.createdBy = this.localStorageService.get('userId');
    if(this.validateEvent()) {
      this.eventService.createEvent(this.form.data.eventModel).subscribe(data => {
        alert("Event has been created successfully.");
        if(data!=null && data.eventId){
          this.router.navigateByUrl('/event/view/'+data.eventId);
        }else{
          this.router.navigateByUrl('/home');
        }
      });
    }
  };

  updateEvent() {
    if(this.validateEvent()){
      this.eventService.updateEvent(this.form.data.eventModel).subscribe( data => {
        alert("Event has been created successfully.");
        if(data!=null && data.eventId){
          this.router.navigateByUrl('/event/view/'+data.eventId);
        }else{
          this.router.navigateByUrl('/home');
        }
      });
    }
  };

  validateEvent(){
    this.form.error.eventTitle = null;
    this.form.error.eventDate = null;
    this.form.error.location = null;
    if(!this.form.data.eventModel.eventTitle){
      this.form.error.eventTitle= 'Please fill in event title';
    }
    if(!this.form.data.eventModel.location){
      this.form.error.location = 'Please fill in the event location';
    }
    if(!this.form.data.eventModel.eventDate){
      this.form.error.eventDate = 'Please fill in the event date';
    }else if(this.form.data.eventModel.eventDate <= new Date()) {
      this.form.error.eventDate = "Event date has to be at least a day after created date.";
    }



    if(this.form.error.eventDate || this.form.error.location || this.form.error.eventTitle){
      return false;
    }

    return true;

  }

}
