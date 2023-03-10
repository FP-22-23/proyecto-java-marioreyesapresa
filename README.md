# Proyecto del Segundo Cuatrimestre Fundamentos de Programación (Curso 2022/23)
Autor/a: Mario Reyes Apresa   uvus:marreyapr


## Estructura de las carpetas del proyecto

* **/src**: Directorio con el código fuente.
  * **fp.starbucks**: Paquete que contiene los tipos del proyecto.
  * **fp.starbucks.test**: Paquete que contiene las clases de test del proyecto.
  * **fp.utiles**:  Paquete que contiene las clases de utilidad. 
  * **fp.common**:  Paquete que contiene los tipos auxiliares. 
* **/data**: Contiene el dataset del proyecto.
    * **starbucks.csv**: Archivo csv que contiene datos de diferentes enceuestas de clientes de starbucks
    
## Estructura del *dataset*

El dataset original Starbucks Customer Survey se puede obtener de la URL [https://www.kaggle.com/datasets/malaynarashid/starbucks-customer-survey]. Originalmente tiene 21 columnas y cada fila contiene datos sobre una encuesta a clientes del establecimeinto. El dataset usado en este proyecto tiene 11 columna, 10 se han tomado del dataset original, y una, el id del cliente, se ha generado de forma aleatoria. A continuación se describen las 11 columnas del dataset:

* **fechaHora**: de tipo LocalDateTime,  indica la fecha y hora en la que se realizó el pedido.
* **genero**: de tipo Enum, indica el tipo de Genero del cliente.
* **edad**: de tipo Integer, indica la edad del cliente.
* **ocupacion**: de tipo Enum, indica el tipo de ocupacion del cliente, siendo Student, Employed o Self_Employed.
* **servicio**: de tipo String, indica si el pedido se realizó para tomar o para llevar.
* **duracion**: de tipo Integer, contiene la duración en minutos del pedido
* **valoracion**: de tipo Double, tiene la puntuación dada por cada cliente.
* **pedido**: de tipo List<String>, contiene una lista con los articulos pedidos. Los pedidos están separados por ;.
* **conocidoPor**: de tipo cadena, indica la forma en la que el cliente conoció el establecimiento.
* **satisfecho**: de tipo Boolean. Indica si el cliente quedó satisfecho con el pedido.
* **idCliente**: de tipo entero. Indica el id del cliente que realiza el pedido.

## Tipos implemendos

Los tipos que se han implementado en el proyecto son los siguientes:

### Tipo Base - Starbucks
Representa un pedido en Starbucks.
**Propiedad**:

- _fechaHora_, de tipo _LocalDateTime_, consultable y modificable. Indica la fecha y hora del pedido. 
- _genero_, de tipo _Genero_, consultable y modificable. Indica el tipo de genero. Puede tomar los valores Female o Male.
- _edad_, de tipo _Integer_, consultable y modificable. Indica la edad del cliente.
- _ocupacion_, de tipo _Ocupacion_, consultable y modificable. Indica la ocupación del cliente. Puede tomar los valores Student, Employed o Self_Employed.
- _servicio_, de tipo _String_, consultable y modificable. Contiene el servicio del pedido.
- _duracion_, de tipo _Integer_, consultable y modificable. Contiene el timepo en minutos que tarda en prepararse el pedido.
- _valoracion_, de tipo _Double_, consultable y modificable. Contiene el rating del pedido.
- _pedido_, de tipo _List\<String\>_, consultable y modificable. Lista de pedido.
- _conocidoPor_, de tipo _String_, consultable y modificable. Indica como se ha conocido el establecimiento.
- _satisfecho_, de tipo _Boolean_, consultable y modificable. Indica si el cliente está satisfecho o no(false).
- _idCliente_, de tipo _Integer_, consultable y modificable. Es el identificador del cliente.
- _pedidoCliente_, de tipo _String_, propiedad derivada. Indica el pedido que ha realizado un cliente con determinado id.


**Constructores**: 

- C1: Tiene un parámetro por cada propiedad básica del tipo.
- C2: Crea un objeto de tipo Starbucks a partir de los siguientes parámetros: LocalDateTime fechaHora, String servicio,Double valoracion,List<String> pedido, Integer idCliente.

**Restricciones**:
 
- R1: La fecha de pedido tiene que ser menor que la fecha actual.
- R2: La duración no debe superar los 60min y debe ser mayor que 0minLa duración no debe superar los 60min y debe ser mayor que 0min.
- R3:La valoracion debe tener valores comprendidos entre 0.0 y 5.0


***Criterio de igualdad**: Dos pedidos son iguales si todas sus propiedades básicas son iguales.

**Criterio de ordenación**: el pedido con mayor valoracion es mejor.

**Otras operaciones**:

- _String getMovimiento(Integer numMovimiento)_: Devuelve el movimiento dado por el número numMovimiento. Eleva ```IllegalArgumentException``` si ```numMovimiento``` no está en el intervalo [1, getNumMovimientos()]

#### Tipos auxiliares

- Genero, enumerado. Puede tomar los valores Male, Female.
- Ocupacion, enumerado. Puede tomar los valores Student, Employed, Self_Employed.
* **fp.common**:
- Cliente: Record que actua como tipo auxiliar, contiene un metodo getAñoNacimiento() que nos permite calcular el año de nacimineto del cliente a partir de la fecha del pedido y de la edad del cliente.
