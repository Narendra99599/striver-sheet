// The idea is to sort the intervals by their starting points. Then, we take the first interval and compare its end with the next intervals starts. As long as they overlap, we update the end to be the max end of the overlapping intervals. Once we find a non overlapping interval, we can add the previous "extended" interval and start over.

// Sorting takes O(n log(n)) and merging the intervals takes O(n). So, the resulting algorithm takes O(n log(n)).

// I used a lambda comparator (Java 8) and a for-each loop to try to keep the code clean and simple.

// EDIT: The function signature changed in april 2019.
// Here is a new version of the algorithm with arrays. To make more memory efficient, I reused the initial array (sort of "in-place") but it would be easy to create new subarrays if you wanted to keep the initial data.
// It takes less memory than 99% of the other solutions (sometimes 90% depending on the run) and is more than 10 times faster than the previous version with lists.
import java.util.*;
public class MergeOverLapping {
    public int[][] merge(int[][] intervals) {
        int n = intervals.length;
        if(n == 1) return intervals;
        Arrays.sort(intervals,new Comparator<int[]>(){
            public int compare(int[] val1,int[] val2){
                return val1[0]-val2[0];
            }
        });
        ArrayList<int[]> arr = new ArrayList<>();
        int st = intervals[0][0];
        int ed = intervals[0][1];
        for(int[] i : intervals){
            if(ed >= i[0]){
                ed = Math.max(ed,i[1]);
            }else{
                arr.add(new int[]{st,ed});
                st = i[0];
                ed = i[1];
            }
        }
        arr.add(new int[]{st,ed});
        int[][] ans = new int[arr.size()][2];
        int it = 0;
        for(int[] i : arr) ans[it++] = i;   
        return ans;
    }
}
