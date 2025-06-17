package com.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.entity.Rol;
import com.example.entity.Usuario;
import com.example.repository.RolRepository;
import com.example.repository.UsuarioRepository;

import java.util.*;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private RolRepository rolRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    // Buscar usuario por nombre de usuario
    public Optional<Usuario> findByUsername(String username) {
        return usuarioRepository.findByUsername(username);
    }

    // Verificar si un usuario ya existe
    public boolean existsByUsername(String username) {
        return usuarioRepository.existsByUsername(username);
    }

    // Guardar nuevo usuario con un solo rol
    public Usuario saveUser(Usuario usuario, String nombreRol) {
        System.out.println("Guardando usuario: " + usuario.getUsername());

        // Buscar el rol correspondiente por su nombre
        Rol rol = rolRepository.findByNombre(nombreRol.trim())
                .orElseThrow(() -> new RuntimeException("Rol no encontrado: " + nombreRol));

        // Asignar el rol al usuario
        usuario.setRol(rol);

        // Codificar la contraseña
        usuario.setPassword(passwordEncoder.encode(usuario.getPassword()));

        // Guardar el usuario en la base de datos
        return usuarioRepository.save(usuario);
    }

    // Listar todos los usuarios
    public List<Usuario> findAll() {
        return usuarioRepository.findAll();
    }
}