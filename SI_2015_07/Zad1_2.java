class Zad1_2{
	
	public void subsample(){
		int tmp;
		for(int i=0; i<this.img.length-1;i++){
			for(int j=0;j<this.img[0].length-1;j++){
				tmp = img[i][j]+img[i+1][j]+img[i][j+1]+img[i+1][j+1];
				System.out.print(tmp);
				System.out.print(" ");
			}
			System.out.print("\n");
		}
	}
	private int[][] img; 

	public Zad1_2(int[][] img){
		this.img = img;	
	}
	public static void sample(){
		int[][] a  = {{1,2,3},{4,5,6}};
		Zad1_2 Z = new Zad1_2(a); 
		Z.subsample();
	}
	public static void main(String[] args) {
			Zad1_2.sample();
			//System.out.print("Hello");
		}	
}