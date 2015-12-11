// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.net;

import java.io.IOException;
import java.net.HttpURLConnection;

// Referenced classes of package com.amazon.mShop.net:
//            HttpFetcher, ServiceCallIdentifier

private static final class VoidParams extends HttpFetcher
{
    private static final class VoidParams extends HttpFetcher.Params
    {

        public final ServiceCallIdentifier getServiceCallIdentifier()
        {
            return null;
        }

        public final HttpFetcher.Subscriber getSubscriber()
        {
            return null;
        }

        public VoidParams(String s)
        {
            super(s, null);
        }
    }


    protected Class getParameterizedClass()
    {
        return null;
    }

    public volatile Object handleResponse(HttpURLConnection httpurlconnection)
        throws IOException
    {
        return handleResponse(httpurlconnection);
    }

    public Void handleResponse(HttpURLConnection httpurlconnection)
        throws IOException
    {
        return null;
    }

    protected boolean isVoidRequest()
    {
        return true;
    }

    public >(String s)
    {
        super(new VoidParams(s));
    }
}
