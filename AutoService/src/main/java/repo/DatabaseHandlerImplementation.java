package repo;

import java.util.List;
import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;

import entity.Client;
import entity.Employee;
import entity.Vehicle;

public class DatabaseHandlerImplementation implements DatabaseHandler {
	
	@Override
	public void saveEmployee(Employee employee) {
        try (Connection connection = DataManager.getConnection();
                PreparedStatement statement = connection.prepareStatement("INSERT INTO employees (last_name, first_name, middle_name, date_of_birth, address, contact_phone, job_position, salary, experience, work_schedule, experience_bonus) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)")) {
               statement.setString(1, employee.getLastName());
               statement.setString(2, employee.getFirstName());
               statement.setString(3, employee.getMiddleName());
               statement.setDate(4, Date.valueOf(employee.getDateOfBirth()));
               statement.setString(5, employee.getAddress());
               statement.setString(6, employee.getContactPhone());
               statement.setString(7, employee.getJobPosition());
               statement.setInt(8, employee.getSalary());
               statement.setInt(9, employee.getExperience());
               statement.setString(10, employee.getWorkSchedule());
               statement.setInt(11, employee.getExperienceBonus());
               statement.executeUpdate();
           } catch (SQLException e) {
               e.printStackTrace();
           }
	}

	@Override
	public void saveVehicle(Vehicle vehicle) {
        try (Connection connection = DataManager.getConnection();
                PreparedStatement statement = connection.prepareStatement("INSERT INTO vehicles (client_id, registration_number, mark, year_of_manufacture) VALUES (?, ?, ?, ?)")) {
               statement.setLong(1, vehicle.getClientId());
               statement.setString(2, vehicle.getRegistrationNumber());
               statement.setString(3, vehicle.getMark());
               statement.setInt(4, vehicle.getYearOfManufacture());
               statement.executeUpdate();
           } catch (SQLException e) {
               e.printStackTrace();
           }
	}
	
	@Override
	public void saveClient(Client client) {
        try (Connection connection = DataManager.getConnection();
                PreparedStatement statement = connection.prepareStatement("INSERT INTO clients (last_name, first_name, middle_name, contact_phone) VALUES (?, ?, ?, ?)")) {
               statement.setString(1, client.getLastName());
               statement.setString(2, client.getFirstName());
               statement.setString(3, client.getMiddleName());
               statement.setString(4, client.getContactPhone());
               statement.executeUpdate();
           } catch (SQLException e) {
               e.printStackTrace();
           }
	}

	@Override
	public void deleteEmployee(Long employeeId) {
        try (Connection connection = DataManager.getConnection();
                //PreparedStatement deleteServiceRequestsStatement = connection.prepareStatement("DELETE FROM service_requests WHERE employee_id = ?");
                PreparedStatement deleteEmployeeStatement = connection.prepareStatement("DELETE FROM employees WHERE employee_id = ?")) {

               //deleteServiceRequestsStatement.setLong(1, employeeId);
               //deleteServiceRequestsStatement.executeUpdate();
               deleteEmployeeStatement.setLong(1, employeeId);
               deleteEmployeeStatement.executeUpdate();
           } catch (SQLException e) {
               e.printStackTrace();
           }
	}

	@Override
	public void deleteVehicle(Long vehicleId) {
        try (Connection connection = DataManager.getConnection();
                //PreparedStatement deleteServiceRequestsStatement = connection.prepareStatement("DELETE FROM service_requests WHERE vehicle_id = ?");
                PreparedStatement deleteVehicleStatement = connection.prepareStatement("DELETE FROM vehicles WHERE vehicle_id = ?")) {

               //deleteServiceRequestsStatement.setLong(1, vehicleId);
               //deleteServiceRequestsStatement.executeUpdate();
               deleteVehicleStatement.setLong(1, vehicleId);
               deleteVehicleStatement.executeUpdate();
           } catch (SQLException e) {
               e.printStackTrace();
           }
	}
	
	@Override
	public void deleteClient(Long clientId) {
        try (Connection connection = DataManager.getConnection();
                PreparedStatement deleteVehiclesStatement = connection.prepareStatement("DELETE FROM vehicles WHERE client_id = ?");
                PreparedStatement deleteClientStatement = connection.prepareStatement("DELETE FROM clients WHERE client_id = ?")) {

               deleteVehiclesStatement.setLong(1, clientId);
               deleteVehiclesStatement.executeUpdate();
               deleteClientStatement.setLong(1, clientId);
               deleteClientStatement.executeUpdate();
           } catch (SQLException e) {
               e.printStackTrace();
           }
	}

	@Override
	public List<Employee> getAllEmployees() {
        List<Employee> employees = new ArrayList<>();
        try (Connection connection = DataManager.getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery("SELECT * FROM employees")) {

            while (resultSet.next()) {
                Long employeeId = resultSet.getLong("employee_id");
                String lastName = resultSet.getString("last_name");
                String firstName = resultSet.getString("first_name");
                String middleName = resultSet.getString("middle_name");
                LocalDate dateOfBirth = resultSet.getDate("date_of_birth").toLocalDate();
                String address = resultSet.getString("address");
                String contactPhone = resultSet.getString("contact_phone");
                String jobPosition = resultSet.getString("job_position");
                int salary = resultSet.getInt("salary");
                int experience = resultSet.getInt("experience");
                String workSchedule = resultSet.getString("work_schedule");
                int experienceBonus = resultSet.getInt("experience_bonus");
                employees.add(new Employee(employeeId, lastName, firstName, middleName, dateOfBirth, address, contactPhone, jobPosition, salary, experience, workSchedule, experienceBonus));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return employees;
	}

	@Override
	public List<Vehicle> getAllVehicles() {
        List<Vehicle> vehicles = new ArrayList<>();
        try (Connection connection = DataManager.getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery("SELECT * FROM vehicles")) {

            while (resultSet.next()) {
                Long vehicleId = resultSet.getLong("vehicle_id");
                Long clientId = resultSet.getLong("client_id");
                String registrationNumber = resultSet.getString("registration_number");
                String mark = resultSet.getString("mark");
                int yearOfManufacture = resultSet.getInt("year_of_manufacture");
                vehicles.add(new Vehicle(vehicleId, clientId, registrationNumber, mark, yearOfManufacture));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return vehicles;
	}
	
	@Override
	public List<Client> getAllClients() {
        List<Client> clients = new ArrayList<>();
        try (Connection connection = DataManager.getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery("SELECT * FROM clients")) {

            while (resultSet.next()) {
                Long clientId = resultSet.getLong("client_id");
                String lastName = resultSet.getString("last_name");
                String firstName = resultSet.getString("first_name");
                String middleName = resultSet.getString("middle_name");
                String contactPhone = resultSet.getString("contact_phone");
                clients.add(new Client(clientId, lastName, firstName, middleName, contactPhone));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return clients;
	}

	@Override
	public boolean vehicleExists(Long vehicleId) {
        try (Connection connection = DataManager.getConnection();
                PreparedStatement statement = connection.prepareStatement("SELECT vehicle_id FROM vehicles WHERE vehicle_id = ?")) {
               statement.setLong(1, vehicleId);
               try (ResultSet resultSet = statement.executeQuery()) {
                   return resultSet.next();
               }
           } catch (SQLException e) {
               e.printStackTrace();
               return false;
           }
	}

	@Override
	public boolean employeeExists(Long employeeId) {
        try (Connection connection = DataManager.getConnection();
                PreparedStatement statement = connection.prepareStatement("SELECT employee_id FROM employees WHERE employee_id = ?")) {
               statement.setLong(1, employeeId);
               try (ResultSet resultSet = statement.executeQuery()) {
                   return resultSet.next();
               }
           } catch (SQLException e) {
               e.printStackTrace();
               return false;
           }
	}
	
	@Override
	public boolean clientExists(Long clientId) {
        try (Connection connection = DataManager.getConnection();
                PreparedStatement statement = connection.prepareStatement("SELECT client_id FROM clients WHERE client_id = ?")) {
               statement.setLong(1, clientId);
               try (ResultSet resultSet = statement.executeQuery()) {
                   return resultSet.next();
               }
           } catch (SQLException e) {
               e.printStackTrace();
               return false;
           }
	}

}
