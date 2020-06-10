package com.company;

public class Q286 {
    public static void wallsAndGates(int[][] rooms) {
        if(rooms.length==0||rooms[0].length==0)return;
        for(int i=0;i<rooms.length;i++){
            for(int j=0;j<rooms[0].length;j++){
                if(rooms[i][j]==0){
                    infect(rooms,i,j,0);
                }
            }
        }
    }
    private static void infect(int[][] rooms,int i,int j,int num){
        if(i < 0 || i >= rooms.length ||j < 0 || j >= rooms[0].length||rooms[i][j]<=num){
            return ;
        }

        rooms[i][j]=num;
        infect(rooms,i+1,j,num+1);
        infect(rooms,i,j+1,num+1);
        infect(rooms,i-1,j,num+1);
        infect(rooms,i,j-1,num+1);
    }
}
