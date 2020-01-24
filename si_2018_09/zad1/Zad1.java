class Zad1{
	public static void main(String[] args) {
		//test_inOrder();
		test_revealPassword();
		
	}
	static void test_inOrder(){
		boolean result = true;
		System.out.printf("%s %s %b\n","a","b",Zad1.inOrder("a","b"));
		result = result && Zad1.inOrder("a","b");

		System.out.printf("%s %s %b\n","a","aa",Zad1.inOrder("a","aa"));
		result = result && Zad1.inOrder("a","aa");

		System.out.printf("%s %s %b\n","zz","zz",Zad1.inOrder("zz","zz"));
		result = result && Zad1.inOrder("zz","zz");

		System.out.printf("%s %s %b\n","zz zz","zz zz",Zad1.inOrder("zz zz","zz zz"));
		result = result && Zad1.inOrder("zz zz","zz zz");
		System.out.printf("Is function inOrder work?: %b",result);
		return ;//result;
	}
	static boolean inOrder(String book1,String book2){
		int i=0;
		while(book1.length() <= i && book2.length() <= i && book1.charAt(i) == book2.charAt(i)){
			i++;
		}
		if( (int)book1.charAt(i) <= (int)book2.charAt(i) ){
			return true;
		}else if( (int)book1.charAt(i) > (int)book2.charAt(i) ){
			return false;
		}else{
			if( book1.length() >= book2.length() ){
				return true;
			}
			else{
				return false;
			}
		}
	}
	static void test_revealPassword(){
		
		String lib[][] = {{"aaa","bbb","cccc"},
		{"ffff","ddddd","asdasd"},
		{"abcd","asd asdf","zzzzzzzzz"}};
		String result = revealPassword(lib,3,3);
		System.out.println(result);
		if(result.equals("3 3 4 ")){
			System.out.print("Function revealPassword is working");
		}else{
			System.out.print("not working");
		}
	}

	static public String revealPassword(String lib[][],int lines,int numBooks){
		String result = "";

		int bookOnLine = 0;
		boolean use = true;
		int tmp;
		for(int i=0; i<lines; i++){
			use = true;
			bookOnLine = 0;
			for(int j=0; j<numBooks-1; j++){
				if(lib[i][j] == null || lib[i][j].length() == 0 ){
					break;
				}
				else{
					bookOnLine++;
					use = inOrder(lib[i][j],lib[i][j+1]);
					if(!use){
						break;
					}
				}
			}
			if(use){
				tmp = 0;
				for(int j = 0;  j < lib[i][bookOnLine/2].length(); j++){
					if(lib[i][bookOnLine/2].charAt(j) != ' '){
						tmp++;
					}else{
						result = result + Integer.toString(tmp)+' ';
						tmp=0;
					}
				}
				result = result + Integer.toString(tmp)+' ';
			}
		}
		return result;
	}
}
