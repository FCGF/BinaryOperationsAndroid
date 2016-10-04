package br.org.catolicasc.fcgf.binaryoperations;

/**
 * Created by Fernando on 28-Sep-16.
 */

final class Divide implements IOperation {
    @Override
    public String calculate(String x, String y) {
        if (x.equals("0") || y.equals("0")) {
            return "0";
        }

        int longestLength = Util.getLongestLength(x, y);
        x = Util.padLeft(x, longestLength);
        y = Util.padLeft(y, longestLength);
        String contador = Util.padLeft("0", longestLength);

        final Add add = new Add();
        final Subtract subtract = new Subtract();

        while (Util.compare(x, y) >= 0) {
            contador = add.calculate(contador, "1");
            x = subtract.calculate(x, y);
        }

        return contador;
    }
}
