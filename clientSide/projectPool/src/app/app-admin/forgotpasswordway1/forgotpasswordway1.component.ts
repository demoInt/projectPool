import { Component } from '@angular/core';
import { FormBuilder, FormControl, FormGroup, Validators } from '@angular/forms';
import { Forgotpasswordway1Service } from './forgotpasswordway1.service';

@Component({
  selector: 'app-forgotpasswordway1',
  templateUrl: './forgotpasswordway1.component.html',
  styleUrls: ['./forgotpasswordway1.component.css']
})
export class Forgotpasswordway1Component {

  emailId : FormGroup ;
  message : string ="" ;
  status : boolean = false ;

  constructor(private service : Forgotpasswordway1Service, private formBuilder : FormBuilder)
  {
    this.emailId = formBuilder.group({ email : new FormControl('',Validators.required) });
  }

  get email()
  {
    return this.emailId.get('email');
  }

  forgotPassword()
  {
    this.service.passwordReset(this.emailId).subscribe( r1 => {
                                                                this.message = r1.message ;
                                                                this.status = r1.status ;
                                                            });
  }

}
