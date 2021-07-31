package arrays;

public class OrderedArray extends BaseArray {
  public OrderedArray(int maxSize) {
    super(maxSize);
  }

  @Override
  public int index(long key) {
    int lowerBound = 0;
    int upperBound = elementCount - 1;
    int currentIndex;

    while (true) {
      currentIndex = (lowerBound + upperBound) / 2;

      if (elements[currentIndex] == key) {
        return currentIndex;
      }

      if (lowerBound > upperBound) {
        return -1;
      }

      if (elements[currentIndex] < key) {
        lowerBound = currentIndex + 1;
      } else {
        upperBound = currentIndex - 1;
      }
    }
  }

  @Override
  public void insert(long value) {
    int insertIndex = -1;
    for (int i = 0; i < elementCount; i++) {
      if (elements[i] > value) {
        insertIndex = i;
        break;
      }
    }

    if (insertIndex == -1) {
      elements[elementCount] = value;
      elementCount++;
      return;
    }

    for (int i = insertIndex; i < elementCount; i++) {
      elements[i + 1] = elements[i];
    }

    elements[insertIndex] = value;
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
}
