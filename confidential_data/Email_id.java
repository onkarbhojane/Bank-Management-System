package confidential_data;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class Email_id{
	int count=0;
	String temp="";
	String email_id;
	coder code=new coder("","","");
	public String verify(String name,String mobile_no) throws IOException{
		File f1=new File("C:\\Users\\viyanshi\\OneDrive\\Desktop\\SY 1st sem\\OOPS project\\Bank_management_system\\BANK DATA\\"+name+".txt");
		if(f1.exists()==true) {
			FileInputStream file=new FileInputStream(f1);
			int i=0;
			while(i!=-1) {
				i=file.read();
				if(i=='!') {
					count++;
				}
				if(count==2 &i!='!') {
					temp=temp+(char)i;
				}
			}
		}
		return code.decrypter(temp);
}
}
