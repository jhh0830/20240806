package com.kh.chap00_intro.run;

import com.kh.chap00_intro.util.MyList;

public class Run {

	public static void main(String[] args) {
		
		// MyList 객체 생성
		MyList list = new MyList(); // 10칸짜리 arr, size ==0
		
		System.out.println(list);
		System.out.println("size : " + list.size() );
		System.out.println("isEmpty : " + list.isEmpty());
		
		System.out.println("---------------------------");
		
		list.add("안녕하세요"); // [0] 0번방에 추가
		list.add(1); // [1] 1번방에 추가 여러가지 추가 가능 Object로 만들어서 가능함 null까지도
		list.add(9.876); // [2]
		list.add("hihi"); // [3]
		System.out.println(list);
		System.out.println("size : " + list.size());
		System.out.println("isEmpty : " + list.isEmpty());
		
		System.out.println("------------------------------------");
		
		list.add(2,"잘가~~~~~");
		System.out.println(list);
		System.out.println("size :" + list.size());
		System.out.println("------------------------------------");

		list.set(0, "안녕히가세요");
		System.out.println(list);
		
		System.out.println("------------------------------------");

		list.remove(3);
		System.out.println(list);
		System.out.println("size : " + list.size());
		System.out.println("------------------------------------");

		// System.out.println("1번 인덱스의 값 : " + list.get(1));
		// 반복문 활용
		for(int i = 0; i < list.size(); i++) {
			System.out.println(i + "번 인덱스의 값 : " + list.get(i));
			
		}
		// 다량에 데이터를 어떻게 효율적으로 처리하거나 관리하는지 알수있게 미리 
		
	}

}
