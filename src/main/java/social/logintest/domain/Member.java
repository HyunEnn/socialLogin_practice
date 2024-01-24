package social.logintest.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
public class Member {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String email;
    private String nickname;
    private OAuthProvider oAuthProvider;
    private String accessToken;
    private String refreshToken;

    @Builder
    public Member(String email, String nickname, OAuthProvider oAuthProvider) {
        this.email = email;
        this.nickname = nickname;
        this.oAuthProvider = oAuthProvider;

    }

    @Builder
    public Member(String email, String nickname, OAuthProvider oAuthProvider, String accessToken, String refreshToken) {
        this.email = email;
        this.nickname = nickname;
        this.oAuthProvider = oAuthProvider;
        this.accessToken = accessToken;
        this.refreshToken = refreshToken;
    }
}
