package br.org.catolicasc.fcgf.binaryoperations;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;

/**
 * Created by Fernando on 28-Sep-16.
 */

final class BinaryCalculator {

    private static BinaryCalculator instance;
    private HashMap<String, IOperation> operationMap;

    private String previousValue;
    private String currentValue;

    private Operation nextOperation;
    private Operation currentOperation;

    private BinaryCalculator() {
        super();
        this.operationMap = new HashMap<>();
        previousValue = null;
        currentValue = null;
        nextOperation = null;
        currentOperation = null;
    }

    static BinaryCalculator GetInstance() {
        if (instance == null) {
            instance = new BinaryCalculator();
        }
        return instance;
    }

    private IOperation findOperation(Operation operation) throws Exception {
        final String model = "br.org.catolicasc.fcgf.binaryoperations";
        final String operationName = operation.getName();
        IOperation op = operationMap.get(operationName);
        if (op == null) {
            final Class<?> klass = Class.forName(String.format("%s.%s", model, operationName));
            final Constructor<?> constructor = klass.getDeclaredConstructor();
            op = (IOperation) constructor.newInstance();
            operationMap.put(operationName, op);
        }
        return op;
    }

    String executeOperation() throws Exception {
        String result = this.findOperation(currentOperation).calculate(previousValue, currentValue);
        previousValue = result;
        currentValue = null;
        currentOperation = nextOperation;
        nextOperation = null;
        return result;
    }

    void addValue(String value) {
        if (previousValue == null) {
            previousValue = value;
        } else if (currentValue == null) {
            currentValue = value;
        }
    }

    void addOperand(Operation operation) {
        if (currentOperation == null) {
            currentOperation = operation;
        } else if (nextOperation == null) {
            nextOperation = operation;
        }
    }

    boolean shouldCalculate() {
        return previousValue != null && currentValue != null && currentOperation != null && nextOperation != null;
    }

    void clear() {
        previousValue = null;
        currentValue = null;
        currentOperation = null;
        nextOperation = null;
    }

}
