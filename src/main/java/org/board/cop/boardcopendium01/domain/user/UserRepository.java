package org.board.cop.boardcopendium01.domain.user;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<UserDomain, Long> {

    Optional<UserDomain> findByEmail(String email);
}
