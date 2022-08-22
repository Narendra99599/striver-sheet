// The logic to solve this problem is same as "max subarray problem" using Kadane's Algorithm. Since no body has mentioned this so far, I thought it's a good thing for everybody to know.

// All the straight forward solution should work, but if the interviewer twists the question slightly by giving the difference array of prices, Ex: for {1, 7, 4, 11}, if he gives {0, 6, -3, 7}, you might end up being confused.

// Here, the logic is to calculate the difference (maxCur += prices[i] - prices[i-1]) of the original array, and find a contiguous subarray giving maximum profit. If the difference falls below 0, reset it to zero.

public class StockBueSell {
    public int maxProfit(int[] prices) {
        int maxCur = 0, maxSoFar = 0;
        for(int i = 1; i < prices.length; i++) {
            maxCur = Math.max(0, maxCur += prices[i] - prices[i-1]);
            maxSoFar = Math.max(maxCur, maxSoFar);
        }
        return maxSoFar;
    }


    public int maxProfit1(int[] arr) {
        int profit=0,n=arr.length;
        if(n == 1){
            return 0;
        }
        profit = arr[1]-arr[0];
        int minval = arr[0];
        for(int i=0; i<n; i++){
            profit = Math.max(profit,arr[i]-minval);
            minval = Math.min(arr[i],minval);
        }
        if(profit<0)
            return 0;
        return profit;
    }
}
