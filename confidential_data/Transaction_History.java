package confidential_data;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class Transaction_History{
	int count=0;
	String temp="";
	int j=0;
	public void transaction_history(String name1,String mobile_no1) throws IOException{
		File f1=new File("C:\\Users\\viyanshi\\OneDrive\\Desktop\\SY 1st sem\\OOPS project\\Bank_management_system\\BANK DATA\\"+name1+".txt");
		count=0;
		int sum=0;
		int mul=1;
		if(f1.exists()==true) {
			FileInputStream file=new FileInputStream(f1);
			int i=0;
			while(i!=-1) {
				i=file.read();
				if(i=='!') {
					count++;
					if(count<=3) {
						temp="";
					}
					if(count>3 ) {
						System.out.println(temp+" rs");
						temp="";
					}
				}else{
					if(count>=3) {
						temp=temp+(char)i;
					}
				}
			}
		}
	}
}