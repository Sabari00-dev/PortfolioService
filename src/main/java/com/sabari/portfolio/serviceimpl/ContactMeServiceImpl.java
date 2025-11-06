package com.sabari.portfolio.serviceimpl;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Service;

import com.sabari.portfolio.dto.ContactMe;
import com.sabari.portfolio.dto.ResponceDTO;
import com.sabari.portfolio.repository.ContactMeRepository;
import com.sabari.portfolio.service.ContactMeService;

import jakarta.transaction.Transactional;

@Service
public class ContactMeServiceImpl implements ContactMeService {

	ContactMeRepository contactMeRepository;
	MailSender mailSender;

	@Value(value = "${spring.mail.username}")
	String toMail;

	public ContactMeServiceImpl(ContactMeRepository contactMeRepository, MailSender mailSender) {
		this.contactMeRepository = contactMeRepository;
		this.mailSender = mailSender;
	}

	@Transactional
	@Override
	public ResponceDTO sentMail(ContactMe contactMe) {
		SimpleMailMessage mailMessage = new SimpleMailMessage();
		mailMessage.setFrom(contactMe.getEmail());
		mailMessage.setTo(toMail);
		mailMessage.setSubject("Contact Me");
		mailMessage.setText(contactMe.getEmail() + " | " + contactMe.getMessage() + " | " + contactMe.getMobileNo());
		mailSender.send(mailMessage);
		contactMeRepository.save(contactMe);
		return new ResponceDTO(true, "Your request has been sent successfully!");
	}

}
