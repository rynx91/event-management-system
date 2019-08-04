import {Injectable} from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import {UserModel} from '../models/user.model';


const httpOptions = {
  headers: new HttpHeaders({ 'Content-Type': 'application/json' })
};

@Injectable()
export class UserService {

  constructor(private http:HttpClient) {}

  private loginUrl = 'http://localhost:8080/event-management/login';

  private userUrl = 'http://localhost:8080/event-management/user';

  public loginUser(userModel:UserModel) {
    return this.http.post<Map<string,string>>(this.loginUrl, userModel);
  }

  public addUser(userModel:UserModel) {
    return this.http.post<Map<string,string>>(this.userUrl+'/add', userModel);
  }


}
