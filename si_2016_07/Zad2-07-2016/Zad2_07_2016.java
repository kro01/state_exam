import java.io.*;  
import java.util.Scanner;  
import java.util.*; 

class Zad2_07_2016{
	public  Zad2_07_2016(){
		try{
			fis = new FileInputStream("C:\\Octave\\txt.txt");
		}catch(Exception e){  
			e.printStackTrace();  
		}
		tree = new Vector<Integer[]>(20);//(20);
	}
	FileInputStream fis;
	List<Integer[]> tree; //= new Vextor(Integer[3]);//parent left-son raite-brither
	
	void bild(){
		try {    
			int r = 0; 
			int sig = 1;
			int num = 0;
			boolean inNum = false;

			int level = 0;

			int last = -1;
			int lastLevel = -1;
			int lastFather = -0;
			boolean hasBrother = false;
			int lastBrother = -0;

			while((r=fis.read())!=-1)  
			{  
				//make number
				if(r =='-'){sig = -1;continue;}
				if(r >= '0' && r <='9'){
					if(inNum == false){
						inNum = true;
						num = 0;
					}
					num = num*10;
					num = num + r-'0';
				}
				else if(inNum == true){
					num = num*sig;
					sig = 1;
					inNum = false;

					tree.add(new Integer[4]);
					if(lastLevel != level){
						lastFather = last;
					}
					tree.get(last+1)[0] = lastFather;
					if(last == -1){
						if(lastLevel == level ){
							tree.get(0)[2] = last+1;//brother
						}else{
							tree.get(0)[1] = last+1;//father
						}
					}
					else if(last != -1){
						if(lastLevel == level ){
							tree.get(last)[2] = last+1;//brother
						}else{
							tree.get(last)[1] = last+1;//father
						}
					}
					
					tree.get(last+1)[3] = num;
					//num = Integer.MIN_VALUE;
					num = 0;
					last++;
					lastLevel = level;
				}

				if(r=='('){
					level++;
				}
				if(r==')'){
					level--;
				}
			}  
		}  
		catch(Exception e){  
			e.printStackTrace();  
		}  
	}
	void show(){
		for(int i=0;i<tree.size();i++){
			System.out.printf("Node %d      Father %d     son %d      Brother %d      value %d\n",i,tree.get(i)[0],tree.get(i)[1],tree.get(i)[2],tree.get(i)[3]);
		}
	}
	
	//static makeNumber()
	public static void main(String[] args) {
		Zad2_07_2016 foo = new Zad2_07_2016();
		foo.bild();
		foo.show();
	}
}