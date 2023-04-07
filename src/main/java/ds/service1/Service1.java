package ds.service1;

import java.io.IOException;

import ds.service1.FleetManagementGrpc.FleetManagementImplBase;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;

public class Service1 extends FleetManagementImplBase{
	
	public static void main(String[] args) throws InterruptedException, IOException {
		Service1 fmService = new Service1();
		
		int port = 50051;
		
		Server server = ServerBuilder.forPort(port)
				        .addService(fmService)
				        .build()
				        .start();
		
		System.out.println("Service-1 started, listening on " + port);

		server.awaitTermination();
	}

	@Override
	public void addVehicle(AddRequest request, StreamObserver<AddResponse> responseObserver) {
		
		//prepare the value to be set back
		String addedVehicleID = "Hello, added vehicle ID is : x212. Capacity is : " + request.getTargetCapacity() + " seats.";
		
		//preparing the response message
		AddResponse reply = AddResponse.newBuilder().setVehicleID(addedVehicleID).build();
		
		responseObserver.onNext(reply);
		responseObserver.onCompleted();		
	}

	@Override
	public void removeVehicle(RemoveRequest request, StreamObserver<RemoveResponse> responseObserver) {
		
		//prepare the value to be set back
		String removedVehicleID = "Hello, removed vehicle ID is : x799. Capacity is : " + request.getCapacity() + " seats.";
		
		//preparing the response message
		RemoveResponse reply = RemoveResponse.newBuilder().setVehicleID(removedVehicleID).build();
		
		responseObserver.onNext(reply);
		responseObserver.onCompleted();
	}

	@Override
	public void getVehicleStatus(StatusRequest request, StreamObserver<StatusResponse> responseObserver) {
		
		//prepare the value to be set back
		String currentLocation = "Hello, vehicle ID is : " + request.getVehicleID() + ". CurrentLocation is : Mayor Square-NCI. ";
		String currentSpeed = "CurrentSpeed is : 20km/h.";
		
		//preparing the response message
		StatusResponse reply = StatusResponse.newBuilder().setCurrentLocation(currentLocation).setCurrentSpeed(currentSpeed).build();
		
		responseObserver.onNext(reply);
		responseObserver.onCompleted();
	}
	
	

}
