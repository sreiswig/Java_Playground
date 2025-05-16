public class NewFeatures {
  public static void TestTypePatterns(Object obj) {
    switch (obj) {
      case Integer i -> System.out.println("Object was an Integer " + i);
      case Long l -> System.out.println("Object was a Long " + l);
      case TestClass tc -> System.out.println("Object was an instance of TestClass " + tc.getValue());
      default -> System.out.println("Unknown Object " + obj);
    }
  }

  public static void main(String[] args) {
    System.out.println("Trying type patterns.");
    Object a = 1;
    TestTypePatterns(a);
    a = (long)1.0;
    TestTypePatterns(a);
    a = new Object();
    TestTypePatterns(a);
    a = new TestClass(4);
    TestTypePatterns(a);
  }
}

