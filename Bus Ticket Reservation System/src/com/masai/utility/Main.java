package com.masai.utility;

import java.sql.Connection;

public class Main {
	public static void main(String[] args) {

		Connection connection = DBUtil.provideConnection();

		if (connection != null) {
			System.out.println("Connection Established Successfully");
		}
	}
}