import java.util.Scanner;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import javax.swing.*;

public class project {

	static String seatNum;
	static Scanner sc = new Scanner(System.in);

	public static void bkCancel(String name) throws IOException {
		File tempFile = new File("C:\\Users\\Qist Bazaar\\Desktop\\New folder\\tempfile.txt");
		File oldFile = new File("C:\\Users\\Qist Bazaar\\Desktop\\New folder\\bookingdetails.txt");

		FileWriter fw = new FileWriter("C:\\Users\\Qist Bazaar\\Desktop\\New folder\\tempfile.txt", true);
		BufferedWriter bw = new BufferedWriter(fw);
		PrintWriter pw = new PrintWriter(bw);

		FileReader fr = new FileReader("C:\\Users\\Qist Bazaar\\Desktop\\New folder\\bookingdetails.txt");
		BufferedReader br = new BufferedReader(fr);

		boolean cancelCheck = false;

		for (String str = br.readLine(); str != null; str = br.readLine()) {
			String[] tempArray = str.split(",");
			if (tempArray[1].equals(name)) {
				seatNum = tempArray[0];
				pw.write(tempArray[0] + "," + "unbooked\n");
				cancelCheck = true;
			} else {
				pw.write(str + "\n");
			}
		}

		pw.flush();
		pw.close();
		fr.close();
		br.close();
		bw.close();
		fw.close();

		if (cancelCheck == false) {
			System.out.println("Sorry, No Such Seats Are Booked on This User Account!");
		}

		if (oldFile.delete()) {
			File d = new File("bookingdetails.txt");
			tempFile.renameTo(d);
			System.out
					.println("Your Booking Of Seat No: " + seatNum + " Of Flight: AB1234 Has Successfully Cancelled!!");
		} else {
			tempFile.delete();
			System.out.println("Something Went Wrong\nTry Again Later");
		}

	}

	public static String seatDisplay() throws IOException {
		try {
			FileReader fr = new FileReader("C:\\Users\\Qist Bazaar\\Desktop\\New folder\\bookingdetails.txt");
			BufferedReader br = new BufferedReader(fr);

			String str = br.readLine();
			String[] seatsArray = new String[18];
			int k = 0;
			while (str != null) {
				String[] tempArray = str.split(",");
				if (tempArray[1].equals("unbooked")) {
					seatsArray[k] = tempArray[0];
				}
				str = br.readLine();
				k++;
			}
			fr.close();
			br.close();

			boolean seatCheck = false;
			while (seatCheck == false) {
				System.out.println("Following Seats are Available: ");
				System.out.println(Arrays.toString(seatsArray));
				System.out.println("Enter Your Desired Seat Number: ");
				String tempSeatNum = sc.next();

				for (int i = 0; i < seatsArray.length; i++) {
					if (tempSeatNum.equals(seatsArray[i])) {
						seatNum = tempSeatNum;
						seatCheck = true;
						break;
					}
				}

				if (seatCheck == false) {
					System.out.println("No Such Seats Are Available At The Moment\nPlease Choose a Different Seat");
				} else
					break;
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		return seatNum;
	}

	public static String seatBooking(String name) {
		try {
			File tempFile = new File("C:\\Users\\Qist Bazaar\\Desktop\\New folder\\tempfile.txt");
			File oldFile = new File("C:\\Users\\Qist Bazaar\\Desktop\\New folder\\bookingdetails.txt");
			FileWriter fw = new FileWriter("C:\\Users\\Qist Bazaar\\Desktop\\New folder\\tempfile.txt", true);
			BufferedWriter bw = new BufferedWriter(fw);
			PrintWriter pw = new PrintWriter(bw);

			FileReader fr = new FileReader("C:\\Users\\Qist Bazaar\\Desktop\\New folder\\bookingdetails.txt");
			BufferedReader br = new BufferedReader(fr);

			seatNum = seatDisplay();
			boolean bookCheck = false;
			String str = br.readLine();
			while (str != null) {
				String[] tempArray = str.split(",");
				// System.out.println(java.util.Arrays.toString(tempArray));
				// System.out.println(tempArray.length);
				if (tempArray[0].equals(seatNum) && tempArray[1].equals("unbooked")) {
					pw.write(tempArray[0] + "," + name + "\n");
					System.out.println("Your Seat " + tempArray[0] + " has been booked");
					bookCheck = true;
				} else {
					pw.write(str + "\n");
				}
				str = br.readLine();
			}

			pw.flush();
			pw.close();
			fr.close();
			br.close();
			bw.close();
			fw.close();

			if (bookCheck == false) {
				System.out.println("Sorry No Seats Are Available Anymore For This Flight ");
			}

			if (oldFile.delete()) {
				File d = new File("bookingdetails.txt");
				tempFile.renameTo(d);
				System.out.println("Action Completed");
			} else {
				tempFile.delete();
				System.out.println("Something Went Wrong\nTry Again Later");
			}

		} catch (IOException e) {
			e.printStackTrace();
		}

		return seatNum;

	}

	public static void displayImage() {

		ImageIcon icon = new ImageIcon("image.png");

		JLabel label = new JLabel(icon);
		JFrame frame = new JFrame();

		frame.add(label);

		frame.setSize(1700, 550);

		frame.setTitle("Image Display");

		// Set the default close operation of the JFrame
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// Display the JFrame
		frame.setVisible(true);
	}

	public static void displayImage2() {

		ImageIcon icon = new ImageIcon("ticket_umar.png");

		JLabel label = new JLabel(icon);
		JFrame frame = new JFrame();

		frame.add(label);

		frame.setSize(1700, 550);

		frame.setTitle("Image Display");

		// Set the default close operation of the JFrame
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// Display the JFrame
		frame.setVisible(true);
	}

	public static void deleteAccount(int l) throws IOException {
		File oldFile = new File("C:\\Users\\Qist Bazaar\\Desktop\\New folder\\userdetails.txt");
		File tempFile = new File("C:\\Users\\Qist Bazaar\\Desktop\\New folder\\tempfile.txt");
		FileReader fr = new FileReader("C:\\Users\\Qist Bazaar\\Desktop\\New folder\\userdetails.txt");
		BufferedReader br = new BufferedReader(fr);

		FileWriter fw = new FileWriter("C:\\Users\\Qist Bazaar\\Desktop\\New folder\\tempfile.txt", true);
		BufferedWriter bw = new BufferedWriter(fw);
		PrintWriter pw = new PrintWriter(bw);

		String line = br.readLine();
		int i = 1;
		while (line != null) {
			if (i != l) {
				pw.println(line);
			}
			i++;
			line = br.readLine();
		}
		pw.flush();
		pw.close();
		fr.close();
		br.close();
		bw.close();
		fw.close();

		if (oldFile.delete()) {
			File d = new File("userdetails.txt");
			tempFile.renameTo(d);
			System.out.println("Account Successfully Deleted");
		} else {
			tempFile.delete();
			System.out.println("Something Went Wrong\nTry Again Later");
		}
	}

	public static void createAccount() {
		try {
			FileWriter fw = new FileWriter("C:\\Users\\Qist Bazaar\\Desktop\\New folder\\userdetails.txt", true);
			BufferedWriter br = new BufferedWriter(fw);
			PrintWriter pw = new PrintWriter(br);

			System.out.print("Enter Your First Name: ");
			String newUserData = sc.next();

			System.out.print("Enter Your Last Name: ");
			newUserData = newUserData + " " + sc.next();

			System.out.print("Enter Your Phone Number: ");
			newUserData = newUserData + " " + sc.next();

			System.out.print("Enter a User Name: ");
			newUserData = newUserData + " " + sc.next();

			System.out.println("Enter a Password: \n(Password Should be under 10 characters)");
			String tempVar;
			while (true) {
				tempVar = sc.next();
				if (tempVar.length() > 10)
					System.out.println("Password Doesn't Match the Requirements\nTry Again:");
				else
					break;
			}

			newUserData = newUserData + " " + tempVar;

			pw.append("\n" + newUserData);
			pw.close();

			System.out.println("Creating your Account..");
			try {
				java.util.concurrent.TimeUnit.SECONDS.sleep(2);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("Congrats!!!\nYour Account has been Created.");
			try {
				java.util.concurrent.TimeUnit.SECONDS.sleep(2);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static int inputValidation() {
		int inp;
		while (true) {
			try {
				inp = Integer.parseInt(sc.next());
				break;
			} catch (NumberFormatException nfe) {
				System.out.print("Try again: ");
			}
		}
		return inp;
	}

	public static String[][] storingArray(String[][] array, String[] arr, int var) {
		for (int i = 0; i < array[0].length; i++) {
			array[var][i] = arr[i];

		}
		return array;
	}

	public static String[][] dataExtraction(String[][] arr) {
		try {
			FileReader fr = new FileReader("C:\\Users\\Qist Bazaar\\Desktop\\New folder\\userdetails.txt");
			BufferedReader br = new BufferedReader(fr);

			int size = 0;
			while (br.readLine() != null) {
				size++;
			}
			// System.out.println(size);

			br.close();

			fr = new FileReader("C:\\Users\\Qist Bazaar\\Desktop\\New folder\\userdetails.txt");
			br = new BufferedReader(fr);

			int kVar = 0;
			int count = 1;
			arr = new String[size][5];
			while (count <= size) {
				String tempVar = br.readLine();
				String[] tempArray = tempVar.split(" ");
				arr = storingArray(arr, tempArray, kVar);
				kVar++;
				count++;
			}

			br.close();
		}

		catch (IOException e) {
			e.printStackTrace();
		}

		return arr;
	}

	public static String enterPassword() {

		Thread th2 = new Thread() {
			public void run() {
				for (int i = 0; i < 5; i++) {
					try {
						java.util.concurrent.TimeUnit.SECONDS.sleep(1);
						System.out.print("*");
					} catch (InterruptedException e) {
						e.printStackTrace();
					}

				}
			}
		};

		th2.start();
		char passwordArray[] = System.console().readPassword("Enter password: ");
		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < passwordArray.length; i++) {
			sb.append(passwordArray[i]);
		}
		String password = sb.toString();

		return password;
	}

	public static int setCharges(String x1) {
		int charges = 0;
		if (x1.equals("2 Hours")) {
			charges = 20000;
		} else if (x1.equals("30 Minutes")) {
			charges = 5000;
		} else if (x1.equals("1 Hour & 30 Minutes")) {
			charges = 15000;
		} else if (x1.equals("50 Minutes")) {
			charges = 10000;
		}
		return charges;
	}

	public static String flightSelector(String x1, String x2) {
		String[] Locations = { "KARACHI", "ISLAMABAD", "LAHORE", "MULTAN", "FAISALABAD", "HYDERABAD", "SUKKUR" };
		int ind1 = 0;
		int ind2 = 0;
		String finalTime;
		for (int i = 0; i < Locations.length; i++) {
			if (x1.equals(Locations[i])) {
				ind1 = i;
			}
			if (x2.equals(Locations[i])) {
				ind2 = i;
			}
		}
		if ((ind1 == 0 && ind2 == 1) || (ind1 == 0 && ind2 == 2)) {
			finalTime = "2 Hours";
		} else if ((ind1 == 0 && ind2 == 5) || (ind1 == 0 && ind2 == 6)) {
			finalTime = "30 Minutes";
		} else if ((ind1 == 0 && ind2 == 3) || (ind1 == 0 && ind2 == 4) || (ind1 == 0 && ind2 == 2)) {
			finalTime = "1 Hour & 30 Minutes";
		} else if (ind2 == 5 || ind2 == 6) {
			finalTime = "50 Minutes";
		} else {
			finalTime = "30 Minutes";
		}

		return finalTime;
	}

	public static String getCurrentDate() {
		String x = (java.time.LocalDate.now()).toString();
		return x;
	}

	public static String[] receiveAccount(String[] userNames, String[] userPass, String[][] users, String userN,
			String userP) {
		String[] currentStuff = new String[8];
		for (int i = 0; i < userNames.length; i++) {
			if (userNames[i].compareTo(userN) == 0 && userPass[i].compareTo(userP) == 0) {
				for (int j = 0; j < users[i].length; j++) {
					currentStuff[j] = users[i][j];
				}

				return currentStuff;
			}
		}
		currentStuff[0] = "false";
		return currentStuff;
	}

	public static Boolean checkLoc(String loc) {
		String[] Locations = { "KARACHI", "ISLAMABAD", "LAHORE", "MULTAN", "FAISALABAD", "HYDERABAD", "SUKKUR" };

		for (int i = 0; i < Locations.length; i++) {
			if (loc.compareTo(Locations[i]) == 0)
				return true;
		}

		return false;
	}

	public static void main(String[] args) throws IOException {

		while (true) {
			// Accounts
			String[][] users = new String[1][1];
			users = dataExtraction(users);
			for (int i = 0; i < users.length; i++) {
				// System.out.println(Arrays.toString(users[i]));
			}
			System.out.println();

			// User IDs and Passwords
			String[] userPass = new String[users.length];
			String[] userNames = new String[users.length];
			for (int i = 0; i < users.length; i++) {
				userNames[i] = users[i][3];
				userPass[i] = users[i][4];
			}

			// System.out.println(Arrays.toString(userNames));
			// System.out.println(Arrays.toString(userPass));

			int menu_1;
			int choice = -1;
			int signIn = 0;
			int exit = 0;
			System.out.println(
					"----------------------------------------------------\n\4 \033[36;1;1mWelcome To Nexus Airlines Online Booking Service\033[0m \4\n----------------------------------------------------");

			while (true) {

				System.out.println(
						"1. Sign-In\n2. Guest Login\n3. Create Account\n4. Delete an Existing Account\n5. Cancel An Existing Booking\n6. Exit");
				menu_1 = inputValidation();
				if (menu_1 == 1 || menu_1 == 2 || menu_1 == 3 || menu_1 == 4 || menu_1 == 5 || menu_1 == 6)
					break;
				else
					System.out.println("\033[31;1;1mINVALID INPUT!!\033[0m \nRe-enter: ");
				;
			}

			if (menu_1 == 4) {
				System.out.println("Enter your User Name: ");
				String tempUN = sc.next();

				System.out.println("Enter Your Password: ");
				String tempUP = enterPassword();

				boolean existVar = false;
				int delLine = 0;
				for (int i = 0; i < userNames.length; i++) {
					if (tempUN.equals(userNames[i]) && tempUP.equals(userPass[i])) {
						delLine = (i + 1);
						existVar = true;
						break;
					}
				}

				if (existVar == false) {
					System.out.println("Sorry, No Such Accounts Exist in our Database !");
				}

				else {
					deleteAccount(delLine);
				}

				exit = 1;

			}

			String[] currentStuff = new String[8];

			if (menu_1 == 3 && exit == 0) {
				createAccount();
				exit = 1;
			}

			if (menu_1 == 6)
				exit = 1;

			else if ((menu_1 == 1 || menu_1 == 5) && exit == 0) {
				while (true) {
					System.out.print("Enter:\nUserName: ");
					String userName = sc.next();

					String userPasss = enterPassword();

					currentStuff = receiveAccount(userNames, userPass, users, userName, userPasss);

					if (currentStuff[0].compareTo("false") == 0) {
						System.out
								.println(
										"\033[31;1;1mInvalid User Name or Password\033[0m \n1. to Re-enter User Name & Password\n2. Exit");
						choice = inputValidation();
						if (choice == 2) {
							exit = 1;
							break;
						}

					} else {
						System.out.println("Account Signed In !!\nWelcome Back " + currentStuff[0]);
						signIn = 1;
						break;
					}
				}
				if (menu_1 == 5) {

					try {
						System.out.println("Are You Sure You Want to Cancel Your Booking?\n1. Yes\n2. No");
						choice = inputValidation();
						if (choice == 1) {
							System.out.println("Checking Your Booking...");
							java.util.concurrent.TimeUnit.SECONDS.sleep(2);
							bkCancel(currentStuff[0]);
							exit = 1;
						} else {
							System.out.println("OK, We Appreciate Your Commitment to Our Services");
							exit = 1;
						}
					} catch (InterruptedException e) {
						e.printStackTrace();
					}

				}
			}

			else if (menu_1 == 2 && exit == 0) {
				System.out.println("Enter Following Details: \n-----------------------");

				System.out.print("First Name: ");
				currentStuff[0] = sc.next();

				System.out.print("Last Name: ");
				currentStuff[1] = sc.next();

				System.out.print("Enter your Phone Number: ");
				currentStuff[3] = sc.next();

			}
			if (exit == 0) {
				while (true) {
					System.out.println("1) Book Ticket For Today\n2) Book Ticket For Future Day\n3) Exit");
					choice = inputValidation();
					if (choice == 3) {
						exit = 1;
						break;
					} else if (choice == 2) {
						System.out.println("Enter Date (FORMAT: YYYY-MM-DD) : ");
						currentStuff[2] = sc.next();
						break;
					} else if (choice == 1) {
						currentStuff[2] = getCurrentDate();
						break;
					} else
						System.out.println("\033[31;1;1mINVALID INPUT!!\033[0m \nRe-enter: ");
				}
			}
			if (exit == 0) {
				boolean check0 = true;
				while (check0 == true) {
					System.out.print("Departure Location: ");
					currentStuff[4] = sc.next();
					currentStuff[4] = currentStuff[4].toUpperCase();
					Boolean check1 = checkLoc(currentStuff[4]);
					if (check1 == true)
						check0 = false;
					else {
						while (true) {
							System.out.println(
									"No Such Locations are available at the moment\n1. Re-enter Location\n2. Exit");
							choice = inputValidation();
							if (choice == 2 || choice == 1)
								break;
							else
								System.out.println("\033[31;1;1mINVALID INPUT!!\033[0m ");
						}
						if (choice == 2) {
							exit = 1;
							break;
						}
					}

				}
				if (exit == 0) {
					check0 = true;
					while (check0 == true) {
						System.out.print("Arrival Location: ");
						currentStuff[5] = sc.next();
						currentStuff[5] = currentStuff[5].toUpperCase();
						Boolean check1 = checkLoc(currentStuff[5]);
						if (check1 == true && currentStuff[5].compareTo(currentStuff[4]) != 0)
							check0 = false;
						else if (currentStuff[5].compareTo(currentStuff[4]) == 0) {
							while (true) {
								System.out.println(
										"Departure and Arrival Locations can't be same\n1. Re-enter Location\n2. Exit");
								choice = inputValidation();
								if (choice == 1 || choice == 2)
									break;
								else {
									System.out.println("\033[31;1;1mINVALID INPUT!!\033[0m ");
								}
							}
							if (choice == 2) {
								exit = 1;
								break;
							}
						} else {
							while (true) {
								System.out.println(
										"No Such Locations are available at the moment\n1. Re-enter Location\n2. Exit");
								choice = inputValidation();
								if (choice == 2 || choice == 1) {
									break;
								} else {
									System.out.println("\033[31;1;1mINVALID INPUT!!\033[0m ");
								}
							}
							if (choice == 2) {
								exit = 1;
								break;
							}
						}
					}
				}
			}
			if (exit == 0) {
				currentStuff[6] = flightSelector(currentStuff[4], currentStuff[5]);

				int charges = setCharges(currentStuff[6]);
				if (signIn == 1)
					charges *= 0.20;
				currentStuff[7] = Integer.toString(charges);

				try {
					System.out.println("Checking if seats are available..");
					java.util.concurrent.TimeUnit.SECONDS.sleep(2);
					seatNum = seatBooking(currentStuff[0]);
					System.out.println("Hurrah, Booking Confirmed!!");
					java.util.concurrent.TimeUnit.SECONDS.sleep(2);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}

				// Ticket Generator
				System.out.println("\n-----------------------");
				System.out.println("    \4\033[36;1;4mGenerating Ticket\033[0m \4");
				System.out.println("-----------------------");
				System.out.println("==> Name: " + currentStuff[0] + " " + currentStuff[1]);
				System.out.println("==> Phone Number: " + currentStuff[3]);
				System.out.println("==> Date: " + currentStuff[2]);
				System.out.println("==> Flight: " + currentStuff[4] + " TO " + currentStuff[5]);
				System.out.println("==> Total Flight Time: " + currentStuff[6]);
				System.out.println("==> Charges: " + currentStuff[7]);
				System.out.println("==> Seat Number: " + seatNum);
				System.out.println("Flight: AB1234");
				System.out.println("------------------------");

			}

			if (exit == 0 && currentStuff[1].equals("Zain")) {
				displayImage();
			}

			if (exit == 0 && currentStuff[1].equals("Umar")) {
				displayImage2();
			}

			System.out.println("Do You Want To:\n1) Continue using App\n2) Exit");
			while (true) {
				choice = inputValidation();
				if (choice == 1 || choice == 2) {
					break;
				} else {
					System.out.println("\033[31;1;1mINVALID INPUT!!\033[0m ");
				}
			}
			if (choice == 2) {
				exit = 1;
			}

			if (choice == 1)
				continue;
			if (exit == 1) {
				System.out.println("\nGoodBye\nHope To See You Again Soon :D");
				break;
			}
			break;

		}

	}
}