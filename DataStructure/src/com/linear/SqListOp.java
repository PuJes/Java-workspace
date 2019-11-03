package com.linear;

public class SqListOp {
	public static void main(String[] arg0) {
		//ʵ��һ���������Ա�˳��洢�ķ������϶���
		SqListOp Op = new SqListOp();
		//��������Ϊ10�Ŀ����Ա�
		SqList L1 = Op.initSq(10);
		//����Ԫ��
		Op.insertSq(L1, "pu", 1);
		//�õ�Ԫ��
		String a = (String)Op.getSq(L1, 1);
		System.out.println(a);
		
	}
	//����Ҫд��Ա��������Ϊ���Ƿ����ļ��ϣ��ǶԺܶ�SqList���������
	/**
	 * 1.˼��������������
	 * 2.˼��������ֲ���
	 * 3.˼���׳��쳣
	 * 4.���ʵ�ַ���
	 * @param size:���봴�����������ݳ���
	 * @return ���������ݽṹ
	 */
	public SqList initSq(int size) {
		if(size < 0 || size == 0) {
			 return null;
		}
		SqList L = new SqList(size);
		return L;
	}
	/**
	 * ��������
	 * @param L:�����ĸ�����
	 * @param inData:���������ֵ
	 * @param i:�����λ��
	 * @return ����״̬
	 */
	public int insertSq(SqList L,Object inData,int i) {
		//�׳��쳣
		if(i<1 || i>L.length+1 ||i>L.MAXSIZE || L.length+1>L.MAXSIZE) {
			return 0;
		}
		//����Ԫ�ش�iλ�ö�����һλ����������ζ����Ҫ�ȴ����һ��Ԫ�ص���ʱ�洢����
		for(int m = L.length-1;m >= i-1 ;m = m-1) {
			L.Data[m+1] = L.Data[m];
		}
		//�������ݵ�
		L.Data[i-1] = inData;
		//���鳤����1
		L.length = L.length + 1;
		return 1;
	}
	/**
	 * ��ȡ
	 * @param L
	 * @param i
	 * @return ���ػ�ȡ��Ԫ��
	 */
	public Object getSq(SqList L,int i){
		//�׳��쳣
		if(i<0 || i>L.length) {
			return 0;
		}
		//��ȡ��Ӧλ��Ԫ��
		Object Data = L.Data[i-1];
		return Data;
	}
}
