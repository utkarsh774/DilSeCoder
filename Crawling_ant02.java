import java.util.*;
public class Crawling_ant02 {
    public static Scanner scn = new Scanner(System.in);

    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        TreeNode(int val) {
            this.val = val;
        }
    }
    
    public static int max = 0;
    public static int crawlingAnt02(TreeNode root){
      
        dfs(root);
        return max;
    }
    public static int[] dfs(TreeNode root){
       if(root == null) return new int[]{-1,-1};
        int[] left = dfs(root.left);
        int[] right = dfs(root.right);
        int[] ans =  new int[]{left[1]+1,right[0]+1};
      max =   Math.max(max,Math.max(left[1]+1,right[0]+1));
      return ans;
    }

     //driver code
     public static TreeNode createTree(int[] arr, int idx){
        if (idx>arr.length-1||arr[idx] == -1) {
            return null;
        }
        TreeNode node = new TreeNode(arr[idx]);
        node.left = createTree(arr, 2*idx+1);
        node.right = createTree(arr, 2*idx+2);

        return node;
    }

    public static void solve() {
        int n = scn.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = scn.nextInt();
        TreeNode root = createTree(arr, 0);
        int ans = crawlingAnt02(root);

           System.out.println(ans);
      
   
    }
    public static void printTree(TreeNode root){
        if(root == null) return;
        System.out.println(root.val);
        printTree(root.left);
        printTree(root.right);
     }
    public static void main(String[] args) {
        solve();
    }

}

