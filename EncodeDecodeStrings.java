import java.util.ArrayList;
import java.util.List;

public class EncodeDecodeStrings {
     public static String encode(List<String> strs) {
        StringBuilder encoded = new StringBuilder();

        for (String s : strs) {
            // format: length#string
            encoded.append(s.length()).append("#").append(s);
        }

        return encoded.toString();
    }

    // Decode: Convert single string back to list of strings
    public static List<String> decode(String str) {
        List<String> result = new ArrayList<>();
        int i = 0;

        while (i < str.length()) {

            // find position of '#'
            int j = i;
            while (str.charAt(j) != '#') {
                j++;
            }

            // length of next word
            int length = Integer.parseInt(str.substring(i, j));

            // move pointer after '#'
            j++;

            // extract word using length
            String word = str.substring(j, j + length);
            result.add(word);

            // move pointer to next segment
            i = j + length;
        }

        return result;
    }

    public static void main(String[] args) {

        List<String> input = new ArrayList<>();
        input.add("hello");
        input.add("world");
        input.add("java#code");
        input.add("123");

        String encoded = encode(input);
        System.out.println("Encoded String:");
        System.out.println(encoded);

        List<String> decoded = decode(encoded);
        System.out.println("\nDecoded List:");
        for (String s : decoded) {
            System.out.println(s);
        }
    }
}
