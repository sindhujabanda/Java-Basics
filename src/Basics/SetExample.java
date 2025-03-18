package Basics;

import java.util.*;

public class SetExample {

    static class Employee{
        int age;
        String name;

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Employee(int age, String name) {
            this.age = age;
            this.name = name;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Employee employee)) return false;
            return age == employee.age && Objects.equals(name, employee.name);
        }

        @Override
        public int hashCode() {
            return Objects.hash(age, name);
        }

        @Override
        public String toString() {
            return "Employee{" +
                    "age=" + age +
                    ", name='" + name + '\'' +
                    '}';
        }
    }

    public static void main(String[] args){
        Set<Employee> list = new TreeSet<>((s1, s2) -> Integer.compare(s1.age, s2.age));
        list.add(new Employee(10, "sindhu"));
        list.add(new Employee(10, "sindhu"));
        list.add(new Employee(11, "karthik"));
        list.add(new Employee(21, "Nani"));
        list.add(new Employee(16, "Banni"));

        System.out.println(list);
    }
}
