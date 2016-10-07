package br.org.catolicasc.fcgf.binaryoperations;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by Fernando on 07-Oct-16.
 */

public class MultiplyTest {

    @Test
    public void OperationTest() {
        IOperation multiply = new Multiply();

        Assert.assertEquals("100101011", multiply.calculate("10111", "1101"));
        Assert.assertEquals("1111", multiply.calculate("101", "11"));
        Assert.assertEquals("1", multiply.calculate("1", "1"));
        Assert.assertEquals("10", multiply.calculate("10", "1"));
        Assert.assertEquals("0", multiply.calculate("10", "0"));
        Assert.assertEquals("1001", multiply.calculate("11", "11"));
        Assert.assertEquals("11110110", multiply.calculate("00101001", "00000110"));
        Assert.assertEquals("01000101", multiply.calculate("00010111", "00000011"));
        Assert.assertEquals("00011000", multiply.calculate("00001000", "00000011"));

    }
}
