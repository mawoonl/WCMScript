package nl.mawoo.wcmscript.extend.mongodb;

import com.mongodb.MongoClient;
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;
import com.mongodb.client.MongoDatabase;

import java.util.Arrays;

/**
 * This class is responsible to manage the connection with MongoDB
 */
public class MongoConnector {
    private String currentDatabase;
    private String host = "localhost";
    private int port = 27017;
    private String username = null;
    private String password = null;

    private MongoDatabase database;

    /**
     * Login with no credentials
     * @param database collection that you want to use.
     */
    public MongoConnector(String database) {
        this.currentDatabase = database;
    }

    /**
     * Make the connection to MongoDB
     */
    public void connect() {
        MongoClient client = null;

        // Check if the credentials are filled in to establish the connection.
        if(this.username == null || this.password == null) {
            client = new MongoClient(new ServerAddress(host, port));
        } else {
            MongoCredential mongoCredential = MongoCredential.createMongoCRCredential(this.username, this.currentDatabase, this.password.toCharArray());
            client = new MongoClient(new ServerAddress(host, port), Arrays.asList(mongoCredential));
        }
        this.database = client.getDatabase(currentDatabase);
    }

    /**
     * Get a collection
     * @param collection string of the collection you want to use
     * @return MongoCollectionHandler so you can input data
     */
    public MongoCollectionHandler getCollection(String collection) {
        return new MongoCollectionHandler(database.getCollection(collection));
    }

    /**
     * Replace default host
     * Default is: "localhost"
     * @param host
     */
    public void setHost(String host) {
        this.host = host;
    }

    /**
     * Replace default port
     * Default port is "27017"
     * @param port MongoDB connection port
     */
    public void setPort(int port) {
        this.port = port;
    }

    /**
     * Replace default username
     * Default username is "null"
     * @param username String of username
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * Replace default password
     * @param password String of password
     */
    public void setPassword(String password) {
        this.password = password;
    }
}