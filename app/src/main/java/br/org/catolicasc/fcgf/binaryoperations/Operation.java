package br.org.catolicasc.fcgf.binaryoperations;

/**
 * Created by Fernando on 28-Sep-16.
 */

enum Operation {
    ADD(Add.class.getSimpleName(), '+'),
    SUBTRACT(Subtract.class.getSimpleName(), '-'),
    MULTIPLY(Multiply.class.getSimpleName(), '*'),
    DIVIDE(Divide.class.getSimpleName(), '/');

    private final String name;
    private final char symbol;

    Operation(String name, char symbol) {
        this.name = name;
        this.symbol = symbol;
    }

    public String getName() {
        return name;
    }

    public char getSymbol() {
        return symbol;
    }
}
