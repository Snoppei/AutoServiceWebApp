package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entity.Vehicle;
import repo.DatabaseHandlerImplementation;
import service.vehicles.VehicleService;
import service.vehicles.VehicleServiceImpl;

@WebServlet("/viewVehicles")
public class ViewVehiclesServlet extends HttpServlet {
    private VehicleService vehicleService;

    public ViewVehiclesServlet() {
        this.vehicleService = new VehicleServiceImpl(new DatabaseHandlerImplementation());
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Vehicle> vehicles = vehicleService.getAllVehicles();
        request.setAttribute("vehicles", vehicles);

        request.getRequestDispatcher("/viewVehicles.jsp").forward(request, response);
    }
}