package br.org.catolicasc.fcgf.binaryoperations;

/**
 * Created by Fernando on 28-Sep-16.
 */

final class Subtract implements IOperation {
    @Override
    public String calculate(String x, String y) {
        final int longestLength = Util.getLongestLength(x, y);
        x = Util.padLeft(x, longestLength);
        y = Util.padLeft(y, longestLength);
        final Add add = new Add();
        y = invert(y);
        y = add.calculate(y, "1");
        String result = add.calculate(x, y);
        result = result.substring(result.length()-longestLength);
        return result;
    }

    private String invert(String binaryNumber) {
        binaryNumber = binaryNumber.replaceAll("0", "2");
        binaryNumber = binaryNumber.replaceAll("1", "0");
        binaryNumber = binaryNumber.replaceAll("2", "1");
        return binaryNumber;
    }
}
