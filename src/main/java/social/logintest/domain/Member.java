package social.logintest.domain;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
public class Member {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "member_id")
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
