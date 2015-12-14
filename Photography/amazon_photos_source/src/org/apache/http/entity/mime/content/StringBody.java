// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.apache.http.entity.mime.content;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;

// Referenced classes of package org.apache.http.entity.mime.content:
//            AbstractContentBody

public class StringBody extends AbstractContentBody
{

    private final Charset charset;
    private final byte content[];

    public StringBody(String s, String s1, Charset charset1)
        throws UnsupportedEncodingException
    {
        super(s1);
        if (s == null)
        {
            throw new IllegalArgumentException("Text may not be null");
        }
        s1 = charset1;
        if (charset1 == null)
        {
            s1 = Charset.defaultCharset();
        }
        content = s.getBytes(s1.name());
        charset = s1;
    }

    public StringBody(String s, Charset charset1)
        throws UnsupportedEncodingException
    {
        this(s, "text/plain", charset1);
    }

    public String getCharset()
    {
        return charset.name();
    }

    public long getContentLength()
    {
        return (long)content.length;
    }

    public String getFilename()
    {
        return null;
    }

    public String getTransferEncoding()
    {
        return "8bit";
    }

    public void writeTo(OutputStream outputstream)
        throws IOException
    {
        if (outputstream == null)
        {
            throw new IllegalArgumentException("Output stream may not be null");
        }
        ByteArrayInputStream bytearrayinputstream = new ByteArrayInputStream(content);
        byte abyte0[] = new byte[4096];
        do
        {
            int i = bytearrayinputstream.read(abyte0);
            if (i != -1)
            {
                outputstream.write(abyte0, 0, i);
            } else
            {
                outputstream.flush();
                return;
            }
        } while (true);
    }
}
