package ds.service2;

import java.io.IOException;

import ds.service2.CustomerServiceGrpc.CustomerServiceImplBase;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;

public class Service2 extends CustomerServiceImplBase{
	
	public static void main(String[] args) throws InterruptedException, IOException {
		Service2 csService = new Service2();
		
		int port = 50052;
		
		Server server = ServerBuilder.forPort(port).addService(csService).build().start();
		
		System.out.println("Service-2 started, listening on " + port);

		server.awaitTermination();
		
	}

	//@Override  为什么此处不能写Override，哪个正确
	public void bookRide(BookRequest request, StreamObserver<BookResponse> responseObserver) {
		
		//prepare the value to be set back
		String currentLocation = request.getCurrentLocation();
		String destination = request.getDestination();
		
		String confirmMessage = "Your booking from " + currentLocation + " to " + destination + " has been confirmed.";
		
		//preparing the response message
		BookResponse reply = BookResponse.newBuilder().setConfirmMessage(confirmMessage).build();
		
		//send the response message to the client
		responseObserver.onNext(reply);
		responseObserver.onCompleted();		
	}
	
	/*public StreamObserver<BookRequest> bookRide(StreamObserver<BookResponse> responseObserver) {
		
		return new StreamObserver<BookRequest> () {
			
			public void onNext(BookRequest request) {
				
				//prepare the value to be set back
				String message = "Book ride successfully. Current location : " + request.getCurrentLocation() + ", Destination : " + request.getDestination() + ".";
				
				//preparing the response message
				BookResponse reply = BookResponse.newBuilder().setConfirmMessage(message).build();
				
				responseObserver.onNext(reply);
			}
			
			public void onError(Throwable t) {
				
				t.printStackTrace();
				
			}
			
			public void onCompleted() {
				
				System.out.println("receiving bookride completed.");
				
				//completed too
				responseObserver.onCompleted();
			}
		};
	}*/

	@Override
	public void cancelRide(CancelRequest request, StreamObserver<CancelResponse> responseObserver) {
		
		//prepare the value to be set back
		String message = "Hello, Your ride ID is : " + request.getRideID() + ". has been cancelled successfully.";
		
		//preparing the response message
		CancelResponse reply = CancelResponse.newBuilder().setStatus(message).build();
		
		//send the response message to the client
		responseObserver.onNext(reply);
		responseObserver.onCompleted();
	}

	@Override
	public void getRideInfo(InfoRequest request, StreamObserver<InfoResponse> responseObserver) {
		
		//prepare the value to be set back
		String startingLocation = "Hello, your ride ID is : " + request.getRideID() + ". StartingLocation is : Mayor Square-NCI. ";
		String destination = "Destination is : Heuston.";
				
		//preparing the response message
		InfoResponse reply = InfoResponse.newBuilder().setStartingLocation(startingLocation).setDestination(destination).build();
		
		//send the response message to the client
		responseObserver.onNext(reply);
		responseObserver.onCompleted();
	}
		

}
