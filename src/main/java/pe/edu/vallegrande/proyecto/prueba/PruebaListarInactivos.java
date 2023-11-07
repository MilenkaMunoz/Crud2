package pe.edu.vallegrande.proyecto.prueba;

import java.util.List;

import pe.edu.vallegrande.proyecto.model.Client;
import pe.edu.vallegrande.proyecto.service.impl.CrudClientService;

public class PruebaListarInactivos {

	// listar tabla completa de INACTIVOS
		public static void main(String[] args) {
			try {
				CrudClientService personService = new CrudClientService();
				List<Client> lista = personService.getInactivos();
				for (Client client : lista) {
					System.out.println(client);
				}
			} catch (Exception e) {
				System.err.println(e.getMessage());
			}
		}
	
}