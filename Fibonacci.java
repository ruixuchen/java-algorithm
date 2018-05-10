import java.math.BigInteger;

public class Fibonacci {
	/**
	 * 基于递推公式f(k)=f(k-1)+f(k-2)的斐波那契数列的计算
	 * 当计算f(k)时,f(i)会被重复计算f(k+1-i)次,其中1<=i且i<=k;
	 * In other words, the number of operations to compute F(n) is proportional to 
	 * the resulting value itself, which grows exponentially.
	 * @param i
	 * @return
	 */
	public static BigInteger fibonacci(int i) {
		if(i==1) {
			return new BigInteger("1");
		}else if(i==2) {
			return new BigInteger("1");
		}else {
			return fibonacci(i-1).add(fibonacci(i-2));
		}	
	}

	private static final BigInteger BIGINTEGER2=new BigInteger("2");
	/**
	 * 时间复杂度为O(logN)的快速计算斐波那契数列算法
	 * k为偶数时：f(k)=f(k/2)*[2*f(k/2)+1)-f(k/2)]
	 * k为奇数时：f(k)=f((k+1)/2)^2+f((k-1)/2)^2
	 * @param i
	 * @return
	 */
	public static BigInteger fibonacciFastDoubling(int i) {
		if(i==1) {
			return new BigInteger("1");
		}else if(i==2) {
			return new BigInteger("1");
		}else {
			if(i%2==0) {
				return fibonacciFastDoubling(i/2).multiply(BIGINTEGER2.multiply(fibonacciFastDoubling(i/2+1)).subtract(fibonacciFastDoubling(i/2)));
			}else {
				return fibonacciFastDoubling((i+1)/2).pow(2).add(fibonacciFastDoubling((i-1)/2).pow(2));
			}
		}
	}
	private static BigInteger[] cache=new BigInteger[1000+1];
	private static final BigInteger BIGINTEGER1=new BigInteger("1");
	/**
	 * 使用缓存的斐波那契数列的计算
	 * @param i
	 * @return
	 */
	public static BigInteger fibonacciCache(int i) {
		if(i==1) {
			cache[1]=BIGINTEGER1;
			return BIGINTEGER1; 
		}else if(i==2) {
			cache[2]=BIGINTEGER1;
			return BIGINTEGER1;
		}else {
			if(cache[i-1]==null) {
				cache[i-1]=fibonacciCache(i-1);
			}
			if(cache[i-2]==null) {
				cache[i-2]=fibonacciCache(i-2);
			}
			return cache[i-1]==null?fibonacciCache(i-1):cache[i-1].add(cache[i-2]==null?fibonacciCache(i-2):cache[i-2]);
		}
	}
	
	/**
	 * 基于快速矩阵幂运算的斐波那契数列的计算
	 * [1,1;1,0]^n=[F(n+1),F(n);F(n),F(n−1)].
	 * @param i
	 * @return
	 */
	public static BigInteger fibonacciMatrix(int i) {
		Matrix<BigInteger> matrix=new Matrix<BigInteger>();
		BigInteger[][] data={{new BigInteger("1"),new BigInteger("1")},{new BigInteger("1"),new BigInteger("0")}};
		matrix.setData(data);
		Matrix<BigInteger> product=Calculator.powFast(matrix, i);
		return (BigInteger)product.getData()[0][1];
	}

}
