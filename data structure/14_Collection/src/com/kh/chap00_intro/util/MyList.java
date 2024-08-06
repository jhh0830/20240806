package com.kh.chap00_intro.util;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

// 마치 배열처럼 여러개의 데이터를 타입에 상관 없이 저장할 수 있게끔 구현
public class MyList {

	// 필드
	
	private Object[] arr; // 자료형에 상관없이 아무 데이터나 다 담을 수 있는 배열
	// 모든타입을 넣을수 있는 배열 boolean도 가능
	private int size; // arr 배열에 실제 담겨있는 데이터의 갯수
	
	// 생성자부
	// 기본생성자 - arr 배열을 10만 짜리로 할당, size 값도 0으로 셋팅
	public MyList() {
	//size = 0;	
	//arr = new Object[10];	
		
	arr = new Object[10];
	size = 0;
	
	
	}
	// 매개변수 생성자 - 전달받은 크기만큼 arr 배열을 length칸짜리로 할당, size 값도 0으로 셋팅
	public MyList(int length) {
		//arr= new Object[length];
		//size= 0;
		
		arr = new Object[length];
		size= 0;
		
		
	}

	// 메소드부
	// add 메소드 1 - 전달받은 item 을 arr 배열의 마지막 인덱스에 저장
	// 				단, 배열이 이미 다 차있다면 기존 arr배열을 깊은복사하되,
	// 				 기존의 2배 사이즈로 복사 후 마지막 인덱스에 저장
	public void add(Object item) {
		//		size = 10;
		//		if(arr.length == size) {
		//			Object [] copy = new Object[size*2];
		//			arr[arr.length-1] = item; 
		//			for(int i = 0; i<arr.length-1;i++) {
		//				copy[i] = arr[i];
		//				
		//			}
		//			
		//		}else {
		//			arr[arr.length-1] = item;
		//		}
		//			
		
		// 배열이 이미 다 차 있을 경우 - 2배 사이즈로 깊은 복사
		
		if(arr.length == size) { 
			arr = Arrays.copyOf(arr, arr.length*2); // 깊은 복사하는 구문 Arrays.copyOf(기존크기 , 기존크기 *2) 
			
			
		}
		
			arr[size] = item; //크기가 size니깐 마지막번째는 size번째임
			size++;
			
				
	}
	
	// add 메소드 2 - 전달받은 item 을 arr 배열의 index 번째 칸에 저장
	//				단, 배열이 이미 다 차있다면 기존 arr 배열을 깊은 복사화되,
	// 				 기존의 2배 사이즈로 복사 후 해당 인덱스에 저장
	// * 해당 인덱스의 값부터 마지막 값까지 뒤로 한칸씩 밀어주는 작업 후 진행!!
	public void add(int index, Object item) {
//		size = 10;
//		if(arr.length == size) {
//			Object [] copy2 = new Object[size*2];
//			arr[index] = item;
//			for(int i = index; i<arr.length;i++) {
//				copy2[i+1] = arr[i];
//				
//			}
//			
//		}else {
//			arr[index]  = item;
//		}
		// 배열이 다 차있는 경우 - 2배 사이즈로 깊은복사
		if(arr.length == size) {
			arr = Arrays.copyOf(arr, arr.length*2);
		}
		// index 에 item 을 대입하기 전에 index ~ 마지막 값까지
		// 뒤로 한칸씩 땡기는 작업을 먼저 진행
		
		
		
		for(int i = size; i < index; i--) {
			arr[i] = arr[i-1];
			
		}
		
		 arr[index] = item; // 이렇게만 쓰면 데이터손실이 일어남
		 size++;
		
		
	}
	
	
	// set 메소드 - 전달 받은 index 번째 칸의 데이터를 전달받은 item 으로 변경
	//   		   단, inedx는 현재 값이 있는 인덱스로 제시해야함!!
	
	public void set(int index, Object item) {
		
		//		if(arr[index] == null) {
		//		arr[index] = item; //전달 받은 index 번째 칸의 데이터를 전달받은 item 으로 변경 
		//		}
		if(index < size) {
			
		arr[index] = item;
		}
		
		
	}
	
	// get 메소드 - arr 배열로부터 전달받은 index 번쨰 데이터를 리턴
	public Object get(int index) {
		
		//return  arr[index];
		return arr[index];
		
	}
	
	// remove 메소드 - arr 배열로부터 전달받은 index 번째 데이터를 삭제
	// * 해당 데이터 삭제 후 뒤의 데이터를앞으로 한칸씩 땡겨오는 작업까지 진행!!
	public void remove(int index) {
			//		for(int i = index; i <arr.length; i++) {
			//			arr[i]=arr[i+1];
			//			
			//		}
			
		// 앞으로 한칸씩 떙겨오기
		for(int i = index; i < size -1;/*사이즈보다 작은게 length라서 그런듯?*/ i++) {
				arr[i] = arr[i+1];
					
			}
		// 마지막 데이터는 삭제해주기
		arr[size - 1] =null; //오브젝트 배열이라 null이 된다.
		size--;
			
	}
	
	// size 메소드 - arr 배열에 실제 담겨있는 데이터의 갯수를 리턴
	public int size() {
		//return arr.length;
		return size;
	}
	// isEmpty 메소드 -arr배열에 담겨있는 데이터가 하나도 없다면 true 리턴
	//										하라도 있다면 false 리턴
	public boolean isEmpty() {
			//		 if(arr == null) {
			//			 return true;
			//		}else {
			//			return false;
			//		}
			//		if(size == 0) {
			//			return true;
			//		}else {
			//			return false;
			//		}
			return (size == 0) ? true : false; // 위와 같음
	}
	
	// toString 메소드 오버라이딩 - arr 배열의 내용물을 [값, 값, ....] 형식으로 문자열 리턴
	
	@Override
	public String toString() {
		
		//return arr.toString();
		
		String str = "[";
				for(int i = 0; i<size; i++) { // 뒤에있는 널값까지 나오지 않게 size 값까지만 뽑아내기
					str += arr[i];
					
					if(i != size -1) {
						str +=",";
					}
				}
				 str += "]";
		return str;
	}
	
	
	
}
