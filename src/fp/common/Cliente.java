package fp.common;

import java.time.LocalDateTime;

public record Cliente(LocalDateTime fechaHora, Integer edad) {

	// Otras operaciones 
	public Integer getAñoNacimiento(Cliente c) {
		Integer año = c.fechaHora.getYear() - edad();
		return año;
	}
	
}
