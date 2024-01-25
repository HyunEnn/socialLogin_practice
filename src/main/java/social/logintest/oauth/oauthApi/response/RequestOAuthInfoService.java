package social.logintest.oauth.oauthApi.response;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import social.logintest.domain.OAuthProvider;
import social.logintest.oauth.oauthApi.client.OAuthApiClient;
import social.logintest.oauth.oauthApi.client.RevokeTokenResponseDto;
import social.logintest.oauth.oauthApi.params.OAuthLoginParams;
import social.logintest.oauth.oauthApi.params.OAuthLogoutParams;
import social.logintest.oauth.oauthApi.response.OAuthInfoResponse;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@Component
@Slf4j
public class RequestOAuthInfoService {
    private final Map<OAuthProvider, OAuthApiClient> clients;

    public RequestOAuthInfoService(List<OAuthApiClient> clients) {
        this.clients = clients.stream().collect(
                Collectors.toUnmodifiableMap(OAuthApiClient::oAuthProvider, Function.identity())
        );
    }

    public OAuthInfoResponse request(OAuthLoginParams params) {
        OAuthApiClient client = clients.get(params.oAuthProvider());
        String accessToken = client.requestAccessToken(params);
        OAuthInfoResponse res = client.requestOauthInfo(accessToken);
        log.info("Object : " + res.getEmail());
        log.info("name : "+ res.getNickname());
        log.info("kakao : " + res.getOAuthProvider());
        // 로그인 유저 정보에 대한 값들을 리턴
        return client.requestOauthInfo(accessToken);
    }

    public RevokeTokenResponseDto logoutService(OAuthLogoutParams params) {
        OAuthApiClient client = clients.get(params.oAuthProvider()); // 클라이언트의 제공자 확인

        return client.revokeAccessToken(params);
    }

}
