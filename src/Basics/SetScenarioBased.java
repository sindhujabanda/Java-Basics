package Basics;

import java.util.*;

public class SetScenarioBased {
    //Duplicate names from a list

    static class FindDuplicateNames{
        public static void main(String[] args){
            List<String> list = new ArrayList<>(Arrays.asList("Alice", "Bob", "John", "Alice","Mark", "John"));
            Set<String> unique = new HashSet<>();
            Set<String> duplicate = new HashSet<>();

            for(String name: list){
                if(!unique.add(name)){
                    duplicate.add(name);
                }
            }

            System.out.println("Duplicate names" + duplicate);
        }
    }

    //Intersection of two sets
    static class FindIntersection{
        public static void main(String[] args){
            Set<Integer> set1 = new HashSet<>(Arrays.asList(1,2,3,4,5));
            Set<Integer> set2 = new HashSet<>(Arrays.asList(4,5,6,7,8,9));

            set1.retainAll(set2);

            System.out.println(set1);
        }
    }

    //Remove Duplicates and maintain insertion order

    static class RemoveDuplicates{
        public static void main(String[] args){
            List<String> list = new ArrayList<>(Arrays.asList("Kari", "Lari", "Bari", "Lari", "Sari", "Sari"));
            Set<String> set = new LinkedHashSet<>(list);
            System.out.println(set);
        }
    }

    //Word Frequency Counter

    static class WordFrequency{
        public static void main(String[] args){
            String text = "Hello World Hello Everyone Java World";
            String[] words = text.split(" ");

            Set<String> set = new HashSet<>(Arrays.asList(words));
            Map<String, Integer> map = new HashMap<>();

            for (String name: set){
                map.put(name, map.getOrDefault(name, 0)+1);
            }

            System.out.println(map);
        }
    }

    static class RemoveEvenNumbers{
        public static void main(String[] args){
            Set<Integer> set = new HashSet<>(Arrays.asList(1,2,3,4,5,6,7,8));
            Iterator<Integer> iterator = set.iterator();

            while (iterator.hasNext()){
                if(iterator.next() % 2 == 0){
                    iterator.remove();
                }
            }

            System.out.println(set);
        }
    }


}
