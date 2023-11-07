package pe.edu.vallegrande.proyecto.service.spec;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import pe.edu.vallegrande.proyecto.model.Client;

public interface CrudServiceSpecClient<T> {

		/**
		 * Consulta todos los registros de la tabla.
		 * @return Retorna una lista de objetos.
		 */
		List<T> getAll();
	
		/**
		 * Permite consultar un registro especifico de la tabla en base de su ID.
		 * @param id El ID del registro a consultas.
		 * @return Retorna el registro se gun el ID.
		 */
		T getById(String id);
	
		/**
		 * Consulta registros en base a un filtro.
		 * @param bean
		 * @return
		 */
		List<T> get(T bean);
	
		/**
		 * Inserta un nuevo registro
		 * @param bean Datos del nuevo registro
		 * @return
		 */
		void insert(T bean);
	
		/**
		 * Actualiza datos de un registro específico
		 * @param bean Datos del registro
		 * @return
		 */
		void update(T bean);
		
		
		void delete(String id);
	
		/**
		 * Elimina un registro de la base de datos
		 * @param id
		 */
		void delete(Integer id);
		
		

}
