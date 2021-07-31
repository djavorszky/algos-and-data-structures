package arrays.util;

import arrays.MyArray;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.stream.LongStream;

import static org.assertj.core.api.Assertions.assertThat;

public abstract class MyArrayTest<T extends MyArray> {

  private final T array;

  public MyArrayTest(T array) {
    this.array = array;
  }

  @BeforeEach
  void setup() {
    array.clear();
  }

  @Test
  void insert() {
    array.insert(10);
    array.insert(15);

    assertThat(array.size()).isEqualTo(2);
    assertThat(array.exists(10)).isTrue();
    assertThat(array.exists(15)).isTrue();
    assertThat(array.exists(20)).isFalse();

    assertThat(array.display()).isEqualTo("[10, 15]");
  }

  @Test
  void delete() {
    array.insert(10);
    array.insert(15);

    assertThat(array.exists(10)).isTrue();

    boolean successfulDelete = array.delete(10);

    assertThat(successfulDelete).isTrue();
    assertThat(array.size()).isEqualTo(1);
    assertThat(array.exists(10)).isFalse();
    assertThat(array.display()).isEqualTo("[15]");

    boolean unsuccessfulDelete = array.delete(-299);

    assertThat(unsuccessfulDelete).isFalse();
    assertThat(array.size()).isEqualTo(1);
  }

  @Test
  void testDisplay() {
    assertThat(array.display()).isEqualTo("[]");

    array.insert(10);

    assertThat(array.display()).isEqualTo("[10]");

    array.insert(20);

    assertThat(array.display()).isEqualTo("[10, 20]");
  }

  @Test
  void multiDelete() {
    array.insert(10);
    array.insert(15);
    array.insert(20);
    array.insert(30);
    array.insert(20);
    array.insert(30);

    assertThat(array.exists(30)).isTrue();

    boolean successfulDelete = array.delete(30);

    assertThat(successfulDelete).isTrue();
    assertThat(array.display()).isEqualTo("[10, 15, 20, 20]");
    assertThat(array.size()).isEqualTo(4);
    assertThat(array.exists(30)).isFalse();

    boolean unsuccessfulDelete = array.delete(-299);

    assertThat(unsuccessfulDelete).isFalse();
    assertThat(array.size()).isEqualTo(4);
  }

  @Test
  void size() {
    assertThat(array.size()).isEqualTo(0);

    array.insert(10);
    array.insert(15);
    array.insert(20);

    assertThat(array.size()).isEqualTo(3);
  }

  @Test
  void exists() {
    LongStream.range(0, 100).forEach(array::insert);

    assertThat(array.exists(10)).isTrue();
    assertThat(array.exists(15)).isTrue();
    assertThat(array.exists(99)).isTrue();
    assertThat(array.exists(200)).isFalse();
  }

  @Test
  void index() {
    LongStream.range(0, 100).forEach(array::insert);

    assertThat(array.index(10)).isEqualTo(10);
    assertThat(array.index(15)).isEqualTo(15);
    assertThat(array.index(99)).isEqualTo(99);
    assertThat(array.index(200)).isEqualTo(-1);
  }
}
