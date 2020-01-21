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
	List<Integer[]> tree; //= new Vextor(Integer[3]);//father left-son raite-brither
	
	void bild(){
		try {    
			int r = 0; 
			int sig = 1;
			int num = 0;
			boolean inNum = false;

			int level = 0;

			int last = -1;
			int lastLevel = -1;
			//int lastFather = -0;
			//boolean hasBrother = false;
			//int lastBrother = -0;
			int levelUp;
			int tmp;
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
				else if(inNum == true){ //r!= 0,1,2,3,4,5,6,7,8,9
					num = num*sig;
					sig = 1;
					inNum = false;

					tree.add(new Integer[4]);
					tree.get(last+1)[3] = num;
					if(lastLevel == level){
						//new brother
						if(last == -1){
							tree.get(0)[2] = last+1;//brother
							//tree.get(0)[0] = last;
						}else{
							//make father on last+1 like father on last 
							tree.get(last+1)[0] = tree.get(last)[0];
							tree.get(last)[2] = last+1;
						}
					}
					else if( level == lastLevel+2){
						// new son
						if(last == -1){
							tree.get(0)[1] = last+1;
							//tree.get(0)[0] = last;
						}
						else{
							tree.get(last+1)[0] = last;
							tree.get(last)[1] = last+1;
						}
					}
					else{
						levelUp = (lastLevel - level)/2;
						//System.out.printf("level %d   lastLevelt %d  num %d\n",level,lastLevel,num);
						tmp = last;
						for(int i = 0; i<levelUp; i++){
							tmp = tree.get(tmp)[0];
						}
						tree.get(tmp)[2] = last+1;
						tree.get(last+1)[0] = tree.get(tmp)[0];
					}
					
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
	int max(){
		int max = 0;
		int node = 0;
		int sum = tree.get(0)[3];
		boolean used[] = new boolean[tree.size()];
		while(true){
			//System.out.printf("node %d sum %d \n",tree.get(node)[3],sum);
			if(max < sum){
				max = sum;
			}
			if(tree.get(node)[1] != null && !used[tree.get(node)[1]]){
				node = tree.get(node)[1];
				sum += tree.get(node)[3];
			}else if(tree.get(node)[2] != null && !used[tree.get(node)[2]]){
				sum -= tree.get(node)[3];
				node = tree.get(node)[2];
				sum += tree.get(node)[3];
			}else if(tree.get(node)[0] != null){
				sum -= tree.get(node)[3];
				node = tree.get(node)[0];
			}
			else{
				return max;
			}
			used[node]=true;
		}
	}
	void show(){
		for(int i=0;i<tree.size();i++){
			System.out.printf("Node %d      Father %d     son %d      Brother %d      value %d\n",i,tree.get(i)[0],tree.get(i)[1],tree.get(i)[2],tree.get(i)[3]);
		}
	}
	void show2(){
		int tmp;
		System.out.printf("%d\n",tree.get(0)[3]);
		for(int i=1; i< tree.size();i++){
			//level = 0;
			tmp = i;
			while(tmp != 0){
				tmp = tree.get(tmp)[0];
				System.out.printf("  ");
			}
			System.out.printf("%d\n",tree.get(i)[3]);
		}
	}
	//static makeNumber()
	public static void main(String[] args) {
		Zad2_07_2016 foo = new Zad2_07_2016();
		foo.bild();
		//foo.show();
		//foo.show2();
		System.out.printf("%d",foo.max());
	}
}