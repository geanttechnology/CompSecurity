// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.cim.http.signing;

import com.comcast.cim.cmasl.http.request.signing.RequestSigner;
import com.comcast.cim.httpcomponentsandroid.client.methods.HttpUriRequest;
import com.comcast.cim.oauth.signpost.commonshttpandroid.CommonsHttpOAuthConsumer;
import oauth.signpost.OAuthConsumer;
import oauth.signpost.exception.OAuthException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class OAuthRequestSigner
    implements RequestSigner
{

    private static final Logger LOG = LoggerFactory.getLogger(com/comcast/cim/http/signing/OAuthRequestSigner);
    private final String key;
    private final String secret;

    public OAuthRequestSigner(String s, String s1)
    {
        key = s;
        secret = s1;
    }

    public void signRequest(HttpUriRequest httpurirequest)
    {
        CommonsHttpOAuthConsumer commonshttpoauthconsumer;
        if (key == null || secret == null)
        {
            break MISSING_BLOCK_LABEL_38;
        }
        commonshttpoauthconsumer = new CommonsHttpOAuthConsumer(key, secret);
        commonshttpoauthconsumer.sign(httpurirequest);
        return;
        httpurirequest;
        LOG.error("Exception occurred during oauth signing", httpurirequest);
        return;
    }

    public volatile void signRequest(Object obj)
    {
        signRequest((HttpUriRequest)obj);
    }

}
