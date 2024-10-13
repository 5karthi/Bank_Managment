package com.BankManag.emailsender;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailServiceImpl implements EmailService {

    @Autowired
    private JavaMailSender javaMailSender;

    @Value("${spring.mail.username}")
    private String sender;

    @Override
    public String sendSimpleMail(String to, String subject, String texts) {
        try {
            // Creating a simple mail message
            SimpleMailMessage mailMessage = new SimpleMailMessage();

            // Setting up necessary details
            mailMessage.setFrom(sender);
            mailMessage.setTo(to);           // Corrected: Using the 'to' parameter
            mailMessage.setSubject(subject);  // Corrected: Using the 'subject' parameter
            mailMessage.setText(texts);       // Corrected: Using the 'texts' parameter

            // Sending the mail
            javaMailSender.send(mailMessage);
            return "Mail sent successfully";

        } catch (Exception e) {
            // Returning the exception message for debugging
            return "Error while sending mail: " + e.getMessage();
        }
    }

    // Remove the unused method if not needed
    @Override
    public String sendSimpleMail(EmailDetails details) {
        // This method can be left unimplemented or removed, depending on your needs
        return null;
    }
}
