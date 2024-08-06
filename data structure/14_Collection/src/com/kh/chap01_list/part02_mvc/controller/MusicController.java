package com.kh.chap01_list.part02_mvc.controller;

import java.util.ArrayList;

import com.kh.chap01_list.part02_mvc.model.vo.Music;

// Controller : ������� "��û" �� �޾Ƽ� �ش� ��� ���� ���� �ڵ�
public class MusicController {

	// ���������� ���� ������ ������ �ִ� "�����" �����
	private ArrayList<Music> list = new ArrayList<>();
	{
		// �ʱ�ȭ ���
		// �ش� ����ҿ� �� Music ��ü�� add �ϴ� ������ �ۼ�
		list.add(new Music("Supernova", "������"));
		list.add(new Music("After Like", "���̺�"));
		list.add(new Music("����ߵ�","QWER"));
		list.add(new Music("Supernatural", "������"));
		
	}
	
	
	
	// 1. ���ο� ���� �߰���Ű�� ��� �޼ҵ�
	public int insertMusic(String title, String artist) {
		int before = list.size();
		
		list.add(new Music(title, artist));
		int after = list.size();
		
		return after - before;
		
	}

	// 2. ��ü ���� ��ȸ�� �� �ִ� ��� �޼ҵ�
	public ArrayList<Music> selectMusicList() {
		return list;
			
	}
	
	// 3. Ư�� ���� �˻��� �� �ִ� ��� �޼ҵ�
	
	public ArrayList<Music> searchMusic(String keyword) { 
		
		// �˻� ����� ��Ƶ� ArrayList ����
		ArrayList<Music> searched = new ArrayList<>();
		
		for(int i = 0; i < list.size(); i++) {
			
			// i��° �뷡 ���� keyword �� ���ԵǾ��ִ��� if������ ����
			
			if(list.get(i).getTitle().contains(keyword)/*�Ʊ�  ArrayList<Music>�� �����߱⶧���� ������ music�� ã��*/) {
				//.contains > ���ԵǾ��ִٸ� true Ű����� ã�Ƴ��°� �̰ɷ� �ϴ°� �� ������
				//System.out.println(list.get(i));
				searched.add(list.get(i));
			}
		}
		
		// �� ���� �������� searched �� �˻� ����� �� ���������
		return searched;
	}
	// 4. Ư�� ���� �����ϴ� ����� �޼ҵ�
	public int deleteMusic(String title) {
		
		int result = 0;
		for(int i = 0; i < list.size(); i++) {
			
			// �� ������ ��Ȯ�ϰ� ��ġ�� ��쿡�� ���� ó��
			if(list.get(i).getTitle().equals(title)) {
				
				list.remove(i);
				i--; // ���� �����Ͱ� ������ ��ĭ�� ���ܿԱ� ����
				
				result++;
			}
			
			
			
	}
		return result;
		
	}
	//5. 
	public int updateMusic(String title, String upTitle, String upArtist) {
		int result = 0;
		for(int i = 0; i < list.size(); i++) {
			// �� ������ ��Ȯ�ϰ� ��ġ�� ��쿡�� ���� �۾� ����
			if(list.get(i).getTitle().equals(title)) {
				// ��� 1.
				
				//list.set(i, new Music(upTitle, upArtist));
				
				// ��� 2.
				list.get(i).setTitle(upTitle);
				list.get(i).setArtist(upArtist);
				
				result++;
				
			}
		}
		return result;
		
	}
	
}
