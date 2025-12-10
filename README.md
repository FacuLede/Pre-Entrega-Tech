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
  "name": "Zanahoria",
  "price": 60.0,
  "stock": 90,
  "description": "Hortaliza"
}
```

**Respuesta:**\
Objeto `ProductResponse` actualizado.

------------------------------------------------------------------------

### 5. Eliminar un producto

**DELETE** `/api/products/{id}`

------------------------------------------------------------------------

# Order API - Endpoints

Base URL: `/api/orders`

## Endpoints

### 1. Obtener todos los pedidos

**GET** `/api/orders`

**Respuesta:**\
Lista de `OrderResponse`.

------------------------------------------------------------------------

### 2. Obtener un pedido por ID

**GET** `/api/orders/{id}`

**Parámetros:**\
- `id` (Long): identificador del pedido.

**Respuesta:**\
Objeto `OrderResponse`.

------------------------------------------------------------------------

### 3. Crear un pedido

**POST** `/api/orders`

**Body (JSON - OrderRequest):**

``` json
{
  "orderDetails": [
    { "productId": 1, "quantity": 2 },
    { "productId": 3, "quantity": 1 }
  ]
}
```

**Respuesta:**\
Objeto `OrderResponse` creado.

------------------------------------------------------------------------

### 4. Actualizar un pedido

**PUT** `/api/orders/{id}`

**Body (JSON - OrderRequest):**

``` json
{
  "id": 5,
  "orderDetails": [
    { "productId": 1, "quantity": 1 },
    { "productId": 4, "quantity": 3 }
  ]
}
```

**Respuesta:**\
Objeto `OrderResponse` actualizado.

------------------------------------------------------------------------

### 5. Eliminar un pedido

**DELETE** `/api/orders/{id}`

