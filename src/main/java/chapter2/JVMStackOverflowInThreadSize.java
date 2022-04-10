/**
 * Copyright (C) 2022 Urban Compass, Inc.
 */
package chapter2;

/**
 * VM Args:-Xss20M
 * <p>
 * Pay attention that this may crash your os and you have better saved all you works before running
 */
public class JVMStackOverflowInThreadSize {

  private void dontStop() {
    while (true) {
    }
  }

  public void stackLeakByThread() {
    while (true) {
      Thread thread = new Thread(new Runnable() {
        public void run() {
          dontStop();
        }
      });
      thread.start();
    }
  }

  public static void main(String[] args) {
    JVMStackOverflowInThreadSize overflow = new JVMStackOverflowInThreadSize();
    overflow.stackLeakByThread();
  }
}
