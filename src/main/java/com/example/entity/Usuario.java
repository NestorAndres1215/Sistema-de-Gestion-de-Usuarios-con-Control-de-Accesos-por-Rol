package com.example.entity;


import jakarta.persistence.*;

@Entity
@Table(name = "usuarios")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String username;

    @Column(nullable = false)
    private String password;

    private boolean enabled = true;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "rol_id")
    private Rol rol; // ✅ Solo un rol, NO 'roles'

    // Constructores
    public Usuario() {
    }

    public Usuario(String username, String password, Rol roles) {
        this.username = username;
        this.password = password;
        this.rol = roles;
    }

    // Getters y Setters
    public Long getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

public Rol getRol() {
    return rol;
}

public void setRol(Rol rol) {
    this.rol = rol;
}
}