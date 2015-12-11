// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package twitter4j.auth;

import twitter4j.conf.Configuration;

// Referenced classes of package twitter4j.auth:
//            OAuthAuthorization, AccessToken, BasicAuthorization, Authorization

public final class AuthorizationFactory
{

    public AuthorizationFactory()
    {
    }

    public static Authorization getInstance(Configuration configuration)
    {
        String s;
        String s2;
        s = configuration.getOAuthConsumerKey();
        s2 = configuration.getOAuthConsumerSecret();
        if (s == null || s2 == null) goto _L2; else goto _L1
_L1:
        if (!configuration.isApplicationOnlyAuthEnabled()) goto _L4; else goto _L3
_L3:
        return null;
_L4:
        OAuthAuthorization oauthauthorization = new OAuthAuthorization(configuration);
        String s3 = configuration.getOAuthAccessToken();
        configuration = configuration.getOAuthAccessTokenSecret();
        if (s3 != null && configuration != null)
        {
            oauthauthorization.setOAuthAccessToken(new AccessToken(s3, configuration));
        }
        return oauthauthorization;
_L2:
        String s1 = configuration.getUser();
        configuration = configuration.getPassword();
        if (s1 != null && configuration != null)
        {
            return new BasicAuthorization(s1, configuration);
        }
        if (true) goto _L3; else goto _L5
_L5:
    }
}
