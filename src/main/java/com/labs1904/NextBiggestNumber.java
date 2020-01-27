package com.labs1904;

import sun.security.util.Debug;

import java.util.ArrayList;

public class NextBiggestNumber {

    public static ArrayList<Integer> permutation_list = new ArrayList<Integer>();

    public static void main(String[] args) {
        Integer input = Integer.parseInt(args[0]);
        int nextBiggestNumber = getNextBiggestNumber(input);
        System.out.println("Input: " + input);
        System.out.println("Next biggest number: " + nextBiggestNumber);
    }

    public static int getNextBiggestNumber(Integer i) {
        String strInput = i.toString();

        permute(strInput,0,strInput.length() -1);

        int lowest_difference = -1; //flag to start the search
        int nextBiggest = -1;

        for(Integer item :permutation_list){

            int difference = item - i;

            if(difference > 0){ //is item higher than input

                if (lowest_difference == -1){ //first time being set
                    lowest_difference = difference;
                    nextBiggest = item;
                }else if(lowest_difference > difference){
                    lowest_difference = difference;
                    nextBiggest = item;
                }
            }

        }

        permutation_list.clear();

        return nextBiggest;
    }

    private static void permute(String str, int index, int upper_bound)
    {
        if (index == upper_bound)
            permutation_list.add(Integer.parseInt(str));
        else {
            for (int i = index; i <= upper_bound; i++) {
                str = swap(str, index, i);
                permute(str, index + 1, upper_bound);
                str = swap(str, index, i);
            }
        }
    }

    public static String swap(String str, int i, int j)
    {
        char temp;
        char[] charArray = str.toCharArray();
        temp = charArray[i];
        charArray[i] = charArray[j];
        charArray[j] = temp;
        return String.valueOf(charArray);
    }
}

