// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cz.msebera.android.httpclient.entity;

import cz.msebera.android.httpclient.Header;
import cz.msebera.android.httpclient.HttpEntity;
import cz.msebera.android.httpclient.util.Args;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class HttpEntityWrapper
    implements HttpEntity
{

    protected HttpEntity wrappedEntity;

    public HttpEntityWrapper(HttpEntity httpentity)
    {
        wrappedEntity = (HttpEntity)Args.notNull(httpentity, "Wrapped entity");
    }

    public void consumeContent()
        throws IOException
    {
        wrappedEntity.consumeContent();
    }

    public InputStream getContent()
        throws IOException
    {
        return wrappedEntity.getContent();
    }

    public Header getContentEncoding()
    {
        return wrappedEntity.getContentEncoding();
    }

    public long getContentLength()
    {
        return wrappedEntity.getContentLength();
    }

    public Header getContentType()
    {
        return wrappedEntity.getContentType();
    }

    public boolean isChunked()
    {
        return wrappedEntity.isChunked();
    }

    public boolean isRepeatable()
    {
        return wrappedEntity.isRepeatable();
    }

    public boolean isStreaming()
    {
        return wrappedEntity.isStreaming();
    }

    public void writeTo(OutputStream outputstream)
        throws IOException
    {
        wrappedEntity.writeTo(outputstream);
    }
}
