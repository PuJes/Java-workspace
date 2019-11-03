package com.linear;

public class SqListOp {
	public static void main(String[] arg0) {
		//实例一个操作线性表顺序存储的方法集合对象
		SqListOp Op = new SqListOp();
		//创建长度为10的空线性表
		SqList L1 = Op.initSq(10);
		//插入元素
		Op.insertSq(L1, "pu", 1);
		//拿到元素
		String a = (String)Op.getSq(L1, 1);
		System.out.println(a);
		
	}
	//不需要写成员变量，因为这是方法的集合，是对很多SqList对象操作的
	/**
	 * 1.思考方法返回类型
	 * 2.思考传入何种参数
	 * 3.思考抛出异常
	 * 4.最后实现方法
	 * @param size:传入创建的线性数据长度
	 * @return 创建的数据结构
	 */
	public SqList initSq(int size) {
		if(size < 0 || size == 0) {
			 return null;
		}
		SqList L = new SqList(size);
		return L;
	}
	/**
	 * 插入数据
	 * @param L:插入哪个数组
	 * @param inData:插入的数据值
	 * @param i:插入的位置
	 * @return 返回状态
	 */
	public int insertSq(SqList L,Object inData,int i) {
		//抛出异常
		if(i<1 || i>L.length+1 ||i>L.MAXSIZE || L.length+1>L.MAXSIZE) {
			return 0;
		}
		//数组元素从i位置都后移一位：“后移意味着需要先存最后一个元素到临时存储区”
		for(int m = L.length-1;m >= i-1 ;m = m-1) {
			L.Data[m+1] = L.Data[m];
		}
		//插入数据到
		L.Data[i-1] = inData;
		//数组长度增1
		L.length = L.length + 1;
		return 1;
	}
	/**
	 * 获取
	 * @param L
	 * @param i
	 * @return 返回获取的元素
	 */
	public Object getSq(SqList L,int i){
		//抛出异常
		if(i<0 || i>L.length) {
			return 0;
		}
		//获取相应位置元素
		Object Data = L.Data[i-1];
		return Data;
	}
}
