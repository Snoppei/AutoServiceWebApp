package repo;

import entity.Employee;
import entity.Vehicle;
import entity.Client;

import java.sql.SQLException;
import java.util.List;

public interface DatabaseHandler {
    void saveEmployee(Employee employee) throws SQLException;
    void saveClient(Client client) throws SQLException;
    void saveVehicle(Vehicle vehicle) throws SQLException;
    void deleteEmployee(Long employeeId) throws SQLException;
    void deleteVehicle(Long vehicleId) throws SQLException;
    void deleteClient(Long clientId) throws SQLException;
    List<Employee> getAllEmployees() throws SQLException;
    List<Client> getAllClients() throws SQLException;
    List<Vehicle> getAllVehicles() throws SQLException;
    boolean vehicleExists(Long vehicleId) throws SQLException;
    boolean employeeExists(Long employeeId) throws SQLException;
    boolean clientExists(Long clientId) throws SQLException;
}
