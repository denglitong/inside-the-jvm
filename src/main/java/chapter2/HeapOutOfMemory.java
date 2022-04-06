/**
 * Copyright (C) 2022 Urban Compass, Inc.
 */
package chapter2;

import java.util.ArrayList;
import java.util.List;

/**
 * VM Args: -Xms20m -Xmx20m -XX:+HeapDumpOnOutOfMemoryError
 */
public class HeapOutOfMemory {

  static class OOMObject {}

  public static void main(String[] args) {
    List<OOMObject> list = new ArrayList<OOMObject>();

    // java.lang.OutOfMemoryError: Java heap space
    // Dumping heap to java_pid65147.hprof ...
    // Heap dump file created [29113774 bytes in 0.131 secs]
    // Exception in thread "main" java.lang.OutOfMemoryError: Java heap space
    while (true) {
      list.add(new OOMObject());
    }
  }
}
