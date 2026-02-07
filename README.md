# Práctica 2. Creación API REST

## Descripción

La práctica trata de desarrollar una API REST utilizando Spring Boot.

La API realiza las operaciones CRUD (Create, Read, Update, Delete) sobre el recurso carrito.

Un carrito tiene:
- idCarrito: identificador único del carrito
- idArticulo: identificador del artículo
- descripción: descripción del artículo
- unidades: número de unidades
- precioFinal: importe total del carrito

El precio final se calcula como: precioFinal = unidades x 9.99.

## Endpoints

| Método | Ruta | Cuerpo | Descripción | Respuestas

| POST | '/api/carritos' | '{"idCarrito" : "1", "idArticulo" : "101", "descripcion" : "Camiseta", "unidades" : 2}' | Crea un nuevo carrito | 201, 409 |
| GET | '/api/carritos' | - | Lista todos los carritos | 200 |
| GET | '/api/carritos/{idCarrito}' | - | Obtiene un carrito por su id | 200, 404 |
| PUT | '/api/carritos/{idCarrito}' | '{"idArticulo" : "101", "descripcion" : "Camiseta M", "unidades" : 3}' | Actualiza un carrito que ya existe | 200, 404 |
| DELETE | '/api/carritos/{idCarrito}' | - | Elimina un carrito por su id | 204, 404 |

