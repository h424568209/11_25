import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main_11_23_1 {
    //洗牌
    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        int groups = scanner.nextInt(); //数组数据
//        while(groups-- > 0 ){
//            int n = scanner.nextInt(); // 表示接下来每组有2n个数
//            int k = scanner.nextInt(); // 洗牌K次
//            int [] res = new int[2*n]; //数组总数放在数组中
//            for(int i =0 ; i < res.length ; i++){ //遍历数据数组
//                int tmp = i+1;
//                for(int j = 0 ; j < k ; j++){
//                    if(tmp <= n ){
//                        tmp = 2*tmp - 1;
//                    }else{
//                        tmp = 2*(tmp - n );
//                    }
//                }
//                res[tmp - 1] = scanner.nextInt();
//            }
//            if(res.length > 0 ){
//                System.out.print(res[0]);
//            }
//            for(int i = 1 ; i < 2*n ; i++){
//                System.out.println(" "+ res[i]);
//            }
//            System.out.println();
//        }


        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNext()){
            int groups = scanner.nextInt();// 牌的组数
            for(int i = 0; i < groups ; i++) {
                int n = scanner.nextInt();  //n张
                int k = scanner.nextInt(); //k次
                ArrayList<Integer> cards = new ArrayList<>();
                ArrayList<Integer> cards1 = new ArrayList<>();
                ArrayList<Integer> cards2 = new ArrayList<>();
                for (int j = 0; j < 2*n ; j++){
                    cards.add(scanner.nextInt());
                }
                Collections.reverse(cards);
                for(int x = 0 ; x< k ; x++){
                    cards1.clear();
                    cards2.clear();
                    for(int j = 0 ; j < n ; j++){
                        cards1.add(cards.get(j)); //6 5 4
                    }
                    System.out.println(cards1);
                    for(int j = n ; j < 2*n ; j++){
                        cards2.add(cards.get(j));  //3 2 1
                    }
                    System.out.println(cards2);
                    cards.clear();
                    for(int j = 0 ; j < n ; j++){
                        cards.add(cards1.get(j)); //6 3 5 2 4 1
                        cards.add(cards2.get(j));
                    }
                    System.out.println(cards);
                }
                Collections.reverse(cards); //1 4 2 5 3 6
                System.out.println(cards.toString().replace("["," ").replace("]"," ").replace(",",""));
            }
        }
    }
}
