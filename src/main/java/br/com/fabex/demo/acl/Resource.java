package br.com.fabex.demo.acl;

import java.util.List;

public interface Resource {
    void access();
    List<String> getPermissions();
}
