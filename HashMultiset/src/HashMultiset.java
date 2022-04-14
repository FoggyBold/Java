import java.util.*;
import java.util.function.Consumer;
import java.util.stream.Collectors;

class Node<E>
{
    E info;
    Integer count;
    Node(E info, Integer count)
    {
        this.info = info;
        this.count = count;
    }

    public void setCount(int count)
    {
        this.count = count;
    }

    public void inc()
    {
        count++;
    }

    public void dec()
    {
        count--;
    }

    public void dec(int value)
    {
        count -= value;
    }
}

class HashMultiset<E>
{
    private HashMap<E, Node<E>> hashMap;

    private final String ERROR_MSG = "Count cannot be negative: ";

    public HashMultiset()
    {
        hashMap = new HashMap<>();
    }

    public int add(E element, int count)
    {
        if (count < 0) {
            throw new IllegalArgumentException(ERROR_MSG + count);
        }

        Node<E> value = hashMap.get(element);

        if (value != null)
        {
            value.inc();
        }
        else
        {
            hashMap.put(element, new Node<>(element, count));
        }

        return value != null ? value.count : 1;
    }

    public boolean add(E element) {
        return add(element, 1) >= 0;
    }

    boolean addAll(Collection<? extends E> c)
    {
        for (E element: c) {
            add(element, 1);
        }

        return true;
    }

    public void addAll(E... arr)
    {
        for (E element: arr) {
            add(element, 1);
        }
    }

    public boolean remove(Object element) {
        return remove(element, 1) > 0;
    }

    public int remove(Object element, int count)
    {
        if (count < 0) {
            throw new IllegalArgumentException(ERROR_MSG + count);
        }

        boolean flag = false;

        Node<E> value = hashMap.get(element);
        if (value == null) {
            return 0;
        }

        if (value.count > count) {
            flag = true;
            value.dec(count);
        }
        else {
            value = null;
            hashMap.remove(element);
        }

        return flag ? value.count : 0;
    }

    public boolean contains(Object element) {
        return hashMap.containsKey(element);
    }

    public int setCount(E element, int count)
    {
        if (count < 0) {
            throw new IllegalArgumentException(ERROR_MSG + count);
        }

        if (count == 0) {
            remove(element);
        }

        Node<E> value = hashMap.get(element);

        if (value != null) {
            value.setCount(count);
        }

        return value != null ? value.count : 0;
    }

    public int count(Object element)
    {
        Node<E> value = hashMap.get(element);

        return value == null ? 0 : value.count;
    }

    public boolean isEmpty() {
        return hashMap.size() == 0;
    }

    @Override
    public String toString()
    {
        StringBuilder sb = new StringBuilder("[");
        int i = 0;
        int length = hashMap.size();
        for (Node<E> value : hashMap.values())
        {
            i++;
            sb.append(value.info);

            if (value.count > 1) {
                sb.append(" x ").append(value.count);
            }

            if(i != length)
            {
                sb.append(", ");
            }
        }

        return sb.append("]").toString();
    }
}

