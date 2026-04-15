import java.util.*;
public class evenlength {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        String s=sc.nextLine();
         StringBuilder sb=new StringBuilder();
        for(int i=0;i<s.length();i++){
             
                if(i<s.length() && s.charAt(i)!=' '){
                    sb.append(s.charAt(i));
                    count++;
                }
                if(count%2==0){
                    System.out.println(sb.toString());
                }

        }
    }
    
}
