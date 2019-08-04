import { Component, OnInit } from '@angular/core';
import {Router} from "@angular/router";
import {UserService} from '../service/user.service';
import {LocalStorageService} from "angular-2-local-storage";
import {UserModel} from '../models/user.model';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html'
})
export class LoginComponent implements OnInit {

  form =
  {
    data:
    {
      user: <UserModel> new UserModel()
    },
    error:
    {
      login: <string> null
    }
  };

  constructor(private router: Router, private userService:UserService, private localStorageService:LocalStorageService) {}

  ngOnInit() {
    if(this.localStorageService.get('userId')!=null){
      this.router.navigateByUrl('/home');
    }
  }

  onLogin(){
    this.form.error.login = null;
    if(!this.form.data.user.userId){
      this.form.error.login = 'Please key in your user id';
    }else if(!this.form.data.user.password){
      this.form.error.login = 'Please key in your password';
    }else{
      this.userService.loginUser(this.form.data.user).subscribe(data=>{
        if(data['error']){
          alert(data['error']);
        }else if(data['userId']){
          this.localStorageService.set('userId', data['userId']);
          this.router.navigateByUrl('/home');
        }
      });
    }
  }

}
