public class boundary_test_case {
    //code to create large input array for level order traversal

    public static void main(String[] args){
        int[] arr = new int[200];
        arr[22] = -1;
        arr[31] = -1;
        arr[27] = -1;
        arr[42] = -1;
        arr[45] = -1;
        for(int i = 0;i<=199;i++){
            if(arr[i]==-1){
                if((2*i+1)<arr.length)
               arr[2*i+1] =-1;
               if((2*i+2)<arr.length)
               arr[2*i+2] =-1;     
            }
            else{
                arr[i] = 2*i;
            }
        }
       // int count = 1;
        for(int itr:arr){
            System.out.println(itr);
        }
    }
}
