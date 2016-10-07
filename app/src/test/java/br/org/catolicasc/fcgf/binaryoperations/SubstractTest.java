package br.org.catolicasc.fcgf.binaryoperations;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by Fernando on 07-Oct-16.
 */

public class SubstractTest {

    @Test
    public void OperationTest() {
        IOperation substract = new Subtract();

        Assert.assertEquals("0", substract.calculate("1", "1"));
        Assert.assertEquals("01", substract.calculate("10", "1"));
        Assert.assertEquals("1001001", substract.calculate("1011011", "10010"));
        Assert.assertEquals("0101100", substract.calculate("1010110", "101010"));
        Assert.assertEquals("0011001", substract.calculate("1000101", "101100"));
        Assert.assertEquals("010011100", substract.calculate("100010110", "1111010"));
        Assert.assertEquals("000110", substract.calculate("101101", "100111"));
        Assert.assertEquals("0011111", substract.calculate("1110110", "1010111"));

    }
}
