/**
 * @Title BucketSort
 * @Description TODO
 * @author chruixu
 * @date 2018年04月13日 10:22
 * @version V1.0
 * @see 
 * @since V1.0
 * 
 */
public class BucketSort<T extends Comparable<T>> {

    public static void main ( String[] args ) {
        int[] a={3,2,5,4,1,4,0};
        bucketSort ( a );
        for ( int i : a ) {
            System.out.println ( i );
        }

    }
    
    /*
     * 桶排序
     */
    public static void bucketSort ( int[] a ) {
        int max=max ( a );
        int[] buckets=new int[max+1];
        for(int i=0;i<a.length;i++){
            buckets[a[i]]++;
        }
        int m=0;
        for(int j=0;j<buckets.length;j++){
            for(int k=0;k<buckets[j];k++){
                a[m]=j;
                m++;
            }
        }
    }
    
    /*
     * 返回一个数组的最大值
     */
    private static int max(int[] a){
        int max=a[0];   
        for(int i=0;i<a.length;i++){
            if(max<a[i]){
                max=a[i];
            }
        }
        return max;
    }


}
