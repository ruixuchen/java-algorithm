import java.math.BigInteger;

public class Calculator {
	/**
	 * 快速幂的迭代版本,时间复杂付是O(logN)
	 * @param a
	 * @param b
	 * @return
	 */
	public static int powIterative(int a,int b){
	    int r=1,base=a;
	    while(b!=0){
		    if(b%2==1) r*=base;
		    base*=base;
		    b/=2;
	    }
	    return r;
	}
	
	/**
	 * 快速幂m的递归版本,时间复杂付是O(logN)
	 * @param a
	 * @param n
	 * @return
	 */
	public static BigInteger powFast(BigInteger a,int n) {
		if(n==1) {
			return a;
		}else {
			if(n%2==1) {
				return a.multiply(powFast(a, n/2)).multiply(powFast(a, n/2));
			}else {
				return powFast(a, n/2).multiply(powFast(a, n/2));
			}
		}	
	}
	
	/**
	 * 普通的求幂运算
	 * @param a
	 * @param n
	 * @return
	 */
	public static BigInteger powCommon(BigInteger a,int n) {
		BigInteger result=new BigInteger("1");
		while(n>0) {
			result=result.multiply(a);
			n--;
		}
		return result;
	}
	
	/**
	 * 矩阵的快速幂运算
	 * @param a
	 * @param n
	 * @return
	 */
	public static Matrix<BigInteger> powFast(Matrix<BigInteger> a,int n){
		if(n==1) {
			return a;
		}else {
			if(n%2==1) {
				return a.multiply(powFast(a, n/2)).multiply(powFast(a, n/2));
			}else {
				return powFast(a, n/2).multiply(powFast(a, n/2));
			}
		}
	}
	
	/**
	 * 快速幂运算的泛型方法
	 * @param a
	 * @param n
	 * @param clazz
	 * @return
	 */
	public static <T> T powFast(T a,int n,Class clazz){
		if(n==1) {
			return a;
		}else {
			if(BigInteger.class.equals(clazz)) {
				if(n%2==1) {
					return (T) ((BigInteger)a).multiply((BigInteger)powFast(a, n/2,BigInteger.class)).multiply((BigInteger)powFast(a, n/2,BigInteger.class));
				}else {
					return (T) ((BigInteger)powFast(a, n/2,BigInteger.class)).multiply((BigInteger) powFast(a, n/2,BigInteger.class));
				}
			}else if(Matrix.class.equals(clazz)) {
				if(n%2==1) {
					return (T) ((Matrix)a).multiply((Matrix)powFast(a, n/2,Matrix.class),BigInteger.class).multiply((Matrix)powFast(a, n/2,Matrix.class),BigInteger.class);
				}else {
					return (T) ((Matrix)powFast(a, n/2,Matrix.class)).multiply((Matrix) powFast(a, n/2,Matrix.class),BigInteger.class);
				}
			}else {
				try {
					throw new Exception("该类型不支持求幂运算");
				}catch (Exception e) {
					e.printStackTrace();
				}
				return null;
			}
			
		}
	}
}
