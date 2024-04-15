package com.example.eduservice;

import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

import java.io.IOException;
import java.util.List;
import io.grpc.Server;
import io.grpc.ServerBuilder;

public class Main {

    public static void main(String[] args) throws InterruptedException, IOException {
        // MongoDB connection string
        ConnectionString connectionString = new ConnectionString("mongodb+srv://muskankohli2000:AssignmentDss@cluster0.kkyabjq.mongodb.net/?retryWrites=true&w=majority&appName=Cluster0");
        MongoClientSettings settings = MongoClientSettings.builder()
                .applyConnectionString(connectionString)
                .build();

        MongoClient mongoClient = MongoClients.create(settings);
        try {
            MongoDatabase database = mongoClient.getDatabase("education");
            EduCostStatQueries eduCostStatQueries = new EduCostStatQueries(database);

            // Optional: Demonstrate a MongoDB operation
            List<Document> top5ExpensiveStates = eduCostStatQueries.getTop5MostExpensiveStates(2013, "Private", "4-year");
            for (Document state : top5ExpensiveStates) {
                System.out.println(state.toJson());
            }

            // Create and start the gRPC server
            Server server = ServerBuilder.forPort(9090)
                    .addService(new EduServiceImpl(database)) // Correctly pass EduCostStatQueries instance
                    .build()
                    .start();

            System.out.println("gRPC server started, listening on port " + server.getPort());
            server.awaitTermination();
        } finally {
            mongoClient.close(); // Ensure MongoDB client is closed when done
        }
    }
}
