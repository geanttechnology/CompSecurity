// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.apache.commons.httpclient.methods;

import java.io.IOException;
import java.io.OutputStream;

// Referenced classes of package org.apache.commons.httpclient.methods:
//            RequestEntity

public class ByteArrayRequestEntity
    implements RequestEntity
{

    private byte content[];
    private String contentType;

    public ByteArrayRequestEntity(byte abyte0[])
    {
        this(abyte0, null);
    }

    public ByteArrayRequestEntity(byte abyte0[], String s)
    {
        if (abyte0 == null)
        {
            throw new IllegalArgumentException("The content cannot be null");
        } else
        {
            content = abyte0;
            contentType = s;
            return;
        }
    }

    public byte[] getContent()
    {
        return content;
    }

    public long getContentLength()
    {
        return (long)content.length;
    }

    public String getContentType()
    {
        return contentType;
    }

    public boolean isRepeatable()
    {
        return true;
    }

    public void writeRequest(OutputStream outputstream)
        throws IOException
    {
        outputstream.write(content);
    }
}
