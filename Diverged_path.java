import java.util.*;
public class Diverged_path {

    public static Scanner scn = new Scanner(System.in);

    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        TreeNode(int val) {
            this.val = val;
        }
    }
    //complete the function
    public static int minTime = Integer.MAX_VALUE;
    public static int minTime(TreeNode root){
        if(root == null) return 0;
        dfs(root,0);
        return minTime;
    }
    //tsf -> time so far
    public static void dfs(TreeNode root,int tsf){
        if(root == null) return;
        if(root.left == null && root.right == null){
            minTime = Math.min(tsf,minTime);
            return;
        }
        tsf = tsf + 20/root.val;
        dfs(root.left,tsf);
        dfs(root.right,tsf);
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
           minTime(root);

           System.out.println(minTime);
      
   
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
