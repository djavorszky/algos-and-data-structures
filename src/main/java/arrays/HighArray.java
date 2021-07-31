package arrays;

public class HighArray extends BaseArray {

  public HighArray(int maxSize) {
    super(maxSize);
  }

  @Override
  public void insert(long e) {
    elements[elementCount] = e;
    elementCount++;
  }

  @Override
  public boolean delete(long value) {
    boolean deleted = false;

    for (int i = 0; i <= elementCount; i++) {
      if (elements[i] == value) {
        elements[i] = elements[i + 1];
        deleted = true;
        elementCount--;
      }
    }

    return deleted;
  }

  @Override
  public int index(long key) {
    for (int i = 0; i < elementCount; i++) {
      if (elements[i] == key) {
        return i;
      }
    }

    return -1;
  }
}
