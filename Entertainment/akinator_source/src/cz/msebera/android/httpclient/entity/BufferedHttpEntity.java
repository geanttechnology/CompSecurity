// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cz.msebera.android.httpclient.entity;

import cz.msebera.android.httpclient.HttpEntity;
import cz.msebera.android.httpclient.util.Args;
import cz.msebera.android.httpclient.util.EntityUtils;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

// Referenced classes of package cz.msebera.android.httpclient.entity:
//            HttpEntityWrapper

public class BufferedHttpEntity extends HttpEntityWrapper
{

    private final byte buffer[];

    public BufferedHttpEntity(HttpEntity httpentity)
        throws IOException
    {
        super(httpentity);
        if (!httpentity.isRepeatable() || httpentity.getContentLength() < 0L)
        {
            buffer = EntityUtils.toByteArray(httpentity);
            return;
        } else
        {
            buffer = null;
            return;
        }
    }

    public InputStream getContent()
        throws IOException
    {
        if (buffer != null)
        {
            return new ByteArrayInputStream(buffer);
        } else
        {
            return super.getContent();
        }
    }

    public long getContentLength()
    {
        if (buffer != null)
        {
            return (long)buffer.length;
        } else
        {
            return super.getContentLength();
        }
    }

    public boolean isChunked()
    {
        return buffer == null && super.isChunked();
    }

    public boolean isRepeatable()
    {
        return true;
    }

    public boolean isStreaming()
    {
        return buffer == null && super.isStreaming();
    }

    public void writeTo(OutputStream outputstream)
        throws IOException
    {
        Args.notNull(outputstream, "Output stream");
        if (buffer != null)
        {
            outputstream.write(buffer);
            return;
        } else
        {
            super.writeTo(outputstream);
            return;
        }
    }
}
