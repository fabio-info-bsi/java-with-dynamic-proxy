package br.com.fabex.demo.acl;

import java.lang.reflect.Proxy;

public class AppAcl {
    public static void main(String[] args) {

        Resource recurseImpl = new ResourceImpl();
        Resource proxyInstance = (Resource) Proxy.newProxyInstance(
                recurseImpl.getClass().getClassLoader(),
                new Class[]{Resource.class},
                new AclInvocationHandler(recurseImpl)
        );

        System.out.println("= = = = = = = = = = = = = = = ");
        proxyInstance.access();
        System.out.println("= = = = = = = = = = = = = = = ");
        System.out.println("Permissions: " + proxyInstance.getPermissions());
    }
}
