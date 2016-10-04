package br.org.catolicasc.fcgf.binaryoperations;

/**
 * Created by Fernando on 29-Sep-16.
 */

public final class Util {

    public static String padLeft(String original, int size) {
        StringBuilder result = new StringBuilder("");

        for (int originalSize = original.length(); originalSize < size; originalSize++) {
            result.append('0');
        }

        result.append(original);

        return result.toString();
    }

    public static int getLongestLength(String first, String second) {
        int firstLength = first.length();
        int secondLength = second.length();
        return firstLength > secondLength ? firstLength : secondLength;
    }

    public static int compare(String x, String y) {
        int longestLength = Util.getLongestLength(x, y);
        x = Util.padLeft(x, longestLength);
        y = Util.padLeft(y, longestLength);

        for (int i = 0; i < longestLength; i++) {
            if (x.charAt(i) > y.charAt(i)) {
                return 1;
            } else if (x.charAt(i) < y.charAt(i)) {
                return -1;
            }
        }
        return 0;
    }
}
