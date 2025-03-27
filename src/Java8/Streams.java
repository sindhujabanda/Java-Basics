package Java8;

import java.security.Key;
import java.util.*;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.*;

public class Streams {

    //Reduce

    public static class UseReduce{
        public static void main(String[] args){
            int[] numbers = {1,2,3,5,6};
            int sum = Arrays.stream(numbers).reduce(0, Integer::sum);
            System.out.println(sum);
        }
    }

    //Concatenate strings using reduce

    static class ConcatenateStrings{
        public static void main(String[] args){
            String[] text = {"Hello", " ", "World!"};
            String newText = Arrays.stream(text).reduce(" ", (a,b)->a+b);
            System.out.println(newText);
        }
    }

    //Parallel Streams

    public static class ParallelStream{
        public static void main(String[] args){
            List<Integer> numbers = List.of(1,2,3,4,5);
            List<Integer> squareList = numbers.parallelStream().map(n-> n*n).toList();
            System.out.println(squareList);
        }
    }

    public static class Emp{
        String name;
        int salary;
        String gender;

        int age;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getSalary() {
            return salary;
        }

        public void setSalary(int salary) {
            this.salary = salary;
        }

        public String getGender() {
            return gender;
        }

        public void setGender(String gender) {
            this.gender = gender;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        public Emp(String name, int salary, String gender, int age) {
            this.name = name;
            this.salary = salary;
            this.gender = gender;
            this.age = age;
        }

        public Emp(String name, int salary, String gender) {
            this.name = name;
            this.salary = salary;
            this.gender = gender;
        }

        public Emp(String name, int salary) {
            this.name = name;
            this.salary = salary;
        }

        @Override
        public String toString() {
            return "Emp{" +
                    "name='" + name + '\'' +
                    ", salary=" + salary +
                    ", gender='" + gender + '\'' +
                    ", age=" + age +
                    '}';
        }

        public static void main(String[] args){
            List<Emp> empList = Arrays.asList(
                    new Emp("sindhu", 1200, "F"),
                    new Emp("karthik", 2246, "M"),
                    new Emp("John", 30566, "M"),
                    new Emp("Genjalo", 1467, "M"),
                    new Emp("Valeria", 32657, "F")
            );

            long females = empList.stream().filter(n -> Objects.equals(n.gender, "F")).count();
            long males = empList.stream().filter(n -> Objects.equals(n.gender, "M")).count();

            System.out.println("Female Count :" + females);
            System.out.println("Male Count :" + males);

            Map<String, Long> genderCount = empList.stream().collect(groupingBy(Emp::getGender, counting()));
            System.out.println(genderCount);

            Map<String, Double> averageSalary = empList.stream().collect(groupingBy(Emp::getGender, averagingDouble(Emp::getSalary)));
            System.out.println(averageSalary);
        }
    }

    public static class SumOfEvenAndOdd{
        public static void main(String[] args){
            List<Integer> numbers = List.of(1,2,4,5,6,6,7);
            Map<Boolean, Long> count = numbers.stream().collect(partitioningBy(n -> n% 2 ==0, summingLong(n->n)));
            System.out.println("even:" + count.get(true));
            System.out.println("odd:"+ count.get(false));
        }
    }

    public static class FindDuplicates{
        public static void main(String[] args){
            List<Integer> numbers = new ArrayList<>(Arrays.asList(1,2,3,4,4,5,2));
            List<Integer> duplicates = numbers.stream()
                            .collect(groupingBy(n->n, counting()))
                            .entrySet().stream()
                            .filter(entry -> entry.getValue()>1)
                            .map(Map.Entry::getKey)
                            .collect(toList());
            System.out.println(duplicates);
        }
    }

    public static class RemoveCharacterInAllOccurrences{
        public static void main(String[] args){
            String text = "sindhuja banda";
            char ch = 'a';
            String newText = text.chars()
                    .filter(c -> c != ch)
                    .mapToObj(c -> String.valueOf((char) c ))
                    .collect(Collectors.joining());

            System.out.println(newText);
        }
    }

    public static class FindSpecialCharacters{
        public static void main(String[] args){
            String text = "Hello, #World!";
            String specialChars = text.chars()
                    .filter(c -> !Character.isLetterOrDigit(c))
                    .mapToObj(c -> String.valueOf((char) c))
                    .collect(Collectors.joining(" "));

            System.out.println(specialChars);
        }
    }

    public static class FindNumbersStartingWith1{
        public static void main(String[] args){
            List<Integer> numbers = Arrays.asList(1,22,13,45,17);

            List<Integer> stream = numbers.stream()
                    .filter(n -> Integer.toString(n).startsWith("1"))
                    .toList();
            System.out.println(stream);
        }
    }

    public static class EmployeeWithHighestSalary {
        public static void main(String[] args) {
            List<Emp> empList = Arrays.asList(
                    new Emp("sindhu", 73782, "F"),
                    new Emp("karthik", 637287, "M"),
                    new Emp("Bhargav", 75383, "M")
            );

            Optional<Emp> empOptional = empList.stream()
                    .max(Comparator.comparingDouble(Emp::getSalary));
            empOptional.ifPresent(System.out::println);
        }
    }

    public static class ConcatenateIntoAString {
        public static void main(String[] args) {
            List<String> names = Arrays.asList("sindhu", "bindhu", "chandhu");
            String name = names.stream()
                               .collect(Collectors.joining(","));
            System.out.println(name);
        }
    }

    public static class FindFirstNonRepeating{
        public static void main(String[] args){
            String s= "swiss";
            Map<Character, Integer> charCountMap = new HashMap<>();
            //converting string into stream of characters
            s.chars().mapToObj(c-> (char) c)
                    .forEach(c -> charCountMap.put(c, charCountMap.getOrDefault(c, 0)+1));

            Optional<Character> firstChar= charCountMap.entrySet()
                    .stream().filter(entry -> entry.getValue() == 1)
                    .map(Map.Entry::getKey)
                    .findFirst();

            firstChar.ifPresent(System.out::println);
        }
    }

    public static class FindFrequencyOfString{
        public static void main(String[] args){
            String s = "swiss";
            Map<Character, Integer> frquencyMap = new HashMap<>();
            s.chars()
                    .mapToObj(c -> (char) c)
                    .forEach(c-> frquencyMap.put(c, frquencyMap.getOrDefault(c, 0)+1));
            System.out.println(frquencyMap);
        }
    }

    public static class GroupingStringsByLength{
        public static void main(String[] args){
            List<String> names = Arrays.asList("sindhu", "gunnu", "bannu", "kani", "soni", "pillows");
            Map<Integer, List<String>> groupedByLength = names.stream()
                    .collect(Collectors.groupingBy(String::length));
            System.out.println(groupedByLength);
        }
    }

    public static class NumberGraterThan10{
        public static void main(String[] args){
            List<Integer> numbers = Arrays.asList(1,22,9,23,14);
            double average = numbers.stream()
                    .filter(n-> n > 10)
                    .mapToInt(n -> n)
                    .average()
                    .orElse(0);

            System.out.println(average);
        }
    }

    public static class StringWithLength{
        public static void main(String[] args){
            List<String> names = Arrays.asList("sindhu", "bindhu", "indhu");
            Map<String, Integer> map = names.stream()
                    .collect(Collectors.toMap(n->n, n->n.length()));
            System.out.println(map);
        }
    }

    //Flatten a lists of integers into a single list of integers
    public static class FlattenList{
        public static void main(String[] args){
            List<List<Integer>> listOfLists = Arrays.asList(
                    Arrays.asList(1,2,3,4),
                    Arrays.asList(5,6,7),
                    Arrays.asList(8,9)
            );

            List<Integer> finalList = listOfLists.stream()
                    .flatMap(List::stream)
                    .collect(toList());

            System.out.println(finalList);
        }
    }

    //Filtering transactions based on their type

    public static class FilteringTransactions{
        static class Transaction{
            String type;
            double amount;

            public String getType() {
                return type;
            }

            public void setType(String type) {
                this.type = type;
            }

            public double getAmount() {
                return amount;
            }

            public void setAmount(double amount) {
                this.amount = amount;
            }

            public Transaction(String type, double amount) {
                this.type = type;
                this.amount = amount;
            }

            @Override
            public String toString() {
                return "Transaction{" +
                        "type='" + type + '\'' +
                        ", amount=" + amount +
                        '}';
            }
        }

        public static void main(String[] args){
            List<Transaction> transactions = Arrays.asList(
                    new Transaction("deposit", 100.00),
                    new Transaction("transfer", 200.00),
                    new Transaction("deposit", 250.00),
                    new Transaction("withdrawal", 500.00)
            );

            String targetType = "deposit";

            Set<Transaction> set = transactions.stream()
                    .filter(n -> targetType.equals(n.type))
                    .collect(Collectors.toSet());

            set.forEach(System.out::println);
        }
    }

    //Find Firstname of the oldest person

    public static class FindFirstNameOfOldestPerson{
        public static void main(String[] args){
            List<Emp> persons = Arrays.asList(
                    new Emp("sindhu", 200, "F", 22),
                    new Emp("karthik", 300, "M", 26),
                    new Emp("anji", 400, "M", 21)
            );

            Optional<Emp> emp =
                    persons.stream().max(Comparator.comparingInt(Emp::getAge));

            String name = emp.map(Emp::getName).orElse("No Name");
            System.out.println(name);
        }
    }

    //Skip first 5 and print the rest

    public static class SkipFirst5{
        public static void main(String[] args){
            List<Integer> numbers = Arrays.asList(1,2,3,3,4,5,6,7,8,9);
            List<Integer> skip5 = numbers.stream().skip(5).collect(toList());
            System.out.println(skip5);
        }
    }

    //Unique words from a list of sentences

    public static class FindUniqueWords{
        public static void main(String[] args){
            List<String> sentences = Arrays.asList(
                    "This world is cruel",
                    "This world is unsafe",
                    "Full fake people"
            );

            Set<String> uniqueWords = sentences.stream()
                    .map(s -> s.split("\\s+"))
                    .flatMap(Arrays::stream)
                    .map(String::toLowerCase)
                    .collect(toSet());

            uniqueWords.forEach(System.out::println);
        }
    }

    //

    public static class StreamExample{
        public static void main(String[] args){
            List<Integer> numbers = Arrays.asList(1,2,3,4,5,6);
            numbers.stream()
                    .filter(n -> n % 2 == 0)
                    .map(n -> n * 3)
                    .sorted(Collections.reverseOrder())
                    .forEach(System.out::println);
        }
    }

    public static class StreamExample2{
        static class Employee {
            String department;
            int salary;

            public Employee(String department, int salary) {
                this.department = department;
                this.salary = salary;
            }

            public String getDepartment() { return department; }
            public int getSalary() { return salary; }

            @Override
            public String toString() {
                return "Employee{" +
                        "department='" + department + '\'' +
                        ", salary=" + salary +
                        '}';
            }
        }

        public static void main(String[] args){
            List<Employee> employees = Arrays.asList(
                    new Employee("HR", 5000),
                    new Employee("IT", 8000),
                    new Employee("HR", 3000),
                    new Employee("Finance", 7000),
                    new Employee("IT", 4000)
            );

            Map<String, List<Employee>> emp = employees.stream()
                    .collect(groupingBy(n -> n.department));
            System.out.println(emp);

            Map<String, Integer> totalSalaryDepartmentVise = employees.stream()
                    .collect(groupingBy(Employee::getDepartment, Collectors.summingInt(Employee::getSalary)));

            System.out.println(totalSalaryDepartmentVise);
        }


    }

    //Second-Highest Salary

    public static class SecondHighestSalary{
        public static void main(String[] args){
            List<Emp> employeeList = Arrays.asList(
                    new Emp("abc", 1000),
                    new Emp("bca", 2000),
                    new Emp("cba", 4000),
                    new Emp("bsgs", 6000)
            );

            Optional<Emp> emp = employeeList.stream()
                    .sorted(Comparator.comparingDouble(Emp :: getSalary).reversed())
                    .skip(2)
                    .findFirst();

            System.out.println(emp);

        }
    }

    //Sort by last name

    public static class SortByLastName{
        public static void main(String[] args){
            List<String> names = Arrays.asList("Sachin Tendulkar", "Dhoni Singh", "Virat Kohli");
            names.stream()
                    .sorted(Comparator.comparing(p -> p.substring(p.lastIndexOf(" ") + 1)))
                    .forEach(System.out::println);
        }
    }


}
