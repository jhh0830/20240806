package com.kh.chap00_intro.run;

import com.kh.chap00_intro.util.MyList;

public class Run {

	public static void main(String[] args) {
		
		// MyList ��ü ����
		MyList list = new MyList(); // 10ĭ¥�� arr, size ==0
		
		System.out.println(list);
		System.out.println("size : " + list.size() );
		System.out.println("isEmpty : " + list.isEmpty());
		
		System.out.println("---------------------------");
		
		list.add("�ȳ��ϼ���"); // [0] 0���濡 �߰�
		list.add(1); // [1] 1���濡 �߰� �������� �߰� ���� Object�� ���� ������ null������
		list.add(9.876); // [2]
		list.add("hihi"); // [3]
		System.out.println(list);
		System.out.println("size : " + list.size());
		System.out.println("isEmpty : " + list.isEmpty());
		
		System.out.println("------------------------------------");
		
		list.add(2,"�߰�~~~~~");
		System.out.println(list);
		System.out.println("size :" + list.size());
		System.out.println("------------------------------------");

		list.set(0, "�ȳ���������");
		System.out.println(list);
		
		System.out.println("------------------------------------");

		list.remove(3);
		System.out.println(list);
		System.out.println("size : " + list.size());
		System.out.println("------------------------------------");

		// System.out.println("1�� �ε����� �� : " + list.get(1));
		// �ݺ��� Ȱ��
		for(int i = 0; i < list.size(); i++) {
			System.out.println(i + "�� �ε����� �� : " + list.get(i));
			
		}
		// �ٷ��� �����͸� ��� ȿ�������� ó���ϰų� �����ϴ��� �˼��ְ� �̸� 
		
	}

}
