import java.util.*;
public class Stars_in_Galaxy02 {

    
    public static Scanner scn = new Scanner(System.in);

    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        TreeNode(int val) {
            this.val = val;
        }
    }
    // dfs
    public static int maxLevel = -1;
    public static int sirius = 0;
    public static int Stars_in_Galaxy02(TreeNode root){
        dfs(root,0);
        return sirius;
    }
    public static void dfs(TreeNode root,int level){
            if(root == null) return;
            if(level>maxLevel){
                maxLevel = level;
                sirius = root.val;
            }
            dfs(root.right,level+1);
            dfs(root.left,level+1);
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
    int ans = Stars_in_Galaxy02(root);

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
