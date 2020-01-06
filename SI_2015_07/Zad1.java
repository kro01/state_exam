class Zad1{
	
	public static void subsample(int m,int n,int[][] img){
		int tmp;
		for(int i=0; i<m-1;i++){
			for(int j=0;j<n-1;j++){
				tmp = img[i][j]+img[i+1][j]+img[i][j+1]+img[i+1][j+1];
				System.out.print(tmp);
				System.out.print(" ");
			}
			System.out.print("\n");
		}
	}
	//private int[][] img; 
	//public Zad1(){
	//	int[][] img  = {{1,2,3},{4,5,6}};
	//}
	public static void main(String[] args) {
			int[][] img  = {{1,2,3},{4,5,6}};
			//Zad1 Z = new Zad1(); 
			Zad1.subsample(2,3,img);
			//System.out.print("Hello");
		}	
}