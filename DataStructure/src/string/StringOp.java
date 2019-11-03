package string;

public class StringOp {
    public static void main(String[] arg0) {
        char[] ch1 = {'p', 'j', 'g', 'o', 'o', 'o', 'd'};
        char[] ch2 = {'p', 'o'};
        MyString s = new MyString(7, ch1);
        MyString t = new MyString(2, ch2);
        StringOp op = new StringOp();
        String index = op.index(s, t, 1);
        System.out.println("在第" + index + "个位置");
    }

    public String index(MyString S, MyString T, int pos) {
        //定义两个代表两个字符串里面的数组位置
        int i = pos - 1;
        int j = 0;

        //整个匹配过程实际上就是两个index的不断变化和回溯
        while (i < S.MAXSIZE && j < T.MAXSIZE) {
            if (S.ch[i] == T.ch[j]) {
                i++;
                j++;
            } else {
                if(i == S.MAXSIZE-T.MAXSIZE&& j==0){
                    return "未找到";
                }
                //这里加1是因为要往后推一位
                i = i - j + 1;
                j = 0;
            }
        }
        //这里加一是指返回的是第几个
        return String.valueOf(i - j + 1);
    }
}
