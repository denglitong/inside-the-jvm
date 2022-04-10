/**
 * Copyright (C) 2022 Urban Compass, Inc.
 */
package chapter2;

import java.util.HashSet;
import java.util.Set;

/**
 * VM Args: -Xmx=128k -Xms=128k
 */
public class RuntimeConstantPoolOOMInJDK7Plus {

  public static void main(String[] args) {
    Set<String> set = new HashSet<String>();
    short i = 0;
    while (true) {
      set.add(String.valueOf(i++).intern());
    }
  }
}
