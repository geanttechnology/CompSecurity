// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cz.msebera.android.httpclient.client.entity;

import cz.msebera.android.httpclient.Header;
import cz.msebera.android.httpclient.HttpEntity;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

// Referenced classes of package cz.msebera.android.httpclient.client.entity:
//            DecompressingEntity, DeflateInputStream

public class DeflateDecompressingEntity extends DecompressingEntity
{

    public DeflateDecompressingEntity(HttpEntity httpentity)
    {
        super(httpentity);
    }

    InputStream decorate(InputStream inputstream)
        throws IOException
    {
        return new DeflateInputStream(inputstream);
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

    public volatile void writeTo(OutputStream outputstream)
        throws IOException
    {
        super.writeTo(outputstream);
    }
}
