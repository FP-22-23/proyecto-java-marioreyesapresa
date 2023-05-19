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

El dataset original Starbucks Customer Survey se puede obtener de la URL [https://www.kaggle.com/datasets/malaynarashid/starbucks-customer-survey]. Originalmente tiene 21 columnas y cada fila contiene datos sobre una encuesta a clientes del establecimeinto. El dataset usado en este proyecto tiene 10 columna, 9 se han tomado del dataset original, y una, el id del cliente, se ha generado de forma aleatoria. A continuación se describen las 10 columnas del dataset:

* **fechaHora**: de tipo LocalDateTime,  indica la fecha y hora en la que se realizó el pedido.
* **genero**: de tipo Enum, indica el tipo de Genero del cliente.
* **edad**: de tipo Integer, indica la edad del cliente.
* **ocupacion**: de tipo Enum, indica el tipo de ocupacion del cliente, siendo Student, Employed o Self_Employed.
* **servicio**: de tipo String, indica si el pedido se realizó para tomar o para llevar.
* **duracion**: de tipo Integer, contiene la duración en minutos del pedido
* **valoracion**: de tipo Double, tiene la puntuación del pedido que ha dado cada cliente.
* **pedido**: de tipo List<String>, contiene una lista con los articulos pedidos. Los pedidos están separados por ;.
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

- _satisfecho_, de tipo _Boolean_, consultable y modificable. Indica si el cliente está satisfecho o no(false).
- _idCliente_, de tipo _Integer_, consultable y modificable. Es el identificador del cliente.
- _pedidoCliente_, de tipo _String_, propiedad derivada. Indica el pedido que ha realizado un cliente con determinado id.
- _añoNacimiento_, de tipo _Integer_, propiedad derivada. Indica el año de nacimiento del cliente que realizó el pedido.

**Constructores**: 

- C1: Tiene un parámetro por cada propiedad básica del tipo.
- C2: Crea un objeto de tipo Starbucks a partir de los siguientes parámetros: LocalDateTime fechaHora, String servicio,Double valoracion,List<String> pedido, Integer idCliente.

**Restricciones**:
 
- R1: La fecha de pedido tiene que ser menor que la fecha actual.
- R2: La duración no debe superar los 60min y debe ser mayor que 0minLa duración no debe superar los 60min y debe ser mayor que 0min.
- R3:La valoracion debe tener valores comprendidos entre 0.0 y 5.0


**Criterio de igualdad**: Dos pedidos son iguales si todas sus propiedades básicas son iguales.

**Criterio de ordenación**: el pedido con mayor valoracion es mejor.



#### Tipos auxiliares

- Genero, enumerado. Puede tomar los valores Male, Female.
- Ocupacion, enumerado. Puede tomar los valores Student, Employed, Self_Employed.
* **fp.common**:
- Cliente: Record que actua como tipo auxiliar, contiene un metodo getAñoNacimiento() que nos permite calcular el año de nacimiento del cliente a partir de la fecha del pedido y de la edad del cliente.

### Factoría - FactoriaStarbucks
Clase de factoría para construir objetos de tipo Starbucks.

- _leerStarbucks(String rutaFichero)_:Crea un objeto de tipo Starbucks a partir de la información recogida en el archivo csv, cuya ruta se da como parámetro.

- _leeListaStarbucks(String rutaFichero)_:Crea una lista de objeto de tipo Starbucks a partir de la información recogida en el archivo csv, cuya ruta se da como parámetro.

- _parsearStarbucks(String linea)_: Recibe como argumento una linea del fichero del tipo String y parsea cada propiedad con su tipo correspondiente.

- _leerStarbucks2(String rutaFichero)_:Crea un objeto de tipo Starbucks a partir del constructor del contenedor. Usa la información recogida en el archivo csv, cuya ruta se da como parámetro.

### Tipo Contenedor - ListaStarbucks

Clase contenedora de los objetos de tipo Starbucks.

**Propiedades**:

-  _listas_, de tipo _List<Starbucks>_, consultable. 
 
**Constructores**: 

- C1:Constructor con todas las propiedades básicas (excepto la colección), que cree un objeto de tipo contenedor sin ningún elemento en la colección.
- C2: Constructor con todas las propiedades básicas y una colección de objetos del tipo base, que cree un objeto de tipo contenedor con todos los elementos de la colección.
- C3: constructor con todas las propiedades básicas (excepto la colección) y un stream de objetos del tipo base, que cree un objeto del tipo contenedor contodos los elementos del stream.
	


**Criterio de igualdad**: Dos Pedidos de Starbucks son iguales si lo son sus propiedades.

**Criterio de ordenación**: idéntico al orden natural del tipo base.

**ToString**: describe el tipo ListaStarbucks


**Otras operaciones**:
- _void añade(Starbucks s)_: Añade un pedido Starbucks al objeto.
- _void eliminarPedido(Starbucks b)_: Elimina un elemento del objeto.
- _Integer getLongitud()_: Devuelve la longitud de la lista


**Métodos con bucles tradicionales**:

- _Boolean existePedidoDadoId(Integer id)_: Devuelve si existe un pedido con un id determinado.

-_Integer numeroDePedidosMes(Integer mes)_: devuelve un Integer con la cantidad de pedidos realizados en el mes que recibe como parámetro.

-_List<Starbucks> filtroPorEdad(Integer edad )_: Filtramos por la edad dada como parámetro y devuelve una lista con los pedidos realizados por clientes con la edad recibida.

-_Map<String, List<Starbucks>> agruparPorOcupacion()_: Map<String, List< Starbucks >> donde asocia a cada Ocupacion sus objetos Starbucks asociados en una lista.

-_Map<String, Integer> conteoDeServicio()_: Map<String, Integer> donde asocia a cada Servicio el conteo de las veces que aparece.

**Métodos con stream**:
- _Boolean existePedidoDadoIdStream(Integer id)_: Devuelve si existe un pedido con un id determinado.

-_Integer numeroDePedidosMesStream(Integer mes)_: devuelve un Integer con la cantidad de pedidos realizados en el mes que recibe como parámetro.

-_List<Starbucks> filtroPorEdadStream(Integer edad )_: Filtramos por la edad dada como parámetro y devuelve una lista con los pedidos realizados por clientes con la edad recibida.

-_Starbucks pedidoMayorValoracion(Genero genero)_: Devuelve el pedido con mayor valoracion hecho por un genero dado como parametro.

-_List<Starbucks> pedidosSatisfechosValoracion()_:Devuelve los pedidos satisfechos ordenados por mejor valoracion

-_Map<String, List<Starbucks>> agruparPorOcupacionStream()_:Map donde asocia a cada ocupacion sus objetos Starbucks asociados en una lista

-_Map<String, List<Integer>> agruparPorPedidoId()_:Map donde asocia a cada mes el id del cliente que ha realizado un pedido.

-_Map<List<String> , Double> pedidosPeoresValoraciones(Integer dia)_:Map donde las claves son los diferentes pedidos y los valores son las valoraciones mínimas de los elementos con ese pedido y cuya fecha y hora tienen el mismo día que el valor del parámetro

-_SortedMap<Genero, List<Starbucks>> obtenerNPedidosMenorDuracionPorGenero(Integer n)_:SortedMap donde las claves son los generos y los valores los n pedidos con menor duracion 
	
-_Ocupacion getOcupacionMayorEdad()_:Crea un Map donde las claves son las ocupaciones y los valores las edades y devuelve la ocupacion(clave) con mayor edad(valor)
