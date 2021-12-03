import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class App {

    private static List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
    private static List<Integer> otherNumbers = Arrays.asList(6, 7, 8, 1, 4, 5, 9, 10, 2, 3);
    private static Stream<Integer> numbersStream = numbers.stream();
    private static Stream<Integer> newNumbersStream = Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
    
    private static List<Integer> list01 = Arrays.asList(1, 2, 3);
    private static List<Integer> list02 = Arrays.asList(4, 5, 6);
    private static List<Integer> list03 = Arrays.asList(7, 8, 9);
    private static List<List<Integer>> listOfNumbers = Arrays.asList(list01, list02, list03);

    private static List<String> countries = Arrays.asList("India", "Australia", "SriLanka", "Russia", "Australia", "SriLanka", "India");
    private static List<String> listOfCountries = Arrays.asList("India", "Australia", "SriLanka", "Russia", "Indonesia");
    public static void main(String[] args) throws Exception {

        List<Integer> cubedNumbers = numbersStream // map()
            .map(x -> x * x * x).collect(Collectors.toList());
        List<Integer> evenNumbers = newNumbersStream // filter()
            .filter(x -> x % 2 == 0).collect(Collectors.toList());
        List<Integer> sortNumbers = numbers.stream() // sorted()
            .sorted().collect(Collectors.toList());
        List<Integer> listOfIntegers = listOfNumbers.stream() // flatMap()
            .flatMap(x -> x.stream())
            .collect(Collectors.toList());
        List<String> distinctCountries = countries.stream() // distinct()
            .distinct().collect(Collectors.toList());

        Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 0) // peek()
            .filter(x -> x % 2 == 0)
            .peek(e -> System.out.println("The even numbers are: " + e))
            .collect(Collectors.toList());
        
        List<?> output = (List<?>) listOfCountries.stream() // collect()
                .filter(x -> x.toString().startsWith("I"))
                .collect(Collectors.toList());

        long outputCount = listOfCountries.stream() // count()
            .filter(x -> x.toString().startsWith("I"))
            .count();

        boolean allElementsStartingWithI = countries.stream() // allMatch()
            .allMatch(x -> x.toString().startsWith("I"));

        boolean areAllElementsStartingWithI = countries.stream() // anMatch()
            .anyMatch(x -> x.toString().startsWith("I"));

        listOfCountries.stream() // forEach()
            .filter(x -> x.toString().startsWith("I"))
            .forEach(System.out::println);

        System.out.println(numbers);
        System.out.println(otherNumbers);
        System.out.println(cubedNumbers);
        System.out.println(evenNumbers);
        System.out.println(sortNumbers);
        System.out.println(listOfIntegers);
        System.out.println(distinctCountries);
        System.out.println(output);
        System.out.println(outputCount);
        System.out.println(allElementsStartingWithI);
        System.out.println(areAllElementsStartingWithI);
    }
}
