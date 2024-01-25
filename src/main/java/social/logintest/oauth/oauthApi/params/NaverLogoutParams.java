package social.logintest.oauth.oauthApi.params;

import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import social.logintest.domain.OAuthProvider;

@Getter
@NoArgsConstructor
public class NaverLogoutParams implements OAuthLogoutParams {
    private String accessToken;
    private String serviceProvider;

    @Override
    public OAuthProvider oAuthProvider() {
        return OAuthProvider.NAVER;
    }

    @Override
    public MultiValueMap<String, String> makebody() {
        LinkedMultiValueMap<String, String> body = new LinkedMultiValueMap<>();
        body.add("access_token", accessToken);
        body.add("service_provider", serviceProvider);
        return body;
    }
}
