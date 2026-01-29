package com.ontariotechu.sofe3980U;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

/**
 * Unit test for Binary class.
 */
public class BinaryTest 
{
    /**
     * Test The constructor with a valid binary value
     */
    @Test
    public void normalConstructor()
    {
        Binary binary = new Binary("1001001");
        assertTrue(binary.getValue().equals("1001001"));
    }

    /**
     * Test The constructor with an invalid binary value of out-of-range digits
     */
    @Test
    public void constructorWithInvalidDigits()
    {
        Binary binary = new Binary("1001001211");
        assertTrue(binary.getValue().equals("0"));
    }

    /**
     * Test The constructor with an invalid binary value of alphabetic characters
     */
    @Test
    public void constructorWithInvalidChars()
    {
        Binary binary = new Binary("1001001A");
        assertTrue(binary.getValue().equals("0"));
    }

    /**
     * Test The constructor with an invalid binary value that has a sign
     */
    @Test
    public void constructorWithNegativeSign()
    {
        Binary binary = new Binary("-1001001");
        assertTrue(binary.getValue().equals("0"));
    }

    /**
     * Test The constructor with a zero tailing valid binary value
     */
    @Test
    public void constructorWithZeroTailing()
    {
        Binary binary = new Binary("00001001");
        assertTrue(binary.getValue().equals("1001"));
    }

    /**
     * Test The constructor with an empty string
     */
    @Test
    public void constructorEmptyString()
    {
        Binary binary = new Binary("");
        assertTrue(binary.getValue().equals("0"));
    }

    /**
     * Test The add function with two binary numbers of the same length
     */
    @Test
    public void add()
    {
        Binary binary1 = new Binary("1000");
        Binary binary2 = new Binary("1111");
        Binary binary3 = Binary.add(binary1, binary2);
        assertTrue(binary3.getValue().equals("10111"));
    }

    /**
     * Test The add function with two binary numbers, the length of the first argument is less than the second
     */
    @Test
    public void add2()
    {
        Binary binary1 = new Binary("1010");
        Binary binary2 = new Binary("11");
        Binary binary3 = Binary.add(binary1, binary2);
        assertTrue(binary3.getValue().equals("1101"));
    }

    /**
     * Test The add function with two binary numbers, the length of the first argument is greater than the second
     */
    @Test
    public void add3()
    {
        Binary binary1 = new Binary("11");
        Binary binary2 = new Binary("1010");
        Binary binary3 = Binary.add(binary1, binary2);
        assertTrue(binary3.getValue().equals("1101"));
    }

    /**
     * Test The add function with a binary number with zero
     */
    @Test
    public void add4()
    {
        Binary binary1 = new Binary("0");
        Binary binary2 = new Binary("1010");
        Binary binary3 = Binary.add(binary1, binary2);
        assertTrue(binary3.getValue().equals("1010"));
    }

    /**
     * Test The add function with two zeros
     */
    @Test
    public void add5()
    {
        Binary binary1 = new Binary("0");
        Binary binary2 = new Binary("0");
        Binary binary3 = Binary.add(binary1, binary2);
        assertTrue(binary3.getValue().equals("0"));
    }

    // ==================== OR Operation Tests ====================

    /**
     * Test OR operation with two binary numbers of the same length
     * 1010 OR 1100 = 1110 (10 OR 12 = 14)
     */
    @Test
    public void or1()
    {
        Binary binary1 = new Binary("1010");
        Binary binary2 = new Binary("1100");
        Binary result = Binary.or(binary1, binary2);
        assertTrue(result.getValue().equals("1110"));
    }

    /**
     * Test OR operation with binary numbers of different lengths
     * 111 OR 10000 = 10111 (7 OR 16 = 23)
     */
    @Test
    public void or2()
    {
        Binary binary1 = new Binary("111");
        Binary binary2 = new Binary("10000");
        Binary result = Binary.or(binary1, binary2);
        assertTrue(result.getValue().equals("10111"));
    }

    /**
     * Test OR operation with a zero operand
     * 1010 OR 0 = 1010 (10 OR 0 = 10)
     */
    @Test
    public void or3()
    {
        Binary binary1 = new Binary("1010");
        Binary binary2 = new Binary("0");
        Binary result = Binary.or(binary1, binary2);
        assertTrue(result.getValue().equals("1010"));
    }

    // ==================== AND Operation Tests ====================

    /**
     * Test AND operation with two binary numbers of the same length
     * 1010 AND 1100 = 1000 (10 AND 12 = 8)
     */
    @Test
    public void and1()
    {
        Binary binary1 = new Binary("1010");
        Binary binary2 = new Binary("1100");
        Binary result = Binary.and(binary1, binary2);
        assertTrue(result.getValue().equals("1000"));
    }

    /**
     * Test AND operation with binary numbers of different lengths
     * 111 AND 10101 = 101 (7 AND 21 = 5)
     */
    @Test
    public void and2()
    {
        Binary binary1 = new Binary("111");
        Binary binary2 = new Binary("10101");
        Binary result = Binary.and(binary1, binary2);
        assertTrue(result.getValue().equals("101"));
    }

    /**
     * Test AND operation with a zero operand
     * 1010 AND 0 = 0 (10 AND 0 = 0)
     */
    @Test
    public void and3()
    {
        Binary binary1 = new Binary("1010");
        Binary binary2 = new Binary("0");
        Binary result = Binary.and(binary1, binary2);
        assertTrue(result.getValue().equals("0"));
    }

    // ==================== Multiply Operation Tests ====================

    /**
     * Test multiply operation with two binary numbers of the same length
     * 1010 * 1100 = 1111000 (10 * 12 = 120)
     */
    @Test
    public void multiply1()
    {
        Binary binary1 = new Binary("1010");
        Binary binary2 = new Binary("1100");
        Binary result = Binary.multiply(binary1, binary2);
        assertTrue(result.getValue().equals("1111000"));
    }

    /**
     * Test multiply operation with binary numbers of different lengths
     * 111 * 101 = 100011 (7 * 5 = 35)
     */
    @Test
    public void multiply2()
    {
        Binary binary1 = new Binary("111");
        Binary binary2 = new Binary("101");
        Binary result = Binary.multiply(binary1, binary2);
        assertTrue(result.getValue().equals("100011"));
    }

    /**
     * Test multiply operation with a zero operand
     * 1010 * 0 = 0 (10 * 0 = 0)
     */
    @Test
    public void multiply3()
    {
        Binary binary1 = new Binary("1010");
        Binary binary2 = new Binary("0");
        Binary result = Binary.multiply(binary1, binary2);
        assertTrue(result.getValue().equals("0"));
    }
}
