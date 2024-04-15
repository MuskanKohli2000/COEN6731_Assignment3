package com.example.eduservice;

import java.util.ArrayList;

import org.bson.Document;

import com.mongodb.ConnectionString;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

public class MongoUtil {

    private static final String DB_NAME = "EduCostStat";
    private static final String DB_CONNECTION_STRING = "mongodb+srv://muskankohli2000:AssignmentDss@cluster0.kkyabjq.mongodb.net/?retryWrites=true&w=majority&appName=Cluster0"
    		+ "";

    private static MongoClient mongoClient;
    
    private MongoUtil() {}
    
    public static synchronized MongoDatabase getDatabase() {
        if (mongoClient == null) {
            mongoClient = MongoClients.create(DB_CONNECTION_STRING);
        }
        return mongoClient.getDatabase(DB_NAME);
    }
    
    public static MongoCollection<Document> getCollection(String collectionName) {
		// Check if a MongoClient object has been created, create one if not
		if (mongoClient == null) {
			ConnectionString connectionString = new ConnectionString(DB_CONNECTION_STRING);
			mongoClient = MongoClients.create(connectionString);
		}

		// Get the database object
		MongoDatabase database = mongoClient.getDatabase(DB_NAME);

		// Check if the collection already exists
		if (database.listCollectionNames().into(new ArrayList<>()).contains(collectionName)) {
			// Collection exists, return it
			return database.getCollection(collectionName);
		}

		// Collection does not exist, create it and return it
		database.createCollection(collectionName);
		return database.getCollection(collectionName);
	}
}
