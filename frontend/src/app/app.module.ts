import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';

import { AppComponent } from './app.component';
import { AppRoutingModule } from './app.routing.module';
import {HttpClientModule} from '@angular/common/http';
import {AddEventComponent} from './event/add-event.component';
import {EventService} from './service/event.service';
import {OwlDateTimeModule, OwlNativeDateTimeModule} from 'ng-pick-datetime';
import {BrowserAnimationsModule} from '@angular/platform-browser/animations';
import {HomeComponent} from './home/home.component';
import {LocalStorageModule, LocalStorageService} from 'angular-2-local-storage';
import {ViewEventComponent} from './event/view-event.component';
import {LoginComponent} from './login/login.component';
import {UserService} from './service/user.service';
import {RegisterEventService} from './service/registerEvent.service';
import {UpcomingEventComponent} from './event/upcoming-event.component';
import {SignupComponent} from './signup/signup.component';

@NgModule({
  declarations: [
    AppComponent,
    AddEventComponent,
    HomeComponent,
    ViewEventComponent,
    LoginComponent,
    UpcomingEventComponent,
    SignupComponent
  ],
  imports: [
    BrowserModule,
    BrowserAnimationsModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule,
    OwlDateTimeModule,
    OwlNativeDateTimeModule,
    LocalStorageModule.withConfig({
      prefix: 'my-app',
      storageType: 'localStorage'
    })
  ],
  providers: [EventService,UserService,RegisterEventService],
  bootstrap: [AppComponent]
})
export class AppModule { }
