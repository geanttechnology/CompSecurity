// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cz.msebera.android.httpclient.entity;

import cz.msebera.android.httpclient.protocol.HTTP;
import cz.msebera.android.httpclient.util.Args;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.nio.charset.UnsupportedCharsetException;

// Referenced classes of package cz.msebera.android.httpclient.entity:
//            AbstractHttpEntity, ContentType

public class StringEntity extends AbstractHttpEntity
    implements Cloneable
{

    protected final byte content[];

    public StringEntity(String s)
        throws UnsupportedEncodingException
    {
        this(s, ContentType.DEFAULT_TEXT);
    }

    public StringEntity(String s, ContentType contenttype)
        throws UnsupportedCharsetException
    {
        Args.notNull(s, "Source string");
        Charset charset;
        Charset charset1;
        if (contenttype != null)
        {
            charset = contenttype.getCharset();
        } else
        {
            charset = null;
        }
        charset1 = charset;
        if (charset == null)
        {
            charset1 = HTTP.DEF_CONTENT_CHARSET;
        }
        try
        {
            content = s.getBytes(charset1.name());
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            throw new UnsupportedCharsetException(charset1.name());
        }
        if (contenttype != null)
        {
            setContentType(contenttype.toString());
        }
    }

    public StringEntity(String s, String s1)
        throws UnsupportedCharsetException
    {
        this(s, ContentType.create(ContentType.TEXT_PLAIN.getMimeType(), s1));
    }

    public StringEntity(String s, String s1, String s2)
        throws UnsupportedEncodingException
    {
        Args.notNull(s, "Source string");
        if (s1 == null)
        {
            s1 = "text/plain";
        }
        if (s2 == null)
        {
            s2 = "ISO-8859-1";
        }
        content = s.getBytes(s2);
        setContentType((new StringBuilder()).append(s1).append("; charset=").append(s2).toString());
    }

    public StringEntity(String s, Charset charset)
    {
        this(s, ContentType.create(ContentType.TEXT_PLAIN.getMimeType(), charset));
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
        Args.notNull(outputstream, "Output stream");
        outputstream.write(content);
        outputstream.flush();
    }
}
