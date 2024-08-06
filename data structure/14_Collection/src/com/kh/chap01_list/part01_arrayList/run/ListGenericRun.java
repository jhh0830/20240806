package com.kh.chap01_list.part01_arrayList.run;

import java.util.ArrayList;
import java.util.List;

import com.kh.chap01_list.part01_arrayList.model.vo.Music;

public class ListGenericRun {
	
	/*
	 * * 제네릭 (Generic, <E>)
	 * <여기> 안에 어떠한 타입을 선언해주어 
	 * Collection 에 담을 데이터의 타입을 픽스 시켜주는 역할
	 * 
	 * > 별도의 제네릭 제시 없이 컬렉션 객체를 생성하면 E == Object
	 *  다형성 때문에 해당 컬렉션에 다양한 자식 타입들의 데이터를 모두 저장 가능!!
	 *  
	 * 
	 * > 별도의 제네릭 설정을하게 되면 E == 해당타입
	 *   해당 타입의 값들만 담을 수 있도록 유도할 수 있다!!
	 *  <String> 으로 설정하면 E  == String
	 *  <Music> 으로 설정하면 E == Music
	 * 
	 * 
	 * * 제네릭을 설정하는 이유
	 * 1. 명시한 타입의 데이터만 저장 가능 하도록 타입의 제한을 두기 위해
	 * 2. 컬렉션에 저장된 객체를 매번 꺼내서 사용할 때
	 * 	  매번 다형성에 의해 "형번환" 하는 절차를 줄일기 위해서!! (코드가 깔금)
	 * 
	 * * 제네릭 설정 시 주의 사항
	 * 반드시 "참조자료형" 타입만 기술 가능하다!!
	 * <int> (X)   --> <Integet> (0)
	 * <double> (X) --> <Double> (0)
	 * 
	 */
	
	// 제네릭 설정한 ArrayList 사용법
	public static void main(String[] args) {

		// ArrayList 객체 생성 시 제네릭 설정하기
		// ArrayList /*<Object>*/ list = new ArrayList(3);
		// > 별도의 제네릭 설정을 안하면 기본적으로 Object 타입으로 설정됨!!
		
		// ArrayList<Music> list = new ArrayList<Music>(3);
		ArrayList<Music> list = new ArrayList<>(3); // <여기> 따로 지정안해줘도됨
		// >JDk 7버전 부터는 뒤쪽의 제네릭 타입은 명시 안해도 됨!!
		
		System.out.println(list);
		
		// E : Element (제네릭)
		// 지금은 E ==  Music 위에서 Music 이라고 선언해줫기 때문에
		
		// 1. add(E e)
		list.add(new Music("Supernova", "에스파")); // [0]
		list.add(new Music("How Sweet", "뉴진스")); // [1]
		list.add(new Music("클락션", "여자아이들")); // [2]
		// list.add("끝"); 아까랑 다르게 Object 타입이 아니라 Music 타입이라 들어갈수없다.
		
		System.out.println(list);
		// > 이제는 해당 Music 타입만 취급할 수 있다.
		// 2. add(int index, E e)
		list.add(1, new Music("한 페이지가 될 수 있게", "데이식스"));
		
		
		System.out.println(list);
		
		// 3. set(int index, E e)
		list.set(0, new Music("Supernatural", "뉴진스"));
		System.out.println(list);
		
		// 4. remove(int index)
		list.remove(1);
		System.out.println(list);
		
		// 5. size()
		System.out.println("리스트에 담긴 데이터 수 :  " +  list.size());
		System.out.println("리스트의 마지막 인덱스 : " + (list.size()-1));
		
		// 6. get(int index) : E
		// 제네릭 설정 전 (다형성을 적용해야 함)
		// Music m = list.get(0);
		// System.out.println((Music)list.get(0).getTitle());
		
		// 제네릭 설정 후 (다형성을 적용 안해도 됨)
		// Music m = list.get(0);
		System.out.println(list.get(0).getTitle());
		
		System.out.println("------------------------------");
		
		// 일반 for문
		for(int i =0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
		System.out.println("------------------------------");
		// 향상된 for문
		for(Music m : list) {
			System.out.println(m.getTitle());
			
		}
		
		System.out.println("------------------------------");

		// 7. subList(int beginIndex, int endIndex)
		
		// 제네릭 설정 전
		// List sub = list.subList(0, 2);
		
		// 제네릭 설정 후
		List<Music> sub = list.subList(0, 2);
		// > 부분 리스트 추출한 결과 또한 Music 만 담겨있을 것
		
		System.out.println(sub);
		
		System.out.println("------------------------------");
		
		//8. addAll(Collection c)
		list.addAll(sub);
		
		System.out.println(list);
		
		//ArrayList<String> strList = new ArrayList<>();
		//strList.add("안녕");
		//list.addAll(strList);
		// > 통째로 추가할 경우에도 제네릭 타입을 고려해야함!!
		
		System.out.println("------------------------------");
		
		// 9. isEmpty()
		System.out.println("리스트가 비어있습니까 : " + list.isEmpty());
		
		// 10. clear()
		
		list.clear();
		System.out.println("리스트가 비어있습니까 : " + list.isEmpty());
		
		
		//ArrayList<int> intList = new ArrayList<>(); // 기본 자료형 불가
		
		ArrayList<Integer> intList = new ArrayList<>(); // 참조 자료형 가능
		
		
	}
	
	

}
