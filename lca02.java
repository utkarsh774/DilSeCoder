import java.util.*;
public class lca02 {
    public static Scanner scn = new Scanner(System.in);

    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        TreeNode(int val) {
            this.val = val;
        }
    }   
         public static TreeNode  ans =  null;
         public static int lca02(TreeNode root,int p,int q){
                dfs(root,p,q);
                return ans.val;
         }
         public static boolean dfs(TreeNode root,int p,int q){
             if(root == null) return false;
             
            boolean self  = false;
             if(root.val == p||root.val == q) self  = true;
             boolean left = dfs(root.left,p,q);
             boolean right = dfs(root.right,p,q);
             if(left == true&&right == true||left == true&&self == true||right == true&&self==true) ans = root;
             return left||self||right;

             
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
            int p = scn.nextInt();
            int q = scn.nextInt();
             lca02(root,p,q);
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
