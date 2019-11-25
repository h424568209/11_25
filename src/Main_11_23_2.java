import java.util.Scanner;

public class Main_11_23_2 {
    //统计同成绩学生人数
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNext()){
            int N = scanner.nextInt();
            if(N==0)
                return;
            int []res= new int[N];
            for(int i =0 ; i < res.length ; i++){
                res[i] = scanner.nextInt();
            }
            int pop = scanner.nextInt();
            int count = 0;
            for(int i = 0 ; i < res.length ; i++){
                if(res[i] == pop)
                    count ++;
            }
            System.out.println(count);
        }
    }
}
