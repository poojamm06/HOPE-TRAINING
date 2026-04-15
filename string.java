import java.util.*;
public class string {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        String s=sc.nextLine();
        int count=0;
        s=s.toLowerCase();
        for(int i=0;i<s.length();i++){
            if(i==s.length()-1 && (s.charAt(i)>='a' && s.charAt(i)<='z')){
                count++;
            }
            else if((s.charAt(i)>='a' && s.charAt(i)<='z') && (s.charAt(i+1)==' ')){
                    count++;
            }
            else{
                continue;
            }
        }
        System.out.println(count);
    }
}
