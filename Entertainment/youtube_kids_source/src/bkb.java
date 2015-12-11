// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpResponseInterceptor;
import org.apache.http.protocol.HttpContext;

public final class bkb
    implements HttpResponseInterceptor
{

    public bkb()
    {
    }

    public final void process(HttpResponse httpresponse, HttpContext httpcontext)
    {
        httpcontext = httpresponse.getEntity();
        Header header;
        if (httpcontext != null)
        {
            if ((header = httpcontext.getContentEncoding()) != null && "gzip".equals(header.getValue()))
            {
                httpresponse.setEntity(new bkc(this, httpcontext));
                return;
            }
        }
    }
}
