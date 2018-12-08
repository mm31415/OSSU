/*
  Generics for arrays are a little different

  You can declare the array using the generic
  However to allocate you must cast an array of type Object into
  the Generic Type passed in
*/
public class StackArrayListGeneric<Item> {
  private int N;
  private Item[] s;

  public StackArrayListGeneric() {
    s = (Item[]) new Object[1];
  }

  public boolean isEmpty() {
    return N == 0;
  }

  public void push(Item item) {
    if (N == s.length) resize(s.length * 2);

    s[N++] = item;
  }

  public Item pop() {
    Item item = s[--N];
    s[N] = null;

    if (N > 0 && N == s.length / 4) resize(s.length / 2);

    return item;
  }

  private void resize(int size) {
    Item[] newStack = (Item[]) new Object[size];

    for (int i = 0; i < N; i++) {
      newStack[i] = s[i];
    }

    s = newStack;
  }

  public int getSize() {
    return s.length;
  }
}
