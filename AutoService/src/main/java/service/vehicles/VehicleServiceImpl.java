package service.vehicles;

import entity.Vehicle;
import repo.DatabaseHandler;
import service.utilities.IdGenerator;

import java.sql.SQLException;
import java.util.List;

public class VehicleServiceImpl implements VehicleService {
    private DatabaseHandler dataHandler;
    private IdGenerator idGenerator;

    public VehicleServiceImpl(DatabaseHandler dataHandler) {
        this.dataHandler = dataHandler;
        this.idGenerator = new IdGenerator();
    }

    @Override
    public void createVehicle(String registrationNumber, String mark, int yearOfManufacture) {
        try {
        	Long vehicleId = idGenerator.getNextVehicleId();
        	Long clientId = idGenerator.getNextClientId();
        	Vehicle vehicle = new Vehicle(vehicleId, clientId, registrationNumber, mark, yearOfManufacture);
        	dataHandler.saveVehicle(vehicle);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteVehicle(Long vehicleId) {
        try {
        	dataHandler.deleteVehicle(vehicleId);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Vehicle> getAllVehicles() {
        try {
            return dataHandler.getAllVehicles();
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public boolean vehicleExists(Long vehicleId) {
        try {
            return dataHandler.vehicleExists(vehicleId);
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
