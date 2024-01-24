package social.logintest.oauth.oauthApi.params;

import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import social.logintest.domain.OAuthProvider;

public class NaverLoginParams implements OAuthLoginParams {
    private String authorizationCode;
    private String state;


    @Override
    public OAuthProvider oAuthProvider() {
        return OAuthProvider.NAVER;
    }

    @Override
    public MultiValueMap<String, String> makeBody() {
        LinkedMultiValueMap<String, String> body = new LinkedMultiValueMap<>();
        body.add("code", authorizationCode);
        body.add("state", state);
        return body;
    }
}
