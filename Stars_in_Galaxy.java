import java.util.*;
public  class Stars_in_Galaxy{

    public static Scanner scn = new Scanner(System.in);

    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        TreeNode(int val) {
            this.val = val;
        }
    }
    //bfs code
    public static int Stars_in_Galaxy(TreeNode root){
        if(root == null) return 0;
        LinkedList<TreeNode> que = new LinkedList<>();
        que.addLast(root);
        int ans = 0;
        while(que.size()!=0){
            int size = que.size();
            ans = que.getLast().val;
            for(int i = 0;i<size;i++){
                TreeNode rn = que.removeFirst();
                if(rn.left!=null){
                    que.addLast(rn.left);
                }
                if(rn.right!=null){
                    que.addLast(rn.right);
                }
            }
            
        }
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
    int ans = Stars_in_Galaxy(root);

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