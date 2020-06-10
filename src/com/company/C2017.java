package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class C2017 {
    static class Tree{
        char data;
        Tree lchild;
        Tree rchild;

        public char getData() {
            return data;
        }

        public void setData(char data) {
            this.data = data;
        }

        public Tree getLchild() {
            return lchild;
        }

        public void setLchild(Tree lchild) {
            this.lchild = lchild;
        }

        public Tree getRchild() {
            return rchild;
        }

        public void setRchild(Tree rchild) {
            this.rchild = rchild;
        }

        public static void houxue(Tree tree){
            if(tree!=null){
                houxue(tree.lchild);
                houxue(tree.rchild);
                System.out.print(tree.data);
            }
        }
    }
    public static Tree contructTree(String fore,String zhong){
        char first=fore.charAt(0);
        Tree tree=new Tree();
        tree.setData(first);
        int a=0;
        for(int i=0;i<zhong.length();i++){
            if(first==zhong.charAt(i)){
                a=i;
            }
        }
//        if(tree.getData()=='\0'){
//            tree.setData(fore.charAt(0));
//            tree.setLchild(new Tree());
//            tree.setRchild(new Tree());
//        }
        if(a==0){
            tree.setLchild(null);
        }else{

            tree.setLchild(contructTree(fore.substring(1,a+1),zhong.substring(0,a)));
        }
        if(a!=zhong.length()-1){
            tree.setRchild(contructTree(fore.substring(a+1,fore.length()),zhong.substring(a+1,zhong.length())));
        }else{
            tree.setRchild(null);
        }
        return tree;

    }
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        String a=sc.next();
        String b=sc.next();
        Tree tree;
        tree=contructTree(a,b);
        Tree.houxue(tree);
        List<String> list=new ArrayList<String>();
        

    }
}
