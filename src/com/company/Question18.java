package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Question18 {


    public static List<List<Integer>> fourSum(int[] nums, int target) {

        List<List<Integer>> result=new ArrayList<List<Integer>>();
        Arrays.sort(nums);
        for (int i=0;i<nums.length;i++){
            if(i!=0&&nums[i]==nums[i-1])continue;
            for (int j=i+1;j<nums.length;j++){
                if(j!=i+1&&nums[j]==nums[j-1])continue;
                int sum1=nums[i]+nums[j];
                int l=j+1,r=nums.length-1;
                while(l<r){
                    if(sum1+nums[l]+nums[r]==target){
                        List<Integer> integers=new ArrayList<Integer>();
                        integers.add(nums[i]);
                        integers.add(nums[j]);
                        integers.add(nums[l]);
                        integers.add(nums[r]);
                        result.add(integers);
                        while(l<r&&nums[r]==nums[r-1])r--;
                        while(l<r&&nums[l]==nums[l+1])l++;
                        r--;
                        l++;
                    }else if(sum1+nums[l]+nums[r]<target){
                        while(l<r&&nums[l]==nums[l+1])l++;
                        l++;
                    }else{
                        while(l<r&&nums[r]==nums[r-1])l++;
                        r--;
                    }
                }
            }
        }

        return result;
    }
    public static int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        HashMap<Integer,Integer> map=new HashMap<Integer,Integer>();
        for(int i=0;i<A.length;i++){
            for(int j=0;j<B.length;j++){
                if(!map.containsKey(A[i]+B[j])){
                    map.put(A[i]+B[j],0);
                }
                map.put(A[i]+B[j],map.get(A[i]+B[j])+1);
            }
        }
        int res=0;
        for(int i=0;i<C.length;i++){
            for(int j=0;j<D.length;j++){
                if(map.containsKey(0-C[i]-D[j])){
                    res+=map.get(0-C[i]-D[j]);
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {

        int[] nums={1, 2};
        int[] nums1={-1,-2};
        int[] nums2={-1,2};
        int[] nums3={0,2};
        fourSumCount(nums,nums1,nums2,nums3);
    }
}
