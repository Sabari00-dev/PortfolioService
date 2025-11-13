package com.sabari.portfolio.serviceimpl;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.sabari.portfolio.dto.ContactMe;
import com.sabari.portfolio.dto.ResponceDTO;
import com.sabari.portfolio.repository.ContactMeRepository;
import com.sabari.portfolio.service.ContactMeService;
import com.sendgrid.Method;
import com.sendgrid.Request;
import com.sendgrid.Response;
import com.sendgrid.SendGrid;
import com.sendgrid.helpers.mail.Mail;
import com.sendgrid.helpers.mail.objects.Content;
import com.sendgrid.helpers.mail.objects.Email;

import jakarta.transaction.Transactional;

@Service
public class ContactMeServiceImpl implements ContactMeService {

	ContactMeRepository contactMeRepository;

	String toMail = "sabarikrishnan0107@gmail.com";

	@Value(value = "${sendgrid.api.key}")
	private String sendGridApiKey;

	public ContactMeServiceImpl(ContactMeRepository contactMeRepository) {
		this.contactMeRepository = contactMeRepository;
	}

	@Transactional
	@Override
	public ResponceDTO sentMail(ContactMe contactMe) {
//		SimpleMailMessage mailMessage = new SimpleMailMessage();
//		mailMessage.setFrom(contactMe.getEmail());
//		mailMessage.setTo(toMail);
//		mailMessage.setSubject("Contact Me");
//		mailMessage.setText(contactMe.getEmail() + " | " + contactMe.getMessage() + " | " + contactMe.getMobileNo());
//		mailSender.send(mailMessage);
//		contactMeRepository.save(contactMe);

		Email from = new Email(contactMe.getEmail()); // from email (must be verified)
		String subject = "New message from " + contactMe.getName();
		Email to = new Email(toMail); // where you want to receive mails
		Content content = new Content("text/plain",
				"From: " + contactMe.getEmail() + "\n\n" + contactMe.getMessage() + " | " + contactMe.getMobileNo());
		Mail mail = new Mail(from, subject, to, content);

		SendGrid sg = new SendGrid(sendGridApiKey);
		Request request = new Request();
		try {
			request.setMethod(Method.POST);
			request.setEndpoint("mail/send");
			request.setBody(mail.build());
			Response response = sg.api(request);
			System.out.println(response.getStatusCode());
			System.out.println(response.getBody());
			contactMeRepository.save(contactMe);
		} catch (IOException ex) {
			System.out.println(ex.getMessage());
			
		}
		return new ResponceDTO(true, "Your request has been sent successfully!");
	}

}
