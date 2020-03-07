class Zad1{
	boolean used[][];
	//int t_x,t_y,t_str;
	char[][] arr;
	String str;
	int[][] path;
	
	boolean contains(char[][] arr,String str){
		used = new boolean[6][6];
		for(int i=0;i<6;i++){
			for(int j=0;j<6;j++){
				used[i][j] = false;
			}
		}
		path = new int[36][2];
		this.arr = arr;
		this.str = str;
		
		//find starting point
		boolean result = false;
		for(int i=0;i<6;i++){
			for(int j=0;j<6;j++){
				if(arr[i][j] == str.charAt(0)){
					result = result || cont(i,j,1);
				}
			}
		}
		return result;
	}
	void show(){
		for(int i=0; i<6; i++){
			for(int j=0;j<6; j++){
				if(used[i][j]){System.out.printf("1 ");}
				else{System.out.printf("0 ");}
			}
			System.out.println();
		}
		System.out.println();
	}
	boolean cont(int t_x,int t_y,int t_str){
		path[t_str][0] = t_x;
		path[t_str][1] = t_y;
		used[t_x][t_y] = true;

		boolean result = false;

		if(t_str == str.length()-1){
			return true;
		}

		if(t_x-1>=0  && !used[t_x-1][t_y] && arr[t_x-1][t_y] == str.charAt(t_str)){
			result = result || cont(t_x-1,t_y,t_str+1);
		}

		if( t_y+1<=5 && !used[t_x][t_y+1] && arr[t_x][t_y+1] == str.charAt(t_str)){
			result = result || cont(t_x,t_y+1,t_str+1);
		}

		if(t_x+1<=5  && !used[t_x+1][t_y] && arr[t_x+1][t_y] == str.charAt(t_str)){
			result = result || cont(t_x+1,t_y,t_str+1);
		}

		if( t_y-1>=0 && !used[t_x][t_y-1] && arr[t_x][t_y-1] == str.charAt(t_str)){
			result = result || cont(t_x,t_y-1,t_str+1);
		}
		path[t_str][0] = -1;
		path[t_str][1] = -1;
		used[t_x][t_y] = false;
		return result;
	}
	public static void main(String[] args) {
		Zad1 z = new Zad1();
		String str1 = "abcdefgh";
		String str2 = "A123B123C";
		char arr[][] = {{'y','u','f','a','b','c'},
						{'G','o','p','g','B','1'},
						{'c','b','a','h','3','2'},
						{'d','k','j','i','2','3'},
						{'e','f','Q','N','1','C'},
						{'h','g','h','M','A','r'}};
		if(z.contains(arr,str2)){
			System.out.printf("String: %s is contained in table.\n",str2);
		}else{
			System.out.printf("String: %s is NOT contained in table.\n",str2);
		}
		if(z.contains(arr,str1)){
			System.out.printf("String: %s is contained in table.\n",str1);
		}else{
			System.out.printf("String: %s is NOT contained in table.\n",str1);
		}
	}
}