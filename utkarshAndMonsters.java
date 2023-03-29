import java.util.*;
public class utkarshAndMonsters {
    

    public static void solution(int n,int[] monsters, int m) {
        int max = Integer.MIN_VALUE;
        for(int val: monsters)
        {
            max = Math.max(val,max);
        }
       
        // int low = 1;
        // int high = max;
        int ans = 0;        // minimum valid rate of killing
        // while(low<=high)
        // {
        //     int k = (low + high)/2;   // k is rate of killing per minute
        //     // isPossible:returns boolean,whether it is possible to kill all the monsters with rate k within time m
        //     if(isPossible(k,monsters,m))
        //     {
        //         ans = k; // if true,store the rate and move left in search space
        //         high = k-1;
        //     }
        //     else
        //     {
        //         low = k+1; // if false move right in search space
        //     }
        // }
        for(int i = 1;i<=max;i++)
        {
            if(isPossible(i,monsters,m))
            {
                ans = i;
            }
            else
            {
                break;
            }

        }
        
        System.out.println(ans);
        
    }
    public static boolean isPossible(int k,int[] arr,int h)
    {
        long time = 0;
        for(int val: arr)
        {
          if(val%k == 0)
          {
              time+= (val/k);
          }
            else
            {
                 time+= (val/k) + 1;
            }
        }
      
        if(time<=h) return true;
        return false;
 
    }
    // driver code
    public static void main(String[] args)
    {
        // n : number of groups of monsters
        // monsters[i] : number of monsters in ith group
        // m : Supershield activation time

        Scanner scn = new Scanner(System.in);
       // input for number of groups of monster
        int n = scn.nextInt();

       //monster[i] -> number of monster in ith group
        int[] monsters = new int[n];

        for(int i = 0;i<monsters.length;i++)
        {
            monsters[i] = scn.nextInt();
        }
        // input for activation time
        int m = scn.nextInt();
        long st = System.currentTimeMillis();
        solution(n,monsters,m);
        long ed = System.currentTimeMillis();
        System.out.println(ed - st);
    }
}
