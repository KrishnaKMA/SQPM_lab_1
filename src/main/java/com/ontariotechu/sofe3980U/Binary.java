package com.ontariotechu.sofe3980U;

public class Binary
{
    private String number="0";  

    /**
     * @param number 
     */
    public Binary(String number) {
        if (number == null || number.isEmpty()) {
            this.number = "0";  // Default to "0" for null or empty input
            return;
        }
        
        // Validate the binary string 
        for (int i = 0; i < number.length(); i++) {
            char ch = number.charAt(i);
            if (ch != '0' && ch != '1') {
                this.number = "0";  
                return;
            }
        }
        
        // Remove leading zeros
        int beg;
        for (beg = 0; beg < number.length(); beg++) {
            if (number.charAt(beg) != '0') {
                break;
            }
        }

        this.number = (beg == number.length()) ? "0" : number.substring(beg);
        
        if (this.number.isEmpty()) {
            this.number = "0";
        }
    }

    /**
     * @return 
     */
    public String getValue()
    {
        return this.number;
    }

    /**
     * @param num1 The first addend object
     * @param num2 The second addend object
     * @return A binary variable with a value of num1+num2.
     */
    public static Binary add(Binary num1, Binary num2)
    {
        // the index of the first digit of each number
        int ind1 = num1.number.length() - 1;
        int ind2 = num2.number.length() - 1;
        // initial variable
        int carry = 0;
        String num3 = "";  // the binary value of the sum
        while (ind1 >= 0 || ind2 >= 0 || carry != 0)  // loop until all digits are processed
        {
            int sum = carry;  // previous carry
            if (ind1 >= 0) {  // if num1 has a digit to add
                sum += (num1.number.charAt(ind1) == '1') ? 1 : 0;  // convert the digit to int and add it to sum
                ind1--;  // update ind1
            }
            if (ind2 >= 0) {  // if num2 has a digit to add
                sum += (num2.number.charAt(ind2) == '1') ? 1 : 0;  // convert the digit to int and add it to sum
                ind2--;  // update ind2
            }
            carry = sum / 2;  // the new carry
            sum = sum % 2;  // the resultant digit
            num3 = ((sum == 0) ? "0" : "1") + num3;  // convert sum to string and append it to num3
        }
        Binary result = new Binary(num3);  // create a binary object with the calculated value.
        return result;
    }

    /**
     * @param num1 The first binary operand
     * @param num2 The second binary operand
     * @return A binary variable with the result of num1 OR num2.
     */
    public static Binary or(Binary num1, Binary num2)
    {
        int ind1 = num1.number.length() - 1;
        int ind2 = num2.number.length() - 1;
        String result = "";
        
        while (ind1 >= 0 || ind2 >= 0)
        {
            int bit1 = 0;
            int bit2 = 0;
            
            if (ind1 >= 0) {
                bit1 = (num1.number.charAt(ind1) == '1') ? 1 : 0;
                ind1--;
            }
            if (ind2 >= 0) {
                bit2 = (num2.number.charAt(ind2) == '1') ? 1 : 0;
                ind2--;
            }
            
            // OR operation: 1 if either bit is 1
            int orResult = (bit1 | bit2);
            result = ((orResult == 0) ? "0" : "1") + result;
        }
        
        return new Binary(result);
    }

    /**
     * Performs bitwise logical AND operation on two binary variables.
     * The AND operation returns 1 only if both bits are 1, otherwise returns 0.
     *
     * @param num1 The first binary operand
     * @param num2 The second binary operand
     * @return A binary variable with the result of num1 AND num2.
     */
    public static Binary and(Binary num1, Binary num2)
    {
        int ind1 = num1.number.length() - 1;
        int ind2 = num2.number.length() - 1;
        String result = "";
        
        while (ind1 >= 0 || ind2 >= 0)
        {
            int bit1 = 0;
            int bit2 = 0;
            
            if (ind1 >= 0) {
                bit1 = (num1.number.charAt(ind1) == '1') ? 1 : 0;
                ind1--;
            }
            if (ind2 >= 0) {
                bit2 = (num2.number.charAt(ind2) == '1') ? 1 : 0;
                ind2--;
            }
            
            // AND operation: 1 only if both bits are 1
            int andResult = (bit1 & bit2);
            result = ((andResult == 0) ? "0" : "1") + result;
        }
        
        return new Binary(result);
    }

    /**
     * Multiplies two binary variables using the shift-and-add algorithm.
     * This method uses the add function to perform the multiplication.
     *
     * @param num1 The first binary operand (multiplicand)
     * @param num2 The second binary operand (multiplier)
     * @return A binary variable with the result of num1 * num2.
     */
    public static Binary multiply(Binary num1, Binary num2)
    {
        Binary result = new Binary("0");
        String multiplier = num2.number;
        
        // For each bit in the multiplier, starting from the least significant bit
        for (int i = multiplier.length() - 1; i >= 0; i--)
        {
            if (multiplier.charAt(i) == '1')
            {
                // Calculate the shift amount (position from the right)
                int shiftAmount = multiplier.length() - 1 - i;
                
                // Shift num1 left by shiftAmount (multiply by 2^shiftAmount)
                String shiftedValue = num1.number;
                for (int j = 0; j < shiftAmount; j++)
                {
                    shiftedValue = shiftedValue + "0";
                }
                
                // Add the shifted value to the result
                Binary shiftedBinary = new Binary(shiftedValue);
                result = add(result, shiftedBinary);
            }
        }
        
        return result;
    }
}
