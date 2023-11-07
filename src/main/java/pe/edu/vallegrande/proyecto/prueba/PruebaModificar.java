package pe.edu.vallegrande.proyecto.prueba;

import pe.edu.vallegrande.proyecto.model.Client;
import pe.edu.vallegrande.proyecto.service.impl.CrudClientService;

public class PruebaModificar {

		public static void main(String[] args) {
				try {
					// Datos
					Client bean = new Client(5, "DNI", "78451236", "Alexander", "Vicente Nolazco", "25-06-1995", "991574221", "alexander.vicente@outlook.com", "A");
				
					// Proceso
					CrudClientService clientService = new CrudClientService();
					clientService.update(bean);
					System.out.print(bean);
				} catch (Exception e) {
						System.err.print(e.getMessage());
				}
		            
		}
}
      