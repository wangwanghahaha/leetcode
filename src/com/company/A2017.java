package com.company;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;
public class A2017 {
    public static void main(String[] args){

//        int a=findChen();
        int[] b={3,2,3};

//        while(sc.hasNext()) {
//            int a = sc.nextInt();
//            int b = sc.nextInt();
//
//            System.out.println(a + b);
//        }

        restoreIpAddresses( "25525511135");
        System.out.println(circularPermutation(2,3));
    }
    public static List<String> restoreIpAddresses(String s) {
        int[] visited=new int[s.length()];
        List<String> res=new ArrayList<String>();
        String now="";
        findres(0,now,s,res);
        return res;
    }
    private static void findres(int start,String now,String s,List<String> res){
        if(start==s.length()){
            res.add(now);
            return ;
        }
        int tmp=0;
        for(int i=start;i<s.length();i++){
            tmp=tmp*10+(s.charAt(i)-48);
            if(i==start&&tmp!=0){
                String a=tmp+"";
                if(i+1==s.length()){
                    a=a+".";
                }
                findres(i+1,now+a,s,res);
            }else if(i!=start&&(tmp<256&&tmp>=0)){
                String a=tmp+"";
                if(i+1==s.length()){
                    a=a+".";
                }
                findres(i+1,now+a,s,res);
            }
        }
        return ;
    }
    public static List<Integer> circularPermutation(int n, int start) {
        List<Integer> res=new ArrayList<Integer>();
        res.add(0);
        res.add(1);
        for(int i=0;i<n-1;i++){
            int t=2<<i;
            for(int j=t-1;j>=0;j--){
                res.add(res.get(j)+t);
            }
        }
        for(int i=0;i<start-1;i++){
            int tmp=res.get(0);

            res.remove(tmp);
            res.add(tmp);
        }
        return res;
    }
    public static int majorityElement(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int i=0;i<nums.length;i++){
            if(map.containsKey(i)){
                int c=map.get(i)+1;
                if(c>nums.length/2)return i;
                map.put(i,c);
            }else{
                map.put(i,1);
            }
        }
        return -1;
    }
    public static String multiply(String num1, String num2) {
        int c=0;
        StringBuffer sb=new StringBuffer();
        String res="0";
        if(num1.equals("0")||num2.equals("0"))return "0";
        if(num1.length()>num2.length()){
            String temp=num2;
            num2=num1;
            num1=temp;

        }
        String[] mid=new String[10];
        mid[0]="0";
        for(int i=1;i<10;i++){
            mid[i]=StrAdd(num2,mid[i-1]);
        }
        int length=num1.length();
        for(int i=0;i<length;i++){
            StringBuffer temp=new StringBuffer();
            int x=num1.charAt(length-i-1)-48;
            if(x==0)continue;
            temp.append(mid[num1.charAt(length-i-1)-48]);
            for(int j=0;j<i;j++){
                temp.append("0");
            }
            res=StrAdd(res,temp.toString());
        }
        return res;
    }
    public static String StrAdd(String a,String b){
        int c=0;
        StringBuffer sb=new StringBuffer();
        if(a.length()>b.length()){
            String temp=a;
            a=b;
            b=temp;

        }
        int i=a.length()-1;
        int j=b.length()-1;
        while(i>=0&&j>=0){
            int x=a.charAt(i)-48;
            int y=b.charAt(j)-48;
            int z=x+y+c;
            c=z/10;
            sb.append(z%10);
            i--;
            j--;
        }
        while(j>=0){
            int y=b.charAt(j)-48;
            int z=y+c;
            c=z/10;
            j--;
            sb.append(z%10);
        }
        if(c!=0)sb.append(1);
        sb.reverse();
        return sb.toString();
    }
    private static int findKthLargest(int[] nums,int k) {
        int left=0,right=nums.length-1;

        return partition(nums,left,right,k);
    }
    private static int partition(int[] nums,int left,int right,int k){
        int index=_index(nums,left,right);
        if(index+1==k)return nums[index];
        if(index+1<k)return partition(nums,index+1,right,k);
        if(index+1>k)return partition(nums,left,index-1,k);
        return -1;
    }

    private static int  _index(int[] nums,int left, int right){
        int e=nums[left];
        int i=left;
        int j=right;
        while(i<j){
            while(nums[j]<=e&&i<j)j--;
            nums[i]=nums[j];
            while(nums[i]>=e&&i<j)i++;
            nums[j]=nums[i];
        }
        nums[i]=e;
        return j;

    }


    private static int findChen() {
        Scanner sc=new Scanner(System.in);
        int num=sc.nextInt();
        int[] tree=new int[num];
        for(int i=0;i<num-1;i++){
            int a=sc.nextInt();
            int b=sc.nextInt();
            tree[b]=a;
        }
        int res=0;
        int[] flag=new int[num];
        for(int i=num-1;i>0;i--){
            if(flag[i]==1)continue;
            flag[i]=1;
            int max=0;
            int j=i;
            while(j!=0){
                j=tree[j];
                max++;
                flag[j]=1;
            }
            if(max>res)res=max;
        }
        return res+1;
    }

}
