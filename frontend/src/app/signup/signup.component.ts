import { Component, OnInit } from '@angular/core';
import {Router} from "@angular/router";
import {UserService} from '../service/user.service';
import {LocalStorageService} from "angular-2-local-storage";
import {UserModel} from '../models/user.model';

@Component({
  selector: 'app-signup',
  templateUrl: './signup.component.html'
})
export class SignupComponent implements OnInit {

  form =
  {
    data:
    {
      user: <UserModel> new UserModel()
    },
    error:
    {
      signup: <string> null
    }
  };

  constructor(private router: Router, private userService:UserService, private localStorageService:LocalStorageService) {}

  ngOnInit() {
    if(this.localStorageService.get('userId')!=null){
      this.router.navigateByUrl('/home');
    }
  }

  onSignup(){
    this.form.error.signup = null;
    if(!this.form.data.user.userId){
      this.form.error.signup = 'Please key in your user id';
    }else if(!this.form.data.user.password){
      this.form.error.signup = 'Please key in your password';
    }else{
      this.userService.addUser(this.form.data.user).subscribe(data=>{
        if(data["success"]){
          alert(data["success"]);
          this.router.navigateByUrl('/login');
        }else if(data["error"]){
          alert(data["error"]);
        }

      });
    }
  }

}
