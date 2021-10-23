package com.mph.testpack;

public class Calculate {
	
	public int add(int... number) {
		int result =0;
			for(int i: number)
			{
				result +=i;
			}		
		return result;
	}
	public int multiply(int... number) {
		int result =1;
			for(int i: number)
			{
				result *=i;
			}		
		return result;
	}

	public int sum(int a, int b)
	{
		return a+b;
	}


	public static void main(String[] args) {
		Calculate c = new Calculate();
		System.out.println(c.add(11,22));
		System.out.println(c.add(1,2,3,4));
		System.out.println(c.add(4,5,1));
		System.out.println(c.multiply(4,5));
	}

}
