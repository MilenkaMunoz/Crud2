package pe.edu.vallegrande.proyecto.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import pe.edu.vallegrande.proyecto.model.Client;
import pe.edu.vallegrande.proyecto.service.impl.CrudClientService;

	@WebServlet({ "/ClientBuscar", "/ClientBuscar2", "/ClientProcesar" , "/ClientInactivos"})
	public class ClientController extends HttpServlet {
		private static final long serialVersionUID = 1L;

		private CrudClientService service = new CrudClientService();
	
		@Override
		protected void service(HttpServletRequest request, HttpServletResponse response)
				throws ServletException, IOException {
			String path = request.getServletPath();
			switch (path) {
			case "/ClientBuscar":
				buscar(request, response);
				break;
			case "/ClientBuscar2":
				buscar2(request, response);
				break;
			case "/ClientProcesar":
				procesar(request, response);
				break;
			case "/ClientInactivos":
				inactivos(request, response);
				break;
			}

		}

		private void inactivos(HttpServletRequest request, HttpServletResponse response) {
			// TODO Auto-generated method stub
			List<Client> lista = service.getInactivos();
			Gson gson = new Gson();
			String data = gson.toJson(lista);
			ControllerUtil.responseJson(response, data);
			
		}

		private void procesar(HttpServletRequest request, HttpServletResponse response) {
			// Datos
			String accion = request.getParameter("accion");
			Client bean = new Client();
			bean.setId(Integer.parseInt(request.getParameter("id")));
			bean.setType_document(request.getParameter("document_type"));
			bean.setNumber_document(request.getParameter("number_document"));
			bean.setNames(request.getParameter("names"));
			bean.setLast_name(request.getParameter("last_name"));
			bean.setBirthdate("birthdate");
			bean.setCell_phone(request.getParameter("cell_phone"));
			bean.setEmail(request.getParameter("email"));
			bean.setState(request.getParameter("state"));
			
			// Proceso
			try {
				switch (accion) {
				case ControllerUtil.CRUD_NUEVO:
					service.insert(bean);
					break;

				case ControllerUtil.CRUD_EDITAR:
					service.update(bean);
					break;
					
				case ControllerUtil.CRUD_ELIMINAR:
					service.delete(bean.getId().toString());
					break;

				case ControllerUtil.CRUD_RESTAURE:
					service.Restaurar(bean.getId().toString());
					break;
					
				case ControllerUtil.CRUD_ELIMINATE:
					service.EliminadoLogico(bean.getId().toString());
					break;

				default:
					throw new IllegalArgumentException("Unexpected value: " + accion);
				}
				ControllerUtil.responseJson(response, "EL proceso se GUARDO, Click BUSCAR");

			} catch (Exception e) {
				ControllerUtil.responseJson(response, e.getMessage());
			}
		}


		private void buscar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			// Datos
			String names = request.getParameter("names");
			String last_name = request.getParameter("last_name");
			// Proceso
			Client bean = new Client();
			bean.setNames(names);
			bean.setLast_name(last_name);
			List<Client> lista = service.get(bean);
			// Reporte
			request.setAttribute("listado", lista);
			RequestDispatcher rd = request.getRequestDispatcher("client.jsp");
			rd.forward(request, response);
		}
		
		private void buscar2(HttpServletRequest request, HttpServletResponse response) throws IOException {
			// Datos
			String type_document = request.getParameter("type_document");
			String names = request.getParameter("names");
			String last_name = request.getParameter("last_name");
			// Proceso
			Client bean = new Client();
			bean.setLast_name(last_name);
			bean.setNames(names);
			bean.setType_document(type_document);
			List<Client> lista = service.get(bean);
			lista.forEach(valor -> System.out.println("Client: " + valor.toString()));
			// Preparando el JSON
			Gson gson = new Gson();
			String data = gson.toJson(lista);
			// Reporte
			ControllerUtil.responseJson(response, data);

		}
	}
