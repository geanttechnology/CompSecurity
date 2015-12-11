// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cz.msebera.android.httpclient.client.entity;

import cz.msebera.android.httpclient.Header;
import cz.msebera.android.httpclient.HttpEntity;
import cz.msebera.android.httpclient.entity.HttpEntityWrapper;
import cz.msebera.android.httpclient.message.BasicHeader;
import cz.msebera.android.httpclient.util.Args;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.zip.GZIPOutputStream;

public class GzipCompressingEntity extends HttpEntityWrapper
{

    private static final String GZIP_CODEC = "gzip";

    public GzipCompressingEntity(HttpEntity httpentity)
    {
        super(httpentity);
    }

    public InputStream getContent()
        throws IOException
    {
        throw new UnsupportedOperationException();
    }

    public Header getContentEncoding()
    {
        return new BasicHeader("Content-Encoding", "gzip");
    }

    public long getContentLength()
    {
        return -1L;
    }

    public boolean isChunked()
    {
        return true;
    }

    public void writeTo(OutputStream outputstream)
        throws IOException
    {
        Args.notNull(outputstream, "Output stream");
        outputstream = new GZIPOutputStream(outputstream);
        wrappedEntity.writeTo(outputstream);
        outputstream.close();
    }
}
