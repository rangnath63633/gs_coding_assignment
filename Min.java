package coderPadTset;
import java.util.Comparator;
import java.util.Arrays;
import java.util.stream.IntStream;

public class Min {

    public static int minimumLoss(int[] price, int n){


        PriceHouse[] ph = new PriceHouse[n];
        for(int i=0; i<n; i++){
            ph[i] = new PriceHouse(price[i], i);
        }
        //[(5, 0), (10, 1), (3, 2)]
        //[(20,0), (7,1), (8,2), (2,3), (5,4)]
        Arrays.sort(ph, Comparator.comparingInt(p -> p.price));
       // Arrays.stream(ph).forEach(System.out::println);
        // [(3, 2), (5, 0), (10, 1)]
        //[(2,3), (5,4), (7,1), (8,2),(20,0)]

        int minLoss = Integer.MAX_VALUE;

        for(int i=1; i<n; i++){
            if(ph[i].index < ph[i-1].index){
                int loss = ph[i].price-ph[i-1].price;
                minLoss = Math.min(minLoss, loss);
            }
        }
        return minLoss;

    }
    static class PriceHouse{

        int price;
        int index;

        public PriceHouse(int price, int index){
            this.price = price;
            this.index = index;
        }
    }

    public static void main(String[] args) {
            int n=3;
            int[] price = {5, 10, 3};
            int n2 = 5;
            int[] price2 = {20,7,8,2,5};

        System.out.println(minimumLoss(price, n));
        System.out.println(minimumLoss(price2, n2));
        System.out.println(houseBuy2(price2));
    }

    public static int houseBuy(int[] input) {
        int minLose = Integer.MAX_VALUE;
        for (int i = 0; i < input.length; i++) {
            for (int j = i + 1; j < input.length; j++) {
                if (input[i] > input[j]) {
                    int lose = input[i] - input[j];
                    minLose = Math.min(lose, minLose);
                }
            }
        }
        return minLose;
    }
    public static int houseBuy2(int[] input) {
            return IntStream.range(0,input.length).boxed()
                .flatMap(i -> IntStream.range(i + 1, input.length)
                        .filter(j -> input[i] > input[j])
                        .mapToObj(j -> input[i] - input[j]))
                .min(Integer::compare)
                .orElse(Integer.MAX_VALUE);
    }

}
