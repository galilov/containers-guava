package ru.otus.containers;

import com.google.common.collect.*;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        example8();

    }

    private static void example8() {
        class DecoratedList<E> extends ForwardingList<E> {
            private List<E> list = new ArrayList<>();

            @Override
            protected List<E> delegate() {
                return list;
            }

            @Override
            public void add(int index, E elem) {
                System.out.println("Added element: " + elem);
                super.add(index, elem);
            }

            @Override
            public boolean add(E elem) {
                return standardAdd(elem);
            }

            @Override
            public boolean addAll(Collection<? extends E> collection) {
                return standardAddAll(collection);
            }
        }

        List<String> lst = new DecoratedList<>();
        lst.add("S1");
        lst.add("S2");
        lst.add("S3");
        lst.addAll(Arrays.asList("S4", "S5", "S6"));

        System.out.println(lst);
    }

    private static void example7() {
        List<Integer> lst = Arrays.asList(0, 1, 2, 3, 4, 3, 5, 6, 7, 0);
        System.out.println(Iterables.frequency(lst, 3));
        System.out.println(Iterables.frequency(lst, -7));
    }

    private static void example6() {
        List<Integer> lst1 = Arrays.asList(1, 2, 3, 4, 5, 6, 7);
        List<Integer> lst2 = Arrays.asList(10, 20, 30, 40, 50, 60, 70);
        Iterable<Integer> result = Iterables.concat(lst1, lst2);
        result.forEach(i -> System.out.println(i));
        ArrayList<Integer> lst = Lists.newArrayList(result);
        System.out.println(lst);
    }

    private static void example5() {
        Table<String, String, Double> t = HashBasedTable.create();
        t.put("Sasha", "Salary", 3000.0);
        t.put("Sasha", "Bonus", 100.0);
        t.put("Petya", "Salary", 3500.0);
        t.put("Petya", "Bonus", 50.0);
        t.put("Eleonora", "Salary", 4500.0);
        t.put("Eleonora", "Bonus", 500.0);

        System.out.println(t);
        System.out.println(t.column("Salary"));
        System.out.println(t.column("Bonus"));
        System.out.println(t.row("Sasha"));
    }

    private static void method4() {
        BiMap<String, Integer> userId = HashBiMap.create();
        userId.put("User1", 100);
        userId.put("User2", 200);
        userId.put("User3", 300);
        //userId.put("User4", 300);
        System.out.println(userId);
        BiMap<Integer, String> idUser = userId.inverse();
        System.out.println(idUser);
    }

    private static void eample3() {
        ListMultimap<String, Integer> treeListMultimap =
                MultimapBuilder
                        .treeKeys()
                        .arrayListValues()
                        .build();
        treeListMultimap.putAll("K1", Arrays.asList(1, 2, 3, 4, 5, 6));
        System.out.println(treeListMultimap);
        treeListMultimap.put("K1", 100);
        System.out.println(treeListMultimap);
        treeListMultimap.put("K2", 555);
        treeListMultimap.put("K2", 777);
        System.out.println(treeListMultimap);
    }

    private static void example2() {
        HashMultiset<String> hms = HashMultiset.create();
        hms.add("Hi");
        hms.add("Hi");
        hms.add("Hello");
        System.out.println(hms.count("Hi"));
        System.out.println(hms.count("Hello"));
        System.out.println(hms.count("Good morning"));
        System.out.println(hms.contains("Hi"));
        System.out.println(hms.contains("Hello"));
        System.out.println(hms.contains("Good morning"));
    }

    private static void example() {
        ArrayList<Integer> src = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            src.add(100 * i);
        }

        List<Integer> immutable = ImmutableList.copyOf(src);
        System.out.println(immutable);

        src.add(777);
        System.out.println(src);
        System.out.println(immutable);
        List<Integer> unmodifiable = Collections.unmodifiableList(src);
        System.out.println(unmodifiable);
        src.add(999);
        System.out.println(unmodifiable);
        //unmodifiable.add(0);
    }

}
