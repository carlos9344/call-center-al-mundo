﻿Call Center
===============

# Consideraciones

### Diseño
Ver diagramas de clases y de secuencia adjuntos.
### Explicación de los puntos adicionales
1. Dar alguna solución sobre qué pasa con una llamada cuando no hay ningún empleado libre.

Cuando no hay ningún empleado libre, se intenta asignar la llamada hasta que el empleado se libera.
Ver test NoAvailableEmployeeScenarioTest (se reiteran los intentos hasta que todas las llamadas son atendidas).

2. Dar alguna solución sobre qué pasa con una llamada cuando entran más de 10 llamadas concurrentes:

Cuando entran mas de 10 llamadas estas serán puestas en una cola de espera hasta que se libere una llamada en curso. Esto lo resuelve el java.util.concurrent.Executors.ExecutorService. El mismo, va a poner en una cola de espera las llamadas nuevas (tasks o runnables), hasta que un thread termine de ejecutar una tarea y se libere un slot del pool. Entonces se ejecuta la primer tarea en la queue y se utiliza en thead disponible (y así con el resto).


### Otras consideraciones

1. La aplicación se ejecuta desde el main method del MainController (se simula un pool de 2 llamadas).
2. Las 10 llamadas de la consigna principal se simulan en el test runTenCalls en CallCenterTest.



### Inicialización

```
$ git clone https://github.com/carlos9344/call-center-al-mundo.git
$ mvn clean package

```
Consigna

Descripción

Existe un call center donde hay 3 tipos de empleados: operador,
supervisor y director. El proceso de la atención de una llamada
telefónica en primera instancia debe ser atendida por un operador, si
no hay ninguno libre debe ser atendida por un supervisor, y de no
haber tampoco supervisores libres debe ser atendida por un director.

Requerimientos

1. Diseñar el modelado de clases y diagramas UML necesarios
para documentar y comunicar el diseño.
2. Debe existir una clase Dispatcher encargada de manejar las
llamadas, y debe contener el método dispatchCall para que las
asigne a los empleados disponibles.
3. La clase Dispatcher debe tener la capacidad de poder procesar
10 llamadas al mismo tiempo (de modo concurrente).
4. Cada llamada puede durar un tiempo aleatorio entre 5 y 10
segundos.
5. Debe tener un test unitario donde lleguen 10 llamadas.

Extras/Plus

1. Dar alguna solución sobre qué pasa con una llamada cuando no
hay ningún empleado libre.
2. Dar alguna solución sobre qué pasa con una llamada cuando
entran más de 10 llamadas concurrentes.
3. Agregar los tests unitarios que se crean convenientes.
4. Agregar documentación de código.

Tener en Cuenta

1. El proyecto debe ser creado con Maven.
2. De ser necesario, anexar un documento con la explicación del
cómo y porqué resolvió los puntos extras, o comentarlo en las
clases donde se encuentran sus tests unitarios respectivos.
