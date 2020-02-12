import java.io.*;
//import Math;

public class Zad2 {

	public Node root;

	public Zad2(){
		root = new Node();
	}

    public static void main(String[] args) {
        Zad2 z = new Zad2();
        //String pathe = System.console().readLine();
        int[] pathe = {1,2,3,4,5,6,7,8,9};
        z.readList(pathe);
        System.out.println(z.member(11));
         System.out.println(z.member(2));
          System.out.println(z.member(4));
           System.out.println(z.member(7));

        //System.out.println("Hello, World");
    }
    public boolean member(int c){
    	Node tmp = root;
    	System.out.println(tmp.value);
    	if(c == tmp.value){
    		return true;
    	}
    	else if(c < tmp.value){
    		return false;
    	}
    	// c < root.value
    	while(c > tmp.jump.value){

    		tmp = tmp.jump;
    		System.out.println(tmp.value);
    		if(tmp.jump == null){
    			break;
    		}
    	}
    	if(tmp.jump != null && c == tmp.jump.value){
    		return true;
    	}
    	Node end = tmp.jump;
    	while(tmp != end){
    		System.out.println(tmp.value);
    		if(c == tmp.value){
    			return true;
    		}
    		else{
    			tmp = tmp.next;
    		}
    	}
    	return false;
    }
    public void readList(int[] n){
    	//FileReader fr = new FileReader(pathe);
    	int i=0;
    	int readed;
    	Node last;
    	Node lastJump;
    	int sqrt = (int)Math.sqrt(n.length);
    	//fr.read(readed);
    	if(n.length != 0){
    		readed = n[i];
    		root.value = readed;
    		last = root;
    		lastJump = root;
    		i++;
    	}
    	else{
    		return;
    	}
    	while(n.length > i){
    		readed = n[i];
    		//System.out.println(readed);
    		last.next = new Node();
    		last.next.value = readed;
   			last = last.next;
   			if(i%sqrt == 0 && i!=0){
   				lastJump.jump = last;
   				lastJump = last;
   				//System.out.println(lastJump.value);
   			}
   			i++;
    	}
    }

}

class Node{
	public int value;
	public Node next;
	public Node jump;
}