package servlet;

import java.io.IOException;

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

@WebServlet("/createClient")
public class CreateClientServlet extends HttpServlet {
    private ClientService clientService;

    public CreateClientServlet() {
        this.clientService = new ClientServiceImpl(new DatabaseHandlerImplementation());
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("/createClient.jsp");
        dispatcher.forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String lastName = request.getParameter("lastName");
        String firstName = request.getParameter("firstName");
        String middleName = request.getParameter("middleName");
        String contactPhone = request.getParameter("contactPhone");

        if (lastName != null && !lastName.isEmpty() &&
            firstName != null && !firstName.isEmpty() &&
            contactPhone != null && !contactPhone.isEmpty()) {

            //Client newClient = new Client(null, lastName, firstName, middleName, contactPhone);
            clientService.createClient(lastName, firstName, middleName, contactPhone);

            response.sendRedirect(request.getContextPath() + "/viewClients");
        } else {
            // Handle validation error or provide feedback to the user
            response.sendRedirect(request.getContextPath() + "/createClient.jsp");
        }
    }
}
