import java.util.*;
public class katieChallange
{

    public static boolean isPresent(char ch)
    {
        if(ch=='k'||ch=='a'||ch=='t'||ch=='i'||ch=='e')
        {
            return true;
        }
        return false;
    }
    public static int solution(String S,int K)
    {
      //  return S.length();
        int maxCount = Integer.MIN_VALUE;
        int count = 0;
        for(int i = 0;i<K;i++)
        {
            char ch = S.charAt(i);
            if(isPresent(ch))
            {
                count++;
            }
        }
        maxCount = Math.max(count,maxCount);
        int i = K-1;
        while(i<S.length()-1)
        {
            i++;
            // acquire
            if(isPresent(S.charAt(i)))
            {
                count++;
            }
            // release 
            char ch = S.charAt(i-K);
            if(isPresent(ch))
            {
                count--;
            }
            // update maxCount
            maxCount = Math.max(count,maxCount);
        }
        maxCount = Math.max(count,maxCount);
        return maxCount;
    }
    public static void main(String[] args)
    {
        Scanner scn = new Scanner(System.in);

        //input for string S
        String S = scn.nextLine();
        // input for K
        int K = scn.nextInt();
        
        
        
        System.out.println(solution(S,K));
    }
}