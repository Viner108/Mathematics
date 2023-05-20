package org.example;

public class OrderAmount {
    static int[] array = {0, 1, 2, 3, 4};
    static int[] newarray = new int[120];
    static int j=0;
    public static void main(String[] args) {
        order();
        int sum=0;
        for (int i = 0; i < newarray.length; i++) {
            if(newarray[i]/10000>=1) {
                sum += newarray[i];
            }
        }
        printLines(newarray);
        System.out.println(j);
        System.out.println(sum);
    }

    private static void order() {
        newarray[j] = count();
        for (int i = 1; i < array.length; i++) {
            permutation();
            returnarray(array.length - i, array.length - 5);
            returnarray(array.length - 1, array.length - 4);
            returnarray(array.length - 2, array.length - 3);
            if(j<newarray.length) {
                newarray[j] = count();
            }
        }
        permutation();
    }

    public static void permutation() {
        if(j<newarray.length) {
            for (int i = 1; i < array.length-1; i++) {
                j++;
                repeat();
                returnarray(array.length - i, array.length - 4);
                returnarray(array.length - 1, array.length - 3);
                newarray[j] = count();
            }
            j++;
            repeat();
        }
    }

    private static void repeat() {
        if(j<newarray.length) {
            returnarray(array.length - 1, array.length - 2);
            newarray[j] = count();
            j++;
            returnarray(array.length - 1, array.length - 3);
            returnarray(array.length - 1, array.length - 2);
            newarray[j] = count();
            j++;
            returnarray(array.length - 1, array.length - 2);
            newarray[j] = count();
            j++;
            returnarray(array.length - 2, array.length - 3);
            returnarray(array.length - 1, array.length - 2);
            newarray[j] = count();
            j++;
            returnarray(array.length - 1, array.length - 2);
            newarray[j] = count();
            j++;
        }
    }

    public static int count() {
        int count = 0;
        int j = 0;
        for (int k = array.length - 1; k >= 0; k--) {
            count += array[k] * Math.pow(10, j++);
        }
        return count;
    }

    public static void returnarray(int i1, int i2) {
        int temp = array[i1];
        array[i1] = array[i2];
        array[i2] = temp;
    }

    public static void printLines(int[] array) {
        System.out.print("[");
        for (int i = 0; i < array.length; i++) {
            if (i > 0) {
                System.out.print(", ");
            }
            System.out.print(String.format(" %2d", array[i]));
        }
        System.out.println("]");
    }
}