import java.util.*;
public class Sheeps_area_02 {
                    
     public static Scanner scn = new Scanner(System.in);   
    public static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        
        TreeNode(int val){
            this.val = val;
        }
    
    }
    
    // complete your function here
    
    public static class diaPair{
    
        int height = -1;
        int max = 0;
    
    }
    public static int sheeps_area02(TreeNode root){
        diaPair ans  =  dfs(root);
        return (int)(3.14*ans.max*ans.max)/4;
    }
    public static diaPair dfs(TreeNode root){
        if(root == null) return new diaPair();
        diaPair left = dfs(root.left);
        diaPair right = dfs(root.right);
    
        int mydia = left.height + right.height + 2;
        int max = Math.max(Math.max(left.max,right.max),mydia);
        int height = Math.max(left.height,right.height) + 1;
    
        diaPair dp = new diaPair();
        
        dp.height = height;
        dp.max = max;
    
        return dp;
    
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
        int ans = sheeps_area02(root);
    
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
        
    



