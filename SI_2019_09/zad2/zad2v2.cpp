#include <iostream>
using namespace std;

typedef int vertex;

template <int n> class label_tree{
	public:
		void set();
		int size;
		vertex tree[n][25];
		int val[n][25];
};

template <int n>
void label_tree<n>::set() {
  for(int i=0;i<n;i++){
  	for(int j=0;j<25;j++){
  		tree[i][j] = 0;
  	}
  }
}

template<int n>
void CommonBranches(label_tree<n> T,vertex u,vertex v,int k){
	char a[20];
	a[0] = '\0';
	CommonBranches(T,u,v,k,a,0);
}
template<int n>
void CommonBranches(label_tree<n> T,vertex u,vertex v,int k,char* w,int wi){
	w[wi+1] = '\0';
	bool leaf_u = true;
	bool leaf_v = true;
	for(int i=0;i<25;i++){
		if(T.tree[u][i] != 0 ){
			leaf_u = false;
			if(T.tree[v][i] != 0){
				leaf_v = false;
				
				if( k-T.val[u][i]-T.val[v][i] >= 0){
					w[wi] = i+'a';
					CommonBranches(T, T.tree[u][i], T.tree[v][i], k-T.val[u][i]-T.val[v][i], w, wi+1);
				}
			}
		}
	}
	if(leaf_u && leaf_v && k == 0){
		w[wi+1] = '\0';
		cout <<w<<endl;
	}
}

int main(int argc, char const *argv[])
{
	label_tree<6> T;
	T.set();

	T.tree[0]['a'-'a'] = 1;
	T.val[0]['a'-'a'] = 1;

	T.tree[0]['c'-'a'] = 3;
	T.val[0]['c'-'a'] = 1;

	T.tree[1]['b'-'a'] = 2;
	T.val[1]['b'-'a'] = 1;

	T.tree[3]['a'-'a'] = 4;
	T.val[3]['a'-'a'] = 1;

	T.tree[4]['b'-'a'] = 5;
	T.val[4]['b'-'a'] = 1;

	CommonBranches(T,0,3,4);
	return 0;
}