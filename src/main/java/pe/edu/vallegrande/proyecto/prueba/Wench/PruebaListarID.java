package pe.edu.vallegrande.proyecto.prueba.Wench;

import pe.edu.vallegrande.proyecto.model.Wench;
import pe.edu.vallegrande.proyecto.service.impl.CrudWenchService;

public class PruebaListarID {

	public static void main(String[] args) {
		
		try {
			CrudWenchService personService = new CrudWenchService();
			Wench bean = personService.getForId("2");
			System.out.println(bean);
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
	}
} 