import java.util.Iterator;

public class Deque<Item> implements Iterable<Item> {
  private Node first = null;
  private Node last = null;
  private int sz = 0;

  private class Node {
    Item item;
    Node prev;
    Node next;
  }

  public boolean isEmpty() {
    return first == null;
  }

  public int size() {
    return sz;
  }

  public void addFirst(Item item) {
    if (item == null) throw new IllegalArgumentException("pass in a valid item");
    Node oldFirst = first;
    first = new Node();
    first.item = item;
    first.next = oldFirst;
    if (first.next == null) last = first;
    else oldFirst.prev = first;

    sz++;
  }

  public void addLast(Item item) {
    if (item == null) throw new IllegalArgumentException("pass in a valid item");
    Node oldLast = last;
    last = new Node();
    last.item = item;
    last.prev = oldLast;
    if (last.prev == null)  first = last;
    else oldLast.next = last;

    sz++;
  }

  public Item removeFirst() {
    if (isEmpty()) throw new NoSuchElementException("Deque is empty");
    Item item = first.item;
    if (first.next == null) {
      first = null;
      last = null;
    } else {
      first = first.next;
      first.prev.next = null;
      first.prev = null;
    }

    sz--;

    return item;
  }

  public Item removeLast() {
    if (isEmpty()) throw new NoSuchElementException("Deque is empty");
    Item item = last.item;
    if (last.prev == null) {
      last = null;
      first = null;
    } else {
      last = last.prev;
      last.next.prev = null;
      last.next = null;
    }

    sz--;

    return item;
  }

  public Iterator<Item> iterator() {
    return new ListIterator();
  }

  private class ListIterator implements Iterator<Item> {
    private Node current = first;

    public boolean hasNext() {
      return current != null;
    }

    public Item next() {
      if (!hasNext()) throw new NoSuchElementException("Iterator does not have another Item");
      Item item = current.item;
      current = current.next;
      return item;
    }

    public void remove() {
      throw new UnsupportedOperationException("Remove not allowed through iterator");
    }
  }
}
