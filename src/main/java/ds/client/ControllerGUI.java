package ds.client;

import java.awt.Dimension;
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
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
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
import io.grpc.Context;
import io.grpc.Deadline;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.Metadata;
import io.grpc.Status;
import io.grpc.StatusRuntimeException;
import io.grpc.stub.MetadataUtils;
import io.grpc.stub.StreamObserver;

public class ControllerGUI implements ActionListener {
	
	private JTextField entry1;
	private JTextArea reply1;
	private JTextField entry2;
	private JTextArea reply2;
	private JTextField entry3;
	private JTextArea reply3;
	private JTextField entry4_1,entry4_2;
	private JTextArea reply4;
	private JTextField entry5;
	private JTextArea reply5;
	private JTextField entry6;
	private JTextArea reply6;
	private JTextField entry7;
	private JTextArea reply7;
	private JTextField entry8_1,entry8_2;
	private JTextArea reply8;
	private JTextField entry9_1,entry9_2,entry9_3;
	private JTextArea reply9;
	
	
	
	private JPanel getService1Method1JPanel() {

        //method 1
		JPanel panel = new JPanel();
        BoxLayout boxlayout = new BoxLayout(panel, BoxLayout.X_AXIS);
        

        JLabel label = new JLabel("Service 1.1: tgCapacity");
        panel.add(label);
        panel.add(Box.createRigidArea(new Dimension(10, 0)));
        entry1 = new JTextField("",10);
        panel.add(entry1);
        panel.add(Box.createRigidArea(new Dimension(10, 0)));

        JButton button = new JButton("addVehicle");
        button.addActionListener(this);
        //button.setPreferredSize(new Dimension(168, button1.getPreferredSize().height));
        panel.add(button);
        panel.add(Box.createRigidArea(new Dimension(10, 0)));

        reply1 = new JTextArea(3,20);
        reply1.setLineWrap(true);
        reply1.setWrapStyleWord(true);
        reply1.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(reply1);
        panel.add(scrollPane);
        
        panel.setLayout(boxlayout);

        return panel;
    }
	
    private JPanel getService1Method2JPanel(){
        //method 2
    	JPanel panel = new JPanel();
        BoxLayout boxlayout = new BoxLayout(panel, BoxLayout.X_AXIS);
        

        JLabel label = new JLabel("Service 1.2: Capacity");
        panel.add(label);
        panel.add(Box.createRigidArea(new Dimension(10, 0)));
        entry2 = new JTextField("",10);
        panel.add(entry2);
        panel.add(Box.createRigidArea(new Dimension(10, 0)));

        JButton button = new JButton("removeVehicle");
        button.addActionListener(this);
        //button.setPreferredSize(new Dimension(168, button.getPreferredSize().height));
        panel.add(button);
        panel.add(Box.createRigidArea(new Dimension(10, 0)));

        reply2 = new JTextArea(3,20);
        reply2.setLineWrap(true);
        reply2.setWrapStyleWord(true);
        reply2.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(reply2);
        panel.add(scrollPane);
        
        panel.setLayout(boxlayout);

        return panel;
    }

    private JPanel getService1Method3JPanel(){
        //method 3
    	JPanel panel = new JPanel();
        BoxLayout boxlayout = new BoxLayout(panel, BoxLayout.X_AXIS);
        

        JLabel label = new JLabel("Service 1.3: VehicleID");
        panel.add(label);
        panel.add(Box.createRigidArea(new Dimension(10, 0)));
        entry3 = new JTextField("",10);
        panel.add(entry3);
        panel.add(Box.createRigidArea(new Dimension(10, 0)));

        JButton button = new JButton("getVehicleStatus");
        button.addActionListener(this);
        //button.setPreferredSize(new Dimension(168, button.getPreferredSize().height));
        panel.add(button);
        panel.add(Box.createRigidArea(new Dimension(10, 0)));

        reply3 = new JTextArea(3,20);
        reply3.setLineWrap(true);
        reply3.setWrapStyleWord(true);
        reply3.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(reply3);
        panel.add(scrollPane);
        
        panel.setLayout(boxlayout);

        return panel;
    }

    private JPanel getService2Method1JPanel() {

        //method 1
    	JPanel panel = new JPanel();
        BoxLayout boxlayout = new BoxLayout(panel, BoxLayout.X_AXIS);
        

        JLabel label1 = new JLabel("Service 2.1: crLocation");
        panel.add(label1);
        panel.add(Box.createRigidArea(new Dimension(10, 0)));
        entry4_1 = new JTextField("",10);
        panel.add(entry4_1);
        panel.add(Box.createRigidArea(new Dimension(10, 0)));
        JLabel label2 = new JLabel("Destination");
        panel.add(label2);
        panel.add(Box.createRigidArea(new Dimension(10, 0)));
        entry4_2 = new JTextField("",10);
        panel.add(entry4_2);
        panel.add(Box.createRigidArea(new Dimension(10, 0)));

        JButton button = new JButton("bookRide");
        button.addActionListener(this);
        //button.setPreferredSize(new Dimension(120, button.getPreferredSize().height));
        panel.add(button);
        panel.add(Box.createRigidArea(new Dimension(10, 0)));

        reply4 = new JTextArea(3,20);
        reply4.setLineWrap(true);
        reply4.setWrapStyleWord(true);
        reply4.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(reply4);
        panel.add(scrollPane);
        
        panel.setLayout(boxlayout);

        return panel;

    }

    private JPanel getService2Method2JPanel(){
        //method 2
    	JPanel panel = new JPanel();
        BoxLayout boxlayout = new BoxLayout(panel, BoxLayout.X_AXIS);
        

        JLabel label = new JLabel("Service 2.2: RideID");
        panel.add(label);
        panel.add(Box.createRigidArea(new Dimension(10, 0)));
        entry5 = new JTextField("",10);
        panel.add(entry5);
        panel.add(Box.createRigidArea(new Dimension(10, 0)));

        JButton button = new JButton("cancelRide");
        button.addActionListener(this);
        //button.setPreferredSize(new Dimension(168, button.getPreferredSize().height));
        panel.add(button);
        panel.add(Box.createRigidArea(new Dimension(10, 0)));

        reply5 = new JTextArea(3,20);
        reply5.setLineWrap(true);
        reply5.setWrapStyleWord(true);
        reply5.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(reply5);
        panel.add(scrollPane);
        
        panel.setLayout(boxlayout);

        return panel;

    }

    private JPanel getService2Method3JPanel(){
        //method 3
    	JPanel panel = new JPanel();
        BoxLayout boxlayout = new BoxLayout(panel, BoxLayout.X_AXIS);
        

        JLabel label = new JLabel("Service 2.3: RideID");
        panel.add(label);
        panel.add(Box.createRigidArea(new Dimension(10, 0)));
        entry6 = new JTextField("",10);
        panel.add(entry6);
        panel.add(Box.createRigidArea(new Dimension(10, 0)));

        JButton button = new JButton("getRideInfo");
        button.addActionListener(this);
        //button.setPreferredSize(new Dimension(168, button.getPreferredSize().height));
        panel.add(button);
        panel.add(Box.createRigidArea(new Dimension(10, 0)));

        reply6 = new JTextArea(3,20);
        reply6.setLineWrap(true);
        reply6.setWrapStyleWord(true);
        reply6.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(reply6);
        panel.add(scrollPane);
        
        panel.setLayout(boxlayout);

        return panel;
    }

    private JPanel getService3Method1JPanel() {

        //method 1
    	JPanel panel = new JPanel();
        BoxLayout boxlayout = new BoxLayout(panel, BoxLayout.X_AXIS);
        

        JLabel label = new JLabel("Service 3.1: Payment");
        panel.add(label);
        panel.add(Box.createRigidArea(new Dimension(10, 0)));
        entry7 = new JTextField("",10);
        panel.add(entry7);
        panel.add(Box.createRigidArea(new Dimension(10, 0)));

        JButton button = new JButton("processPayment");
        button.addActionListener(this);
        //button.setPreferredSize(new Dimension(168, button.getPreferredSize().height));
        panel.add(button);
        panel.add(Box.createRigidArea(new Dimension(10, 0)));

        reply7 = new JTextArea(3,20);
        reply7.setLineWrap(true);
        reply7.setWrapStyleWord(true);
        reply7.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(reply7);
        panel.add(scrollPane);
        
        panel.setLayout(boxlayout);

        return panel;

    }

    private JPanel getService3Method2JPanel(){
        //method 2
    	JPanel panel = new JPanel();
        BoxLayout boxlayout = new BoxLayout(panel, BoxLayout.X_AXIS);
        

        JLabel label1 = new JLabel("Service 3.2: custName");
        panel.add(label1);
        panel.add(Box.createRigidArea(new Dimension(10, 0)));
        entry8_1 = new JTextField("",10);
        panel.add(entry8_1);
        panel.add(Box.createRigidArea(new Dimension(10, 0)));
        JLabel label2 = new JLabel("Amount");
        panel.add(label2);
        panel.add(Box.createRigidArea(new Dimension(10, 0)));
        entry8_2 = new JTextField("",10);
        panel.add(entry8_2);
        panel.add(Box.createRigidArea(new Dimension(10, 0)));

        JButton button = new JButton("generateInvoice");
        button.addActionListener(this);
        //button.setPreferredSize(new Dimension(168, button.getPreferredSize().height));
        panel.add(button);
        panel.add(Box.createRigidArea(new Dimension(10, 0)));

        reply8 = new JTextArea(3,20);
        reply8.setLineWrap(true);
        reply8.setWrapStyleWord(true);
        reply8.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(reply8);
        panel.add(scrollPane);
        
        panel.setLayout(boxlayout);

        return panel;

    }

    private JPanel getService3Method3JPanel(){
        //method 3
    	JPanel panel = new JPanel();
        BoxLayout boxlayout = new BoxLayout(panel, BoxLayout.X_AXIS);
        

        JLabel label1 = new JLabel("Service 3.3: custName");
        panel.add(label1);
        panel.add(Box.createRigidArea(new Dimension(10, 0)));
        entry9_1 = new JTextField("",10);
        panel.add(entry9_1);
        panel.add(Box.createRigidArea(new Dimension(10, 0)));
        JLabel label2 = new JLabel("RideID");
        panel.add(label2);
        panel.add(Box.createRigidArea(new Dimension(10, 0)));
        entry9_2 = new JTextField("",10);
        panel.add(entry9_2);
        panel.add(Box.createRigidArea(new Dimension(10, 0)));
        JLabel label3 = new JLabel("Amount");
        panel.add(label3);
        panel.add(Box.createRigidArea(new Dimension(10, 0)));
        entry9_3 = new JTextField("",10);
        panel.add(entry9_3);
        panel.add(Box.createRigidArea(new Dimension(10, 0)));

        JButton button = new JButton("handleRefunds");
        button.addActionListener(this);
        //button.setPreferredSize(new Dimension(168, button.getPreferredSize().height));
        panel.add(button);
        panel.add(Box.createRigidArea(new Dimension(10, 0)));

        reply9 = new JTextArea(3,20);
        reply9.setLineWrap(true);
        reply9.setWrapStyleWord(true);
        reply9.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(reply9);
        panel.add(scrollPane);
        
        panel.setLayout(boxlayout);
        

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
	                	InetAddress[] addresses = service1Info.getInetAddresses();
	                	String host = addresses[0].getHostAddress();
	                	int port = service1Info.getPort();
	                	ManagedChannel channel = ManagedChannelBuilder.forAddress(host, port)
	                			                 .usePlaintext()
	                			                 .build();
	                	try {
							FleetManagementBlockingStub blockingStub1 = FleetManagementGrpc.newBlockingStub(channel);
							FleetManagementStub asyncStub1 = FleetManagementGrpc.newStub(channel);
						} finally {
							channel.shutdown();
						}
	                    
	                }else if(service_type.equals("_service2._tcp.local.")){
	                	System.out.println("Service 2 resolved: " + event.getInfo());
	                	ServiceInfo service2Info = event.getInfo();
	                	InetAddress[] addresses =service2Info.getInetAddresses();
	                	String host = addresses[0].getHostAddress();
	                	int port = service2Info.getPort();
	                	ManagedChannel channel = ManagedChannelBuilder.forAddress(host, port)
	                			                 .usePlaintext()
	                			                 .build();
	                	try {
							CustomerServiceBlockingStub blockingStub2 = CustomerServiceGrpc.newBlockingStub(channel);
							CustomerServiceStub asyncStub2 = CustomerServiceGrpc.newStub(channel);
						} finally {
							channel.shutdown();
						}
	                }else if(service_type.equals("_service3._tcp.local.")) {
	                	System.out.println("Service 3 resolved: " + event.getInfo());
	                	ServiceInfo service3Info = event.getInfo();
	                	InetAddress[] addresses = service3Info.getInetAddresses();
	                	String host = addresses[0].getHostAddress();
	                	int port = service3Info.getPort();
	                	ManagedChannel channel = ManagedChannelBuilder.forAddress(host, port)
	                			                 .usePlaintext()
	                			                 .build();
	                	try {
							PaymentSystemBlockingStub blockingStub3 = PaymentSystemGrpc.newBlockingStub(channel);
							PaymentSystemStub asyncStub3 = PaymentSystemGrpc.newStub(channel);
						} finally {
							channel.shutdown();
						}
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
			Thread.sleep(1000);
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
			
		panel.add( getService1Method1JPanel() );
		panel.add( getService1Method2JPanel() );
		panel.add( getService1Method3JPanel() );
		panel.add( getService2Method1JPanel() );
		panel.add( getService2Method2JPanel() );
		panel.add( getService2Method3JPanel() );
		panel.add( getService3Method1JPanel() );
		panel.add( getService3Method2JPanel() );
		panel.add( getService3Method3JPanel() );

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

		/*if (label.equals("Invoke Service 1")) {
			System.out.println("Service 1 to be invoked ...");*/
			
            if (label.equals("addVehicle")) { 
            	System.out.println("service 1 method 1 to be invoked ...");
            	ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 50051).usePlaintext().build();
    			FleetManagementGrpc.FleetManagementBlockingStub blockingStub = FleetManagementGrpc.newBlockingStub(channel);

    			//Deadline deadline = Deadline.after(1, TimeUnit.SECONDS);
    			//Context.CancellableContext cancellableContext = Context.current().withDeadline(deadline, null);
    			
    			//Metadata headers = new Metadata();
    			//headers.put(Metadata.Key.of("Authorization", Metadata.ASCII_STRING_MARSHALLER), "Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9");
    			try {
    				//blockingStub = blockingStub.withDeadline(cancellableContext.getDeadline());
    				//blockingStub = MetadataUtils.attachHeaders(blockingStub, headers);
    				//addVehicle method          1 VS 1
        			//preparing message to send
					ds.service1.AddRequest request = ds.service1.AddRequest.newBuilder().setTargetCapacity(entry1.getText()).build();

					//retrieving reply from service
					ds.service1.AddResponse response = blockingStub.addVehicle(request);
					
					//displaying the response to the user
					reply1.setText(response.getVehicleID());
				} catch (StatusRuntimeException e1) {
					if(e1.getStatus()==Status.UNAVAILABLE) {
						System.out.println("Error: Service is unavailable.");
					}else if(e1.getStatus()==Status.NOT_FOUND) {
						System.out.println("Error: Method is not found.");
					}else {
						System.out.println("Error: " + e1.getStatus());
					}
				}finally {
					try {
						/*if(!cancellableContext.isCancelled()) {
							cancellableContext.cancel(new Exception("Client cancelled the request"));
						}*/
						channel.shutdown().awaitTermination(5, TimeUnit.SECONDS);
					}catch(InterruptedException e1) {
						e1.printStackTrace();
					}
				}
            
            }else if (label.equals("removeVehicle")) {
            	System.out.println("service 1 method 2 to be invoked ...");
            	ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 50051).usePlaintext().build();
    			FleetManagementGrpc.FleetManagementBlockingStub blockingStub = FleetManagementGrpc.newBlockingStub(channel);
    			try {
					//removeVehicle method             1 VS 1
					//preparing message to send
					ds.service1.RemoveRequest request = ds.service1.RemoveRequest.newBuilder().setCapacity(entry2.getText()).build();
					
					//retrieving reply from service			
					ds.service1.RemoveResponse response = blockingStub.removeVehicle(request);
					
					//displaying the response to the user
					reply2.setText(response.getVehicleID());
				} catch (StatusRuntimeException e1) {
					if(e1.getStatus()==Status.UNAVAILABLE) {
						System.out.println("Error: Service is unavailable.");
					}else if(e1.getStatus()==Status.NOT_FOUND) {
						System.out.println("Error: Method is not found.");
					}else {
						System.out.println("Error: " + e1.getStatus());
					}
				}finally {
					try {
						channel.shutdown().awaitTermination(5, TimeUnit.SECONDS);
					}catch(InterruptedException e1) {
						e1.printStackTrace();
					}
				}
            }else if (label.equals("getVehicleStatus")) {   
            	System.out.println("service 1 method 3 to be invoked ...");
            	ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 50051).usePlaintext().build();
    			FleetManagementGrpc.FleetManagementStub asyncStub = FleetManagementGrpc.newStub(channel);
    			//getVehicleStatus method             1 VS 2
    			ds.service1.StatusRequest request = ds.service1.StatusRequest.newBuilder().setVehicleID(entry3.getText()).build();
    			StreamObserver<StatusResponse> responseObserver = new StreamObserver<StatusResponse>(){
    				@Override
    				public void onNext(StatusResponse response) {
    					reply3.setText(response.getCurrentLocation() + response.getCurrentSpeed());
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
    			
    			asyncStub.getVehicleStatus(request, responseObserver);
    			
    			try {
    				Thread.sleep(1000);
    			} catch (InterruptedException e1) {
    				// TODO Auto-generated catch block
    				e1.printStackTrace();
    			} finally {
    				try {
    					channel.shutdown().awaitTermination(5, TimeUnit.SECONDS);
    				} catch (InterruptedException el) {
    					el.printStackTrace();
    				}
    			}
    			
    			
            //}
			
		/*}else if (label.equals("Invoke Service 2")) {
			System.out.println("Service 2 to be invoked ...");*/
			
            }else if (label.equals("bookRide")) {
            	System.out.println("service 2 method 1 to be invoked ...");
				ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 50052).usePlaintext().build();
				CustomerServiceGrpc.CustomerServiceStub stub = CustomerServiceGrpc.newStub(channel);
				//bookRide method                     2 VS 1
				StreamObserver<BookRequest> requestObserver = stub.bookRide(new StreamObserver<BookResponse>() {
					@Override
					public void onNext(BookResponse response) {
						reply4.setText(response.getConfirmMessage());
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
				
				requestObserver.onNext(BookRequest.newBuilder().setCurrentLocation(entry4_1.getText()).setDestination(entry4_2.getText()).build());
				requestObserver.onCompleted();
				
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} finally {
					try {
						channel.shutdown().awaitTermination(5, TimeUnit.SECONDS);
					}catch(InterruptedException e1) {
						e1.printStackTrace();
					}
				}
				
			}else if (label.equals("cancelRide")) {
				System.out.println("service 2 method 2 to be invoked ...");
				ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 50052).usePlaintext().build();
				CustomerServiceGrpc.CustomerServiceBlockingStub blockingStub = CustomerServiceGrpc.newBlockingStub(channel);
				try {
					//cancelRide method               1 VS 1
					ds.service2.CancelRequest request = ds.service2.CancelRequest.newBuilder().setRideID(entry5.getText()).build();
										
					ds.service2.CancelResponse response = blockingStub.cancelRide(request);
					
					reply5.setText(response.getStatus());
				} catch (StatusRuntimeException e1) {
					if(e1.getStatus()==Status.UNAVAILABLE) {
						System.out.println("Error: Service is unavailable.");
					}else if(e1.getStatus()==Status.NOT_FOUND) {
						System.out.println("Error: Method is not found.");
					}else {
						System.out.println("Error: " + e1.getStatus());
					}
				}finally {
					try {
						channel.shutdown().awaitTermination(5, TimeUnit.SECONDS);
					}catch(InterruptedException e1) {
						e1.printStackTrace();
					}
				}
				
			}else if (label.equals("getRideInfo")){	
				System.out.println("service 2 method 3 to be invoked ...");
				ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 50052).usePlaintext().build();
				CustomerServiceGrpc.CustomerServiceStub asyncStub = CustomerServiceGrpc.newStub(channel);
				//getRideInfo method             1 VS 2
				ds.service2.InfoRequest request = ds.service2.InfoRequest.newBuilder().setRideID(entry6.getText()).build();
				StreamObserver<InfoResponse> responseObserver = new StreamObserver<InfoResponse>(){
					@Override
					public void onNext(InfoResponse response) {
						reply6.setText(response.getStartingLocation() + response.getDestination());
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
				
				asyncStub.getRideInfo(request, responseObserver);
				
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} finally {
					try {
						channel.shutdown().awaitTermination(5, TimeUnit.SECONDS);
					}catch(InterruptedException e1) {
						e1.printStackTrace();
					}
				}
			//}
						
		/*}else if (label.equals("Invoke Service 3")) {
			System.out.println("Service 3 to be invoked ...");*/
			
			}else if (label.equals("processPayment")) {
				System.out.println("service 3 method 1 to be invoked ...");
				ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 50053).usePlaintext().build();
				PaymentSystemGrpc.PaymentSystemBlockingStub blockingStub = PaymentSystemGrpc.newBlockingStub(channel);
				try {
					//processPayment method            1 VS 1
					double payment = Double.parseDouble(entry7.getText());
					ds.service3.PaymentRequest request = ds.service3.PaymentRequest.newBuilder().setPayment(payment).build();			
					
					ds.service3.PaymentResponse response = blockingStub.processPayment(request);

					reply7.setText(response.getConfirmMessage());
				} catch (StatusRuntimeException e1) {
					if(e1.getStatus()==Status.UNAVAILABLE) {
						System.out.println("Error: Service is unavailable.");
					}else if(e1.getStatus()==Status.NOT_FOUND) {
						System.out.println("Error: Method is not found.");
					}else {
						System.out.println("Error: " + e1.getStatus());
					}
				}finally {
					try {
						channel.shutdown().awaitTermination(5, TimeUnit.SECONDS);
					}catch(InterruptedException e1) {
						e1.printStackTrace();
					}
				}
				
			}else if (label.equals("generateInvoice")) {
				System.out.println("service 3 method 2 to be invoked ...");
				ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 50053).usePlaintext().build();
				PaymentSystemGrpc.PaymentSystemStub asyncStub = PaymentSystemGrpc.newStub(channel);
				//generateInvoice method           2 VS 2

				StreamObserver<InvoiceResponse> responseObserver = new StreamObserver<InvoiceResponse>(){
					@Override
					public void onNext(InvoiceResponse response) {
						reply8.setText(response.getInvoiceID() + response.getConfirmMessage());
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
				StreamObserver<InvoiceRequest> requestObserver = asyncStub.generateInvoice(responseObserver);
				double amount = Double.parseDouble(entry8_2.getText());
				ds.service3.InvoiceRequest request = ds.service3.InvoiceRequest.newBuilder()
						                              .setCustomerName(entry8_1.getText())
						                              .setAmount(amount)
						                              .build(); 
				try {

					requestObserver.onNext(request);

					// Mark the end of requests
					requestObserver.onCompleted();
					Thread.sleep(1000);

				} catch (RuntimeException e1) {
					e1.printStackTrace();
				} catch (InterruptedException e1) {			
					e1.printStackTrace();
				} finally {
					try {
						channel.shutdown().awaitTermination(5, TimeUnit.SECONDS);
					}catch(InterruptedException e1) {
						e1.printStackTrace();
					}
				}
				
			}else if (label.equals("handleRefunds")) {
				System.out.println("service 3 method 3 to be invoked ...");
				ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 50053).usePlaintext().build();
				PaymentSystemGrpc.PaymentSystemStub asyncStub = PaymentSystemGrpc.newStub(channel);
				//handleRefunds method              3 VS 2
				StreamObserver<RefundsResponse> responseObserver = new StreamObserver<RefundsResponse>(){
					@Override
					public void onNext(RefundsResponse response) {
						reply9.setText(response.getConfirmMessage() + response.getRefundID());
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
				double amount = Double.parseDouble(entry9_3.getText());
				ds.service3.RefundsRequest request = ds.service3.RefundsRequest.newBuilder()
						                              .setCustomerName(entry9_1.getText())
						                              .setRideID(entry9_2.getText())
						                              .setAmount(amount)
						                              .build(); 
				try {

					requestObserver.onNext(request);

					// Mark the end of requests
					requestObserver.onCompleted();
					Thread.sleep(1000);

				} catch (RuntimeException e1) {
					e1.printStackTrace();
				} catch (InterruptedException e1) {			
					e1.printStackTrace();
				} finally {
					try {
						channel.shutdown().awaitTermination(5, TimeUnit.SECONDS);
					}catch(InterruptedException e1) {
						e1.printStackTrace();
					}
				}
				
				
			//}
		
		}else{
			
		     }
	}
}
