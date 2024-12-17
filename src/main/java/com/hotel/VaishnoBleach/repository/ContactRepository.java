package com.hotel.VaishnoBleach.repository;

import com.hotel.VaishnoBleach.entities.ContactForm;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContactRepository extends JpaRepository<ContactForm, Integer> {
}
