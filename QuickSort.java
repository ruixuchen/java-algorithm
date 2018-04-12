/*
 * 文件名: QuickSort.java
 * 文件编号: 
 * 版权: Copyright (c) 2018, YAN Co.Ltd. and/or its affiliates. All rights reserved.Use is subject to license terms.
 * 描述: TODO
 * 创建人: admin
 * 创建时间: 2018年04月12日 13:45
 * 修改人:
 * 修改时间: 2018年04月12日 13:45
 * 修改变更号: 
 * 修改内容: TODO
 */
package com.crx.qichacha;

/**
 * @Title QuickSort
 * @Description TODO
 * @author admin
 * @date 2018年04月12日 13:45
 * @version V1.0
 * @see 
 * @since V1.0
 * 
 */
public class QuickSort<T extends Comparable<T>> {
    public static void main ( String[] args ) {
       QuickSort<Integer> quickSort=new QuickSort<Integer> ();
       Integer[] a={9,3,1,4,6,2};
       quickSort.quickSort ( a, 0, a.length-1 );
       for ( Integer integer : a ) {
           System.out.println ( integer );
       }
    }
    /*
     * 快速排序
     */
    public void quickSort(T[] a,int start,int end){
        if(start<end){
            int mid=partition ( a, start, end );
            quickSort ( a, mid+1, end );
            quickSort ( a, start, mid );
        }
    }
    /*
     * 以主元进行分割
     */
    private int partition(T[] a,int start,int end){
        int i=start;
        int j=end;
        T key=a[start];
        T temp;
        while(i<j){
            while(i<j&&a[j].compareTo ( key )>0){
                j--;
            }
            if(i<j){
                temp=a[j];
                a[j]=a[i];
                a[i]=temp;
                i++;
            }
            while(i<j&&a[i].compareTo ( key )<0){
                i++;
            }
            if(i<j){
                temp=a[j];
                a[j]=a[i];
                a[i]=temp;
                j--;
            }
        }
        return i;
    }
}
