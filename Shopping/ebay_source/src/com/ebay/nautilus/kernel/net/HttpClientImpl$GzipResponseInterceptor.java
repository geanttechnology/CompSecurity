// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.kernel.net;

import java.io.IOException;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpException;
import org.apache.http.HttpResponse;
import org.apache.http.HttpResponseInterceptor;
import org.apache.http.protocol.HttpContext;

// Referenced classes of package com.ebay.nautilus.kernel.net:
//            HttpClientImpl

private static class <init>
    implements HttpResponseInterceptor
{

    public void process(HttpResponse httpresponse, HttpContext httpcontext)
        throws HttpException, IOException
    {
        httpcontext = httpresponse.getEntity();
        if (httpcontext != null)
        {
            httpcontext = httpcontext.getContentEncoding();
            if (httpcontext != null && httpcontext.getValue().compareToIgnoreCase("gzip") == 0)
            {
                httpresponse.setEntity(new <init>(httpresponse.getEntity()));
            }
        }
    }

    private I()
    {
    }

    I(I i)
    {
        this();
    }
}
