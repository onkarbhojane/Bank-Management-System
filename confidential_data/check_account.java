package confidential_data;

import java.io.*;

public class check_account{
	boolean bool;
	private int amount;
	int count=0;
	int flag=0;
	String temp="";
	private Object Interger;
	String data[]=new String[3];//getting decoded data
	public boolean verify_account(String name,String mobile_no) throws IOException{
		coder code=new coder(name,mobile_no,"");
		File f1=new File("C:\\Users\\viyanshi\\OneDrive\\Desktop\\SY 1st sem\\OOPS project\\Bank_management_system\\BANK DATA\\"+name+".txt");
		if(f1.exists()==true) {
			FileInputStream file=new FileInputStream(f1);
			int i=0;
			while(i!=-1) {
				i=file.read();
				if(i=='!') {
					count++;
				}else{
					temp=temp+(char)i;
				}
				if(count==1) {
					if(code.decrypter(temp).equals(name)) {
						flag++;
						temp="";
					}
				}
				if(count==2) {
					if(code.decrypter(temp).equals(mobile_no)) {
						flag++;
						temp="";
					}
				}
			}
		}
		if(flag==2) {
			return true;
		}return false ;
}
	
	
	public boolean verify_bal(String name,String mobile_no,String amount ) throws IOException{
		File f1=new File("C:\\Users\\viyanshi\\OneDrive\\Desktop\\SY 1st sem\\OOPS project\\Bank_management_system\\BANK DATA\\"+name+".txt");
		int sum=0;
		int mul=1;
		int flag=0;
		if(f1.exists()==true) {
			FileInputStream file=new FileInputStream(f1);
			int i=0;
			while(i!=-1) {
				i=file.read();
				if(i=='!') {
					count++;
					flag=1;
				}else{
					if(i=='-') {
						mul=-1;//checking negative number;
					}else if(count>=3) {
						temp=temp+(char)i;
					}
				}
				if(count>=4 && flag==1) {
						int t=Integer.parseInt(temp);
						sum=sum+mul*t;
						flag=0;
						mul=1;
						temp="";
				}
			}
		}
		int p=Integer.parseInt(amount);  
		this.amount=p;
		if(sum>=p){
			return true;
		}return false;
	}
	public int verify_bal(String name1,String mobile_no1) throws IOException{
		File f1=new File("C:\\Users\\viyanshi\\OneDrive\\Desktop\\SY 1st sem\\OOPS project\\Bank_management_system\\BANK DATA\\"+name1+".txt");
		int sum=0;
		int mul=1;
		if(f1.exists()==true) {
			FileInputStream file=new FileInputStream(f1);
			int i=0;
			while(i!=-1) {
				i=file.read();
				if(i=='!') {
					count++;
					if(count>=4 ) {
						int t=Integer.parseInt(temp);
						sum=sum+t;
						mul=1;
						temp="";
					}
					if(count==3 ) {
						temp="";
						//System.out.println(temp);
					}
				}else{
					if(i=='-') {
						mul=-1;//checking negative number;
						//System.out.println(mul);
					}if(count>=3) {
						temp=temp+(char)i;
						//System.out.println(temp);
					}
				}
			}
		}
		return sum;
	}
	
}