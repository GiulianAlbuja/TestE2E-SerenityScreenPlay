
# Proyecto TestE2E-SerenityScreenPlay

## Descripción
Este proyecto responde a la automatización de pruebas E2E haciendo uso de  **Serenity BDD** utilizando el patrón **Screenplay**, que corresponde a un enfoque avanzado para escribir pruebas automatizadas, que promueve una forma estructurada y expresiva de definir los flujos de pruebas, enfocándose en el comportamiento de los actores (usualmente los usuarios). Además, **Screenplay** permite modelar interacciones en términos de acciones y objetivos desde la perspectiva de los usuarios, haciendo que las pruebas sean más legibles, mantenibles y reutilizables.

Se trabajo sobre el e-commerce de prueba [Swag Labs](https://www.saucedemo.com/). La aplicación web Swag Labs simula una tienda en línea de accesorios. Las pruebas automatizadas cubren los siguientes pasos: 

1. **Login**: el usuario ingresa su nombre de usuario y su contraseña.
2. **Agregar producto**: el usuario agrega al carrito un producto a la vez.
3. **Ingresar al carrito de compras**: el usuario ingresa al carrito de compras.
4. **Checkout**: el usuario completa el proceso de checkout.

Se trabajó con un **Scenario Outline** con seis casos de prueba:
1. **standard_user** (requerimiento): representa un usuario normal, típico del sistema. Funciona correctamente y sin problemas.
2. **locked_out_user**: simula un usuario bloqueado o deshabilitado.
3. **problem_user**: representa a un usuario que, al interactuar con el sistema, podría causar errores o conflictos.
4. **performance_glitch_user**: simula un usuario que podría experimentar problemas de rendimiento (carga lenta, retrasos, etc.).
5. **visual_user**: representa a un usuario que interactúa con los mismos elementos de la interfaz gráfica pero con variabilidad en la posición o representación de estos elementos gráficos.
6. **error_user**: representa un usuario que podría desencadenar errores específicos.

Finalmente, gracias a **Serenity BDD**, el resultados de cada prueba se ve reflejado en un reporte, esto con el objetivo de analizar el estado de las validaciones. Estos reportes muestran información organizada sobre cada prueba ejecutada, lo que facilita la revisión de los resultados y ayuda a identificar rápidamente cualquier problema o éxito en los casos de prueba ejecutados.

---

## Prerequisitos

Para poder ejecutar este proyecto de forma correcta, se debe cumplir con los siguientes prerequisitos en tu máquina local:

- **IDE Recomendado**: [IntelliJ IDEA]
- **JDK**: [[JDK versión](https://docs.aws.amazon.com/corretto/)  11 -17 (configurado en la variable de entorno `JAVA_HOME`)] 
- **Gradle**: [[Gradle versión](https://maven.apache.org/download.cgi) 7.6.1 o superiores (configurado en la variable de entorno `GRADLE_HOME`)]
> **Nota**: Si se trabaja en IntelliJ IDEA se podrán ejecutar tareas Gradle desde el IDE sin necesidad de tener Gradle instalado y configurado en variables de entorno.
---
> **Nota**: Asegúrate de que el JDK esté correctamente configurado en IntelliJ. Para hacerlo, ve a **File > Project Structure**. Ahí encontraras dos configuraciones: **Project** y **SDKs**. Selecciona la versión del JDK que hayas configurado en `JAVA_HOME`.
> 
## Comandos de Instalación

Para instalar este proyecto en tu máquina local, sigue estos pasos: 
1. **Clona el repositorio**: Puedes hacerlo de dos maneras: 
- **Desde Git Bash**: Abre Git Bash en la carpeta donde deseas clonar el proyecto y ejecuta el siguiente comando: ```git clone https://github.com/GiulianAlbuja/TestE2E-SerenityScreenPlay.git``` 

- **Desde IntelliJ IDEA**: 
	- Abre IntelliJ IDEA. 
	- Ve a **File > New > Project from Version Control...**. 
	- Ingresa la URL del repositorio (`https://github.com/GiulianAlbuja/TestE2E-SerenityScreenPlay.git`) y selecciona la carpeta de destino.
	 - Haz clic en **Clone**. 

2. **Ejecuta el comando de instalación**: Una vez clonado el proyecto y abrirlo en IntelliJ, las dependencias se descargarán automáticamente, de lo contrario, ejecuta la siguiente tarea Gradle: `gradle clean build`. Dicha tarea limpiara y construirá el proyecto. Además, se ejecutarán las pruebas automáticamente.

## Instrucciones para ejecutar los test
### Opción 1
- Como se menciono anteriormente, al momento de ejecutar el comando `gradle clean build` se limpiara y construirá el proyecto, finalizando con la ejecución de las pruebas automáticamente y la generación del reporte.
### Opción 2
 - Ejecutar la clase `RunnerTest.java` ubicada en la siguiente ruta: `src/test/java/com/nttdata/runners/RunnerTest.java`. Se ejecutaran las pruebas y se creara el reporte respectivo.
### Opción 3
- Ejecutar la tarea Gradle `gradle clean test aggregate` . Dicha tarea compilará el proyecto, ejecutará las pruebas y generará el nuevo reporte. 

El reporte se verá reflejado en al siguiente ruta: `target/site/serenity/index.html`


Para el caso de prueba requerido (standard_user): 

![image](https://github.com/user-attachments/assets/cbc13af8-d77b-4222-a4fa-a4e96676d393)


Para los casos de prueba exitosos (standard_user, performance_glitch_user, visual_user): 

![image](https://github.com/user-attachments/assets/37e69e6e-ad9b-4449-b8e2-d12ce3e95dac)


Para los casos de prueba fallidos (locked_out_user, problem_user, error_user):

![image](https://github.com/user-attachments/assets/fceeafbf-812d-4dc2-9978-65c86b252de8)


Para todos los casos de prueba en conjunto (standard_user, performance_glitch_user, visual_user, locked_out_user, problem_user, error_user):

![image](https://github.com/user-attachments/assets/fec03062-983d-4ca2-81a0-aa0875d416d1)
