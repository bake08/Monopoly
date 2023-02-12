import java.util.ArrayList;

public class Bonus {
    ArrayList<Integer> money = new ArrayList<>();
    ArrayList<Integer> text = new ArrayList<>();

    Bonus(){
        money.add(+100000);
        money.add(-96000);
        money.add(-75000);
        money.add(+6500);
        money.add(-45000);
        money.add(+95000);
        money.add(-73000);
        money.add(+4000);
        money.add(-3800);
        money.add(+9600);
        money.add(-15000);
        money.add(+9800);
        money.add(-7900);
        money.add(-110);
        money.add(+800);
        money.add(-160000);
        money.add(+20000);

        text.add(-3);
        text.add(+1);
        text.add(-6);
        text.add(+9);
        text.add(-12);
        text.add(-7);
        text.add(+2);
        text.add(+12);
        text.add(+6);
        text.add(+9);
        text.add(-4);
        text.add(+6);
        text.add(-7);
        text.add(+2);
        text.add(+8);
        text.add(-1);
        text.add(+5);

    }


    public Integer getCard(int k){
        int n = (int)(Math.random()*16)+1;

        if(k == 1){
            return money.get(n);
        }else if (k == 2){
            return text.get(n);
        }
        return 0;
    }


}
