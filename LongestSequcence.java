/*
We will use HashMap. The key thing is to keep track of the sequence length and store that in the boundary points of the sequence. For example, as a result, for sequence {1, 2, 3, 4, 5}, map.get(1) and map.get(5) should both return 5.

Whenever a new element n is inserted into the map, do two things:

See if n - 1 and n + 1 exist in the map, and if so, it means there is an existing sequence next to n. Variables left and right will be the length of those two sequences, while 0 means there is no sequence and n will be the boundary point later. Store (left + right + 1) as the associated value to key n into the map.
Use left and right to locate the other end of the sequences to the left and right of n respectively, and replace the value with the new length.
Everything inside the for loop is O(1) so the total time is O(n). Please comment if you see something wrong. Thanks.*/
import java.util.*;
public class LongestSequcence {
    public int longestConsecutive(int[] num) {
        int res = 0;
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int n : num) {
            if (!map.containsKey(n)) {
                int left = (map.containsKey(n - 1)) ? map.get(n - 1) : 0;
                int right = (map.containsKey(n + 1)) ? map.get(n + 1) : 0;
                // sum: length of the sequence n is in
                int sum = left + right + 1;
                map.put(n, sum);

                // keep track of the max length
                res = Math.max(res, sum);

                // extend the length to the boundary(s)
                // of the sequence
                // will do nothing if n has no neighbors
                map.put(n - left, sum);
                map.put(n + right, sum);
            } else {
                // duplicates
                continue;
            }
        }
        return res;
    }

    public int longestConsecutivetwo(int[] nums) {
        int n = nums.length;
        if (n == 0)
            return 0;
        Arrays.sort(nums);
        int ans = 1;
        int cnt = 1;
        for (int i = 1; i < n; ++i) {
            if (nums[i] == (nums[i - 1] + 1) || nums[i] == nums[i - 1]) {
                if (nums[i] == nums[i - 1])
                    continue;
                ++cnt;
                ans = Math.max(ans, cnt);
            } else
                cnt = 1;
        }
        return ans;
    }

    public int method3(int[] nums)
    {
        int maxstreak = 1;
        HashSet<Integer> hs = new HashSet<>();
        for (int i : nums)
            hs.add(i);
        for (int i : nums) {
            if (!hs.contains(i - 1)) {
                int curnum = i;
                int curlen = 1;
                while (hs.contains(curnum + 1)) {
                    curnum += 1;
                    ++curlen;
                }
                maxstreak = Math.max(curlen, maxstreak);
            }
        }
        return maxstreak;
    }
}
