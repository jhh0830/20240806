package com.kh.chap01_list.part01_arrayList.run;

import java.util.ArrayList;
import java.util.List;

import com.kh.chap01_list.part01_arrayList.model.vo.Music;

public class ListGenericRun {
	
	/*
	 * * ���׸� (Generic, <E>)
	 * <����> �ȿ� ��� Ÿ���� �������־� 
	 * Collection �� ���� �������� Ÿ���� �Ƚ� �����ִ� ����
	 * 
	 * > ������ ���׸� ���� ���� �÷��� ��ü�� �����ϸ� E == Object
	 *  ������ ������ �ش� �÷��ǿ� �پ��� �ڽ� Ÿ�Ե��� �����͸� ��� ���� ����!!
	 *  
	 * 
	 * > ������ ���׸� �������ϰ� �Ǹ� E == �ش�Ÿ��
	 *   �ش� Ÿ���� ���鸸 ���� �� �ֵ��� ������ �� �ִ�!!
	 *  <String> ���� �����ϸ� E  == String
	 *  <Music> ���� �����ϸ� E == Music
	 * 
	 * 
	 * * ���׸��� �����ϴ� ����
	 * 1. ����� Ÿ���� �����͸� ���� ���� �ϵ��� Ÿ���� ������ �α� ����
	 * 2. �÷��ǿ� ����� ��ü�� �Ź� ������ ����� ��
	 * 	  �Ź� �������� ���� "����ȯ" �ϴ� ������ ���ϱ� ���ؼ�!! (�ڵ尡 ���)
	 * 
	 * * ���׸� ���� �� ���� ����
	 * �ݵ�� "�����ڷ���" Ÿ�Ը� ��� �����ϴ�!!
	 * <int> (X)   --> <Integet> (0)
	 * <double> (X) --> <Double> (0)
	 * 
	 */
	
	// ���׸� ������ ArrayList ����
	public static void main(String[] args) {

		// ArrayList ��ü ���� �� ���׸� �����ϱ�
		// ArrayList /*<Object>*/ list = new ArrayList(3);
		// > ������ ���׸� ������ ���ϸ� �⺻������ Object Ÿ������ ������!!
		
		// ArrayList<Music> list = new ArrayList<Music>(3);
		ArrayList<Music> list = new ArrayList<>(3); // <����> ���� ���������൵��
		// >JDk 7���� ���ʹ� ������ ���׸� Ÿ���� ��� ���ص� ��!!
		
		System.out.println(list);
		
		// E : Element (���׸�)
		// ������ E ==  Music ������ Music �̶�� �����آZ�� ������
		
		// 1. add(E e)
		list.add(new Music("Supernova", "������")); // [0]
		list.add(new Music("How Sweet", "������")); // [1]
		list.add(new Music("Ŭ����", "���ھ��̵�")); // [2]
		// list.add("��"); �Ʊ�� �ٸ��� Object Ÿ���� �ƴ϶� Music Ÿ���̶� ��������.
		
		System.out.println(list);
		// > ������ �ش� Music Ÿ�Ը� ����� �� �ִ�.
		// 2. add(int index, E e)
		list.add(1, new Music("�� �������� �� �� �ְ�", "���̽Ľ�"));
		
		
		System.out.println(list);
		
		// 3. set(int index, E e)
		list.set(0, new Music("Supernatural", "������"));
		System.out.println(list);
		
		// 4. remove(int index)
		list.remove(1);
		System.out.println(list);
		
		// 5. size()
		System.out.println("����Ʈ�� ��� ������ �� :  " +  list.size());
		System.out.println("����Ʈ�� ������ �ε��� : " + (list.size()-1));
		
		// 6. get(int index) : E
		// ���׸� ���� �� (�������� �����ؾ� ��)
		// Music m = list.get(0);
		// System.out.println((Music)list.get(0).getTitle());
		
		// ���׸� ���� �� (�������� ���� ���ص� ��)
		// Music m = list.get(0);
		System.out.println(list.get(0).getTitle());
		
		System.out.println("------------------------------");
		
		// �Ϲ� for��
		for(int i =0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
		System.out.println("------------------------------");
		// ���� for��
		for(Music m : list) {
			System.out.println(m.getTitle());
			
		}
		
		System.out.println("------------------------------");

		// 7. subList(int beginIndex, int endIndex)
		
		// ���׸� ���� ��
		// List sub = list.subList(0, 2);
		
		// ���׸� ���� ��
		List<Music> sub = list.subList(0, 2);
		// > �κ� ����Ʈ ������ ��� ���� Music �� ������� ��
		
		System.out.println(sub);
		
		System.out.println("------------------------------");
		
		//8. addAll(Collection c)
		list.addAll(sub);
		
		System.out.println(list);
		
		//ArrayList<String> strList = new ArrayList<>();
		//strList.add("�ȳ�");
		//list.addAll(strList);
		// > ��°�� �߰��� ��쿡�� ���׸� Ÿ���� ����ؾ���!!
		
		System.out.println("------------------------------");
		
		// 9. isEmpty()
		System.out.println("����Ʈ�� ����ֽ��ϱ� : " + list.isEmpty());
		
		// 10. clear()
		
		list.clear();
		System.out.println("����Ʈ�� ����ֽ��ϱ� : " + list.isEmpty());
		
		
		//ArrayList<int> intList = new ArrayList<>(); // �⺻ �ڷ��� �Ұ�
		
		ArrayList<Integer> intList = new ArrayList<>(); // ���� �ڷ��� ����
		
		
	}
	
	

}
