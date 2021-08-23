package arrays.util;

import arrays.MyArray;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.stream.LongStream;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public abstract class MyArrayTest<T extends MyArray> {

  protected final T array;

  public MyArrayTest(T array) {
    this.array = array;
  }

  @BeforeEach
  void setup() {
    array.clear();
  }

  @Test
  void elementAt() {
    assertThat(array.elementAt(0)).isEqualTo(-1);

    Stream.of(10, 15, 30).forEach(array::insert);

    assertThat(array.elementAt(-1)).isEqualTo(-1);
    assertThat(array.elementAt(0)).isEqualTo(10);
    assertThat(array.elementAt(1)).isEqualTo(15);
    assertThat(array.elementAt(2)).isEqualTo(30);

    assertThat(array.elementAt(30)).isEqualTo(-1);
    assertThat(array.elementAt(150)).isEqualTo(-1);
  }

  @Test
  void insert() {
    Stream.of(10, 15, 30).forEach(array::insert);

    assertThat(array.size()).isEqualTo(3);
    assertThat(array.exists(10)).isTrue();
    assertThat(array.exists(15)).isTrue();
    assertThat(array.exists(20)).isFalse();

    assertThat(array.display()).isEqualTo("[10, 15, 30]");
  }

  @Test
  void delete() {
    Stream.of(10, 15).forEach(array::insert);

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
    Stream.of(10, 15, 20, 30, 20, 30).forEach(array::insert);

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

  @Test
  void max() {
    Stream.of(10, 20, 30, 40).forEach(array::insert);

    assertThat(array.max()).isEqualTo(40);
  }

  @Test
  void emptyMax() {
    assertThat(array.max()).isEqualTo(-1);
  }

  @Test
  void removeMax() {
    Stream.of(10, 20, 30, 40).forEach(array::insert);

    assertThat(array.removeMax()).isEqualTo(40);
    assertThat(array.exists(40)).isFalse();
  }

  @Test
  void emptyRemoveMax() {
    assertThat(array.removeMax()).isEqualTo(-1);
  }
}
