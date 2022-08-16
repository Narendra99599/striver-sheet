public class NextPermutation {
    static void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    static void rev(int[] arr,int l,int h){
        while(l < h){
            int temp = arr[l];
            arr[l] = arr[h];
            arr[h] = temp;
            l++;
            h--;
        }
    }
    public void nextPermutation(int[] nums) {
        int idx1 = -1, idx2 = -1;
        int n = nums.length;
        for(int i=n-2; i>=0; i--){
            if(nums[i] < nums[i+1]){
                idx1 = i;
                break;             
            }
        }if(idx1 == -1)
            rev(nums,0,n-1);
        else{
            for(int i=n-1; i>idx1; i--){
                if(nums[idx1] < nums[i]){
                    idx2 = i;
                    break;
                }
            }
            swap(nums,idx1,idx2);
            rev(nums,idx1+1,n-1);
        }
    }
}
