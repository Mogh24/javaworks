import java.util.ArrayList;
import java.util.List;

public class Main{

    public static void main(String[] args){
        System.out.println("<-------第一题------->");
        question1();
        System.out.println("");

        System.out.println("<-------第二题------->");
        question2();
        System.out.println("");

        System.out.println("<-------第三题------->");
        String sum = getSum("88888888888888888", "25461213124533465");
        System.out.println(sum);

        sum = getSum("13829579081298345918257", "438823897418920918472193");
        System.out.println(sum);
        System.out.println("");

        System.out.println("<-------第四题------->");
        int[] origin = {0, 0};
        int[] target = {3, 3};
        System.out.println(question4(origin, target));
        System.out.println("");

        System.out.println("<-------第五题------->");
        String[] strs = {"f1ower","f1ow","f1ight"};
        System.out.println(question5(strs));
    }

    public static void question1(){
        MonKey monKey = new MonKey(null);
        People people = new People(null);
        monKey.speak();
        people.speak();
        people.think();
    }

    public static void question2(){
        new Car(3);
        new Truck(1, 3000);
        new Car(6);
        new Truck(1, 7000);
    }

    public static String getSum(String a, String b){
        List<Integer> la = new ArrayList<>();
        List<Integer> lb = new ArrayList<>();
        String c = "";

        for(int i = a.length() - 1; i >= 0; i--){
            la.add(a.charAt(i) - '0');
        }
        for(int j = b.length() - 1; j >= 0; j--){
            lb.add(b.charAt(j) - '0');
        }

        int count = 0;
        int next = 0;
        while(true){
            int i = 0;
            int j = 0;
            if(count < la.size()) i = la.get(count);
            if(count < lb.size()) j = lb.get(count);

            if(count >= la.size() && count >= lb.size() && next == 0){ 
                break;
            }else if(count >= la.size() && count >= lb.size() && next != 0){
                c = next + c;
                break;
            }

        /* 
          13829579081298345918257
         438823897418920918472193

         452653476500219264390450
         452653476500219264390450 
        */

            int sum = i + j + next;

            if(sum >= 10){
                next = 1;
                sum = sum - 10;
            }else{
                next = 0;
            }
            
            c = sum + c;
            count++;
        }
        return c;
    }

    public static int question4(int[] p, int[] target){
        return getRoad(p, target, 0);
    }

    public static int getRoad(int[] p, int[] target, int count){
        int x = p[0];
        int y = p[1];

        if (x == target[0] && y == target[1]){
            return count + 1;
        }

        if (x < target[0]){
            p[0] = x + 1;
            count = getRoad(p, target, count);
        }

        if (y < target[1]){
            if(p[0] != x) p[0] = x;
            p[1] = y + 1;
            count = getRoad(p, target, count);
        }
        return count;
    }

    public static String question5(String[] strs){
        String s = "";
        int count = 0;
        while(true){
            try{
                boolean flag = false;
                char c = strs[0].charAt(count);
                for (String str : strs){
                    if(c != str.charAt(count)) {
                        flag = false;
                    }else{
                        flag = true;
                    }
                }

                if(flag){
                    s = s + c;
                }else{
                    break;
                }

                count++;
            }catch(IndexOutOfBoundsException e){
                return s;
            }
            
        }
        return s;
    }
}

class MonKey{
    public MonKey(String s){

    }
    
    public void speak(){
        System.out.println("咿咿呀呀 ......");
    }
}

class People extends MonKey{
    public People(String s){
        super(s);
    }

    @Override
    public void speak(){
        System.out.println("小样儿，不错嘛！会说话了！");
    }

    public void think(){
        System.out.println("别说话！认真思考！");
    }
}

class Vehicle{

    int wheels;
    float weight;
}

class Car extends Vehicle{

    int max_loader = 5;
    int loader;

    public Car(int loader){
        this.wheels = 4;
        this.weight = 1150;
        System.out.println("车轮的个数是：" + this.wheels + "  车重：" + this.weight);
        if(loader < max_loader){
            System.out.println("这是一辆小车,能载5人,实载" + loader + "人");
        }else{
            System.out.println("这是一辆小车,能载5人,实载" + loader + "人,你超员了！！！");
        }
    }
}

class Truck extends Vehicle{

    int max_loader = 3;
    int max_payload = 5000;
    int loader;
    int payload;

    public Truck(int loader, float payload){
        this.wheels = 6;
        this.weight = 15000;

        System.out.println("车轮的个数是：" + this.wheels + "  车重：" + this.weight);
        if(loader < max_loader){
            System.out.println("这是一辆卡车,能载3人,实载" + loader + "人");
        }else{
            System.out.println("这是一辆卡车,能载3人,实载" + loader + "人,你超员了！！！");
        }
        if(payload < max_payload){
            System.out.println("这是一辆卡车,核载5000kg,你已装载" + payload + "kg");
        }else{
            System.out.println("这是一辆卡车,核载5000kg,你已装载" + payload + "kg,你超载了！！！");
        }
    }
}