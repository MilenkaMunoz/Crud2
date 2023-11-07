package pe.edu.vallegrande.proyecto.prueba.Wench;

import java.util.List;

import pe.edu.vallegrande.proyecto.model.Wench;
import pe.edu.vallegrande.proyecto.service.impl.CrudWenchService;

public class PruebaListarInactivos {

	// listar tabla completa de INACTIVOS
		public static void main(String[] args) {
			try {
				CrudWenchService personService = new CrudWenchService();
				List<Wench> lista = personService.getInactivos();
				for (Wench client : lista) {
					System.out.println(client);
				}
			} catch (Exception e) {
				System.err.println(e.getMessage());
			}
		}
	
}