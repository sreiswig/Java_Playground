public class TestClass {
  private int value;

  public TestClass(int value) {
    int preInitialization = value * 2;
    this.value = preInitialization;
  }

  public int getValue() {
    return this.value;
  }
}
