// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package oauth.signpost;

import java.util.Map;
import oauth.signpost.http.HttpParameters;

// Referenced classes of package oauth.signpost:
//            OAuthProvider, OAuthProviderListener

public abstract class AbstractOAuthProvider
    implements OAuthProvider
{

    private String accessTokenEndpointUrl;
    private String authorizationWebsiteUrl;
    private Map defaultHeaders;
    private boolean isOAuth10a;
    private transient OAuthProviderListener listener;
    private String requestTokenEndpointUrl;
    private HttpParameters responseParameters;

    public String getAccessTokenEndpointUrl()
    {
        return accessTokenEndpointUrl;
    }

    public String getAuthorizationWebsiteUrl()
    {
        return authorizationWebsiteUrl;
    }

    public Map getRequestHeaders()
    {
        return defaultHeaders;
    }

    public String getRequestTokenEndpointUrl()
    {
        return requestTokenEndpointUrl;
    }

    public HttpParameters getResponseParameters()
    {
        return responseParameters;
    }

    public boolean isOAuth10a()
    {
        return isOAuth10a;
    }

    public void setListener(OAuthProviderListener oauthproviderlistener)
    {
        listener = oauthproviderlistener;
    }

    public void setOAuth10a(boolean flag)
    {
        isOAuth10a = flag;
    }

    public void setResponseParameters(HttpParameters httpparameters)
    {
        responseParameters = httpparameters;
    }
}
