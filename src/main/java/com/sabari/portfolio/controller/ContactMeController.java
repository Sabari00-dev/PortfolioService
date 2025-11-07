package com.sabari.portfolio.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sabari.portfolio.dto.ContactMe;
import com.sabari.portfolio.dto.ResponceDTO;
import com.sabari.portfolio.service.ContactMeService;

@RestController
@RequestMapping("contact-me")
@CrossOrigin(origins = "*")
public class ContactMeController {
	private ContactMeService contactMeService;

	public ContactMeController(ContactMeService contactMeService) {
		this.contactMeService = contactMeService;
	}

	@PostMapping("sentmail")
	public ResponceDTO sentMail(@RequestBody ContactMe contactMe) {
		return contactMeService.sentMail(contactMe);
	}
}
