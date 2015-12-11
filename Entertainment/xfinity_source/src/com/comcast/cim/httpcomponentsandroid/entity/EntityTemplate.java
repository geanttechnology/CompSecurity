// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.cim.httpcomponentsandroid.entity;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

// Referenced classes of package com.comcast.cim.httpcomponentsandroid.entity:
//            AbstractHttpEntity, ContentProducer

public class EntityTemplate extends AbstractHttpEntity
{

    private final ContentProducer contentproducer;

    public InputStream getContent()
    {
        throw new UnsupportedOperationException("Entity template does not implement getContent()");
    }

    public long getContentLength()
    {
        return -1L;
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
            contentproducer.writeTo(outputstream);
            return;
        }
    }
}
