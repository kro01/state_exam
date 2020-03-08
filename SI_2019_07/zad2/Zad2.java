class Zad2{
	int bro[];
	int father[];
	int son[];
	int val[];
	char sym[];
	public Zad2(int[] bro,int[] father,int[] son, int[] val,char[] sym){
		this.bro = bro;
		this.father = father;
		this.son = son;
		this.val = val;
		this.sym = sym;
	}
	static int sumVal(Zad2 z,int v,int u){
		Result result = sum(z,v,u);
		return result.value*result.reapet;
	}
	static Result sum(Zad2 z,int v,int u){
		//System.out.printf("%d %d\n",v,u);
		Result result = new Result();
		result.value = 0;
		result.reapet = 0;
		Result tem;
		int p;
		int t = z.son[v];
		if(t== -1 && z.son[u] == -1){
			result.value = z.val[u]+z.val[v];
			result.reapet = 1;
			return result;
		}else if(t== -1 ^ z.son[u] == -1){
			result.value = 0;
			result.reapet = 0;
			return result;
		}else{
			while(t != -1){
				p = z.son[u];
				while(p != -1){
					if(z.sym[t] == z.sym[p]){
						tem = sum(z,t,p);
						result.value += (tem.value+z.val[u]+z.val[v])*tem.reapet;
						result.reapet += tem.reapet;
					}
					p = z.bro[p];
				}
				t = z.bro[t];
			}
			return result;
		}
	}
	static void test(){
				      //  0,  1,  2, 3
		int[] bro    = { -1,  2, -1,-1};
		int[] father = { -1,  0,  0, 2};
		int[] son    = {  1, -1,  3,-1};
		int[] val    = {  1,  2,  4, 8};
		char[] sym   = {'a','b','a','b'};
		Zad2 z = new Zad2(bro,father,son,val,sym);
		System.out.printf("%d\n",Zad2.sumVal(z,0,2));
	}
	public static void main(String[] args) {
		Zad2.test();
	}
}
class Result{
	public int reapet;
	public int value;
}