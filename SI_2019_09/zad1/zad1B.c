#include <iostream>
using namespace std;


template <typename ReturnType,typename InputType,typename OpType>

ReturnType fold_left(InputType* arr,size_t size,OpType op,ReturnType nil){
	ReturnType result = nil;//nil
	for (size_t i = 0; i < size;++i)
		result = op(result,arr[i]);
	return result;
}
int op(char Digit,int Result){
	return (Result*10) +(Digit-'0');
}
int str_to_int(const char * str){
	return (str == nullptr) ? 0 : fold_left(str,??????,op,0);
}