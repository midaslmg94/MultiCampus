package com.mulcam.j0125;

import java.io.FileInputStream;
import java.io.FileOutputStream;

public class FileReadWriteTest {
   public static void main(String[] args)throws Exception{
	 //a.txt 파일 읽기
	   //FileInputStream(String name)  : name==>파일의 경로 path
	   
	  FileInputStream fis = 
	  //new FileInputStream("c:\\jaelee\\workspace\\Oracle\\0125\\a.txt"); 
	  //new FileInputStream("c:/jaelee/workspace/Oracle/0125/a.txt");
	             new FileInputStream("MultiCampus/a.txt");
	 /* 
	  System.out.println(fis.read());//97
	  System.out.println(fis.read());//98
	  System.out.println(fis.read());//99
	  
	  System.out.println(fis.read());//-1 더이상 읽을 바이트 데이터 없을때.
	  System.out.println(fis.read());//-1
	  
	  System.out.println(97);  //97
	  System.out.println( (char)97 );  //'a'
	  */
	 
	  /*
	  int i;
	  //File 읽고   ------> Console(화면) 쓰기
	  while( (i=fis.read())   !=  -1  ) {
		 System.out.print((char)i); 
	  }
	  */
	  
	  
	  //File 읽고   ------> File 쓰기     : 파일Copy
	  
	  FileOutputStream fos = new FileOutputStream("0125/b.txt");
	  //FileOutputStream과 FileWriter는  명시된 파일을 생성하는 기능이 있음.
	  
	  int i;
	  while( (i=fis.read())  !=  -1   ) {//읽을 바이트가 있다면
		  fos.write(i);
	  }
	  
	  //fos.flush();//출력버퍼에 있는 데이터를 push하는 기능.
	  fos.close();//파일 자원 반환 (flush기능도 포함)
	  System.out.println("파일복사 성공!!");
	  
	  
	  
   }
}


