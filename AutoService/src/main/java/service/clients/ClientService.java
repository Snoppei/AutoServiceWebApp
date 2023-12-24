package service.clients;

import java.util.List;

import entity.Client;

public interface ClientService {
    void createClient(String lastName, String firstName, String middleName, String contactPhone);
    void deleteClient(Long clientId);
    List<Client> getAllClients();
    boolean clientExists(Long clientId);
}
