// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.client.metrics.transport;

import amazon.communication.MissingCredentialsException;
import amazon.communication.authentication.RequestContext;
import amazon.communication.authentication.RequestSigner;
import amazon.communication.authentication.SigningException;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.apache.http.client.methods.HttpRequestBase;

public class MetricsHttpRequestSigner
    implements RequestSigner
{

    private final Map mAdditionalHeaders;
    private RequestSigner mNextRequestSigner;

    public MetricsHttpRequestSigner(Map map, RequestSigner requestsigner)
    {
        mNextRequestSigner = requestsigner;
        mAdditionalHeaders = map;
    }

    public RequestSigner getNextRequestSigner()
    {
        return mNextRequestSigner;
    }

    public void setNextRequestSigner(RequestSigner requestsigner)
    {
        mNextRequestSigner = requestsigner;
    }

    public void signRequest(HttpRequestBase httprequestbase, RequestContext requestcontext)
        throws SigningException, MissingCredentialsException
    {
        if (mAdditionalHeaders != null)
        {
            java.util.Map.Entry entry;
            for (Iterator iterator = mAdditionalHeaders.entrySet().iterator(); iterator.hasNext(); httprequestbase.addHeader((String)entry.getKey(), (String)entry.getValue()))
            {
                entry = (java.util.Map.Entry)iterator.next();
            }

        }
        if (mNextRequestSigner != null)
        {
            mNextRequestSigner.signRequest(httprequestbase, requestcontext);
        }
    }
}
