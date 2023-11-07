package pe.edu.vallegrande.proyecto.prueba.Wench;

import pe.edu.vallegrande.proyecto.model.Wench;
import pe.edu.vallegrande.proyecto.service.impl.CrudWenchService;

public class PruebaModificar {

		public static void main(String[] args) {
				try {
					// Datos
					Wench bean = new Wench(2, "DNI", "71658875", "Milenka", "Barrios", "1999-02-01", "123456789", "Milenka.Barrios@example.com", "A");
				
					// Proceso
					CrudWenchService WenchService = new CrudWenchService();
					WenchService.update(bean);
					System.out.print(bean);
				} catch (Exception e) {
						System.err.print(e.getMessage());
				}
		            
		}
}
      