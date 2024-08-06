package com.kh.chap01_list.part02_mvc.view;

import java.net.ServerSocket;
import java.util.ArrayList;
import java.util.Scanner;

import com.kh.chap01_list.part02_mvc.controller.MusicController;
import com.kh.chap01_list.part02_mvc.model.vo.Music;

// View�� : ȭ���� ����ϴ� �ڵ常 �ۼ��� ��
// > ��¹�, �Է¹� �� Ȱ��!!
public class MusicView {

	// Scanner ��ü�� ���������� ���� �� ����
	private Scanner sc = new Scanner(System.in);
	
	// MusicController ��ü ���� ���������� ���� �� ����
	private MusicController mc = new MusicController();
	
	// ����ȭ�� : ���α׷� ���� �� ���� ó������ �������� ȭ��
	public void mainMenu() {
		
		
		
		// ����ڰ� �����ϱ� ������ ���� ������ �ʵ��� ���ѹݺ�
		while(true) {
			
			System.out.println("~~~ �Ҹ��ٴ� ~~~");
			System.out.println("1. ���ο� �� �߰�");
			System.out.println("2. �� ��ü ��ȸ");
			System.out.println("3. Ư�� �� �˻�");
			System.out.println("4. Ư�� �� ����");
			System.out.println("5. Ư�� �� ����");
			System.out.println("0. ���α׷� ����");
			
			System.out.println("---------------------");
			System.out.print("�޴� �Է� : ");
			int menu = sc.nextInt();
			sc.nextLine();
			
			
			switch(menu) {
			case 1 : 
				// ���ο� ���� �߰��ϴ� ��� �ڵ�
				// > title, artist
				insertMusic();
				
				break;
			case 2 : 
				// �� ��ü ��ȸ�ϴ� ��� �ڵ�
				
				selectMusicList();
				
				
				break;
			case 3 : 
				// �� �˻� ��� �ڵ�
				
				searchMusic();
				
				break;
			case 4 : 
				// �� ���� ��� �ڵ�
				deleteMusic();
				break;
			case 5 : 
				// �� ���� ��� �ڵ�
				updateMusic();
				break;
				
			case 0 : 
				// ���α׷� ���� ����
				System.out.println("���α׷��� �����մϴ�. �ȳ��� ������.");
				return; // ���� ȣ���ߴ� ������ ���ư�
			default :
				System.out.println();
				System.out.println("���� �޴��� �Է��ϼ˽��ϴ�. �ٽ� �Է��� �ּ���");
				System.out.println();
				
			}
			
		}
		
	} // mainMenu �޼ҵ� ���� ��
	
	// 1. ���ο� ���� �߰���ų�� �ִ� ȭ��
	public void insertMusic() {
		
		System.out.println("--- �� �߰� ----");
		System.out.print("��� �Է� : ");
		String title = sc.nextLine();
		System.out.print("������ �Է� : ");
		String artist = sc.nextLine();
		
		// Controller �� ��� ��û
		
		
		int result = mc.insertMusic(title, artist);
		if(result > 0) {
		System.out.println("���������� �߰��Ǿ����ϴ�.");
		}else {
			System.out.println("�� �߰��� �����߽��ϴ�.");
		}
		
	} // insertMusic �޼ҵ� ���� �� 
	// 2. ��ü ���� ��ȸ�� �� �ִ� ȭ��
	public void selectMusicList() {
		
		System.out.println("--- ��ü �� ��ȸ ---");
		
		ArrayList<Music> list = mc.selectMusicList();
		
		if(list.isEmpty()) {
			// ����Ʈ�� ������� ��� (�뷡�� �� �Ѱ ���� ���)
			
			System.out.println("���� �����ϴ� ���� �����ϴ�.");
			
		} else {
			// ����Ʈ�� ������� ���� ���(�뷡�� �Ѱ� �̻� �����Ұ��)
			
			for(int i = 0; i <list.size(); i++) {
				
				System.out.println(list.get(i));
				
			}
		}
		
	} // selectMusicList �޼ҵ� ���� ��
	
	// 3. Ư�� ���� �˻��� �� �ִ� ȭ��
	public void searchMusic() {
		System.out.println("--- Ư�� �� �˻� ---");
		
		System.out.print("�˻��� ��� Ű���� : ");
		String keyword = sc.nextLine();
		
		ArrayList<Music> searched = mc.searchMusic(keyword);
		
		// searched.isEmpty()
		if(searched.size() == 0) {
			// ����Ʈ�� ������� ��� (�˻� ����� ���� ���)
			System.out.println("�˻� ����� �����ϴ�.");
		}else {
			// ����Ʈ�� ������� ���� ��� (�˻� ����� ���� ���)
			
			System.out.println("�˻� ����� �� " + searched.size()+"�� �Դϴ�.");
			//for(int i =0; i < searched.size(); i++) {
				//System.out.println(searched.get(i));
			//}
			
			for(Music m :searched) {
				System.out.println(m);
				
			}
		}
		
	}// searchMusic �޼ҵ� ���� ��
	// 4. Ư�� ���� ������ �� �ִ� ȭ��
	public void deleteMusic() {
		System.out.println("--- �� ���� ---");
		
		System.out.print("������ ��� : ");
		String title = sc.nextLine();
		
		
		int result = mc.deleteMusic(title);
		// > 0 �� ���� �ְ� ������� ���� ����
		
		if(result > 0) {
			// ���� �����
			System.out.println("���������� ���� �Ǿ����ϴ�.");
		}else if(result== 0){
			// ������ ���� ã�� ����
			System.out.println("������ ���� ã�� ���߽��ϴ�.");
		}
		
	}// deleteMusic �޼ҵ� ���� ��
	
	
	//5. Ư������ ������ �� �ִ� ȭ��
	public void updateMusic() {
		System.out.println("---�� ���� --");
		//
		System.out.print("���� ���:");
		String title = sc.nextLine();
		
		System.out.print("���� ���� (���) : ");
		String upTitle =sc.nextLine();
		
		System.out.print("���� ���� (������) : ");
		
		String upArtist = sc.nextLine();
		
		int result = mc.updateMusic(title, upTitle,upArtist);
		
		if(result > 0) {
			// ���� �����
			System.out.println("���������� �����Ǿ����ϴ�.");
		}else {
			// ������ ���� ã�� ����
			
			System.out.println("������ ���� ã�� ���߽��ϴ�.");
		}
		
	}
}




