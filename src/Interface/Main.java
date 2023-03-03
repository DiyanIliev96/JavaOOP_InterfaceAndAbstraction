package Interface;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
       Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        List<Buyer> buyerList = new ArrayList<>();
        for (int i = 0; i < n ; i++) {
            Buyer buyer;
            String[] data = scanner.nextLine().split(" ");
            if (data.length == 4) {
                buyer = new Citizen(data[0],Integer.parseInt(data[1]),data[2],data[3]);
                buyerList.add(buyer);
            } else if (data.length == 3) {
                buyer = new Rebel(data[0],Integer.parseInt(data[1]),data[2]);
                buyerList.add(buyer);
            }
        }

        String nameWhoBuy = scanner.nextLine();

        while (!nameWhoBuy.equals("End")) {
            for (Buyer buyer : buyerList) {
                if (buyer.getName().equals(nameWhoBuy)) {
                    buyer.buyFood();
                }
            }
            nameWhoBuy = scanner.nextLine();
        }
        int sum = buyerList.stream().mapToInt(Buyer::getFood).sum();
        System.out.println(sum);
    }
}
