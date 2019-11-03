package com.linear;


//一个数据结构类
public class SqList {
	//成员变量：顺序存储结构的三个描述属性：1.最大长度 2.首地址值 3.当前长度
	public final int MAXSIZE;
	public Object[] Data;
	public int length;
	//成员方法：必有构造函数，其余操作在另一个类定义
	//没有无参构造：因为新建线性表必须定义最大长度
	//有参构造1：无初始值
	public SqList(int MAXSIZE){
		this.MAXSIZE = MAXSIZE;
		this.length = 0;
		Data = new Object[MAXSIZE];
	}
	//有参构造2：有初始值，初始值为一串数组
	public SqList(int MAXSIZE,int length,Object[] Data) {
		this.MAXSIZE = MAXSIZE;
		this.length = length;
		//初始数组的地址值被赋予成员变量
		this.Data = Data;
	}
}
