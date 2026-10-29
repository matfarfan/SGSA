# Análisis de principios SOLID y Clean Code — SGSA

## Etapa 4 — Evaluación del código original

Este documento analiza la aplicación de los principios SOLID y las buenas prácticas de Clean Code en el Sistema de Gestión de Solicitudes Académicas (SGSA), con el objetivo de identificar oportunidades de mejora antes del refactoring.

## 1. Análisis de principios SOLID

### 1.1. SRP — Principio de responsabilidad única

**Estado:** cumplimiento parcial.

La clase `Main` concentra el menú, la entrada de datos y la coordinación de operaciones. Además, `SistemaSolicitudes` combina la gestión de solicitudes con la presentación de mensajes por consola.

**Mejora propuesta:** separar las responsabilidades de interacción, presentación y gestión.

### 1.2. OCP — Principio abierto/cerrado

**Estado:** presenta limitaciones.

Las opciones del menú se encuentran definidas directamente en `Main` mediante un `switch`. Agregar nuevas operaciones requiere modificar este bloque.

**Mejora propuesta:** organizar las operaciones en componentes que faciliten futuras ampliaciones. El uso de `switch` no constituye por sí solo una infracción del principio.

### 1.3. LSP — Principio de sustitución de Liskov

**Estado:** no aplicable directamente.

El sistema original no presenta jerarquías de herencia ni implementaciones polimórficas que permitan evaluar la sustitución entre subtipos.

**Mejora propuesta:** considerar este principio si posteriormente se incorporan jerarquías de clases.

### 1.4. ISP — Principio de segregación de interfaces

**Estado:** no evaluable directamente.

El código original no define interfaces que obliguen a las clases a implementar operaciones innecesarias.

**Mejora propuesta:** diseñar interfaces específicas si la evolución del sistema requiere separar contratos.

### 1.5. DIP — Principio de inversión de dependencias

**Estado:** presenta limitaciones.

`Main` utiliza directamente `SistemaSolicitudes`, mientras que esta clase depende de la salida por consola mediante `System.out.println()`.

**Mejora propuesta:** reducir el acoplamiento entre la lógica del sistema y la presentación, incorporando abstracciones cuando aporten una mejora concreta.

## 2. Conclusión del análisis SOLID

El principal problema identificado se relaciona con la distribución de responsabilidades y el acoplamiento entre la lógica del sistema y la interfaz de consola.

Los principios SRP, OCP y DIP ofrecen oportunidades de mejora. LSP e ISP no pueden evaluarse directamente debido a la estructura actual del proyecto.

Este análisis permitirá fundamentar los refactorings posteriores sin incorporar complejidad innecesaria.

## 3. Análisis de Clean Code

Clean Code propone escribir código claro, organizado y fácil de mantener. A continuación, se evalúan las principales prácticas en el SGSA.

### 3.1. Nombres descriptivos

**Estado:** cumplimiento adecuado.

Las clases y los métodos utilizan nombres comprensibles, como `Solicitud`, `registrarSolicitud()` y `buscarSolicitudPorId()`, lo que facilita interpretar su propósito.

### 3.2. Métodos pequeños y responsabilidades claras

**Estado:** requiere mejoras.

El método `main()` concentra numerosas operaciones dentro de un `switch`, mientras que `SistemaSolicitudes` combina tareas de gestión y presentación.

**Mejora propuesta:** aplicar *Extract Method* y distribuir las responsabilidades.

### 3.3. Evitar duplicación y valores mágicos

**Estado:** cumplimiento parcial.

Existen operaciones similares de lectura de datos y valores numéricos utilizados directamente para seleccionar opciones.

**Mejora propuesta:** crear métodos reutilizables y constantes descriptivas cuando corresponda.

### 3.4. Validación y manejo de errores

**Estado:** requiere mejoras.

El programa valida la entrada numérica del menú principal, pero no aplica controles equivalentes en todos los campos. Tampoco impide registrar identificadores duplicados.

**Mejora propuesta:** centralizar las validaciones y controlar los datos antes de procesarlos.

### 3.5. Separación de responsabilidades

**Estado:** requiere mejoras.

`SistemaSolicitudes` utiliza `System.out.println()` para mostrar resultados, lo que vincula la lógica del sistema con la consola.

**Mejora propuesta:** separar el procesamiento de datos de su presentación.

## 4. Conclusión general

El SGSA presenta nombres descriptivos y una estructura básica comprensible. Sin embargo, se identifican oportunidades de mejora en la organización de métodos, las validaciones y la separación de responsabilidades.

Los resultados del análisis SOLID y Clean Code servirán para planificar refactorings controlados, buscando mejorar la calidad interna sin alterar las funcionalidades existentes.