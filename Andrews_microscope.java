import java.util.*;
public class Andrews_microscope {
    public static Scanner scn = new Scanner(System.in);

    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        TreeNode(int val) {
            this.val = val;
        }
    }
    
    public static List<Integer> andrewMicroscope(TreeNode root,int a,int bondLength){
        List<Integer> ans  =  new ArrayList<>();
        dfs(root,a,bondLength,ans);
        return ans;
    }
    public static int dfs(TreeNode root,int a,int bondLength,List<Integer> ans){
        if(root == null) return 0;
       if(root.val == a){
       kDown(root,bondLength,null,ans);
       return 1;
       }
       int ld =  dfs(root.left,a,bondLength,ans); 
       if(ld!=0){
           kDown(root,bondLength-ld,root.left,ans);
           return ld+1;
       }  
       int rd = dfs(root.right,a,bondLength,ans);
       if(rd!=0){
        kDown(root,bondLength-rd,root.right,ans);
        return rd+1;
       }

       return 0;
    }
    public static void kDown(TreeNode root,int k,TreeNode block,List<Integer> ans){
        if(root == null||k<0||root == block) return;

        if(k == 0){
           ans.add(root.val);
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
      List<Integer> ans =   andrewMicroscope(root,a,bondLength);
      for(int itr : ans){
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
