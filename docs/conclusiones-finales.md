# Conclusiones finales — SGSA

## 1. Resultados del trabajo

El Trabajo Práctico Integrador permitió analizar y mejorar la calidad del código del Sistema de Gestión de Solicitudes Académicas (SGSA), aplicando los principios SOLID, las buenas prácticas de Clean Code y técnicas de refactoring.

Se identificaron problemas de diseño y deuda técnica en la versión inicial, y se realizaron cuatro refactorings controlados:

- **Extract Method:** permitió organizar el código de `Main` en métodos más pequeños.
- **Move Method:** separó parcialmente la presentación de solicitudes de su gestión.
- **Introduce Parameter Object:** simplificó la construcción de solicitudes mediante `DatosSolicitud`.
- **Replace String with Enum:** mejoró el control de los estados válidos.

## 2. Verificación de resultados

Se ejecutaron **14 pruebas automatizadas de regresión** antes y después de los cambios, obteniendo resultados satisfactorios en ambas versiones.

También se verificó manualmente el manejo de estados inválidos.

El repositorio de GitHub conserva las versiones `estado-inicial` y `estado-refactorizado`, permitiendo identificar y comparar la evolución del sistema.

## 3. Aprendizajes y mejoras pendientes

El trabajo permitió comprender la importancia de identificar problemas de diseño antes de modificar el código, realizar cambios graduales y comprobar que las funcionalidades existentes continúen funcionando.

La revisión de código permitió reconocer oportunidades de mejora relacionadas con la validación de entradas, la separación de responsabilidades y el control de identificadores duplicados.

## 4. Conclusión general

Los refactorings aplicados mejoraron la legibilidad, organización y mantenibilidad del SGSA sin alterar su comportamiento esperado.

La combinación de análisis de calidad, pruebas automatizadas, Code Review y control de versiones permitió desarrollar un proceso de mejora documentado, verificable y acorde con las buenas prácticas de ingeniería de software.