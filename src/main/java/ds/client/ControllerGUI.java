package ds.client;

import java.awt.Dimension;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import ds.service1.FleetManagementGrpc;
import ds.service1.FleetManagementGrpc.FleetManagementBlockingStub;
import ds.service1.FleetManagementGrpc.FleetManagementStub;
import ds.service1.StatusRequest;
import ds.service1.StatusResponse;
import ds.service2.BookRequest;
import ds.service2.BookResponse;
import ds.service2.CustomerServiceGrpc;
import ds.service2.InfoResponse;
import ds.service3.PaymentSystemGrpc;
import ds.service3.RefundsRequest;
import ds.service3.RefundsResponse;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.stub.StreamObserver;

public class ControllerGUI implements ActionListener {
	
	private JTextField entry1, reply1;
	private JTextField entry2, reply2;
	private JTextField entry3, reply3;
	private static FleetManagementBlockingStub blockingStub;
	private static FleetManagementStub asyncStub;

	private JPanel getService1JPanel() {

		JPanel panel = new JPanel();

		BoxLayout boxlayout = new BoxLayout(panel, BoxLayout.X_AXIS);

		JLabel label = new JLabel("Enter value")	;
		panel.add(label);
		panel.add(Box.createRigidArea(new Dimension(10, 0)));
		entry1 = new JTextField("",10);
		panel.add(entry1);
		panel.add(Box.createRigidArea(new Dimension(10, 0)));

		JButton button = new JButton("Invoke Service 1");
		button.addActionListener(this);
		panel.add(button);
		panel.add(Box.createRigidArea(new Dimension(10, 0)));

		reply1 = new JTextField("", 10);
		reply1 .setEditable(false);
		panel.add(reply1 );

		panel.setLayout(boxlayout);

		return panel;

	}
	
	private JPanel getService2JPanel() {

		JPanel panel = new JPanel();

		BoxLayout boxlayout = new BoxLayout(panel, BoxLayout.X_AXIS);

		JLabel label = new JLabel("Enter value")	;
		panel.add(label);
		panel.add(Box.createRigidArea(new Dimension(10, 0)));
		entry2 = new JTextField("",10);
		panel.add(entry2);
		panel.add(Box.createRigidArea(new Dimension(10, 0)));

		JButton button = new JButton("Invoke Service 2");
		button.addActionListener(this);
		panel.add(button);
		panel.add(Box.createRigidArea(new Dimension(10, 0)));

		reply2 = new JTextField("", 10);
		reply2 .setEditable(false);
		panel.add(reply2 );

		panel.setLayout(boxlayout);

		return panel;

	}
	
	private JPanel getService3JPanel() {

		JPanel panel = new JPanel();

		BoxLayout boxlayout = new BoxLayout(panel, BoxLayout.X_AXIS);

		JLabel label = new JLabel("Enter value")	;
		panel.add(label);
		panel.add(Box.createRigidArea(new Dimension(10, 0)));
		entry3 = new JTextField("",10);
		panel.add(entry3);
		panel.add(Box.createRigidArea(new Dimension(10, 0)));

		JButton button = new JButton("Invoke Service 3");
		button.addActionListener(this);
		panel.add(button);
		panel.add(Box.createRigidArea(new Dimension(10, 0)));

		reply3 = new JTextField("", 10);
		reply3 .setEditable(false);
		panel.add(reply3 );

		panel.setLayout(boxlayout);

		return panel;

	}
	
	public static void main(String[] args) {

		ControllerGUI gui = new ControllerGUI();

		gui.build();
	}
	
	private void build() { 

		JFrame frame = new JFrame("Service Controller Sample");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// Set the panel to add buttons
		JPanel panel = new JPanel();

		// Set the BoxLayout to be X_AXIS: from left to right
		BoxLayout boxlayout = new BoxLayout(panel, BoxLayout.Y_AXIS);

		panel.setLayout(boxlayout);

		// Set border for the panel
		panel.setBorder(new EmptyBorder(new Insets(50, 100, 50, 100)));
	
		panel.add( getService1JPanel() );
		panel.add( getService2JPanel() );
		panel.add( getService3JPanel() );

		// Set size for the frame
		frame.setSize(300, 300);

		// Set the window to be visible as the default to be false
		frame.add(panel);
		frame.pack();
		frame.setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		JButton button = (JButton)e.getSource();
		String label = button.getActionCommand();  

		if (label.equals("Invoke Service 1")) {
			System.out.println("service 1 to be invoked ...");

		
			/*
			 * 
			 */
			ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 50051).usePlaintext().build();
			FleetManagementGrpc.FleetManagementBlockingStub blockingStub = FleetManagementGrpc.newBlockingStub(channel);

			//preparing message to send
			ds.service1.AddRequest request1 = ds.service1.AddRequest.newBuilder().setTargetCapacity(entry1.getText()).build();

			//retrieving reply from service
			ds.service1.AddResponse response1 = blockingStub.addVehicle(request1);
			
			//displaying the response to the user
			reply1.setText(response1.getVehicleID());
			
			//preparing message to send
			ds.service1.RemoveRequest request2 = ds.service1.RemoveRequest.newBuilder().setCapacity(entry1.getText()).build();
			
			//retrieving reply from service			
			ds.service1.RemoveResponse response2 = blockingStub.removeVehicle(request2);
			
			//displaying the response to the user
			reply1.setText(response2.getVehicleID());
						
			//getVehicleStatus method
			ds.service1.StatusRequest request3 = ds.service1.StatusRequest.newBuilder().setVehicleID(entry1.getText()).build();
			StreamObserver<StatusResponse> responseObserver = new StreamObserver<StatusResponse>(){
				@Override
				public void onNext(StatusResponse response3) {
					reply1.setText(response3.getCurrentLocation() + response3.getCurrentSpeed());
				}
				
				@Override
				public void onError(Throwable t) {
					t.printStackTrace();
				}
				
				@Override
				public void onCompleted() {
					System.out.println("Stream is completed.");
				}
			};
			
			asyncStub.getVehicleStatus(request3, responseObserver);
			
			
			/* 是否需要responseObserver.onCompleted();------------------------	
			/*ds.service1.StatusRequest request3 = ds.service1.StatusRequest.newBuilder().setVehicleID(entry1.getText()).build();

			//retrieving reply from service
			ds.service1.StatusResponse response3 = blockingStub.getVehicleStatus(request3);

			//displaying the response to the user	
			reply1.setText(response3.getCurrentLocation() + response3.getCurrentSpeed());*/
		
		}else if (label.equals("Invoke Service 2")) {
			System.out.println("service 2 to be invoked ...");

		
			/*
			 * 
			 */
			ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 50052).usePlaintext().build();
			CustomerServiceGrpc.CustomerServiceBlockingStub blockingStub = CustomerServiceGrpc.newBlockingStub(channel);

            //bookRide method
			ds.service2.BookRequest request1 = ds.service2.BookRequest.newBuilder().setCurrentLocation(entry2.getText()).setDestination(entry2.getText()).build();				
		    StreamObserver<BookResponse> responseObserver = new StreamObserver<BookResponse>() {
		    	@Override
				public void onNext(BookResponse response1) {   
					reply2.setText(response1.getConfirmMessage());
				}
				
				@Override
				public void onError(Throwable t) {
					t.printStackTrace();
				}
				
				@Override
				public void onCompleted() {
					System.out.println("Stream is completed.");
				}
		    };
		    asyncStub.bookRide(request1, responseObserver);
		  //什么问题----------------------检查一下这个方法是否正确
		    
			try {
				Thread.sleep(15000);
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			//cancelRide method
			ds.service2.CancelRequest request2 = ds.service2.CancelRequest.newBuilder().setRideID(entry2.getText()).build();
								
			ds.service2.CancelResponse response2 = blockingStub.cancelRide(request2);
			
			reply2.setText(response2.getStatus());
			
			//getRideInfo method
			ds.service2.InfoRequest request3 = ds.service2.InfoRequest.newBuilder().setRideID(entry2.getText()).build();
			StreamObserver<InfoResponse> responseObserver3 = new StreamObserver<InfoResponse>(){
				@Override
				public void onNext(InfoResponse response3) {
					reply2.setText(response3.getStartingLocation() + response3.getDestination());
				}
				
				@Override
				public void onError(Throwable t) {
					t.printStackTrace();
				}
				
				@Override
				public void onCompleted() {
					System.out.println("Stream is completed.");
				}
			};
			
			asyncStub.getRideInfo(request3, responseObserver);
			//什么问题----------------------检查一下这个方法是否正确
	
			
		}else if (label.equals("Invoke Service 3")) {
			System.out.println("service 3 to be invoked ...");

		
			/*
			 * 
			 */
			ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 50053).usePlaintext().build();
			PaymentSystemGrpc.PaymentSystemBlockingStub blockingStub = PaymentSystemGrpc.newBlockingStub(channel);

			//processPayment method
			ds.service3.PaymentRequest request1 = ds.service3.PaymentRequest.newBuilder().setPayment(entry3.getText()).build();			
			
			ds.service3.PaymentResponse response1 = blockingStub.processPayment(request1);
	
			reply3.setText(response1.getConfirmMessage());
			
			//generateInvoice method
			ds.service3.InvoiceRequest request2 = ds.service3.InvoiceRequest.newBuilder().setCustomerName(entry3.getText()).setAmount(entry3.getText()).build();
			
			ds.service3.InvoiceResponse response2 = blockingStub.generateInvoice(request2);
			
			reply3.setText(response2.getInvoiceID() + response2.getConfirmMessage());
			
			//handleRefunds method
			StreamObserver<RefundsResponse> responseObserver = new StreamObserver<RefundsResponse>(){
				@Override
				public void onNext(RefundsResponse response3) {
					reply3.setText(response3.getConfirmMessage() + response3.getRefundID());
				}
				
				@Override
				public void onError(Throwable t) {
					t.printStackTrace();
				}
				
				@Override
				public void onCompleted() {
					System.out.println("Stream is completed.");
				}
			};
			
			StreamObserver<RefundsRequest> requestObserver = asyncStub.handleRefunds(responseObserver);
			ds.service3.RefundsRequest request3 = ds.service3.RefundsRequest.newBuilder()
					                              .setCustomerName(entry3.getText())
					                              .setRideID(entry3.getText())
					                              .setAmount(entry3.getText())
					                              .build(); 
			try {

				requestObserver.onNext(request3);

				// Mark the end of requests
				requestObserver.onCompleted();
				Thread.sleep(10000);

			} catch (RuntimeException e1) {
				e1.printStackTrace();
			} catch (InterruptedException e1) {			
				e1.printStackTrace();
			}

		
		}else{
			
		}

	}
}
