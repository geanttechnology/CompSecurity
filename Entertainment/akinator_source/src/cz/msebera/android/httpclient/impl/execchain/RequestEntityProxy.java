// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cz.msebera.android.httpclient.impl.execchain;

import cz.msebera.android.httpclient.Header;
import cz.msebera.android.httpclient.HttpEntity;
import cz.msebera.android.httpclient.HttpEntityEnclosingRequest;
import cz.msebera.android.httpclient.HttpRequest;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

class RequestEntityProxy
    implements HttpEntity
{

    private boolean consumed;
    private final HttpEntity original;

    RequestEntityProxy(HttpEntity httpentity)
    {
        consumed = false;
        original = httpentity;
    }

    static void enhance(HttpEntityEnclosingRequest httpentityenclosingrequest)
    {
        HttpEntity httpentity = httpentityenclosingrequest.getEntity();
        if (httpentity != null && !httpentity.isRepeatable() && !isEnhanced(httpentity))
        {
            httpentityenclosingrequest.setEntity(new RequestEntityProxy(httpentity));
        }
    }

    static boolean isEnhanced(HttpEntity httpentity)
    {
        return httpentity instanceof RequestEntityProxy;
    }

    static boolean isRepeatable(HttpRequest httprequest)
    {
label0:
        {
            if (httprequest instanceof HttpEntityEnclosingRequest)
            {
                httprequest = ((HttpEntityEnclosingRequest)httprequest).getEntity();
                if (httprequest != null && (!isEnhanced(httprequest) || ((RequestEntityProxy)httprequest).isConsumed()))
                {
                    break label0;
                }
            }
            return true;
        }
        return httprequest.isRepeatable();
    }

    public void consumeContent()
        throws IOException
    {
        consumed = true;
        original.consumeContent();
    }

    public InputStream getContent()
        throws IOException, IllegalStateException
    {
        return original.getContent();
    }

    public Header getContentEncoding()
    {
        return original.getContentEncoding();
    }

    public long getContentLength()
    {
        return original.getContentLength();
    }

    public Header getContentType()
    {
        return original.getContentType();
    }

    public HttpEntity getOriginal()
    {
        return original;
    }

    public boolean isChunked()
    {
        return original.isChunked();
    }

    public boolean isConsumed()
    {
        return consumed;
    }

    public boolean isRepeatable()
    {
        return original.isRepeatable();
    }

    public boolean isStreaming()
    {
        return original.isStreaming();
    }

    public String toString()
    {
        StringBuilder stringbuilder = new StringBuilder("RequestEntityProxy{");
        stringbuilder.append(original);
        stringbuilder.append('}');
        return stringbuilder.toString();
    }

    public void writeTo(OutputStream outputstream)
        throws IOException
    {
        consumed = true;
        original.writeTo(outputstream);
    }
}
