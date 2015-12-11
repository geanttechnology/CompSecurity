// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package twitter4j.auth;

import twitter4j.conf.Configuration;

// Referenced classes of package twitter4j.auth:
//            VineOauthAuthorization, AccessToken, BasicAuthorization, Authorization

public class VineAuthorizationFactory
{

    public VineAuthorizationFactory()
    {
    }

    public static Authorization getInstance(Configuration configuration)
    {
        VineOauthAuthorization vineoauthauthorization = null;
        String s = configuration.getOAuthConsumerKey();
        String s3 = configuration.getOAuthConsumerSecret();
        if (s != null && s3 != null)
        {
            vineoauthauthorization = new VineOauthAuthorization(configuration);
            String s1 = configuration.getOAuthAccessToken();
            configuration = configuration.getOAuthAccessTokenSecret();
            if (s1 != null && configuration != null)
            {
                vineoauthauthorization.setOAuthAccessToken(new AccessToken(s1, configuration));
            }
            configuration = vineoauthauthorization;
        } else
        {
            String s2 = configuration.getUser();
            String s4 = configuration.getPassword();
            configuration = vineoauthauthorization;
            if (s2 != null)
            {
                configuration = vineoauthauthorization;
                if (s4 != null)
                {
                    return new BasicAuthorization(s2, s4);
                }
            }
        }
        return configuration;
    }
}
