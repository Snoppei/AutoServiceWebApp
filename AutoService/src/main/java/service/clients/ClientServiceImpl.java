package service.clients;

import entity.Client;
import repo.DatabaseHandler;
import service.utilities.IdGenerator;

import java.sql.SQLException;
import java.util.List;

public class ClientServiceImpl implements ClientService {
    private DatabaseHandler databaseHandler;
    private IdGenerator idGenerator;

    public ClientServiceImpl(DatabaseHandler databaseHandl) {
        this.databaseHandler = databaseHandl;
        this.idGenerator = new IdGenerator();
    }

    @Override
    public void createClient(String lastName, String firstName, String middleName, String contactPhone) {
        try {
        	Long clientId = idGenerator.getNextClientId();
        	Client client = new Client(clientId, lastName, firstName, middleName, contactPhone);
            databaseHandler.saveClient(client);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteClient(Long clientId) {
        try {
            databaseHandler.deleteClient(clientId);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Client> getAllClients() {
        try {
            return databaseHandler.getAllClients();
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public boolean clientExists(Long clientId) {
        try {
            return databaseHandler.clientExists(clientId);
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
