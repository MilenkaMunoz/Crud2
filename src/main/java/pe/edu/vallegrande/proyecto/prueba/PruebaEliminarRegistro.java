package pe.edu.vallegrande.proyecto.prueba;

import pe.edu.vallegrande.proyecto.service.impl.CrudClientService;

public class PruebaEliminarRegistro {

	//eliminar registro

		public static void main(String[] args) {
			try {
				// Datos
				String id = "8";
				// Proceso
				CrudClientService clientService = new CrudClientService();
				clientService.delete(id);
				System.out.println(" ups el Registro fue eliminado, listo");
			} catch (Exception e) {
				System.err.println(e.getMessage());
			}
		}
	
}