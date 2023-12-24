package service.employees;

import entity.Employee;
import repo.DatabaseHandler;
import service.utilities.IdGenerator;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

public class EmployeeServiceImpl implements EmployeeService {
    private DatabaseHandler dataHandl;
    private IdGenerator idGenerator;

    public EmployeeServiceImpl(DatabaseHandler dataHandl) {
        this.dataHandl = dataHandl;
        this.idGenerator = new IdGenerator();
    }

    @Override
    public void createEmployee(String lastName, String firstName, String middleName, LocalDate dateOfBirth, String address, String contactPhone, String jobPosition, int salary, int experience, String workSchedule, int experienceBonus) {
        try {
        	Long employeeId = idGenerator.getNextEmployeeId();
        	Employee employee = new Employee(employeeId, lastName, firstName, middleName, dateOfBirth, address, contactPhone, jobPosition, salary, experience, workSchedule, experienceBonus);
        	dataHandl.saveEmployee(employee);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteEmployee(Long employeeId) {
        try {
        	dataHandl.deleteEmployee(employeeId);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Employee> getAllEmployees() {
        try {
            return dataHandl.getAllEmployees();
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public boolean employeeExists(Long employeeId) {
        try {
            return dataHandl.employeeExists(employeeId);
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
