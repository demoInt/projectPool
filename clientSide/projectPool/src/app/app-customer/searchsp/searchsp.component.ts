import { Component } from '@angular/core';
import { FormBuilder, FormControl, FormGroup, Validators } from '@angular/forms';
import { SearchspService } from './searchsp.service';

@Component({
  selector: 'app-searchsp',
  templateUrl: './searchsp.component.html',
  styleUrls: ['./searchsp.component.css']
})
export class SearchspComponent {

    basicSearchFormStatus : boolean = true ;
    basicSearch : FormGroup ;
    basicSearchResults : any ;
    statusBasic : boolean = false ;
    message : string = "" ;


    advancedSearch : FormGroup ;
    statusAdvanced : boolean = false ;
    messageAdvanced : string = "" ;
    advancedSearchResults : any ;
    advancedSearchFormStatus : boolean = false ;

    constructor(private service : SearchspService, private formBuilder : FormBuilder){
        this.basicSearch = formBuilder.group({
                                                title : new FormControl('',Validators.required) 
                                             });

        this.advancedSearch = formBuilder.group({
                                                    city : new FormControl(),
                                                    state : new FormControl(),
                                                    country : new FormControl() 
                                                });
    }

    searchBasic()
    {
      this.service.searchBasic(this.basicSearch.value.title).subscribe( r1  =>  {
                                                                                  this.basicSearchResults = r1.pools ;
                                                                                  this.message = r1.message ;
                                                                                  this.statusBasic = r1.status ;
                                                                                });       
    }

  get title()
  {
    return this.basicSearch.get('title');
  }


  toShowTableAdSearch()
  {
    this.basicSearchFormStatus = false ;
    this.advancedSearchFormStatus = true ;

  }

  searchAdvanced()
  { 
    console.log(this.advancedSearch);
    this.service.searchAdvanced(this.advancedSearch).subscribe(r1 => {
                                                                        this.advancedSearchResults = r1.pools ;
                                                                        this.statusAdvanced = r1.status ;
                                                                        this.messageAdvanced = r1.message ;
                                                                      });
  }

}
