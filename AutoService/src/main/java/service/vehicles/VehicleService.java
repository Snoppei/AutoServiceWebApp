package service.vehicles;

import java.util.List;

import entity.Vehicle;

public interface VehicleService {
    void createVehicle(String registrationNumber, String mark, int yearOfManufacture);
    void deleteVehicle(Long vehicleId);
    List<Vehicle> getAllVehicles();
    boolean vehicleExists(Long vehicleId);
}
