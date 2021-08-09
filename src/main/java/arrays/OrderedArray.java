package arrays;

public class OrderedArray extends BaseArray {
  public OrderedArray(int maxSize) {
    super(maxSize);
  }

  @Override
  public int index(long key) {
    return getElementLocation(key, true);
  }

  @Override
  public void insert(long value) {
    int insertIndex = getElementLocation(value, false);

    if (insertIndex == -1) {
      elements[elementCount] = value;
      elementCount++;
      return;
    }

    System.arraycopy(elements, insertIndex, elements, insertIndex + 1, elementCount - insertIndex);

    elements[insertIndex] = value;
    elementCount++;
  }

  @Override
  public boolean delete(long value) {
    boolean deleted = false;

    int index;
    while ((index = index(value)) != -1) {
      deleted = true;

      if (elementCount + 1 - index >= 0)
        System.arraycopy(elements, index + 1, elements, index, elementCount + 1 - index);

      elementCount--;
    }

    return deleted;
  }

  @Override
  public long max() {
    if (elementCount == 0) {
      return -1;
    }
    return this.elements[elementCount - 1];
  }

  @Override
  public long removeMax() {
    if (elementCount == 0) {
      return -1;
    }

    return this.elements[--elementCount];
  }

  private int getElementLocation(long element, boolean exactMatch) {
    int lowerBound = 0;
    int upperBound = elementCount - 1;
    int currentIndex;

    while (true) {
      currentIndex = (upperBound + lowerBound) / 2;

      long elementAtIndex = elements[currentIndex];

      if (elementAtIndex == element) {
        return currentIndex;
      }

      if (lowerBound > upperBound || currentIndex == 0) {
        return -1;
      }

      if (elementAtIndex > element) {
        if (!exactMatch && elements[currentIndex + 1] < elementAtIndex) {
          return currentIndex - 1;
        }

        upperBound = currentIndex - 1;
      } else {
        if (!exactMatch && elements[currentIndex - 1] > elementAtIndex) {
          return currentIndex;
        }

        lowerBound = currentIndex + 1;
      }
    }
  }
}
