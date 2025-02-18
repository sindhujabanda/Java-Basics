package Basics;

public class BandSStock {
    public static int maxProfit(int[] prices){
        int min_price = prices[0];
        int profit = 0;
        for(int i=1; i < prices.length; i++){
            if(prices[i] < min_price){
                min_price = prices[i];
            } else {
                int current_profit = prices[i] - min_price;
                profit = Math.max(current_profit, profit);
            }
        }

        return profit;
    }

    public static void main(String[] args){
       int[] prices = {7,1,3,5,6,4};
       int result = maxProfit(prices);
       System.out.println(result);
    }
}
