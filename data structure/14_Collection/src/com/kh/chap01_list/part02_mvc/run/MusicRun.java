package com.kh.chap01_list.part02_mvc.run;

import com.kh.chap01_list.part02_mvc.view.MusicView;

public class MusicRun {

	public static void main(String[] args) {
		
		// 프로그램 시작과 동시에 메인메뉴가 보여지게끔
		// MusicView 클래스의 mainMenu 메소드 호출
		
		MusicView mv = new MusicView();
		mv.mainMenu();
		
	}

}
