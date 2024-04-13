package org.board.cop.boardcopendium01.domain.user;

import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class UrlRoleMapping {
    private Map<String, List<Role>> urlRoleMap;

    public UrlRoleMapping() {
        urlRoleMap = new HashMap<>();
        urlRoleMap.put("/", List.of(Role.GUEST, Role.USER));
        urlRoleMap.put("/api/v1/posts", List.of(Role.USER));
    }

    public Map<String, List<Role>> getUrlRoleMap(){
        return urlRoleMap;
    }
}
