package com.company;

import java.util.Arrays;
import java.util.Scanner;

public class B2017 {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int a=sc.nextInt();
        int b=sc.nextInt();
        int[] str=new int[a];
        for(int i=0;i<a;i++){
            str[i]=sc.nextInt();
        }
        for(int i=0;i<b;i++){
            switch(sc.nextInt()){
                case 1:
                    oneMethod(sc.nextInt(),sc.nextInt(),str);
                    break;
                case 2:
                    twoMethod(sc.nextInt(),sc.nextInt(),sc.nextInt(),str);
                    break;
                case 3:
                    threeMethod(sc.nextInt(),sc.nextInt(),sc.nextInt(),str);
                    break;
                case 4:
                    fourMethod(sc.nextInt(),sc.nextInt(),str);
                    break;
                case 5:
                    fiveMethod(sc.nextInt(),sc.nextInt(),str);
                    break;

            }
        }
    }
    public static void oneMethod(int l,int r,int[] nums){

        int[] temp=new int[r-l+1];
        for(int i=l-1;i<r;i++){
            temp[i-l+1]=nums[i];
        }
        for(int i=l-1;i<r;i++){
            nums[i]=temp[r-i-1];
        }

    }
    public static void twoMethod(int l,int r,int len,int[] nums){
        int temp;
        int j=r-1;
        for(int i=0;i<len;i++){
            temp=nums[i+l-1];
            nums[i+l-1]=nums[j+i];
            nums[j+i]=temp;
        }
    }
    public static void threeMethod(int l,int r,int x,int[] nums){
        for(int i=l-1;i<r;i++){
            nums[i]=x;
        }
    }
    public static void fourMethod(int l,int r,int[] nums) {
        int[] temp = new int[r - l + 1];
        for (int i = l - 1; i < r; i++) {
            temp[i - l + 1] = nums[i];
        }
        Arrays.sort(temp);
        for (int i = l - 1; i < r; i++) {
            nums[i] = temp[i - l + 1];
        }
    }
    public static void fiveMethod(int l,int r,int[] nums){
        int sum=0;
        for (int i = l - 1; i < r; i++) {
            sum+=nums[i];
        }
        System.out.println(sum);
    }
}
