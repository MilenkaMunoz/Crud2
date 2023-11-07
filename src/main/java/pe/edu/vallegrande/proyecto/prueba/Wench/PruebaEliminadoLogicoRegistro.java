package pe.edu.vallegrande.proyecto.prueba.Wench;

import pe.edu.vallegrande.proyecto.service.impl.CrudWenchService;

public class PruebaEliminadoLogicoRegistro {

	//eliminar registro

		public static void main(String[] args) {
			try {
				// Datos
				String id = "2";
				// Proceso
				CrudWenchService clientService = new CrudWenchService();
				clientService.EliminadoLogico(id);
				System.out.println(" El registro se ELIMINO de manera LÓGICA  el estado paso a I");
			} catch (Exception e) {
				System.err.println(e.getMessage());
			}
		}
}
