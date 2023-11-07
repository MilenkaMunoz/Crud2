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
import pe.edu.vallegrande.proyecto.model.Wench;
import pe.edu.vallegrande.proyecto.service.impl.CrudWenchService;

@WebServlet("/wench/*")
public class WenchController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private final CrudWenchService service = new CrudWenchService();

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String path = request.getServletPath();
        switch (path) {
            case "/wench/buscar":
                search(request, response);
                break;
            case "/wench/buscar2":
                search2(request, response);
                break;
            case "/wench/procesar":
                process(request, response);
                break;
            case "/wench/inactivos":
                getInactivos(request, response);
                break;
        }
    }

    private void getInactivos(HttpServletRequest request, HttpServletResponse response) {
        List<Wench> inactivos = service.getInactivos();
        Gson gson = new Gson();
        String data = gson.toJson(inactivos);
        ControllerUtil.responseJson(response, data);
    }

    private void process(HttpServletRequest request, HttpServletResponse response) {
        String action = request.getParameter("accion");
        Wench Wench = new Wench();
        Wench.setId(Integer.parseInt(request.getParameter("id")));
        Wench.setTypeDocument(request.getParameter("document_type"));
        Wench.setNumberDocument(request.getParameter("number_document"));
        Wench.setNames(request.getParameter("names"));
        Wench.setLastName(request.getParameter("last_name"));
        Wench.setBirthdate("birthdate"); // Check if this should be changed
        Wench.setCellPhone(request.getParameter("cell_phone"));
        Wench.setEmail(request.getParameter("email"));
        Wench.setState(request.getParameter("state"));

        try {
            switch (action) {
                case ControllerUtil.CRUD_NUEVO:
                    service.insert(Wench);
                    break;
                case ControllerUtil.CRUD_EDITAR:
                    service.update(Wench);
                    break;
                case ControllerUtil.CRUD_ELIMINAR:
                    service.delete(Wench.getId().toString());
                    break;
                case ControllerUtil.CRUD_RESTAURE:
                    service.Restaurar(Wench.getId().toString());
                    break;
                case ControllerUtil.CRUD_ELIMINATE:
                    service.EliminadoLogico(Wench.getId().toString());
                    break;
                default:
                    throw new IllegalArgumentException("Unexpected action: " + action);
            }
            ControllerUtil.responseJson(response, "The process has been saved. Click SEARCH.");
        } catch (Exception e) {
            // Log the exception or handle it appropriately
            ControllerUtil.responseJson(response, e.getMessage());
        }
    }

    private void search(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String names = request.getParameter("names");
        String lastName = request.getParameter("last_name");
        Wench Wench = new Wench();
        Wench.setNames(names);
        Wench.setLastName(lastName);
        List<Wench> Wenchs = service.get(Wench);
        request.setAttribute("listado", Wenchs);
        RequestDispatcher rd = request.getRequestDispatcher("Wench.jsp");
        rd.forward(request, response);
    }

    private void search2(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String typeDocument = request.getParameter("type_document");
        String names = request.getParameter("names");
        String lastName = request.getParameter("last_name");
        Wench Wench = new Wench();
        Wench.setLastName(lastName);
        Wench.setNames(names);
        Wench.setTypeDocument(typeDocument);
        List<Wench> clients = service.get(Wench);
        Gson gson = new Gson();
        String data = gson.toJson(clients);
        ControllerUtil.responseJson(response, data);
    }
}
