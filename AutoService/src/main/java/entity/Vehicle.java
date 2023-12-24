package entity;

public class Vehicle {
    public Vehicle(Long vehicleId, Long clientId, String registrationNumber, String mark, int yearOfManufacture) {
        this.vehicleId = vehicleId;
        this.clientId = clientId;
        this.registrationNumber = registrationNumber;
        this.mark = mark;
        this.yearOfManufacture = yearOfManufacture;
    }

    public Long getVehicleId() {
        return vehicleId;
    }

    public void setVehicleId(Long vehicleId) {
        this.vehicleId = vehicleId;
    }

    public Long getClientId() {
        return clientId;
    }

    public void setClientId(Long clientId) {
        this.clientId = clientId;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public void setRegistrationNumber(String registrationNumber) {
        this.registrationNumber = registrationNumber;
    }

    public String getMark() {
        return mark;
    }

    public void setMark(String mark) {
        this.mark = mark;
    }

    public int getYearOfManufacture() {
        return yearOfManufacture;
    }

    public void setYearOfManufacture(int yearOfManufacture) {
        this.yearOfManufacture = yearOfManufacture;
    }

    private Long vehicleId;
    private Long clientId;
    private String registrationNumber;
    private String mark;
    private int yearOfManufacture;
}
