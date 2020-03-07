#include <iostream>
using namespace std;


template <typename ReturnType,typename InputType,typename OpType>

ReturnType fold_left(InputType* arr,size_t size,OpType op,ReturnType nil){
	ReturnType result = nil;
	for (size_t i = 0; i < size;++i)
		result = op(arr[i],result);
	return result;
}
int op(char Digit,int Result){
	return ( Result * 10 ) + ( Digit - '0' );
}
int str_to_int(const char * str,int size){//no size 
	//return (str == nullptr) ? 0 : fold_left(str,size,op,0);
	// nullptr return error
	return fold_left(str,size,op,0);
	// ReturnType int ,InputType char ,OpType function
}
int main(){

	cout << str_to_int("12345",5);
}