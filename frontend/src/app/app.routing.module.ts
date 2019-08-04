import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

import {AddEventComponent} from './event/add-event.component';
import {HomeComponent} from './home/home.component';
import {ViewEventComponent} from './event/view-event.component';
import {LoginComponent} from './login/login.component';
import {UpcomingEventComponent} from './event/upcoming-event.component';
import {SignupComponent} from './signup/signup.component';

const routes: Routes = [
  { path: '', redirectTo: '/login', pathMatch: 'full' },
  { path: 'login', component: LoginComponent },
  { path: 'signup', component: SignupComponent },
  { path: 'home', component: HomeComponent },
  { path: 'event', component: AddEventComponent},
  { path: 'event/edit/:eventId', component: AddEventComponent},
  { path: 'event/view/:eventId', component: ViewEventComponent},
  { path: 'event/upcoming', component: UpcomingEventComponent},
];

@NgModule({
  imports: [
    RouterModule.forRoot(routes)
  ],
  exports: [
    RouterModule
  ],
  declarations: []
})
export class AppRoutingModule { }
