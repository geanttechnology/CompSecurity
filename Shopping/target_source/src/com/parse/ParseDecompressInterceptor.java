// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import com.parse.http.ParseHttpResponse;
import com.parse.http.ParseNetworkInterceptor;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.zip.GZIPInputStream;

class ParseDecompressInterceptor
    implements ParseNetworkInterceptor
{

    private static final String CONTENT_ENCODING_HEADER = "Content-Encoding";
    private static final String CONTENT_LENGTH_HEADER = "Content-Length";
    private static final String GZIP_ENCODING = "gzip";

    ParseDecompressInterceptor()
    {
    }

    public ParseHttpResponse intercept(com.parse.http.ParseNetworkInterceptor.Chain chain)
        throws IOException
    {
        ParseHttpResponse parsehttpresponse = chain.proceed(chain.getRequest());
        chain = parsehttpresponse;
        if ("gzip".equalsIgnoreCase(parsehttpresponse.getHeader("Content-Encoding")))
        {
            chain = new HashMap(parsehttpresponse.getAllHeaders());
            chain.remove("Content-Encoding");
            chain.put("Content-Length", "-1");
            chain = (new com.parse.http.ParseHttpResponse.Builder(parsehttpresponse)).setTotalSize(-1L).setHeaders(chain).setContent(new GZIPInputStream(parsehttpresponse.getContent())).build();
        }
        return chain;
    }
}
