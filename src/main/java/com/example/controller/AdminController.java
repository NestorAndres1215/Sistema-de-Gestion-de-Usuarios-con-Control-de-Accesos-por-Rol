package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AdminController {

    @GetMapping("/admin")
    public String mostrarVistaAdmin() {
        return "admin/admin"; // Carga admin.html desde templates/admin/
    }
}