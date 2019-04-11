package com.mulcam.j0125;

public class Account {
	//저금통, 누적기능
		   private int total; //총 모금액

		   public int getTotal() {
				return total;
		   }
		   
		   public synchronized void deposit(int amount) {//모금기능
			   total+=amount; //total = total + amount	   
		   /*                    3       1       2   
		    load total 
		    add amount
		    save total 
		    */
			   //참고) 블럭동기화 
			   /// synchronized (스레드객체){
			   //동시에 수행하면 안되는 문장; }
		   
		   
		   }//deposit
		   
		   

}
