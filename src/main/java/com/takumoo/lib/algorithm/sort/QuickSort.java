package com.takumoo.lib.algorithm.sort;

class QuickSort {
    public static void sort(Comparable[] a, Integer start, Integer end)
    {
        if(start>=end) return;
        int p = QuickSort.partition(a, 0, start, end);
        // return;
        System.out.printf("sort: %d to %d, ", start, p);
        QuickSort.sort(a, start, p);
        System.out.printf("sort: %d to %d\n", p+1, end);
        QuickSort.sort(a, p+1, end);
    }

    private static void swap(Comparable[] a, Integer i, Integer j)
    {
        Comparable t = a[j];
        a[j] = a[i];
        a[i] = t;
    }

    private static Integer partition(Comparable[] a, Integer p, Integer low, Integer high)
    {
        if(high-low==1) {
            if(a[high].compareTo(a[low])<0) {
                swap(a, high, low);
            }
            return low;
        }
        if( p > low) {
            swap(a, p, low);
        }
        Comparable t = a[p];
        int i = low+1,  j = low+1;
        for(; j<=high; j++) {
            if(a[i].compareTo(t)<0) {
                i += 1;
                j += 1;
            }
            if(a[j].compareTo(t)<0) {
                swap(a, i, j);
                i += 1;
            }
        }
        swap(a, p, i-1);
        return i-1;
    }

    public static void main(String[] args) {
        Integer[] arr = {10, 20, 5, 3, 4, 99};
        //Integer[] arr = {10, 20};
        QuickSort.sort(arr, 0, arr.length-1);
        for (Integer val : arr) {
            System.out.println(val);
        }
    }
}