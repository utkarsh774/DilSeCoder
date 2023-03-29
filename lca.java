import java.util.*;
public class lca{

    public static Scanner scn = new Scanner(System.in);

    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        TreeNode(int val) {
            this.val = val;
        }
    }


    public static int lca(TreeNode root,int p,int q){
                    List<TreeNode> l1 = ntrp(root,p);
                    List<TreeNode> l2 = ntrp(root,q);

                    int i1 = l1.size() - 1;
                    int i2 = l2.size() - 1;
                    TreeNode lca = null;
                    while(i1>=0&&i2>=0){
                        if(l1.get(i1)==l2.get(i2)){
                            lca  = l1.get(i1);
                        }
                        i1--;
                        i2--;
                    }
                    return lca.val;
    }
    public static List<TreeNode>  ntrp(TreeNode root,int p){
            if(root == null) return null;

            if(root.val == p){
                List<TreeNode> ans  =  new ArrayList<>();
                ans.add(root);
                return ans;
            }
          List<TreeNode> left =  ntrp(root.left,p);
          if(left != null){
              left.add(root);
              return left;
          }
          List<TreeNode> right =   ntrp(root.right,p);
          if(right !=null){
              right.add(root);
              return right;
          }
          return null;
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
       int ans =  lca(root,p,q);
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