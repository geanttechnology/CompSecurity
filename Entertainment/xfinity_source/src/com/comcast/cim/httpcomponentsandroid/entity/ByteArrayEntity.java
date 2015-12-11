// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.cim.httpcomponentsandroid.entity;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

// Referenced classes of package com.comcast.cim.httpcomponentsandroid.entity:
//            AbstractHttpEntity

public class ByteArrayEntity extends AbstractHttpEntity
    implements Cloneable
{

    protected final byte content[];

    public ByteArrayEntity(byte abyte0[])
    {
        if (abyte0 == null)
        {
            throw new IllegalArgumentException("Source byte array may not be null");
        } else
        {
            content = abyte0;
            return;
        }
    }

    public Object clone()
        throws CloneNotSupportedException
    {
        return super.clone();
    }

    public InputStream getContent()
    {
        return new ByteArrayInputStream(content);
    }

    public long getContentLength()
    {
        return (long)content.length;
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
        if (outputstream == null)
        {
            throw new IllegalArgumentException("Output stream may not be null");
        } else
        {
            outputstream.write(content);
            outputstream.flush();
            return;
        }
    }
}
