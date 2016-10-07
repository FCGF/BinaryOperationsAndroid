package br.org.catolicasc.fcgf.binaryoperations;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by Fernando on 07-Oct-16.
 */

public class DivideTest {

    @Test
    public void OperationTest() {
        IOperation divide = new Divide();

        Assert.assertEquals("1", divide.calculate("1", "1"));
        Assert.assertEquals("10", divide.calculate("10", "1"));
        Assert.assertEquals("0", divide.calculate("0", "10"));
        Assert.assertEquals("0011", divide.calculate("1011", "11"));
        Assert.assertEquals("00011011", divide.calculate("10000111", "00000101"));
        Assert.assertEquals("00000111", divide.calculate("00101010", "00000110"));

    }
}
