package ds.service1;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.InetAddress;
import java.util.Properties;
import java.util.Random;

import javax.jmdns.JmDNS;
import javax.jmdns.ServiceInfo;

import ds.service1.FleetManagementGrpc.FleetManagementImplBase;
import io.grpc.Context;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.Metadata;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.Status;
import io.grpc.stub.MetadataUtils;
import io.grpc.stub.StreamObserver;

public class Service1 extends FleetManagementImplBase{
	
	public static void main(String[] args){
		Service1 service1 = new Service1();
		
		Properties prop = service1.getProperties();
		
		service1.registerService(prop);
		
		int port = Integer.valueOf( prop.getProperty("service_port") );
		//int port = 50051;
			
		try {
			Server server = ServerBuilder.forPort(port)				
				    .addService(service1)
				    .build()
				    .start();

			System.out.println("Service-1 started, listening on " + port);

			server.awaitTermination();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private Properties getProperties() {
		Properties prop = null;
		
		try(InputStream input = new FileInputStream("src/main/resources/service1.properties")){
			
			prop = new Properties();
			
			//load a properties file
			prop.load(input);
			
			//get the property value and print it out
			System.out.println("Service1 properies ...");
            System.out.println("\t service_type: " + prop.getProperty("service_type"));
            System.out.println("\t service_name: " +prop.getProperty("service_name"));
            System.out.println("\t service_description: " +prop.getProperty("service_description"));
	        System.out.println("\t service_port: " +prop.getProperty("service_port"));
	        
		} catch(IOException ex) {
			ex.printStackTrace();
		}
		return prop;
	}
	
	private void registerService(Properties prop) {
		
		try {
			//create a JmDNS instance
			JmDNS jmdns = JmDNS.create(InetAddress.getLocalHost());
			
			String service_type = prop.getProperty("service_type");
			String service_name = prop.getProperty("service_name");
			
			int service_port = Integer.valueOf( prop.getProperty("service_port"));
			
			String service_description_properties = prop.getProperty("service_description");
			
			//Register a service
			ServiceInfo serviceInfo = ServiceInfo.create(service_type, service_name, service_port, service_description_properties);
			jmdns.registerService(serviceInfo);
			
			System.out.printf("registrering service with type %s and name %s \n", service_type, service_name);
			
			//wait a bit
			Thread.sleep(500);			
			
		} catch(IOException e) {
			System.out.println(e.getMessage());
		} catch(InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void addVehicle(AddRequest request, StreamObserver<AddResponse> responseObserver) {
		
		// Retrieve the current context of the current gRPC call.
		Context context = Context.current();
		
		// Create a gRPC channel to connect to the server.
	    ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 50051)
	            .usePlaintext()
	            .build();
				
		try {
			//Checks if the context has been cancelled.
			if (context.isCancelled()) {
				System.out.println("Request cancelled by client");
				responseObserver.onError(Status.CANCELLED.withDescription("Cancelled by client").asRuntimeException());
				return;
			}
			//prepare the value to be set back
			String vehicleID = "Hello, added vehicle ID is : x212. Capacity is : " + request.getTargetCapacity()
					+ " seats.";
			//preparing the response message
			AddResponse reply = AddResponse.newBuilder().setVehicleID(vehicleID).build();
			
			// Convert the blocking stub to AbstractStub.
			FleetManagementGrpc.FleetManagementBlockingStub blockingStub = FleetManagementGrpc.newBlockingStub(channel);

			// Set the Authorization header with the value "Bearer <token>"
			Metadata metadata = new Metadata();
			metadata.put(
			        Metadata.Key.of("Authorization", Metadata.ASCII_STRING_MARSHALLER),
			        "Bearer <token>"
			);
			// attach the metadata to the stub
			blockingStub = MetadataUtils.attachHeaders(blockingStub, metadata);
	        			
			responseObserver.onNext(reply);
			responseObserver.onCompleted();
		} catch (Exception e) {
			// TODO: handle exception
			responseObserver.onError(Status.INTERNAL.withDescription("Internal error").withCause(e).asRuntimeException());
		}		
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
		Random rand = new Random();
		for(int i = 0; i < 2; i++) {
			int random_value1 = rand.nextInt(31) + 30;

			String currentSpeed = Integer.toString(random_value1);
			
			int random_value2 = rand.nextInt(1001) + 2000;

			String currentLocation = Integer.toString(random_value2);
			
			//preparing the response message
			StatusResponse reply = StatusResponse.newBuilder().setCurrentLocation(currentLocation).setCurrentSpeed(currentSpeed).build();
			
			responseObserver.onNext(reply);
			
			try {
				//wait for a second
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
				
		responseObserver.onCompleted();
	}
	
}
