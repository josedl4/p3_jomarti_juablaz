# Practica 3 de Tecnologias para el Desarrollo de Software

#### Autores:
* Jose Luis Martín Martín  -    _jomarti_
* Juan Carlos Blázquez Muñoz  - _juablaz_

#### Built With:
* [Maven](https://maven.apache.org/) - Dependency Management
* [Ant](http://ant.apache.org/) -  Automating software build processes
* [Eclipse](https://eclipse.org/) - IDE

#### Targets de Ant:
* **_ant compilar_** - Obtención de las dependencias y generación de los ficheros .class para la realización de los test.
* **_ant ejecutarTodo_** - Realizaremos la ejecución de todos los test.
* **_ant ejecutarTestsTDD_** - Ejecutar solo test de TDD y de caja negra.
* **_ant ejecutarTestEnAislamiento_** - Ejecutar test en asilamiento y de caja blanca.
* **_ant ejecutarPruebasSecuencia_** - Ejecutar test de secuencia.
* **_ant obtenerInformeCobertura_** - Obtener informe de cobertura
* **_ant medidas_** - Obtener complejidad ciclomática y ratio _code to test_.
* **_ant documentar_** - Generar documentación.
* **_ant limpiar_** - Limpiar el directorio del proyecto.

#### Estructura del proyecto:
* **_src_** - Fuentes del proyecto.
* **_lib_** - Dependencias de Maven.
* **_target_**
  * **_class_** - .class de las clases _Noticia_ y _Boletin_.
  * **_class-test_** - .class de los test.
  * **_site_** - Informes generados de cobertura y medidas.
    * _javancss_ - Informe de complejidad ciclomática.
    * _jacoco_ - Code To Test Ratio.
    * _cobertura_ - Informe de cobertura.
