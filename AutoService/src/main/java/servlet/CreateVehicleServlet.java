package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entity.Vehicle;
import repo.DatabaseHandlerImplementation;
import service.vehicles.VehicleService;
import service.vehicles.VehicleServiceImpl;

@WebServlet("/createVehicle")
public class CreateVehicleServlet extends HttpServlet {
    private VehicleService vehicleService;

    public CreateVehicleServlet() {
        this.vehicleService = new VehicleServiceImpl(new DatabaseHandlerImplementation());
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/createVehicle.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String mark = request.getParameter("mark");
        String registrationNumber = request.getParameter("registrationNumber");
        int yearOfManufacture = Integer.parseInt(request.getParameter("yearOfManufacture"));

        //Vehicle newVehicle = new Vehicle(null, null, registrationNumber, mark, yearOfManufacture);
        vehicleService.createVehicle(registrationNumber, mark, yearOfManufacture);

        response.sendRedirect(request.getContextPath() + "/viewVehicles");
    }
}
