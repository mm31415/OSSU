/*
  Array List is the name java uses for a resizable array
*/
class StringStackArrayList {
  private String[] s;
  private int N;

  public StringStackArrayList() {
    s = new String[1];
  }

  public void push(String item) {
    // resizes the array by 2 when reaching length, amortized O(1) for push
    if (N == s.length) resize(s.length * 2);

    s[N++] = item;
  }

  public String pop() {
    String item = s[--N];
    // clears memory reference at N, garbage collector would not know
    // that value is no longer needed
    s[N] == null;
    // keeps the array from become extremely large but mostly unused
    if (N > 0 && N == s.length / 4) resize(s.length / 2);

    return item;
  }

  public boolean isEmpty() {
    return N == 0;
  }

  private void resize(int size) {
    String[] newStack = new String[size];

    for (int i = 0; i < N; i++) {
      newStack[i] = s[i];
    }

    s = newStack;
  }
}
