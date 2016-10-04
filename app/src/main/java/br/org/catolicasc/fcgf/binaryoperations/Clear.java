package br.org.catolicasc.fcgf.binaryoperations;

/**
 * Created by Fernando on 29-Sep-16.
 */

final class Clear implements IOperation {
    @Override
    public String calculate(String x, String y) {
        return x + " / " + y;
    }
}
