import java.util.List;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        StreamClass sc = new StreamClass();
        List<String> listOfNames = List.of("Arnold", "Borys", "Vasyl", "Herasym", "Drahomyr", "Ernest");
        String[] strings = {"1, 2, 0", "4, 5"};
        Stream<Long> longs = sc.generateRandomStream(25214903917L, 11 , (long) Math.pow(2, 48), 10);
        //System.out.println(sc.filterNameList(listOfNames));
        //System.out.println(sc.sortNameList(listOfNames));
        //System.out.println(sc.sortNumbers(strings));
        //longs.limit(10).forEach(System.out::println);
        sc.zip(listOfNames.stream(), Stream.of(strings)).forEach(System.out::println);
    }
}
