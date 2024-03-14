package confidential_data;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class add_money{
	public add_money(String name, String mobile_no, String amount)throws IOException {
		// TODO Auto-generated constructor stub
		File f1=new File("C:\\Users\\viyanshi\\OneDrive\\Desktop\\SY 1st sem\\OOPS project\\Bank_management_system\\BANK DATA\\"+name+".txt");
		FileOutputStream file=new FileOutputStream(f1,true);
		int i=0;
		while(i<amount.length()) {
			file.write(amount.charAt(i));
			if(i==amount.length()-1) {
				file.write('!');
			}
			i++;
		}
	}
}