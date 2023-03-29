import java.util.*;
public class dataSetOfTemperature
{
// optimized solution
public static int[] solution(int[] T,int N)
{
           // Initialize a prefix array
            int[] prefix = new int[N];
            // Traverse on T array to fill prefix array
            for(int i = 0;i<T.length;i++)
            {
                if(i == 0)
                {
                    prefix[i] = T[i];
                }
                else{
                    prefix[i] = T[i] + prefix[i-1];
                }
            }

            // initialize a suffix array
            int[] suffix = new int[N];
            // Traverse on T array to fill the suffix array
            for(int i = N-1;i>=0;i--)
            {
                if(i == N-1)
                {
                    suffix[i] = T[i];
                }
                else
                {
                    suffix[i] = T[i]+suffix[i+1];
                }
            }

            // Traverse on T array -> At equilibrium point -> prefix[i] = suffix[i]

            for(int i = 0;i<N;i++)
            {
                if((N == 1||i == 0||i==N-1) && (prefix[i] == suffix[i]))
                {
                    return new int[]{i+1,0};
                }
                else
                {
                    if(prefix[i] == suffix[i])
                    {
                        return new int[]{i+1,prefix[i-1]};
                    }
                }
            }
            return new int[]{-1,-1};
}
// brute force
public static int[] solution_(int[] T,int N)
{
    for(int i = 0;i<T.length;i++)
    {
        int leftSum = 0;
        int rightSum = 0;
        for(int j = i+1;j<T.length;j++)
        {
                leftSum+=T[j];
        }
        for(int j = i-1;j>=0&&j!=-1;j--)
        {
            rightSum+=T[j];
        }

        if(leftSum == rightSum)
        {
            return new int[]{i+1,leftSum};
        }
    }

    return new int[]{-1,-1};
}
// driver code
public static void main(String[] args)
{
        Scanner scn = new Scanner(System.in);
        // Take input for number of days.
        int N = scn.nextInt();

        // initialize a temperature array to store temperature for N days

        int[] T = new int[N];

        // Take input of temperatures

        for(int i = 0;i<N;i++)
        {
            T[i] = scn.nextInt();
        }

       long st = System.currentTimeMillis();
        int[] ans = solution(T,N);
       long end = System.currentTimeMillis();
        //ans[0] -> equilibrium day   ans[1] -> equilibrium sum
        System.out.println(ans[0] + " "+ ans[1]);
        System.out.println(end - st);

}
}