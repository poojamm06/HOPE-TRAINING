import java.util.*;
public class waveform {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        String s=sc.nextLine();
        for(int i=0;i<s.length();i+=2){
            
               System.out.print(s.charAt(i));
        }
        for(int j=1;j<s.length();j+=2){
               System.out.print(s.charAt(j));}

          sc.close();
   
        }
    }

