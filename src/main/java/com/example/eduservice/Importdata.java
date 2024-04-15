package com.example.eduservice;

import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.MongoCollection;
import org.bson.Document;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import java.io.FileReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.io.FileInputStream;

public class Importdata {
    public static void main(String[] args) {
        try {
            // Load environment variables from a properties file
            Properties properties = new Properties();
            properties.load(new FileInputStream(".env"));

            String mongoUser = properties.getProperty("MONGO_USER");
            String mongoPassword = properties.getProperty("MONGO_PASSWORD");
            String mongoUri = "mongodb+srv://muskankohli2000:AssignmentDss@cluster0.kkyabjq.mongodb.net/?retryWrites=true&w=majority&appName=Cluster0";

            // Connect to MongoDB Atlas
            try (MongoClient mongoClient = MongoClients.create(mongoUri)) {
                MongoDatabase database = mongoClient.getDatabase("education");
                MongoCollection<Document> collection = database.getCollection("EduCostStat");

                // Read the CSV file using the updated method to handle headers
                Reader in = new FileReader("C:\\Users\\Dell\\Documents\\COEN6731_ASN2-master\\nces330_20.csv");
                CSVParser parser = new CSVParser(in, CSVFormat.DEFAULT.builder().setHeader().build());
                List<Document> documents = new ArrayList<>();
                
                for (CSVRecord record : parser) {
                    Document doc = new Document();
                    for (String header : parser.getHeaderNames()) {
                        String value = record.get(header);
                        doc.append(header, value.isEmpty() ? null : value);
                    }
                    documents.add(doc);
                }

                // Insert records into the collection
                collection.insertMany(documents);
            }

            System.out.println("Data import completed.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
