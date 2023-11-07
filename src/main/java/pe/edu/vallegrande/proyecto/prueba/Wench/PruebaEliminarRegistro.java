package pe.edu.vallegrande.proyecto.prueba.Wench;

import pe.edu.vallegrande.proyecto.service.impl.CrudWenchService;

public class PruebaEliminarRegistro {

	//eliminar registro

		public static void main(String[] args) {
			try {
				// Datos
				String id = "1";
				// Proceso
				CrudWenchService clientService = new CrudWenchService();
				clientService.delete(id);
				System.out.println(" ups el Registro fue eliminado, listo");
			} catch (Exception e) {
				System.err.println(e.getMessage());
			}
		}
	
}