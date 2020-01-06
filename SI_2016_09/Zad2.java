import java.util.Scanner;

class Zad2{
	//static Tree makeTree(int k, int[] a){
	//	return new Tree();
	//}
	static int k;
	static int sizeA;
	static int a[];
	static void read(){
		Scanner scanner = new Scanner(System.in);
		System.out.print("\nenter number K \n");
		Zad2.k = scanner.nextInt();

		System.out.print("\nenter size of array A \n");
		Zad2.sizeA = scanner.nextInt();
		Zad2.a = new int[Zad2.sizeA];
		System.out.print("\nenter array A \n");
		for(int i=0; i<sizeA; i++){
			Zad2.a[i] = scanner.nextInt();
		}
	}
	public static void main(String[] args) {
		Zad2.read();
		Tree tree = new Tree(Zad2.k,Zad2.a);
		tree.hipifi();
		tree.show();
	}
}
class Tree{
	int k;
	int[] a;
	int[] parent;
	public Tree(int k,int[] a){
		this.k = k;
		this.a = a;
	}
	int parent(int i){
		return (i-1)/k;
	}
	int son(int num,int i){
		return k*i+1+num;
	}
	int hipi(int h){
		int minAddres = h;
		for(int i=0; i<k; i++){
			if(son(i,h)<a.length && a[minAddres] > a[son(i,h)]){
				minAddres  = son(i,h);
			}
		}
		if(minAddres == h){
			return -1;
		}
		else{
			return minAddres;
		}
	}
	void hipifi(){
		int h,tmp,hi;
		for(int i=parent(a.length) ; i>=0; i--){
			h=i;
			hi = hipi(h);
			while(hi != -1){
				tmp = a[h];
				a[h] = a[hi];
				a[hi] = tmp;
				h = hi;
				hi = hipi(h);
			}
		}
	}
	public void show(){
		System.out.println();
		int interval = (int)Math.round(Math.log((double)(a.length*(k-1)+1)))-1;
		String in = "";
		int p=0;
		int tmpP=0;
		for(int i=0; i<=interval; i++){
			System.out.print("\n");
			in = "";
			for(int j=0; j<(interval-i)*k+1; j++){
				in += " ";
			}
			tmpP = p;
			for(; p<Math.pow(k,i)+tmpP && p<a.length;p++){				
				System.out.print(a[p]);
				System.out.print(in);
			}
			//p = p+(int)Math.pow(k,i);
			System.out.print("\n");
		}
	}
}