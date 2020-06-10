package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class stringTest {
    private String qdk;
    public String getQdk() {
        return qdk;
    }
    public void setQdk(String qdk) {
        this.qdk = qdk;
    }
    public static void main(String[] args) {

        stringTest zsw1=new stringTest();
        zsw1.setQdk("123");
        stringTest zsw2 =new stringTest();
        String a="123";
        List<Integer> list=new ArrayList<>();
        String b=new String("123");
        if(a==b){
            System.out.println("zswsb");
        }
        zsw2.setQdk(a);
        if(zsw1.getQdk()==zsw2.getQdk()){
            System.out.println("zswsb1");
        }
        if(String.valueOf(zsw1.getQdk())==String.valueOf(zsw2.getQdk())){
            System.out.println("qdksb");
        }
    }
}
