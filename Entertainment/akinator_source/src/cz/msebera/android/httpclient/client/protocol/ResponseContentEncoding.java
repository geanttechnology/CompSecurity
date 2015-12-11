// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cz.msebera.android.httpclient.client.protocol;

import cz.msebera.android.httpclient.Header;
import cz.msebera.android.httpclient.HeaderElement;
import cz.msebera.android.httpclient.HttpEntity;
import cz.msebera.android.httpclient.HttpException;
import cz.msebera.android.httpclient.HttpResponse;
import cz.msebera.android.httpclient.HttpResponseInterceptor;
import cz.msebera.android.httpclient.client.entity.DeflateDecompressingEntity;
import cz.msebera.android.httpclient.client.entity.GzipDecompressingEntity;
import cz.msebera.android.httpclient.protocol.HttpContext;
import java.io.IOException;
import java.util.Locale;

public class ResponseContentEncoding
    implements HttpResponseInterceptor
{

    public static final String UNCOMPRESSED = "http.client.response.uncompressed";

    public ResponseContentEncoding()
    {
    }

    public void process(HttpResponse httpresponse, HttpContext httpcontext)
        throws HttpException, IOException
    {
        httpcontext = httpresponse.getEntity();
        if (httpcontext == null || httpcontext.getContentLength() == 0L) goto _L2; else goto _L1
_L1:
        httpcontext = httpcontext.getContentEncoding();
        if (httpcontext == null) goto _L2; else goto _L3
_L3:
        String s;
        httpcontext = httpcontext.getElements();
        boolean flag = false;
        if (httpcontext.length < 0)
        {
            httpcontext = httpcontext[0];
            s = httpcontext.getName().toLowerCase(Locale.ENGLISH);
            if ("gzip".equals(s) || "x-gzip".equals(s))
            {
                httpresponse.setEntity(new GzipDecompressingEntity(httpresponse.getEntity()));
                flag = true;
            } else
            {
                if (!"deflate".equals(s))
                {
                    continue;
                }
                httpresponse.setEntity(new DeflateDecompressingEntity(httpresponse.getEntity()));
                flag = true;
            }
        }
_L5:
        if (flag)
        {
            httpresponse.removeHeaders("Content-Length");
            httpresponse.removeHeaders("Content-Encoding");
            httpresponse.removeHeaders("Content-MD5");
        }
_L2:
        do
        {
            return;
        } while ("identity".equals(s));
        throw new HttpException((new StringBuilder()).append("Unsupported Content-Coding: ").append(httpcontext.getName()).toString());
        if (true) goto _L5; else goto _L4
_L4:
    }
}
