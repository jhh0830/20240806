package com.kh.chap01_list.part02_mvc.view;

import java.net.ServerSocket;
import java.util.ArrayList;
import java.util.Scanner;

import com.kh.chap01_list.part02_mvc.controller.MusicController;
import com.kh.chap01_list.part02_mvc.model.vo.Music;

// View단 : 화면을 담당하는 코드만 작성할 것
// > 출력문, 입력문 을 활용!!
public class MusicView {

	// Scanner 객체를 전역변수로 선언 및 생성
	private Scanner sc = new Scanner(System.in);
	
	// MusicController 객체 또한 전역변수로 선언 및 생성
	private MusicController mc = new MusicController();
	
	// 메인화면 : 프로그램 실행 시 제일 처음으로 보여지는 화면
	public void mainMenu() {
		
		
		
		// 사용자가 종료하기 전까지 절대 끝나지 않도록 무한반복
		while(true) {
			
			System.out.println("~~~ 소리바다 ~~~");
			System.out.println("1. 새로운 곡 추가");
			System.out.println("2. 곡 전체 조회");
			System.out.println("3. 특정 곡 검색");
			System.out.println("4. 특정 곡 삭제");
			System.out.println("5. 특정 곡 수정");
			System.out.println("0. 프로그램 종료");
			
			System.out.println("---------------------");
			System.out.print("메뉴 입력 : ");
			int menu = sc.nextInt();
			sc.nextLine();
			
			
			switch(menu) {
			case 1 : 
				// 새로운 곡을 추가하는 기능 코드
				// > title, artist
				insertMusic();
				
				break;
			case 2 : 
				// 곡 전체 조회하는 기능 코드
				
				selectMusicList();
				
				
				break;
			case 3 : 
				// 곡 검색 기능 코드
				
				searchMusic();
				
				break;
			case 4 : 
				// 곡 삭제 기능 코드
				deleteMusic();
				break;
			case 5 : 
				// 곡 수정 기능 코드
				updateMusic();
				break;
				
			case 0 : 
				// 프로그램 종료 구문
				System.out.println("프로그램을 종료합니다. 안녕히 가세요.");
				return; // 나를 호출했던 곳으로 돌아감
			default :
				System.out.println();
				System.out.println("없는 메뉴를 입력하셧습니다. 다시 입력해 주세요");
				System.out.println();
				
			}
			
		}
		
	} // mainMenu 메소드 영역 끝
	
	// 1. 새로운 곡을 추가시킬수 있는 화면
	public void insertMusic() {
		
		System.out.println("--- 곡 추가 ----");
		System.out.print("곡명 입력 : ");
		String title = sc.nextLine();
		System.out.print("가수명 입력 : ");
		String artist = sc.nextLine();
		
		// Controller 로 기능 요청
		
		
		int result = mc.insertMusic(title, artist);
		if(result > 0) {
		System.out.println("성공적으로 추가되었습니다.");
		}else {
			System.out.println("곡 추가에 실패했습니다.");
		}
		
	} // insertMusic 메소드 영역 끝 
	// 2. 전체 곡을 조회할 수 있는 화면
	public void selectMusicList() {
		
		System.out.println("--- 전체 곡 조회 ---");
		
		ArrayList<Music> list = mc.selectMusicList();
		
		if(list.isEmpty()) {
			// 리스트가 비어있을 경우 (노래가 단 한곡도 없을 경우)
			
			System.out.println("현재 존재하는 곡이 없습니다.");
			
		} else {
			// 리스트가 비어있지 않을 경우(노래가 한곡 이상 존재할경우)
			
			for(int i = 0; i <list.size(); i++) {
				
				System.out.println(list.get(i));
				
			}
		}
		
	} // selectMusicList 메소드 영역 끝
	
	// 3. 특정 곡을 검색할 수 있는 화면
	public void searchMusic() {
		System.out.println("--- 특정 곡 검색 ---");
		
		System.out.print("검색할 곡명 키워도 : ");
		String keyword = sc.nextLine();
		
		ArrayList<Music> searched = mc.searchMusic(keyword);
		
		// searched.isEmpty()
		if(searched.size() == 0) {
			// 리스트가 비어있을 경우 (검색 결과가 없을 경우)
			System.out.println("검색 결과가 없습니다.");
		}else {
			// 리스트가 비어있지 않을 경우 (검색 결과가 있을 경우)
			
			System.out.println("검색 결과는 총 " + searched.size()+"건 입니다.");
			//for(int i =0; i < searched.size(); i++) {
				//System.out.println(searched.get(i));
			//}
			
			for(Music m :searched) {
				System.out.println(m);
				
			}
		}
		
	}// searchMusic 메소드 영역 끝
	// 4. 특정 곡을 삭제할 수 있는 화면
	public void deleteMusic() {
		System.out.println("--- 곡 삭제 ---");
		
		System.out.print("삭제할 곡명 : ");
		String title = sc.nextLine();
		
		
		int result = mc.deleteMusic(title);
		// > 0 일 수도 있고 양수값일 수도 있음
		
		if(result > 0) {
			// 삭제 진행됨
			System.out.println("성공적으로 삭제 되었습니다.");
		}else if(result== 0){
			// 삭제할 곳을 찾지 못함
			System.out.println("삭제할 곡을 찾지 못했습니다.");
		}
		
	}// deleteMusic 메소드 영역 끝
	
	
	//5. 특정곡을 수정할 수 있는 화면
	public void updateMusic() {
		System.out.println("---곡 수정 --");
		//
		System.out.print("기존 곡명:");
		String title = sc.nextLine();
		
		System.out.print("수정 내용 (곡명) : ");
		String upTitle =sc.nextLine();
		
		System.out.print("수정 내용 (가수명) : ");
		
		String upArtist = sc.nextLine();
		
		int result = mc.updateMusic(title, upTitle,upArtist);
		
		if(result > 0) {
			// 수정 진행됨
			System.out.println("성공적으로 수정되었습니다.");
		}else {
			// 수정할 곡을 찾지 못함
			
			System.out.println("수정할 곡을 찾지 못했습니다.");
		}
		
	}
}




