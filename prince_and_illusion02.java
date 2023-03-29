import java.util.*;
public class prince_and_illusion02 {
    
    public static Scanner scn = new Scanner(System.in);

    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        TreeNode(int val) {
            this.val = val;
        }
    }
    //complete this function
    public static TreeNode priceIllusion(TreeNode root) {
       return root;
    }
    public static void helper(TreeNode root){
      if(root == null) return;
                 TreeNode leftc = root.left;
                 TreeNode rightc = root.right;
                 root.left = null;
                 root.right = null;
                 root.left = rightc;
                 root.right = leftc;
                helper(root.left);
                helper(root.right);
       
    }
    //driver code
    public static TreeNode createTree(int[] arr, int idx){
        if (idx>arr.length-1) {
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
         printTree(priceIllusion(root));
   
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
