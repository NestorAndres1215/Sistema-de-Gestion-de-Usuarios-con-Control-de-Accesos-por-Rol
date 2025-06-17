# 🔐 Sistema de Gestión de Usuarios con Control de Accesos por Rol

Este proyecto es una aplicación web desarrollada con **Spring Boot**, que implementa un sistema de autenticación y autorización basado en roles. Permite registrar, autenticar y controlar el acceso de usuarios según su perfil (ADMIN, USER o MODERADOR), integrando una interfaz dinámica y segura mediante **Thymeleaf** y **Spring Security**.

---

## ✨ Características Principales

- Autenticación de usuarios con formulario de login.
- Control de acceso basado en roles con reglas personalizadas.
- Navegación condicional y segura según el rol del usuario.
- Gestión de usuarios (CRUD) accesible solo por administradores.
- Páginas de error personalizadas (403, 404, 500).
- Diseño adaptable y estructurado con Thymeleaf.

---

## ⚙️ Tecnologías y Herramientas Utilizadas

| Tecnología            | Descripción de uso                                                                 |
|------------------------|------------------------------------------------------------------------------------|
| **Java 17**           | Lenguaje principal para el desarrollo del backend.                                 |
| **Spring Boot 3.x**   | Framework para la creación de aplicaciones web robustas y escalables.              |
| **Spring Security**   | Framework de seguridad para autenticación y control de acceso por roles.           |
| **Thymeleaf**         | Motor de plantillas para renderizado dinámico de páginas HTML desde el backend.    |
| **MySQL**             | Base de datos relacional para almacenamiento de usuarios, roles y credenciales.    |
| **Maven**             | Sistema de gestión de dependencias y construcción del proyecto.                    |
| **HTML/CSS**          | Tecnologías para estructurar y dar estilo a las vistas del sistema.                |

---

## 🧩 Estructura de Roles

| Rol           | Acceso permitido                       |
|---------------|----------------------------------------|
| `ROLE_ADMIN`  | Panel de administración, gestión de usuarios (`/admin`, `/usuarios`). |
| `ROLE_USER`   | Panel de usuario (`/user`).            |
| `ROLE_MODERADOR` | Panel de moderación (`/moderador`). |

El sistema evalúa el rol del usuario autenticado para permitir o denegar el acceso a ciertas rutas protegidas.

---

## 📄 Páginas de Error Personalizadas

| Código | Archivo        | Descripción                                      |
|--------|----------------|--------------------------------------------------|
| 403    | `403.html`     | Acceso denegado: el usuario no tiene permisos.  |
| 404    | `404.html`     | Página no encontrada.                           |
| 500    | `500.html`     | Error interno del servidor.                     |

Estas vistas permiten una mejor experiencia de usuario en casos de errores.

---



## 📸 Capturas de Pantalla

A continuación se muestran algunas pantallas del sistema según el rol del usuario:

---

### 🔐 Página de Login
Formulario donde los usuarios ingresan su nombre de usuario y contraseña.

![Login](docs/screenshots/login.png)

---

### 📝 Página de Registro
Formulario de creación de cuenta para nuevos usuarios.

![Registro](docs/screenshots/registro.png)

---

### 🧑‍💼 Panel de Administrador
Vista principal del administrador con acceso a la gestión de usuarios.

![Panel Admin](docs/screenshots/panel-admin.png)

---

### 📋 Listado de Usuarios (Solo ADMIN)
Tabla donde se muestran todos los usuarios registrados con su rol asignado.

![Listado de Usuarios](docs/screenshots/listado-usuarios.png)

---

### 👤 Panel de Usuario
Vista personalizada para el usuario con las opciones disponibles según su rol.

![Panel Usuario](docs/screenshots/panel-user.png)

---

### 🛡️ Panel de Moderador
Vista exclusiva para moderadores donde pueden gestionar ciertos recursos.

![Panel Moderador](docs/screenshots/panel-moderador.png)

---
