package com.hotel.VaishnoBleach.controller;

import com.hotel.VaishnoBleach.entities.ContactForm;
import com.hotel.VaishnoBleach.repository.ContactRepository;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class ContactController {

    @Autowired
    private ContactRepository contactRepository;

    @RequestMapping("/contact")
    public String showContactForm() {
        return "contact";
    }

    // Handle form submission
    @PostMapping("/submitContactForm")
    public String submitContactForm(
            @RequestParam("name") String name,
            @RequestParam("email") String email,
            @RequestParam("subject") String subject,
            @RequestParam("message") String message,
            Model model) {

        // Create a new ContactForm object and populate it with form data
        ContactForm contactForm = new ContactForm();
        contactForm.setName(name);
        contactForm.setEmail(email);
        contactForm.setSubject(subject);
        contactForm.setMessage(message);
        contactForm.setCreatedAt(java.time.LocalDateTime.now().toString());  // Automatically set the created timestamp

        // Save the contact form data to the database
        contactRepository.save(contactForm);

        // Add a success message to the redirect attributes
        model.addAttribute("message", "Your message has been sent successfully!");

        // Redirect back to the contact form page
        return "redirect:/contact";
    }

    @GetMapping("/dashboard")
    public String showInquiries(Model model, HttpSession session) {
        if (session.getAttribute("admin") == null) {
            return "redirect:/login";
        }
        List<ContactForm> inquiries = contactRepository.findAll();
        model.addAttribute("inquiries", inquiries);
        return "admin/dashboard"; // Return inquiries.html
    }

    @GetMapping("/deleteInquiry")
    public String deleteInquiry(@RequestParam("id") int id) {
        contactRepository.deleteById(id);
        return "redirect:/dashboard";
    }
}
