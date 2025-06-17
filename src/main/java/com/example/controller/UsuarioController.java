package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
@Controller
public class UsuarioController {
        @GetMapping("/user")
    public String mostrarVistaModerador() {
        return "user/user"; // <-- Esto busca templates/admin/admin.html
    }
}
