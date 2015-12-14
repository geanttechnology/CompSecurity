// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.apache.http.entity;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;

// Referenced classes of package org.apache.http.entity:
//            AbstractHttpEntity

public class StringEntity extends AbstractHttpEntity
    implements Cloneable
{

    protected final byte content[];

    public StringEntity(String s)
        throws UnsupportedEncodingException
    {
        this(s, null);
    }

    public StringEntity(String s, String s1)
        throws UnsupportedEncodingException
    {
        if (s == null)
        {
            throw new IllegalArgumentException("Source string may not be null");
        }
        String s2 = s1;
        if (s1 == null)
        {
            s2 = "ISO-8859-1";
        }
        content = s.getBytes(s2);
        setContentType("text/plain; charset=" + s2);
    }

    public Object clone()
        throws CloneNotSupportedException
    {
        return super.clone();
    }

    public InputStream getContent()
        throws IOException
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
