package com.ontariotechu.sofe3980U;

public class App 
{
    /**
     * Main program
     * @param args: not used
     */
    public static void main( String[] args )
    {
        Binary binary1 = new Binary("10001000");
        System.out.println("First binary number is " + binary1.getValue());
        
        Binary binary2 = new Binary("111000");
        System.out.println("Second binary number is " + binary2.getValue());
        
        // Addition
        Binary sum = Binary.add(binary1, binary2);
        System.out.println("Their summation is " + sum.getValue());
        
        // OR operation
        Binary orResult = Binary.or(binary1, binary2);
        System.out.println("Their OR is " + orResult.getValue());
        
        // AND operation
        Binary andResult = Binary.and(binary1, binary2);
        System.out.println("Their AND is " + andResult.getValue());
        
        // Multiplication
        Binary product = Binary.multiply(binary1, binary2);
        System.out.println("Their multiplication is " + product.getValue());
    }
}
