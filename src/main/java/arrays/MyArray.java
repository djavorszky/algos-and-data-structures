package arrays;

public interface MyArray {

  boolean exists(long searchKey);

  void insert(long value);

  boolean delete(long value);

  String display();

  int size();

  void clear();

  int index(long searchKey);
}
