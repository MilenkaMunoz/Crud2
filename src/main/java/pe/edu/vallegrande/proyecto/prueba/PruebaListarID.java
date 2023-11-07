package pe.edu.vallegrande.proyecto.prueba;

import pe.edu.vallegrande.proyecto.model.Client;
import pe.edu.vallegrande.proyecto.service.impl.CrudClientService;

public class PruebaListarID {

	public static void main(String[] args) {
		
		try {
			CrudClientService personService = new CrudClientService();
			Client bean = personService.getForId("6");
			System.out.println(bean);
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
	}
} 