package string;

public class StringOp {
    public static void main(String[] arg0) {
        char[] ch1 = {'p', 'j', 'g', 'o', 'o', 'o', 'd'};
        char[] ch2 = {'p', 'o'};
        MyString s = new MyString(7, ch1);
        MyString t = new MyString(2, ch2);
        StringOp op = new StringOp();
        String index = op.index(s, t, 1);
        System.out.println("�ڵ�" + index + "��λ��");
    }

    public String index(MyString S, MyString T, int pos) {
        //�����������������ַ������������λ��
        int i = pos - 1;
        int j = 0;

        //����ƥ�����ʵ���Ͼ�������index�Ĳ��ϱ仯�ͻ���
        while (i < S.MAXSIZE && j < T.MAXSIZE) {
            if (S.ch[i] == T.ch[j]) {
                i++;
                j++;
            } else {
                if(i == S.MAXSIZE-T.MAXSIZE&& j==0){
                    return "δ�ҵ�";
                }
                //�����1����ΪҪ������һλ
                i = i - j + 1;
                j = 0;
            }
        }
        //�����һ��ָ���ص��ǵڼ���
        return String.valueOf(i - j + 1);
    }
}
