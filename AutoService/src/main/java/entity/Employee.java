package entity;

import java.time.LocalDate;

public class Employee {
    private Long employeeId;
    private String lastName;
    private String firstName;
    private String middleName;
    private LocalDate dateOfBirth;
    private String address;
    private String contactPhone;
    private String jobPosition;
    private int salary;
    private int experience;
    private String workSchedule;
    private int experienceBonus;

    public Employee(Long employeeId, String lastName, String firstName, String middleName, LocalDate dateOfBirth, String address, String contactPhone, String jobPosition, int salary, int experience, String workSchedule, int experienceBonus) {
        this.employeeId = employeeId;
        this.lastName = lastName;
        this.firstName = firstName;
        this.middleName = middleName;
        this.dateOfBirth = dateOfBirth;
        this.address = address;
        this.contactPhone = contactPhone;
        this.jobPosition = jobPosition;
        this.salary = salary;
        this.experience = experience;
        this.workSchedule = workSchedule;
        this.experienceBonus = experienceBonus;
    }

    public Long getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Long employeeId) {
        this.employeeId = employeeId;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getContactPhone() {
        return contactPhone;
    }

    public void setContactPhone(String contactPhone) {
        this.contactPhone = contactPhone;
    }

    public String getJobPosition() {
        return jobPosition;
    }

    public void setJobPosition(String jobPosition) {
        this.jobPosition = jobPosition;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public int getExperience() {
        return experience;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    public String getWorkSchedule() {
        return workSchedule;
    }

    public void setWorkSchedule(String workSchedule) {
        this.workSchedule = workSchedule;
    }

    public int getExperienceBonus() {
        return experienceBonus;
    }

    public void setExperienceBonus(int experienceBonus) {
        this.experienceBonus = experienceBonus;
    }

    // Constructors, getters, and setters
}
