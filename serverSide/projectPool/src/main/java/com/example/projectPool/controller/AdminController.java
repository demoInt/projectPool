package com.example.projectPool.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.projectPool.dto.ChangePasswordDTO;
import com.example.projectPool.dto.LoginDTO;
import com.example.projectPool.dto.ForgotPasswordDTO;
import com.example.projectPool.entity.AppUser;
import com.example.projectPool.service.AppUserService;
import com.example.projectPool.service.MailService;

@RestController
@RequestMapping("admin")
@CrossOrigin
public class AdminController {
	
	@Autowired
	private AppUserService appUserService ;
	
	@Autowired
	private MailService mailService ;
	
	@PostMapping("login")
	public ResponseEntity<LoginDTO> login(@RequestBody LoginDTO loginDTO)
	{
		AppUser appUser = appUserService.login(loginDTO) ; 
		
		if(appUser == null) {
			loginDTO.setStatus("Login Failed , Username not found");
		}
		else 
		{
			loginDTO.setStatus("Login Success");
			loginDTO.setRole(appUser.getRole());
			if(appUser.getStatus() == 0)
			{
				loginDTO.setStatus("Please Activate Your Email Before LoggingIn");
			}
		}
		return ResponseEntity.ok(loginDTO);
	}
	
	@PostMapping("changePassword")
	public ResponseEntity<ChangePasswordDTO> changePassword(@RequestBody ChangePasswordDTO changePasswordDTO)
	{
		AppUser appUser = appUserService.findByEmail(changePasswordDTO.getEmail()) ;
		changePasswordDTO.setMessage("Password incorrect ");
		changePasswordDTO.setStatus(false);
		
		if(appUser.getPassword().equals(changePasswordDTO.getOldPassword()))
		{
			appUser.setPassword(changePasswordDTO.getNewPassword());
			appUserService.update(appUser);
			changePasswordDTO.setMessage("Password Changed SuccessFully");
			changePasswordDTO.setStatus(true);
		}		
		return ResponseEntity.ok(changePasswordDTO);
	}	
	
	@PostMapping("forgotPassword")
	public ResponseEntity<ForgotPasswordDTO> forgotPassword(@RequestBody ForgotPasswordDTO forgotPasswordDTO) throws Exception
	{
		AppUser appUser = appUserService.findByEmail(forgotPasswordDTO.getEmail());
		
		if(appUser == null)
		{
			forgotPasswordDTO.setMessage("Email Doesn't Exist");
			forgotPasswordDTO.setStatus(false);
		}
		else
		{
			String activationCode = mailService.passwordResetLink(forgotPasswordDTO.getEmail());
			appUser.setActivationCode(activationCode);
			appUserService.update(appUser);
			
			forgotPasswordDTO.setMessage("Password reset link sent to registered email");
			forgotPasswordDTO.setStatus(true);
		}
		
		return ResponseEntity.ok(forgotPasswordDTO) ;
	}
	
	@GetMapping("resetPasswordLink")
	public ResponseEntity<ForgotPasswordDTO> resetLink(@RequestParam String email ,
													   @RequestParam String activationCode,
													   @RequestParam String password )
	{
		return ResponseEntity.ok(appUserService.reset(email,activationCode,password));
	}
	
}
