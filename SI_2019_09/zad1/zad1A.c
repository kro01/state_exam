#include <stdio.h>

//0 false  1 true
int find( int value, int* arr, size_t size){
	if(size == 0) return 0;

	size_t mid = size/2;
	if(value == arr[mid]) return 1;

	if(value < arr[mid])
		return find(value,arr,size/2);
	else
		return find(value,arr+size/2+1,size/2);
}

int main(int argc, char const *argv[])
{
	printf("Helllo\n");
	int a[] = {0,1,2,3,4,5,6,7,8,9,10,11,12,13,14};
	for(int i=-5;i<20;i++){
		printf("\n %d %d\n",i,find(i,a,15) );
	}
	return 0;
}