
/*import {Injectable} from '@angular/core';
import {User} from '../model/user';
import {Http, RequestOptions} from '@angular/http';
import {Observable} from 'rxjs/Observable';
import {environment} from '../../environments/environment';

@Injectable()
export class LoginService{

  public currentUser: User;

  constructor(private http: Http) {
  }

  login(user: User): Observable<Boolean> {
    const body = JSON.stringify({username: user.username, password: user.password});
    const options = new RequestOptions({headers: new Headers({'Content-Type': 'application/json'})});
    return this.http.post('/travel/login', body, options)
      .map(this.handleResponse)
      .catch(LoginService.handleError);
  }

  logout(): void {
    this.currentUser = null;
    localStorage.removeItem(environment.USER_KEY);
  }

  private handleResponse(response: Response) {
    const token = response.json().token;
    const user = response.json().user;
    if (token && user) {
      this.currentUser = user;
      this.currentUser.token = token;
      localStorage.setItem(environment.USER_KEY, JSON.stringify(this.currentUser));
      return true;
    }
    return false;
  }

  private static handleError(error: Response | any) {
    console.error(error.message ? error.message : error.toString());
    return Observable.throw('неправильное имя пользователя или пароль');
  }

  static getCurrentUser() {
    return JSON.parse(localStorage.getItem(environment.USER_KEY));
  }

}*/
