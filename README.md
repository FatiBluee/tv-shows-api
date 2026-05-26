# TV Shows Management API 

Este proyecto consiste en una **API REST** desarrollada en el ecosistema de Java con Spring Boot. El sistema está diseñado para gestionar un catálogo de series de televisión, actores, agencias y biografías de forma eficiente, implementando las mejores prácticas de arquitectura en capas, validación de datos y seguridad.

---

##  Características Principales

*   **Arquitectura Limpia (En Capas):** Separación estricta de responsabilidades utilizando el patrón **Controller-Service-Repository** para un código mantenible y desacoplado mediante el uso de interfaces.
*   **Modelo de Datos Relacional Avanzado:** Mapeo de entidades complejas utilizando Hibernate/JPA, gestionando relaciones **One-to-One**, **One to Many** y **Many-to-Many** eficientemente.
*   **Operaciones CRUD Completas:** Implementación de endpoints REST optimizados con soporte para actualizaciones parciales (`PATCH`) y totales (`PUT`).
*   **Seguridad Estructurada:** Configuración base de filtros con **Spring Security** y almacenamiento seguro de credenciales en la base de datos utilizando el algoritmo de hashing **BCrypt**.
*   **Validación del Lado del Servidor:** Integración de reglas de validación en DTOs mediante Jakarta Validation para asegurar la integridad de los datos entrantes.
*   **Código Limpio:** Implementación de **Lombok** para reducir el código repetitivo (*boilerplate*) y optimizar el desarrollo.

---

##  Tecnologías y Herramientas

*   **Lenguaje:** Java 21 (LTS)
*   **Framework Principal:** Spring Boot 4.0.x
*   **Persistencia & ORM:** Spring Data JPA / Hibernate
*   **Base de Datos:** MySQL (Diseñada con MySQL Workbench)
*   **Seguridad:** Spring Security (Criptografía BCrypt)
*   **Validación:** Jakarta Validation (`spring-boot-starter-validation`)
*   **Productividad:** Project Lombok
*   **Pruebas de Endpoints:** Postman

---

## 📂 Arquitectura del Proyecto

El código fuente está organizado bajo una estructura de paquetes limpia que garantiza la separación de conceptos:

*   `config`: Configuraciones globales de la aplicación (Filtros de Seguridad, Beans, etc.).
*   `controllers`: Capa de exposición que gestiona las peticiones HTTP y define los endpoints REST.
*   `dtos` *(Data Transfer Objects)*: Objetos para la transferencia selectiva y validación de datos entre cliente y servidor.
*   `models`: Entidades del dominio (*Actors, Agency, Biography, Shows, Users*) y Enums de configuración de roles.
*   `repositories`: Interfaces que extienden de JPA Repository para la abstracción de consultas a la base de datos.
*   `services`: Capa de lógica de negocio organizada mediante interfaces y clases de implementación para maximizar el desacoplamiento.

---

## 🔐 Configuración de Seguridad

La API cuenta con una arquitectura de seguridad centralizada:
*   Desactivación temporal de protección CSRF para pruebas en entorno de desarrollo.
*   Inyección de un componente `PasswordEncoder` configurado con **BCrypt** para automatizar el hasheo de contraseñas de los usuarios al persistirlos en el sistema.

---

## 🚥 Endpoints Principales (Testeo en Postman)

El comportamiento de la API fue completamente validado mediante una colección automatizada en **Postman** cubriendo los siguientes flujos:

### Gestión de Actores (`/api/actors` o ruta correspondiente)
*   `GET` - Recuperar la lista completa de actores.
*   `GET /{name}` - Búsqueda parametrizada de actores por su nombre.
*   `POST` - Creación de un nuevo registro de actor.
*   `PUT /{id}` - Actualización completa de la entidad del actor.
*   `PATCH /{id}` - Actualización parcial (Optimizado mediante un DTO específico para modificar únicamente el nombre).
*   `DELETE /{id}` - Eliminación física del registro por su identificador único.

### Gestión de Usuarios (`/api/users` o ruta correspondiente)
*   `POST` - Registro de nuevos usuarios en el sistema, asignando por defecto el rol `USER` y aplicando cifrado criptográfico a la contraseña antes del almacenamiento.
