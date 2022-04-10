/**
 * Copyright (C) 2022 Urban Compass, Inc.
 */
package chapter2;

import java.lang.reflect.Method;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

/**
 * JDK7 VM Args: -XX:PermSize=10M -XX:MaxPermSize=10M
 * <p>
 * JDK 8+ VM Args: -XX:MetaspaceSize=10m -XX:MaxMetaspaceSize=10m
 */
public class JVMMethodAreaOOM {

  public static void main(String[] args) {
    while (true) {
      // use CGLib to create dynamic class thus they will be saved in method area
      Enhancer enhancer = new Enhancer();
      enhancer.setSuperclass(OOMObject.class);
      enhancer.setUseCache(false);
      enhancer.setCallback(new MethodInterceptor() {
        public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy)
            throws Throwable {
          return proxy.invokeSuper(obj, args);
        }
      });
      enhancer.create();
    }
  }

  static class OOMObject {
  }
}
