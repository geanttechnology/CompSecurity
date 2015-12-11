// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.scribe.builder.api;

import org.scribe.model.Token;

// Referenced classes of package org.scribe.builder.api:
//            DefaultApi10a

public class TwitterApi extends DefaultApi10a
{
    public static class Authenticate extends SSL
    {

        private static final String AUTHENTICATE_URL = "https://api.twitter.com/oauth/authenticate?oauth_token=%s";

        public String getAuthorizationUrl(Token token)
        {
            return String.format("https://api.twitter.com/oauth/authenticate?oauth_token=%s", new Object[] {
                token.getToken()
            });
        }

        public Authenticate()
        {
        }
    }

    public static class Authorize extends SSL
    {

        public Authorize()
        {
        }
    }

    public static class SSL extends TwitterApi
    {

        public String getAccessTokenEndpoint()
        {
            return "https://api.twitter.com/oauth/access_token";
        }

        public String getRequestTokenEndpoint()
        {
            return "https://api.twitter.com/oauth/request_token";
        }

        public SSL()
        {
        }
    }


    private static final String ACCESS_TOKEN_RESOURCE = "api.twitter.com/oauth/access_token";
    private static final String AUTHORIZE_URL = "https://api.twitter.com/oauth/authorize?oauth_token=%s";
    private static final String REQUEST_TOKEN_RESOURCE = "api.twitter.com/oauth/request_token";

    public TwitterApi()
    {
    }

    public String getAccessTokenEndpoint()
    {
        return "http://api.twitter.com/oauth/access_token";
    }

    public String getAuthorizationUrl(Token token)
    {
        return String.format("https://api.twitter.com/oauth/authorize?oauth_token=%s", new Object[] {
            token.getToken()
        });
    }

    public String getRequestTokenEndpoint()
    {
        return "http://api.twitter.com/oauth/request_token";
    }
}
