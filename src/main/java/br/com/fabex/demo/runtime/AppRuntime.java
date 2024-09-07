package br.com.fabex.demo.runtime;

import java.lang.reflect.Proxy;

public class AppRuntime {

    public static void main(String[] args) {
        BusinessService businessServiceImpl = new BusinessServiceImpl();
        BusinessService proxyInstance = (BusinessService) Proxy.newProxyInstance(
                businessServiceImpl.getClass().getClassLoader(),
                new Class[]{BusinessService.class},
                new RuntimeInvocationHandler(businessServiceImpl)
        );

        proxyInstance.save(new User(1, ""));
        proxyInstance.findById(1L);
        proxyInstance.delete(1L);
        proxyInstance.findAll();
    }
}
