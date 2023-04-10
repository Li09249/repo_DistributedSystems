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
import ds.service2.CustomerServiceGrpc.CustomerServiceBlockingStub;
import ds.service2.CustomerServiceGrpc.CustomerServiceStub;
import ds.service2.InfoResponse;
import ds.service3.InvoiceRequest;
import ds.service3.InvoiceResponse;
import ds.service3.PaymentSystemGrpc;
import ds.service3.PaymentSystemGrpc.PaymentSystemBlockingStub;
import ds.service3.PaymentSystemGrpc.PaymentSystemStub;
import ds.service3.RefundsRequest;
import ds.service3.RefundsResponse;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.stub.StreamObserver;

public class ControllerGUI implements ActionListener {
	
	private JTextField entry1_1,entry1_2,entry1_3, reply1_1,reply1_2,reply1_3;
	private JTextField entry2_1,entry2_2,entry2_3, reply2_1,reply2_2,reply2_3;
	private JTextField entry3_1,entry3_2,entry3_3, reply3_1,reply3_2,reply3_3;
	private static FleetManagementBlockingStub blockingStub1;
	private static FleetManagementStub asyncStub1;
	private static CustomerServiceBlockingStub blockingStub2;
	private static CustomerServiceStub asyncStub2;
	private static PaymentSystemBlockingStub blockingStub3;
	private static PaymentSystemStub asyncStub3;
	
	private JPanel getService1JPanel() {

		JPanel panel = new JPanel();

		BoxLayout boxlayout = new BoxLayout(panel, BoxLayout.X_AXIS);

		//service 1, method 1
		JLabel label = new JLabel("Service 1: Enter value")	;
		panel.add(label);
		panel.add(Box.createRigidArea(new Dimension(10, 0)));
		entry1_1 = new JTextField("",10);
		panel.add(entry1_1);
		panel.add(Box.createRigidArea(new Dimension(10, 0)));

		JButton button = new JButton("Invoke Method 1");
		button.addActionListener(this);
		panel.add(button);
		panel.add(Box.createRigidArea(new Dimension(10, 0)));

		reply1_1 = new JTextField("", 10);
		reply1_1 .setEditable(false);
		panel.add(reply1_1);
		
		//method 2
		JLabel label2 = new JLabel("Enter value")	;
		panel.add(label2);
		panel.add(Box.createRigidArea(new Dimension(10, 0)));
		entry1_2 = new JTextField("",10);
		panel.add(entry1_2);
		panel.add(Box.createRigidArea(new Dimension(10, 0)));

		JButton button2 = new JButton("Invoke Method 2");
		button2.addActionListener(this);
		panel.add(button2);
		panel.add(Box.createRigidArea(new Dimension(10, 0)));

		reply1_2 = new JTextField("", 10);
		reply1_2 .setEditable(false);
		panel.add(reply1_2 );
		
		//method 3
		JLabel label3 = new JLabel("Enter value")	;
		panel.add(label3);
		panel.add(Box.createRigidArea(new Dimension(10, 0)));
		entry1_3 = new JTextField("",10);
		panel.add(entry1_3);
		panel.add(Box.createRigidArea(new Dimension(10, 0)));

		JButton button3 = new JButton("Invoke Method 3");
		button3.addActionListener(this);
		panel.add(button3);
		panel.add(Box.createRigidArea(new Dimension(10, 0)));

		reply1_3 = new JTextField("", 10);
		reply1_3 .setEditable(false);
		panel.add(reply1_3 );

		panel.setLayout(boxlayout);

		return panel;

	}
	
	private JPanel getService2JPanel() {

		JPanel panel = new JPanel();

		BoxLayout boxlayout = new BoxLayout(panel, BoxLayout.X_AXIS);

		//service 2, method 1
		JLabel label = new JLabel("Service 2: Enter value")	;
		panel.add(label);
		panel.add(Box.createRigidArea(new Dimension(10, 0)));
		entry2_1 = new JTextField("",10);
		panel.add(entry2_1);
		panel.add(Box.createRigidArea(new Dimension(10, 0)));

		JButton button = new JButton("Invoke Method 1");
		button.addActionListener(this);
		panel.add(button);
		panel.add(Box.createRigidArea(new Dimension(10, 0)));

		reply2_1 = new JTextField("", 10);
		reply2_1 .setEditable(false);
		panel.add(reply2_1 );
		
		//method 2
		JLabel label2 = new JLabel("Enter value")	;
		panel.add(label2);
		panel.add(Box.createRigidArea(new Dimension(10, 0)));
		entry2_2 = new JTextField("",10);
		panel.add(entry2_2);
		panel.add(Box.createRigidArea(new Dimension(10, 0)));

		JButton button2 = new JButton("Invoke Method 2");
		button2.addActionListener(this);
		panel.add(button2);
		panel.add(Box.createRigidArea(new Dimension(10, 0)));

		reply2_2 = new JTextField("", 10);
		reply2_2 .setEditable(false);
		panel.add(reply2_2 );
		
		//method 3
		JLabel label3 = new JLabel("Enter value")	;
		panel.add(label3);
		panel.add(Box.createRigidArea(new Dimension(10, 0)));
		entry2_3 = new JTextField("",10);
		panel.add(entry2_3);
		panel.add(Box.createRigidArea(new Dimension(10, 0)));

		JButton button3 = new JButton("Invoke Method 3");
		button3.addActionListener(this);
		panel.add(button3);
		panel.add(Box.createRigidArea(new Dimension(10, 0)));

		reply2_3 = new JTextField("", 10);
		reply2_3 .setEditable(false);
		panel.add(reply2_3 );

		panel.setLayout(boxlayout);

		return panel;

	}
	
	private JPanel getService3JPanel() {

		JPanel panel = new JPanel();

		BoxLayout boxlayout = new BoxLayout(panel, BoxLayout.X_AXIS);

		//service 3, method 1
		JLabel label = new JLabel("Service 3: Enter value")	;
		panel.add(label);
		panel.add(Box.createRigidArea(new Dimension(10, 0)));
		entry3_1 = new JTextField("",10);
		panel.add(entry3_1);
		panel.add(Box.createRigidArea(new Dimension(10, 0)));

		JButton button = new JButton("Invoke Method 1");
		button.addActionListener(this);
		panel.add(button);
		panel.add(Box.createRigidArea(new Dimension(10, 0)));

		reply3_1 = new JTextField("", 10);
		reply3_1 .setEditable(false);
		panel.add(reply3_1 );
		
		//method 2
		JLabel label2 = new JLabel("Enter value")	;
		panel.add(label2);
		panel.add(Box.createRigidArea(new Dimension(10, 0)));
		entry3_2 = new JTextField("",10);
		panel.add(entry3_2);
		panel.add(Box.createRigidArea(new Dimension(10, 0)));

		JButton button2 = new JButton("Invoke Method 2");
		button2.addActionListener(this);
		panel.add(button2);
		panel.add(Box.createRigidArea(new Dimension(10, 0)));

		reply3_2 = new JTextField("", 10);
		reply3_2 .setEditable(false);
		panel.add(reply3_2 );
		
		//method 3
		JLabel label3 = new JLabel("Enter value")	;
		panel.add(label3);
		panel.add(Box.createRigidArea(new Dimension(10, 0)));
		entry3_3 = new JTextField("",10);
		panel.add(entry3_3);
		panel.add(Box.createRigidArea(new Dimension(10, 0)));

		JButton button3 = new JButton("Invoke Method 3");
		button3.addActionListener(this);
		panel.add(button3);
		panel.add(Box.createRigidArea(new Dimension(10, 0)));

		reply3_3 = new JTextField("", 10);
		reply3_3 .setEditable(false);
		panel.add(reply3_3 );

		panel.setLayout(boxlayout);

		return panel;

	}
	
	public static void main(String[] args) {

		ControllerGUI gui = new ControllerGUI();

		gui.build();
	}
	
	private void build() { 

		JFrame frame = new JFrame("Transport System Controller");
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

			ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 50051).usePlaintext().build();
			FleetManagementGrpc.FleetManagementBlockingStub blockingStub1 = FleetManagementGrpc.newBlockingStub(channel);

			//addVehicle method          1 VS 1
			//preparing message to send
			ds.service1.AddRequest request1 = ds.service1.AddRequest.newBuilder().setTargetCapacity(entry1_1.getText()).build();

			//retrieving reply from service
			ds.service1.AddResponse response1 = blockingStub1.addVehicle(request1);
			
			//displaying the response to the user
			reply1_1.setText(response1.getVehicleID());
			
			//removeVehicle method             1 VS 1
			//preparing message to send
			ds.service1.RemoveRequest request2 = ds.service1.RemoveRequest.newBuilder().setCapacity(entry1_2.getText()).build();
			
			//retrieving reply from service			
			ds.service1.RemoveResponse response2 = blockingStub1.removeVehicle(request2);
			
			//displaying the response to the user
			reply1_2.setText(response2.getVehicleID());
						
			//getVehicleStatus method             1 VS 2
			ds.service1.StatusRequest request3 = ds.service1.StatusRequest.newBuilder().setVehicleID(entry1_3.getText()).build();
			StreamObserver<StatusResponse> responseObserver = new StreamObserver<StatusResponse>(){
				@Override
				public void onNext(StatusResponse response3) {
					reply1_3.setText(response3.getCurrentLocation() + response3.getCurrentSpeed());
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
			
			asyncStub1.getVehicleStatus(request3, responseObserver);
			
			try {
				Thread.sleep(15000);
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
		}else if (label.equals("Invoke Service 2")) {
			System.out.println("service 2 to be invoked ...");

			ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 50052).usePlaintext().build();
			CustomerServiceGrpc.CustomerServiceBlockingStub blockingStub2 = CustomerServiceGrpc.newBlockingStub(channel);
			CustomerServiceGrpc.CustomerServiceStub stub = CustomerServiceGrpc.newStub(channel);

            //bookRide method                     2 VS 1
			StreamObserver<BookRequest> requestObserver = stub.bookRide(new StreamObserver<BookResponse>() {
				@Override
				public void onNext(BookResponse response1) {
					reply2_1.setText(response1.getConfirmMessage());
				}
				
				@Override
				public void onError(Throwable t) {
					t.printStackTrace();
				}
				
				@Override
				public void onCompleted() {
					System.out.println("Stream is completed.");
				}
			});
			
			requestObserver.onNext(BookRequest.newBuilder().setCurrentLocation(entry2_1.getText()).setDestination(entry2_1.getText()).build());
			requestObserver.onCompleted();
			
			/*ds.service2.BookRequest request1 = ds.service2.BookRequest.newBuilder().setCurrentLocation(entry2_1.getText()).setDestination(entry2_1.getText()).build();				
		    StreamObserver<BookResponse> responseObserver = new StreamObserver<BookResponse>() {
		    	@Override
				public void onNext(BookResponse response1) {   
					reply2_1.setText(response1.getConfirmMessage());
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
		    asyncStub2.bookRide(request1, responseObserver);
		  //why it shows error----------------------------------
		    
			try {
				Thread.sleep(15000);
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}*/
			
			//cancelRide method               1 VS 1
			ds.service2.CancelRequest request2 = ds.service2.CancelRequest.newBuilder().setRideID(entry2_2.getText()).build();
								
			ds.service2.CancelResponse response2 = blockingStub2.cancelRide(request2);
			
			reply2_2.setText(response2.getStatus());
			
			//getRideInfo method             1 VS 2
			ds.service2.InfoRequest request3 = ds.service2.InfoRequest.newBuilder().setRideID(entry2_3.getText()).build();
			StreamObserver<InfoResponse> responseObserver3 = new StreamObserver<InfoResponse>(){
				@Override
				public void onNext(InfoResponse response3) {
					reply2_3.setText(response3.getStartingLocation() + response3.getDestination());
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
			
			asyncStub2.getRideInfo(request3, responseObserver3);
			
			try {
				Thread.sleep(15000);
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
	
			
		}else if (label.equals("Invoke Service 3")) {
			System.out.println("service 3 to be invoked ...");

			ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 50053).usePlaintext().build();
			PaymentSystemGrpc.PaymentSystemBlockingStub blockingStub3 = PaymentSystemGrpc.newBlockingStub(channel);

			//processPayment method            1 VS 1
		    double payment = Double.parseDouble(entry3_2.getText());
			ds.service3.PaymentRequest request1 = ds.service3.PaymentRequest.newBuilder().setPayment(payment).build();			
			
			ds.service3.PaymentResponse response1 = blockingStub3.processPayment(request1);
	
			reply3_1.setText(response1.getConfirmMessage());
			
			//generateInvoice method           2 VS 2
			double amount = Double.parseDouble(entry3_2.getText());
			StreamObserver<InvoiceResponse> responseObserver1 = new StreamObserver<InvoiceResponse>(){
				@Override
				public void onNext(InvoiceResponse response2) {
					reply3_2.setText(response2.getInvoiceID() + response2.getConfirmMessage());
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
			StreamObserver<InvoiceRequest> requestObserver1 = asyncStub3.generateInvoice(responseObserver1);
			double amount2 = Double.parseDouble(entry3_2.getText());
			ds.service3.InvoiceRequest request2 = ds.service3.InvoiceRequest.newBuilder()
					                              .setCustomerName(entry3_3.getText())
					                              .setAmount(amount2)
					                              .build(); 
			try {

				requestObserver1.onNext(request2);

				// Mark the end of requests
				requestObserver1.onCompleted();
				Thread.sleep(10000);

			} catch (RuntimeException e1) {
				e1.printStackTrace();
			} catch (InterruptedException e1) {			
				e1.printStackTrace();
			}
			
			//handleRefunds method              3 VS 2
			StreamObserver<RefundsResponse> responseObserver2 = new StreamObserver<RefundsResponse>(){
				@Override
				public void onNext(RefundsResponse response3) {
					reply3_3.setText(response3.getConfirmMessage() + response3.getRefundID());
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
			
			StreamObserver<RefundsRequest> requestObserver2 = asyncStub3.handleRefunds(responseObserver2); //why it shows error----------
			double amount1 = Double.parseDouble(entry3_3.getText());
			ds.service3.RefundsRequest request3 = ds.service3.RefundsRequest.newBuilder()
					                              .setCustomerName(entry3_3.getText())
					                              .setRideID(entry3_3.getText())
					                              .setAmount(amount1)
					                              .build(); 
			try {

				requestObserver2.onNext(request3);

				// Mark the end of requests
				requestObserver2.onCompleted();
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
