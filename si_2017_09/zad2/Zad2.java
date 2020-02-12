//
class Zad2{
	//0-[number] 1-[addres of next number] 2-[adres of privias]
	int nodes[][];
	int lists[];
	public Zad2(int nodes[][],int lists[]){
		this.nodes = nodes;
		this.lists = lists;
	}
	public void show(int no){
		System.out.printf("show\nnumber  node\n");
		int i=0;
		while(no!= -1 && i<20){
			System.out.printf("%d        %d\n",nodes[no][0],no);
			no = nodes[no][1];
			i++;
		}
	}
	public void showAll(){
		for(int i=0;i<nodes.length;i++){
			System.out.printf("%d %d %d\n",nodes[i][0],nodes[i][1],nodes[i][2]);
		}
	}
	public int reverse(int no){
		int tmp; 
		while(nodes[no][1] != -1){
			tmp = nodes[no][1];
			nodes[no][1] = nodes[no][2];
			nodes[no][2] = tmp;

			no = nodes[no][2];
		}
		return no;
	}
	public int merge(int t1,int t2){
		//System.out.printf("t1=%d t2=%d\n",t1,t2);
		int i = 0;
		int start,last;
		if(nodes[t1][0] < nodes[t2][0]){
			start = last = t1;
			t1 = nodes[t1][1];
		}else{
			start = last = t2;
			t2 = nodes[t2][1];
		}

		while(nodes[last][1] != -1 && i<20){
			i++;
			//System.out.printf("%d %d\n",t1,t2);
			if(nodes[t1][0] < nodes[t2][0]){
				nodes[last][1] = t1;
				nodes[t1][2] = last;
				last = t1;
				t1 = nodes[t1][1]; 
			}else{
				nodes[last][1] = t2;
				nodes[t2][2] = last;
				last = t2;
				t2 = nodes[t2][1];

			}
		}
		if(t1 == -1){
			nodes[last][1] = t2;
			nodes[t2][2] = last;
		}else if(t2 == -1){
			nodes[last][1] = t1;
			nodes[t1][2] = last;
		}
		return start;
	}
	public int sort(){
		int start = -1;
		boolean first = true;

		for(int i=0; i<lists.length; i++){
			if(isListSort(lists[i])){
				if(!grow(lists[i])){//disending
						lists[i] = reverse(lists[i]);
					}
				if(first){
					start = lists[i];
					first = false;
				}
				else{
					start = merge(start,lists[i]);
				}
			}	
		}
		return start;
	}
	public boolean grow(int start){
		if(nodes[start][0] < nodes[nodes[start][1]][0]){
			return true;
		}else{
			return false;
		}
	}
	public boolean isListSort(int no){
		boolean grow = grow(no);
	
		while(nodes[no][1]!=-1){
			if((nodes[no][0] < nodes[nodes[no][1]][0]) != grow){
				return false;
			}
			no = nodes[no][1];
		}
		return true;
	}
	public static void main(String[] args){
		//0-[number] 1-[addres of next number] 2-[adres of privias]
		Zad2.test();
	}
	static void test2(){
		int lists[] = {0,4};
		int nodes[][] = {{1,1,-1},{3,2,0},{5,3,2},{7,-1,2},
					   {2,5,-1},{4,6,4},{6,7,5},{8,-1,6}};

		Zad2 z = new Zad2(nodes,lists);
		z.show(z.merge(0,4));
		//z.showAll();			   
	}
	static void test(){
		int lists[] = {0,5,10,14,17};
		int nodes[][] = {{1,1,-1},{3,2,0},{7,3,1},{9,4,2},{13,-1,3},
						{1,6,-1},{2,7,5},{4,8,6},{5,9,7},{9,-1,8},
						{1,11,-1},{2,12,10},{3,13,11},{2,-1,12},
						{4,15,-1},{9,16,14},{100,-1,15},
						{10,18,-1},{5,19,17},{1,-1,18}};
		Zad2 z = new Zad2(nodes,lists);
		boolean result = true;

		System.out.printf("grow %d %b\n",0,z.grow(0));
		result = result && (z.grow(0) == true);

		System.out.printf("grow %d %b\n",5,z.grow(5));
		result = result && (z.grow(5) == true);

		System.out.printf("grow %d %b\n",10,z.grow(10));
		result = result && (z.grow(10) == true);

		System.out.printf("grow %d %b\n",14,z.grow(14));
		result = result && (z.grow(14) == true);

		System.out.printf("grow %d %b\n",17,z.grow(17));
		result = result && (z.grow(17) == false);

		System.out.printf("isListSort %d %b\n",0,z.isListSort(0));
		result = result && (z.isListSort(0) == true);

		System.out.printf("isListSort %d %b\n",1,z.isListSort(1));
		result = result && (z.isListSort(1) == true);

		System.out.printf("isListSort %d %b\n",3,z.isListSort(3));
		result = result && (z.isListSort(3) == true);

		System.out.printf("isListSort %d %b\n",5,z.isListSort(5));
		result = result && (z.isListSort(5) == true);

		System.out.printf("isListSort %d %b\n",10,z.isListSort(10));
		result = result && (z.isListSort(10) == false);

		System.out.printf("isListSort %d %b\n",14,z.isListSort(14));
		result = result && (z.isListSort(14) == true);
		
		System.out.printf("isListSort %d %b\n",17,z.isListSort(17));
		result = result && (z.isListSort(17) == true);
		

		z.show(z.sort());
		//z.showAll();
		System.out.printf("\nWas test sucses: %b",result);
	}
}