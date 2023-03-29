import java.util.*;
public class Sheeps_area {
                
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
// Time:o(n^2) space:o(1)
public static int sheeps_area(TreeNode root){
   
    int dia = sheeps_area_(root);
  //return (int)((3.14*dia*dia)/4);
  return dia;
}
public static int sheeps_area_(TreeNode root){
    if(root == null) return -1;

    int ld = sheeps_area_(root.left);
    int rd = sheeps_area_(root.right);

    int lh = getHeight(root.left);
    int rh = getHeight(root.right);

    int mydia = lh + rh + 2;

    return Math.max(Math.max(ld,rd),mydia);

}
public static int getHeight(TreeNode root){
    if(root == null) return -1;

    int lh = getHeight(root.left);
    int rh = getHeight(root.right);
    return Math.max(lh,rh) + 1;
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
    int ans = sheeps_area(root);

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
    
