package social.logintest.oauth.oauthApi.params;

import org.springframework.util.MultiValueMap;
import social.logintest.domain.OAuthProvider;

public interface OAuthLogoutParams {

    OAuthProvider oAuthProvider();
    MultiValueMap<String, String> makebody();

}
