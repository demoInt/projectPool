import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { UrlTree } from '@angular/router';

@Injectable({
  providedIn: 'root'
})
export class SearchspService {

  url : string = 'http://localhost:9090/swimmingPool';

  constructor(private httpClient : HttpClient) { }

  searchBasic(title : any)
  {
    return this.httpClient.get<any>(this.url + '/findPoolByName/'+title) ;
  }

  searchAdvanced(search : any)
  {
    return this.httpClient.post<any>(this.url+'/advancedSearch', search.value) ;
  }
}
