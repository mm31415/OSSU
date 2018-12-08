/*
  Generics are used when a class should support multiple types of data.

  form:  <TYPE>

  The type is wrapped with arrows
  Note that the TYPE cannot be a primitive type it must be wrapped with a
  wrapper class of the primitive type: Integer, Boolean, Chararcter

  Autoboxing and Unboxing is applied by Java automatically to the primitive
  wrapper types
*/
public class StackListGeneric<Item> {
  private Node first = null;

  private class Node {
    Item item;
    Node next;
  }

  public boolean isEmpty() {
    return first == null;
  }

  public void push(Item item) {
    Node oldFirst = first;
    first = new Node();
    first.item = item;
    first.next = oldFirst;
  }

  public Item pop() {
    Item item = first.item;
    first = first.next;
    return item;
  }
}
