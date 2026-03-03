# Sistema de Notas Académicas

Sistema de gestión de notas desarrollado en Java,
aplicando los principios de Programación Orientada a Objetos.

##  Arquitectura
El proyecto sigue una arquitectura en capas:
- Model → Entidades del dominio
- DAO → Persistencia en archivos .txt
- Service → Lógica de negocio
- View → Menú en consola

## Conceptos POO aplicados
- Abstracción (clase Persona abstracta)
- Herencia (Estudiante y Docente extienden Persona)
- Polimorfismo (mostrarInfo() en cada subclase)
- Encapsulamiento (atributos private con getters/setters)
- Interfaces (IEvaluable implementada por Estudiante)

## Estructura del proyecto

SistemaNotas/
├── src/
│   └── sistemanotas/
│       ├── model/
│       ├── dao/
│       ├── service/
│       ├── view/
│       └── Main.java
├── datos/
│   ├── estudiantes.txt
│   ├── docentes.txt
│   ├── asignaturas.txt
│   └── notas.txt
├── .gitignore
└── README.md

## Autor
Ing. Alfredo Bautista — Universidad Popular del Cesar  
Programación de Computadores III
