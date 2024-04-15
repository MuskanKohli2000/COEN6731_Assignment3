package com.example.eduservice;

import com.rabbitmq.client.*;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.concurrent.TimeoutException;

public class RabbitMQConsumer {
    private static final String EXCHANGE_NAME = "topic";
    private static final String HOST = "129.153.84.219"; // RabbitMQ server host
    private static final String QUEUE_NAME = "queue"; // Queue name
    private static final String[] BINDING_KEYS = {
        "Cost-#", 
        "Top5-Expensive-#", 
        "Top5-Economic-#", 
        "Top5-HighestGrow-#", 
        "AverageExpense-#"
    }; // Routing key patterns

    public static void main(String[] args) {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost(HOST);

        try (
        	
        	 Connection connection = factory.newConnection();
             Channel channel = connection.createChannel()) 
        
        {
        	

            // Declare the exchange
            channel.exchangeDeclare(EXCHANGE_NAME, "topic", false); // Durable exchange

            // Declare a durable queue
            channel.queueDeclare(QUEUE_NAME, true, false, false, null); // Durable queue

            // Bind the queue to the exchange with all predefined binding keys
            for (String bindingKey : BINDING_KEYS) {
                channel.queueBind(QUEUE_NAME, EXCHANGE_NAME, bindingKey);
                System.out.println("Queue " + QUEUE_NAME + " bound to " + EXCHANGE_NAME + " with " + bindingKey);
            }

            System.out.println(" [*] Waiting for messages. To exit press CTRL+C");

            DeliverCallback deliverCallback = (consumerTag, delivery) -> {
                try {
                    String routingKey = delivery.getEnvelope().getRoutingKey();
                    String message = new String(delivery.getBody(), StandardCharsets.UTF_8);
                    System.out.println(" [x] Received '" + routingKey + "':'" + message + "'");
                    
                    // Process the message based on the routing key pattern
                    if (routingKey.startsWith("Cost-")) {
                        // Handle messages for 'Cost' topic
                        System.out.println("Processing Cost message...");
                    } else if (routingKey.startsWith("Top5-Expensive-")) {
                        // Handle messages for 'Top5-Expensive' topic
                        System.out.println("Processing Top5-Expensive message...");
                    } else if (routingKey.startsWith("Top5-Economic-")) {
                        // Handle messages for 'Top5-Economic' topic
                        System.out.println("Processing Top5-Economic message...");
                    }
                    // Add more conditions for other routing key patterns...
                    
                    // Simulate message processing time (remove this in production)
                    Thread.sleep(1000); // Example: 1 second processing time
                    
                    // Acknowledge message after successful processing
                    channel.basicAck(delivery.getEnvelope().getDeliveryTag(), false);
                } catch (Exception e) {
                    // Handle any exceptions (e.g., channel closure) gracefully
                    System.err.println("Error processing message: " + e.getMessage());
                    e.printStackTrace(); // Print stack trace for detailed error output
                }
            };

            // Start consuming messages from the queue
            channel.basicConsume(QUEUE_NAME, false, deliverCallback, consumerTag -> { });

            // Keep the consumer running until manually stopped
            while (true) {
                Thread.sleep(1000); // Sleep to avoid excessive CPU usage
            }

        } catch (IOException | TimeoutException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}