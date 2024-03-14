package confidential_data;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
public class account_creation {
	static int counter=1000;
	String name1="";
	long Mobile_no;
	String account_no;
	String Email_id;
	
	String data[]=new String[3];//for getting encrpted data
	public void set(String name,String mobile_no,String email_id) throws IOException {
		File file0=new File("C:\\Users\\viyanshi\\OneDrive\\Desktop\\SY 1st sem\\OOPS project\\Bank_management_system\\BANK DATA\\"+name+".txt");
		FileOutputStream file=new FileOutputStream(file0);//creating file of name
		int i=0;
		
		coder code=new coder(name,mobile_no,email_id);
		data=code.encrpter();
				
		i=0;
		int k=0;
		while(k<3) { //writting encrpted data to file
			i=0;
			while(i<data[k].length())
			{
				file.write(data[k].charAt(i));
				if(i==data[k].length()-1) {
					file.write('!');
				}
				i++;
			}
			k++;
		}
		
		file.close();
	}
	
	public int count(String name) throws IOException {//used to count number of '!' / counters in file
		FileInputStream file1=new FileInputStream("C:\\Users\\viyanshi\\OneDrive\\Desktop\\SY 1st sem\\OOPS project\\Bank_management_system\\BANK DATA\\"+name+".txt");
		int i=0;
		int n=0;
		while(i!=-1) {
			i=file1.read();
			if(i=='!') {
				n++;
			}
		}
		return n;
	}
//changing mobile number
	public void change_mobin(String name,String mobile,String mobile_no1) throws IOException {
		File file=new File("C:\\Users\\viyanshi\\OneDrive\\Desktop\\SY 1st sem\\OOPS project\\Bank_management_system\\BANK DATA\\"+name+".txt");
		FileOutputStream fileo=new FileOutputStream("C:\\Users\\viyanshi\\OneDrive\\Desktop\\SY 1st sem\\OOPS project\\Bank_management_system\\BANK DATA\\"+name+".txt",true);
		FileInputStream file1=new FileInputStream("C:\\Users\\viyanshi\\OneDrive\\Desktop\\SY 1st sem\\OOPS project\\Bank_management_system\\BANK DATA\\"+name+".txt");
		int i=0;
		int count=0;
		int flag=0;
		int n=this.count(name);
		String before="";
		String after="";
		//System.out.println(n);
		while(i!=-1) {
			i=file1.read();
			
			if(count<1) {
				before =before+(char)i;
			}
			
			if(count>=2 & count<n) {
				after=after+(char)i;
			}
			
			if(i=='!') {
				count++;
			}
			
		}
		
		file.delete();
		File filen=new File("C:\\Users\\viyanshi\\OneDrive\\Desktop\\SY 1st sem\\OOPS project\\Bank_management_system\\BANK DATA\\"+name+".txt");
		FileOutputStream file2=new FileOutputStream(filen);
		coder code=new coder("","","");
		for (int j=0;j<before.length();j++) {
			file2.write(before.charAt(j));
		}
		
		for (int j=0;j<code.encrpter(mobile_no1).length();j++) {
			file2.write(mobile_no1.charAt(j));
			if(j==mobile_no1.length()-1) {
				file2.write('!');
			}
		}
		
		for (int j=0;j<after.length();j++) {
			file2.write(after.charAt(j));
		}
		
	}
}
