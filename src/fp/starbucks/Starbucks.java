package fp.starbucks;


import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;
import fp.utiles.Checkers;

/**
 * @author marreyapr
 *
 */

public class Starbucks {
	
	private LocalDateTime fechaHora;
	private Genero genero;
	private Integer edad;
	private Ocupacion ocupacion;
	private String servicio;
	private Integer duracion;
	private Double valoracion;
	private List<String> pedido;
	private String conocidoPor;
	private Boolean satisfecho;
	private Integer idCliente;
	
	//Constructores
	//Constructor 1: devuelve todos los atributos de la clase Starbucks.
	

		public Starbucks(LocalDateTime fechaHora, Genero genero, Integer edad, Ocupacion ocupacion, String servicio,
				Integer duracion, Double valoracion, List<String> pedido, String conocidoPor, Boolean satisfecho, Integer idCliente) {
			
			
			Checkers.check("La fecha de pedido tiene que ser menor que la fecha actual", 
					fechaHora.isBefore(LocalDateTime.now()));
			this.fechaHora = fechaHora;
			this.genero = genero;
			this.edad = edad;
			this.ocupacion = ocupacion;
			this.servicio = servicio;
			Checkers.check("La duración no debe superar los 60min y debe ser mayor que 0min", 
					duracion <= 60. && duracion >= 0.);
			this.duracion = duracion;
			Checkers.check("La valoracion debe tener valores comprendidos entre 0.0 y 5.0", 
					valoracion >= 0.0 && valoracion <= 5.0);
			
			this.valoracion = valoracion;
			this.pedido = pedido;
			this.conocidoPor = conocidoPor;
			this.satisfecho = satisfecho;
			this.idCliente=idCliente;
		}
	
		
	//Constructor 2: devuelve la fecha y hora, el servicio, el pedido y el id, todos los demás datos los devuelve null.
		
		public Starbucks(LocalDateTime fechaHora, String servicio,Double valoracion,List<String> pedido, Integer idCliente) {
		
			
			
			Checkers.check("La fecha de pedido tiene que ser menor que la fecha actual", 
					fechaHora.isBefore(LocalDateTime.now()));
			this.fechaHora = fechaHora;
			this.genero = null;
			this.edad = null;
			this.ocupacion = null;
			this.servicio = servicio;
			this.duracion = null;
			this.valoracion = valoracion;
			this.pedido = pedido;
			this.conocidoPor = null;
			this.satisfecho = null; //revisar
			this.idCliente=idCliente;
		}

		/**
		 * @param fechaHora Indica la fecha y hora en la que se realizó el pedido.
		 * @param genero Indica el genero del cliente, hombre(Male) o mujer(Female).
		 * @param edad Indica la edad del cliente.
		 * @param ocupacion Indica si el cliente es un Estudiante o un Empleado.
		 * @param servicio Indica si se solicita el pedido para tomar o para llevar.
		 * @param duracion Indica el timepo, en minutos, que se tarda en entregar el pedido.
		 * @param valoracion Rating del jugador con las negras
		 * @param pedido Cadena que contiene la lista de pedidos.
		 * @param conocidoPor Cadena que indica por qué medio(como por ejemplo una red social)se ha conocido el establecimiento
		 * @param satisfecho Indica si el cliente está satisfecho (true) o no
		 * @param idCliente Identificador del cliente.
		 * @throws IllegalArgumentException si la fecha de pedido es mayor que la fecha actual
		 * @throws IllegalArgumentException si la valoracion no tiene valores comprendidos entre 0.0 y 5.0
		 * @throws IllegalArgumentException si la duración supera los 60min y o no es mayor que 0min
		 */
	
	//todas las propiedades son consultables y modificables
		

		public LocalDateTime getFechaHora() {
			return fechaHora;
		}


		public void setFechaHora(LocalDateTime fechaHora) {
			this.fechaHora = fechaHora;
		}


		public Genero getGenero() {
			return genero;
		}


		public void setGenero(Genero genero) {
			this.genero = genero;
		}


		public Integer getEdad() {
			return edad;
		}


		public void setEdad(Integer edad) {
			this.edad = edad;
		}


		public Ocupacion getOcupacion() {
			return ocupacion;
		}


		public void setOcupacion(Ocupacion ocupacion) {
			this.ocupacion = ocupacion;
		}


		public String getServicio() {
			return servicio;
		}


		public void setServicio(String servicio) {
			this.servicio = servicio;
		}


		public Integer getDuracion() {
			return duracion;
		}


		public void setDuracion(Integer tiempoMinutos) {
			this.duracion = tiempoMinutos;
		}


		public Double getValoracion() {
			return valoracion;
		}


		public void setValoracion(Double valoracion) {
			this.valoracion = valoracion;
		}


		public List<String> getPedido() {
			return pedido;
		}


		public void setPedido(List<String> pedido) {
			this.pedido = pedido;
		}


		public String getConocidoPor() {
			return conocidoPor;
		}


		public void setConocidoPor(String conocidoPor) {
			this.conocidoPor = conocidoPor;
		}


		public Boolean getSatisfecho() {
			return satisfecho;
		}


		public void setSatisfecho(Boolean satisfecho) {
			this.satisfecho = satisfecho;
		}
		
		public Integer getIdCliente() {
			return idCliente;
		}


		public void setIdCliente(Integer idCliente) {
			this.idCliente = idCliente;
		}

		//propiedad derivada
		//Propiedad Derivada: devuelve el pedido del cliente.
	

		/**
		 * @return El pedido que realiza un determinado cliente
		 */
		public String pedidoCliente() {
			
			return "El cliente con id: " + getIdCliente() + " ha pedido " + getPedido();
			
		}


	
		//Representacion como cadena
		
		public String toString() {
			return "Starbucks [fechaHora=" + fechaHora + ", genero=" + genero + ", edad=" + edad + ", ocupacion="
					+ ocupacion + ", servicio=" + servicio + ", duracion=" + duracion + ", valoracion="
					+ valoracion + ", pedido=" + pedido + ", conocidoPor=" + conocidoPor + ", satisfecho=" + satisfecho
					+ ", idCliente=" + idCliente + "]";
		}
		
		//Criterio de igualdad
	
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Starbucks other = (Starbucks) obj;
			return Objects.equals(conocidoPor, other.conocidoPor) && Objects.equals(edad, other.edad)
					&& Objects.equals(fechaHora, other.fechaHora) && genero == other.genero
					&& Objects.equals(idCliente, other.idCliente) && ocupacion == other.ocupacion
					&& Objects.equals(pedido, other.pedido) && Objects.equals(satisfecho, other.satisfecho)
					&& Objects.equals(servicio, other.servicio) && Objects.equals(duracion, other.duracion)
					&& Objects.equals(valoracion, other.valoracion);
		}
		
		//Criterio de orden natural
		//CompareTo: el pedido con mayor valoracion es mejor.
		
		/**
		 * @return el pedido con mayor valoracion es mejor.
		 */
		public int compareTo(Object o) {
			  
			  Starbucks  Starbucks = (Starbucks) o; 
			  if (this.getValoracion() == Starbucks.getValoracion()) return 0; 
			  else if (this.getValoracion() > Starbucks.getValoracion()) return 1; 
			  else return -1; 
			}
		

}
