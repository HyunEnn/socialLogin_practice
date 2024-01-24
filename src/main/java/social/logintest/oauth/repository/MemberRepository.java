package social.logintest.oauth.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import social.logintest.domain.Member;

import java.util.Optional;

public interface MemberRepository extends JpaRepository<Member, Long> {
    Optional<Member> findByEmail(String email);
}
