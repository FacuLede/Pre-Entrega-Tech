# Product API - Endpoints

Base URL: `/api/products`

## Endpoints

### 1. Obtener todos los productos

**GET** `/api/products`

**Respuesta:**\
Lista de `ProductResponse`.

------------------------------------------------------------------------

### 2. Obtener un producto por ID

**GET** `/api/products/{id}`

**Parámetros:**\
- `id` (Long): identificador del producto.

**Respuesta:**\
Objeto `ProductResponse`.

------------------------------------------------------------------------

### 3. Crear un producto

**POST** `/api/products`

**Body (JSON - ProductRequest):**

``` json
{
  "name": "Zanahoria",
  "price": 50.0,
  "stock": 100,
  "description": "Hortaliza"
  
}
```

**Respuesta:**\
Objeto `ProductResponse` creado.

------------------------------------------------------------------------

### 4. Actualizar un producto

**PUT** `/api/products/{id}`

**Body (JSON - ProductRequest):**

``` json
{
  "name": "Nuevo nombre",
  "description": "Nueva descripción",
  "price": 1500.0
}
```

**Respuesta:**\
Objeto `ProductResponse` actualizado.

------------------------------------------------------------------------

### 5. Eliminar un producto

**DELETE** `/api/products/{id}`

