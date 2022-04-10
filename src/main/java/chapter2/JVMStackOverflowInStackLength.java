/**
 * Copyright (C) 2022 Urban Compass, Inc.
 */
package chapter2;

/**
 * VM Args: -Xss128k
 */
public class JVMStackOverflowInStackLength {

  private int stackLength = 1;

  public void stackLeak() {
    stackLength++;
    stackLeak();
  }

  public static void main(String[] args) throws Throwable {
    JVMStackOverflowInStackLength overflow = new JVMStackOverflowInStackLength();
    try {
      overflow.stackLeak();
    } catch (Throwable e) {
      // stack length: 16907
      // Exception in thread "main" java.lang.StackOverflowError
      System.out.println("stack length: " + overflow.stackLength);
      throw e;
    }
  }
}
