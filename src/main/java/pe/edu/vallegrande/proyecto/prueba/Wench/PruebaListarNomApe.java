package pe.edu.vallegrande.proyecto.prueba.Wench;

import java.util.List;

import pe.edu.vallegrande.proyecto.model.Wench;
import pe.edu.vallegrande.proyecto.service.impl.CrudWenchService;

public class PruebaListarNomApe {

	// listar por nombre y apellido dentro de nuestra tabla student

		public static void main(String[] args) {
			try {
				// Datos
				Wench bean = new Wench();
				bean.setLastName("Barrios");
				bean.setNames("");
				bean.setNumberDocument("");
				// Proceso
				CrudWenchService personService = new CrudWenchService();
				List<Wench> lista = personService.get(bean);
				for (Wench Wench : lista) {
					System.out.println(Wench);
				}
			} catch (Exception e) {
				System.err.println(e.getMessage());
			}
		}
	
}