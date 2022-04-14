import static org.junit.jupiter.api.Assertions.*;

class HashMultisetTest {

    @org.junit.jupiter.api.Test
    void add() {
        HashMultiset<String> temp = new HashMultiset<>();
        temp.add("Car");
        assertEquals(true, temp.contains("Car"));
    }

    @org.junit.jupiter.api.Test
    void addAll() {
        HashMultiset<String> temp = new HashMultiset<>();
        temp.addAll("India", "China");
        assertEquals(true, temp.contains("India") && temp.contains("China"));
    }

    @org.junit.jupiter.api.Test
    void remove() {
        HashMultiset<String> temp = new HashMultiset<>();
        temp.add("Car");
        temp.remove("Car");
        assertEquals(false,temp.contains("Car"));
    }

    @org.junit.jupiter.api.Test
    void contains() {
        HashMultiset<String> temp = new HashMultiset<>();
        temp.add("Car");
        assertEquals(true,temp.contains("Car"));
    }

    @org.junit.jupiter.api.Test
    void notContains() {
        HashMultiset<String> temp = new HashMultiset<>();
        temp.add("Car");
        assertEquals(false,temp.contains("Phone"));
    }

    @org.junit.jupiter.api.Test
    void setCount() {
        HashMultiset<String> temp = new HashMultiset<>();
        temp.add("Car");
        temp.setCount("Car",2);
        assertEquals(2, temp.count("Car"));
    }

    @org.junit.jupiter.api.Test
    void isEmpty() {
        HashMultiset<String> temp = new HashMultiset<>();
        assertEquals(true, temp.isEmpty());
    }

    @org.junit.jupiter.api.Test
    void isNotEmpty() {
        HashMultiset<String> temp = new HashMultiset<>();
        temp.add("Car");
        assertEquals(false, temp.isEmpty());
    }

    @org.junit.jupiter.api.Test
    void testToString() {
        HashMultiset<String> temp = new HashMultiset<>();
        temp.add("Car");
        temp.add("Cat",2);
        assertEquals("[Car, Cat x 2]",temp.toString());
    }
}