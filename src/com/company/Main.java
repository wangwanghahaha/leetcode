package com.company;

import javax.sound.midi.Soundbank;
import java.sql.SQLOutput;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;

class Main {
    static int[][][] day = new int[5002][13][32];
    static int[][] dayOfyears = new int[13][3];
    public static void setDayOfyears() {
        dayOfyears[1][1] = 31;
        dayOfyears[2][1] = 28;
        dayOfyears[3][1] = 31;
        dayOfyears[4][1] = 30;
        dayOfyears[5][1] = 31;
        dayOfyears[6][1] = 30;
        dayOfyears[7][1] = 31;
        dayOfyears[8][1] = 31;
        dayOfyears[9][1] = 30;
        dayOfyears[10][1] = 31;
        dayOfyears[11][1] = 30;
        dayOfyears[12][1] = 31;
        dayOfyears[1][2] = 31;
        dayOfyears[2][2] = 29;
        dayOfyears[3][2] = 31;
        dayOfyears[4][2] = 30;
        dayOfyears[5][2] = 31;
        dayOfyears[6][2] = 30;
        dayOfyears[7][2] = 31;
        dayOfyears[8][2] = 31;
        dayOfyears[9][2] = 30;
        dayOfyears[10][2] = 31;
        dayOfyears[11][2] = 30;
        dayOfyears[12][2] = 31;


    }

    public static void setDay() {
        setDayOfyears();
        day[0][1][1] = 1;
        int days = 1;
        int Day = 1;
        int year = 0;
        int mouth = 1;
        day[0][1][1] = 1;
        while (year < 5001) {
            Day++;
            days++;
            if (Day <= dayOfyears[mouth][isRen(year)]) {
                day[year][mouth][Day] = days;
            } else {
                Day = 1;
                mouth++;
                if (mouth < 13) {
                    day[year][mouth][Day] = days;
                } else {
                    mouth = 1;
                    year++;
                    day[year][mouth][Day] = days;
                }
            }
        }
    }

    public static int cha(int a, int b) {
        setDay();
        return Math.abs(day[a / 10000][(a % 10000) / 100][a % 100] - day[b / 10000][(b % 10000) / 100][b % 100]) + 1;
    }


    public static int isRen(int y) {
        if (y % 100 == 0) {
            if (y % 400 == 0) {
                return 2;
            } else {
                return 1;
            }
        } else if (y % 4 == 0) {
            return 2;
        } else {
            return 1;
        }
    }
    public static int maxDistance(int[][] grid) {
        if(grid==null||grid[0].length==0)return -1;
        int m=grid.length;
        int n=grid.length;
        int res=-1;
        int[][] dp=new int[m][n];
        for(int i=0;i<m;i++)Arrays.fill(dp[i],Integer.MAX_VALUE-1);
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==1){
                    dp[i][j]=0;
                }else{
                    if(i>0)dp[i][j]=Math.min(dp[i][j],dp[i-1][j]+1);
                    if(j>0)dp[i][j]=Math.min(dp[i][j],dp[i][j-1]+1);
                    if(dp[i][j]<Integer.MAX_VALUE-1){
                        res=Math.max(res,dp[i][j]);
                    }
                }
            }
        }
        for(int i=m-1;i>=0;i--){
            for(int j=n-1;j>=0;j--){
                if(grid[i][j]==1){
                    dp[i][j]=0;
                }else {
                    if(i<m-1)dp[i][j]=Math.min(dp[i][j],dp[i+1][j]+1);
                    if(j<n-1)dp[i][j]=Math.min(dp[i][j],dp[i][j+1]+1);
                    if(dp[i][j]<Integer.MAX_VALUE-1){
                        res=Math.max(res,dp[i][j]);
                    }
                }
            }
        }
        return res;
    }
    public static int myAtoi(String str) {
        if(str.length()==0)return 0;
        int len=str.length();
        int i=0;
        while(i<len&&str.charAt(i)==' ')i++;
        if(i==len)return 0;
        long res=0;
        int flag=1;
        if(str.charAt(i++)=='-')flag=-1;
        while(i<len&&str.charAt(i)>='0'&&str.charAt(i)<='9'){
            res=res*10+str.charAt(i++)-'0';
            if(res>=2147483648L){
                if(flag==1){
                    return Integer.MAX_VALUE;
                }
                else {
                    return Integer.MIN_VALUE;
                }
            }
        }
        return (int)res*flag;
    }
    public static void main(String[] args) {
        szqw();


    }
    public static void szqw(){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[] s=new int[n];
        long c=1;
        for(int i=0;i<n;i++){
            int j=sc.nextInt();
            c*=j;
            s[i]=j;
        }
        float res=1/c;
        Arrays.sort(s);
        int max=s[n-1];
        float last=1.0f;
        for(int i=2;i<=max;i++){
            float tmp=1.0f;
            for(int j=0;j<n;j++){
                tmp*=Math.min(s[j],i);
            }
            res+=i*(tmp-last)/c;
            last=tmp;
        }
        System.out.println(String.format("%.2f", res));
    }
    public static boolean isValid(String s) {
        char[] l={'(','{','['};
        char[] r={')','}',']'};
        int[] num=new int[3];
        Stack<Integer> last=new Stack<>();
        for(int i=0;i<s.length();i++){
            char c=s.charAt(i);
            for(int j=0;j<3;j++){
                if(c==l[j]){
                    last.push(i);
                    num[j]++;
                    break;
                }else if(c==r[j]){
                    if(r[last.pop()]!=c)return false;
                    num[j]--;
                    if(num[j]<0)return false;
                    break;
                }
            }
        }
        return true;

    }
    public static String reverseWords(String s) {
        StringBuilder res=new StringBuilder("");
        String[] ss=s.split(" ");
        for(int i=ss.length-1;i>=0;i--){
            if((("").equals(ss[i])))continue;
            res.append(ss[i]).append(" ");


        }
        String str=res.toString();
        if(("").equals(str))return str;
        return str.substring(0,str.length()-1);
    }
    public static int maxAreaOfIsland(int[][] grid) {
        if(grid==null||grid.length==0||grid[0].length==0)return 0;
        int len_i=grid.length;
        int len_j=grid[0].length;
        int res=0;
        DSU d=new DSU(len_i*len_j);
        for(int i=0; i<len_i;i++){
            for(int j=0;j<len_j;j++){
                if(grid[i][j]==1){
                    res=Math.max(res,1);
                    if(j+1<len_j&&grid[i][j+1]==1){
                        res=Math.max(res,d.union(i*len_i+j,i*len_i+j+1));

                    }
                    if(i+1<len_i&&grid[i+1][j]==1){
                        res=Math.max(res,d.union(i*len_i+j,(i+1)*len_i+j));
                    }


                }

            }
        }
        return res;
    }

    public static int[][] findContinuousSequence(int target) {
        List<int[]> res =new ArrayList<>();
        for(int i=1;i<target/2+1;i++){
            for(int j=1;j<i;j++){
                if((i+j)*(i-j+1)/2==target){
                    int[] tmp=new int[i-j+1];
                    for(int k=0;k<i-j+1;k++){
                        tmp[k]=i+k;
                    }
                    res.add(tmp);
                }
            }
        }
        return (int[][])res.toArray();
    }

    public static int nthUglyNumber(int n) {
        int[] dp = new int[n];
        dp[0] = 1;
        int p2 = 0;
        int p3 = 0;
        int p5 = 0;
        for (int i = 1; i < n; i++) {
            dp[i] = Math.min(Math.min(2 * dp[p2], 3 * dp[p3]), 5 * dp[p5]);
            if (dp[i] == 2 * dp[p2]) p2++;
            if (dp[i] == 3 * dp[p3]) p3++;
            if (dp[i] == 5 * dp[p5]) p5++;
        }
        return dp[n - 1];
    }

    public static int deleteAndEarn(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];
        int len = nums.length;
        int[] trans = new int[10001];
        for (int i = 0; i < len; i++) {
            trans[nums[i]] += nums[i];
        }
        int i = 0;
        while (trans[i] == 0) i++;
        int last = nums[i];
        i++;
        int ll = 0;
        int res = trans[i];
        for (; i < 10001; i++) {
            res = Math.max(last, ll + trans[i]);
            ll = last;
            last = res;
        }
        return res;
    }

    public static int minTaps(int n, int[] ranges) {
        if (ranges.length == 0) return 0;
        PriorityQueue<int[]> q = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] == o2[0]) return o2[1] - o1[1];
                return o1[0] - o2[0];
            }
        });
        for (int i = 0; i < n + 1; i++) {
            int[] range = new int[2];
            range[0] = i - ranges[i] < 0 ? 0 : i - ranges[i];
            range[1] = i + ranges[i];
            q.add(range);
        }
        int[] dp = new int[n + 1];
        int res = 0;
        int last = 0;
        while (q.peek() != null) {
            int[] range = q.poll();
            int tmp = last;
            if (range[0] > last) {
                return -1;
            } else {
                tmp = range[1];

                while (q.peek() != null && q.peek()[0] < last) {
                    int[] range1 = q.poll();
                    tmp = Math.max(tmp, range1[1]);
                }
                if (tmp >= n) return res + 1;
                res++;
                last = tmp;
            }
        }
        return last < n ? -1 : res;
    }

    /**
     * @param s
     * @return
     */
    public static int longestPalindromeSubseq(String s) {
        if (s == null || s.length() == 0) return 0;
        int len = s.length();
        char[] c = s.toCharArray();
        int[][] dp = new int[len][len];
        for (int i = 0; i < len; i++) dp[i][i] = 1;
        for (int i = 1; i < len; i++) {
            for (int j = 0; j < len - i; j++) {
                if (c[j] == c[j + i]) {
                    if (i == 1) {
                        dp[j][j + i] = 2;
                    } else {
                        dp[j][j + i] = dp[j + 1][j + i - 1] + 2;
                    }
                } else {
                    dp[j][j + i] = dp[j + 1][j + i - 1];
                }
            }
        }
        return dp[0][len - 1];
    }

    public static List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList();
        if (digits.length() == 0) {
            return res;
        }
        char[] c = digits.toCharArray();
        bt(0, c, "", res);
        return res;

    }

    public static void bt(int n, char[] c, String s, List list) {
        if (n >= c.length) {
            list.add(s);
            return;
        }
        switch (c[n]) {
            case '2':
                bt(n + 1, c, s + 'a', list);
                bt(n + 1, c, s + 'b', list);
                bt(n + 1, c, s + 'c', list);
                break;
            case '3':
                bt(n + 1, c, s + 'd', list);
                bt(n + 1, c, s + 'e', list);
                bt(n + 1, c, s + 'f', list);
                break;
            case '4':
                bt(n + 1, c, s + 'g', list);
                bt(n + 1, c, s + 'h', list);
                bt(n + 1, c, s + 'i', list);
                break;
            case '5':
                bt(n + 1, c, s + 'j', list);
                bt(n + 1, c, s + 'k', list);
                bt(n + 1, c, s + 'l', list);
                break;
            case '6':
                bt(n + 1, c, s + 'm', list);
                bt(n + 1, c, s + 'n', list);
                bt(n + 1, c, s + 'o', list);
                break;
            case '7':
                bt(n + 1, c, s + 'p', list);
                bt(n + 1, c, s + 'q', list);
                bt(n + 1, c, s + 'r', list);
                bt(n + 1, c, s + 's', list);
                break;
            case '8':
                bt(n + 1, c, s + 't', list);
                bt(n + 1, c, s + 'u', list);
                bt(n + 1, c, s + 'v', list);
                break;
            case '9':
                bt(n + 1, c, s + 'w', list);
                bt(n + 1, c, s + 'x', list);
                bt(n + 1, c, s + 'y', list);
                bt(n + 1, c, s + 'z', list);
                break;

        }

    }

    public static List<String> generateParenthesis(int n) {
        List<String> first = new ArrayList<String>();
        first.add("()");
        List<List<String>> res = new ArrayList<List<String>>();
        res.add(first);
        for (int i = 2; i <= n; i++) {
            generate(res, i);
        }
        return res.get(n - 1);
    }

    private static List<List<String>> generate(List<List<String>> res, int num) {
        List<String> ans = new ArrayList<String>();

        for (int i = 1; i < num; i++) {
            for (int j = 0; j < res.get(i - 1).size(); j++) {
                for (int k = 0; k < res.get(num - i - 1).size(); k++) {
                    StringBuffer sb = new StringBuffer();
                    sb.append(res.get(i - 1).get(j));
                    sb.append(res.get(num - i - 1).get(k));
                    ans.add(sb.toString());
                }
            }
        }
        for (int k = 0; k < res.get(num - 2).size(); k++) {
            StringBuffer sb = new StringBuffer();

            sb.append('(');

            sb.append(res.get(num - 2).get(k));

            sb.append(')');


            ans.add(sb.toString());
        }
        removeDuplicate(ans);
        res.add(ans);
        return res;
    }

    public static List removeDuplicate(List list) {
        for (int i = 0; i < list.size() - 1; i++) {
            for (int j = list.size() - 1; j > i; j--) {
                if (list.get(j).equals(list.get(i))) {
                    list.remove(j);
                }
            }
        }
        return list;
    }

    public static List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ls = new ArrayList<List<Integer>>();

        for (int i = 0; i < nums.length - 2; i++) {
            if (i == 0 || (i > 0 && nums[i] != nums[i - 1])) {  // 跳过可能重复的答案

                int l = i + 1, r = nums.length - 1, sum = 0 - nums[i];
                while (l < r) {
                    if (nums[l] + nums[r] == sum) {
                        ls.add(Arrays.asList(nums[i], nums[l], nums[r]));
                        while (l < r && nums[l] == nums[l + 1]) l++;
                        while (l < r && nums[r] == nums[r - 1]) r--;
                        l++;
                        r--;
                    } else if (nums[l] + nums[r] < sum) {
                        while (l < r && nums[l] == nums[l + 1]) l++;   // 跳过重复值
                        l++;
                    } else {
                        while (l < r && nums[r] == nums[r - 1]) r--;
                        r--;
                    }
                }
            }
        }
        return ls;
    }
}
