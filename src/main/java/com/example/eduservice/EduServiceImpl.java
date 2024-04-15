package com.example.eduservice;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

import org.bson.Document;

import com.example.eduservice.EduServiceGrpc.EduServiceImplBase;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Sorts;
import com.example.eduservice.RegionUtils;

import io.grpc.stub.StreamObserver;

public class EduServiceImpl extends EduServiceImplBase {
	
	private final MongoDatabase database;

    public EduServiceImpl(MongoDatabase database) {
        this.database = database; // Use this database instance in service methods
    }
	// MongoDB connection string (Ensure this is securely managed in a real application)
    private static final String CONNECTION_STRING = "mongodb+srv://muskankohli2000:AssignmentDss@cluster0.kkyabjq.mongodb.net/?retryWrites=true&w=majority&appName=Cluster0";
    private static final String DATABASE_NAME = "education"; // Adjust to your database name
    private static final String COLLECTION_NAME = "EduCostStat"; // Adjust to your collection name

    //Query 1 Implementation	
    @Override
    public void getCostByParams(GetCostByParamsRequest request, StreamObserver<GetCostByParamsResponse> responseObserver) {
        try (MongoClient mongoClient = MongoClients.create(CONNECTION_STRING)) {
            MongoDatabase database = mongoClient.getDatabase(DATABASE_NAME);
            MongoCollection<Document> collection = database.getCollection(COLLECTION_NAME);
            
            Document queryDocument = new Document("Year", request.getYear())
                    .append("State", request.getState())
                    .append("Type", request.getType())
                    .append("Length", request.getLength())
            		.append("Expense",request.getExpense());
            Document result = collection.find(queryDocument).first();
             double cost = 0;          	
             cost = result.getInteger("Value");           
            
                // Save the query
                Document saveDoc = new Document(queryDocument)
                        .append("cost", cost);
                database.getCollection("EduCostStatQueryOne").insertOne(saveDoc);
                System.out.println("Query saved successfully.");           

        
            GetCostByParamsResponse response = GetCostByParamsResponse.newBuilder().setCost(cost).build();
            responseObserver.onNext(response);
            responseObserver.onCompleted();
        }
        catch (Exception e) {
            System.err.println("Failed to save query: " + e.getMessage());
        }

 
    }
    
    //Query 2 Implementation
    @Override
    public void getTop5MostExpensiveStates(GetTop5MostExpensiveStatesRequest request, StreamObserver<GetTop5MostExpensiveStatesResponse> responseObserver) {
    	
    	 try (MongoClient mongoClient = MongoClients.create(CONNECTION_STRING)) {
             MongoDatabase database = mongoClient.getDatabase(DATABASE_NAME);
             MongoCollection<Document> collection = database.getCollection(COLLECTION_NAME);
        List<Document> states = database.getCollection("EduCostStat")
                .find(new Document("Year", request.getYear())
                        .append("Type", request.getType())
                        .append("Length", request.getLength()))
                .sort(Sorts.descending("Value"))
                .limit(5)
                .into(new ArrayList<>());
        
        System.out.print(states);
        
        GetTop5MostExpensiveStatesResponse.Builder responseBuilder = GetTop5MostExpensiveStatesResponse.newBuilder();

        // Process the results and add them to the response
        for (Document state : states) {
            StateExpense.Builder stateExpenseBuilder = StateExpense.newBuilder()
                .setState(state.getString("State"))
                .setExpense(state.getInteger("Value")); 

       
            responseBuilder.addStateExpenses(stateExpenseBuilder.build());
        }
        
        // Save the query information
        Document saveDoc = new Document("year", request.getYear())
            .append("type", request.getType())
            .append("length", request.getLength())
            .append("dateQueried", new Date()) 
        	.append("result", states);
        database.getCollection("EduCostStatQueryTwo").insertOne(saveDoc);

        GetTop5MostExpensiveStatesResponse response = responseBuilder.build();
        responseObserver.onNext(response);
        responseObserver.onCompleted();	 
    }  
    }
    
    //Query 3 Implementation
    public void getTop5MostEconomicalStates(GetTop5MostEconomicalStatesRequest request, StreamObserver<GetTop5MostEconomicalStatesResponse> responseObserver) {
    	try (MongoClient mongoClient = MongoClients.create(CONNECTION_STRING)) {
            MongoDatabase database = mongoClient.getDatabase(DATABASE_NAME);
            MongoCollection<Document> collection = database.getCollection(COLLECTION_NAME);

        List<Document> results = database.getCollection("EduCostStat")
                .find(new Document("Year", request.getYear())
                        .append("Type", request.getType())
                        .append("Length", request.getLength()))
                .sort(Sorts.ascending("Value"))
                .limit(5)
                .into(new ArrayList<>());
        
        System.out.print(results);
        
        GetTop5MostEconomicalStatesResponse.Builder responseBuilder = GetTop5MostEconomicalStatesResponse.newBuilder();
        
        for (Document result : results) {
            StateExpense.Builder stateExpenseBuilder = StateExpense.newBuilder()
                .setState(result.getString("State"))
                .setExpense(result.getInteger("Value")); 
       
            responseBuilder.addStateExpenses(stateExpenseBuilder.build());
        }

        Document queryDocument = new Document("year", request.getYear())
                .append("type", request.getType())
                .append("length", request.getLength())
                .append("query", "Top5MostEconomicalStates")
                .append("dateQueried", new Date())
                .append("results", results);

        database.getCollection("EduCostStatQueryThree").insertOne(queryDocument);
        
     // Build the response and send it
        GetTop5MostEconomicalStatesResponse response = responseBuilder.build();
        responseObserver.onNext(response);
        responseObserver.onCompleted();
     }
    }
   
    //Query 4 Implementation
   public void getTop5GrowthRateStates(GetTop5GrowthRateStatesRequest request, StreamObserver<GetTop5GrowthRateStatesResponse> responseObserver) {
    	    	try (MongoClient mongoClient = MongoClients.create(CONNECTION_STRING)) {
    	            MongoDatabase database = mongoClient.getDatabase(DATABASE_NAME);
    	            MongoCollection<Document> collection = database.getCollection(COLLECTION_NAME);

    	            int baseYear = request.getBaseYear();
    	            String type = request.getType();
    	            String length = request.getLength();
    	            int range = request.getRange();

    	            // Calculate start year based on range
    	            List<Integer> years = new ArrayList<>();
    	            for (int i = 0; i <= range; i++) {
    	                years.add(baseYear - i);
    	            }

    	            // Fetch documents for all years in the range
    	            List<Document> documents = collection.find(
    	                Filters.and(
    	                    Filters.in("Year", years),
    	                    Filters.eq("Type", type),
    	                    Filters.eq("Length", length)
    	                )
    	            ).into(new ArrayList<>());

    	            // Process documents to calculate growth rates
    	            Map<String, Map<Integer, Integer>> expensesByStateAndYear = new HashMap<>();
    	            documents.forEach(doc -> {
    	                String state = doc.getString("State");
    	                int year = doc.getInteger("Year");
    	                String expenseStr = doc.getString("Expense");
    	                int cost=doc.getInteger("Value");
    	                expensesByStateAndYear.computeIfAbsent(state, k -> new HashMap<>()).put(year, cost);
    	            });
    	            
    	           

    	            Map<String, Double> growthRates = new HashMap<>();
    	            expensesByStateAndYear.forEach((state, yearlyExpenses) -> {
    	                if (yearlyExpenses.containsKey(baseYear) && yearlyExpenses.containsKey(baseYear - range)) {
    	                    double latestExpense = yearlyExpenses.get(baseYear);
    	                    double earliestExpense = yearlyExpenses.get(baseYear - range);
    	                    double growthRate = (latestExpense - earliestExpense) / earliestExpense * 100; // Calculate growth rate
    	                    
    	                    growthRates.put(state, growthRate);
    	                }
    	            });
    	            
    	            

    	            // Sort by growth rate and pick top 5
    	            List<Map.Entry<String, Double>> sortedEntries = growthRates.entrySet().stream()
    	                .sorted(Map.Entry.<String, Double>comparingByValue().reversed())
    	                .limit(5)
    	                .collect(Collectors.toList());

    	            // Build response
    	            GetTop5GrowthRateStatesResponse.Builder responseBuilder = GetTop5GrowthRateStatesResponse.newBuilder();
    	            sortedEntries.forEach(entry -> {
    	                StateGrowthRate stateGrowthRate = StateGrowthRate.newBuilder()
    	                    .setState(entry.getKey())
    	                    .setGrowthRate(entry.getValue())
    	                    .build();
    	                responseBuilder.addStateGrowthRates(stateGrowthRate);
    	            });

    	            // Save query result
    	            List<Document> resultDocuments = sortedEntries.stream()
    	                .map(entry -> new Document("State", entry.getKey()).append("growthRate", entry.getValue()))
    	                .collect(Collectors.toList());

    	            Document queryResult = new Document("baseYear", baseYear)
    	                .append("Type", type)
    	                .append("Length", length)
    	                .append("Range", range)
    	                .append("results", resultDocuments);
    	            database.getCollection("EduCostStatQueryFour").insertOne(queryResult);

    	            // Complete RPC call
    	            responseObserver.onNext(responseBuilder.build());
    	            responseObserver.onCompleted();
    	        } catch (Exception e) {
    	            e.printStackTrace();
    	            responseObserver.onError(e);
    	        }
    	    }
   
   //Query 5 implementation
   public void getRegionAvgExpense(GetRegionAvgExpenseRequest request, StreamObserver<GetRegionAvgExpenseResponse> responseObserver) {
 	    	try (MongoClient mongoClient = MongoClients.create(CONNECTION_STRING)) {
 	            MongoDatabase database = mongoClient.getDatabase(DATABASE_NAME);
 	            MongoCollection<Document> collection = database.getCollection(COLLECTION_NAME);
 	           List<Document> documents = collection.find(
 	                  Filters.and(
 	                      Filters.eq("Year", request.getYear()),
 	                      Filters.eq("Type", request.getType()),
 	                      Filters.eq("Length", request.getLength())
 	                  )
 	              ).into(new ArrayList<>());

 	              // Map to keep track of expenses by region. This example simply counts documents; adjust as needed.
 	              Map<String, Integer> expenseCountByRegion = new HashMap<>();

 	              documents.forEach(doc -> {
 	                  String state = doc.getString("State"); // Adjust field name as necessary.
 	                  String region = RegionUtils.STATE_TO_REGION.get(state); // Map state to region.
 	                  int cost = doc.getInteger("Value");
 	                  if (region != null) {
 	                      expenseCountByRegion.put(region, expenseCountByRegion.getOrDefault(region, 0) + cost);
 	                  }
 	              });

 	              // Build the response based on expenseCountByRegion
 	              GetRegionAvgExpenseResponse.Builder responseBuilder = GetRegionAvgExpenseResponse.newBuilder();
 	              expenseCountByRegion.forEach((region, cost) -> {
 	                  responseBuilder.addRegionAverages(
 	                      RegionAverage.newBuilder()
 	                          .setRegion(region)
 	                          .setAverageExpense(cost) // This example uses count. Adjust according to your needs.
 	                          .build());
 	              });
 	              
 	             Document queryResult = new Document("Year", request.getYear())
     	                .append("Type", request.getType())
     	                .append("Length", request.getLength())
     	                .append("results", expenseCountByRegion);
     	            database.getCollection("EduCostStatQueryFive").insertOne(queryResult);
 	              responseObserver.onNext(responseBuilder.build());
 	              responseObserver.onCompleted();
 	              
 	              // Optionally, save the aggregated data to EduCostStatQueryFive.
 	          } catch (Exception e) {
 	              e.printStackTrace();
 	              responseObserver.onError(io.grpc.Status.INTERNAL.withDescription("Internal error").asRuntimeException());
 	          }
 	      }
}