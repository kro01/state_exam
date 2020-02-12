import java.io.*;

public class FileReaderExample {  
    public static void main(String args[])throws Exception{    
          FileReader fr=new FileReader(".\n.txt");    
          int i;    
          while((i=fr.read())!=-1)    
          System.out.print((char)i);    
          fr.close();    
    }    
}    