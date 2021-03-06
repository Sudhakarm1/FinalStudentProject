package org.jsp.StuentManagement;

import java.io.File;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
import java.util.Scanner;
import java.util.Random;

public class StudentManagement {
	// Display Method
	public void Display() throws Exception {
		Scanner Sc = new Scanner(System.in);
		Connection Con = null;
		Statement Ptsm = null;
		PreparedStatement Ptsm1 = null;
		Properties Pro = new Properties();
		ResultSet R = null;
		Random rand = new Random();
		try {
			Pro.load(new FileReader(new File("./src/org/jsp/StuentManagement/Test.properties")));
			Class.forName(Pro.getProperty("driver"));
			Con = DriverManager.getConnection(Pro.getProperty("url"), Pro);
			// System.out.println("Pkease Choose your Table Given");
			// System.out.println("1.Student table from KPR");
			// System.out.println("2.Employee table from KPR");
			// System.out.println("3.Default Table from KPR");
			// int Num = Sc.nextInt();
			String Str1 = "student_management_system";
			/*
			 * switch (Num) { case 1: Str1 = "student_management_system"; break; case 2:
			 * Str1 = "Employee_management_system"; break; default: Str1 =
			 * "student_management_system"; break; }
			 */
			Ptsm = Con.createStatement();
			String Str = "SELECT * from " + Str1;
			R = Ptsm.executeQuery(Str);
			System.out.println(
					"-------------------------------------------------------------------------------------------------------------------------------------");
			System.out.println("S_Id" + "\t\t" + "S_Fname" + "\t\t" + "S_Lname" + "\t\t" + "S_Gendar" + "\t\t"
					+ "S_RegNo" + "\t\t" + "S_Fees" + "\t\t" + "S_MobileNo" + "\t\t" + "S_Address");
			System.out.println(
					"------------------------------------------------------------------------------------------------------------------------------------------------");
			while (R.next()) {
				System.out.println(R.getInt(1) + "\t\t" + R.getString(2) + "\t\t" + R.getString(3) + "\t\t"
						+ R.getString(4) + "\t\t\t" + R.getInt(5) + "\t\t" + R.getDouble(6) + "\t\t" + R.getLong(8)
						+ "\t\t" + R.getString(7));
			}
			System.out.println(
					"-------------------------------------------------------------------------------------------------------------------------------------------------");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			R.close();
			Ptsm.close();
			Con.close();
		}
	}

	// Insert Method
	public void DispalyTable() throws Exception {
		Scanner Sc = new Scanner(System.in);
		Connection Con = null;
		PreparedStatement Ptsm = null;
		int Numbers = 0;
		Properties Pro = new Properties();
		try {
			Pro.load(new FileReader(new File("./src/org/jsp/StuentManagement/Test.properties")));
			Class.forName(Pro.getProperty("driver"));
			Con = DriverManager.getConnection(Pro.getProperty("url"), Pro);
			Ptsm = Con.prepareStatement("INSERT INTO student_management_system VALUES(?,?,?,?,?,?,?,?)");
			System.out.println("Enter Number of Rows You want to Insert :");
			System.out.println("-------------------------------------------");
			int Length = Sc.nextInt();
			// S_Id, S_Fname, S_Lname, S_Gendar, S_MobileNo, S_Fees, S_Address
			for (int i = 0; i < Length; i++) {
				System.out.println("Enter Student ID ");
				int Id = Sc.nextInt();
				System.out.println("-------------------------------------------");
				System.out.println("Enter Student First Name");
				String Fname = Sc.next();
				System.out.println("-------------------------------------------");
				System.out.println("Enter Student Last Name");
				String Lname = Sc.next();
				System.out.println("-------------------------------------------");
				System.out.println("Enter Student Gender(F/M)");
				String Gen = Sc.next();
				System.out.println("-------------------------------------------");
				System.out.println("Enter Student Mobile Number(Should Be 10 Digit)");
				long Mno = Sc.nextLong();
				System.out.println("-------------------------------------------");
				String MobileNumber = Mno + "";
				if (MobileNumber.length() == 10) {
					System.out.println("Accepted");
				} else {
					System.out.println("Not Accepted Should Be 10 Digit");
					System.out.println("Enter Student Mobile Number(Should Be 10 Digit)");
					Mno = Sc.nextLong();
				}
				System.out.println("Enter Student Fees");
				double Fee = Sc.nextDouble();
				System.out.println("Enter Student Address");
				String Add = Sc.next();
				int min = 1;
				int max = 1000;
				int Random = (int) (Math.random() * (max - min + 1) + min);
				Ptsm.setInt(1, Id);
				Ptsm.setString(2, Fname);
				Ptsm.setString(3, Lname);
				Ptsm.setString(4, Gen);
				Ptsm.setInt(5, Random);
				Ptsm.setDouble(6, Fee);
				Ptsm.setString(7, Add);
				Ptsm.setLong(8, Mno);
				int Num = Ptsm.executeUpdate();
			}
		} catch (SQLException s) {
			s.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			Ptsm.close();
			Con.close();
		}
	}

	// Update Method
	public void UpdateTable() throws Exception {
		Scanner Sc = new Scanner(System.in);
		Connection Con = null;
		PreparedStatement Ptsm = null;
		int Numbers = 0;
		Properties Pro = new Properties();
		try {
			Pro.load(new FileReader(new File("./src/org/jsp/StuentManagement/Test.properties")));
			Class.forName(Pro.getProperty("driver"));
			Con = DriverManager.getConnection(Pro.getProperty("url"), Pro);
			System.out.println("which Column You are Going to use Operation");
			System.out.println("-------------------------------------------");
			System.out.println("1.ID");
			System.out.println("2.Mobile Number");
			System.out.println("3.Register Number");
			System.out.println("4.First Name");
			System.out.println("5.Address");
			System.out.println("-------------------------------------------");
			int Ch = Sc.nextInt();
			switch (Ch) {
			// Update ID Method
			case 1:
				System.out.println("Please Enter Student ID");
				int ID = Sc.nextInt();
				System.out.println("-------------------------------------");
				System.out.println("Which Colum You are going to Update");
				System.out.println("-------------------------------------");
				System.out.println("1.Fee");
				System.out.println("2.Register Number");
				System.out.println("3.First Name");
				System.out.println("4.Last Name");
				System.out.println("5.Gender");
				System.out.println("6..Address");
				System.out.println("7.Mobile Number");
				System.out.println("------------------------------------");
				int Ch1 = Sc.nextInt();
				switch (Ch1) {
				case 1:
					System.out.println("Please Enter Student Fees");
					double Fee = Sc.nextDouble();
					Ptsm = Con.prepareStatement(
							"UPDATE student_management_system" + " SET S_Fees=" + Fee + " WHERE S_Id=" + ID);
					Numbers = Ptsm.executeUpdate();
					break;
				case 2:
					System.out.println("Please Enter Student RegNo");
					int RegNo = Sc.nextInt();
					Ptsm = Con.prepareStatement(
							"UPDATE student_management_system" + " SET S_RegNo=" + RegNo + " WHERE S_Id=" + ID);
					Numbers = Ptsm.executeUpdate();
					break;
				case 3:
					System.out.println("Please Enter Student First Name");
					String Fname = Sc.next();
					Ptsm = Con.prepareStatement(
							"UPDATE student_management_system" + " SET S_Fname=?" + " WHERE S_Id=" + ID);
					Ptsm.setString(1, Fname);
					Numbers = Ptsm.executeUpdate();
					break;
				case 4:
					System.out.println("Please Enter Student Last name");
					String Lname = Sc.next();
					Ptsm = Con.prepareStatement(
							"UPDATE student_management_system" + " SET S_Lname=?" + " WHERE S_Id=" + ID);
					Ptsm.setString(1, Lname);
					Numbers = Ptsm.executeUpdate();
					break;
				case 5:
					System.out.println("Please Enter Student Gender");
					String Gender = Sc.next();
					Ptsm = Con.prepareStatement(
							"UPDATE student_management_system" + " SET S_Gender=?" + " WHERE S_Id=" + ID);
					Ptsm.setString(1, Gender);
					Numbers = Ptsm.executeUpdate();
					break;
				case 6:
					System.out.println("Please Enter Student Address");
					String Address = Sc.next();
					Ptsm = Con.prepareStatement(
							"UPDATE student_management_system" + " SET S_Address=?" + " WHERE S_Id=" + ID);
					Ptsm.setString(1, Address);
					Numbers = Ptsm.executeUpdate();
					break;
				case 7:
					System.out.println("Please Enter Student Mobile No");
					long Mobile = Sc.nextLong();
					Ptsm = Con.prepareStatement(
							"UPDATE student_management_system" + " SET S_MobileNo=" + Mobile + " WHERE S_Id=" + ID);
					Numbers = Ptsm.executeUpdate();
					break;
				}
				break;
			// Update Mobile Number
			case 2:
				System.out.println("Please Enter Student Mobile Number");
				long Mobil = Sc.nextLong();
				System.out.println("Which Colum You are going to Update");
				System.out.println("1.Fee");
				System.out.println("2.Register Number");
				System.out.println("3.First Name");
				System.out.println("4.Last Name");
				System.out.println("5.Gender");
				System.out.println("6..Address");
				System.out.println("7.Mobile Number");
				int Ch2 = Sc.nextInt();
				switch (Ch2) {
				case 1:
					System.out.println("Please Enter Student Fees");
					double Fee = Sc.nextDouble();
					Ptsm = Con.prepareStatement(
							"UPDATE student_management_system" + " SET S_Fees=" + Fee + " WHERE S_RegNo=" + Mobil);
					Numbers = Ptsm.executeUpdate();
					break;
				case 2:
					System.out.println("Please Enter Student RegNo");
					int RegNo = Sc.nextInt();
					Ptsm = Con.prepareStatement(
							"UPDATE student_management_system" + " SET S_RegNo=" + RegNo + " WHERE S_RegNo=" + Mobil);
					Numbers = Ptsm.executeUpdate();
					break;
				case 3:
					System.out.println("Please Enter Student Fees");
					String Fname = Sc.next();
					Ptsm = Con.prepareStatement(
							"UPDATE student_management_system" + " SET S_Fname=?" + " WHERE S_RegNo=" + Mobil);
					Ptsm.setString(1, Fname);
					Numbers = Ptsm.executeUpdate();
					break;
				case 4:
					System.out.println("Please Enter Student Last name");
					String Lname = Sc.next();
					Ptsm = Con.prepareStatement(
							"UPDATE student_management_system" + " SET S_Lname=?" + " WHERE S_RegNo=" + Mobil);
					Ptsm.setString(1, Lname);
					Numbers = Ptsm.executeUpdate();
					break;
				case 5:
					System.out.println("Please Enter Student Gender");
					String Gender = Sc.next();
					Ptsm = Con.prepareStatement(
							"UPDATE student_management_system" + " SET S_Gender=?" + " WHERE S_RegNo=" + Mobil);
					Ptsm.setString(1, Gender);
					Numbers = Ptsm.executeUpdate();
					break;
				case 6:
					System.out.println("Please Enter Student Address");
					String Address = Sc.next();
					Ptsm = Con.prepareStatement(
							"UPDATE student_management_system" + " SET S_Address=?" + " WHERE S_RegNo=" + Mobil);
					Ptsm.setString(1, Address);
					Numbers = Ptsm.executeUpdate();
					break;
				case 7:
					System.out.println("Please Enter Student Mobile No");
					long Mobile = Sc.nextLong();
					Ptsm = Con.prepareStatement("UPDATE student_management_system" + " SET S_MobileNo=" + Mobile
							+ " WHERE S_RegNo=" + Mobil);
					Numbers = Ptsm.executeUpdate();
					break;
				}
				break;
			// Update Register Number Method
			case 3:
				System.out.println("Please Enter Student Register Number");
				int Reg = Sc.nextInt();
				System.out.println("Which Colum You are going to Update");
				System.out.println("1.Fee");
				System.out.println("2.Register Number");
				System.out.println("3.First Name");
				System.out.println("4.Last Name");
				System.out.println("5.Gender");
				System.out.println("6..Address");
				System.out.println("7.Mobile Number");
				int Ch3 = Sc.nextInt();
				switch (Ch3) {
				case 1:
					System.out.println("Please Enter Student Fees");
					System.out.println(
							"---------------------------------------------------------------------------------------");
					double Fee = Sc.nextDouble();
					Ptsm = Con.prepareStatement(
							"UPDATE student_management_system" + " SET S_Fees=" + Fee + " WHERE S_RegNo=" + Reg);
					Numbers = Ptsm.executeUpdate();
					break;
				case 2:
					System.out.println("Please Enter Student RegNo");
					System.out.println(
							"---------------------------------------------------------------------------------------");
					int RegNo = Sc.nextInt();
					Ptsm = Con.prepareStatement(
							"UPDATE student_management_system" + " SET S_RegNo=" + RegNo + " WHERE S_RegNo=" + Reg);
					Numbers = Ptsm.executeUpdate();
					break;
				case 3:
					System.out.println("Please Enter Student Firt Name");
					System.out.println(
							"---------------------------------------------------------------------------------------");
					String Fname = Sc.next();
					Ptsm = Con.prepareStatement(
							"UPDATE student_management_system" + " SET S_Fname=?" + " WHERE S_RegNo=" + Reg);
					Ptsm.setString(1, Fname);
					Numbers = Ptsm.executeUpdate();
					break;
				case 4:
					System.out.println("Please Enter Student Last name");
					System.out.println(
							"---------------------------------------------------------------------------------------");
					String Lname = Sc.next();
					Ptsm = Con.prepareStatement(
							"UPDATE student_management_system" + " SET S_Lname=?" + " WHERE S_RegNo=" + Reg);
					Ptsm.setString(1, Lname);
					Numbers = Ptsm.executeUpdate();
					break;
				case 5:
					System.out.println("Please Enter Student Gender");
					System.out.println(
							"---------------------------------------------------------------------------------------");
					String Gender = Sc.next();
					Ptsm = Con.prepareStatement(
							"UPDATE student_management_system" + " SET S_Gender=?" + " WHERE S_RegNo=" + Reg);
					Ptsm.setString(1, Gender);
					Numbers = Ptsm.executeUpdate();
					break;
				case 6:
					System.out.println("Please Enter Student Address");
					System.out.println(
							"---------------------------------------------------------------------------------------");
					String Address = Sc.next();
					Ptsm = Con.prepareStatement(
							"UPDATE student_management_system" + " SET S_Address=?" + " WHERE S_RegNo=" + Reg);
					Ptsm.setString(1, Address);
					Numbers = Ptsm.executeUpdate();
					break;
				case 7:
					System.out.println("Please Enter Student Mobile No");
					System.out.println(
							"---------------------------------------------------------------------------------------");
					long Mobile = Sc.nextLong();
					Ptsm = Con.prepareStatement(
							"UPDATE student_management_system" + " SET S_MobileNo=" + Mobile + " WHERE S_RegNo=" + Reg);
					Numbers = Ptsm.executeUpdate();
					break;
				}
				break;
			// Update First Name Method
			case 4:
				System.out.println("Please Enter Student First Name");
				System.out.println(
						"---------------------------------------------------------------------------------------");
				String Fname = Sc.next();
				System.out.println("Which Colum You are going to Update");
				System.out.println(
						"---------------------------------------------------------------------------------------");
				System.out.println("1.Fee");
				System.out.println("2.Register Number");
				System.out.println("3.First Name");
				System.out.println("4.Last Name");
				System.out.println("5.Gender");
				System.out.println("6.Address");
				System.out.println("7.Mobile Number");
				int Ch4 = Sc.nextInt();
				switch (Ch4) {
				case 1:
					System.out.println("Please Enter Student Fees");
					System.out.println(
							"---------------------------------------------------------------------------------------");
					double Fee = Sc.nextDouble();
					Ptsm = Con.prepareStatement(
							"UPDATE student_management_system" + " SET S_Fees=" + Fee + " WHERE S_Fname=?");
					Ptsm.setString(1, Fname);
					Numbers = Ptsm.executeUpdate();
					break;
				case 2:
					System.out.println("Please Enter Student RegNo");
					System.out.println(
							"---------------------------------------------------------------------------------------");
					int RegNo = Sc.nextInt();
					Ptsm = Con.prepareStatement(
							"UPDATE student_management_system" + " SET S_RegNo=" + RegNo + " WHERE S_Fname=?");
					Ptsm.setString(1, Fname);
					Numbers = Ptsm.executeUpdate();
					break;
				case 3:
					System.out.println("Please Enter Student Firt Name");
					System.out.println(
							"---------------------------------------------------------------------------------------");
					String Fname2 = Sc.next();
					Ptsm = Con.prepareStatement(
							"UPDATE student_management_system" + " SET S_Fname=?" + " WHERE S_Fname=?");
					Ptsm.setString(1, Fname2);
					Ptsm.setString(2, Fname);
					Numbers = Ptsm.executeUpdate();
					break;
				case 4:
					System.out.println("Please Enter Student Last name");
					System.out.println(
							"---------------------------------------------------------------------------------------");
					String Lname = Sc.next();
					Ptsm = Con.prepareStatement(
							"UPDATE student_management_system" + " SET S_Lname=?" + " WHERE S_Fname=?");
					Ptsm.setString(1, Lname);
					Ptsm.setString(2, Fname);
					Numbers = Ptsm.executeUpdate();
					break;
				case 5:
					System.out.println("Please Enter Student Gender");
					System.out.println(
							"---------------------------------------------------------------------------------------");
					String Gender = Sc.next();
					Ptsm = Con.prepareStatement(
							"UPDATE student_management_system" + " SET S_Gender=?" + " WHERE S_RegNo=?");
					Ptsm.setString(1, Gender);
					Ptsm.setString(2, Fname);
					Numbers = Ptsm.executeUpdate();
					break;
				case 6:
					System.out.println("Please Enter Student Address");
					System.out.println(
							"---------------------------------------------------------------------------------------");
					String Address = Sc.next();
					Ptsm = Con.prepareStatement(
							"UPDATE student_management_system" + " SET S_Address=?" + " WHERE S_RegNo=?");
					Ptsm.setString(1, Address);
					Ptsm.setString(2, Fname);
					Numbers = Ptsm.executeUpdate();
					break;
				case 7:
					System.out.println("Please Enter Student Mobile No");
					System.out.println(
							"---------------------------------------------------------------------------------------");
					long Mobile = Sc.nextLong();
					Ptsm = Con.prepareStatement(
							"UPDATE student_management_system" + " SET S_MobileNo=" + Mobile + " WHERE S_RegNo=?");
					Ptsm.setString(1, Fname);
					Numbers = Ptsm.executeUpdate();
					break;
				}
				break;
			// Update Address Method
			case 5:
				System.out.println("Please Enter Student Address");
				System.out.println(
						"---------------------------------------------------------------------------------------");
				String Address = Sc.next();
				System.out.println("Which Colum You are going to Update");
				System.out.println(
						"---------------------------------------------------------------------------------------");
				System.out.println("1.Fee");
				System.out.println("2.Register Number");
				System.out.println("3.First Name");
				System.out.println("4.Last Name");
				System.out.println("5.Gender");
				System.out.println("6..Address");
				System.out.println("7.Mobile Number");
				int Ch5 = Sc.nextInt();
				switch (Ch5) {
				case 1:
					System.out.println("Please Enter Student Fees");
					System.out.println(
							"---------------------------------------------------------------------------------------");
					double Fee = Sc.nextDouble();
					Ptsm = Con.prepareStatement(
							"UPDATE student_management_system" + " SET S_Fees=" + Fee + " WHERE S_Address=?");
					Ptsm.setString(1, Address);
					Numbers = Ptsm.executeUpdate();
					break;
				case 2:
					System.out.println("Please Enter Student RegNo");
					System.out.println(
							"---------------------------------------------------------------------------------------");
					int RegNo = Sc.nextInt();
					Ptsm = Con.prepareStatement(
							"UPDATE student_management_system" + " SET S_RegNo=" + RegNo + " WHERE S_Address=?");
					Ptsm.setString(1, Address);
					Numbers = Ptsm.executeUpdate();
					break;
				case 3:
					System.out.println("Please Enter Student Firt Name");
					System.out.println(
							"---------------------------------------------------------------------------------------");
					String Fname2 = Sc.next();
					Ptsm = Con.prepareStatement(
							"UPDATE student_management_system" + " SET S_Fname=?" + " WHERE S_Address=?");
					Ptsm.setString(1, Fname2);
					Ptsm.setString(2, Address);
					Numbers = Ptsm.executeUpdate();
					break;
				case 4:
					System.out.println("Please Enter Student Last name");
					System.out.println(
							"---------------------------------------------------------------------------------------");
					String Lname = Sc.next();
					Ptsm = Con.prepareStatement(
							"UPDATE student_management_system" + " SET S_Lname=?" + " WHERE S_Address=?");
					Ptsm.setString(1, Lname);
					Ptsm.setString(2, Address);
					Numbers = Ptsm.executeUpdate();
					break;
				case 5:
					System.out.println("Please Enter Student Gender");
					System.out.println(
							"---------------------------------------------------------------------------------------");
					String Gender = Sc.next();
					Ptsm = Con.prepareStatement(
							"UPDATE student_management_system" + " SET S_Gender=?" + " WHERE S_Address=?");
					Ptsm.setString(1, Gender);
					Ptsm.setString(2, Address);
					Numbers = Ptsm.executeUpdate();
					break;
				case 6:
					System.out.println("Please Enter Student Address");
					System.out.println(
							"---------------------------------------------------------------------------------------");
					String Address1 = Sc.next();
					Ptsm = Con.prepareStatement(
							"UPDATE student_management_system" + " SET S_Address=?" + " WHERE S_Address=?");
					Ptsm.setString(1, Address1);
					Ptsm.setString(2, Address);
					Numbers = Ptsm.executeUpdate();
					break;
				case 7:
					System.out.println("Please Enter Student Mobile No");
					System.out.println(
							"---------------------------------------------------------------------------------------");
					long Mobile = Sc.nextLong();
					Ptsm = Con.prepareStatement(
							"UPDATE student_management_system" + " SET S_MobileNo=" + Mobile + " WHERE S_Address=?");
					Ptsm.setString(1, Address);
					Numbers = Ptsm.executeUpdate();
					break;
				}
				break;
			}
			if (Numbers == 0) {
				System.out.println("0 Rows Updated");
				Display();
			} else {
				System.out.println("Successfully Deleted" + Numbers + " row");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			Con.close();
		}
	}

	// Delete Table
	public void Deteteable() throws Exception {
		Scanner Sc = new Scanner(System.in);
		Connection Con = null;
		PreparedStatement Ptsm = null;
		Properties Pro = new Properties();
		PreparedStatement Psm = null;
		int number = 0;
		try {
			Pro.load(new FileReader(new File("./src/org/jsp/StuentManagement/Test.properties")));
			Class.forName(Pro.getProperty("driver"));
			Con = DriverManager.getConnection(Pro.getProperty("url"), Pro);
			System.out.println("which Column You are Going to use to Delete");
			System.out
					.println("---------------------------------------------------------------------------------------");
			System.out.println("1.ID");
			System.out.println("2.Mobile Number");
			System.out.println("3.Register Number");
			System.out.println("4.First Name");
			System.out.println("5.Address");
			System.out
					.println("---------------------------------------------------------------------------------------");
			int Ch = Sc.nextInt();
			switch (Ch) {
			case 1:
				System.out.println("Please Enter Student ID");
				System.out.println(
						"---------------------------------------------------------------------------------------");
				int ID = Sc.nextInt();
				Ptsm = Con.prepareStatement("DELETE FROM student_management_system " + "WHERE S_ID=" + ID);
				number = Ptsm.executeUpdate();
				break;
			case 2:
				System.out.println("Please Enter Student Mobile Number");
				long Mobil = Sc.nextInt();
				Ptsm = Con.prepareStatement("DELETE FROM student_management_system " + "WHERE S_MobileNo=" + Mobil);
				number = Ptsm.executeUpdate();
				break;
			case 3:
				System.out.println("Please Enter Student Register Number");
				System.out.println(
						"---------------------------------------------------------------------------------------");
				int RegNo = Sc.nextInt();
				Ptsm = Con.prepareStatement("DELETE FROM student_management_system " + "WHERE S_RegNo=" + RegNo);
				number = Ptsm.executeUpdate();
				break;
			case 4:
				ResultSet Rs = null;
				String Strin = "SELECT * FROM student_management_system " + "WHERE S_Fname= ?";
				System.out.println("Please Enter Student First Name");
				String Fname = Sc.next();
				Psm = Con.prepareStatement(Strin);
				Psm.setString(1, Fname);
				Rs = Psm.executeQuery();
				if (Rs.first() == true) {
					Rs = Psm.executeQuery();
					System.out.println(
							"-------------------------------------------------------------------------------------------------------------------------------------");
					System.out.println("S_Id" + "\t\t" + "S_Fname" + "\t\t" + "S_Lname" + "\t\t" + "S_Gendar" + "\t\t"
							+ "S_RegNo" + "\t\t" + "S_Fees" + "\t\t" + "S_MobileNo" + "\t\t" + "S_Address");
					System.out.println(
							"-------------------------------------------------------------------------------------------------------------------------------------");
					while (Rs.next()) {
						System.out.println(Rs.getInt(1) + "\t\t" + Rs.getString(2) + "\t\t" + Rs.getString(3) + "\t\t"
								+ Rs.getString(4) + "\t\t\t" + Rs.getInt(5) + "\t\t" + Rs.getDouble(6) + "\t\t"
								+ Rs.getLong(8) + "\t\t" + Rs.getString(7));
					}
					System.out.println(
							"-------------------------------------------------------------------------------------------------------------------------------------");
				} else {
					System.out.println("First name is Mismatch Please try again");
					System.out.println(
							"---------------------------------------------------------------------------------------");
					Deteteable();
				}
				String Str = "DELETE FROM student_management_system " + "WHERE S_RegNo= ?";
				System.out.println("Please Enter Student Register Number Based on Your Table");
				System.out.println(
						"---------------------------------------------------------------------------------------");
				int RegNo1 = Sc.nextInt();
				Psm = Con.prepareStatement(Str);
				Psm.setInt(1, RegNo1);
				number = Psm.executeUpdate();
				break;
			case 5:
				ResultSet Rs1 = null;
				String Strin1 = "SELECT * FROM student_management_system " + "WHERE S_Address= ?";
				System.out.println("Please Enter Student Address");
				System.out.println(
						"---------------------------------------------------------------------------------------");
				String Address = Sc.next();
				Psm = Con.prepareStatement(Strin1);
				Psm.setString(1, Address);
				Rs = Psm.executeQuery();
				if (Rs.first() == true) {
					Rs = Psm.executeQuery();
					System.out.println(
							"-------------------------------------------------------------------------------------------------------------------------------------");
					System.out.println("S_Id" + "\t\t" + "S_Fname" + "\t\t" + "S_Lname" + "\t\t" + "S_Gendar" + "\t\t"
							+ "S_RegNo" + "\t\t" + "S_Fees" + "\t\t" + "S_MobileNo" + "\t\t" + "S_Address");
					System.out.println(
							"-------------------------------------------------------------------------------------------------------------------------------------");
					while (Rs.next()) {
						System.out.println(Rs.getInt(1) + "\t\t" + Rs.getString(2) + "\t\t" + Rs.getString(3) + "\t\t"
								+ Rs.getString(4) + "\t\t\t" + Rs.getInt(5) + "\t\t" + Rs.getDouble(6) + "\t\t"
								+ Rs.getLong(8) + "\t\t" + Rs.getString(7));
					}
					System.out.println(
							"-------------------------------------------------------------------------------------------------------------------------------------");
				} else {
					System.out.println("Address is Mismatch Please try again");
					System.out.println(
							"---------------------------------------------------------------------------------------");
					Deteteable();
				}
				String Str1 = "DELETE FROM student_management_system " + "WHERE S_RegNo= ?";
				System.out.println("Please Enter Student Register Number");
				System.out.println(
						"---------------------------------------------------------------------------------------");
				int RegNo2 = Sc.nextInt();
				Psm = Con.prepareStatement(Str1);
				Psm.setInt(1, RegNo2);
				number = Psm.executeUpdate();
				break;
			}
			if (number == 0) {
				System.out.println("0 row Affected");
			} else {
				System.out.println("Successfully Deleted " + number + " row");
				Display();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			Con.close();
		}
	}

	// Searching Methods
	public void Search() throws Exception {
		Scanner Sc = new Scanner(System.in);
		Connection Con = null;
		Statement Ptsm = null;
		PreparedStatement Psm = null;
		Properties Pro = new Properties();
		try {
			Pro.load(new FileReader(new File("./src/org/jsp/StuentManagement/Test.properties")));
			Class.forName(Pro.getProperty("driver"));
			Con = DriverManager.getConnection(Pro.getProperty("url"), Pro);
			System.out.println("which Column You are Going to use to Search");
			System.out
					.println("---------------------------------------------------------------------------------------");
			System.out.println("1.First Name");
			System.out.println("2.Last Name");
			System.out.println("3.Mobile Number");
			System.out.println("4.Address");
			System.out
					.println("---------------------------------------------------------------------------------------");
			int Ch = Sc.nextInt();
			ResultSet Num = null;
			switch (Ch) {
			case 1:
				int Num1 = 0;
				String Str = "SELECT * FROM student_management_system " + "WHERE S_Fname= ?";
				System.out.println("Please Enter Student FirstName");
				System.out.println(
						"---------------------------------------------------------------------------------------");
				String Name = Sc.next();
				Psm = Con.prepareStatement(Str);
				Psm.setString(1, Name);
				Num = Psm.executeQuery();
				if (Num.next() == true) {
					Num = Psm.executeQuery();
					System.out.println(
							"-------------------------------------------------------------------------------------------------------------------------------------");
					System.out.println("S_Id" + "\t\t" + "S_Fname" + "\t\t" + "S_Lname" + "\t\t" + "S_Gendar" + "\t\t"
							+ "S_RegNo" + "\t\t" + "S_Fees" + "\t\t" + "S_MobileNo" + "\t\t" + "S_Address");
					System.out.println(
							"-------------------------------------------------------------------------------------------------------------------------------------");
					while (Num.next()) {
						System.out.println(Num.getInt(1) + "\t\t" + Num.getString(2) + "\t\t" + Num.getString(3)
								+ "\t\t" + Num.getString(4) + "\t\t\t" + Num.getInt(5) + "\t\t" + Num.getDouble(6)
								+ "\t\t" + Num.getLong(8) + "\t\t" + Num.getString(7));
					}
					System.out.println(
							"-------------------------------------------------------------------------------------------------------------------------------------");
					System.out.println("If you want to Search Anything Else Enter 1 Otherwise Enter 2");
					int Sear=Sc.nextInt();
					switch(Sear)
					{
						case 1:Search();
						break;
						case 2:MainStudentManagement.main(null);
						break;
					}
				} else {
					System.out.println(
							"Sorry You FirstName is Not Matched Please Try Another Option or Enter Valid FirstName :(");
					System.out.println(
							"---------------------------------------------------------------------------------------");
					Search();
				}
				break;
			case 2:
				String Str1 = "SELECT * FROM student_management_system " + "WHERE S_Lname= ?";
				System.out.println("Please Enter Student LastName");
				System.out.println(
						"---------------------------------------------------------------------------------------");
				String LName = Sc.next();
				Psm = Con.prepareStatement(Str1);
				Psm.setString(1, LName);
				Num = Psm.executeQuery();
				if (Num.next()) {
					System.out.println(
							"-------------------------------------------------------------------------------------------------------------------------------------");
					System.out.println("S_Id" + "\t\t" + "S_Fname" + "\t\t" + "S_Lname" + "\t\t" + "S_Gendar" + "\t\t"
							+ "S_RegNo" + "\t\t" + "S_Fees" + "\t\t" + "S_MobileNo" + "\t\t" + "S_Address");
					System.out.println(
							"-------------------------------------------------------------------------------------------------------------------------------------");
					while (Num.next()) {
						System.out.println(Num.getInt(1) + "\t\t" + Num.getString(2) + "\t\t" + Num.getString(3)
								+ "\t\t" + Num.getString(4) + "\t\t\t" + Num.getInt(5) + "\t\t" + Num.getDouble(6)
								+ "\t\t" + Num.getLong(8) + "\t\t" + Num.getString(7));
					}
					System.out.println(
							"-------------------------------------------------------------------------------------------------------------------------------------");
					System.out.println("If you want to Search Anything Else Enter 1 Otherwise Enter 2");
					int Sear=Sc.nextInt();
					switch(Sear)
					{
						case 1:Search();
						break;
						case 2:MainStudentManagement.main(null);
						break;
					}
				} else {
					System.out.println(
							"Sorry You FirstName is Not Matched Please Try Another Option or Enter Valid Last Name :(");
					System.out.println(
							"---------------------------------------------------------------------------------------");
					Search();
				}
				break;
			case 3:
				System.out.println("Please Enter Student Mobile Number");
				System.out.println(
						"---------------------------------------------------------------------------------------");
				int Mobil = Sc.nextInt();
				Ptsm = Con.createStatement();
				Num = Ptsm.executeQuery("SELECT * FROM student_management_system " + "WHERE S_MobileNo=" + Mobil);
				if (Num.next()==true) {
					Num = Ptsm.executeQuery("SELECT * FROM student_management_system " + "WHERE S_MobileNo=" + Mobil);
					System.out.println(
							"-------------------------------------------------------------------------------------------------------------------------------------");
					System.out.println("S_Id" + "\t\t" + "S_Fname" + "\t\t" + "S_Lname" + "\t\t" + "S_Gendar" + "\t\t"
							+ "S_RegNo" + "\t\t" + "S_Fees" + "\t\t" + "S_MobileNo" + "\t\t" + "S_Address");
					System.out.println(
							"-------------------------------------------------------------------------------------------------------------------------------------");
					while (Num.next()) {
						System.out.println(Num.getInt(1) + "\t\t" + Num.getString(2) + "\t\t" + Num.getString(3)
								+ "\t\t" + Num.getString(4) + "\t\t\t" + Num.getInt(5) + "\t\t" + Num.getDouble(6)
								+ "\t\t" + Num.getLong(8) + "\t\t" + Num.getString(7));
					}
					System.out.println(
							"-------------------------------------------------------------------------------------------------------------------------------------");
					System.out.println("If you want to Search Anything Else Enter 1 Otherwise Enter 2");
					int Sear=Sc.nextInt();
					switch(Sear)
					{
						case 1:Search();
						break;
						case 2:MainStudentManagement.main(null);
						break;
					}
				} else {
					System.out.println(
							"Sorry You FirstName is Not Matched Please Try Another Option or Enter Valid Mobile :(");
					System.out.println(
							"---------------------------------------------------------------------------------------");
					Search();
				}
				break;
			case 4:
				String Str3 = "SELECT * FROM student_management_system " + "WHERE S_Address= ?";
				System.out.println("Please Enter Student Address");
				System.out.println(
						"---------------------------------------------------------------------------------------");
				String S_Address = Sc.next();
				Psm = Con.prepareStatement(Str3);
				Psm.setString(1, S_Address);
				Num = Psm.executeQuery();
				if (Num.next() == true) {
					Num = Psm.executeQuery();
					System.out.println(
							"-------------------------------------------------------------------------------------------------------------------------------------");
					System.out.println("S_Id" + "\t\t" + "S_Fname" + "\t\t" + "S_Lname" + "\t\t" + "S_Gendar" + "\t\t"
							+ "S_RegNo" + "\t\t" + "S_Fees" + "\t\t" + "S_MobileNo" + "\t\t" + "S_Address");
					System.out.println(
							"-------------------------------------------------------------------------------------------------------------------------------------");
					while (Num.next()) {
						System.out.println(Num.getInt(1) + "\t\t" + Num.getString(2) + "\t\t" + Num.getString(3)
								+ "\t\t" + Num.getString(4) + "\t\t\t" + Num.getInt(5) + "\t\t" + Num.getDouble(6)
								+ "\t\t" + Num.getLong(8) + "\t\t" + Num.getString(7));
					}
					System.out.println(
							"-------------------------------------------------------------------------------------------------------------------------------------");
					System.out.println("If you want to Search Anything Else Enter 1 Otherwise Enter 2");
					int Sear=Sc.nextInt();
					switch(Sear)
					{
						case 1:Search();
						break;
						case 2:MainStudentManagement.main(null);
						break;
					}
				} else {
					System.out.println(
							"Sorry You FirstName is Not Matched Please Try Another Option or Enter Valid Address :(");
					System.out.println(
							"---------------------------------------------------------------------------------------");
					Search();
				}
				break;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			Con.close();
		}
	}
}