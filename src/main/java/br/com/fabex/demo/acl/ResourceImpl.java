package br.com.fabex.demo.acl;

import java.util.List;

public class ResourceImpl implements Resource{
    @Override
    public void access() {
        System.out.println("Access impl...");
    }

    @Override
    public List<String> getPermissions() {
        return List.of("ADMINISTRATOR", "READ", "WRITE");
    }
}
