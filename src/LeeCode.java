import java.util.Stack;

public class LeeCode {
    /**
     * () 得 1 分。
     * AB 得 A + B 分，其中 A 和 B 是平衡括号字符串。
     * (A) 得 2 * A 分，其中 A 是平衡括号字符串。
     * 遇到左括号 n左移  右括号 右移
     * @param S 括号的字符串
     * @return 括号的分数
     */
    public int scoreOfParentheses(String S) {
        int length = S.length();
        int sum = 0 ;
        int n = 0;
        for(int i =0  ; i < length ; i++){
            if(S.charAt(i) =='('){
                if(n==0){
                    n=1;
                }else{
                    n= n<<1;
                }
            }else if(S.charAt(i) == ')'){
                if(S.charAt(i-1) == '('){
                    sum+=n;
                }
                n=n>>1;
            }
        }
        return sum;
    }
    public String removeKnums(String num , int k){
        if(k>=num.length()){
            return "0";
        }
        int n = num.length();
        //比当前元素小就出栈，否则就入栈
        Stack<Integer> stack = new Stack<>();
        int i =0 ;
        for(;i<n;i++){
            if(k==0){
                break;
            }
            int val = num.charAt(i) - '0';
            //添加之前把比自己小的全部弹出
            while(!stack.isEmpty() && val<stack.peek() && k>0){
                stack.pop();
                k--;
            }
            //栈为空 或者 自己是0的话不允许加入
            if(!stack.isEmpty() || val!= 0 ){
                stack.push(val);
            }
        }
        //若是顺序递增的  则从后向前进行删除
        while(k>0){
            stack.pop();
            k--;
        }
        StringBuffer res = new StringBuffer();
        //添加的时候从头部进行添加，否则就是逆序的
        while(!stack.isEmpty()){
            res.insert(0,String.valueOf(stack.pop()));
        }
        //break 到这里  进行字符串切割
        if(i<num.length()){
            res.append(num.substring(i));
        }
        return res.length() == 0? "0":res.toString();
    }
    /**
     *   循环k次 每次删除最大的元素
     *   内层循环作用是找最大元素的索引
     *   字符串可以根据索引进行删除元素
     * @param num 字符串
     * @param k 删除k个元素
     * @return 最小的字符串
     */
    public String removeKdigits(String num, int k) {
       if(num.length() == k ){
           return "0";
       }
       StringBuffer s = new StringBuffer(num);
       for(int i =0 ; i < k  ;i ++){
           int index = 0;
           for(int j = 1 ; j < s.length() && s.charAt(j)>=s.charAt(j-1); j++){
               index = j ;
           }
           s.delete(index,index+1);
           //排除最开始是0的情况
           while(s.length() >1 && s.charAt(0) == '0')
               s.delete(0,1);
       }
       return s.toString();
    }

    public static void main(String[] args) {
        String s=  "123321";
        LeeCode l = new LeeCode();
        System.out.println(l.removeKdigits(s,3));
        System.out.println(l.removeKnums(s,3));
        String ss = "(()(()))";//()()((()))";
        System.out.println(l.scoreOfParentheses(ss));
    }
}
