package com.masai.Main;

import com.masai.Exceptions.BusException;
import com.masai.Exceptions.TicketException;

public class Main {

	public static void main(String[] args) {
		System.out.println("--------------- Welcome to Yatin's Bus Ticket Reservation System ---------------");
		try {
			try {
				BTRS.selectOption();
			} catch (TicketException e) {
				e.printStackTrace();
			}
		} catch (BusException e) {
			System.out.println(e.getMessage());
		}
	}
}
