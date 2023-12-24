package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import repo.DatabaseHandlerImplementation;
import service.clients.ClientService;
import service.clients.ClientServiceImpl;

@WebServlet("/deleteClient")
public class DeleteClientServlet extends HttpServlet {
    private ClientService clientService;

    public DeleteClientServlet() {
        this.clientService = new ClientServiceImpl(new DatabaseHandlerImplementation());
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String clientIdString = request.getParameter("clientId");

        if (clientIdString != null && !clientIdString.isEmpty()) {
            Long clientId = Long.parseLong(clientIdString);
            clientService.deleteClient(clientId);
        }

        response.sendRedirect(request.getContextPath() + "/viewClients");
    }
}
