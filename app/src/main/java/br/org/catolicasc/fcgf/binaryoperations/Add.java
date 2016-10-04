package br.org.catolicasc.fcgf.binaryoperations;

/**
 * Created by Fernando on 28-Sep-16.
 */

final class Add implements IOperation {
    @Override
    public String calculate(String x, String y) {
        int longestLength = Util.getLongestLength(x, y);
        x = Util.padLeft(x, longestLength);
        y = Util.padLeft(y, longestLength);
        int leftover = 0;

        StringBuilder result = new StringBuilder("");

        for (int i = longestLength - 1; i >= 0; i--) {
            int first = Integer.parseInt(x.substring(i, i + 1));
            int second = Integer.parseInt(y.substring(i, i + 1));

            int sum = first + second + leftover;

            switch (sum) {
                case 0:
                    leftover = 0;
                    break;
                case 1:
                    leftover = 0;
                    break;
                case 2:
                    sum = 0;
                    leftover = 1;
                    break;
                case 3:
                    sum = 1;
                    leftover = 1;
                    break;
            }

            result.insert(0, sum);
        }
        if (leftover == 1) {
            result.insert(0, leftover);
        }
        return result.toString();
    }
}
