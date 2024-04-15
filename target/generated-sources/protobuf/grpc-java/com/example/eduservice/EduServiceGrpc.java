package com.example.eduservice;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.42.1)",
    comments = "Source: edu_service.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class EduServiceGrpc {

  private EduServiceGrpc() {}

  public static final String SERVICE_NAME = "eduservice.EduService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.example.eduservice.GetCostByParamsRequest,
      com.example.eduservice.GetCostByParamsResponse> getGetCostByParamsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetCostByParams",
      requestType = com.example.eduservice.GetCostByParamsRequest.class,
      responseType = com.example.eduservice.GetCostByParamsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.example.eduservice.GetCostByParamsRequest,
      com.example.eduservice.GetCostByParamsResponse> getGetCostByParamsMethod() {
    io.grpc.MethodDescriptor<com.example.eduservice.GetCostByParamsRequest, com.example.eduservice.GetCostByParamsResponse> getGetCostByParamsMethod;
    if ((getGetCostByParamsMethod = EduServiceGrpc.getGetCostByParamsMethod) == null) {
      synchronized (EduServiceGrpc.class) {
        if ((getGetCostByParamsMethod = EduServiceGrpc.getGetCostByParamsMethod) == null) {
          EduServiceGrpc.getGetCostByParamsMethod = getGetCostByParamsMethod =
              io.grpc.MethodDescriptor.<com.example.eduservice.GetCostByParamsRequest, com.example.eduservice.GetCostByParamsResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetCostByParams"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.example.eduservice.GetCostByParamsRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.example.eduservice.GetCostByParamsResponse.getDefaultInstance()))
              .setSchemaDescriptor(new EduServiceMethodDescriptorSupplier("GetCostByParams"))
              .build();
        }
      }
    }
    return getGetCostByParamsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.example.eduservice.GetTop5MostExpensiveStatesRequest,
      com.example.eduservice.GetTop5MostExpensiveStatesResponse> getGetTop5MostExpensiveStatesMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetTop5MostExpensiveStates",
      requestType = com.example.eduservice.GetTop5MostExpensiveStatesRequest.class,
      responseType = com.example.eduservice.GetTop5MostExpensiveStatesResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.example.eduservice.GetTop5MostExpensiveStatesRequest,
      com.example.eduservice.GetTop5MostExpensiveStatesResponse> getGetTop5MostExpensiveStatesMethod() {
    io.grpc.MethodDescriptor<com.example.eduservice.GetTop5MostExpensiveStatesRequest, com.example.eduservice.GetTop5MostExpensiveStatesResponse> getGetTop5MostExpensiveStatesMethod;
    if ((getGetTop5MostExpensiveStatesMethod = EduServiceGrpc.getGetTop5MostExpensiveStatesMethod) == null) {
      synchronized (EduServiceGrpc.class) {
        if ((getGetTop5MostExpensiveStatesMethod = EduServiceGrpc.getGetTop5MostExpensiveStatesMethod) == null) {
          EduServiceGrpc.getGetTop5MostExpensiveStatesMethod = getGetTop5MostExpensiveStatesMethod =
              io.grpc.MethodDescriptor.<com.example.eduservice.GetTop5MostExpensiveStatesRequest, com.example.eduservice.GetTop5MostExpensiveStatesResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetTop5MostExpensiveStates"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.example.eduservice.GetTop5MostExpensiveStatesRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.example.eduservice.GetTop5MostExpensiveStatesResponse.getDefaultInstance()))
              .setSchemaDescriptor(new EduServiceMethodDescriptorSupplier("GetTop5MostExpensiveStates"))
              .build();
        }
      }
    }
    return getGetTop5MostExpensiveStatesMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.example.eduservice.GetTop5MostEconomicalStatesRequest,
      com.example.eduservice.GetTop5MostEconomicalStatesResponse> getGetTop5MostEconomicalStatesMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetTop5MostEconomicalStates",
      requestType = com.example.eduservice.GetTop5MostEconomicalStatesRequest.class,
      responseType = com.example.eduservice.GetTop5MostEconomicalStatesResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.example.eduservice.GetTop5MostEconomicalStatesRequest,
      com.example.eduservice.GetTop5MostEconomicalStatesResponse> getGetTop5MostEconomicalStatesMethod() {
    io.grpc.MethodDescriptor<com.example.eduservice.GetTop5MostEconomicalStatesRequest, com.example.eduservice.GetTop5MostEconomicalStatesResponse> getGetTop5MostEconomicalStatesMethod;
    if ((getGetTop5MostEconomicalStatesMethod = EduServiceGrpc.getGetTop5MostEconomicalStatesMethod) == null) {
      synchronized (EduServiceGrpc.class) {
        if ((getGetTop5MostEconomicalStatesMethod = EduServiceGrpc.getGetTop5MostEconomicalStatesMethod) == null) {
          EduServiceGrpc.getGetTop5MostEconomicalStatesMethod = getGetTop5MostEconomicalStatesMethod =
              io.grpc.MethodDescriptor.<com.example.eduservice.GetTop5MostEconomicalStatesRequest, com.example.eduservice.GetTop5MostEconomicalStatesResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetTop5MostEconomicalStates"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.example.eduservice.GetTop5MostEconomicalStatesRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.example.eduservice.GetTop5MostEconomicalStatesResponse.getDefaultInstance()))
              .setSchemaDescriptor(new EduServiceMethodDescriptorSupplier("GetTop5MostEconomicalStates"))
              .build();
        }
      }
    }
    return getGetTop5MostEconomicalStatesMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.example.eduservice.GetTop5GrowthRateStatesRequest,
      com.example.eduservice.GetTop5GrowthRateStatesResponse> getGetTop5GrowthRateStatesMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetTop5GrowthRateStates",
      requestType = com.example.eduservice.GetTop5GrowthRateStatesRequest.class,
      responseType = com.example.eduservice.GetTop5GrowthRateStatesResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.example.eduservice.GetTop5GrowthRateStatesRequest,
      com.example.eduservice.GetTop5GrowthRateStatesResponse> getGetTop5GrowthRateStatesMethod() {
    io.grpc.MethodDescriptor<com.example.eduservice.GetTop5GrowthRateStatesRequest, com.example.eduservice.GetTop5GrowthRateStatesResponse> getGetTop5GrowthRateStatesMethod;
    if ((getGetTop5GrowthRateStatesMethod = EduServiceGrpc.getGetTop5GrowthRateStatesMethod) == null) {
      synchronized (EduServiceGrpc.class) {
        if ((getGetTop5GrowthRateStatesMethod = EduServiceGrpc.getGetTop5GrowthRateStatesMethod) == null) {
          EduServiceGrpc.getGetTop5GrowthRateStatesMethod = getGetTop5GrowthRateStatesMethod =
              io.grpc.MethodDescriptor.<com.example.eduservice.GetTop5GrowthRateStatesRequest, com.example.eduservice.GetTop5GrowthRateStatesResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetTop5GrowthRateStates"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.example.eduservice.GetTop5GrowthRateStatesRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.example.eduservice.GetTop5GrowthRateStatesResponse.getDefaultInstance()))
              .setSchemaDescriptor(new EduServiceMethodDescriptorSupplier("GetTop5GrowthRateStates"))
              .build();
        }
      }
    }
    return getGetTop5GrowthRateStatesMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.example.eduservice.GetRegionAvgExpenseRequest,
      com.example.eduservice.GetRegionAvgExpenseResponse> getGetRegionAvgExpenseMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetRegionAvgExpense",
      requestType = com.example.eduservice.GetRegionAvgExpenseRequest.class,
      responseType = com.example.eduservice.GetRegionAvgExpenseResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.example.eduservice.GetRegionAvgExpenseRequest,
      com.example.eduservice.GetRegionAvgExpenseResponse> getGetRegionAvgExpenseMethod() {
    io.grpc.MethodDescriptor<com.example.eduservice.GetRegionAvgExpenseRequest, com.example.eduservice.GetRegionAvgExpenseResponse> getGetRegionAvgExpenseMethod;
    if ((getGetRegionAvgExpenseMethod = EduServiceGrpc.getGetRegionAvgExpenseMethod) == null) {
      synchronized (EduServiceGrpc.class) {
        if ((getGetRegionAvgExpenseMethod = EduServiceGrpc.getGetRegionAvgExpenseMethod) == null) {
          EduServiceGrpc.getGetRegionAvgExpenseMethod = getGetRegionAvgExpenseMethod =
              io.grpc.MethodDescriptor.<com.example.eduservice.GetRegionAvgExpenseRequest, com.example.eduservice.GetRegionAvgExpenseResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetRegionAvgExpense"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.example.eduservice.GetRegionAvgExpenseRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.example.eduservice.GetRegionAvgExpenseResponse.getDefaultInstance()))
              .setSchemaDescriptor(new EduServiceMethodDescriptorSupplier("GetRegionAvgExpense"))
              .build();
        }
      }
    }
    return getGetRegionAvgExpenseMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static EduServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<EduServiceStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<EduServiceStub>() {
        @java.lang.Override
        public EduServiceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new EduServiceStub(channel, callOptions);
        }
      };
    return EduServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static EduServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<EduServiceBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<EduServiceBlockingStub>() {
        @java.lang.Override
        public EduServiceBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new EduServiceBlockingStub(channel, callOptions);
        }
      };
    return EduServiceBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static EduServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<EduServiceFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<EduServiceFutureStub>() {
        @java.lang.Override
        public EduServiceFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new EduServiceFutureStub(channel, callOptions);
        }
      };
    return EduServiceFutureStub.newStub(factory, channel);
  }

  /**
   */
  public static abstract class EduServiceImplBase implements io.grpc.BindableService {

    /**
     */
    public void getCostByParams(com.example.eduservice.GetCostByParamsRequest request,
        io.grpc.stub.StreamObserver<com.example.eduservice.GetCostByParamsResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetCostByParamsMethod(), responseObserver);
    }

    /**
     */
    public void getTop5MostExpensiveStates(com.example.eduservice.GetTop5MostExpensiveStatesRequest request,
        io.grpc.stub.StreamObserver<com.example.eduservice.GetTop5MostExpensiveStatesResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetTop5MostExpensiveStatesMethod(), responseObserver);
    }

    /**
     */
    public void getTop5MostEconomicalStates(com.example.eduservice.GetTop5MostEconomicalStatesRequest request,
        io.grpc.stub.StreamObserver<com.example.eduservice.GetTop5MostEconomicalStatesResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetTop5MostEconomicalStatesMethod(), responseObserver);
    }

    /**
     */
    public void getTop5GrowthRateStates(com.example.eduservice.GetTop5GrowthRateStatesRequest request,
        io.grpc.stub.StreamObserver<com.example.eduservice.GetTop5GrowthRateStatesResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetTop5GrowthRateStatesMethod(), responseObserver);
    }

    /**
     */
    public void getRegionAvgExpense(com.example.eduservice.GetRegionAvgExpenseRequest request,
        io.grpc.stub.StreamObserver<com.example.eduservice.GetRegionAvgExpenseResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetRegionAvgExpenseMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getGetCostByParamsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.example.eduservice.GetCostByParamsRequest,
                com.example.eduservice.GetCostByParamsResponse>(
                  this, METHODID_GET_COST_BY_PARAMS)))
          .addMethod(
            getGetTop5MostExpensiveStatesMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.example.eduservice.GetTop5MostExpensiveStatesRequest,
                com.example.eduservice.GetTop5MostExpensiveStatesResponse>(
                  this, METHODID_GET_TOP5MOST_EXPENSIVE_STATES)))
          .addMethod(
            getGetTop5MostEconomicalStatesMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.example.eduservice.GetTop5MostEconomicalStatesRequest,
                com.example.eduservice.GetTop5MostEconomicalStatesResponse>(
                  this, METHODID_GET_TOP5MOST_ECONOMICAL_STATES)))
          .addMethod(
            getGetTop5GrowthRateStatesMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.example.eduservice.GetTop5GrowthRateStatesRequest,
                com.example.eduservice.GetTop5GrowthRateStatesResponse>(
                  this, METHODID_GET_TOP5GROWTH_RATE_STATES)))
          .addMethod(
            getGetRegionAvgExpenseMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.example.eduservice.GetRegionAvgExpenseRequest,
                com.example.eduservice.GetRegionAvgExpenseResponse>(
                  this, METHODID_GET_REGION_AVG_EXPENSE)))
          .build();
    }
  }

  /**
   */
  public static final class EduServiceStub extends io.grpc.stub.AbstractAsyncStub<EduServiceStub> {
    private EduServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected EduServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new EduServiceStub(channel, callOptions);
    }

    /**
     */
    public void getCostByParams(com.example.eduservice.GetCostByParamsRequest request,
        io.grpc.stub.StreamObserver<com.example.eduservice.GetCostByParamsResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetCostByParamsMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getTop5MostExpensiveStates(com.example.eduservice.GetTop5MostExpensiveStatesRequest request,
        io.grpc.stub.StreamObserver<com.example.eduservice.GetTop5MostExpensiveStatesResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetTop5MostExpensiveStatesMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getTop5MostEconomicalStates(com.example.eduservice.GetTop5MostEconomicalStatesRequest request,
        io.grpc.stub.StreamObserver<com.example.eduservice.GetTop5MostEconomicalStatesResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetTop5MostEconomicalStatesMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getTop5GrowthRateStates(com.example.eduservice.GetTop5GrowthRateStatesRequest request,
        io.grpc.stub.StreamObserver<com.example.eduservice.GetTop5GrowthRateStatesResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetTop5GrowthRateStatesMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getRegionAvgExpense(com.example.eduservice.GetRegionAvgExpenseRequest request,
        io.grpc.stub.StreamObserver<com.example.eduservice.GetRegionAvgExpenseResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetRegionAvgExpenseMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class EduServiceBlockingStub extends io.grpc.stub.AbstractBlockingStub<EduServiceBlockingStub> {
    private EduServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected EduServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new EduServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public com.example.eduservice.GetCostByParamsResponse getCostByParams(com.example.eduservice.GetCostByParamsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetCostByParamsMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.example.eduservice.GetTop5MostExpensiveStatesResponse getTop5MostExpensiveStates(com.example.eduservice.GetTop5MostExpensiveStatesRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetTop5MostExpensiveStatesMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.example.eduservice.GetTop5MostEconomicalStatesResponse getTop5MostEconomicalStates(com.example.eduservice.GetTop5MostEconomicalStatesRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetTop5MostEconomicalStatesMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.example.eduservice.GetTop5GrowthRateStatesResponse getTop5GrowthRateStates(com.example.eduservice.GetTop5GrowthRateStatesRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetTop5GrowthRateStatesMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.example.eduservice.GetRegionAvgExpenseResponse getRegionAvgExpense(com.example.eduservice.GetRegionAvgExpenseRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetRegionAvgExpenseMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class EduServiceFutureStub extends io.grpc.stub.AbstractFutureStub<EduServiceFutureStub> {
    private EduServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected EduServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new EduServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.example.eduservice.GetCostByParamsResponse> getCostByParams(
        com.example.eduservice.GetCostByParamsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetCostByParamsMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.example.eduservice.GetTop5MostExpensiveStatesResponse> getTop5MostExpensiveStates(
        com.example.eduservice.GetTop5MostExpensiveStatesRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetTop5MostExpensiveStatesMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.example.eduservice.GetTop5MostEconomicalStatesResponse> getTop5MostEconomicalStates(
        com.example.eduservice.GetTop5MostEconomicalStatesRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetTop5MostEconomicalStatesMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.example.eduservice.GetTop5GrowthRateStatesResponse> getTop5GrowthRateStates(
        com.example.eduservice.GetTop5GrowthRateStatesRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetTop5GrowthRateStatesMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.example.eduservice.GetRegionAvgExpenseResponse> getRegionAvgExpense(
        com.example.eduservice.GetRegionAvgExpenseRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetRegionAvgExpenseMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_GET_COST_BY_PARAMS = 0;
  private static final int METHODID_GET_TOP5MOST_EXPENSIVE_STATES = 1;
  private static final int METHODID_GET_TOP5MOST_ECONOMICAL_STATES = 2;
  private static final int METHODID_GET_TOP5GROWTH_RATE_STATES = 3;
  private static final int METHODID_GET_REGION_AVG_EXPENSE = 4;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final EduServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(EduServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_GET_COST_BY_PARAMS:
          serviceImpl.getCostByParams((com.example.eduservice.GetCostByParamsRequest) request,
              (io.grpc.stub.StreamObserver<com.example.eduservice.GetCostByParamsResponse>) responseObserver);
          break;
        case METHODID_GET_TOP5MOST_EXPENSIVE_STATES:
          serviceImpl.getTop5MostExpensiveStates((com.example.eduservice.GetTop5MostExpensiveStatesRequest) request,
              (io.grpc.stub.StreamObserver<com.example.eduservice.GetTop5MostExpensiveStatesResponse>) responseObserver);
          break;
        case METHODID_GET_TOP5MOST_ECONOMICAL_STATES:
          serviceImpl.getTop5MostEconomicalStates((com.example.eduservice.GetTop5MostEconomicalStatesRequest) request,
              (io.grpc.stub.StreamObserver<com.example.eduservice.GetTop5MostEconomicalStatesResponse>) responseObserver);
          break;
        case METHODID_GET_TOP5GROWTH_RATE_STATES:
          serviceImpl.getTop5GrowthRateStates((com.example.eduservice.GetTop5GrowthRateStatesRequest) request,
              (io.grpc.stub.StreamObserver<com.example.eduservice.GetTop5GrowthRateStatesResponse>) responseObserver);
          break;
        case METHODID_GET_REGION_AVG_EXPENSE:
          serviceImpl.getRegionAvgExpense((com.example.eduservice.GetRegionAvgExpenseRequest) request,
              (io.grpc.stub.StreamObserver<com.example.eduservice.GetRegionAvgExpenseResponse>) responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class EduServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    EduServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.example.eduservice.EduServiceProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("EduService");
    }
  }

  private static final class EduServiceFileDescriptorSupplier
      extends EduServiceBaseDescriptorSupplier {
    EduServiceFileDescriptorSupplier() {}
  }

  private static final class EduServiceMethodDescriptorSupplier
      extends EduServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    EduServiceMethodDescriptorSupplier(String methodName) {
      this.methodName = methodName;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.MethodDescriptor getMethodDescriptor() {
      return getServiceDescriptor().findMethodByName(methodName);
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (EduServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new EduServiceFileDescriptorSupplier())
              .addMethod(getGetCostByParamsMethod())
              .addMethod(getGetTop5MostExpensiveStatesMethod())
              .addMethod(getGetTop5MostEconomicalStatesMethod())
              .addMethod(getGetTop5GrowthRateStatesMethod())
              .addMethod(getGetRegionAvgExpenseMethod())
              .build();
        }
      }
    }
    return result;
  }
}
