package service.utilities;

public class IdGenerator {
    private Long vehicleIdCounter = 1L;
    private Long clientIdCounter = 1L;
    private Long employeeIdCounter = 1L;

    public Long getNextEmployeeId() {
        return employeeIdCounter++;
    }

    public Long getNextClientId() {
        return clientIdCounter++;
    }
    
    public Long getNextVehicleId() {
    	return vehicleIdCounter++;
    }
}