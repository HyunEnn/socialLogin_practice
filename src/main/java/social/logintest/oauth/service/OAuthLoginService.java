package social.logintest.oauth.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import social.logintest.domain.Member;
import social.logintest.oauth.oauthApi.response.RequestOAuthInfoService;
import social.logintest.oauth.oauthApi.params.OAuthLoginParams;
import social.logintest.oauth.oauthApi.response.OAuthInfoResponse;
import social.logintest.oauth.tokens.AuthTokens;
import social.logintest.oauth.tokens.AuthTokensGenerator;
import social.logintest.oauth.repository.MemberRepository;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class OAuthLoginService {
    private final MemberRepository memberRepository;
    private final AuthTokensGenerator authTokensGenerator;
    private final RequestOAuthInfoService requestOAuthInfoService;

    public AuthTokens login(OAuthLoginParams params) {
        OAuthInfoResponse oAuthInfoResponse = requestOAuthInfoService.request(params);
        // param 값을 통한, access, refresh, grantType, 유효시간을 반환한다.
        Long memberId = findOrCreateMember(oAuthInfoResponse);

        return authTokensGenerator.generate(memberId);
        // JWT 토큰으로 엑세스 토큰, 리프래쉬 토큰이 만들어져서 리턴된다
    }


    private Long findOrCreateMember(OAuthInfoResponse oAuthInfoResponse) {
        return memberRepository.findByEmail(oAuthInfoResponse.getEmail())
                .map(Member::getId)
                .orElseGet(() -> newMember(oAuthInfoResponse));
    }

    private Long newMember(OAuthInfoResponse oAuthInfoResponse) {
        Member member = Member.builder()
                .email(oAuthInfoResponse.getEmail())
                .nickname(oAuthInfoResponse.getNickname())
                .oAuthProvider(oAuthInfoResponse.getOAuthProvider())
                .build();

        return memberRepository.save(member).getId();
    }

    private Member findMember(OAuthInfoResponse oAuthInfoResponse) {
        Optional<Member> findMember = memberRepository.findByEmail(oAuthInfoResponse.getEmail());

        return findMember.orElse(null);
    }
}
