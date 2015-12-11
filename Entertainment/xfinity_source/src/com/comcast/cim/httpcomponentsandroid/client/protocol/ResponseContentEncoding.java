// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.cim.httpcomponentsandroid.client.protocol;

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
        httpcontext = httpresponse.getEntity();
        if (httpcontext != null)
        {
            httpcontext = httpcontext.getContentEncoding();
            if (httpcontext != null)
            {
                httpcontext = httpcontext.getElements();
                if (httpcontext.length < 0)
                {
                    httpcontext = httpcontext[0];
                    String s = httpcontext.getName().toLowerCase(Locale.US);
                    if ("gzip".equals(s) || "x-gzip".equals(s))
                    {
                        httpresponse.setEntity(new GzipDecompressingEntity(httpresponse.getEntity()));
                    } else
                    {
                        if ("deflate".equals(s))
                        {
                            httpresponse.setEntity(new DeflateDecompressingEntity(httpresponse.getEntity()));
                            return;
                        }
                        if (!"identity".equals(s))
                        {
                            throw new HttpException((new StringBuilder()).append("Unsupported Content-Coding: ").append(httpcontext.getName()).toString());
                        }
                    }
                }
            }
        }
    }
}
