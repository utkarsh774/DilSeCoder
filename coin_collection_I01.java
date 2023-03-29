import java.util.*;
public class coin_collection_I01 {
    
    

    public static Scanner scn = new Scanner(System.in);   
    public static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        
        TreeNode(int val){
            this.val = val;
        }
    
    }
    // time: o(n) 
    // space: o(1)
    public static class pair{
        int NtL = 0;   //node to leaf 
        int LtL = 0;   // node to node
    }
    public static int coinCollectionI01(TreeNode root){
           pair mp =  dfs(root);
            return mp.LtL;
    }
    public static pair dfs(TreeNode root){
            if(root == null) return new pair();

            pair left = dfs(root.left);
            pair right = dfs(root.right);
            pair mp = new pair();
           mp.NtL =  Math.max(left.NtL,right.NtL)+root.val;
           mp.LtL = Math.max(Math.max(left.LtL,right.LtL),(left.NtL+right.NtL+root.val));
           return mp;
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
        int ans = coinCollectionI01(root);
    
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
