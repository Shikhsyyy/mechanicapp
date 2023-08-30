package com.mechanicapp;

import java.util.Date;

import java.sql.SQLException;
 
import java.text.ParseException;
import java.text.SimpleDateFormat;
 
import java.util.List;
import java.util.Scanner;

import com.mechanicapp.dao.ClientDao;
import com.mechanicapp.dao.impl.ClientDaoImpl;
import com.mechanicapp.exception.AppointmentNotFoundException;
import com.mechanicapp.exception.ClientNotFoundException;
import com.mechanicapp.model.Appointment;
import com.mechanicapp.model.Client;

public class ClientManagementApp {
    
	private static ClientDao dao = new ClientDaoImpl();
    private static Scanner scanner = new Scanner(System.in);
    
    public static void main(String[] args) throws ParseException {
        
    	while (true) {
    		System.out.println("Welcome to Mechanic Appointment Management System");
    		
            System.out.println("Enter Your choice");
            System.out.println("PRESS 1 FOR CUSTOMER MENU");
            System.out.println("PRESS 2 FOR APPOINTMENT MENU"); // complete
            System.out.println("PRESS 8 TO EXIT ");
            
            int choice = Integer.parseInt(scanner.nextLine());
            
            switch (choice) {
            
                case 1:
                	System.out.println("HELP US SERVE YOU BETTER!");
                    System.out.println("****PLS ENTER YOUR CHOICE FROM THE CUSTOMER MENU***");
                    System.out.println("PRESS 1 FOR Registration");
                    System.out.println("PRESS 2 FOR  Viewing Single Record");
                    System.out.println("PRESS 3 FOR  Deleting a Record");
                    System.out.println("PRESS 4 FOR Modifying a record");
                    System.out.println("PRESS 5 FOR Viewing all records ");
                    System.out.println("PRESS 6 TO EXIT");
                    
                    int CUSTCHOICE = Integer.parseInt(scanner.nextLine());
                    
                    switch (CUSTCHOICE) {
                    
                     
                    case 1:
                            System.out.println("****WELCOME ONBOARD! Customer registeration begins!***");
                            regClient();
                            System.out.println("**** Registration Ended***");
                            break;
                      
                    case 2:
                            System.out.println("**** single Record ***");
                            findById();
                            System.out.println("**** Display Single Record **");
                            break;
                    
                    case 3:
                            System.out.println("**** Delete Record***");
                            delete();
                            System.out.println("**** Delete Record***");
                            break;
                        
                    case 4:
                        	System.out.println("**** UPDATE Choice***");
                            System.out.println("1. First Name");
                            System.out.println("2. Last Name");
                            System.out.println("3. Address");
                            System.out.println("4. Mobile No");
                            System.out.println("5. Email ID");
                            System.out.println("6. Exit");
                            
                            int UpdateChoice = Integer.parseInt(scanner.nextLine());
                            
                            switch (UpdateChoice) {
                            
                            case 1:
                                    System.out.println("**** Update First Name***");
                                    updateFirstName();
                                    break;
                                
                            case 2:
                                    System.out.println("**** Update Last Name***");
                                    updateLastName();
                                    break;
                                
                            case 3:
                                    System.out.println("**** Update Address***");
                                    updateAddress();
                                    break;
                                
                            case 4:
                                    System.out.println("**** Update Mobile No***");
                                    updateMobileNo();
                                    break;
                                
                            case 5:
                    	               System.out.println("**** Update Email ID***");
                                       updateEmailId();
                                          break;
                                
                             case 6:
                                      break;
                              default:
                        	    System.exit(0);
                        	}
                            break;
                        
                    case 5:
                            System.out.println("**** Displaying All records***");
                            displayAllClient();
                            System.out.println("**** Displaying  All records **");
                            break;
                        
                        
                    case 6:
                            System.exit(0);
                        default:
                            System.exit(0);
                    }
                    break;
                
                case 2: //press 2 in main menu
                    System.out.println("**** APPOINTMENT MENU***");
                    System.out.println("1. Book An Appointment");
                    System.out.println("2. Modify Appointment Details");
                    System.out.println("3. Delete An Appointment");
                    System.out.println("4. View Single Record");
                    System.out.println("5. View All Record");
                    System.out.println("6. Exit");
                    
                    int AppointmentChoice = Integer.parseInt(scanner.nextLine());
                    
                    switch (AppointmentChoice) {
                        
                        case 1:
                            System.out.println("****Welcome!! pls proceed to book an  Book An Appointment ***");
                            bookAppointment();
                            System.out.println("**** Book An Appointment ***");
                             break;
                        
                        case 2:
                            System.out.println("**** Modify Appointment Details ***");
                            System.out.println("**** Pls enter your Choice***");
                            System.out.println("PRESS 1 TO Modify Appointment Date");
                            System.out.println("PRESS 2 TO  Modify Location");
                            System.out.println("PRESS 3 TO Modify Vehicle Name");
                            System.out.println("PRESS 4 TO Modify Vehicle Number");
                            System.out.println("PRESS 5 TO Modify Customer Name");
                            System.out.println("PRESS 6 TO  Modify Service Type");
                            System.out.println("PRESS 7 TO  Modify Additional Info");
                            System.out.println("PRESS 8 TO EXIT");
                            
                            int AppointmentModify = Integer.parseInt(scanner.nextLine());
                            
                            switch(AppointmentModify) {
                            
                            case 1: 
                            	System.out.println("--------Modify Date--------");
                            	updateAppointmentDate();
                            	System.out.println("--------Modify Date---------");
                            	break;
                            
                            case 2: 
                            	System.out.println("--------Modify Location---------");
                            	updateLocation();
                            	System.out.println("--------Modify Location---------");
                            	break;
                            
                            case 3:
                            	System.out.println("--------Modify Vehicle Name---------");
                            	updateVehiclename();
                            	System.out.println("--------Modify Vehicle Name---------");
                            	break;
                            	
                            case 4:
                            	System.out.println("--------Modify Vehicle Number---------");
                            	updateVehiclenumber();
                            	System.out.println("--------Modify Vehicle Number---------");
                            	break;
                            
                            case 5:
                            	System.out.println("--------Modify Customer Name---------");
                            	updateCustomerName();
                            	System.out.println("--------Modify Customer Name---------");
                            	break;
                            	
                            case 6:
                            	System.out.println("--------Modify Service Type CLEANING OR REPAIR OR ACCIDENTAL DAMAGE---------");
                            	updateServiceType();
                            	System.out.println("--------Modify Service Type---------");
                            	break;
                            	
                            case 7:
                            	System.out.println("--------Modify Additional Info---------");
                            	updateAdditionalInfo();
                            	System.out.println("--------Modify Additional Info---------");
                            	break;
                            case 8:
                                System.exit(0);
                            default:
                                System.exit(0);
                        }
                          
                             break;
                        
                        case 3:
                            System.out.println("**** Delete An Appointment***");
                            deleteappointment();
                            System.out.println("**** Delete An Appointment***");
                             break;
                        
                        case 4:
                            System.out.println("**** View Single Record ***");
                            appointmentfindById();
                            System.out.println("**** View Single Record ***");
                             break;
                        
                        case 5:
                            System.out.println("**** View All Record ***");
                            displayAllAppointment();
                            System.out.println("**** View All Record ***");
                             break;
                        
                        
                        case 6:
                            System.exit(0);
                        default:
                            System.exit(0);
                    }
                    break;
                
                 case 8:
                    System.exit(0);
                default:
                    System.exit(0);
            }
        }
    }

    private static void regClient() {
    	System.out.println("\nEnter First Name:");
        String firstName = scanner.nextLine();
        System.out.println("\nEnter Last Name:");
        String lastName = scanner.nextLine();
        System.out.println("\nEnter Address:");
        String address = scanner.nextLine();
        System.out.println("\nEnter Emailid:");
        String emailid = scanner.nextLine(); 
        System.out.println("\nEnter MobileNo:");
        long mobileno = Long.parseLong(scanner.nextLine());
        
        Client client = new Client(firstName, lastName, address, emailid, mobileno);
        
        try {
            if (dao.insert(client)) {
                System.out.println("Registration Successful");
            }
        } catch (SQLException e) {
            System.err.println(e);
        }
    }

    private static void findById() { 
    	System.out.println("\nEnter Id:");
    	int clientId = Integer.parseInt(scanner.nextLine());
        
    	try {
            Client findById = dao.findById(clientId);
            System.out.println(findById);
        } catch (ClientNotFoundException | SQLException e) {
            System.err.println(e);
        }
    }

    private static void displayAllClient() {
    	try {
            List<Client> displayAllClient = dao.displayAllClient();
            for (Client client : displayAllClient) {
                System.out.println(client);
            }
        } catch (SQLException e) {
            System.err.println(e);
        }
    }
    
    private static void updateFirstName() {
        System.out.println("\nEnter Customer Id:");
        int clientId = Integer.parseInt(scanner.nextLine());
        
        System.out.println("\nEnter New First Name:");
        String firstName = scanner.nextLine();

        try {
            Client client = dao.findById(clientId);
            client.setFirstName(firstName);
            
            if (dao.update(client)) {
                System.out.println("First Name Update Successfully");
            }
        } catch (ClientNotFoundException | SQLException e) {
            System.err.println(e);
        }
    }
    
    private static void updateLastName() {
        System.out.println("\nEnter Client Id:");
        int clientId = Integer.parseInt(scanner.nextLine());
        System.out.println("\nEnter New Last Name:");
        String lastName = scanner.nextLine();

        try {
            Client client = dao.findById(clientId);
            client.setLastName(lastName);

            if (dao.update(client)) {
                System.out.println("Update Successfully");
            }
        } catch (ClientNotFoundException | SQLException e) {
            System.err.println(e);
        }
    }
    
    private static void updateAddress() {
        System.out.println("\nEnter Client Id:");
        int clientId = Integer.parseInt(scanner.nextLine());
        System.out.println("\nEnter New Address:");
        String address = scanner.nextLine();

        try {
            Client client = dao.findById(clientId);
            client.setAddress(address);

            if (dao.update(client)) {
                System.out.println("Update Successfully");
            }
        } catch (ClientNotFoundException | SQLException e) {
            System.err.println(e);
        }
    }
    
    private static void updateMobileNo() {
        System.out.println("\nEnter Client Id:");
        int clientId = Integer.parseInt(scanner.nextLine());
        System.out.println("\nEnter New Mobile No:");
        Long mobileNo = Long.parseLong(scanner.nextLine());

        try {
            Client client = dao.findById(clientId);
            client.setMobileNo(mobileNo);

            if (dao.update(client)) {
                System.out.println("Update Successfully");
            }
        } catch (ClientNotFoundException | SQLException e) {
            System.err.println(e);
        }
    }
    
    private static void updateEmailId() {
        System.out.println("\nEnter Client Id:");
        int clientId = Integer.parseInt(scanner.nextLine());
        System.out.println("\nEnter New Emailid:");
        String emailid = scanner.nextLine();

        try {
            Client client = dao.findById(clientId);
            client.setEmailid(emailid);

            if (dao.update(client)) {
                System.out.println("Update Successfully");
            }
        } catch (ClientNotFoundException | SQLException e) {
            System.err.println(e);
        }
    }
    
    private static void delete() {
    	System.out.println("\n Enter ID:");
        int id = Integer.parseInt(scanner.nextLine());
        Client client = new Client(id);
        
        try {
            if (dao.delete(client)) {
                System.out.println("Deleted");
            }
        } catch (SQLException e) {
            System.err.println(e);
        }

    }
    
    
    public static void bookAppointment() throws ParseException {
    	
    	System.out.println("\nEnter Date: (yyyy-mm-dd)");
    	
    	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd") ;
    	String strDate = scanner.nextLine();
    	Date date = sdf.parse(strDate);
        
    	System.out.println("\nEnter Location:");
        String location = scanner.nextLine();
        
        System.out.println("\nEnter Vehicle Name:");
        String vehiclename = scanner.nextLine();
        
        System.out.println("\nEnter Vehicle Number:");
        String vehiclenumber = scanner.nextLine();
        
        System.out.println("\nEnter Customer Name");
        String customername = scanner.nextLine(); 
        
        System.out.println("\nEnter Service Type: CLEANING OR REPAIR OR ACCIDENTAL DAMAGE ");
        String servicetype = scanner.nextLine();
        
        System.out.println("\nEnter Additional Info:");
        String additionalinfo = scanner.nextLine();
        
        System.out.println("\nEnter Customer ID:");
        int customerid = Integer.parseInt(scanner.nextLine());
        
        Appointment appointment = new Appointment(date, location, vehiclename, vehiclenumber, customername, servicetype, additionalinfo, 2);
        
        try {
            if (dao.insertappointment(appointment)) {
                System.out.println("Appointment Book Successfully");
            }
        } catch (SQLException e) {
            System.err.println(e);
        }
    }
    
    private static void displayAllAppointment() {
    	try {
            List<Appointment> displayAllAppointment = dao.displayAllAppointment();
            for (Appointment appointment : displayAllAppointment) {
                System.out.println(appointment);
            }
        } catch (SQLException e) {
            System.err.println(e);
        }
    }
    
    private static void appointmentfindById() { 
    	System.out.println("\nEnter Customer Id:");
    	int appointmentId = Integer.parseInt(scanner.nextLine());
        
    	try {
            Appointment appointmentfindById = dao.appointmentfindById(appointmentId);
            System.out.println(appointmentfindById);
        } catch (AppointmentNotFoundException | SQLException e) {
            System.err.println(e);
        }
    }
    
    private static void deleteappointment() {
    	System.out.println("\nEnter Customer ID:");
        int id = Integer.parseInt(scanner.nextLine());
        Appointment appointment = new Appointment(id);
        
        try {
            if (dao.deleteappointment(appointment)) {
                System.out.println("Deleted");
            }
        } catch (SQLException e) {
            System.err.println(e);
        }
    }
    
   private static void updateAppointmentDate() throws ParseException {
        System.out.println("\nEnter Customer Id:");
        int appointmentId = Integer.parseInt(scanner.nextLine());
        
        System.out.println("\nEnter New Date:yyyy-MM-dd");
        
       SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd") ;
    	String strDate1 = scanner.nextLine();
    	Date date1 = sdf1.parse(strDate1);

        try {
         Appointment appointment = dao.appointmentfindById(appointmentId);
         appointment.setDate(date1);    
         
          if (dao.updateappointment(appointment)) {
          System.out.println("Date Update Successfully");
           }
        } catch (AppointmentNotFoundException | SQLException e) {
            System.err.println(e);
       }
   }
    
    private static void updateLocation() {
        System.out.println("\nEnter Customer Id:");
        int appointmentId = Integer.parseInt(scanner.nextLine());
        System.out.println("\nEnter New Location:");
        String location = scanner.nextLine();

        try {
            Appointment appointment = dao.appointmentfindById(appointmentId);
            appointment.setLocation(location);

            if (dao.updateappointment(appointment)) {
                System.out.println("Update Successfully");
            }
        } catch (AppointmentNotFoundException | SQLException e) {
            System.err.println(e);
        }
    }
    
    private static void updateVehiclename() {
        System.out.println("\nEnter Customer Id:");
        int appointmentId = Integer.parseInt(scanner.nextLine());
        System.out.println("\nEnter New Vehicle Name:");
        String vehiclename = scanner.nextLine();

        try {
            Appointment appointment = dao.appointmentfindById(appointmentId);
            appointment.setLocation(vehiclename);

            if (dao.updateappointment(appointment)) {
                System.out.println("Update Successfully");
            }
        } catch (AppointmentNotFoundException | SQLException e) {
            System.err.println(e);
        }
    }
    
    private static void updateVehiclenumber() {
        System.out.println("\nEnter Customer Id:");
        int appointmentId = Integer.parseInt(scanner.nextLine());
        System.out.println("\nEnter New Vehicle Number:");
        String vehiclenumber = scanner.nextLine();

        try {
            Appointment appointment = dao.appointmentfindById(appointmentId);
            appointment.setLocation(vehiclenumber);

            if (dao.updateappointment(appointment)) {
                System.out.println("Update Successfully");
            }
        } catch (AppointmentNotFoundException | SQLException e) {
            System.err.println(e);
        }
    }
    
    private static void updateCustomerName() {
        System.out.println("\nEnter Customer Id:");
        int appointmentId = Integer.parseInt(scanner.nextLine());
        System.out.println("\nEnter New Cutomer Name:");
        String customername = scanner.nextLine();

        try {
        	Appointment appointment = dao.appointmentfindById(appointmentId);
        	appointment.setCustomername(customername);

            if (dao.updateappointment(appointment)) {
                System.out.println("Update Successfully");
            }
        } catch (AppointmentNotFoundException | SQLException e) {
            System.err.println(e);
        }
    }
    
    private static void updateServiceType() {
        System.out.println("\nEnter Customer Id:");
        int appointmentId = Integer.parseInt(scanner.nextLine());
        System.out.println("\nEnter New Service Type:CLEANING OR REPAIR OR ACCIDENTAL DAMAGE");
        String servicetype = scanner.nextLine();

        try {
        	Appointment appointment = dao.appointmentfindById(appointmentId);
            appointment.setServicetype(servicetype);

            if (dao.updateappointment(appointment)) {
                System.out.println("Update Successfully");
            }
        } catch (AppointmentNotFoundException | SQLException e) {
            System.err.println(e);
        }
    }
    
    private static void updateAdditionalInfo() {
        System.out.println("\nEnter Customer Id:");
        int appointmentId = Integer.parseInt(scanner.nextLine());
        System.out.println("\nEnter New Additional Info:");
        String additionalinfo = scanner.nextLine();

        try {
        	Appointment appointment = dao.appointmentfindById(appointmentId);
        	appointment.setAdditionalinfo(additionalinfo);

            if (dao.updateappointment(appointment)) {
                System.out.println("Update Successfully");
            }
        } catch (AppointmentNotFoundException | SQLException e) {
            System.err.println(e);
        }
    }

}



