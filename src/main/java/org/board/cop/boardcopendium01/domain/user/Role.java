package org.board.cop.boardcopendium01.domain.user;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.Arrays;

@Getter
@RequiredArgsConstructor
public enum Role {
    GUEST("ROLE_GUEST", "손님"),
    USER("ROLE_USER", "일반 사용자");

    private final String key;
    private final String title;

    public static Role getRoleByKey(String key){
        return Arrays.stream(Role.values())
                .filter(e-> e.key.equals(key))
                .findAny().orElseThrow(()-> new IllegalArgumentException("해당 권한이 권한 리스트에 없습니다."));

    }
}
