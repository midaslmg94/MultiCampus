package com.mulcam.j0125;

class MyThread extends Thread{
	public void run() {
		// 동시에 실행할 문장
		try {
			for(int i=0; i<10; i++) {
				//Thread.sleep(long millis);
				sleep(500); // 0.5초 간격으로 실행
				System.out.println(getName()+":"+i);
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	} // run : 쓰레드의 특성 메소드
}// class MyThread 

class MyThread2 extends Test implements Runnable{

	@Override
	public void run() {
		try {
			for(int i=0; i<10; i++) {
				//Thread.sleep(long millis);
				Thread.sleep(500); // 0.5초 간격으로 실행
				System.out.println("길동스레드:"+i);
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
}


public class ThreadTest {
	public static void main(String[] args) {
		MyThread t1 = new MyThread();
		// MyThread는 쓰레드 객체이다
		//t1.run(); //안된다. --> 일반 메소드 호출과 같아짐. 쓰레드 메소드가 아님
		t1.start(); // start()메소드에게 run()메소드 실행을 위임. 
		MyThread2 r = new MyThread2();
		// MyThread2는 쓰레드 객체가 아니다. --> Runnable 객체이다. 
		// Runnable를 사용할 경우 Thread 객체를 직접 생성해주어야 함.
		Thread t2 = new Thread(r);
		// r은 Thread에게 run()메소드의 위치를 알려주는 역할
		t2.start();
		// 길동스레드가 앞에있는 t1이 끝날때까지 기다리지 않고 같이 실행된다
	}

}
