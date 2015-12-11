// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.cim.httpcomponentsandroid.client.entity;

import com.comcast.cim.httpcomponentsandroid.Header;
import com.comcast.cim.httpcomponentsandroid.HttpEntity;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.zip.GZIPInputStream;

// Referenced classes of package com.comcast.cim.httpcomponentsandroid.client.entity:
//            DecompressingEntity

public class GzipDecompressingEntity extends DecompressingEntity
{

    public GzipDecompressingEntity(HttpEntity httpentity)
    {
        super(httpentity);
    }

    public volatile InputStream getContent()
        throws IOException
    {
        return super.getContent();
    }

    public Header getContentEncoding()
    {
        return null;
    }

    public long getContentLength()
    {
        return -1L;
    }

    InputStream getDecompressingInputStream(InputStream inputstream)
        throws IOException
    {
        return new GZIPInputStream(inputstream);
    }

    public volatile void writeTo(OutputStream outputstream)
        throws IOException
    {
        super.writeTo(outputstream);
    }
}
