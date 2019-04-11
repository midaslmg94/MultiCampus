package com.mulcam.j0125;


public class Customer extends Thread{//모금자 클래스
	   
	Account account;
	
	public Customer(Account account) {
	    this.account=account;
	}
	
	
	@Override
	public void run() {
       try {
		for(int i=1; i<201; i++) {
			   account.deposit(1000);
			   System.out.println(getName()+":"+i+"회");
			   if(account.getTotal()>=500000) break ; //목표액 : 50만원 
			   
			   Thread.sleep(200); //0.2초 딜레이시키기
		   
		   }
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		
	}//run
}



