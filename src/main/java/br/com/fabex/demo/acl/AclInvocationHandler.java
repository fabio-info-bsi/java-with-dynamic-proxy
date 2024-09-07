package br.com.fabex.demo.acl;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class AclInvocationHandler implements InvocationHandler {

    private final Object obj;

    public AclInvocationHandler(Object obj) {
        this.obj = obj;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        if (checkAuthorization()) {
            System.out.println("Authorization granted");
            System.out.println("Method: " + method.getName());
            return method.invoke(obj, args);
        } else {
            throw new SecurityException("Access denied!");
        }
    }

    private boolean checkAuthorization() {
        return true;
    }
}
