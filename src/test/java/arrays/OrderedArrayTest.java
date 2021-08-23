package arrays;

import arrays.util.MyArrayTest;
import org.junit.jupiter.api.Test;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class OrderedArrayTest extends MyArrayTest<OrderedArray> {
  public OrderedArrayTest() {
    super(new OrderedArray(100));
  }

  @Test
  void merge() {
    Stream.of(15, 16, 20, 29, 35).forEach(array::insert);

    OrderedArray other = new OrderedArray(100);

    Stream.of(5, 17, 29).forEach(other::insert);

    OrderedArray result = array.merge(other);

    assertThat(result.size()).isEqualTo(8);
    assertThat(result.display()).isEqualTo("[5, 15, 16, 17, 20, 29, 29, 35]");
  }
}
