// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.device.crashmanager;

import amazon.communication.MissingCredentialsException;
import amazon.communication.authentication.RequestContext;
import amazon.communication.authentication.SigningException;
import com.amazon.communication.authentication.RequestSigner;
import com.amazon.device.utils.OAuthHelper;
import com.amazon.dp.logger.DPLogger;
import org.apache.http.client.methods.HttpRequestBase;

class OAuthRequestSigner
    implements RequestSigner
{

    private static final DPLogger log = new DPLogger("OAuthRequestSigner");
    private OAuthHelper mOAuthHelper;

    public OAuthRequestSigner(OAuthHelper oauthhelper)
    {
        mOAuthHelper = oauthhelper;
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

    public void signRequest(HttpRequestBase httprequestbase)
        throws SigningException, MissingCredentialsException
    {
        String s;
        try
        {
            validateRequest(httprequestbase);
            s = mOAuthHelper.getAccessToken();
        }
        // Misplaced declaration of an exception variable
        catch (HttpRequestBase httprequestbase)
        {
            throw new SigningException("Exception while retrieving access token", httprequestbase);
        }
        if (s != null)
        {
            break MISSING_BLOCK_LABEL_41;
        }
        throw new MissingCredentialsException("Null access token returned from OAuthHelper.");
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
