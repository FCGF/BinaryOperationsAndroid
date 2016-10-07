package br.org.catolicasc.fcgf.binaryoperations;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by Fernando on 07-Oct-16.
 */

public class AddTest {

    @Test
    public void OperationTest() {
        IOperation add = new Add();

        Assert.assertEquals("10", add.calculate("1", "1"));
        Assert.assertEquals("11", add.calculate("10", "1"));
        Assert.assertEquals("101110", add.calculate("10001", "11101"));
        Assert.assertEquals("1000110", add.calculate("101101", "11001"));
        Assert.assertEquals("10010011", add.calculate("1011001", "111010"));
        Assert.assertEquals("11101", add.calculate("1110", "1111"));
        Assert.assertEquals("1001100", add.calculate("10111", "110101"));
        Assert.assertEquals("1100101", add.calculate("11011", "1001010"));

    }
}
