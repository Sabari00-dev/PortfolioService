package com.sabari.portfolio.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sabari.portfolio.dto.ContactMe;

public interface ContactMeRepository extends JpaRepository<ContactMe, Integer> {

}
