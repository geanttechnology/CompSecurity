// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cz.msebera.android.httpclient.impl.client.cache;

import cz.msebera.android.httpclient.Header;
import cz.msebera.android.httpclient.HttpEntity;
import cz.msebera.android.httpclient.client.cache.HttpCacheEntry;
import cz.msebera.android.httpclient.client.cache.Resource;
import cz.msebera.android.httpclient.util.Args;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Serializable;

// Referenced classes of package cz.msebera.android.httpclient.impl.client.cache:
//            IOUtils

class CacheEntity
    implements HttpEntity, Serializable
{

    private static final long serialVersionUID = 0xcfe273082febf0d7L;
    private final HttpCacheEntry cacheEntry;

    public CacheEntity(HttpCacheEntry httpcacheentry)
    {
        cacheEntry = httpcacheentry;
    }

    public Object clone()
        throws CloneNotSupportedException
    {
        return super.clone();
    }

    public void consumeContent()
        throws IOException
    {
    }

    public InputStream getContent()
        throws IOException
    {
        return cacheEntry.getResource().getInputStream();
    }

    public Header getContentEncoding()
    {
        return cacheEntry.getFirstHeader("Content-Encoding");
    }

    public long getContentLength()
    {
        return cacheEntry.getResource().length();
    }

    public Header getContentType()
    {
        return cacheEntry.getFirstHeader("Content-Type");
    }

    public boolean isChunked()
    {
        return false;
    }

    public boolean isRepeatable()
    {
        return true;
    }

    public boolean isStreaming()
    {
        return false;
    }

    public void writeTo(OutputStream outputstream)
        throws IOException
    {
        InputStream inputstream;
        Args.notNull(outputstream, "Output stream");
        inputstream = cacheEntry.getResource().getInputStream();
        IOUtils.copy(inputstream, outputstream);
        inputstream.close();
        return;
        outputstream;
        inputstream.close();
        throw outputstream;
    }
}
