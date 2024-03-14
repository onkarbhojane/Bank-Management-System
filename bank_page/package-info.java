package bank_page;
import java.io.IOException;
import java.util.Scanner;

import confidential_data.Email_id;
import confidential_data.account_creation;
import confidential_data.add_money;
import confidential_data.check_account;
import confidential_data.Transaction_History;
class front{
	//private static final String String = null;

	public static void main(String []arg) throws IOException {
		Scanner sc=new Scanner(System.in);
		check_account c1=new check_account();
		check_account c2=new check_account();
		check_account c3=new check_account();
		check_account c4=new check_account();
		check_account c5=new check_account();
		check_account c6=new check_account();
		int chance=0;
		int o;
		int create_account=0;
		Transaction_History tr=new Transaction_History();
		account_creation acc=new account_creation();
		System.out.println("                     W E L C O M E \n\n");	
		System.out.println("HOW CAN I HELP YOU PLEASE SELECT OPTION WHICH YOU WANT TO DO ");
		int n=1;
		System.out.println("\n1.Create Account\n2.LOGIN ");
		while(n==1) {
				if(create_account==1) {
					o=1;	
					System.out.print("\nCREATE ACCOUNT YOU DO NOT HAVE ANY ACCOUNT :: ");
				}else {
					System.out.print("\nEnter your Option :: ");
					o=sc.nextInt();
				}
			switch(o){
				case 1://account creation
					System.out.print("\nEnter your Name :: ");
					String name=sc.next().toLowerCase();
					System.out.println("\nEnter your Mobile Number :: ");
					String mobile_no=sc.next();
					if (c5.verify_account(name,mobile_no)==true) {
						System.out.println("\nACCOUNT ALREADY EXIST !!! PLEASE LOGIN ");
					}else {
						System.out.println("\nEnter your email_id :: ");
						String email_id=sc.next().toLowerCase();
						acc.set(name,mobile_no,email_id);
						System.out.println("\nACCOUNT CREATED SUCCESFULLY !!!");
						create_account=0;
						name="";
						mobile_no="";
					}
					break;
				case 2://LOGIN to account
					System.out.print("\nenter your name :: ");
					String name1=sc.next();
					System.out.println("\nenter your mobile number :: ");
					String mobile_no1=sc.next();
					if(c1.verify_account(name1,mobile_no1)==true) {//goes to check_account file
						System.out.println("\nSUCCESFULLY LOGIN TO YOUR ACCOUNT !!!");
						System.out.println("\nHOW CAN I HELP YOU PLEASE SELECT OPTION WHICH YOU WANT TO DO ");
						System.out.println("\n1.money add\n2.Money Transfer\n3.Balance Check\n4.Change Mobile No.\n5.Transaction History\n6.PassBook\n");
						int a=1;
						while(a==1) {
							System.out.print("\nEnter your Option :: ");
							int c=sc.nextInt();
							switch(c) {
							  	case 1://adding money
							  		System.out.println("\nENTER YOUR AMOUNT :: ");
							  		String amount=sc.next();
							  		new add_money(name1,mobile_no1,amount);//creating object for calling constructor
							  		System.out.println("\n      SUCCESSFULLY "+amount+"rs ADDED TO YOUR ACCOUNT !!!");
							  		break;
							  	case 2://Transferring money 
							  		System.out.print("\nenter name of account holder :: ");
									String name2=sc.next();
									System.out.println("\nenter mobile number of account holder :: ");
									String mobile_no2=sc.next();//mobile no not in spaced values
									if(c2.verify_account(name2,mobile_no2)==true) {
										System.out.print("\nENTER YOUR AMOUNT :: ");
										String amount2=sc.next();//amount is not in spaced values
										if(c3.verify_bal(name1,mobile_no1,amount2)==true) {
											new add_money(name2,mobile_no2,amount2);//creating object for calling constructor
									  		System.out.println(amount2+"rs SUCCESSFULLY transfered !!!");
									  		new add_money(name1,mobile_no1,"-"+amount2);
										}else {
											System.out.println("\nBALANCE IS INSUFFICIENT !!!");
										}
									}else {
										System.out.println("\nINVALID ACCOUNT !!! REENTER ACCOUNT DETAILS !!!");
									}
									break;
							  	case 3://checking balance 
							  			System.out.println(c4.verify_bal(name1,mobile_no1)+"rs");
							  		break;
							  	case 4 ://Mobile number change
							  		System.out.print("\nenter your name :: ");
									String name3=sc.next();
									System.out.println("\nenter your mobile number :: ");
									String mobile_no3=sc.next();
									if(c6.verify_account(name3,mobile_no3)==true) {
										System.out.println("\nenter your new mobile number :: ");
										String mobile_no4=sc.next();
										acc.change_mobin(name3,mobile_no3,mobile_no4);
										System.out.println("\nYOUR MOBILE NUMBER SUCCESSFULLY UPDATAED !!!");
									}else {
										System.out.println("\nWRONG NAME OR MOBILE NUMBER !!!");
									}
									break;
							  	case 5 ://transaction history
							  		tr.transaction_history(name1,mobile_no1);
							  		break;
							  	case 6 :
							  		System.out.println("             P A S S B O O K");
							  		System.out.println("\nACCOUNT NAME :: "+name1);
							  		System.out.println("\nLINKED MOBILE NUMBER :: "+mobile_no1);
							  		System.out.println("\nLINKED EMAIL ID :: "+(new Email_id()).verify(name1,mobile_no1));
							  		break;
							  	default :
							  		System.out.println("\nOHHH !, YOU CHOOSEN WRONG OPTION PLEASE RE-LOGIN !!!");
							  		a=0;
							}
						}
					}else {
						if(chance>=3) {
							System.out.println("\nYOU REACHED MAXIMUM NUMBER OF ATTEMPT PLEASE CONTACT YOUR BRANCH MANAGER OR CREATE ACCOUNT ");
							System.out.print("\nEnter 1 for creating account :: ");
							create_account=sc.nextInt();
						}else {
							System.out.println("\nRE-ENTER account Details or KINDLY check if account is created \n"+"ATTEMPT NO :: "+chance);
						}
						chance++;
						n=1;
					}
					break;
				default :
					System.out.println("\nOHHH !, YOU CHOOSEN WRONG OPTION CHOOSE CORRECT OPTION !!!");
					n=1;
				}
			}
		}
		
	}
