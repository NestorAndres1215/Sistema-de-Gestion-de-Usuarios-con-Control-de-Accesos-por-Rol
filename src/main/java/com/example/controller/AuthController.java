package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;



import com.example.entity.Usuario;
import com.example.service.UsuarioService;

@Controller
public class AuthController {

    @Autowired
    private UsuarioService usuarioService;

    // ======= LOGIN =======
    @GetMapping("/login")
    public String mostrarLogin(@RequestParam(value = "error", required = false) String error,
            @RequestParam(value = "logout", required = false) String logout,
            @RequestParam(value = "registroExitoso", required = false) String registroExitoso,
            Model model) {
        if (error != null) {
            model.addAttribute("error", "Credenciales incorrectas");
        }
        if (logout != null) {
            model.addAttribute("logout", "Has cerrado sesión correctamente");
        }
        if (registroExitoso != null) {
            model.addAttribute("registroExitoso", true);
        }
        return "auth/login";
    }

    // ======= REGISTRO =======
    @GetMapping("/registro")
    public String mostrarFormularioRegistro(Model model) {
        model.addAttribute("usuario", new Usuario());
        return "auth/registro";
    }

    @PostMapping("/registro")
    public String registrarUsuario(@ModelAttribute Usuario usuario,
            @RequestParam("roles") String roles,
            Model model) {
        System.out.println("Roles recibidos: " + roles);
        // Validar que el usuario no exista
        if (usuarioService.existsByUsername(usuario.getUsername())) {
            model.addAttribute("error", "El usuario ya existe");
            return "auth/registro";
        }

        usuarioService.saveUser(usuario, String.join(",", roles));
        return "redirect:/login?registroExitoso=true";
    }

    // ======= REDIRECCIÓN POR ROL =======
    @GetMapping("/home")
    public String redireccionSegunRol(Authentication auth) {
        if (auth.getAuthorities().stream().anyMatch(a -> a.getAuthority().equals("ROLE_ADMIN"))) {
            return "redirect:/admin";
        } else if (auth.getAuthorities().stream().anyMatch(a -> a.getAuthority().equals("ROLE_MODERADOR"))) {
            return "redirect:/moderador";
        } else {
            return "redirect:/user";
        }
    }

    // ======= LISTADO DE USUARIOS (solo ADMIN) =======
    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/usuarios")
    public String listarUsuarios(Model model) {
        model.addAttribute("usuarios", usuarioService.findAll());
        return "admin/usuarios";
    }

}