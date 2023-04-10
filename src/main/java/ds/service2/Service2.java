package ds.service2;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.InetAddress;
import java.util.Properties;

import javax.jmdns.JmDNS;
import javax.jmdns.ServiceInfo;

import ds.service2.CustomerServiceGrpc.CustomerServiceImplBase;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;

public class Service2 extends CustomerServiceImplBase{
	
	public static void main(String[] args) throws InterruptedException, IOException {
		Service2 csService = new Service2();
		
        Properties prop = csService.getProperties();
		
		csService.registerService(prop);
		
		int port = Integer.valueOf( prop.getProperty("50052") );
		
		Server server = ServerBuilder.forPort(port).addService(csService).build().start();
		
		System.out.println("Service-2 started, listening on " + port);

		server.awaitTermination();
		
	}
	
	private Properties getProperties() {
		Properties prop = null;
		
		try(InputStream input = new FileInputStream("src/main/resources/transportSystem.properties")){
			
			prop = new Properties();
			
			//load a properties file
			prop.load(input);
			
			//get the property value and print it out
			System.out.println("Service2 properies ...");
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
			
			String service_type = prop.getProperty("_http._tcp.local.");
			String service_name = prop.getProperty("Service2_customerService");
			
			int service_port = Integer.valueOf( prop.getProperty("50052"));
			
			String service_description_properties = prop.getProperty("path=index2.html");
			
			//Register a service
			ServiceInfo serviceInfo = ServiceInfo.create(service_type, service_name, service_port, service_description_properties);
			jmdns.registerService(serviceInfo);
			
			System.out.printf("registrering service with type %s and name %s \n", service_type, service_name);
			
			//wait a bit
			Thread.sleep(1000);
			
		} catch(IOException e) {
			System.out.println(e.getMessage());
		} catch(InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}    
	
	@Override
	public StreamObserver<BookRequest> bookRide(StreamObserver<BookResponse> responseObserver) {
		
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
	}  

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
