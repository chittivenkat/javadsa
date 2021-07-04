package com.java.dsa;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ReverseList {
    public static void main(String[] args) {
        List<Integer> a = Arrays.asList(2,4,8,3,1);
        List<Integer> aCopy = new ArrayList();
        for(int i=0;i<a.size();i++){
            System.out.println(a.size() +"-"+ i);
            aCopy.add(i, a.get((a.size()-1) - i));
        }
        System.out.println(aCopy);
    }
}
