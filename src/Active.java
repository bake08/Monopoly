import java.util.ArrayList;
import java.util.HashMap;

public class Active {


    HashMap<String, String> color = new HashMap<>();
    static HashMap<String,Integer> price = new HashMap<>();
    static HashMap<Integer,String> ind = new HashMap<>();
    Active(){
        super();
        color.put("Chanel","Violet");
        price.put("Chanel",600000);
        ind.put(1,"Chanel");

        color.put("Boss","Violet");
        price.put("Boss",600000);
        ind.put(3,"Boss");

        color.put("Mercedes","Red");
        price.put("Mercedes",2000000);
        ind.put(5,"Mercedes");

        color.put("Adidas","Yellow");
        price.put("Adidas",60000);
        ind.put(6,"Adidas");

        color.put("Puma","Yellow");
        price.put("Puma",1000000);
        ind.put(8,"Puma");

        color.put("Lacoste","Yellow");
        price.put("Lacoste",1200000);
        ind.put(9,"Lacoste");

        color.put("Vk", "LGreen");
        price.put("Vk",1400000);
        ind.put(11,"Vk");

        color.put("GTA","Brown");
        price.put("GTA",1500000);
        ind.put(12,"GTA");

        color.put("Facebook","LGreen");
        price.put("Facebook",1400000);
        ind.put(13,"Facebook");

        color.put("Twitter","LGreen");
        price.put("Twitter",1600000);
        ind.put(14,"Twitter");

        color.put("Audi","Red");
        price.put("Audi",2000000);
        ind.put(15,"Audi");

        color.put("CocaCola","Blue");
        price.put("CocaCola",1800000);
        ind.put(16,"CocaCola");

        color.put("Pepsi","Blue");
        price.put("Pepsi",1800000);
        ind.put(18,"Pepsi");

        color.put("Fanta","Blue");
        price.put("Fanta",2000000);
        ind.put(19,"Fanta");

        color.put("America","Green");
        price.put("America",2200000);
        ind.put(21,"America");

        color.put("Lufthansa","Green");
        price.put("Lufthansa",2200000);
        ind.put(23,"Lufthansa");

        color.put("British","Green");
        price.put("British",2400000);
        ind.put(24,"British");

        color.put("Ford","Red");
        price.put("Ford",2000000);
        ind.put(25,"Ford");

        color.put("Mac","LBlue");
        price.put("Mac",2600000);
        ind.put(26,"Mac");

        color.put("Burger","LBlue");
        price.put("Burger",2600000);
        ind.put(27,"Burger");

        color.put("Rovio","Brown");
        price.put("Rovio",1500000);
        ind.put(28,"Rovio");

        color.put("Kfc","LBlue");
        price.put("Kfc",2800000);
        ind.put(29,"Kfc");

        color.put("Hollday","Pink");
        price.put("HOllday",3000000);
        ind.put(31,"HOllday");

        color.put("Radisson","Pink");
        price.put("Radisson",3000000);
        ind.put(32,"Radisson");

        color.put("Novotel","Pink");
        price.put("Novotel",3200000);
        ind.put(34,"Novotel");

        color.put("LandRover","Red");
        price.put("LandRover",2000000);
        ind.put(35,"LandRover");

        color.put("Apple","Gray");
        price.put("Apple",3500000);
        ind.put(37,"Apple");

        color.put("Nokia","Gray");
        price.put("Nokia",4000000);
        ind.put(39,"Nokia");

    }


    public int dice(){
        return (int)(Math.random()*12)+1;
    }

    public int getPrice(int i){
        return price.get(ind.get(i));
    }

    public void setPrice(int i){

        int p = getPrice(i);
        String key = getName(i);
        price.put(key,p/15);

    }

    public void setPrice(String key, int price){
        this.price.put(key,price);
    }


    public String getName(int i){
        return ind.get(i);
    }

    public String[] sort(String[] arr, int j){
        ArrayList<String> res = new ArrayList<>();
        String[] r = new String[arr.length - 1];

        for (int i = 0; i < arr.length; i++) {
            if(i != j)
                res.add(arr[i]);
        }

        for (int i = 0; i < res.size(); i++) {
            r[i] = res.get(i);
        }

        return r;
    }
}
