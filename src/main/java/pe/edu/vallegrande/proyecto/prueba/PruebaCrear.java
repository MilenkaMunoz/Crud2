package pe.edu.vallegrande.proyecto.prueba;

import pe.edu.vallegrande.proyecto.model.Client;
import pe.edu.vallegrande.proyecto.service.impl.CrudClientService;

public class PruebaCrear {

	public static void main(String[] args) {
			try {
				// Crear objeto del cliente
				Client bean = new Client("CNE", "69452859", "Cristiam", "Chavez Riojas", "2000-10-29", "966542231", "cristiam.chavez@outlook.com");
				
				// Instanciar el servicio de clientes
				CrudClientService clientService = new CrudClientService();
				clientService.insert(bean);
				// Mostrar mensaje de éxito
				System.out.println(bean);
				
			} catch (Exception e) {
				System.err.println(e.getMessage());
			}
	}
}