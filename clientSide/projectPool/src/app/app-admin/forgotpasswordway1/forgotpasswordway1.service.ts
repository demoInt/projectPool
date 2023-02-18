import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class Forgotpasswordway1Service {

  url : string = 'http://localhost:9090/admin/forgotPassword';

  constructor(private httpClient :HttpClient) { }

  passwordReset(reset : any)
  {
    return this.httpClient.post<any>(this.url , reset.value);
  }

}
