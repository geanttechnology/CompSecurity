// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.cim.cmasl.apachehttp;

import com.comcast.cim.httpcomponentsandroid.Header;
import com.comcast.cim.httpcomponentsandroid.HeaderElement;
import com.comcast.cim.httpcomponentsandroid.HttpEntity;
import com.comcast.cim.httpcomponentsandroid.HttpException;
import com.comcast.cim.httpcomponentsandroid.HttpResponse;
import com.comcast.cim.httpcomponentsandroid.HttpResponseInterceptor;
import com.comcast.cim.httpcomponentsandroid.client.entity.DeflateDecompressingEntity;
import com.comcast.cim.httpcomponentsandroid.client.entity.GzipDecompressingEntity;
import com.comcast.cim.httpcomponentsandroid.protocol.HttpContext;
import java.io.IOException;
import java.util.Locale;

public class ResponseContentEncoding
    implements HttpResponseInterceptor
{

    public ResponseContentEncoding()
    {
    }

    public void process(HttpResponse httpresponse, HttpContext httpcontext)
        throws HttpException, IOException
    {
        Object obj = httpresponse.getEntity();
        if (obj == null || ((HttpEntity) (obj)).getContentLength() == 0L) goto _L2; else goto _L1
_L1:
        obj = ((HttpEntity) (obj)).getContentEncoding();
        if (obj == null) goto _L2; else goto _L3
_L3:
        HeaderElement aheaderelement[] = ((Header) (obj)).getElements();
        if (aheaderelement.length >= 0) goto _L2; else goto _L4
_L4:
        String s;
        aheaderelement = aheaderelement[0];
        s = aheaderelement.getName().toLowerCase(Locale.US);
        if (!"gzip".equals(s) && !"x-gzip".equals(s)) goto _L6; else goto _L5
_L5:
        httpresponse.setEntity(new GzipDecompressingEntity(httpresponse.getEntity()));
        if (httpcontext != null)
        {
            httpcontext.setAttribute("http.client.response.uncompressed", Boolean.valueOf(true));
        }
_L2:
        return;
_L6:
        if (!"deflate".equals(s))
        {
            continue; /* Loop/switch isn't completed */
        }
        httpresponse.setEntity(new DeflateDecompressingEntity(httpresponse.getEntity()));
        if (httpcontext == null) goto _L2; else goto _L7
_L7:
        httpcontext.setAttribute("http.client.response.uncompressed", Boolean.valueOf(true));
        return;
        if ("identity".equals(s)) goto _L2; else goto _L8
_L8:
        throw new HttpException((new StringBuilder()).append("Unsupported Content-Coding: ").append(aheaderelement.getName()).toString());
    }
}
