package com.masai.Main;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Scanner;

import com.masai.Admin.AdminIntr;
import com.masai.Admin.Adminimpl;
import com.masai.Exceptions.AdminException;
import com.masai.Exceptions.BusException;
import com.masai.Exceptions.TicketException;
import com.masai.UseCases.CustomerLoginUseCase;
import com.masai.bean.Bus;
import com.masai.bean.Customer;
import com.masai.bean.CustomerDTO;

import BusDAO.BusImpl;
import BusDAO.BusIntr;

public class BTRS {

    static SimpleDateFormat myFormat = new SimpleDateFormat("dd MM yyyy");

    public static void selectOption() throws BusException, TicketException {
        Scanner sc = new Scanner(System.in);
        AdminIntr ad = new Adminimpl();
        BusIntr bs = new BusImpl();

        System.out.println("\n Please Select a Option to Continue: ");
        System.out.println("1. Login As Admin");
        System.out.println("2. Login As Customer");
        int ch = sc.nextInt();
        switch (ch) {
            case 1: {
                System.out.println("Please Enter your Username :");
                String username = sc.next();

                System.out.println("Please Enter your Password");
                String password = sc.next();
                try {

                    boolean ans = ad.login(username, password);

                    if (ans) {
                        System.out.println("Login Success !");
                        System.out.println("Welcome To Admin Panel : " + username);
                        System.out.println("1 : Add a New Bus");
                        System.out.println("2 : Show all Buses:");
                        System.out.println("3 : Contact Persons Details After Confirmation of the Seat");
                        System.out.println("4 : Confirmation of the Seat to the Customer");
                        System.out.println("5 : exit()");

                        int x = sc.nextInt();
                        while (x != 5) {
                            if (x == 1) {
                                System.out.println("Please Enter your Bus No: ");
                                int bno = sc.nextInt();
                                System.out.println("Please Enter your Bus Name: ");
                                String bname = sc.next();
                                System.out.println("Please Enter your Bus Route: ");
                                String broute = sc.next();
                                System.out.println("Please Enter your Bus Type (Ac OR NonAC): ");
                                String btype = sc.next();
                                System.out.println("Please Enter your Seat Number:");
                                int seat = sc.nextInt();

                                System.out.println("Please Enter your Source:");
                                String source = sc.next();
                                System.out.println("Please Enter your Bus Destination:");
                                String des = sc.next();

                                Bus bus = new Bus();
                                bus.setBusNo(bno);
                                bus.setBusname(bname);
                                bus.setBusRoute(broute);
                                bus.setBusType(btype);
                                bus.setSeat(seat);
                                bus.setSource(source);
                                bus.setDestination(des);

                                String result = ad.registerbus(bus);
                                System.out.println(result);

                            } else if (x == 2) {
                                List<Bus> l1 = ad.showBus();
                                if (l1.size() != 0) {
                                    l1.forEach(b -> {

                                        System.out.println("Your Bus No is :" + b.getBusNo());
                                        System.out.println("Your Bus Name is: " + b.getBusname());
                                        System.out.println("Your Bus Route is: " + b.getBusRoute());
                                        System.out.println("Your Bus Type is: " + b.getBusType());
                                        System.out.println("Your Bus Seat is: " + b.getSeat());
                                        System.out.println("Your Bus departure Time is: " + b.getDeparturetime());
                                        System.out.println("Your Bus arrive Time is: " + b.getArriveTime());
                                        System.out.println("Your Bus Date Time is: " + b.getDate());

                                        System.out.println("=======================");
                                    });
                                } else {
                                    System.out.println("No Bus is Avalible");
                                }

                            } else if (x == 3) {

                                String b = sc.next();
                                List<CustomerDTO> l1 = ad.confirmation(b);

                                if (l1.size() != 0) {
                                    l1.forEach(cb -> {
                                        System.out.println("Bus No is : " + cb.getBno());

                                        System.out.println("Bus Name is: " + cb.getBusname());

                                        System.out.println("Avalibale Seat is: " + cb.getSeat());
                                        System.out.println("Customer Name is: " + cb.getCn());
                                        System.out.println("Cutomer Address is: " + cb.getA());

                                        System.out.println("Customer Mobile is: " + cb.getM());

                                        System.out.println("=============================================");
                                    });
                                } else {
                                    System.out.println("No Customer Found!!");
                                }


                            } else if (x == 4) {
                                List<CustomerDTO> l1 = ad.conformationSeat();
                                if (l1.size() != 0) {
                                    l1.forEach(cx -> {
                                        System.out.println("Bus No is :" + cx.getBno());

                                        System.out.println("Bus Name is: " + cx.getBusname());

                                        System.out.println("Avalibale Seat is: " + cx.getSeat());
                                        System.out.println("Customer Name is: " + cx.getCn() + " " + " Sucessfully booked");
                                        System.out.println("Cutomer Address is: " + cx.getA());
                                        System.out.println("Customer Mobile is: " + cx.getM());

                                        System.out.println("=============================================");
                                    });
                                } else {
                                    System.out.println("Doesn't Book any Ticket!!");
                                }


                            } else if (x == 5) {

                            } else {
                                System.out.println("Please select a valid option.");

                            }
                            System.out.println("Welcome To Admin: " + username);
                            System.out.println("1 : add a new Bus ");
                            System.out.println("2 : Show all buses: ");
                            System.out.println("3 : Contact persons details after confirmation of the seat ");
                            System.out.println("4 : Confirmation of the seat to the Customer ");
                            System.out.println("5 : exit() ");
                            x = sc.nextInt();
                        }

                    } else {
                        System.out.println("Wrong Username and Password");
                    }
                    System.out.println("\n 1. Login As Admin.\n 2.Login As Customer.");
                    ch = sc.nextInt();

                } catch (AdminException e) {

                    System.out.println(e.getMessage());
                }
                break;

            }

            //Customer Login
            case 2: {
                System.out.println("Welcome: ");
                System.out.println("1 : Register As Customer ");
                System.out.println("2 : See all available Bus list ");
                System.out.println("3 : Book  ticket by selecting Source and destination ");
                System.out.println("4 : Cancel ticket ");
                System.out.println("5 : Exit() ");
                int num = sc.nextInt();


                while (num != 5) {
                    if (num == 1) {
                        System.out.println("Enter Customer id:");
                        int id = sc.nextInt();
                        System.out.println("Enter Customer Name");
                        String name = sc.next();
                        System.out.println("Enter Customer Address");
                        String add = sc.next();
                        System.out.println("Enter Customer Mobile Number");
                        String mob = sc.next();
                        System.out.println("Enter Source");
                        String s = sc.next();
                        System.out.println("Enter Destination.");
                        String d = sc.next();
                        Customer c = new Customer(id, name, add, mob, s, d);
                        CustomerLoginUseCase cl = new CustomerLoginUseCase();
                        String str = cl.LoginCustomer(c);
                        System.out.println(str);
                    } else if (num == 2) {

                        List<Bus> l1 = ad.showBus();
                        l1.forEach(b -> {

                            System.out.println("Bus No is :" + b.getBusNo());
                            System.out.println("Bus Name is: " + b.getBusname());
                            System.out.println("Bus Route is: " + b.getBusRoute());
                            System.out.println("Bus Type is: " + b.getBusType());
                            System.out.println("Bus Seat is: " + b.getSeat());
                            System.out.println("Bus departure Time is: " + b.getDeparturetime());
                            System.out.println("Bus arrive Time is: " + b.getArriveTime());
                            System.out.println("Bus Date Time is: " + b.getDate());

                            System.out.println("=======================");
                        });
                    } else if (num == 3) {

                        System.out.println("Enter Source: ");
                        String source = sc.next();
                        System.out.println("Enter Destination ");
                        String des = sc.next();
                        System.out.println("Enter Customer Id: ");
                        int cid = sc.nextInt();
                        System.out.println("Enter BusNo: ");
                        int bno = sc.nextInt();
                        System.out.println("Enter No of seat you want to book: ");
                        int ticket = sc.nextInt();
                        String ans = bs.bookTicket(source, des, cid, bno, ticket);
                        System.out.println(ans);
                        if (ans.equals("Your Ticket is Booked Sucessfully...")) {


                            CustomerLoginUseCase xx = new CustomerLoginUseCase();
                            List<CustomerDTO> d = xx.avalibleTicket();
                            d.forEach(c -> {
                                System.out.println("Bus No is : " + c.getBno());


                                System.out.println("Avalibale  Seat is: " + c.getSeat());

                                String str = xx.UpdateSeat(c.getBno(), c.getSeat());
                                System.out.println("=============================================");
                            });
                        }

                    } else if (num == 4) {
                        System.out.println("Enter Customer_id ");
                        int id = sc.nextInt();
                        bs.cancelTicket(id);
                    } else if (num == 5) {

                    } else {
                        System.out.println("Please select a valid option ");
                    }
                    System.out.println();
                    System.out.println("1 : Register As Customer.");
                    System.out.println("2 : See all available Bus list.");
                    System.out.println("3 : Book  ticket by selecting Source and destination");
                    System.out.println("4 : Cancel ticket");
                    System.out.println("5 : Exit() ");
                    num = sc.nextInt();
                }
            }

            System.out.println("Please Enter a Valid Choice !!");
        }
    }
}
