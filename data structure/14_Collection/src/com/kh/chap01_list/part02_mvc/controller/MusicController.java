package com.kh.chap01_list.part02_mvc.controller;

import java.util.ArrayList;

import com.kh.chap01_list.part02_mvc.model.vo.Music;

// Controller : 사용자의 "요청" 을 받아서 해당 기능 구현 관련 코드
public class MusicController {

	// 전역변수로 음악 정보를 담을수 있는 "저장소" 만들기
	private ArrayList<Music> list = new ArrayList<>();
	{
		// 초기화 블록
		// 해당 저장소에 들어갈 Music 객체를 add 하는 구문들 작성
		list.add(new Music("Supernova", "에스파"));
		list.add(new Music("After Like", "아이브"));
		list.add(new Music("고민중독","QWER"));
		list.add(new Music("Supernatural", "뉴진스"));
		
	}
	
	
	
	// 1. 새로운 곡을 추가시키는 기능 메소드
	public int insertMusic(String title, String artist) {
		int before = list.size();
		
		list.add(new Music(title, artist));
		int after = list.size();
		
		return after - before;
		
	}

	// 2. 전체 곡을 조회할 수 있는 기능 메소드
	public ArrayList<Music> selectMusicList() {
		return list;
			
	}
	
	// 3. 특정 곡을 검색할 수 있는 기능 메소드
	
	public ArrayList<Music> searchMusic(String keyword) { 
		
		// 검색 결과를 담아둘 ArrayList 생성
		ArrayList<Music> searched = new ArrayList<>();
		
		for(int i = 0; i < list.size(); i++) {
			
			// i번째 노래 제목에 keyword 가 포함되어있는지 if문으로 구별
			
			if(list.get(i).getTitle().contains(keyword)/*아까  ArrayList<Music>로 선언했기때문에 어차피 music만 찾음*/) {
				//.contains > 포함되어있다면 true 키워드로 찾아내는건 이걸로 하는게 더 좋을듯
				//System.out.println(list.get(i));
				searched.add(list.get(i));
			}
		}
		
		// 이 시점 기준으로 searched 에 검색 결과가 잘 담겨있을것
		return searched;
	}
	// 4. 특정 곡을 삭제하는 기능의 메소드
	public int deleteMusic(String title) {
		
		int result = 0;
		for(int i = 0; i < list.size(); i++) {
			
			// 곡 제목이 정확하게 일치할 경우에만 삭제 처리
			if(list.get(i).getTitle().equals(title)) {
				
				list.remove(i);
				i--; // 뒤의 데이터가 앞으로 한칸씩 떙겨왔기 때문
				
				result++;
			}
			
			
			
	}
		return result;
		
	}
	//5. 
	public int updateMusic(String title, String upTitle, String upArtist) {
		int result = 0;
		for(int i = 0; i < list.size(); i++) {
			// 곡 제목이 정확하게 일치할 경우에만 수정 작업 진행
			if(list.get(i).getTitle().equals(title)) {
				// 방법 1.
				
				//list.set(i, new Music(upTitle, upArtist));
				
				// 방법 2.
				list.get(i).setTitle(upTitle);
				list.get(i).setArtist(upArtist);
				
				result++;
				
			}
		}
		return result;
		
	}
	
}
