# Fibonacci Rest API

## Descripción
Este proyecto es una API REST que calcula el valor de Fibonacci para un índice dado. Utiliza Spring Boot y sigue una arquitectura hexagonal para mantener una separación clara entre las capas de aplicación y las capas de infraestructura.

## Características
- Calcula el valor de Fibonacci para un índice dado.
- Utiliza una arquitectura hexagonal para separar las capas de la aplicación y la infraestructura.
- Manejo de errores para casos como índices negativos o no válidos.

## Uso
### Endpoints
- `GET /fibonacci/{n}`: Calcula el valor de Fibonacci para el índice `n`.

### Ejemplos
- Calcular Fibonacci para el índice 5:
    - `GET /fibonacci/10`: Respuesta: 5
- Calcular Fibonacci para el índice 10:
    - `GET /fibonacci/10`: Respuesta: 55
- Calcular Fibonacci para el índice -3:
    - `GET /fibonacci/-3`: Respuesta: Error 400 (Bad Request). Mensaje: Index cannot be negative.


## Configuración
- Asegúrate de tener Java y Gradle instalados en tu sistema.
- Clona este repositorio en tu máquina local.

## Ejecución
1. Abre una terminal y navega hasta la raíz del proyecto.
2. Ejecuta el siguiente comando para compilar y ejecutar la aplicación:
```bash
gradle bootRun
```
3. La aplicación estará disponible en `http://localhost:8080`.

## Pruebas Unitarias
El proyecto incluye pruebas unitarias para garantizar su funcionamiento correcto. Puedes ejecutar las pruebas utilizando el siguiente comando:
```bash
gradle test
```

## Futuras mejoras
- Creación de modelos para devolver una respuesta estandarizada
- Implementación de seguridad en el api, ejemplo JWT
