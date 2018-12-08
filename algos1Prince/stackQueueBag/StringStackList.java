class StringStackList {
  private Node first = null;

  // inner private class to create LinkedList
  private class Node {
    String item;
    Node next = null;
  }

  public void push(String item) {
    Node oldFirst = first;
    first = new Node();
    first.item = item;
    first.next = oldFirst;
  }

  public String pop() {
    String item = first.item;
    first = first.next;
    return item;
  }

  public boolean isEmpty() {
    return first == null;
  }
}
