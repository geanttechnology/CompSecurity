// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.communication;

import java.io.IOException;
import java.util.zip.GZIPInputStream;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.entity.InputStreamEntity;

public class HttpResponseDecompressor
{

    public static boolean decompressResponseIfNecessary(HttpResponse httpresponse)
        throws IOException
    {
        HttpEntity httpentity = httpresponse.getEntity();
        Header header;
        if (httpentity != null)
        {
            if ((header = httpentity.getContentEncoding()) != null)
            {
                if (!"gzip".equalsIgnoreCase(header.getValue()))
                {
                    throw new UnsupportedOperationException((new StringBuilder()).append("Unsupported encoding type: ").append(header.getValue()).toString());
                } else
                {
                    httpresponse.setEntity(new InputStreamEntity(new GZIPInputStream(httpentity.getContent()), -1L));
                    httpresponse.setHeader("Content-Length", "-1");
                    httpresponse.removeHeaders("Content-Encoding");
                    return true;
                }
            }
        }
        return false;
    }
}
