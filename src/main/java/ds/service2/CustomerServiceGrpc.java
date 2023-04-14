package ds.service2;

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
    comments = "Source: service2.proto")
public final class CustomerServiceGrpc {

  private CustomerServiceGrpc() {}

  public static final String SERVICE_NAME = "service2.CustomerService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<ds.service2.BookRequest,
      ds.service2.BookResponse> getBookRideMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "bookRide",
      requestType = ds.service2.BookRequest.class,
      responseType = ds.service2.BookResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.CLIENT_STREAMING)
  public static io.grpc.MethodDescriptor<ds.service2.BookRequest,
      ds.service2.BookResponse> getBookRideMethod() {
    io.grpc.MethodDescriptor<ds.service2.BookRequest, ds.service2.BookResponse> getBookRideMethod;
    if ((getBookRideMethod = CustomerServiceGrpc.getBookRideMethod) == null) {
      synchronized (CustomerServiceGrpc.class) {
        if ((getBookRideMethod = CustomerServiceGrpc.getBookRideMethod) == null) {
          CustomerServiceGrpc.getBookRideMethod = getBookRideMethod = 
              io.grpc.MethodDescriptor.<ds.service2.BookRequest, ds.service2.BookResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.CLIENT_STREAMING)
              .setFullMethodName(generateFullMethodName(
                  "service2.CustomerService", "bookRide"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ds.service2.BookRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ds.service2.BookResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new CustomerServiceMethodDescriptorSupplier("bookRide"))
                  .build();
          }
        }
     }
     return getBookRideMethod;
  }

  private static volatile io.grpc.MethodDescriptor<ds.service2.CancelRequest,
      ds.service2.CancelResponse> getCancelRideMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "cancelRide",
      requestType = ds.service2.CancelRequest.class,
      responseType = ds.service2.CancelResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<ds.service2.CancelRequest,
      ds.service2.CancelResponse> getCancelRideMethod() {
    io.grpc.MethodDescriptor<ds.service2.CancelRequest, ds.service2.CancelResponse> getCancelRideMethod;
    if ((getCancelRideMethod = CustomerServiceGrpc.getCancelRideMethod) == null) {
      synchronized (CustomerServiceGrpc.class) {
        if ((getCancelRideMethod = CustomerServiceGrpc.getCancelRideMethod) == null) {
          CustomerServiceGrpc.getCancelRideMethod = getCancelRideMethod = 
              io.grpc.MethodDescriptor.<ds.service2.CancelRequest, ds.service2.CancelResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "service2.CustomerService", "cancelRide"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ds.service2.CancelRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ds.service2.CancelResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new CustomerServiceMethodDescriptorSupplier("cancelRide"))
                  .build();
          }
        }
     }
     return getCancelRideMethod;
  }

  private static volatile io.grpc.MethodDescriptor<ds.service2.InfoRequest,
      ds.service2.InfoResponse> getGetRideInfoMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "getRideInfo",
      requestType = ds.service2.InfoRequest.class,
      responseType = ds.service2.InfoResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
  public static io.grpc.MethodDescriptor<ds.service2.InfoRequest,
      ds.service2.InfoResponse> getGetRideInfoMethod() {
    io.grpc.MethodDescriptor<ds.service2.InfoRequest, ds.service2.InfoResponse> getGetRideInfoMethod;
    if ((getGetRideInfoMethod = CustomerServiceGrpc.getGetRideInfoMethod) == null) {
      synchronized (CustomerServiceGrpc.class) {
        if ((getGetRideInfoMethod = CustomerServiceGrpc.getGetRideInfoMethod) == null) {
          CustomerServiceGrpc.getGetRideInfoMethod = getGetRideInfoMethod = 
              io.grpc.MethodDescriptor.<ds.service2.InfoRequest, ds.service2.InfoResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
              .setFullMethodName(generateFullMethodName(
                  "service2.CustomerService", "getRideInfo"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ds.service2.InfoRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ds.service2.InfoResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new CustomerServiceMethodDescriptorSupplier("getRideInfo"))
                  .build();
          }
        }
     }
     return getGetRideInfoMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static CustomerServiceStub newStub(io.grpc.Channel channel) {
    return new CustomerServiceStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static CustomerServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new CustomerServiceBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static CustomerServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new CustomerServiceFutureStub(channel);
  }

  /**
   * <pre>
   * Interface exported by the server.
   * Service Definition
   * </pre>
   */
  public static abstract class CustomerServiceImplBase implements io.grpc.BindableService {

    /**
     */
    public io.grpc.stub.StreamObserver<ds.service2.BookRequest> bookRide(
        io.grpc.stub.StreamObserver<ds.service2.BookResponse> responseObserver) {
      return asyncUnimplementedStreamingCall(getBookRideMethod(), responseObserver);
    }

    /**
     */
    public void cancelRide(ds.service2.CancelRequest request,
        io.grpc.stub.StreamObserver<ds.service2.CancelResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getCancelRideMethod(), responseObserver);
    }

    /**
     */
    public void getRideInfo(ds.service2.InfoRequest request,
        io.grpc.stub.StreamObserver<ds.service2.InfoResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getGetRideInfoMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getBookRideMethod(),
            asyncClientStreamingCall(
              new MethodHandlers<
                ds.service2.BookRequest,
                ds.service2.BookResponse>(
                  this, METHODID_BOOK_RIDE)))
          .addMethod(
            getCancelRideMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                ds.service2.CancelRequest,
                ds.service2.CancelResponse>(
                  this, METHODID_CANCEL_RIDE)))
          .addMethod(
            getGetRideInfoMethod(),
            asyncServerStreamingCall(
              new MethodHandlers<
                ds.service2.InfoRequest,
                ds.service2.InfoResponse>(
                  this, METHODID_GET_RIDE_INFO)))
          .build();
    }
  }

  /**
   * <pre>
   * Interface exported by the server.
   * Service Definition
   * </pre>
   */
  public static final class CustomerServiceStub extends io.grpc.stub.AbstractStub<CustomerServiceStub> {
    private CustomerServiceStub(io.grpc.Channel channel) {
      super(channel);
    }

    private CustomerServiceStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected CustomerServiceStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new CustomerServiceStub(channel, callOptions);
    }

    /**
     */
    public io.grpc.stub.StreamObserver<ds.service2.BookRequest> bookRide(
        io.grpc.stub.StreamObserver<ds.service2.BookResponse> responseObserver) {
      return asyncClientStreamingCall(
          getChannel().newCall(getBookRideMethod(), getCallOptions()), responseObserver);
    }

    /**
     */
    public void cancelRide(ds.service2.CancelRequest request,
        io.grpc.stub.StreamObserver<ds.service2.CancelResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getCancelRideMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getRideInfo(ds.service2.InfoRequest request,
        io.grpc.stub.StreamObserver<ds.service2.InfoResponse> responseObserver) {
      asyncServerStreamingCall(
          getChannel().newCall(getGetRideInfoMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * <pre>
   * Interface exported by the server.
   * Service Definition
   * </pre>
   */
  public static final class CustomerServiceBlockingStub extends io.grpc.stub.AbstractStub<CustomerServiceBlockingStub> {
    private CustomerServiceBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private CustomerServiceBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected CustomerServiceBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new CustomerServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public ds.service2.CancelResponse cancelRide(ds.service2.CancelRequest request) {
      return blockingUnaryCall(
          getChannel(), getCancelRideMethod(), getCallOptions(), request);
    }

    /**
     */
    public java.util.Iterator<ds.service2.InfoResponse> getRideInfo(
        ds.service2.InfoRequest request) {
      return blockingServerStreamingCall(
          getChannel(), getGetRideInfoMethod(), getCallOptions(), request);
    }
  }

  /**
   * <pre>
   * Interface exported by the server.
   * Service Definition
   * </pre>
   */
  public static final class CustomerServiceFutureStub extends io.grpc.stub.AbstractStub<CustomerServiceFutureStub> {
    private CustomerServiceFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private CustomerServiceFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected CustomerServiceFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new CustomerServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<ds.service2.CancelResponse> cancelRide(
        ds.service2.CancelRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getCancelRideMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_CANCEL_RIDE = 0;
  private static final int METHODID_GET_RIDE_INFO = 1;
  private static final int METHODID_BOOK_RIDE = 2;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final CustomerServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(CustomerServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_CANCEL_RIDE:
          serviceImpl.cancelRide((ds.service2.CancelRequest) request,
              (io.grpc.stub.StreamObserver<ds.service2.CancelResponse>) responseObserver);
          break;
        case METHODID_GET_RIDE_INFO:
          serviceImpl.getRideInfo((ds.service2.InfoRequest) request,
              (io.grpc.stub.StreamObserver<ds.service2.InfoResponse>) responseObserver);
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
        case METHODID_BOOK_RIDE:
          return (io.grpc.stub.StreamObserver<Req>) serviceImpl.bookRide(
              (io.grpc.stub.StreamObserver<ds.service2.BookResponse>) responseObserver);
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class CustomerServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    CustomerServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return ds.service2.Service2Impl.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("CustomerService");
    }
  }

  private static final class CustomerServiceFileDescriptorSupplier
      extends CustomerServiceBaseDescriptorSupplier {
    CustomerServiceFileDescriptorSupplier() {}
  }

  private static final class CustomerServiceMethodDescriptorSupplier
      extends CustomerServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    CustomerServiceMethodDescriptorSupplier(String methodName) {
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
      synchronized (CustomerServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new CustomerServiceFileDescriptorSupplier())
              .addMethod(getBookRideMethod())
              .addMethod(getCancelRideMethod())
              .addMethod(getGetRideInfoMethod())
              .build();
        }
      }
    }
    return result;
  }
}
