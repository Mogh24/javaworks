import java.util.*;
import java.util.Scanner;

interface Compute{
    int computer(int n, int m);
}

class Add implements Compute{
    @Override
    public int computer(int n, int m) {
        return n + m;
    }
}

class Multiply implements Compute{
    @Override
    public int computer(int n, int m) {
        return n * m;
    }
}

class Divide implements Compute{
    @Override
    public int computer(int n, int m) {     
        return n / m;
    }
}

class Subtract implements Compute{
    @Override
    public int computer(int n, int m) {
        return n - m;
    }
}

class UseCompute{

    public void useCom(Compute com, int one ,int two){
        System.out.println(com.computer(one, two));
    }
}

class Employee{
    private String name;
    private int number;
    private MyDate birthday = new MyDate();

    void earnings() {
        System.out.println(name);
        System.out.println(number);
        System.out.println(birthday.toString());
    }

    public Employee(String name, int number){
        this.name = name;
        this.number = number;
    }

    static class MyDate{
        public String toString(){
            Date date = new Date();
            return date.toString();
        }
    }
}


public class Main {
    

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        /* System.out.println("1. input two number : ");
        question1(scanner.nextInt(), scanner.nextInt());

        System.out.println("2. input score :");
        question2(scanner.nextInt());

        System.out.println("3. input n : ");
        int N = scanner.nextInt();
        System.out.println("input : ");
        question3(N, scanner); */

        System.out.println("4. ");
        question4();

        String[] words =  {"a", "bb", "acd", "ace"};
        question5("abcde", words);

        scanner.close();
    }

    public static void question1(int one, int two){
        UseCompute compute = new UseCompute();
        compute.useCom(new Add(), one, two);
        compute.useCom(new Subtract(), one, two);
        compute.useCom(new Multiply(), one, two);
        compute.useCom(new Divide(), one, two);
    }

    public static void question2(int score){
        if(score >= 0 && score <= 100){
            System.out.println(score);
        }else{
            System.out.println("input error");
        }
    }

    public static void question3(int N, Scanner scanner){
        int nums[] = new int[N];

        for(int i = 0; i < N; i++){
            nums[i] = scanner.nextInt();
            if(nums[i] < 0){
                System.out.println("必须是正数或者0, 请重新输入");
                nums[i] = scanner.nextInt();
            }
        }

        int sum = 0;
        for(int i : nums){
            sum += i;
        }
        System.out.println((float) (sum / N));
    }

    public static void question4(){
        Employee employee = new Employee("abc", 100);
        employee.earnings();

    }

    public static void question5(String S, String[] words){
        char[] s = S.toCharArray();
        int count = 0;

        for(String str : words){
            char[] s0= str.toCharArray();

            int len = s.length;
            int len0 = s0.length;
            if(len < len0) continue;

            for(int index = 0; index <= len - len0; index++){
                int j = 0;
                if(s[index] == s0[j]){
                    for(int i = index; i < len; i++){
                        if(s[i] == s0[j]){
                            j++;
                            if(j == len0) break;
                        }
                    }

                    if(j == len0){
                        count++;
                        break;
                    }
                }
            }
        }
        System.out.println("5. " + count);
    }

}


