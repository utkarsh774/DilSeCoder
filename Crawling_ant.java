import java.util.*;
public class Crawling_ant {
    public static Scanner scn = new Scanner(System.in);

    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        TreeNode(int val) {
            this.val = val;
        }
    }
    public static class zz{
        int forward = -1;
        int backward = -1;
        int max = 0;

        zz(int forward,int backward){
            this.forward = forward;
            this.backward = backward;
        }
        zz(){

        }
    }
    public static int crawlingAnt(TreeNode root){
         return dfs(root).max;
           
    }
    public static zz dfs(TreeNode root){
        if(root == null) return new zz();
        zz left = dfs(root.left);
        zz right = dfs(root.right);
        zz myzz = new zz(left.backward+1,right.forward+1);
        myzz.max = Math.max(Math.max(left.max,right.max),Math.max((left.backward+1),right.forward+1));
        return myzz;
        
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
        int ans = crawlingAnt(root);

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
