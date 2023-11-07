package pe.edu.vallegrande.proyecto.prueba;

import pe.edu.vallegrande.proyecto.service.impl.CrudClientService;

public class PruebaRestaurarRegistro {

	//eliminar registro

		public static void main(String[] args) {
			try {
				// Datos
				String id = "6";
				// Proceso
				CrudClientService personService = new CrudClientService();
				personService.Restaurar(id);
				System.out.println("Muy bien el registro Se RESTAURO a estado A");
			} catch (Exception e) {
				System.err.println(e.getMessage());
			}
		}
	
}