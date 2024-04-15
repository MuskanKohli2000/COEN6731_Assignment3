package com.example.eduservice;


import io.grpc.Server;
import io.grpc.ServerBuilder;
import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoDatabase;

import java.io.IOException;

public class EduServiceServer {
    public static void main(String[] args) throws IOException, InterruptedException {
        // MongoDB connection string
        String connectionString = "mongodb+srv://muskankohli2000:AssignmentDss@cluster0.kkyabjq.mongodb.net/?retryWrites=true&w=majority&appName=Cluster0";

        // Create a MongoDatabase instance
        MongoClient mongoClient = MongoClients.create(MongoClientSettings.builder()
                .applyConnectionString(new ConnectionString(connectionString))
                .build());
        MongoDatabase database = mongoClient.getDatabase("education");

        int port = 50051; 
        Server server = ServerBuilder.forPort(port)
                .addService(new EduServiceImpl(database)) 
                .build()
                .start();

        System.out.println("Server started, listening on " + port);
        server.awaitTermination();

        // Close the MongoDB client when the server is shutting down
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            System.out.println("Shutting down MongoDB client");
            mongoClient.close();
        }));
    }
}
