import java.util.Scanner;
import java.util.*; 
import java.util.HashMap;
import java.io.*;

class Zad2{
	public static void main(String[] args) {
		Tree tree = new Tree('a',1);
		tree.root.add('b',10);
		tree.root.add('b',10);
		int a = Zad2.sumVal (tree,tree.root,tree.root);
		System.out.println(a); 
	}
	static char[] alphabet = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};
	public static int sumVal (Tree t,Vertex u, Vertex v){
		A a = sumVal(u,v);
		return a.value;
	}

	public static A sumVal (Vertex u, Vertex v){
		if(u.isItLeaf() && v.isItLeaf()){
			if(u.symbol == v.symbol){
				return new A(u.value + v.value,1);
			}
			else{
				return new A(0,0);
			}
		}
		else if(u.isItLeaf() || v.isItLeaf()){
			return new A(0,0);
		}
		else{
			A tmp;
			int value = 0;
			int num = 0;
			if(u.symbol == v.symbol){
				for(int i=0;i<alphabet.length;i++){
					if(u.childs.get(alphabet[i]) == null){
						continue;
					}
					if(v.childs.get(alphabet[i]) == null){
						continue;
					}
					for(int j=0; j<u.childs.get(alphabet[i]).size(); j++){
						for(int k=0;k<v.childs.get(alphabet[i]).size();k++){
							tmp = Zad2.sumVal(u.childs.get(alphabet[i]).get(j),v.childs.get(alphabet[i]).get(k));
							value += tmp.value;
							num += tmp.num;
						}
					}
				}
				return new A(value+num*(u.value+v.value),num);
			}
			else{
				return new A(0,0);
			}
		}
	}

}

class A{
	public int value;
	public int num;
	public A(int v,int b){
		value = v;
		num = b;
	}
}
class Vertex{
	public char symbol;
	public int value;
	public HashMap<Character,ArrayList<Vertex>> childs;
	public boolean isItLeaf(){
		return childs.isEmpty();
	}
	public Vertex(char symbol,int value){
		this.symbol = symbol;
		this.value = value;
		childs = new HashMap<Character,ArrayList<Vertex>>(); 
	}
	public void add(char sym,int val){
		if(!childs.containsKey(sym)){
			childs.put(sym,new ArrayList<Vertex>());
		}
		childs.get(sym).add(new Vertex(sym,val));
	}
}
class Tree{
	Vertex root;
	public Tree(char c, int v){
		root = new Vertex(c,v);
	}
}