import java.util.concurrent.Executors;
import java.util.stream.IntStream;
import java.time.Duration;
import java.lang.Character;

public class NewFeatures {
  static String testSwitchStatement(String input) {
    String output = null;
    switch (input) {
      case null -> output = "Null case";
      case "test" -> output = "test case";
      default -> output = "default case";
    }
    return output;
  }

  public static void main(String[] args) {
    String output = testSwitchStatement("test");
    System.out.println(output);
    output = testSwitchStatement(null);
    System.out.println(output);
    output = testSwitchStatement("some nonsense");
    System.out.println(output);

    try(var executor = Executors.newVirtualThreadPerTaskExecutor()) {
      IntStream.rangeClosed(1, 10_000).forEach(i -> {
        executor.submit(() -> {
          System.out.println(i);
          try {
            Thread.sleep(Duration.ofSeconds(1));
          }
          catch (InterruptedException e) {
            e.printStackTrace();
          }
        });
      });
    }

    boolean isEmojiChar = Character.isEmoji('🐢');
    System.out.println("Is 🐢 an emoji? " + isEmojiChar);
    System.out.println("🤔");
  }
}
