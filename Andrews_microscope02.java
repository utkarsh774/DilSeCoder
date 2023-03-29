import java.util.*;
import java.util.List;
public class Andrews_microscope02 {
    public static Scanner scn = new Scanner(System.in);

    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        TreeNode(int val) {
            this.val = val;
        }
    }
 
    public static List<Integer> andrewMicroscope02(TreeNode root,int a,int bondLength){
        List<TreeNode> ntrp = ntrp(root,a);
        List<Integer> ans  = new ArrayList<>();
        if(ntrp == null) return ans; //a is not present in tree or root is null
        TreeNode block =  null;
        for(int i = 0;i<ntrp.size();i++){
            kDown(ntrp.get(i),bondLength-i,block,ans);
            block = ntrp.get(i);
        }
        return ans;
    }
    // ntrp -> Node to Root Path
    public static List<TreeNode> ntrp(TreeNode root,int a){
        if(root == null) return null;
        if(root.val == a){
            List<TreeNode> al = new ArrayList<>();
            al.add(root);
            return al;
        }       
        List<TreeNode> left = ntrp(root.left,a);
         if(left!=null){
             left.add(root);
             return left;
         }
        List<TreeNode> right = ntrp(root.right,a);
        if(right!=null){
            right.add(root);
            return right;
        }

        return null;
    }
   //k level Down
   public static void kDown(TreeNode root,int k,TreeNode block,List<Integer> ans){
       if(root == null||k<0||root == block) return;

       if(k==0){
        ans.add(root.val);
        return;
       }
       kDown(root.left,k-1,block,ans);
       kDown(root.right,k-1,block,ans);
       
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
        int a = scn.nextInt();
        int bondLength = scn.nextInt();
      List<Integer> ans =   andrewMicroscope02(root,a,bondLength);
      for(int itr:ans){
          System.out.println(itr);
      }
      
   
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

