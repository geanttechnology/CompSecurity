// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.client.metrics.transport;

import amazon.communication.MissingCredentialsException;
import amazon.communication.authentication.RequestContext;
import amazon.communication.authentication.RequestSigner;
import amazon.communication.authentication.SigningException;
import org.apache.http.client.methods.HttpRequestBase;

// Referenced classes of package com.amazon.client.metrics.transport:
//            OAuthHelper

public class OAuthRequestSigner
    implements RequestSigner
{

    private OAuthHelper mOAuthHelper;

    public OAuthRequestSigner()
    {
    }

    private void validateRequest(HttpRequestBase httprequestbase)
    {
        if (httprequestbase == null)
        {
            throw new IllegalArgumentException("Request cannot be null");
        } else
        {
            return;
        }
    }

    public void setOAuthHelper(OAuthHelper oauthhelper)
    {
        mOAuthHelper = oauthhelper;
    }

    public void signRequest(HttpRequestBase httprequestbase)
        throws SigningException, MissingCredentialsException
    {
        try
        {
            validateRequest(httprequestbase);
            if (mOAuthHelper == null)
            {
                throw new IllegalArgumentException("OAuth helper is set to null");
            }
        }
        // Misplaced declaration of an exception variable
        catch (HttpRequestBase httprequestbase)
        {
            throw new MissingCredentialsException("Exception while retrieving access token", httprequestbase);
        }
        String s = mOAuthHelper.getAccessToken();
        if (s == null)
        {
            break MISSING_BLOCK_LABEL_55;
        }
        if (!s.isEmpty())
        {
            break MISSING_BLOCK_LABEL_65;
        }
        throw new IllegalArgumentException("OAuth access token is null or empty");
        httprequestbase.addHeader("x-amz-access-token", s);
        return;
    }

    public void signRequest(HttpRequestBase httprequestbase, RequestContext requestcontext)
        throws SigningException, MissingCredentialsException
    {
        if (requestcontext != null)
        {
            throw new UnsupportedOperationException("OAuthRequestSigner does not support client-provided RequestContext");
        } else
        {
            signRequest(httprequestbase);
            return;
        }
    }
}
