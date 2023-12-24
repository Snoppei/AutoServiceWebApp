package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entity.Client;
import repo.DatabaseHandlerImplementation;
import service.clients.ClientService;
import service.clients.ClientServiceImpl;

@WebServlet("/viewClients")
public class ViewClientsServlet extends HttpServlet {
    /**
	 * 
	 */
//	private static final long serialVersionUID = 1L;
	private ClientService clientService;

    public ViewClientsServlet() {
        this.clientService = new ClientServiceImpl(new DatabaseHandlerImplementation());
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Client> clients = clientService.getAllClients();
        request.setAttribute("clients", clients);

        RequestDispatcher dispatcher = request.getRequestDispatcher("/viewClients.jsp");
        dispatcher.forward(request, response);
    }
}
