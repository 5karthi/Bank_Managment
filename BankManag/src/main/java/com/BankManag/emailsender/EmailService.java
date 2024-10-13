package com.BankManag.emailsender;


public interface EmailService {

	String sendSimpleMail(EmailDetails details);

	String sendSimpleMail(String to, String subject, String text);
}