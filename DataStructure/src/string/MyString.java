package string;

public class MyString {
    //字符串没有length，它的长度可以放在数组第一个，亦可以以“\0”结尾
    final int MAXSIZE;
    char[] ch;
    public MyString(int MAXSIZE, char[] ch){
        this.MAXSIZE = MAXSIZE;
        this.ch = new char[MAXSIZE+1];
        this.ch[MAXSIZE] = '\0';
        for (int i = 0;i<MAXSIZE;i++){
            this.ch[i] = ch[i];
        }
    }
    public MyString(int MAXSIZE) {
        this.MAXSIZE = MAXSIZE;
        //初始数组的地址值被赋予成员变量
        this.ch = new char[MAXSIZE+1];
        ch[MAXSIZE] = '\0';
    }
}
