package ds.service3;

import java.io.IOException;

import ds.service3.PaymentSystemGrpc.PaymentSystemImplBase;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;

public class Service3 extends PaymentSystemImplBase{
	
	public static void main(String[] args) throws InterruptedException, IOException{
		Service3 psService = new Service3();
		
		int port = 50053;
		
		Server server = ServerBuilder.forPort(port).addService(psService).build().start();
		
		System.out.println("Service-3 started, listening on " + port);

		server.awaitTermination();
	}

	@Override
	public void processPayment(PaymentRequest request, StreamObserver<PaymentResponse> responseObserver) {
		
		//prepare the value be set back
		String confirmMessage = "Payment successful. Paid a total of " + request.getPayment();
		
		//preparing the response message
		PaymentResponse reply = PaymentResponse.newBuilder().setConfirmMessage(confirmMessage).build();
		
		//send the response message to the client
		responseObserver.onNext(reply);
		responseObserver.onCompleted();
	}

	@Override
	public StreamObserver<InvoiceRequest> generateInvoice(StreamObserver<InvoiceResponse> responseObserver) {
		
		return new StreamObserver<InvoiceRequest> (){
			
			@Override
			public void onNext(InvoiceRequest request) {
				
				//prepare the value be set back
				String invoiceID = "Hello, " + request.getCustomerName() + ". Your invoice ID is : x21227993.";
				String confirmMessage = "Amount is : " + request.getAmount() + "Invoice generated successfully!";
				
				//preparing the response message
				InvoiceResponse reply = InvoiceResponse.newBuilder().setInvoiceID(confirmMessage).setConfirmMessage(invoiceID).build();
				
				responseObserver.onNext(reply);
			}
			
			@Override
			public void onError(Throwable t) {
				
				t.printStackTrace();
				
			}

			@Override
			public void onCompleted() {
				System.out.println("receiving generateInvoice completed.");
				
				//completed too
				responseObserver.onCompleted();
			}		
		};
	}

	@Override
	public StreamObserver<RefundsRequest> handleRefunds(StreamObserver<RefundsResponse> responseObserver) {
		
		return new StreamObserver<RefundsRequest> () {
			
			@Override
			public void onNext(RefundsRequest request) {
				
				//prepare the value be set back			
				String confirmMessage = "Hello, " + request.getCustomerName() + ". Your ride ID x666, amount is " + request.getAmount() + ", has been refunded successfully.";
				String refundID = "Refund ID is : x888.";
				
				//preparing the response message
				RefundsResponse reply = RefundsResponse.newBuilder().setConfirmMessage(confirmMessage).setRefundID(refundID).build();
				
				responseObserver.onNext(reply);
			}
			
			@Override
			public void onError(Throwable t) {
				
				t.printStackTrace();
				
			}
			
			@Override
			public void onCompleted() {
				System.out.println("receiving handleRefunds completed.");
				
				//completed too
				responseObserver.onCompleted();
			}
		};
	}	

}
