package ds.service3;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.InetAddress;
import java.util.Properties;

import javax.jmdns.JmDNS;
import javax.jmdns.ServiceInfo;

import ds.service3.PaymentSystemGrpc.PaymentSystemImplBase;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;

public class Service3 extends PaymentSystemImplBase{
	
	public static void main(String[] args) throws InterruptedException, IOException{
		Service3 psService = new Service3();
		
        Properties prop = psService.getProperties();
		
		psService.registerService(prop);
		
		int port = Integer.valueOf( prop.getProperty("50053") );
		
		Server server = ServerBuilder.forPort(port).addService(psService).build().start();
		
		System.out.println("Service-3 started, listening on " + port);

		server.awaitTermination();
	}
	
	private Properties getProperties() {
		Properties prop = null;
		
		try(InputStream input = new FileInputStream("src/main/resources/transportSystem.properties")){
			
			prop = new Properties();
			
			//load a properties file
			prop.load(input);
			
			//get the property value and print it out
			System.out.println("Service3 properies ...");
            System.out.println("\t service_type: " + prop.getProperty("_http._tcp.local."));
            System.out.println("\t service_name: " +prop.getProperty("Service3_PaymentSystem"));
            System.out.println("\t service_description: " +prop.getProperty("path=index3.html"));
	        System.out.println("\t service_port: " +prop.getProperty("50053"));
	        
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
			String service_name = prop.getProperty("Service3_PaymentSystem");
			
			int service_port = Integer.valueOf( prop.getProperty("50053"));
			
			String service_description_properties = prop.getProperty("path=index3.html");
			
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
				System.out.println("Receiving generateInvoice completed.");
				
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
				System.out.println("Receiving handleRefunds completed.");
				
				//completed too
				responseObserver.onCompleted();
			}
		};
	}	

}
