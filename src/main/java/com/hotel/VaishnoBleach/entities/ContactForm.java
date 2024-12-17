package com.hotel.VaishnoBleach.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "contactform")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ContactForm {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String name;
    private String email;
    private String subject;
    private String message;
    private String createdAt;
}
