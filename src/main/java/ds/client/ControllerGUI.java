package ds.client;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.concurrent.TimeUnit;

import javax.jmdns.JmDNS;
import javax.jmdns.ServiceEvent;
import javax.jmdns.ServiceInfo;
import javax.jmdns.ServiceListener;
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
import io.grpc.StatusRuntimeException;
import io.grpc.stub.StreamObserver;

public class ControllerGUI implements ActionListener {
	
	private JTextField entry1, reply1;
	private JTextField entry2, entry2_1,entry2_2, reply2;
	private JTextField entry3, entry3_1,entry3_2,entry3_3, reply3;
	
	private static FleetManagementStub asyncStub1;
	private static FleetManagementBlockingStub blockingStub1;

	private static CustomerServiceStub asyncStub2;
	private static CustomerServiceBlockingStub blockingStub2;

	private static PaymentSystemStub asyncStub3;
	private static PaymentSystemBlockingStub blockingStub3;
	
	private ServiceInfo service1Info;
	private ServiceInfo service2Info;
	private ServiceInfo service3Info;
	
	
	private JPanel getService1JPanel() {

		JPanel panel = new JPanel();		
		BoxLayout boxlayout = new BoxLayout(panel, BoxLayout.Y_AXIS);	
		panel.setLayout(boxlayout);
		
		//service 1
		JPanel panel1 = new JPanel();
		BoxLayout boxlayout1 = new BoxLayout(panel1, BoxLayout.X_AXIS);
		panel1.setLayout(boxlayout1);
		
		JButton button4 = new JButton("Invoke Service 1");
		button4.addActionListener(this);
		Font font = button4.getFont();
		button4.setFont(new Font(font.getName(), Font.BOLD, 18));
		panel1.add(Box.createHorizontalGlue());
		panel1.add(button4);
		panel.add(panel1);
		
		//method 1
		JPanel panel2 = new JPanel();
		BoxLayout boxlayout2 = new BoxLayout(panel2, BoxLayout.X_AXIS);
		panel2.setLayout(boxlayout2);
		
		JLabel label2 = new JLabel("tgCapacity");
		panel2.add(label2);
		panel2.add(Box.createRigidArea(new Dimension(10, 0)));
		entry1 = new JTextField("",30);
		panel2.add(entry1);
		panel2.add(Box.createRigidArea(new Dimension(10, 0)));

		JButton button1 = new JButton("addVehicle");
		button1.addActionListener(this);
		button1.setPreferredSize(new Dimension(168, button1.getPreferredSize().height));
		panel2.add(button1);
		panel2.add(Box.createRigidArea(new Dimension(10, 0)));

		reply1 = new JTextField("", 30);
		reply1.setEditable(false);
		panel2.add(reply1);
		panel.add(panel2);
		
		//method 2
		JPanel panel3 = new JPanel();
		BoxLayout boxlayout3 = new BoxLayout(panel3, BoxLayout.X_AXIS);
		panel3.setLayout(boxlayout3);
		
		JLabel label3 = new JLabel("Capacity");
		panel3.add(label3);
		panel3.add(Box.createRigidArea(new Dimension(21, 0)));
		entry1 = new JTextField("",30);
		panel3.add(entry1);
		panel3.add(Box.createRigidArea(new Dimension(10, 0)));

		JButton button2 = new JButton("removeVehicle");
		button2.addActionListener(this);
		button2.setPreferredSize(new Dimension(168, button2.getPreferredSize().height));
		panel3.add(button2);
		panel3.add(Box.createRigidArea(new Dimension(10, 0)));

		reply1 = new JTextField("", 30);
		reply1.setEditable(false);
		panel3.add(reply1);
		panel.add(panel3);
		
		
		//method 3
		JPanel panel4 = new JPanel();
		BoxLayout boxlayout4 = new BoxLayout(panel4, BoxLayout.X_AXIS);
		panel4.setLayout(boxlayout4);
		
		JLabel label4 = new JLabel("VehicleID");
		panel4.add(label4);
		panel4.add(Box.createRigidArea(new Dimension(16, 0)));
		entry1 = new JTextField("",30);
		panel4.add(entry1);
		panel4.add(Box.createRigidArea(new Dimension(10, 0)));

		JButton button3 = new JButton("getVehicleStatus");
		button3.addActionListener(this);
		button3.setPreferredSize(new Dimension(168, button3.getPreferredSize().height));
		panel4.add(button3);
		panel4.add(Box.createRigidArea(new Dimension(10, 0)));

		reply1 = new JTextField("", 30);
		reply1.setEditable(false);
		panel4.add(reply1);
		panel.add(panel4);
		
		return panel;
		
		

	}
	
	private JPanel getService2JPanel() {
		
		JPanel panel = new JPanel();		
		BoxLayout boxlayout = new BoxLayout(panel, BoxLayout.Y_AXIS);	
		panel.setLayout(boxlayout);
		
		//service 2
		JPanel panel1 = new JPanel();
		BoxLayout boxlayout1 = new BoxLayout(panel1, BoxLayout.X_AXIS);
		panel1.setLayout(boxlayout1);
		
		JButton button4 = new JButton("Invoke Service 2");
		button4.addActionListener(this);
		Font font = button4.getFont();
		button4.setFont(new Font(font.getName(), Font.BOLD, 18));
		panel1.add(Box.createHorizontalGlue());
		panel1.add(button4);
		panel.add(panel1);
		
		//method 1
		JPanel panel2 = new JPanel();
		BoxLayout boxlayout2 = new BoxLayout(panel2, BoxLayout.X_AXIS);
		panel2.setLayout(boxlayout2);
		
		JLabel label2 = new JLabel("crLocation");
		panel2.add(label2);
		panel2.add(Box.createRigidArea(new Dimension(10, 0)));
		entry2_1 = new JTextField("",9);
		panel2.add(entry2_1);
		panel2.add(Box.createRigidArea(new Dimension(10, 0)));
		JLabel label2_2 = new JLabel("Destination");
		panel2.add(label2_2);
		panel2.add(Box.createRigidArea(new Dimension(10, 0)));
		entry2_2 = new JTextField("",9);
		panel2.add(entry2_2);
		panel2.add(Box.createRigidArea(new Dimension(10, 0)));

		JButton button1 = new JButton("bookRide");
		button1.addActionListener(this);
		button1.setPreferredSize(new Dimension(120, button1.getPreferredSize().height));
		panel2.add(button1);
		panel2.add(Box.createRigidArea(new Dimension(10, 0)));

		reply2 = new JTextField("", 30);
		reply2.setEditable(false);
		panel2.add(reply2);		
		panel.add(panel2);
		
		//method 2
		JPanel panel3 = new JPanel();
		BoxLayout boxlayout3 = new BoxLayout(panel3, BoxLayout.X_AXIS);
		panel3.setLayout(boxlayout3);
		
		JLabel label3 = new JLabel("RideID");
		panel3.add(label3);
		panel3.add(Box.createRigidArea(new Dimension(32, 0)));
		entry2 = new JTextField("",30);
		panel3.add(entry2);
		panel3.add(Box.createRigidArea(new Dimension(10, 0)));

		JButton button2 = new JButton("cancelRide");
		button2.addActionListener(this);
		button2.setPreferredSize(new Dimension(168, button2.getPreferredSize().height));
		panel3.add(button2);
		panel3.add(Box.createRigidArea(new Dimension(10, 0)));

		reply2 = new JTextField("", 30);
		reply2.setEditable(false);
		panel3.add(reply2);
		panel.add(panel3);
		
		//method 3
		JPanel panel4 = new JPanel();
		BoxLayout boxlayout4 = new BoxLayout(panel4, BoxLayout.X_AXIS);
		panel4.setLayout(boxlayout4);
		
		JLabel label4 = new JLabel("RideID");
		panel4.add(label4);
		panel4.add(Box.createRigidArea(new Dimension(32, 0)));
		entry2 = new JTextField("",30);
		panel4.add(entry2);
		panel4.add(Box.createRigidArea(new Dimension(10, 0)));

		JButton button3 = new JButton("getRideInfo");
		button3.addActionListener(this);
		button3.setPreferredSize(new Dimension(168, button3.getPreferredSize().height));
		panel4.add(button3);
		panel4.add(Box.createRigidArea(new Dimension(10, 0)));

		reply2 = new JTextField("", 30);
		reply2.setEditable(false);
		panel4.add(reply2);
		panel.add(panel4);

		return panel;

	}
	
	private JPanel getService3JPanel() {

		JPanel panel = new JPanel();		
		BoxLayout boxlayout = new BoxLayout(panel, BoxLayout.Y_AXIS);	
		panel.setLayout(boxlayout);
		
		//service 3
		JPanel panel1 = new JPanel();
		BoxLayout boxlayout1 = new BoxLayout(panel1, BoxLayout.X_AXIS);
		panel1.setLayout(boxlayout1);
		
		JButton button4 = new JButton("Invoke Service 3");
		button4.addActionListener(this);
		Font font = button4.getFont();
		button4.setFont(new Font(font.getName(), Font.BOLD, 18));
		panel1.add(Box.createHorizontalGlue());
		panel1.add(button4);
		panel.add(panel1);

		//method 1
		JPanel panel2 = new JPanel();
		BoxLayout boxlayout2 = new BoxLayout(panel2, BoxLayout.X_AXIS);
		panel2.setLayout(boxlayout2);
		
		JLabel label2 = new JLabel("Payment");
		panel2.add(label2);
		panel2.add(Box.createRigidArea(new Dimension(18, 0)));
		entry3 = new JTextField("",30);
		panel2.add(entry3);
		panel2.add(Box.createRigidArea(new Dimension(10, 0)));

		JButton button1 = new JButton("processPayment");
		button1.addActionListener(this);
		button1.setPreferredSize(new Dimension(168, button1.getPreferredSize().height));
		panel2.add(button1);
		panel2.add(Box.createRigidArea(new Dimension(9, 0)));

		reply3 = new JTextField("", 30);
		reply3.setEditable(false);
		panel2.add(reply3);
		panel.add(panel2);
		
		//method 2
		JPanel panel3 = new JPanel();
		BoxLayout boxlayout3 = new BoxLayout(panel3, BoxLayout.X_AXIS);
		panel3.setLayout(boxlayout3);
		
		JLabel label3 = new JLabel("custName");
		panel3.add(label3);
		panel3.add(Box.createRigidArea(new Dimension(11, 0)));
		entry3_1 = new JTextField("",12);
		panel3.add(entry3_1);
		panel3.add(Box.createRigidArea(new Dimension(10, 0)));
		JLabel label3_2 = new JLabel("Amount");
		panel3.add(label3_2);
		panel3.add(Box.createRigidArea(new Dimension(10, 0)));
		entry3_2 = new JTextField("",3);
		panel3.add(entry3_2);
		panel3.add(Box.createRigidArea(new Dimension(10, 0)));

		JButton button2 = new JButton("generateInvoice");
		button2.addActionListener(this);
		button2.setPreferredSize(new Dimension(168, button2.getPreferredSize().height));
		panel3.add(button2);
		panel3.add(Box.createRigidArea(new Dimension(10, 0)));

		reply3 = new JTextField("", 30);
		reply3.setEditable(false);
		panel3.add(reply3);
		panel.add(panel3);
		
		//method 3
		JPanel panel4 = new JPanel();
		BoxLayout boxlayout4 = new BoxLayout(panel4, BoxLayout.X_AXIS);
		panel4.setLayout(boxlayout4);
		
		JLabel label4 = new JLabel("custName");
		panel4.add(label4);
		panel4.add(Box.createRigidArea(new Dimension(11, 0)));
		entry3_1 = new JTextField("",10);
		panel4.add(entry3_1);
		panel4.add(Box.createRigidArea(new Dimension(10, 0)));
		JLabel label4_2 = new JLabel("RideID");
		panel4.add(label4_2);
		panel4.add(Box.createRigidArea(new Dimension(10, 0)));
		entry3_2 = new JTextField("",10);
		panel4.add(entry3_2);
		panel4.add(Box.createRigidArea(new Dimension(10, 0)));
		JLabel label4_3 = new JLabel("Amount");
		panel4.add(label4_3);
		panel4.add(Box.createRigidArea(new Dimension(10, 0)));
		entry3_3 = new JTextField("",10);
		panel4.add(entry3_3);
		panel4.add(Box.createRigidArea(new Dimension(10, 0)));

		JButton button3 = new JButton("handleRefunds");
		button3.addActionListener(this);
		button3.setPreferredSize(new Dimension(168, button3.getPreferredSize().height));
		panel4.add(button3);
		panel4.add(Box.createRigidArea(new Dimension(10, 0)));

		reply3 = new JTextField("", 30);
		reply3.setEditable(false);
		panel4.add(reply3);
        panel.add(panel4);

		return panel;

	}
	
	public static void main(String[] args) {

		ControllerGUI gui = new ControllerGUI();

		gui.build();
	}
	public ControllerGUI() {
		
		String service1_type = "_service1._tcp.local.";
		String service2_type = "_service2._tcp.local.";
		String service3_type = "_service3._tcp.local.";
		discoverService(service1_type);
		discoverService(service2_type);
		discoverService(service3_type);
		
	}
	
	private void discoverService(String service_type) {
		try {
			//create a JmDNS instance
			JmDNS jmdns = JmDNS.create(InetAddress.getLocalHost());
			
			//add a service listener for service 1
			jmdns.addServiceListener(service_type, new ServiceListener() {
				
				@Override
	            public void serviceResolved(ServiceEvent event) {
	                                
	                // Get the service info and connect to the service
	                if (service_type.equals("_service1._tcp.local.")) {
	                	System.out.println("Service 1 resolved: " + event.getInfo());
	                	ServiceInfo service1Info = event.getInfo();
	                	String host = service1Info.getHostAddress()[0];
	                	int port = service1Info.getPort();
	                	ManagedChannel channel = ManagedChannelBuilder.forAddress(host, port)
	                			                 .usePlaintext()
	                			                 .build();
	                    blockingStub1 = FleetManagementGrpc.newBlockingStub(channel);
	                    asyncStub1 = FleetManagementGrpc.newStub(channel);
	                    
	                }else if(service_type.equals("_service2._tcp.local.")){
	                	System.out.println("Service 2 resolved: " + event.getInfo());
	                	ServiceInfo service2Info = event.getInfo();
	                	String host = service2Info.getHostAddress()[0];
	                	int port = service2Info.getPort();
	                	ManagedChannel channel = ManagedChannelBuilder.forAddress(host, port)
	                			                 .usePlaintext()
	                			                 .build();
	                    blockingStub2 = CustomerServiceGrpc.newBlockingStub(channel);
	                    asyncStub2 = CustomerServiceGrpc.newStub(channel);
	                }else if(service_type.equals("_service3._tcp.local.")) {
	                	System.out.println("Service 3 resolved: " + event.getInfo());
	                	ServiceInfo service3Info = event.getInfo();
	                	String host = service3Info.getHostAddress()[0];
	                	int port = service3Info.getPort();
	                	ManagedChannel channel = ManagedChannelBuilder.forAddress(host, port)
	                			                 .usePlaintext()
	                			                 .build();
	                	blockingStub3 = PaymentSystemGrpc.newBlockingStub(channel);
	                    asyncStub3 = PaymentSystemGrpc.newStub(channel);
	                }
	            }
				
				@Override
				public void serviceAdded(ServiceEvent event) {
					System.out.println("Service added: " + event.getInfo());
				}
				
				@Override
				public void serviceRemoved(ServiceEvent event) {
					System.out.println("Service removed: " + event.getInfo());					
				}
								
			});
			
			// Wait a bit
			Thread.sleep(2000);
			jmdns.close();
		} catch (UnknownHostException e) {
			System.out.println(e.getMessage());
		} catch (IOException e) {
			System.out.println(e.getMessage());
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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
		frame.setSize(400, 400);

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
			System.out.println("Service 1 to be invoked ...");

			ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 50051).usePlaintext().build();
			FleetManagementGrpc.FleetManagementBlockingStub blockingStub = FleetManagementGrpc.newBlockingStub(channel);
			
            if (label.equals("addVehicle")) {            	
    			try {
    				//addVehicle method          1 VS 1
        			//preparing message to send
					ds.service1.AddRequest request = ds.service1.AddRequest.newBuilder().setTargetCapacity(entry1.getText()).build();

					//retrieving reply from service
					ds.service1.AddResponse response = blockingStub.addVehicle(request);
					
					//displaying the response to the user
					reply1.setText(response.getVehicleID());
				} catch (StatusRuntimeException e1) {
					e1.getStatus();
				}finally {
					try {
						channel.shutdown().awaitTermination(5, TimeUnit.SECONDS);
					}catch(InterruptedException e1) {
						e1.printStackTrace();
					}
				}
            
            }else if (label.equals("removeVehicle")) {
    			try {
					//removeVehicle method             1 VS 1
					//preparing message to send
					ds.service1.RemoveRequest request = ds.service1.RemoveRequest.newBuilder().setCapacity(entry1.getText()).build();
					
					//retrieving reply from service			
					ds.service1.RemoveResponse response = blockingStub.removeVehicle(request);
					
					//displaying the response to the user
					reply1.setText(response.getVehicleID());
				} catch (StatusRuntimeException e1) {
					e1.getStatus();
				}finally {
					try {
						channel.shutdown().awaitTermination(5, TimeUnit.SECONDS);
					}catch(InterruptedException e1) {
						e1.printStackTrace();
					}
				}
            }else if (label.equals("getVehicleStatus")) {           	
    			//getVehicleStatus method             1 VS 2
    			ds.service1.StatusRequest request = ds.service1.StatusRequest.newBuilder().setVehicleID(entry1.getText()).build();
    			StreamObserver<StatusResponse> responseObserver = new StreamObserver<StatusResponse>(){
    				@Override
    				public void onNext(StatusResponse response) {
    					reply1.setText(response.getCurrentLocation() + response.getCurrentSpeed());
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
    			
    			asyncStub1.getVehicleStatus(request, responseObserver);
    			
    			try {
    				Thread.sleep(15000);
    			} catch (InterruptedException e1) {
    				// TODO Auto-generated catch block
    				e1.printStackTrace();
    			}
            }
			
		}else if (label.equals("Invoke Service 2")) {
			System.out.println("Service 2 to be invoked ...");

			ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 50052).usePlaintext().build();
			CustomerServiceGrpc.CustomerServiceBlockingStub blockingStub = CustomerServiceGrpc.newBlockingStub(channel);
			CustomerServiceGrpc.CustomerServiceStub stub = CustomerServiceGrpc.newStub(channel);
			
			if (label.equals("bookRide")) {
				//bookRide method                     2 VS 1
				StreamObserver<BookRequest> requestObserver = stub.bookRide(new StreamObserver<BookResponse>() {
					@Override
					public void onNext(BookResponse response) {
						reply2.setText(response.getConfirmMessage());
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
				
				requestObserver.onNext(BookRequest.newBuilder().setCurrentLocation(entry2_1.getText()).setDestination(entry2_2.getText()).build());
				requestObserver.onCompleted();
				
			}else if (label.equals("cancelRide")) {
				try {
					//cancelRide method               1 VS 1
					ds.service2.CancelRequest request = ds.service2.CancelRequest.newBuilder().setRideID(entry2.getText()).build();
										
					ds.service2.CancelResponse response = blockingStub.cancelRide(request);
					
					reply2.setText(response.getStatus());
				} catch (StatusRuntimeException e1) {
					e1.getStatus();
				}finally {
					try {
						channel.shutdown().awaitTermination(5, TimeUnit.SECONDS);
					}catch(InterruptedException e1) {
						e1.printStackTrace();
					}
				}
				
			}else if (label.equals("getRideInfo")){				
				//getRideInfo method             1 VS 2
				ds.service2.InfoRequest request = ds.service2.InfoRequest.newBuilder().setRideID(entry2.getText()).build();
				StreamObserver<InfoResponse> responseObserver = new StreamObserver<InfoResponse>(){
					@Override
					public void onNext(InfoResponse response) {
						reply2.setText(response.getStartingLocation() + response.getDestination());
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
				
				asyncStub2.getRideInfo(request, responseObserver);
				
				try {
					Thread.sleep(15000);
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
						
		}else if (label.equals("Invoke Service 3")) {
			System.out.println("Service 3 to be invoked ...");

			ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 50053).usePlaintext().build();
			PaymentSystemGrpc.PaymentSystemBlockingStub blockingStub = PaymentSystemGrpc.newBlockingStub(channel);
			
			if (label.equals("processPayment")) {
				try {
					//processPayment method            1 VS 1
					double payment = Double.parseDouble(entry3.getText());
					ds.service3.PaymentRequest request = ds.service3.PaymentRequest.newBuilder().setPayment(payment).build();			
					
					ds.service3.PaymentResponse response = blockingStub.processPayment(request);

					reply3.setText(response.getConfirmMessage());
				} catch (StatusRuntimeException e1) {
					e1.getStatus();
				}finally {
					try {
						channel.shutdown().awaitTermination(5, TimeUnit.SECONDS);
					}catch(InterruptedException e1) {
						e1.printStackTrace();
					}
				}
				
			}else if (label.equals("generateInvoice")) {				
				//generateInvoice method           2 VS 2

				StreamObserver<InvoiceResponse> responseObserver = new StreamObserver<InvoiceResponse>(){
					@Override
					public void onNext(InvoiceResponse response) {
						reply3.setText(response.getInvoiceID() + response.getConfirmMessage());
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
				StreamObserver<InvoiceRequest> requestObserver = asyncStub3.generateInvoice(responseObserver);
				double amount2 = Double.parseDouble(entry3_2.getText());
				ds.service3.InvoiceRequest request = ds.service3.InvoiceRequest.newBuilder()
						                              .setCustomerName(entry3_1.getText())
						                              .setAmount(amount2)
						                              .build(); 
				try {

					requestObserver.onNext(request);

					// Mark the end of requests
					requestObserver.onCompleted();
					Thread.sleep(10000);

				} catch (RuntimeException e1) {
					e1.printStackTrace();
				} catch (InterruptedException e1) {			
					e1.printStackTrace();
				}
				
			}else if (label.equals("handleRefunds")) {
				//handleRefunds method              3 VS 2
				StreamObserver<RefundsResponse> responseObserver = new StreamObserver<RefundsResponse>(){
					@Override
					public void onNext(RefundsResponse response) {
						reply3.setText(response.getConfirmMessage() + response.getRefundID());
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
				
				StreamObserver<RefundsRequest> requestObserver = asyncStub3.handleRefunds(responseObserver); 
				double amount1 = Double.parseDouble(entry3_3.getText());
				ds.service3.RefundsRequest request = ds.service3.RefundsRequest.newBuilder()
						                              .setCustomerName(entry3_1.getText())
						                              .setRideID(entry3_2.getText())
						                              .setAmount(amount1)
						                              .build(); 
				try {

					requestObserver.onNext(request);

					// Mark the end of requests
					requestObserver.onCompleted();
					Thread.sleep(10000);

				} catch (RuntimeException e1) {
					e1.printStackTrace();
				} catch (InterruptedException e1) {			
					e1.printStackTrace();
				}
				
				
			}
		
		}else{
			
		     }

	}
}
