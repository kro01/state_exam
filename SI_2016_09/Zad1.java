import java.io.Console;
import java.util.Arrays;
import java.io.IOException;


class Zad1{
	//static int[] read(){}

	public static void main(String[] args) {
		Console c = System.console();
        if (c == null) {
            System.err.println("No console.");
            System.exit(1);
        }
        String str = c.readLine("Enter String: ");
        //String str = "this is just a asimple example";
		//String str = "11";
		char[] arr = str.toCharArray();
		int[] match = new int[arr.length];
		int max = -1;
		int maxPos = -1;
 		for(int i=0; i<arr.length; i++){
 			match[i] = -1;
 			for(int j=arr.length-1; j>i; j--){
 				if(arr[i] == arr[j]){
 					match[i] = j;
 					if(j-i>max){
 						max = j-i;
 						maxPos = i;
 					}
 					break;
 				}
 			}
 		}
 		System.out.print("\nBigest interval ");
 		System.out.print(max);
 		System.out.print("\nSimbol is ");
 		System.out.print(arr[maxPos]);
 		System.out.print("\npositions are ");
 		System.out.print(maxPos);
 		System.out.print("  ");
 		System.out.print(maxPos+max);
	}
}