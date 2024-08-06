package com.kh.chap00_intro.util;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

// ��ġ �迭ó�� �������� �����͸� Ÿ�Կ� ��� ���� ������ �� �ְԲ� ����
public class MyList {

	// �ʵ�
	
	private Object[] arr; // �ڷ����� ������� �ƹ� �����ͳ� �� ���� �� �ִ� �迭
	// ���Ÿ���� ������ �ִ� �迭 boolean�� ����
	private int size; // arr �迭�� ���� ����ִ� �������� ����
	
	// �����ں�
	// �⺻������ - arr �迭�� 10�� ¥���� �Ҵ�, size ���� 0���� ����
	public MyList() {
	//size = 0;	
	//arr = new Object[10];	
		
	arr = new Object[10];
	size = 0;
	
	
	}
	// �Ű����� ������ - ���޹��� ũ�⸸ŭ arr �迭�� lengthĭ¥���� �Ҵ�, size ���� 0���� ����
	public MyList(int length) {
		//arr= new Object[length];
		//size= 0;
		
		arr = new Object[length];
		size= 0;
		
		
	}

	// �޼ҵ��
	// add �޼ҵ� 1 - ���޹��� item �� arr �迭�� ������ �ε����� ����
	// 				��, �迭�� �̹� �� ���ִٸ� ���� arr�迭�� ���������ϵ�,
	// 				 ������ 2�� ������� ���� �� ������ �ε����� ����
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
		
		// �迭�� �̹� �� �� ���� ��� - 2�� ������� ���� ����
		
		if(arr.length == size) { 
			arr = Arrays.copyOf(arr, arr.length*2); // ���� �����ϴ� ���� Arrays.copyOf(����ũ�� , ����ũ�� *2) 
			
			
		}
		
			arr[size] = item; //ũ�Ⱑ size�ϱ� ��������°�� size��°��
			size++;
			
				
	}
	
	// add �޼ҵ� 2 - ���޹��� item �� arr �迭�� index ��° ĭ�� ����
	//				��, �迭�� �̹� �� ���ִٸ� ���� arr �迭�� ���� ����ȭ��,
	// 				 ������ 2�� ������� ���� �� �ش� �ε����� ����
	// * �ش� �ε����� ������ ������ ������ �ڷ� ��ĭ�� �о��ִ� �۾� �� ����!!
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
		// �迭�� �� ���ִ� ��� - 2�� ������� ��������
		if(arr.length == size) {
			arr = Arrays.copyOf(arr, arr.length*2);
		}
		// index �� item �� �����ϱ� ���� index ~ ������ ������
		// �ڷ� ��ĭ�� ����� �۾��� ���� ����
		
		
		
		for(int i = size; i < index; i--) {
			arr[i] = arr[i-1];
			
		}
		
		 arr[index] = item; // �̷��Ը� ���� �����ͼս��� �Ͼ
		 size++;
		
		
	}
	
	
	// set �޼ҵ� - ���� ���� index ��° ĭ�� �����͸� ���޹��� item ���� ����
	//   		   ��, inedx�� ���� ���� �ִ� �ε����� �����ؾ���!!
	
	public void set(int index, Object item) {
		
		//		if(arr[index] == null) {
		//		arr[index] = item; //���� ���� index ��° ĭ�� �����͸� ���޹��� item ���� ���� 
		//		}
		if(index < size) {
			
		arr[index] = item;
		}
		
		
	}
	
	// get �޼ҵ� - arr �迭�κ��� ���޹��� index ���� �����͸� ����
	public Object get(int index) {
		
		//return  arr[index];
		return arr[index];
		
	}
	
	// remove �޼ҵ� - arr �迭�κ��� ���޹��� index ��° �����͸� ����
	// * �ش� ������ ���� �� ���� �����͸������� ��ĭ�� ���ܿ��� �۾����� ����!!
	public void remove(int index) {
			//		for(int i = index; i <arr.length; i++) {
			//			arr[i]=arr[i+1];
			//			
			//		}
			
		// ������ ��ĭ�� ���ܿ���
		for(int i = index; i < size -1;/*������� ������ length�� �׷���?*/ i++) {
				arr[i] = arr[i+1];
					
			}
		// ������ �����ʹ� �������ֱ�
		arr[size - 1] =null; //������Ʈ �迭�̶� null�� �ȴ�.
		size--;
			
	}
	
	// size �޼ҵ� - arr �迭�� ���� ����ִ� �������� ������ ����
	public int size() {
		//return arr.length;
		return size;
	}
	// isEmpty �޼ҵ� -arr�迭�� ����ִ� �����Ͱ� �ϳ��� ���ٸ� true ����
	//										�϶� �ִٸ� false ����
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
			return (size == 0) ? true : false; // ���� ����
	}
	
	// toString �޼ҵ� �������̵� - arr �迭�� ���빰�� [��, ��, ....] �������� ���ڿ� ����
	
	@Override
	public String toString() {
		
		//return arr.toString();
		
		String str = "[";
				for(int i = 0; i<size; i++) { // �ڿ��ִ� �ΰ����� ������ �ʰ� size �������� �̾Ƴ���
					str += arr[i];
					
					if(i != size -1) {
						str +=",";
					}
				}
				 str += "]";
		return str;
	}
	
	
	
}
