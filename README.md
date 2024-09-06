# Drone Exploration Service

## Descripción del Proyecto

El proyecto "Drone Exploration" simula el movimiento de drones en una meseta rectangular siguiendo un conjunto de instrucciones. Cada dron tiene una posición inicial y un conjunto de instrucciones que determinan su movimiento en la meseta. Las instrucciones pueden ser "L" (giro a la izquierda), "R" (giro a la derecha) y "M" (mover hacia adelante). El sistema también valida que los drones no se muevan fuera de los límites de la meseta y maneja errores en las instrucciones.

## Estructura del Proyecto

El proyecto está estructurado de la siguiente manera:

- **`src/main/java/ar/equo/model`**: Contiene las clases de modelo como `Drone`, `Position`, y `Plateau`.
- **`src/main/java/ar/equo/service`**: Contiene la lógica de servicio, incluyendo `DroneExploration`.
- **`src/test/java/ar/equo/service`**: Contiene los tests de unidad para la clase `DroneExploration`.

## Requisitos

- **Java JDK 17** o superior
- **Apache Maven 3.8.6** o superior

## Instalación y Configuración

1. **Clonar el Repositorio**

   Clona el repositorio en tu máquina local usando Git:

   ```bash
   git clone https://github.com/tuusuario/tu-repositorio.git

2. **Navega al directorio del proyecto**

    ```bash
    cd DroneExploration

3. **Construir el Proyecto**

    ```bash
    mvn clean install

4. **Ejecutar las Pruebas**

    ```bash
    mvn test

5. **Ejecutar la aplicación**

    ```bash
    mvn exec:java -Dexec.mainClass="ar.equo.DroneApp" 

### Descripción de los Tests

Los tests verifican el correcto funcionamiento de la lógica de exploración de drones en un entorno simulado. Se incluyen casos para evaluar escenarios exitosos y excepciones esperadas.

1. **Test de Exploración Correcta**  
   Verifica que los drones lleguen a sus posiciones finales esperadas tras ejecutar las instrucciones de movimiento en el plateau.

2. **Test de Excepción por Salida de Límites (`DroneOutOfBoundsException`)**  
   Comprueba que se lance la excepción adecuada cuando un dron intenta moverse fuera de los límites del plateau.

3. **Test de Excepción por Instrucción Ilegal (`IllegalArgumentException`)**  
   Asegura que se lance una excepción si se proveen instrucciones no válidas para un dron.

4. **Test de Escenario Complejo**  
   Simula un escenario más elaborado con varios drones en un plateau más grande, verificando las posiciones finales de cada dron tras una serie de movimientos complejos.

### Descripción de la aplicación

Para ejecutar la aplicación y simular el movimiento de drones, ejecuta la clase DroneApp. Esta clase lee las entradas desde el teclado y ejecuta la simulación según las instrucciones proporcionadas.

**Entrada de Datos**:
   - Ingrese las coordenadas del plateau (por ejemplo, `5 5`).
   - Especifique el número de drones.
   - Para cada dron, ingrese la posición inicial (por ejemplo, `1 2 N`) y las instrucciones de movimiento (por ejemplo, `LMLMLMLMM`).

**Salida**:
   - La aplicación imprimirá las posiciones finales de los drones después de ejecutar todas las instrucciones.




