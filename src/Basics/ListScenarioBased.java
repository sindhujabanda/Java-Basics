package Basics;

import java.util.*;

public class ListScenarioBased {

    //Sorting based on age and then salary and then name
    static class Employee{
        public String name;
        public int age;
        public int salary;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        public int getSalary() {
            return salary;
        }

        public void setSalary(int salary) {
            this.salary = salary;
        }

        public Employee(String name, int age, int salary) {
            this.name = name;
            this.age = age;
            this.salary = salary;
        }

        @Override
        public String toString() {
            return "Employee{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    ", salary=" + salary +
                    '}';
        }

        public static void main(String[] args){
            ArrayList<Employee> list = new ArrayList<>();
            list.add(new Employee("sindhu", 21, 1000));
            list.add(new Employee("karthik", 21, 1000));
            list.add(new Employee("bindhu", 22, 2000));
            list.add(new Employee("anjan", 22, 500));

            list.sort(Comparator.comparingInt((Employee e) -> e.age)
                    .thenComparingInt(e -> e.salary)
                    .thenComparing(e->e.name));

            for (Employee e: list){
                System.out.println(e);
            }
        }
    }

    //Removing duplicates from a list
    static class RemoveDuplicates{
        public static void main(String[] args){
            List<Integer> list = Arrays.asList(1,2,3,4,2);
            List<Integer> uniqueList = new ArrayList<>();

            for(Integer num: list){
                if(!uniqueList.contains(num)){
                    uniqueList.add(num);
                }
            }

            System.out.println(uniqueList);

        }
    }

    //Find kth largest element in a list

    static class FindKthLargest{
        public static void main(String[] args){
            List<Integer> list = new ArrayList<>(Arrays.asList(1,4,5,7));
            int k = 2;
            Collections.sort(list, Collections.reverseOrder());
            System.out.println(list.get(k-1));
        }
    }

    //find the first non-repeating element in a list

    static class FirstNonRepeating{

        public static int nonRepeating(List<Integer> numbers){
            Map<Integer, Integer> frequencyMap = new HashMap<>();
            for(int num: numbers){
                frequencyMap.put(num, frequencyMap.getOrDefault(num,0)+1);
            }

            for(Map.Entry<Integer, Integer> frequency: frequencyMap.entrySet()){
                if(frequency.getValue() == 1){
                    return frequency.getKey();
                }
            }
            return -1;
        }
        public static void main(String[] args){
            List<Integer> list = new ArrayList<>(Arrays.asList(1,2,1,3,4,5,3));
            System.out.println(nonRepeating(list));
        }
    }

    //Reverse a linked list without collections.reverse()

    static class ReverseLinkedList{
        public static void main(String[] args){
            List<Integer> list = new LinkedList<>(Arrays.asList(1,2,3,4,5));
            List<Integer> reverse = new LinkedList<>();
            for(int i = list.size()-1; i >= 0; i--){
                reverse.add(list.get(i));
            }
            System.out.println(reverse);
        }
    }

    //Merge two sorted lists

    static class MergeLists{
        public static List<Integer> merge(List<Integer> list1, List<Integer> list2){
            List<Integer> merged = new ArrayList<>();
            int i =0, j=0;
            while (i < list1.size() && j < list2.size()){
                if(list1.get(i) < list2.get(j)){
                    merged.add(list1.get(i));
                    i++;
                } else{
                    merged.add(list2.get(j));
                    j++;
                }
            }
            while (i < list1.size()){
                merged.add(list1.get(i));
                i++;
            }
            while (j < list2.size()){
                merged.add(list2.get(j));
                j++;
            }
            return merged;
        }

        public static void main(String[] args){
            List<Integer> list1 = Arrays.asList(1,2,4,6);
            List<Integer> list2 = Arrays.asList(3,5,7);
            System.out.println(merge(list1,list2));
        }
    }

    //Move All Zeros to the End of a List

    static class MoveZerosEnd{
        public static void main(String[] args){
            List<Integer> list = new ArrayList<>(Arrays.asList(0, 1, 2, 0, 3, 4, 0, 5));
            int index = 0;
            for(int num: list){
                if(num != 0){
                    list.set(index++, num);
                }
            }
            while (index < list.size()){
                list.set(index++, 0);
            }

            System.out.println(list);
        }
    }

    //Find Intersection of two lists

    static class Section{
        public static void main(String[] args){
            List<Integer> list1 = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));
            List<Integer> list2 = new ArrayList<>(Arrays.asList(4, 5, 6, 7, 8));
            Set<Integer> set = new HashSet<>(list1);
            List<Integer> newList = new ArrayList<>();

            for (int num: list2){
                if(set.contains(num)){
                    newList.add(num);
                    set.remove(num);
                }
            }

            System.out.println(newList);
        }
    }

    //If contains Duplicates

    static class HasDuplicates{
        public static void main(String[] args){
            List<Integer> list = new ArrayList<>(Arrays.asList(1,2,3,4,4));
            Set<Integer> set = new HashSet<>(list);
            System.out.println(list.size() > set.size());
        }
    }

    //Rotate list by K times to right

    static class RotateList{
        public static void main(String[] args){
            List<Integer> list = new ArrayList<>(Arrays.asList(1,2,3,4,5,6,7));
            int n = list.size();
            int k =3;
            k = k % n;

            Collections.reverse(list);
            Collections.reverse(list.subList(0, k));
            Collections.reverse(list.subList(k, n));
            System.out.println(list);
        }
    }

    //Find the length of the consecutive numbers in a list

    static class ConsecutiveNumbers{
        public static void main(String[] args){
            List<Integer> list = new ArrayList<>(Arrays.asList(100, 4, 3, 200, 1, 2));
            int maxLen = 0;
            Set<Integer> set = new HashSet<>(list);
            System.out.println(set);

            for(int num: set){
                if(!set.contains(num - 1)) {
                    int currentNum = num;
                    int currentLen = 1;

                    while (set.contains(currentNum +1)){
                        currentNum++;
                        currentLen++;
                    }
                    maxLen = Math.max(maxLen, currentLen);
                }
            }
            System.out.println(maxLen);

        }
    }

    //Majority element

    static class FindMajority{
        public static void main(String[] args) {
            List<Integer> list = new ArrayList<>(Arrays.asList(3,2,3));
            int count = 0, candidate = 0;
            for (int num: list){
                if(count == 0){
                    candidate = num;
                    count = 1;
                } else if(num == candidate){
                    count++;
                } else {
                    count--;
                }
            }
            System.out.println(candidate);

        }
    }

    //Rearrange positive and negative numbers

    static class RearrangeNumbers{
        public static void main(String[] args){
            List<Integer> list = new ArrayList<>(Arrays.asList(-1,2,3,-4,-5));
            List<Integer> pos = new ArrayList<>();
            List<Integer> neg = new ArrayList<>();
            for(int num : list){
                if(num >= 0){
                    pos.add(num);
                } else {
                    neg.add(num);
                }
            }

            list.clear();
            list.addAll(pos);
            list.addAll(neg);
            System.out.println(list);
        }
    }

    //Find Numbers with given sum

    static class HasPairSum{
        public static void main(String[] args){
            List<Integer> list = new ArrayList<>(Arrays.asList(1,4,6,8,10));
            int target = 10;
            Set<Integer> set = new HashSet<>(list);
            for(int num: list){
                if(set.contains(target - num)){
                    System.out.println(true);
                    set.add(num);
                }
            }
            System.out.println(false);

        }
    }

    //Remove Elements Greater Than a Given Value

    static class RemoveGrater{
        public static void main(String[] args){
            int target = 4;
            List<Integer> list = new ArrayList<>(Arrays.asList(1,2,3,4,5,6));
            list.removeIf(num -> num > target);
            System.out.println(list);
        }
    }
    
    //Sum of Two Lists
    
    static class SumOfLists{

        public static void main(String[] args) {
            List<Integer> list1 = new ArrayList<>(Arrays.asList(1, 2, 3, 4));
            List<Integer> list2 = new ArrayList<>(Arrays.asList(1, 2, 3, 4));

            List<Integer> sumList = new ArrayList<>();
            if(list1.size() == list2.size()){
                for(int i =0; i < list1.size(); i++){
                    sumList.add(list1.get(i) + list2.get(i));
                }
            }
            System.out.println(sumList);
        }
    }

}
