import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamClass {
    public String filterNameList(List<String> list) {
        return IntStream.range(0, list.size())
                .filter(value -> value % 2 == 1)
                .mapToObj(value -> value + ". " + list.get(value))
                .collect(Collectors.joining(", "));
    }

    public List<String> sortNameList(List<String> list) {
        Stream<String> stream = list.stream();
        return stream
                .map(str -> str.toUpperCase())
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.toList());
    }

    public String sortNumbers(String[] arr) {
        return Stream.of(arr)
                .flatMap(str -> Stream.of(str.split(", ")))
                .sorted(Comparator.naturalOrder())
                .collect(Collectors.joining(", "));
    }

    public Stream<Long> generateRandomStream(long a, long c, long m, long seed)
    {
        return Stream.iterate(seed, x -> (a * x + c) % m);
    }

    public static <T> Stream<T> zip(Stream<T> first, Stream<T> second)
    {
        List<T> list = Stream.concat(first, second).collect(Collectors.toList());
        Collections.shuffle(list);
        return list.stream();
    }
}
