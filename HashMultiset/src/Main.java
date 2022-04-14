import java.util.Arrays;

class Main
{
    // Multiset implementation in Java
    public static void main(String[] args)
    {
        HashMultiset<String> multiset = new HashMultiset();

        multiset.add("USA");
        multiset.add("Japan", 2);
        multiset.addAll("India", "China");
        multiset.addAll(Arrays.asList("USA", "India", "China", "Japan"));

        System.out.println(multiset);

        multiset.remove("China");
        multiset.remove("Japan", 2);

        System.out.println(multiset);

        multiset.setCount("USA", 4);
        multiset.setCount("Japan", 5);
        multiset.setCount("Mexico", 3);
        multiset.setCount("China", 0);

        System.out.println(multiset);
    }
}