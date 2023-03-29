import java.util.*;
public class Harry_and_Tree02{
    public static Scanner scn = new Scanner(System.in);

    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        TreeNode(int val) {
            this.val = val;
        }
    }

    public static boolean HarryAndTree02(TreeNode root,int k){
        return dfs(root,root,k);
    }
    public static boolean dfs(TreeNode root,TreeNode mainroot,int k){
        if(root == null) return false;
        
        if(find(mainroot,k-root.val,root)){
                return true;
        }
        boolean left = dfs(root.left,mainroot,k);
        if(left){
            return true;
        }
        boolean right =  dfs(root.right,mainroot,k);
        if(right){
            return true;
        }
        return false;
    }
    public static boolean find(TreeNode root,int k,TreeNode node){
        if(root == null) return false;
        
        if(root.val == k&&root!=node){
            return true;
        }
        boolean left = find(root.left,k,node);
        if(left == true){
            return true;
        }
        boolean right = find(root.right,k,node);
        if(right == true){
            return true;
        }
        return false;
    }

   //driver code
   public static TreeNode createTree(Integer[] arr, int idx){
    if (idx>arr.length-1||arr[idx] == null) {
        return null;
    }
    TreeNode node = new TreeNode(arr[idx]);
    node.left = createTree(arr, 2*idx+1);
    node.right = createTree(arr, 2*idx+2);

    return node;
}

public static void solve() {
    int n = scn.nextInt();
    Integer[] arr = new Integer[n];
    for (int i = 0; i < n; i++)
        arr[i] = scn.nextInt();
    TreeNode root = createTree(arr, 0);
    int k = scn.nextInt();
   boolean ans =  HarryAndTree02(root,k);
    System.out.print(ans);
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