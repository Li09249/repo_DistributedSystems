package ds.service3;

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
    comments = "Source: service3.proto")
public final class PaymentSystemGrpc {

  private PaymentSystemGrpc() {}

  public static final String SERVICE_NAME = "service3.PaymentSystem";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<ds.service3.PaymentRequest,
      ds.service3.PaymentResponse> getProcessPaymentMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "processPayment",
      requestType = ds.service3.PaymentRequest.class,
      responseType = ds.service3.PaymentResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<ds.service3.PaymentRequest,
      ds.service3.PaymentResponse> getProcessPaymentMethod() {
    io.grpc.MethodDescriptor<ds.service3.PaymentRequest, ds.service3.PaymentResponse> getProcessPaymentMethod;
    if ((getProcessPaymentMethod = PaymentSystemGrpc.getProcessPaymentMethod) == null) {
      synchronized (PaymentSystemGrpc.class) {
        if ((getProcessPaymentMethod = PaymentSystemGrpc.getProcessPaymentMethod) == null) {
          PaymentSystemGrpc.getProcessPaymentMethod = getProcessPaymentMethod = 
              io.grpc.MethodDescriptor.<ds.service3.PaymentRequest, ds.service3.PaymentResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "service3.PaymentSystem", "processPayment"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ds.service3.PaymentRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ds.service3.PaymentResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new PaymentSystemMethodDescriptorSupplier("processPayment"))
                  .build();
          }
        }
     }
     return getProcessPaymentMethod;
  }

  private static volatile io.grpc.MethodDescriptor<ds.service3.InvoiceRequest,
      ds.service3.InvoiceResponse> getGenerateInvoiceMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "generateInvoice",
      requestType = ds.service3.InvoiceRequest.class,
      responseType = ds.service3.InvoiceResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING)
  public static io.grpc.MethodDescriptor<ds.service3.InvoiceRequest,
      ds.service3.InvoiceResponse> getGenerateInvoiceMethod() {
    io.grpc.MethodDescriptor<ds.service3.InvoiceRequest, ds.service3.InvoiceResponse> getGenerateInvoiceMethod;
    if ((getGenerateInvoiceMethod = PaymentSystemGrpc.getGenerateInvoiceMethod) == null) {
      synchronized (PaymentSystemGrpc.class) {
        if ((getGenerateInvoiceMethod = PaymentSystemGrpc.getGenerateInvoiceMethod) == null) {
          PaymentSystemGrpc.getGenerateInvoiceMethod = getGenerateInvoiceMethod = 
              io.grpc.MethodDescriptor.<ds.service3.InvoiceRequest, ds.service3.InvoiceResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING)
              .setFullMethodName(generateFullMethodName(
                  "service3.PaymentSystem", "generateInvoice"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ds.service3.InvoiceRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ds.service3.InvoiceResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new PaymentSystemMethodDescriptorSupplier("generateInvoice"))
                  .build();
          }
        }
     }
     return getGenerateInvoiceMethod;
  }

  private static volatile io.grpc.MethodDescriptor<ds.service3.RefundsRequest,
      ds.service3.RefundsResponse> getHandleRefundsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "handleRefunds",
      requestType = ds.service3.RefundsRequest.class,
      responseType = ds.service3.RefundsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING)
  public static io.grpc.MethodDescriptor<ds.service3.RefundsRequest,
      ds.service3.RefundsResponse> getHandleRefundsMethod() {
    io.grpc.MethodDescriptor<ds.service3.RefundsRequest, ds.service3.RefundsResponse> getHandleRefundsMethod;
    if ((getHandleRefundsMethod = PaymentSystemGrpc.getHandleRefundsMethod) == null) {
      synchronized (PaymentSystemGrpc.class) {
        if ((getHandleRefundsMethod = PaymentSystemGrpc.getHandleRefundsMethod) == null) {
          PaymentSystemGrpc.getHandleRefundsMethod = getHandleRefundsMethod = 
              io.grpc.MethodDescriptor.<ds.service3.RefundsRequest, ds.service3.RefundsResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING)
              .setFullMethodName(generateFullMethodName(
                  "service3.PaymentSystem", "handleRefunds"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ds.service3.RefundsRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ds.service3.RefundsResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new PaymentSystemMethodDescriptorSupplier("handleRefunds"))
                  .build();
          }
        }
     }
     return getHandleRefundsMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static PaymentSystemStub newStub(io.grpc.Channel channel) {
    return new PaymentSystemStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static PaymentSystemBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new PaymentSystemBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static PaymentSystemFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new PaymentSystemFutureStub(channel);
  }

  /**
   * <pre>
   * Interface exported by the server.
   * Service Definition
   * </pre>
   */
  public static abstract class PaymentSystemImplBase implements io.grpc.BindableService {

    /**
     */
    public void processPayment(ds.service3.PaymentRequest request,
        io.grpc.stub.StreamObserver<ds.service3.PaymentResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getProcessPaymentMethod(), responseObserver);
    }

    /**
     */
    public io.grpc.stub.StreamObserver<ds.service3.InvoiceRequest> generateInvoice(
        io.grpc.stub.StreamObserver<ds.service3.InvoiceResponse> responseObserver) {
      return asyncUnimplementedStreamingCall(getGenerateInvoiceMethod(), responseObserver);
    }

    /**
     */
    public io.grpc.stub.StreamObserver<ds.service3.RefundsRequest> handleRefunds(
        io.grpc.stub.StreamObserver<ds.service3.RefundsResponse> responseObserver) {
      return asyncUnimplementedStreamingCall(getHandleRefundsMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getProcessPaymentMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                ds.service3.PaymentRequest,
                ds.service3.PaymentResponse>(
                  this, METHODID_PROCESS_PAYMENT)))
          .addMethod(
            getGenerateInvoiceMethod(),
            asyncBidiStreamingCall(
              new MethodHandlers<
                ds.service3.InvoiceRequest,
                ds.service3.InvoiceResponse>(
                  this, METHODID_GENERATE_INVOICE)))
          .addMethod(
            getHandleRefundsMethod(),
            asyncBidiStreamingCall(
              new MethodHandlers<
                ds.service3.RefundsRequest,
                ds.service3.RefundsResponse>(
                  this, METHODID_HANDLE_REFUNDS)))
          .build();
    }
  }

  /**
   * <pre>
   * Interface exported by the server.
   * Service Definition
   * </pre>
   */
  public static final class PaymentSystemStub extends io.grpc.stub.AbstractStub<PaymentSystemStub> {
    private PaymentSystemStub(io.grpc.Channel channel) {
      super(channel);
    }

    private PaymentSystemStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected PaymentSystemStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new PaymentSystemStub(channel, callOptions);
    }

    /**
     */
    public void processPayment(ds.service3.PaymentRequest request,
        io.grpc.stub.StreamObserver<ds.service3.PaymentResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getProcessPaymentMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public io.grpc.stub.StreamObserver<ds.service3.InvoiceRequest> generateInvoice(
        io.grpc.stub.StreamObserver<ds.service3.InvoiceResponse> responseObserver) {
      return asyncBidiStreamingCall(
          getChannel().newCall(getGenerateInvoiceMethod(), getCallOptions()), responseObserver);
    }

    /**
     */
    public io.grpc.stub.StreamObserver<ds.service3.RefundsRequest> handleRefunds(
        io.grpc.stub.StreamObserver<ds.service3.RefundsResponse> responseObserver) {
      return asyncBidiStreamingCall(
          getChannel().newCall(getHandleRefundsMethod(), getCallOptions()), responseObserver);
    }
  }

  /**
   * <pre>
   * Interface exported by the server.
   * Service Definition
   * </pre>
   */
  public static final class PaymentSystemBlockingStub extends io.grpc.stub.AbstractStub<PaymentSystemBlockingStub> {
    private PaymentSystemBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private PaymentSystemBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected PaymentSystemBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new PaymentSystemBlockingStub(channel, callOptions);
    }

    /**
     */
    public ds.service3.PaymentResponse processPayment(ds.service3.PaymentRequest request) {
      return blockingUnaryCall(
          getChannel(), getProcessPaymentMethod(), getCallOptions(), request);
    }
  }

  /**
   * <pre>
   * Interface exported by the server.
   * Service Definition
   * </pre>
   */
  public static final class PaymentSystemFutureStub extends io.grpc.stub.AbstractStub<PaymentSystemFutureStub> {
    private PaymentSystemFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private PaymentSystemFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected PaymentSystemFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new PaymentSystemFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<ds.service3.PaymentResponse> processPayment(
        ds.service3.PaymentRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getProcessPaymentMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_PROCESS_PAYMENT = 0;
  private static final int METHODID_GENERATE_INVOICE = 1;
  private static final int METHODID_HANDLE_REFUNDS = 2;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final PaymentSystemImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(PaymentSystemImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_PROCESS_PAYMENT:
          serviceImpl.processPayment((ds.service3.PaymentRequest) request,
              (io.grpc.stub.StreamObserver<ds.service3.PaymentResponse>) responseObserver);
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
        case METHODID_GENERATE_INVOICE:
          return (io.grpc.stub.StreamObserver<Req>) serviceImpl.generateInvoice(
              (io.grpc.stub.StreamObserver<ds.service3.InvoiceResponse>) responseObserver);
        case METHODID_HANDLE_REFUNDS:
          return (io.grpc.stub.StreamObserver<Req>) serviceImpl.handleRefunds(
              (io.grpc.stub.StreamObserver<ds.service3.RefundsResponse>) responseObserver);
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class PaymentSystemBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    PaymentSystemBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return ds.service3.Service3Impl.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("PaymentSystem");
    }
  }

  private static final class PaymentSystemFileDescriptorSupplier
      extends PaymentSystemBaseDescriptorSupplier {
    PaymentSystemFileDescriptorSupplier() {}
  }

  private static final class PaymentSystemMethodDescriptorSupplier
      extends PaymentSystemBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    PaymentSystemMethodDescriptorSupplier(String methodName) {
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
      synchronized (PaymentSystemGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new PaymentSystemFileDescriptorSupplier())
              .addMethod(getProcessPaymentMethod())
              .addMethod(getGenerateInvoiceMethod())
              .addMethod(getHandleRefundsMethod())
              .build();
        }
      }
    }
    return result;
  }
}
