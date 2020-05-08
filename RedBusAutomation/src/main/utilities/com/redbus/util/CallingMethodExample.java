package com.redbus.util;

public class CallingMethodExample {

	public static void main(String[] args) {
		method1();
		
	}

	private static void method1() {
		System.err.println(Thread.currentThread().getStackTrace()[2].getMethodName());
		System.err.println(Thread.currentThread().getStackTrace()[1].getMethodName());
	//	System.err.println(Thread.currentThread().getStackTrace()[0].getMethodName());

		System.out.println("CallingMethodExample.method1()");
		
	}

}
