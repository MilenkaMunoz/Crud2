package pe.edu.vallegrande.proyecto.prueba;

import java.util.List;

import pe.edu.vallegrande.proyecto.model.Client;
import pe.edu.vallegrande.proyecto.service.impl.CrudClientService;

public class PruebaListarNomApe {

	// listar por nombre y apellido dentro de nuestra tabla student

		public static void main(String[] args) {
			try {
				// Datos
				Client bean = new Client();
				bean.setLast_name("    ");
				bean.setNames(" ");
				bean.setType_document(" DNI ");
				// Proceso
				CrudClientService personService = new CrudClientService();
				List<Client> lista = personService.get(bean);
				for (Client client : lista) {
					System.out.println(client);
				}
			} catch (Exception e) {
				System.err.println(e.getMessage());
			}
		}
	
}