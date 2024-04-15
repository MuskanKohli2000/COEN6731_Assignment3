package com.example.eduservice;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeoutException;

import org.bson.Document;

import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Sorts;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

public class RabbitMQProducer {
	
	private final static String EXCHANGE_NAME = "topic";
	private final static String QUEUE_NAME = "queue";

	public static void main(String[] args) throws IOException, TimeoutException, InterruptedException {
		
		// ***** SETTING CONNECTION FOR RABBITMQ ***** 
				ConnectionFactory factory = new ConnectionFactory();
				
				// setting up IP address for the rabbimq server.. It is hosted in oracle cloud instance
				factory.setHost("129.153.84.219");
				try(Connection connection = factory.newConnection();
						Channel channel = connection.createChannel()){
					
					
					//creating exchange interface to handle topics, here the data transferring method is "topic"
					channel.exchangeDeclare(EXCHANGE_NAME, "topic");
					
					channel.queueDeclare(QUEUE_NAME, true, false, false, null);
			        channel.queueBind(QUEUE_NAME, EXCHANGE_NAME, "#");
					
					// *** CREATING MONGODB CLIENT ***
					// establishing connection to my mongodb instance
					ConnectionString connectionString = new ConnectionString("mongodb+srv://muskankohli2000:AssignmentDss@cluster0.kkyabjq.mongodb.net/?retryWrites=true&w=majority&appName=Cluster0");
					MongoClientSettings settings = MongoClientSettings.builder()
					        .applyConnectionString(connectionString)
					        .build();
					MongoClient mongoClient = MongoClients.create(settings);
					
					// Access the MongoDB database
					MongoDatabase database = mongoClient.getDatabase("education");
					Thread.sleep(1000);
					
					// FOR TOPIC ONE **************************************************************************************
					//Access MongoDB collection
					MongoCollection<Document> collection_one = database.getCollection("EduCostStatQueryOne");
					
					//Retrieve documents from the MongoDB collection
					Document query_one = new Document("State", "New York");
					MongoCursor<Document> cursor_one = collection_one.find(query_one).iterator();
					
					while(cursor_one.hasNext())
					{
					
						Document doc = cursor_one.next();
						String routingKey = createRoutingKey_one(doc);
						String message = getMessage_one(doc);
						
						//Publish the message to exchange
						channel.basicPublish(EXCHANGE_NAME,routingKey, null, message.getBytes("UTF-8"));
						System.out.println("[x] Sent '"+routingKey+"':'"+message+"'");
						
					}
					
					// *****************************************************************************************************
					
					
					//FOR TOPIC TWO **************************************************************************************
					//Access MongoDB Collection
					MongoCollection<Document> collection_two = database.getCollection("EduCostStatQueryTwo");
					
					Document query_two = new Document("year", 2020);
					MongoCursor<Document> cursor_two = collection_two.find(query_two).iterator();
					
			
					
					while(cursor_two.hasNext())
					{
						
						Document doc = cursor_two.next();
						
						String routingKey = createRoutingKey_two(doc);
						String message = getMessage_two(doc);
						
						//Publish the message to the exchange
						channel.basicPublish(EXCHANGE_NAME,routingKey, null, message.getBytes("UTF-8"));
						System.out.println("[x] Sent "+routingKey+"':'"+message+"");
						
					}
					
					// *****************************************************************************************************
					
					//FOR TOPIC THREE **************************************************************************************
					//Access MongoDB Collection
					MongoCollection<Document> collection_three = database.getCollection("EduCostStatQueryThree");
					
					//Retrieve documents from the the MongoDB collection
					Document query_three = new Document("year", 2020);
					MongoCursor<Document> cursor_three = collection_three.find(query_three).iterator();
					
					
					while(cursor_three.hasNext())
					{
						Document doc = cursor_three.next();
						String routingKey = createRoutingKey_three(doc);
						String message = getMessage_three(doc);
						
						//Publish the message to the exchange
						channel.basicPublish(EXCHANGE_NAME,routingKey, null, message.getBytes("UTF-8"));
						System.out.println("[x] Sent '"+routingKey+"':"+message+"");
						
					}
					
					// *****************************************************************************************************
					
					//FOR TOPIC FOUR **************************************************************************************
					//Access MongoDB Collection
					MongoCollection<Document> collection_four = database.getCollection("EduCostStatQueryFour");
					
					//Retrieve documents from the the MongoDB collection
					Document query_four = new Document("baseYear", 2021);
					MongoCursor<Document> cursor_four = collection_four.find(query_four).iterator();
					
					
					while(cursor_four.hasNext())
					{
						Document doc = cursor_four.next();
						String routingKey = createRoutingKey_four(doc);
						String message = getMessage_four(doc);
						
						//Publish the message to the exchange
						channel.basicPublish(EXCHANGE_NAME,routingKey, null, message.getBytes("UTF-8"));
						System.out.println("[x] Sent '"+routingKey+"':"+message+"");
						
					}
					
					// *****************************************************************************************************
					
					//FOR TOPIC FOUR **************************************************************************************
					//Access MongoDB Collection
					MongoCollection<Document> collection_five = database.getCollection("EduCostStatQueryFive");
					
					Document query_five = new Document("Year", 2021);
					MongoCursor<Document> cursor_five = collection_five.find(query_five).iterator();
					
					while(cursor_five.hasNext()) 
					{
						Document doc = cursor_five.next();
						String routingKey = createRoutingKey_five(doc);
						String message = getMessage_five(doc);
						
						//Publish the message to the exchange
						channel.basicPublish(EXCHANGE_NAME,routingKey, null, message.getBytes("UTF-8"));
						System.out.println("[x] Sent '"+routingKey+"':"+message+"");
					}
					
				}	
			}
	
	private static String createRoutingKey_one(Document doc)
	{
		//Extracting the required fields from the document
		int Year = doc.getInteger("Year");
		String State = doc.getString("State");
		String Type = doc.getString("Type");
		String Length = doc.getString("Length");
		
		//create routing key using the required fields
		String routingKey = "Cost-"+Year+"-"+State+"-"+Type+"-"+Length;
		
		return routingKey;
	}
	
	private static String getMessage_one(Document doc)
	{
		//Extracting the required result value from the document
		double Value = doc.getDouble("cost");
		String Expense = doc.getString("Expense");
		
		String message = "Result-> Value: " +Double.toString(Value) +" Expense type : "+Expense;
		
		return message;
	}
	
	private static String createRoutingKey_two(Document doc) {
	    int year = doc.getInteger("year");
	    String type = doc.getString("type");
	    String length = doc.getString("length");
	    // Assuming type, length, and year are defined at the top level of each document
	    return "Top5-Expensive-" + year + "-" + type + "-" + length;
	}
	
	private static String getMessage_two(Document doc) {
	    List<Document> results = doc.getList("result", Document.class);
	    StringBuilder messageBuilder = new StringBuilder();

	    for (Document result : results) {
	        String state = result.getString("State");
	        String expense = result.getString("Expense");
	        Integer value = result.getInteger("Value");
	    

	        messageBuilder.append(String.format("State: %s, Expense: %s, Value: %d%n", state, expense, value));
	    }
	    return messageBuilder.toString();
	}
	
	private static String createRoutingKey_three(Document doc)
	{
		//Extracting the required fields from the document
		int Year = doc.getInteger("year");
		String Type = doc.getString("type");
		String Length = doc.getString("length");
		//create routing key using the required fields
		String routingKey = "Top5-Economic-"+Year+"-"+Type+"-"+Length;
		
		return routingKey;
		
	}
	
	private static String getMessage_three(Document doc)
	{
		List<Document> results = doc.getList("results", Document.class);
	    StringBuilder messageBuilder = new StringBuilder();

	    for (Document result : results) {
	        String state = result.getString("State");
	        String expense = result.getString("Expense");
	        Integer value = result.getInteger("Value");
	    

	        messageBuilder.append(String.format("State: %s, Expense: %s, Value: %d%n", state, expense, value));
	    }
	    return messageBuilder.toString();

	}
	
	
	private static String createRoutingKey_four(Document doc)
	{
		//Extracting the required fields from the document
				int Year = doc.getInteger("baseYear");
				String Type = doc.getString("Type");
				String Length = doc.getString("Length");
				int Range = doc.getInteger("Range");
				//create routing key using the required fields
				String routingKey = "Top5-GrowthRates-"+Year+"-"+Type+"-"+Length+"-"+Range;
				
				return routingKey;
	}
	
	private static String getMessage_four(Document doc)
	{
		List<Document> results = doc.getList("results", Document.class);
	    StringBuilder messageBuilder = new StringBuilder();

	    for (Document result : results) {
	        String state = result.getString("State");
	        Double value = result.getDouble("growthRate");
	    

	        messageBuilder.append(String.format("State: %s,  Growth Rate: %.2f%n", state, value));
	    }
	    return messageBuilder.toString();

	}
	
	private static String createRoutingKey_five(Document doc)
	{
		//Extracting the required fields from the document
		
		int Year = doc.getInteger("Year");
		String Type = doc.getString("Type");
		String Length = doc.getString("Length");
		//create routing key using the required fields
		String routingKey = "AverageExpense-"+Year+"-"+Type+"-"+Length;
		
		return routingKey;
		
	}
	
	private static String getMessage_five(Document doc)
	{
		Document results = doc.get("results", Document.class);
	    StringBuilder messageBuilder = new StringBuilder();

	    
	    results.forEach((key, value) -> {
	        // Append each region and its corresponding value
	        messageBuilder.append(String.format("%s: %s, ", key, value.toString()));
	    });
	    
	    if (results.size() > 0) {
	    	messageBuilder.setLength(messageBuilder.length() - 2);
	    }

	        
	    return messageBuilder.toString();

	}


}