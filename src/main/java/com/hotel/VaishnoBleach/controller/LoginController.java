package com.hotel.VaishnoBleach.controller;

import com.hotel.VaishnoBleach.entities.Login;
import com.hotel.VaishnoBleach.repository.LoginRepository;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginController {

    @Autowired
    private LoginRepository loginRepository;

    @RequestMapping("/login")
    public String showLoginForm() {
        return "admin/login";
    }

    @PostMapping("/login")
    public String login(String email, String password, Model model, HttpSession session) {
        Login admin = loginRepository.findByEmail(email);
        if (admin != null && admin.getPassword().equals(password)) {
            session.setAttribute("admin", admin); // Store admin info in session
            return "redirect:/dashboard";
        }
        model.addAttribute("error", "Invalid email or password"); // Add error message
        return "admin/login"; // Redirect back to login page
    }

    @RequestMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate(); // Invalidate the session
        return "redirect:/login"; // Redirect to login page
    }
}
