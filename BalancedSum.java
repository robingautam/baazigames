package org.example;

public class BalancedSum {

    public static void main(String[] args){
        int arr[] = {1,2,4,5,3,9,2,1};

        System.out.println("Index is "+ balanacedSum(arr));
    }

    public static int balanacedSum(int arr[]){
        int sum = 0;
        for (int val:arr){
            sum += val;
        }
        int rightSum = arr[arr.length-1];
        sum = sum-arr[arr.length-1];
        for (int i=arr.length-2;i>=0;i--){
            sum = sum-arr[i];
            if (rightSum==sum){
                return i;
            }
            rightSum = rightSum+arr[i];
        }

        return -1;
    }
}
