package br.org.catolicasc.fcgf.binaryoperations;

/**
 * Created by Fernando on 28-Sep-16.
 */

final class Multiply implements IOperation {
    @Override
    public String calculate(String x, String y) {
        if(x.equals("0") || y.equals("0")){
            return "0";
        }

        int longestLength = Util.getLongestLength(x, y);
        x = Util.padLeft(x, longestLength);
        y = Util.padLeft(y, longestLength);
        String contador = Util.padLeft("1", longestLength);

        final Add add = new Add();

        String result = x;

        while(!contador.equals(y)){
            contador = add.calculate(contador, "1");
            result = add.calculate(result, x);
        }

        return result;
    }
}
