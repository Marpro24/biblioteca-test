# Biblioteca CRUD con Java y PostgreSQL 

## Descripción

Este proyecto implementa un sistema CRUD (Crear, Leer, Actualizar, Eliminar) para la gestión de libros en una biblioteca utilizando Java, PostgreSQL y el patrón de arquitectura MVC.

## Tecnologías Utilizadas

Java: Lenguaje de programación principal del proyecto.

Maven: Sistema de gestión de dependencias y construcción del proyecto.

PostgreSQL: Base de datos relacional utilizada para almacenar la información de los libros.

JDBC: Para la conexión entre Java y PostgreSQL.

## Arquitectura del Proyecto

El proyecto sigue el patrón Modelo-Vista-Controlador (MVC):

Modelo (Book, BookDAO): Representa los datos y la lógica de negocio.

Vista (BookView): Interfaz de usuario en la terminal para interactuar con el usuario.

Controlador (BookController): Maneja la comunicación entre la vista y el modelo.

## Funcionalidades

Crear un libro.

Buscar un libro por título.

Actualizar un libro.

Eliminar un libro.

## Instalación y Configuración

### Clonar el repositorio:

git clone (https://github.com/Marpro24/biblioteca-test.git)
cd biblioteca-test

### Configurar la base de datos PostgreSQL:

Crear la base de datos:

CREATE DATABASE biblioteca;

Crear la tabla book:

CREATE TABLE book (
    id SERIAL PRIMARY KEY,
    title VARCHAR(255),
    genre VARCHAR(100),
    author VARCHAR(255),
    description TEXT,
    isbn BIGINT
);

### Configurar la conexión en DBManager.java:

private static final String URL = "jdbc:postgresql://localhost:5432/biblioteca";
private static final String USER = "tu_usuario";
private static final String PASSWORD = "tu_contraseña";

### Compilar y ejecutar:

mvn clean package
java -jar target/biblioteca-crud.jar

## Uso del Sistema

El sistema presenta un menú con las siguientes opciones:

1. Crear un libro

2. Actualizar un libro

3. Buscar un libro por título

4. Eliminar un libro

5. Salir

El usuario puede ingresar la opción deseada y seguir las instrucciones en la terminal.

### Autoría 
[Marta Ibarra](https://github.com/Marpro24)
[Milena Okoro](https://github.com/MilenaOcoro)
[Mariuxi Olaya](https://github.com/catmaluci)
[Tetiana Vaschenko ](https://github.com/Tetiana-BCN)
[Karisha Meléndez](https://github.com/karisssha)

![gif](https://i.giphy.com/qJFNKmwkglLZPPOHd7.webp)
