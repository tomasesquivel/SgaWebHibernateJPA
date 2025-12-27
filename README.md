# Sistema de Gestión de Alumnos (Java + Hibernate) ☕📚

> **Nota:** Este proyecto es una implementación manual ("Vanilla") diseñada para comprender la arquitectura de persistencia antes de migrar a frameworks automatizados como Spring Boot.

## 🎯 Objetivo del Proyecto
El propósito principal de este desarrollo no fue solo crear un CRUD, sino realizar una **"ingeniería inversa" conceptual** de cómo funcionan los ORM modernos.

En lugar de depender de la "magia" de `@Autowired` o `JpaRepository`, implementé manualmente:
* El ciclo de vida de las sesiones (`Session` y `Transaction`).
* La configuración programática de Hibernate (`persistence.xml`).
* El patrón de diseño **DAO** (Data Access Object) para desacoplar la lógica de negocio del acceso a datos.

## 🛠️ Tecnologías (Stack Técnico)
* **Lenguaje:** Java 8
* **ORM:** Hibernate 5.6.15.Final (Core)
* **Base de Datos:** MySQL (con driver JDBC)
* **Gestión de Dependencias:** Maven
* **Arquitectura:** MVC (Modelo-Vista-Controlador) manual.

## 📂 Estructura del Código
El proyecto sigue una arquitectura en capas clásica para asegurar la escalabilidad:

* `src/main/java/domain` ➡️ **Entidades:** Clases POJO anotadas con JPA (`@Entity`, `@Table`) que mapean las tablas de la BD.
* `src/main/java/dao` ➡️ **Acceso a Datos:** Aquí reside la lógica "dura" de Hibernate (métodos `save`, `update`, `delete`, `createQuery`).
* `src/main/java/dao` ➡️ **Configuración:** La clase `GenericDAO` que gestiona el patrón Singleton para la `EntityManagerFactory`.

## 🚀 Instalación y Uso
1.  **Clonar el repositorio:**
    ```bash
    git clone https://github.com/tomasesquivel/SgaWebHibernateJPA.git
    ```
2.  **Base de Datos:**
    * Crea una base de datos en MySQL llamada `gestion_alumnos`.
    * Configura tu usuario/password en el archivo `src/main/resources/META-INF/persistence.xml`.
3.  **Ejecución:**
    * Al correr la aplicación (`Main`), Hibernate generará automáticamente las tablas gracias a la propiedad `hbm2ddl.auto`.

## 🧠 Aprendizajes Clave
Durante el desarrollo me enfrenté a desafíos reales que fortalecieron mi comprensión del Backend:
* ✅ **Manejo de Transacciones:** Aprendí que sin un `commit()` explícito, los datos nunca viajan a la BD, aunque Java no de error.
* ✅ **Lazy vs Eager:** Comprendí cómo Hibernate trae los datos y los riesgos de pedir datos fuera de una sesión activa.
* ✅ **Inyección de Dependencias:** Al no tener Spring, tuve que instanciar mis servicios manualmente, lo que me enseñó el valor real de un contenedor IoC.

---
*Desarrollado por Tomás Esquivel- Estudiante de Análisis de Sistemas* 🚀
