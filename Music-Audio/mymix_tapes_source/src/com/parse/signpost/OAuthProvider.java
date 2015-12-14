// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse.signpost;

import com.parse.signpost.exception.OAuthCommunicationException;
import com.parse.signpost.exception.OAuthExpectationFailedException;
import com.parse.signpost.exception.OAuthMessageSignerException;
import com.parse.signpost.exception.OAuthNotAuthorizedException;
import com.parse.signpost.http.HttpParameters;
import java.io.Serializable;
import java.util.Map;

// Referenced classes of package com.parse.signpost:
//            OAuthProviderListener, OAuthConsumer

public interface OAuthProvider
    extends Serializable
{

    public abstract String getAccessTokenEndpointUrl();

    public abstract String getAuthorizationWebsiteUrl();

    public abstract Map getRequestHeaders();

    public abstract String getRequestTokenEndpointUrl();

    public abstract HttpParameters getResponseParameters();

    public abstract boolean isOAuth10a();

    public abstract void removeListener(OAuthProviderListener oauthproviderlistener);

    public abstract void retrieveAccessToken(OAuthConsumer oauthconsumer, String s)
        throws OAuthMessageSignerException, OAuthNotAuthorizedException, OAuthExpectationFailedException, OAuthCommunicationException;

    public abstract String retrieveRequestToken(OAuthConsumer oauthconsumer, String s)
        throws OAuthMessageSignerException, OAuthNotAuthorizedException, OAuthExpectationFailedException, OAuthCommunicationException;

    public abstract void setListener(OAuthProviderListener oauthproviderlistener);

    public abstract void setOAuth10a(boolean flag);

    public abstract void setRequestHeader(String s, String s1);

    public abstract void setResponseParameters(HttpParameters httpparameters);
}
