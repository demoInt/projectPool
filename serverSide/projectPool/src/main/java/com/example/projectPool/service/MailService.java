package com.example.projectPool.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import jakarta.mail.internet.MimeMessage;

@Service
public class MailService {
	
	@Autowired
	private JavaMailSender javaMailSender ;
	
	public String sendEmailToVerify(String email) throws Exception
	{
		MimeMessage mime = javaMailSender.createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper(mime);
		
		helper.setTo(email);
		helper.setSubject("Verify Your Email Address");
		
		String activationCode = Util.generateActivationCode() ;		
		StringBuilder link = new StringBuilder() ;
		link.append("<h1>Click on below link to verify email</h1><br>") ;
		link.append("<a href='http://localhost:9090/appUser/verification/email/"+email+"/activationCode/"+activationCode+"'>Verify Email</a>") ;
		
		helper.setText(link.toString(),true);
		
		javaMailSender.send(mime);
		
		return activationCode ;
	}
	
	public String passwordResetLink(String email) throws Exception
	{
		MimeMessage mime = javaMailSender.createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper(mime);
		
		helper.setTo(email);
		helper.setSubject("Password Reset Form");
		String activationCode = Util.generateActivationCode() ;
		
		StringBuilder link = new StringBuilder() ;
		
		link.append("<h1>Reset Password</h1>");
		link.append("<form action='http://localhost:9090/admin/resetPasswordLink'>") ;
		link.append("<input type='hidden' name = 'email' value = '"+email+"'>") ;
		link.append("<input type='hidden' name = 'activationCode' value = '"+activationCode+"'>") ;
		link.append("New Password : <input type='password' name = 'password'><br>") ;
		link.append("<input type='submit' value ='Reset'><br>");
		link.append("<form>") ;
		
		helper.setText(link.toString(),true);
		
		javaMailSender.send(mime);
		
		return activationCode ;
	}
	
}
