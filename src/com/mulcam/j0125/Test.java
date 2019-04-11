package com.mulcam.j0125;

public class Test {

	public static void main(String[] args) {
		String str = "abc";//'a' 문자의 아스키코드 값 : 97
		byte[]b  = 	str.getBytes(); // 
		for(int i=0; i<b.length;i++)
			System.out.println("b["+i+"] = "+b[i]);
		
		// byte 배열 --> String 변환
		byte[] b2 = {97,99,101};
		String str2 = new String(b2);
		System.out.println("str2 = "+str2);
	}

}
