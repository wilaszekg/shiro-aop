package pl.agh.toik.samples.cache;

public class Main {
    public static void main(String[] args) {
        Computer computer = new Computer();
        System.out.println(computer.compute());
        System.out.println(computer.compute());
        System.out.println(computer.compute());

        System.out.println("-----------");
        System.out.println(computer.getResult());
        System.out.println(computer.getResult());
        computer.setResult("new result");
        System.out.println(computer.getResult());
        
        System.out.println("-----------");
        System.out.println(computer.computeParam1(5));
        System.out.println(computer.computeParam1(5));
        System.out.println(computer.computeParam1(10));
        System.out.println(computer.computeParam1(5));

        System.out.println(computer.computeParam2(5));
        System.out.println(computer.computeParam2(10));
        System.out.println(computer.computeParam2(10));
        System.out.println(computer.computeParam2(10));
        
    }
}
