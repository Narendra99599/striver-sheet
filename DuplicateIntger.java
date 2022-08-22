import java.util.*;


// Perform Binary Search on range 1 to n;
// low = 1, high = nums.size() - 1;
// While the value of high is greater than or equal to low.
// calculate mid.
// count elements <= to mid.
// if count is less than equal to mid.
// low = mid + 1 (binary search on right half)
// else high = mid + 1 (binary search on left half)
// Return low which will point to duplicate.

public class DuplicateIntger {
    int findDuplicate(ArrayList<Integer> nums) {
        int low = 1, high = nums.size() - 1, cnt;
        
        while(low <=  high)
        {
            int mid = low + (high - low) / 2;
            cnt = 0;
            // cnt number less than equal to mid
            for(int n : nums)
            {
                if(n <= mid)
                    ++cnt;
            }
            // binary search on left
            if(cnt <= mid)
                low = mid + 1;
            else
            // binary search on right
                high = mid - 1;
            
        }
        return low;
    }

    public int findDuplicate(int[] arr) {
        int slow = arr[0];
        int fast = arr[0];
        while(true){
            slow = arr[slow];
            fast = arr[arr[fast]];
            if(slow == fast)
                break;
        }
        slow = arr[0];
        while(slow != fast){
            slow = arr[slow];
            fast = arr[fast];
        }
        return slow;
    }
}
