package pe.edu.vallegrande.proyecto.prueba.Wench;

import pe.edu.vallegrande.proyecto.model.Wench;
import pe.edu.vallegrande.proyecto.service.impl.CrudWenchService;

public class PruebaCrear {

	public static void main(String[] args) {
			try {
				// Crear objeto del cliente
				Wench bean = new Wench(3, "DNI", "72658875", "Milenka", "Barrios", "1999-02-01", "123456789", "Milenka.Barrios@example.com", "A");
				
				// Instanciar el servicio de clientes
				CrudWenchService WenchService = new CrudWenchService();
				WenchService.insert(bean);
				// Mostrar mensaje de éxito
				System.out.println(bean);
				
			} catch (Exception e) {
				System.err.println(e.getMessage());
			}
	}
}