import java.util.*;
public class testCase {
   
    public static void main(String[] args)
    {
        for(int i =0;i<=10000;i++)
        {
            System.out.print(getRandomNumberUsingNextInt(0,2000)+" ");
        }
    }
//         char []alphabet = { 'a', 'b', 'c', 'd', 'e', 'f', 'g',
//         'h', 'i', 'j', 'k', 'l', 'm', 'n',
//         'o', 'p', 'q', 'r', 's', 't', 'u',
//         'v', 'w', 'x', 'y', 'z' };

// int max = 26;
// String res = "";
// for (int i = 0; i < 10000; i++)
// res = res + alphabet[(int) (Math.random() * 100 % max)];

//  System.out.println(res);

//     }

    public static int getRandomNumberUsingNextInt(int min, int max) {
        Random random = new Random();
        return random.nextInt(max - min) + min;
    }
}
