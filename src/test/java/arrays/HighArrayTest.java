package arrays;

import arrays.util.MyArrayTest;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class HighArrayTest extends MyArrayTest<HighArray> {
  public HighArrayTest() {
    super(new HighArray(100));
  }
}