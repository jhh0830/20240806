package com.kh.chap01_list.part01_arrayList.run;

import java.util.ArrayList;
import java.util.List;

import com.kh.chap01_list.part01_arrayList.model.vo.Music;

public class ListRun {

	/*
	 * * 컬렉션 (Collection)
	 * " 자료구조가" 가 내장되어있는 클래스로
	 * 자바에서 제공하는 "자료구조" 를 담당하는 "프레임워크" 이다.
	 * 
	 * - 자료구조 : 방대한 데이터들을 효율적 (구조적) 으로 다룰 떄 필요한 개념
	 * - 프레임워크 : 효율적인 기능들이 이미 정의되어있는 틀, 뼈대
	 * 
	 * > 정리해보면
	 * 	 데이터들이 새로우 추가되거나 , 삭제가 되거나, 수정이 되는 기능 들이
	 *   이미 코드로 정의되어있는  틀이 있다. == "컬렉션"
	 *   
	 * > 우리는 그동안
	 * 	 다량의 데이터들을 관리하고자 할때 "배열" 을 가지고 충분히 사용했었음!!
	 *   단, 배열의 단점 생각보다 크기 떄문에 보완한 것이 컬렉션!!
	 * 
	 * * 배열과 컬렉션의 차이점
	 * - 배열의 단점
	 * 1. 배열을 쓰고자 할 때 먼저 크기를 지정해야함
	 * > 한번 지정된 크기는 변경이 불가
	 * 	 새로운 값을 추가하고자 할 때 크기가 오버될 경우
	 * 	 새로운 크기의 배열을 새롭게 만들고, 기존의 내용을 깊은복사 후 
	 * 	 (코드를 내가 직접 다 짜야 함!!)
	 * 2. 배열 중간 위치에 새로운 데이터를 추가하거나 삭제하는 경우
	 * 	  기존의 값들을 앞으로 땡겨오거나 뒤로 밀어주는 코드를 일일이 다 짜야 함
	 * 3. 한 타입의 데이터들만 저장 가능
	 * - 컬렉션의 장점
	 * 1. 크기에 제약이 없다.
	 * > 크기 지정을 해줄 필요가 없고, 만일 크기지정을 하더라도
	 *   알아서 크기가 늘어나면서 새로운 데이터를 추가해주는 코드가 이미 작성되어 있음 
	 * 2. 중간에 값을 추가하거나 삭제하는 경우 값을 앞으로 떙겨오거나
	 *    뒤로 밀어주는 코드가 이미 메소드로 정의되어 있음 
	 * 3. 기본적으로 여러 타입의 데이터들을 저장할 수 있음
	 *	  (단, 제네릭 설정을 통해서 한 타입의 데이터들만 담기게끔 유도 가능)
	 * > 즉, 배열이 단점을 보완하기 위해 개발자인 내가 직접 코드를 다 짤 수 있지만
	 *   (알고리즘으로 구현) 이미 선배 개발자들이 쓰라고 메소드 단위로 코드를 짜 놨음!!
	 *  안 쓸 이유가..? 없음 컬렉션이라는 대체제가 있어서 실무에서는 배열을 거의 안쓴다.
	 *  
	 * * 배열 vs 컬렉션을 써야 하는 경우
	 *  배열 : 방대한 데이터들을 단지 담아만 두고 "조회" 만 할 목적 
	 *  컬렉션 : 방대한 데이터들이 빈번하게 "추가","수정", "삭제" 가 될것 같다?
	 *  
	 * * 컬렉션의 3가지 분류
	 * Collection 자식 계열 - List, Set 계열
	 * Map 계열
	 * 
	 * List 계열
	 * 담고자 하는 값(value) 만 저장 / 값 저장 시 순서 유지(index 개념 있음)
	 * 중복갑 허용
	 * 예) ArrayList, Vector, LinkedList >> ArrayList가 제일 많이 쓰임
	 * 
	 * Set 계열
	 * 담고자 하는 값(value) 만 저장 / 값 저장 시 순서 유지 X(index 개념 없음) / 
	 * 중복값 허용 X
	 * 예) HashSet, TreeSet
	 * 
	 * 
	 * Map 계열
	 * 키(key) + 담고자 하는  값 (value) 세트로 저장 /
	 * 값 저장 시 순서 유지 X (index 개념 없음) / key 만 중복값 허용 X
	 * 예) HashMap, HashTable, Properties 
	 * 
	 * 
	 */
	// ArrayList 사용법
	public static void main(String[] args) {
		
		// ArrayList 객체 먼저 생성
		//ArrayList list = new ArrayList();
		// >기본 생성자로 생성 시 내부적으로 크기 10짜리인 배열이 생성됨
		
		ArrayList list = new ArrayList(3);
		// > 매개변수생성자로 생성 시 내부적으로 크기 3짜리인 배열이 생성됨
		
		System.out.println(list); // >[]
		// > 안에 아무것도 없는 상태 (비어있다)
		
		// E : Element(제네릭)
		// E 가 의미하는 것 ==Object 타입
		// > 아직 제네릭 설정 방법을 배우지 않아서 셋팅 X 
		// 1. add(E e)
		// : 해당 리스트의 끝에 전달된 e 를 추가시켜주는 메소드
		list.add(new Music("Supernova", "에스파")); // [0]
		list.add(new Music("How Sweet", "뉴진스")); // [1]
		list.add(new Music("클락션", "여자아이들")); // [2]
		list.add("끝");							//[3] 타입이 다른 문자열도 넣을수있다. 배열은 같은타입만 가능
		
		
		System.out.println(list);
		// > 순서가 유지되면서 값이 추가됨 (각 index에 담겨있음)
		//   크기에 제약 없음
		//   다양한 타입의 값 추가 가능
		
		// 2. add(int index, Object e)
		// : 리스트에 전달되는 index 번째 자리에
		//   전달되는 e를 추가 시켜주는 메소드
		//  (오버로딩)
		list.add(1, new Music("한 페이지가 될 수 있게", "데이식스"));
		
		System.out.println(list);
		// > 중간에 값 추가 시 알아서 기존의 값들을 뒤로 땡겨주는 작업이
		//   내부적으로 진행됨
		
		// 3. set(int index, E e)
		// : 리스트 해당 index 자리의 값을 전달되는 e로 변경시켜주는 메소드
		list.set(0, new Music("SuperNatural" , "뉴진스"));
		System.out.println(list);
		
		// 4. remove(int index)
		// : 리스트에 해당 index 자리의 값을 삭제시켜주는 메소드
		list.remove(1);
		System.out.println(list);
		// > 중간에 값 삭제 시 내부적으로 앞으로 한칸씩 값들을 떙겨오는 작업 수행
		
		// 5. size()
		// : 현재 리스트에 담겨있는 데이터의 갯수를 반환해주는 메소드
		System.out.println("리스트에 담긴 데이터 수 : " + list.size());
		System.out.println("리스트의 마지막 인덱스 : " + (list.size() -1));
		// > 마지막 인덱스 == 리스트의 크기 - 1
		
		// 6. get(int index) : E
		// : 리스트로부터 해당 index 자리의 데이터를 반환해주는 메소드
		//Music m = (Music)list.get(0); // 다운캐스팅 강제 형변환을 해야지만 사용가능 > 자식타입으로 강제 형변환
		//System.out.println(m);
		System.out.println(list.get(0) /*.toString()*/);
		
		// 제목만 보고 싶을 경우?
		System.out.println(((Music)(list.get(0))).getTitle());
		// > DownCasting 을 정확히 한 후 해당 필드의 getter 호출
		
		System.out.println("----------------------------");
		
		// 0번 ~ 마지막 인덱스 까지의 데이터 모두 출력 (반복문)
		// for문
		for(int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
		System.out.println("----------------------------");
		
		// 향샹된 for문(foreach문) - 배열 뿐만 아니라 List 에서도 사용 가능
		// for(변수선언문 : 배열명)
		// for(변수선언문 : 리스트명)
		for(Object o : list) {
			System.out.println(o);
		}
		System.out.println("----------------------------");
		
		// 7. subList(int beginIndex, int endIndex) : List
		// : 해당 리스트로부터 beginIndex 에서 endIndex - 1 까지의
		//   데이터 값들을 추출해서 새로운 List 로 만들어서 반환해주는 메소드
		//   (substring 메소드의 List 버전)
		List sub = list.subList(0, 2);
		System.out.println(sub);
		// > endIndex는 포함 아님!!
		System.out.println("----------------------------");

		// 8. addAll(Collection c)
		// : 해당 리스트에 다른 컬렉션에 있는 데이터들을 통째로 추가해주는 메소드
		//  (String 의 concat 메소드의 List 버전)
		list.addAll(sub);
		System.out.println(list);
		
		// 9.isEmpty() : boolean
		// : 해당 리스트가 비어있는 묻는 메소드
		// 비어있으면 true, 비어있지 않으면 false 를 반환
		System.out.println("리스트가 비어있습니까: " + list.isEmpty());
		
		// 10. clear()
		// 해당 리스트를 싹 비워주는 메소드
		list.clear();
		System.out.println("리스트가 비어있습니까: " + list.isEmpty());
		System.out.println(list);
		System.out.println("size : " + list.size());
		
		
	}

}
