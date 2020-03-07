#include <iostream>
using namespace std;

typedef int vertex;
template<class type> class node{
	public:
	type son;
	type bro;
};
class label_tree{
	public:
		label_tree (int);
		int size;
		node<vertex> * tree;//[size][2]left son;rigth brother;
		node<char> * label;
		node<int> * val;
};
void label_tree::sort(){
	
}
label_tree::label_tree(int s){
	size = s;
	node<vertex> t[s];
	tree = t;
	node<char> l[s];
	label = l;
	node<int> v[s];
	val = v;
}

void CommonBranches(label_tree T,vertex u,vertex v,int k){

}

int main(int argc, char const *argv[])
{
	label_tree T(6);
	//T.size = 6;
	//T.tree = {{}}
	//T.tree = int[T.size];
	T.tree[0].son = 1;
	T.label[0].son = 'a';
	T.val[0].son = 1;

	T.tree[1].son = 2;
	T.label[1].son = 'b';
	T.val[1].son = 1;

	T.tree[1].bro = 3;
	T.label[1].bro = 'c';
	T.val[1].bro = 1;

	T.tree[3].son = 4;
	T.label[3].son = 'a';
	T.val[3].son = 1;

	T.tree[4].son = 5;
	T.label[4].son = 'b';
	T.val[4].son = 1;

	return 0;
}