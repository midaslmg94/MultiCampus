package com.mulcam.j0125;
/*
TVContribution : 메인클래스
Account        : 모금 누적 기능 (모금함, 저금통)
Customer       : (경쟁적인)모금자 : Thread
*/
public class TVContribution {
public static void main(String[] args) {
	Account account = new Account();
	
	/*Customer c1 = new Customer(account); 
	Customer c2 = new Customer(account); 
	Customer c3 = new Customer(account); 
	Customer c4 = new Customer(account); 
	Customer c5 = new Customer(account); */
	
	Customer[] customers = new Customer[5];
	//customers[i] = Thread
	for(int i =0; i<customers.length; i++ ) {
		customers[i] = new Customer(account);
		customers[i].start();
	}
	try {
		for(int i =0; i<customers.length; i++) {
			customers[i].join();
		}
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	System.out.println("총 모금액>>>"+ account.getTotal());
}
}
