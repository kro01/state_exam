    #include <stdio.h>

	void revealPassword(char a[2][3][3],int m,int n){
		int p = 0;
		int b = 0;
		int len;
		for(int i = 0; i < m; i++){
			b = 0;
			for(int j = 0; j < n-1; j++){
				p++;
				while(a[i][j][p]!='\0' && a[i][j+1][p]!='\0'){
					if(a[i][j][p]>a[i][j+1][p]){
						b = 1;
					}
					p++;
				}

			}
			if(b==1){break;}
			len = 0;
			for(int t=0;t<100;t++){
				if(a[i][n%2][t] == '\0'){
					break;
				}
				else{
					len++;
				}
			}
			printf("%d ",len);
			printf("%s ",a[i][n%2]);
		}
	}
    int main()
    {
    	char a [2][3][3] = {{"a","b","c"},{"b","c","a"}};
    	revealPassword(a,2,3);
       return 0;
    }