import com.sun.org.apache.xpath.internal.objects.XBoolean;

import java.util.*;

public class Game {

    Game(){}
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Active active = new Active();
        Bonus bonus = new Bonus();

        System.out.println("Добро пожаловать игроки Монополий! \nСперва давайте познакомимся с правилами:\n\nИгроки поочередно кидают игральные кости и делают соответствующее количество ходов на игровом поле. \nВстав на поле с активом, игрок может приобрести его, если он свободен, а если он принадлежит другому игроку, \nто игрок обязан заплатить за посещение данного поля по установленному правилами прейскуранту. \nПри посещении поля с событиями игрок получает указание следовать выпавшему ему событию. \nПример: получить дополнительные средства из Банка (Банк — это ещё один игрок, который взаимодействует с игроками-людьми посредством событий, \nпроисходящих в игре), отдать часть своих средств Банку, передвинуться на другое поле, отдать часть своих средств другим игрокам, пропустить свой следующий ход, получить дополнительный ход и другие." + "\n");

        System.out.print("Укажите количество играков: ");
        int n = sc.nextInt();
        System.out.println();


        String[] players = new String[n];
        int[] pay = new int[n];
        int[] place = new int[n];
        boolean[] motion = new boolean[n];

        int[] map = new int[40];

        for (int i = 0; i < 40; i++) {
            map[i] = -1;
        }

        map[0] = -10;
        map[2] = -2;
        map[4] = -4;
        map[7] = -2;
        map[10] = -11;
        map[17] = -2;
        map[20] = -12;
        map[22] = -2;
        map[30] = -13;
        map[33] = -2;
        map[38] = -2;
        map[36] = -3;


        for (int i = 0; i < n; i++) {
            System.out.print(i+1 + " Игрок введите ваш хэндл: " );
            players[i] = sc.next();
            pay[i] = 2000000000;
        }

        System.out.println("\n\nТак пусть начнется игра века !!! \nВсем игрокам желаем удачи ;) \n\n");

        boolean winner = true;

        while(winner){

            for (int i = 0; i < n; i++) {

                if(motion[i]){
                    motion[i] = false;
                    continue;
                }else {

                    System.out.println("Кость бросает игрок под хэдолом: " + players[i]);
                    int d = active.dice();

                    System.out.println("\nИиии Та да Та ДАМ: " + d + " ходов впёред");

                    place[i] += d;

                    if (place[i] > 39) {
                        place[i] -= 40;
                        pay[i] += 500000;
                    }


                    if (map[place[i]] == -1) {

                        System.out.print(players[i] + " мы вам предлагаем купить место " + active.getName(place[i]) + " за " + active.getPrice(place[i]) + " тг \nВаш ответ Да/Нет: ");
                        String ans = sc.next();
//buy brand
                        if (ans.equals("Да")) {
                            map[place[i]] = i;
                            pay[i] -= active.getPrice(place[i]);
                            active.setPrice(place[i]);
                            System.out.println("Поздравляем вас с покупкой " + active.getName(place[i]));
                        }

                    } else if (map[place[i]] == -2) {

                        int k = (int) (Math.random() * 3) + 1;

                        if (k == 3) {
                            System.out.println("Ууу Вам не повезло пропустите карту :)");
                        } else {
                            int p = bonus.getCard(k);
                            System.out.println(p);
                            if (k == 1) {
                                if (p > 0) {
                                    System.out.println("Поздравляем Банк выплачивает бонус вам: " + p + " тг");
                                    pay[i] += p;
                                } else {
                                    System.out.println("Ууу Это карта не в вашу пользу оплатите штраф: " + Math.abs(p) + " тг");
                                    pay[i] -= p;
                                }
                            } else if (k == 2) {
                                if (p > 0) {
                                    System.out.println("Ого вам повезло " + p + " шагов вперёд");
                                    place[i] += p;
                                } else {
                                    System.out.println("К сожелению вам не позевло " + p + " шагов назад");
                                    place[i] -= p;
                                }
                            } else {
                                System.out.println("Поле играет с вами злую шутку это карта пуста ;0");
                            }
                        }
                    } else if (map[place[i]] == -4) {
                        pay[i] += 200000;
                        System.out.println("Банк выплачивает вам бонус 200000 тг");
                    } else if (map[place[i]] == -3) {
                        pay[i] += 400000;
                        System.out.println("Банк выплачивает вам боунус 400000 тг");
                    } else if (map[place[i]] == -10) {
                        System.out.println("Поздравляю тебя с оканчанием Круга!");
                    } else if (map[place[i]] == -11) {
                        System.out.println("Не бойся ты только должен посесшять тюрму");
                    } else if (map[place[i]] == -12) {
                        System.out.println("Ого Джекпот ты в казино и за это не нужно платить.");
                    } else if (map[place[i]] == -13) {
                        System.out.println("Да уж тебе не повезло ты поподаешь в тюрмю и пропускаешь ход");
                        motion[i] = true;
                        continue;
                    }else {

                        if (i == map[place[i]]) {
                            System.out.println("Вы пришли в свои город: " + active.getName(place[i]));
                        } else {
                            System.out.println("Вы пришли на " + active.getName(place[i]) + " и это место игрока под хэндлом: " + players[map[place[i]]] + "\nИ вы должны оплатить налог: " + active.getPrice(place[i]) + " тг");
                            int h = active.getPrice(place[i]);
                            pay[i] -= h;
                            pay[map[place[i]]] += h;
                        }
                    }
                    if(pay[i] <= 0){
                        players = active.sort(players,i);
                        n--;
                    }else {
                        System.out.println("Ваш счет состовляет: " + pay[i]);
                    }

                    if(n == 1){
                        System.out.println("И долго жданый момент наша игра закончилась. У нас есть побидитель: " + players[0]);
                        winner = false;
                    }
                }
            }
        }
    }
}