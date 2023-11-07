package pe.edu.vallegrande.proyecto.service.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import pe.edu.vallegrande.proyecto.db.AccesoDB;
import pe.edu.vallegrande.proyecto.model.Client;
import pe.edu.vallegrande.proyecto.service.spec.CrudServiceSpecClient;
import pe.edu.vallegrande.proyecto.service.spec.RowMapper;

public class CrudClientService implements CrudServiceSpecClient<Client>, RowMapper<Client>  {

		// Definiendo cosas
	    private final String SQL_SELECT_BASE = "SELECT * FROM Client";
	    private final String SQL_INSERT = "INSERT INTO Client (type_document, number_document, names, last_name, birthdate, cell_phone, email) VALUES (?, ?, ?, ?, ?, ?, ?)";
	    private final String SQL_UPDATE = "UPDATE Client SET type_document = ?, number_document = ?, names = ?, last_name = ?, birthdate = ?, cell_phone = ?, email = ?, state = ?, WHERE id = ?";
	    private final String SQL_RESTAURE = "UPDATE Client SET state = 'A' WHERE id = ?";
	    private final String SQL_ELIMINATE = "UPDATE Client SET state = 'I' WHERE id = ?";
	    private final String SQL_DELETE = "DELETE FROM Client WHERE id = ?";

	    
	 // Obtiene todos los datos de una tabla
	    public List<Client> getAll() {
	    	// Variables
			Connection cn = null;
			List<Client> lista = new ArrayList<>();
			PreparedStatement pstm = null;
			ResultSet rs = null;
			Client bean;
			String sql;
			// Proceso
			try {
				cn = AccesoDB.getConnection();
				sql = SQL_SELECT_BASE + " WHERE state='A'";
				pstm = cn.prepareStatement(sql);
				rs = pstm.executeQuery();
				while (rs.next()) {
					bean = mapRow(rs);
					lista.add(bean);
				}
				rs.close();
				pstm.close();
			} catch (SQLException e) {
				throw new RuntimeException(e.getMessage());
			} finally {
				try {
					cn.close();
				} catch (Exception e2) {
				}
			}
			return lista;
		}
	    
	 // listamos INACTIVOS nuestra DB persona que nos muestren los estados I
	 		public List<Client> getInactivos() {
	 			// Variables
	 			Connection cn = null;
	 			List<Client> lista = new ArrayList<>();
	 			PreparedStatement pstm = null;
	 			ResultSet rs = null;
	 			Client bean;
	 			String sql;
	 			// Proceso
	 			try {
	 				cn = AccesoDB.getConnection();
	 				sql = SQL_SELECT_BASE + " WHERE state='I' ORDER BY names, last_name";
	 				pstm = cn.prepareStatement(sql);
	 				rs = pstm.executeQuery();
	 				while (rs.next()) {
	 					bean = mapRow(rs);
	 					lista.add(bean);
	 				}
	 				rs.close();
	 				pstm.close();
	 			} catch (SQLException e) {
	 				throw new RuntimeException(e.getMessage());
	 			} finally {
	 				try {
	 					cn.close();
	 				} catch (Exception e2) {
	 				}
	 			}
	 			return lista;
	 		}
	    
	 	// listar el dato de la tabla
	 		public Client getForId(String id) {
	 			// Variables
	 			Connection cn = null;
	 			PreparedStatement pstm = null;
	 			ResultSet rs = null;
	 			Client bean = null;
	 			String sql;
	 			// Proceso
	 			try {
	 				cn = AccesoDB.getConnection();
	 				sql = SQL_SELECT_BASE + " WHERE id=?";
	 				pstm = cn.prepareStatement(sql);
	 				pstm.setInt(1, Integer.parseInt(id));
	 				rs = pstm.executeQuery();
	 				if (rs.next()) {
	 					bean = mapRow(rs);
	 				}
	 				rs.close();
	 				pstm.close();
	 			} catch (SQLException e) {
	 				throw new RuntimeException(e.getMessage());
	 			} finally {
	 				try {
	 					cn.close();
	 				} catch (Exception e2) {
	 				}
	 			}
	 			return bean;
	 		}

	 	// INSERTAMOS nuevos datos
	 		public void insert(Client bean) {
	 			// Variables
	 			Connection cn = null;
	 			PreparedStatement pstm = null;
	 			int filas;
	 			// Proceso
	 			try {
	 				// Iniciar la Tx
	 				cn = AccesoDB.getConnection();
	 				cn.setAutoCommit(false);
	 				pstm = cn.prepareStatement(SQL_INSERT);
	 				pstm.setString(1, bean.getType_document());
	 				pstm.setString(2, bean.getNumber_document()); 
	 				pstm.setString(3, bean.getNames());
	 				pstm.setString(4, bean.getLast_name()); 
	 				pstm.setString(5, bean.getBirthdate());
	 				pstm.setString(6, bean.getCell_phone());
	 				pstm.setString(7, bean.getEmail());
	 				filas = pstm.executeUpdate();
	 				pstm.close();
	 				
	 				if (filas != 1) {
	 					throw new SQLException("Error, verifique sus datos e intentelo nuevamente.");
	 				}
	 				cn.commit();
	 			} catch (SQLException e) {
	 				try {
	 					cn.rollback();
	 					cn.close();
	 				} catch (Exception e2) {
	 				}
	 			} finally {
	 				try {
	 					cn.close();
	 				} catch (Exception e2) {
	 				}
	 			}
	 		}

	 		@Override
	 		public void update(Client bean) {
	 			// Variables
	 			Connection cn = null;
	 			PreparedStatement pstm = null;
	 			int filas;
	 			// Proceso
	 			try {
	 				// Iniciar la Tx
	 				cn = AccesoDB.getConnection();
	 				cn.setAutoCommit(false);
	 				// Actualizar el registro
	 				pstm = cn.prepareStatement(SQL_UPDATE);
	 				pstm.setString(1, bean.getType_document());
	 				pstm.setString(2, bean.getNumber_document()); 
	 				pstm.setString(3, bean.getNames());
	 				pstm.setString(4, bean.getLast_name()); 
	 				pstm.setString(5, bean.getBirthdate());
	 				pstm.setString(6, bean.getCell_phone());
	 				pstm.setString(7, bean.getEmail());
	 				pstm.setString(8, bean.getState());
	 				pstm.setInt(9, bean.getId());
	 				filas = pstm.executeUpdate();
	 				pstm.close();
	 				if (filas != 1) {
	 					throw new SQLException("Error en CrudClientService, verifique sus datos e intentelo nuevamente.");
	 				}
	 				// Fin de Tx
	 				cn.commit();
	 			} catch (SQLException e) {
	 				try {
	 					cn.rollback();
	 					cn.close();
	 				} catch (Exception e2) {
	 				}
	 				throw new RuntimeException(e.getMessage());
	 			} finally {
	 				try {
	 					cn.close();
	 				} catch (Exception e2) {
	 				}
	 			}
	 		}

	 	// ELIMINAMOS los datos de una fila en la tabla persona
	 		@Override
	 		public void delete(String id) {
	 			// Variables
	 			Connection cn = null;
	 			PreparedStatement pstm = null;
	 			int filas = 0;

	 			// Proceso
	 			try {
	 				// Inicio de Tx
	 				cn = AccesoDB.getConnection();
	 				cn.setAutoCommit(false);
	 				// Proceso
	 				pstm = cn.prepareStatement(SQL_DELETE);
	 				pstm.setInt(1, Integer.parseInt(id));
	 				filas = pstm.executeUpdate();
	 				pstm.close();
	 				if (filas != 1) {
	 					throw new SQLException("uyyyy no se pudo eliminar el cliente, vuelve a intentarlo.");
	 				}
	 				// Confirmar Tx
	 				cn.commit();
	 			} catch (SQLException e) {
	 				throw new RuntimeException(e.getMessage());
	 			} finally {
	 				try {
	 					cn.close();
	 				} catch (Exception e2) {
	 				}
	 			}
	 		}
	 		
	 	// ELIMINAMOS los datos de una fila en la tabla persona I
			
			public void EliminadoLogico(String id) {
				// Variables
				Connection cn = null;
				PreparedStatement pstm = null;
				int filas = 0;

				// Proceso
				try {
					// Inicio de Tx
					cn = AccesoDB.getConnection();
					cn.setAutoCommit(false);
					// Proceso
					pstm = cn.prepareStatement(SQL_ELIMINATE);
					pstm.setInt(1, Integer.parseInt(id));
					filas = pstm.executeUpdate();
					pstm.close();
					if (filas != 1) {
						throw new SQLException("Listo ya se ELIMINO de manera LOGICO el registro a 'I' ");
					}
					// Confirmar Tx
					cn.commit();
				} catch (SQLException e) {
					throw new RuntimeException(e.getMessage());
				} finally {
					try {
						cn.close();
					} catch (Exception e2) {
					}
				}

			}
	 		
			// RESTAURAR los datos de una fila en la tabla persona
			
			public void Restaurar(String id) {
				// Variables
				Connection cn = null;
				PreparedStatement pstm = null;
				int filas = 0;

				// Proceso
				try {
					// Inicio de Tx
					cn = AccesoDB.getConnection();
					cn.setAutoCommit(false);
					// Proceso
					pstm = cn.prepareStatement(SQL_RESTAURE);
					pstm.setInt(1, Integer.parseInt(id));
					filas = pstm.executeUpdate();
					pstm.close();
					if (filas != 1) {
						throw new SQLException("Listo ya se RESTAURO el registro a 'A' ");
					}
					// Confirmar Tx
					cn.commit();
				} catch (SQLException e) {
					throw new RuntimeException(e.getMessage());
				} finally {
					try {
						cn.close();
					} catch (Exception e2) {
					}
				}

			}
			
			
			// Realiza la busqueda por apellido y nombre dentro de la tabla.
			@Override
			public List<Client> get(Client bean) {
				// Variables
				Connection cn = null;
				List<Client> lista = new ArrayList<>();
				PreparedStatement pstm = null;
				ResultSet rs = null;
				Client item;
				String sql;
				String type_document;
				String names;
				String last_name;
				
				// Preparar los datos
				type_document = "%" + UtilService.setStringVacio(bean.getType_document()) + "%";
				names = "%" + UtilService.setStringVacio(bean.getNames()) + "%";
				last_name = "%" + UtilService.setStringVacio(bean.getLast_name()) + "%";
				
				// Proceso
				try {
					// Conexion
					cn = AccesoDB.getConnection();
					// La consulta
					sql = SQL_SELECT_BASE + " WHERE type_document LIKE ? AND names LIKE ? AND last_name LIKE ?  AND state ='A' ORDER BY names, last_name";
					pstm = cn.prepareStatement(sql);
					pstm.setString(1, type_document);
					pstm.setString(2, names);
					pstm.setString(3, last_name);
					
					rs = pstm.executeQuery();
					while (rs.next()) {
						item = mapRow(rs);
						lista.add(item);
					}
					rs.close();
					pstm.close();
				} catch (SQLException e) {
					throw new RuntimeException(e.getMessage());
				} finally {
					try {
						cn.close();
					} catch (Exception e2) {
					}
				}
				return lista;
			}
			
	 		
	@Override
	public Client mapRow(ResultSet rs) throws SQLException {
		Client bean = new Client();
		// Columnas: id, type_document, number_document, names; last_name;
		// birthdate, cell_phone; email; state;
		bean.setId(rs.getInt("id"));
		bean.setType_document(rs.getString("type_document")); 
		bean.setNumber_document(rs.getString("number_document")); 
		bean.setNames(rs.getString("names"));
		bean.setLast_name(rs.getString("last_name"));
		bean.setBirthdate("birthdate");
		bean.setCell_phone(rs.getString("cell_phone"));
		bean.setEmail(rs.getString("email"));
		bean.setState(rs.getString("state"));
		
		
		return bean;
	}

	@Override
	public Client getById(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Integer id) {
		// TODO Auto-generated method stub
		
	}



}