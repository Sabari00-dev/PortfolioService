package com.sabari.portfolio.service;

import com.sabari.portfolio.dto.ContactMe;
import com.sabari.portfolio.dto.ResponceDTO;

public interface ContactMeService {

	ResponceDTO sentMail(ContactMe contactMe) ;

}
