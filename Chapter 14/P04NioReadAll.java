package ex14_1_exercise;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Stream;

/**
 *
 * @author oracle
 */
public class P04NioReadAll {
  public static void main(String[] args) {
        
    Path file =  Paths.get("resources/hamlet.txt");
    List<String> fileArr;

    try{
        // Read fileinto array here
      fileArr = Files.readAllLines(file);

        System.out.println("\n=== Lord Count ===");
      long wordCount = fileArr.stream()
              .flatMap(line -> Stream.of(line.split("\\W+")))
              .map(word -> word.toLowerCase())
              .filter(word -> word.equals("lord"))
              .peek(System.out::println)
              .count();


      System.out.println("Word count: " + wordCount);

        System.out.println("\n=== Prison Count ===");
      wordCount = fileArr.stream()
              .flatMap(line -> Stream.of(line.split("\\W+")))
              .map(word -> word.toLowerCase())
              .filter(word -> word.equals("prison"))
              .peek(System.out::println)
              .count();


      System.out.println("Word count: " + wordCount);

    }catch (IOException e){
        System.out.println("Error: " + e.getMessage());
    }

  } 
}
