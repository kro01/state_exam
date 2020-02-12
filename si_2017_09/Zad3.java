class Zad3{
	public static void main(String[] args) {

		/*char teren[][]={{'r','r','1','1','2','2'},
						{'1','r','r','r','1','2'},
						{'s','1','r','r','2','3'},
						{'4','4','s','s','r','r'}};
		char teren[][]={{'4','r','4','1','4','2'},
						{'4','4','4','4','4','2'},
						{'s','1','4','r','2','4'},
						{'4','4','4','4','4','4'}};*/
		char teren[][]={{'4','r','4','1','4','2'},
						{'4','4','4','4','4','2'},
						{'s','1','4','r','2','4'},
						{'4','4','4','4','2','4'}};
		int arr[][] = new int[teren.length][teren[0].length];
		int reneme[] = new int[100];//????
		for(int i=0;i<reneme.length;i++){
			reneme[i] = -1;
		}

		int t=1; // number of arreya with number 4
		if(teren[0][0] == '4'){
			arr[0][0] = 1;
			t++;
		}
		for(int i=1; i<teren[0].length; i++){
			if(teren[0][i] == '4'){
				if(teren[0][i-1] == '4'){
					arr[0][i] = arr[0][i-1];
				}
				else{
					arr[0][i] = t;
					t++;
				}
			}
		}
		for(int i=1; i<teren.length; i++){
			// first element from line
			if(teren[i][0] == '4'){
				if(teren[i-1][0] == '4'){
					arr[i][0] = arr[i-1][0];
				}
				else{
					arr[i][0] = t;
					t++;
				}
			}
			// 
			for(int j=1; j<teren[0].length; j++){
				if(teren[i][j] == '4'){
					if(teren[i-1][j] == '4' && teren[i][j-1] != '4'){
						arr[i][j] = arr[i-1][j];
					}
					else if(teren[i-1][j] != '4' && teren[i][j-1] == '4'){
						arr[i][j] = arr[i][j-1];
					}
					else if(teren[i-1][j] == '4' && teren[i][j-1] == '4'){
						if(arr[i-1][j] < arr[i][j-1]){
							arr[i][j] = arr[i-1][j];
							reneme[arr[i][j-1]] = arr[i-1][j];
						}else{
							arr[i][j] = arr[i][j-1];
							reneme[arr[i-1][j]] = arr[i][j-1];
						}
					}else if(teren[i-1][j] != '4' && teren[i][j-1] != '4'){
						arr[i][j] = t;
						t++;
					}
				}
			}
		}
		//some arrayes have more then 1 number I find smalest number
		int tmp,tmp2,tmp3;

		for(int i=reneme.length-1;i>0;i--){

			tmp = i;
			while(reneme[tmp]!=-1){
				tmp = reneme[tmp];
			}
			tmp2 = i;
			tmp3 = i;
			while(tmp2 != tmp){
				tmp2 = reneme[tmp3];
				reneme[tmp3] = tmp;
				tmp3 = tmp2;
			}
		}
		System.out.println();
		for(int i=0;i<reneme.length;i++){
			if(reneme[i] != -1){
				System.out.printf("%d:%d  ",i,reneme[i]);
			}
		}
		System.out.println();
		// count 
		int count[] = new int[reneme.length];
		for(int i=0;i<count.length;i++){
			count[i] = 0;
		}
		int max = 0;
		for(int i=0; i<teren.length; i++){
			for(int j=0; j<teren[0].length; j++){
				if(reneme[arr[i][j]] != -1 && reneme[arr[i][j]] != 0){
					arr[i][j] = reneme[arr[i][j]];
				}
				System.out.print(arr[i][j]);
				if(arr[i][j] == 0){
					continue;
				}
				count[arr[i][j]]++;
				if(count[arr[i][j]] > max){
					max = count[arr[i][j]];
				}
				
			}
			System.out.println();
		}

		System.out.printf("max area is  %d\n",max);
	}
}