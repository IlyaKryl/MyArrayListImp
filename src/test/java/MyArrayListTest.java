import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Comparator;

public class MyArrayListTest {

    @Test
    public void methodsAddAndAddWithIndexShouldWork() {
        MyArrayList<Integer> myArrayList = new MyArrayList<>();
        myArrayList.add(321231);
        myArrayList.add(12345);
        myArrayList.add(67890);
        myArrayList.add(77777, 0);
        myArrayList.add(33333, 2);
        myArrayList.add(99999, 5);

        Assertions.assertEquals(77777, myArrayList.get(0));
        Assertions.assertEquals(321231, myArrayList.get(1));
        Assertions.assertEquals(33333, myArrayList.get(2));
        Assertions.assertEquals(12345, myArrayList.get(3));
        Assertions.assertEquals(67890, myArrayList.get(4));
        Assertions.assertEquals(99999, myArrayList.get(5));

        Assertions.assertEquals(6, myArrayList.size());
    }

    @Test
    public void methodDeleteShouldWork() {
        MyArrayList<String> myArrayList = new MyArrayList<>();

        myArrayList.add("Masha");
        myArrayList.add("Dasha");
        myArrayList.add("Natasha");

        myArrayList.delete("Natasha");
        myArrayList.delete("Masha");

        Assertions.assertEquals("Dasha", myArrayList.get(0));

        Assertions.assertEquals(1, myArrayList.size());
    }

    @Test
    public void methodSortShouldWorkForAnyCustomClass1() {
        MyArrayList<Double> numbers = new MyArrayList<>();
        numbers.add(5.53);
        numbers.add(5.17);
        numbers.add(5.97);
        numbers.add(7.81);
        numbers.add(7.01);

        numbers.sort(Comparator.naturalOrder());

        Assertions.assertEquals(5.17, numbers.get(0));
        Assertions.assertEquals(5.53, numbers.get(1));
        Assertions.assertEquals(7.81, numbers.get(4));
    }

    @Test
    public void methodSortShouldWorkForAnyCustomClass2() {
        MyArrayList<String> fruits = new MyArrayList<>();
        fruits.add("Банан");
        fruits.add("Груша");
        fruits.add("Яблоко");
        fruits.add("Апельсин");
        fruits.add("Абрикос");

        fruits.sort(Comparator.naturalOrder());

        Assertions.assertEquals("Абрикос", fruits.get(0));
        Assertions.assertEquals("Апельсин", fruits.get(1));
        Assertions.assertEquals("Яблоко", fruits.get(4));
    }

    @Test
    public void methodSortShouldWorkForAnyCustomClass3() {
        class Person {
            String name;
            int age;
            int height;

            public Person(String name, int age, int height) {
                this.name = name;
                this.age = age;
                this.height = height;
            }

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

            public int getHeight() {
                return height;
            }

            public void setHeight(int height) {
                this.height = height;
            }
        }

        MyArrayList<Person> people = new MyArrayList<>();
        Person petya = new Person("Petya", 18, 180);
        Person vasya = new Person("Vasya", 25, 195);
        Person kolya = new Person("Kolya", 16, 172);
        Person alex = new Person("Alexey", 51, 179);

        people.add(petya);
        people.add(vasya);
        people.add(kolya);
        people.add(alex);

        people.sort(Comparator.comparing(o -> o.name));

        Assertions.assertEquals("Alexey", people.get(0).getName());
        Assertions.assertEquals("Vasya", people.get(3).getName());

        people.sort(Comparator.comparing(o -> o.age));

        Assertions.assertEquals(16, people.get(0).getAge());
        Assertions.assertEquals(51, people.get(3).getAge());

        people.sort(Comparator.comparing(o -> o.height));

        Assertions.assertEquals(172, people.get(0).getHeight());
        Assertions.assertEquals(195, people.get(3).getHeight());
    }
}
