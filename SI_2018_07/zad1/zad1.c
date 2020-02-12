#include <stdio.h>

void sortLex(int n,int* a){
	int digit[n][20];
	for(int i=0;i<n;i++){
		for(int j=0; j<20; j++){
			digit[i][j] = a[i]%10;
			a[i] = a[i]/10;
			printf("%d ",digit[i][j]);
		}
		printf("\n");
	}
}

int main(int argc, char const *argv[])
{
	int a[] = {112,244,35,488};
	sortLex(4,a);
	return 0;
}