import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ChangepasswordComponent } from './changepassword/changepassword.component';
import { ForgotpasswordComponent } from './forgotpassword/forgotpassword.component';
import { Forgotpasswordway1Component } from './forgotpasswordway1/forgotpasswordway1.component';
import { LoginComponent } from './login/login.component';
import { LogoutComponent } from './logout/logout.component';
import { MyprofileComponent } from './myprofile/myprofile.component';
import { SignupComponent } from './signup/signup.component';

const routes: Routes = [
  {path:"login",component:LoginComponent},
  {path:"signup",component:SignupComponent},
  {path:"forgotpassword",component:ForgotpasswordComponent},
  {path:"myprofile", component:MyprofileComponent},
  {path:"changepassword", component:ChangepasswordComponent},
  {path:"logout",component:LogoutComponent},
  {path:"forgotpasswordway1",component:Forgotpasswordway1Component}
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class AppAdminRoutingModule { }
