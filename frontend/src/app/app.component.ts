import { Component } from '@angular/core';
import {Router} from '@angular/router';
import { LocalStorageService } from 'angular-2-local-storage';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {

  showNavBar = false;
  navbarOpen = false;
  userId = null;

  constructor(private router:Router, private localStorageService:LocalStorageService) {

  }

  toggleNavbar() {
    this.navbarOpen = !this.navbarOpen;
  }

  onLogout(){
    this.localStorageService.remove('userId');
    this.showNavBar = false;
    this.userId = null;
    this.router.navigateByUrl('/login');
  }

  checkIsLogin() {
    this.userId = this.localStorageService.get('userId');
    if (this.userId != null) {
      return true;
    } else {
      return false;
    }
  }
}
