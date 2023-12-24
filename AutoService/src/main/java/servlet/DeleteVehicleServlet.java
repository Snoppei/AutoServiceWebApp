package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import repo.DatabaseHandlerImplementation;
import service.vehicles.VehicleService;
import service.vehicles.VehicleServiceImpl;

@WebServlet("/deleteVehicle")
public class DeleteVehicleServlet extends HttpServlet {
    private VehicleService vehicleService;

    public DeleteVehicleServlet() {
        this.vehicleService = new VehicleServiceImpl(new DatabaseHandlerImplementation());
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Long vehicleId = Long.parseLong(request.getParameter("vehicleId"));
        vehicleService.deleteVehicle(vehicleId);

        response.sendRedirect(request.getContextPath() + "/viewVehicles");
    }
}
