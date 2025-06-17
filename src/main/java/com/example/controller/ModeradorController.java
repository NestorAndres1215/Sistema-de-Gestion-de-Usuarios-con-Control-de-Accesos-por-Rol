package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ModeradorController {
    @GetMapping("/moderador")
    public String mostrarVistaModerador() {
        return "moderador/moderador"; // <-- Esto busca templates/admin/admin.html
    }
}
