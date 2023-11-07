package pe.edu.vallegrande.proyecto.prueba;

import java.util.List;

import pe.edu.vallegrande.proyecto.model.Client;
import pe.edu.vallegrande.proyecto.model.Wench;
import pe.edu.vallegrande.proyecto.service.impl.CrudClientService;
import pe.edu.vallegrande.proyecto.service.impl.CrudWenchService;

public class PruebaListarTodo {

	//listar tabla completa
		public static void main(String[] args) {
	        try {
	            CrudWenchService personService = new CrudWenchService();
	            List<Wench> lista = personService.getAll();
	            for (Wench Wench : lista) {
	                System.out.println(Wench);
	            }
	        } catch (Exception e) {
	            System.err.println(e.getMessage());
	        }
	    }
	
}