import java.io.*;  
import java.util.Scanner;  

public class zad2_07_2016 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try  
		{  
			//constructor of file class having file as argument  
			File file=new File("C:\\demo\\demofile.txt");   
			FileInputStream fis=new FileInputStream(file);     //opens a connection to an actual file  
			System.out.println("file content: ");  
			int r=0;  
			while((r=fis.read())!=-1)  
			{  
			System.out.print((char)r);      //prints the content of the file  
			}  
			}  
			catch(Exception e)  
			{  
			e.printStackTrace();  
			}  il
	}

}
