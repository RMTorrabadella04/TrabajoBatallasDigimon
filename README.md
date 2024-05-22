## Digimon

## Atributos: nombre, nivel, puntos de ataque, salud, DP1, DP2.
Asignación de atributos:
Nombre: dado al registrar.
Nivel: aleatorio entre 1 y 5.
Puntos de ataque: 5 veces el nivel.
Salud: 10 veces el nivel.
DP1 y DP2: Inicialmente 10 cada uno.
Ataques:
Ataque1: daño igual a puntos de ataque, reduce DP1 en 1.
Ataque2: daño igual al doble de los puntos de ataque, reduce DP2 en 2.


## Domador

## Atributos: nombre, equipo (máximo 3 Digimon).
Métodos:
Constructor: asigna un Digimon aleatorio al equipo.
captura(Digimon): si el Digimon tiene 20 puntos menos de salud, se une al equipo; si no, no se une.


## BatallaDigital

Atributos: genera un Digimon enemigo aleatorio.
Métodos:
elige(): elige un Digimon del equipo del domador.
pelea(): elige el tipo de ataque o intenta capturar al enemigo.
Flujo Principal
Solicitar el nombre del domador.
Ofrecer opciones:
1. Iniciar batalla
2. Salir
En resumen, el programa permite a un domador registrar y usar Digimon en batallas, con la opción de capturar nuevos Digimon si cumplen con ciertos criterio, aparte de lo puesto tiene más clases que alijeran la carga de ejecución.
