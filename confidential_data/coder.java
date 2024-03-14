package confidential_data;
import java.util.Random;
public class coder{
	Random ran=new Random();
	int p;
	String data[]=new String[] {"","",""};
	public coder(String name,String Mobile_no,String Email_id){
		
			for (int i=0;i<name.length();i++) {
				data[0]=data[0]+name.charAt(i);
			}
			
			for (int i=0;i<Mobile_no.length();i++) {
				data[1]=data[1]+Mobile_no.charAt(i);
			}
			
			for (int i=0;i<Email_id.length();i++) {
				data[2]=data[2]+Email_id.charAt(i);
			}
	}
	
	public String[] encrpter() {
		p=ran.nextInt(9);
		int k=0;
		String temp="";
		while(k<3) {
			for (int i=0;i<data[k].length();i++) {
				if(i==0) {
					temp=temp+p;
				}
				temp=temp+(char)((int)data[k].charAt(i)+p+1);
			}
			data[k]=temp;
			//System.out.println(temp);
			temp="";
			k++;
		}
		
		return data;
	}
	
	public String decrypter(String data) {
		int k=0;
		String temp;
		String temp1="";
		int p=0;
		
		for (int i=0;i<data.length();i++) {
			if(i==0) {
				p=Integer.parseInt(String.valueOf(data.charAt(i)));
			}else {
				temp1=temp1+(char)((int)data.charAt(i)-p-1);
			}
		}	
		return temp1;
	}
	
	public String encrpter(String data) {
		p=ran.nextInt(9);
		int k=0;
		String temp="";
		
			for (int i=0;i<data.length();i++) {
				if(i==0) {
					temp=temp+p;
				}
				temp=temp+(char)((int)data.charAt(i)+p+1);
			}		
		return temp;
	}
}