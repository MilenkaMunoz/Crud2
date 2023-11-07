package pe.edu.vallegrande.proyecto.prueba;

import pe.edu.vallegrande.proyecto.service.impl.CrudClientService;

public class PruebaEliminadoLogicoRegistro {

	//eliminar registro

		public static void main(String[] args) {
			try {
				// Datos
				String id = "6";
				// Proceso
				CrudClientService clientService = new CrudClientService();
				clientService.EliminadoLogico(id);
				System.out.println(" El registro se ELIMINO de manera LÓGICA  el estado paso a I");
			} catch (Exception e) {
				System.err.println(e.getMessage());
			}
		}
}
