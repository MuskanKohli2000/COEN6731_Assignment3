package com.example.eduservice;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

public class EduServiceClient {
    public static void main(String[] args) {
        // Establish a connection to the server at "localhost" on port 50051
        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 50051)
                .usePlaintext()
                .build();

       
        EduServiceGrpc.EduServiceBlockingStub stub = EduServiceGrpc.newBlockingStub(channel);
        
        //Query 1
        // Prepare a request for the GetCostByParams RPC
        GetCostByParamsRequest getCostByParamsRequest = GetCostByParamsRequest.newBuilder()
                .setYear(2020)
                .setState("New York")
                .setType("Private")
                .setLength("4-year")
                .setExpense("Fees/Tuition")
                .build();

        // Make the GetCostByParams RPC call
        GetCostByParamsResponse getCostByParamsResponse = stub.getCostByParams(getCostByParamsRequest);

        // Print the response from GetCostByParams RPC
        System.out.println("GetCostByParams Response: Cost = " + getCostByParamsResponse.getCost());

        
        //Query 2
        // Prepare a request for the GetTop5MostExpensiveStates RPC
        GetTop5MostExpensiveStatesRequest getTop5MostExpensiveStatesRequest = GetTop5MostExpensiveStatesRequest.newBuilder()
                .setYear(2020)
                .setType("Private")
                .setLength("4-year")
                .build();

        // Make the GetTop5MostExpensiveStates RPC call
        GetTop5MostExpensiveStatesResponse getTop5MostExpensiveStatesResponse = stub.getTop5MostExpensiveStates(getTop5MostExpensiveStatesRequest);

        // Print the response from GetTop5MostExpensiveStates RPC
        System.out.println("GetTop5MostExpensiveStates Response:");
        getTop5MostExpensiveStatesResponse.getStateExpensesList().forEach(stateExpense -> {
            System.out.println("State: " + stateExpense.getState() + ", Expense: " + stateExpense.getExpense());
        });
        
        
        //Query 3
        // Prepare a request for the GetTop5MostExpensiveStates RPC
        GetTop5MostEconomicalStatesRequest getTop5MostEconomicalStatesRequest = GetTop5MostEconomicalStatesRequest.newBuilder()
                .setYear(2020)
                .setType("Private")
                .setLength("4-year")
                .build();

        // Make the GetTop5MostExpensiveStates RPC call
        GetTop5MostEconomicalStatesResponse getTop5MostEconomicalStatesResponse = stub.getTop5MostEconomicalStates(getTop5MostEconomicalStatesRequest);

        // Print the response from GetTop5MostExpensiveStates RPC
        System.out.println("GetTop5MostEconomicalStates Response:");
        getTop5MostEconomicalStatesResponse.getStateExpensesList().forEach(stateExpense -> {
            System.out.println("State: " + stateExpense.getState() + ", Expense: " + stateExpense.getExpense());
        });
        
        
        //Query 4
        GetTop5GrowthRateStatesRequest request = GetTop5GrowthRateStatesRequest.newBuilder()
                .setBaseYear(2021) 
                .setType("Private") 
                .setLength("4-year") 
                .setRange(5) 
                .build();

        // Call the service method and get the response
        GetTop5GrowthRateStatesResponse response = stub.getTop5GrowthRateStates(request);

        // Process the response
        System.out.println("GetTop5GrowthRateStates Response:");
        response.getStateGrowthRatesList().forEach(stateGrowthRate -> {
            System.out.println("State: " + stateGrowthRate.getState() + 
                               ", Growth Rate: " + stateGrowthRate.getGrowthRate() + "%");
        });

        
        //Query 5
        GetRegionAvgExpenseRequest Regionrequest = GetRegionAvgExpenseRequest.newBuilder()
                .setYear(2021) // Example year
                .setType("Private") // Example type
                .setLength("4-year") // Example length
                .build();

        // Make the call using the stub
        GetRegionAvgExpenseResponse Regionresponse = stub.getRegionAvgExpense(Regionrequest);

        // Process the response
        System.out.println("GetRegionAvgExpense Response:");
        Regionresponse.getRegionAveragesList().forEach(regionAvg -> {
            System.out.println(regionAvg.getRegion() + ": " + regionAvg.getAverageExpense());
        });
    
        // Shutdown the channel
        channel.shutdown();
    }

}
