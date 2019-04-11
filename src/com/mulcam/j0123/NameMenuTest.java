package com.mulcam.j0123;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class NameMenuTest 
{
	public static void main(String[] args) throws IOException 
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		NamesDAO menu = new NamesDAO(); 
		
     int num;		  
     do{
		System.out.println("<이름메뉴>");
        System.out.println("1.추가 2.검색 3.수정 4.삭제 5.종료");
        System.out.print("번호입력==> ");
		num= Integer.parseInt(br.readLine());//  Integer.parseInt("1") ---> 1

		System.out.println();
		switch(num){
		    case 1: 
				       System.out.print("이름입력: ");
				       String name=br.readLine();
				       menu.insert(name);
					   break;

			case 2: menu.select(); break;
			case 3: 
				       System.out.print("수정할이름입력: ");
			           String oldName = br.readLine();

                       System.out.print("변경할이름입력: ");
					   String newName = br.readLine();

				       menu.update(oldName, newName); 
					   break;

			case 4: 
				       System.out.print("삭제할이름입력: ");
			           String delName=br.readLine();
				       menu.delete(delName);
		}//switch
        System.out.println();

	 }while(num != 5);

      System.out.println("-- END --");
	}//main
}//class end








