package ds.service1;

import static io.grpc.MethodDescriptor.generateFullMethodName;
import static io.grpc.stub.ClientCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ClientCalls.asyncClientStreamingCall;
import static io.grpc.stub.ClientCalls.asyncServerStreamingCall;
import static io.grpc.stub.ClientCalls.asyncUnaryCall;
import static io.grpc.stub.ClientCalls.blockingServerStreamingCall;
import static io.grpc.stub.ClientCalls.blockingUnaryCall;
import static io.grpc.stub.ClientCalls.futureUnaryCall;
import static io.grpc.stub.ServerCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ServerCalls.asyncClientStreamingCall;
import static io.grpc.stub.ServerCalls.asyncServerStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnaryCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall;

/**
 * <pre>
 * Interface exported by the server.
 * Service Definition
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.15.0)",
    comments = "Source: service1.proto")
public final class FleetManagementGrpc {

  private FleetManagementGrpc() {}

  public static final String SERVICE_NAME = "service1.FleetManagement";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<ds.service1.AddRequest,
      ds.service1.AddResponse> getAddVehicleMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "addVehicle",
      requestType = ds.service1.AddRequest.class,
      responseType = ds.service1.AddResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<ds.service1.AddRequest,
      ds.service1.AddResponse> getAddVehicleMethod() {
    io.grpc.MethodDescriptor<ds.service1.AddRequest, ds.service1.AddResponse> getAddVehicleMethod;
    if ((getAddVehicleMethod = FleetManagementGrpc.getAddVehicleMethod) == null) {
      synchronized (FleetManagementGrpc.class) {
        if ((getAddVehicleMethod = FleetManagementGrpc.getAddVehicleMethod) == null) {
          FleetManagementGrpc.getAddVehicleMethod = getAddVehicleMethod = 
              io.grpc.MethodDescriptor.<ds.service1.AddRequest, ds.service1.AddResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "service1.FleetManagement", "addVehicle"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ds.service1.AddRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ds.service1.AddResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new FleetManagementMethodDescriptorSupplier("addVehicle"))
                  .build();
          }
        }
     }
     return getAddVehicleMethod;
  }

  private static volatile io.grpc.MethodDescriptor<ds.service1.RemoveRequest,
      ds.service1.RemoveResponse> getRemoveVehicleMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "removeVehicle",
      requestType = ds.service1.RemoveRequest.class,
      responseType = ds.service1.RemoveResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<ds.service1.RemoveRequest,
      ds.service1.RemoveResponse> getRemoveVehicleMethod() {
    io.grpc.MethodDescriptor<ds.service1.RemoveRequest, ds.service1.RemoveResponse> getRemoveVehicleMethod;
    if ((getRemoveVehicleMethod = FleetManagementGrpc.getRemoveVehicleMethod) == null) {
      synchronized (FleetManagementGrpc.class) {
        if ((getRemoveVehicleMethod = FleetManagementGrpc.getRemoveVehicleMethod) == null) {
          FleetManagementGrpc.getRemoveVehicleMethod = getRemoveVehicleMethod = 
              io.grpc.MethodDescriptor.<ds.service1.RemoveRequest, ds.service1.RemoveResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "service1.FleetManagement", "removeVehicle"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ds.service1.RemoveRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ds.service1.RemoveResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new FleetManagementMethodDescriptorSupplier("removeVehicle"))
                  .build();
          }
        }
     }
     return getRemoveVehicleMethod;
  }

  private static volatile io.grpc.MethodDescriptor<ds.service1.StatusRequest,
      ds.service1.StatusResponse> getGetVehicleStatusMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "getVehicleStatus",
      requestType = ds.service1.StatusRequest.class,
      responseType = ds.service1.StatusResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
  public static io.grpc.MethodDescriptor<ds.service1.StatusRequest,
      ds.service1.StatusResponse> getGetVehicleStatusMethod() {
    io.grpc.MethodDescriptor<ds.service1.StatusRequest, ds.service1.StatusResponse> getGetVehicleStatusMethod;
    if ((getGetVehicleStatusMethod = FleetManagementGrpc.getGetVehicleStatusMethod) == null) {
      synchronized (FleetManagementGrpc.class) {
        if ((getGetVehicleStatusMethod = FleetManagementGrpc.getGetVehicleStatusMethod) == null) {
          FleetManagementGrpc.getGetVehicleStatusMethod = getGetVehicleStatusMethod = 
              io.grpc.MethodDescriptor.<ds.service1.StatusRequest, ds.service1.StatusResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
              .setFullMethodName(generateFullMethodName(
                  "service1.FleetManagement", "getVehicleStatus"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ds.service1.StatusRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ds.service1.StatusResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new FleetManagementMethodDescriptorSupplier("getVehicleStatus"))
                  .build();
          }
        }
     }
     return getGetVehicleStatusMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static FleetManagementStub newStub(io.grpc.Channel channel) {
    return new FleetManagementStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static FleetManagementBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new FleetManagementBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static FleetManagementFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new FleetManagementFutureStub(channel);
  }

  /**
   * <pre>
   * Interface exported by the server.
   * Service Definition
   * </pre>
   */
  public static abstract class FleetManagementImplBase implements io.grpc.BindableService {

    /**
     */
    public void addVehicle(ds.service1.AddRequest request,
        io.grpc.stub.StreamObserver<ds.service1.AddResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getAddVehicleMethod(), responseObserver);
    }

    /**
     */
    public void removeVehicle(ds.service1.RemoveRequest request,
        io.grpc.stub.StreamObserver<ds.service1.RemoveResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getRemoveVehicleMethod(), responseObserver);
    }

    /**
     */
    public void getVehicleStatus(ds.service1.StatusRequest request,
        io.grpc.stub.StreamObserver<ds.service1.StatusResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getGetVehicleStatusMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getAddVehicleMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                ds.service1.AddRequest,
                ds.service1.AddResponse>(
                  this, METHODID_ADD_VEHICLE)))
          .addMethod(
            getRemoveVehicleMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                ds.service1.RemoveRequest,
                ds.service1.RemoveResponse>(
                  this, METHODID_REMOVE_VEHICLE)))
          .addMethod(
            getGetVehicleStatusMethod(),
            asyncServerStreamingCall(
              new MethodHandlers<
                ds.service1.StatusRequest,
                ds.service1.StatusResponse>(
                  this, METHODID_GET_VEHICLE_STATUS)))
          .build();
    }
  }

  /**
   * <pre>
   * Interface exported by the server.
   * Service Definition
   * </pre>
   */
  public static final class FleetManagementStub extends io.grpc.stub.AbstractStub<FleetManagementStub> {
    private FleetManagementStub(io.grpc.Channel channel) {
      super(channel);
    }

    private FleetManagementStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected FleetManagementStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new FleetManagementStub(channel, callOptions);
    }

    /**
     */
    public void addVehicle(ds.service1.AddRequest request,
        io.grpc.stub.StreamObserver<ds.service1.AddResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getAddVehicleMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void removeVehicle(ds.service1.RemoveRequest request,
        io.grpc.stub.StreamObserver<ds.service1.RemoveResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getRemoveVehicleMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getVehicleStatus(ds.service1.StatusRequest request,
        io.grpc.stub.StreamObserver<ds.service1.StatusResponse> responseObserver) {
      asyncServerStreamingCall(
          getChannel().newCall(getGetVehicleStatusMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * <pre>
   * Interface exported by the server.
   * Service Definition
   * </pre>
   */
  public static final class FleetManagementBlockingStub extends io.grpc.stub.AbstractStub<FleetManagementBlockingStub> {
    private FleetManagementBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private FleetManagementBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected FleetManagementBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new FleetManagementBlockingStub(channel, callOptions);
    }

    /**
     */
    public ds.service1.AddResponse addVehicle(ds.service1.AddRequest request) {
      return blockingUnaryCall(
          getChannel(), getAddVehicleMethod(), getCallOptions(), request);
    }

    /**
     */
    public ds.service1.RemoveResponse removeVehicle(ds.service1.RemoveRequest request) {
      return blockingUnaryCall(
          getChannel(), getRemoveVehicleMethod(), getCallOptions(), request);
    }

    /**
     */
    public java.util.Iterator<ds.service1.StatusResponse> getVehicleStatus(
        ds.service1.StatusRequest request) {
      return blockingServerStreamingCall(
          getChannel(), getGetVehicleStatusMethod(), getCallOptions(), request);
    }
  }

  /**
   * <pre>
   * Interface exported by the server.
   * Service Definition
   * </pre>
   */
  public static final class FleetManagementFutureStub extends io.grpc.stub.AbstractStub<FleetManagementFutureStub> {
    private FleetManagementFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private FleetManagementFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected FleetManagementFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new FleetManagementFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<ds.service1.AddResponse> addVehicle(
        ds.service1.AddRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getAddVehicleMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<ds.service1.RemoveResponse> removeVehicle(
        ds.service1.RemoveRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getRemoveVehicleMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_ADD_VEHICLE = 0;
  private static final int METHODID_REMOVE_VEHICLE = 1;
  private static final int METHODID_GET_VEHICLE_STATUS = 2;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final FleetManagementImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(FleetManagementImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_ADD_VEHICLE:
          serviceImpl.addVehicle((ds.service1.AddRequest) request,
              (io.grpc.stub.StreamObserver<ds.service1.AddResponse>) responseObserver);
          break;
        case METHODID_REMOVE_VEHICLE:
          serviceImpl.removeVehicle((ds.service1.RemoveRequest) request,
              (io.grpc.stub.StreamObserver<ds.service1.RemoveResponse>) responseObserver);
          break;
        case METHODID_GET_VEHICLE_STATUS:
          serviceImpl.getVehicleStatus((ds.service1.StatusRequest) request,
              (io.grpc.stub.StreamObserver<ds.service1.StatusResponse>) responseObserver);
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

  private static abstract class FleetManagementBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    FleetManagementBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return ds.service1.Service1Impl.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("FleetManagement");
    }
  }

  private static final class FleetManagementFileDescriptorSupplier
      extends FleetManagementBaseDescriptorSupplier {
    FleetManagementFileDescriptorSupplier() {}
  }

  private static final class FleetManagementMethodDescriptorSupplier
      extends FleetManagementBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    FleetManagementMethodDescriptorSupplier(String methodName) {
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
      synchronized (FleetManagementGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new FleetManagementFileDescriptorSupplier())
              .addMethod(getAddVehicleMethod())
              .addMethod(getRemoveVehicleMethod())
              .addMethod(getGetVehicleStatusMethod())
              .build();
        }
      }
    }
    return result;
  }
}
