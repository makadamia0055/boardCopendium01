package org.board.cop.boardcopendium01.interceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.board.cop.boardcopendium01.domain.user.Role;
import org.springframework.web.servlet.HandlerInterceptor;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RequiredArgsConstructor
public class AccessPermitInterceptor implements HandlerInterceptor {

    private final Map<String, List<Role>> urlRoleMap;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String requestedUrl = request.getRequestURI();
        //일단 매칭될 때만
        // 임시로 유저 롤을 세션에서 가져오도록 함.
        // 나중에 토큰 구현하면 토큰으로 할 듯?

        String roleStr = (String) Optional.ofNullable(request.getSession().getAttribute("USER_ROLE"))
                .orElseGet(() -> String.valueOf(Role.GUEST.getKey()));
        // 세션 저장 방식이 아리까리해서 문자열로 가져옴.
        Role userRole = Role.getRoleByKey(roleStr);

        return urlRoleMap.getOrDefault(requestedUrl, List.of(userRole))
                .stream().filter(r-> r.equals(userRole)).findAny().isPresent();

    }



}
