package social.logintest.oauth.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import social.logintest.oauth.oauthApi.client.OAuthApiClient;
import social.logintest.oauth.oauthApi.client.RevokeTokenResponseDto;
import social.logintest.oauth.oauthApi.params.OAuthLogoutParams;
import social.logintest.oauth.oauthApi.response.RequestOAuthInfoService;

@Service
@RequiredArgsConstructor
public class OAuthLogoutService {

    private final RequestOAuthInfoService requestOAuthInfoService;

    public RevokeTokenResponseDto logout(OAuthLogoutParams params) {
        RevokeTokenResponseDto responseDto = requestOAuthInfoService.logoutService(params);
        return responseDto;
    }
}
