package social.logintest.oauth.oauthApi.params;

import org.springframework.util.MultiValueMap;
import social.logintest.domain.OAuthProvider;

public interface OAuthLoginParams {
    OAuthProvider oAuthProvider();
    MultiValueMap<String, String> makeBody();
}
/**
 * MultiValueMap
 * -> Extension of the Map interface that stores multiple values.
 * example
 * multiValueMap.add("test",1);
 * multiValueMap.add("test",2);
 * 실행 결과
 * multiValueMap = {test=[1, 2]}
 */

