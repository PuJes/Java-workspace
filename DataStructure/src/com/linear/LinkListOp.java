package com.linear;

public class LinkListOp {
	public static void main(String[] arg0) {
		//实例化一个操作类
		LinkListOp a = new LinkListOp();
		//这个是链表
		LinkList L1 = a.initLi();
		//这个是新建的结点
		LinkList L2 = new LinkList("pujess");
		
		a.insertLi(L1, 1,L2);
		LinkList L3 = a.getLi(L1, 1);
		System.out.println(L3.data);
		System.out.println(L1.data);
		System.out.println(L1.nextNode);
		a.deletLi(L1, 1);
		System.out.println(L1.data);
		System.out.println(L1.nextNode);
	}
	public LinkList initLi() {
		LinkList L = new LinkList(1);
		return L;
	}

	public int insertLi(LinkList L, int i, LinkList data) {
		// 抛出异常
		if (i <= 0) {
			return 0;
		}
		// 头结点存储的时候数组长度
		L.data = (int) L.data + 1;
		// 找第i-1+1个位置：因为头结点不存放数据但是占了第一个位置
		for (int m = 1; m < i - 1 + 1; m++) {
			if (L.nextNode == null) {
				// 由于没有到第i个位置链表已经终止，所以i是超过了数组长度的，返回错误
				return 0;
			}
			L = L.nextNode;
		}
		
		// 插入
		data.nextNode = L.nextNode;
		L.nextNode = data;

		return 1;
	}
	public int deletLi(LinkList L, int i) {
		// 抛出异常
		if (i <= 0) {
			return 0;
		}
		// 头结点存储的时候数组长度
		L.data = (int) L.data - 1;
		// 找第i+1-1个位置：因为头结点不存放数据但是占了第一个位置
		for (int m = 1; m < i + 1 - 1 ; m++) {
			if (L.nextNode == null) {
				// 由于没有到第i个位置链表已经终止，所以i是超过了数组长度的，返回错误
				return 0;
			}
			L = L.nextNode;
		}

		// 删除
		L.nextNode = L.nextNode.nextNode;

		return 1;
	}

	public LinkList getLi(LinkList L, int i) {
		// 找存放数据的第i+1-1个位置
		for (int m = 1; m < i + 1 - 1; m++) {
			if (L.nextNode == null) {
				// 由于没有到第i个位置链表已经终止，所以i是超过了数组长度的，返回空
				return null;
			}
			L = L.nextNode;
		}
		return L.nextNode;
	}
}
