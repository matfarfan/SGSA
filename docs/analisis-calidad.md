# Análisis de calidad externa e interna del SGSA

## Etapa 2 — Evaluación de calidad del sistema base

Este documento analiza la calidad externa e interna del Sistema de Gestión de Solicitudes Académicas (SGSA), desarrollado en Java 21. El objetivo es identificar fortalezas y limitaciones antes de aplicar mejoras mediante SOLID, Clean Code y refactoring.

## 1. Calidad externa

La calidad externa evalúa el funcionamiento del sistema desde la perspectiva del usuario, considerando sus funcionalidades, facilidad de uso y respuesta ante errores.

### 1.1. Funcionalidad

El SGSA permite registrar, listar, buscar y filtrar solicitudes, asignar responsables, modificar estados y generar reportes. Las pruebas manuales realizadas confirmaron el funcionamiento de estas operaciones en los casos evaluados.

### 1.2. Usabilidad

El sistema utiliza un menú numerado mediante consola, con mensajes que orientan al usuario. Su funcionamiento es sencillo, aunque la interfaz es limitada.

### 1.3. Manejo de errores

El sistema informa cuando una solicitud no existe y valida que la opción del menú sea numérica. Sin embargo, otras entradas no cuentan con las mismas validaciones, lo que puede provocar errores ante datos incorrectos.

### 1.4. Confiabilidad

Las pruebas manuales verificaron que los cambios de estado y responsable se reflejan correctamente en las consultas posteriores. No obstante, todavía no se evaluaron todos los escenarios posibles.

### 1.5. Persistencia

Las solicitudes se almacenan temporalmente en un `ArrayList`. Al cerrar el programa, la información se pierde porque no existe almacenamiento permanente.

### 1.6. Evidencias

Las capturas de las pruebas manuales se encuentran en:

`docs/evidencias/estado-inicial/`

Estas evidencias respaldan el funcionamiento observado en la versión inicial del sistema.

## 2. Calidad interna

La calidad interna analiza la estructura del código, su organización y la facilidad para realizar modificaciones sin afectar el funcionamiento del sistema.

### 2.1. Organización del código

El SGSA está compuesto por cinco clases: `Main`, `Estudiante`, `Responsable`, `Solicitud` y `SistemaSolicitudes`. Esta separación permite identificar las entidades principales y las operaciones del sistema.

### 2.2. Responsabilidades

La clase `Main` concentra el menú, la entrada de datos y la interacción con el usuario. Por su parte, `SistemaSolicitudes` administra las solicitudes, realiza búsquedas, modifica estados y genera reportes.

Esta acumulación de tareas dificulta la separación de responsabilidades y puede afectar la mantenibilidad.

### 2.3. Legibilidad

El código utiliza nombres descriptivos para las clases y los métodos, lo que facilita su comprensión. Sin embargo, existen bloques extensos y operaciones que podrían organizarse en métodos más pequeños.

### 2.4. Acoplamiento

`Main` depende directamente de las clases del sistema, mientras que `SistemaSolicitudes` combina la gestión de solicitudes con la presentación de resultados mediante `System.out.println()`.

Esto genera dependencias entre la lógica del sistema y la interfaz de consola.

### 2.5. Mantenibilidad

La estructura actual permite implementar las funcionalidades básicas, pero algunas responsabilidades concentradas y validaciones dispersas pueden dificultar futuras modificaciones.

### 2.6. Evaluación general

El SGSA cumple las funciones principales verificadas, aunque presenta oportunidades de mejora en la distribución de responsabilidades, la organización del código y la separación entre lógica y presentación.

Estas observaciones servirán como base para identificar deuda técnica y *code smells* en las siguientes etapas del TPI.

## 3. Deuda técnica identificada

El análisis inicial del SGSA permitió detectar limitaciones que pueden afectar su mantenimiento y evolución.

Entre las principales se encuentran la concentración de responsabilidades en `Main`, la combinación de lógica y presentación en `SistemaSolicitudes`, las validaciones incompletas y el uso de cadenas de texto para representar estados.

También se identificó la ausencia de persistencia de datos, una limitación del prototipo que deberá considerarse al evaluar su evolución.

Estos aspectos serán analizados con mayor profundidad en la siguiente etapa para identificar *code smells*, evaluar su impacto y establecer prioridades de mejora.