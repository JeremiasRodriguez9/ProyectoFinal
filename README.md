
# Proyecto Final AP

API Rest para el manejo de una Biblioteca. tiene un CRUD para manejar Libros, Autores y Editoriales.


## Tecnologias

- Spring Boot 3.1.5
- Spring Web
- PostgreSQL
- Lombok
- DBeaver


## Requisitos

- Java 17
- Maven
## Instalación
1. Clonar el repositorio: `git clone https://github.com/JeremiasRodriguez9/ProyectoFinal`
2. Importar el dump de la base de datos llamada dump-proyectofinal-202310311919
3. Modificar el archivo `application.properties` con las credenciales de la base de datos
4. Iniciar la aplicación
5. Acceder a la aplicación en `http://localhost:8080`


    
## Endpoints
- Hay un archivo exportado desde postman llamado ProyectoFinal.postman_collection donde estan todos los Endpoint a continuacion detallado:

| Endpoint                      | Metodo      | Descripción                                                    | Body                       |
|-------------------------------|-------------|----------------------------------------------------------------|----------------------------|
|                               |
| `/libros/findAll`                     | GET         | Lista todos los libros.                                        |                            |
| `/libros/findLibro?isbn={isbn}`         | GET         | Permite obtener un libro específico por su identificador.      |                            |
| `/libros/saveLibro`                 | POST        | Registra un nuevo libro.                                       | `Ver ejemplo 1`            |
| `/libros/updateLibro`       | POST        | Actualiza un libro ya existente.                               | `Ver ejemplo 2`            |
| `/libros/delete?isbn={isbn}`       | POST      | Elimina de forma permanente un libro.                              |                            |
| `/libros/baja?isbn={isbn}`      | POST| Da de baja un libro (Eliminacion logica)
|                               |
| `/libros/alta?isbn={isbn}`      | POST| Da de alta un libro (Restauracion logica)                     |                            |
| `/libros/prestar?isbn={isbn}`      | POST| Hace la funcion de prestar libro                     |                            |
| `/autores/findAllAutores`                   | GET         | Lista de todos los autores.                                    |                            |
| `/autores/findAutor?id={id}`       | GET         | Permite obtener un autor específico por su identificador.      |                            |
| `/autores/saveAutor`               | POST        | Registra un nuevo autor.                                         | `{"id": 5,"nombre": "Pedro Sánchez""alta": true}` |
| `/autores/updateAutor`         | POST        | Permite modificar un autor específico.             | `{"id": 5,"nombre": "Pedro Casco""alta": true}` |
| `/autores/baja?id={id}`     | POST        | Da de baja un autor(Eliminacion logica)                               |   |
| `/autores/alta?id={id}`     | POST        | Da de alta un autor(Restauracion logica)                               |   |
| `/autores/delete?id={id}`     | POST      | Elimina de forma permanente un autor.                              |                            |
| `/editoriales/findAllEditoriales`                | GET         | Lista de todas las editoriales.                                |                            |
| `/editoriales/findEditorial?id={id}`    | GET         | Permite obtener una editorial específica por su identificador. |                            |
| `/editoriales/saveEditorial`            | POST        | Registra una nueva editorial.                                    | `{"id": 2,"nombre": "Editorial B","alta": true}` |
| `/editoriales/updateEditorial`  | POST        | Permite modificar una editorial específica.                           | `{"id": 2,"nombre": "Editorial B","alta": true}`  |
| `/editoriales/baja?id={id}`  | POST      | Da de baja una editorial(Eliminacion logica)                         |                            |
| `/editoriales/alta?id={id}` | POST| Da de alta una editorial(Restauracion logica)                   |                            | 
| `/editoriales/delete?id={id}`    | POST | Elimina de forma permanente una editorial                       |                            |
|                               |

| Ejemplo 1 |
|-------------|
```
[POST] "/libros/saveLibro" 
BODY:
{
    "id": "10",
    "isbn": 9780123456789,
    "titulo": "Libro 10",
    "fechaPublicacion": "2018-09-14",
    "ejemplares": 100,
    "ejemplaresPrestados": 9,
    "ejemplaresRestantes": 91,
    "alta": true,
    "autores": [
        {
        "id": 13,
        "nombre": "Miguel Rodríguez",
        "alta": true
    },
    {
        "id": 14,
        "nombre": "Carmen Sánchez",
        "alta": true
    }
    ],
    "editorial": {
        "id": 10,
        "nombre": "Editorial J",
        "alta": true
    }
}
```
| Ejemplo 2 |
|--------------|
```
[PATCH] "/libros/updateLibro"
BODY:
{
    "id": "3",
    "isbn": 9783456789012,
    "titulo": "Libro 3",
    "fechaPublicacion": "2023-01-10",
    "ejemplares": 80,
    "ejemplaresPrestados": 5,
    "ejemplaresRestantes": 75,
    "alta": true,
    "autores": [
        {
            "id": 5,
            "nombre": "Pedro Sánchez",
            "alta": true
        },
        {
            "id": 8,
            "nombre": "Elena Herrera",
            "alta": true
        }
    ],
    "editorial": {
        "id": 3,
        "nombre": "Editorial C",
        "alta": true
    }
}