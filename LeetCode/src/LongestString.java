import java.util.Arrays;
import java.util.Scanner;

public class LongestString {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String a = input.nextLine();
        String res = longestPalindrome(a);
        System.out.println(res);
    }
    public static String longestPalindrome(String s) {
        String maxString = "";
        int[][] c = new int[s.length()][s.length()];
        for(int i=0;i<s.length();i++){
            for(int j=i;j<s.length();j++){
                if(c[i][j]==0){
                    fill(c,i,j,s);
                }
            }
        }
        System.out.println("c:"+Arrays.deepToString(c));
        int k=0;
        for(int m=0;m<s.length();m++) {
            k=s.length()-m-1;
            for (int n = 0; n <= m; n++) {
                if (c[n][k]==1){
                    return s.substring(n,k+1);
                }
                k++;
            }
        }
        return maxString;
    }
    public static void fill(int[][] c,int i,int j,String s){
        if(j==i){
            c[i][j]=1;
            return;
        }
        if(j-1==i){
            if(s.charAt(i)==s.charAt(j) && c[i][j-1]==1){
                c[i][j]=1;
            }else{
                c[i][j]=-1;
            }
            return;
        }
        if(c[i+1][j-1]==0){
            fill(c,i+1,j-1,s);
        }
        if(s.charAt(i)==s.charAt(j)){
            if(c[i+1][j-1]==1){
                c[i][j]=1;
            }else{
                c[i][j]=-1;
            }
        }else{
            c[i][j]=-1;
        }
        return;
    }
}
