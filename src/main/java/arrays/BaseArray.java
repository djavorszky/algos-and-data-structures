package arrays;

public abstract class BaseArray implements MyArray {

  protected final long[] elements;
  protected int elementCount;

  public BaseArray(int maxSize) {
    this.elements = new long[maxSize];
  }

  @Override
  public String display() {
    if (elementCount == 0) {
      return "[]";
    }

    StringBuilder sb = new StringBuilder();
    sb.append("[");
    for (int i = 0; i < elementCount - 1; i++) {
      sb.append(elements[i]);
      sb.append(", ");
    }
    sb.append(elements[elementCount - 1]);
    sb.append("]");

    return sb.toString();
  }

  @Override
  public boolean exists(long searchKey) {
    return index(searchKey) != -1;
  }

  @Override
  public int size() {
    return elementCount;
  }

  @Override
  public void clear() {
    elementCount = 0;
  }
}
