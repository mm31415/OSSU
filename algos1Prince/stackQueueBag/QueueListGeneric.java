public class QueueListGeneric<Item> {
  private Node first = null;
  private Node last = null;

  private class Node {
    Item item;
    Node next;
  }

  public boolean isEmpty() {
    return first == null;
  }

  public void enqueue(Item item) {
    Node oldLast = last;
    last = new Node();
    last.item = item;
    if (first == null) first = last;
    else oldLast.next = last;
  }

  public Item dequeue() {
    Item item = first.item;
    first = first.next;
    if (first == null) last = null;

    return item;
  }
}
