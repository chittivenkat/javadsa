package com.java.dsa;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;

import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class TwoDArrayDSSolution {

    /*
     * Complete the 'hourglassSum' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts 2D_INTEGER_ARRAY arr as parameter.
     */

    public static int hourglassSum(List<List<Integer>> arr) {
        // Write your code here
        System.out.println(arr);
        List<List<Integer>> arr3x3 = null;
        int currentMatrixSum=-100;
        for(int x=0;x<=3;x++){
            for(int y=0;y<=3;y++){
                arr3x3 = getArr3x3(arr, y, x);
                System.out.println("Sub Arr: " + arr3x3);
                int sumOfMatrix = getSumOfMatrix(arr3x3);
                System.out.println("Sum Of Matrix: " + sumOfMatrix);
                if(sumOfMatrix > currentMatrixSum){
                    currentMatrixSum = sumOfMatrix;
                }
                //System.out.println("Sum Of Matrix: " + sumOfMatrix);
            }
        }
        return currentMatrixSum;
    }

    private static int getSumOfMatrix(List<List<Integer>> arr3x3) {
        int sumOfMatrix=0;
        for(int i=0; i<=2; i++){//row
            List<Integer> rowArr = arr3x3.get(i);
            for (int j = 0; j <= 2; j++) {//column
                if((i==1 && (j==0 || j==2))) {
                    //System.out.println("Miss Index:" + i + "-" + j);
                }else{
                    sumOfMatrix = rowArr.get(j) + sumOfMatrix;
                    //System.out.println("M Index:" + i + "-" + j);
                }
            }
        }
        return sumOfMatrix;
    }

    private static List<List<Integer>> getArr3x3(List<List<Integer>> arr, int x, int y) {
        //int x = 0,y = 0;
        List<List<Integer>> subArr = new ArrayList<>();
        for(int i=0; i<=2; i++){//row
            List<Integer> tempArr = new ArrayList<>();
            List<Integer> rowArr = arr.get(i+y);
            for (int j = 0; j <= 2; j++) {//column
                tempArr.add(j, rowArr.get(j+x));
            }
            subArr.add(i, tempArr);
        }
        return subArr;
    }

}

public class TwoDArrayDS {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        //BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        List<List<Integer>> arr = new ArrayList<>();

        IntStream.range(0, 6).forEach(i -> {
            try {
                arr.add(
                        Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                                .map(Integer::parseInt)
                                .collect(toList())
                );
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        int result = TwoDArrayDSSolution.hourglassSum(arr);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}

