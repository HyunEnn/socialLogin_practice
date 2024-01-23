package social.logintest.oauth.oauthApi.response;

import social.logintest.domain.OAuthProvider;

public interface OAuthInfoResponse {
    String getEmail();
    String getNickname();
    OAuthProvider getOauthProvider();
}
