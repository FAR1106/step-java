import java.util.*;

public class TwoSumTransactions {

    public static void findTwoSum(int[] nums,int target){

        HashMap<Integer,Integer> map=new HashMap<>();

        for(int i=0;i<nums.length;i++){

            int complement=target-nums[i];

            if(map.containsKey(complement)){

                System.out.println(
                "Pair: "+complement+" + "+nums[i]);
            }

            map.put(nums[i],i);
        }
    }

    public static void main(String[] args){

        int[] arr={500,300,200};

        findTwoSum(arr,500);
    }
}