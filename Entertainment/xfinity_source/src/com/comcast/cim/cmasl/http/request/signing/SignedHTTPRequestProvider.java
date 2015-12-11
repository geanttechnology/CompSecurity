// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.cim.cmasl.http.request.signing;

import com.comcast.cim.cmasl.http.request.RequestProvider;
import com.comcast.cim.cmasl.utils.exceptions.CimException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

// Referenced classes of package com.comcast.cim.cmasl.http.request.signing:
//            RequestSigner

public class SignedHTTPRequestProvider
    implements RequestProvider
{

    private final Logger LOG = LoggerFactory.getLogger(getClass());
    private RequestProvider delegateProvider;
    private RequestSigner requestSigner;

    public SignedHTTPRequestProvider(RequestProvider requestprovider, RequestSigner requestsigner)
    {
        delegateProvider = requestprovider;
        requestSigner = requestsigner;
    }

    public void addHeader(String s, String s1)
    {
        delegateProvider.addHeader(s, s1);
    }

    public void addHttpEntityParameter(String s, String s1)
    {
        delegateProvider.addHttpEntityParameter(s, s1);
    }

    public void addQueryParameter(String s, String s1)
    {
        delegateProvider.addQueryParameter(s, s1);
    }

    public Object createRequest()
    {
        Object obj = delegateProvider.createRequest();
        try
        {
            requestSigner.signRequest(obj);
        }
        catch (CimException cimexception)
        {
            LOG.error("Exception occurred during signing", cimexception);
            return obj;
        }
        return obj;
    }

    public void setSocketTimeout(long l)
    {
        delegateProvider.setSocketTimeout(l);
    }
}
