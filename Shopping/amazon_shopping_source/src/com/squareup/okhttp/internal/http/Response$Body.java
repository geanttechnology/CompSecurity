// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.squareup.okhttp.internal.http;

import com.squareup.okhttp.MediaType;
import com.squareup.okhttp.internal.Util;
import com.squareup.okhttp.internal.okio.Okio;
import com.squareup.okhttp.internal.okio.Source;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.charset.Charset;

// Referenced classes of package com.squareup.okhttp.internal.http:
//            Response

public static abstract class 
    implements Closeable
{

    private Reader reader;
    private Source source;

    private Charset charset()
    {
        MediaType mediatype = contentType();
        if (mediatype != null)
        {
            return mediatype.charset(Util.UTF_8);
        } else
        {
            return Util.UTF_8;
        }
    }

    public abstract InputStream byteStream();

    public final byte[] bytes()
        throws IOException
    {
        long l = contentLength();
        if (l > 0x7fffffffL)
        {
            throw new IOException((new StringBuilder()).append("Cannot buffer entire body for content length: ").append(l).toString());
        }
        byte abyte0[];
        if (l != -1L)
        {
            abyte0 = new byte[(int)l];
            InputStream inputstream = byteStream();
            Util.readFully(inputstream, abyte0);
            if (inputstream.read() != -1)
            {
                throw new IOException("Content-Length and stream length disagree");
            }
        } else
        {
            abyte0 = new ByteArrayOutputStream();
            Util.copy(byteStream(), abyte0);
            abyte0 = abyte0.toByteArray();
        }
        return abyte0;
    }

    public final Reader charStream()
    {
        Reader reader1 = reader;
        if (reader1 != null)
        {
            return reader1;
        } else
        {
            InputStreamReader inputstreamreader = new InputStreamReader(byteStream(), charset());
            reader = inputstreamreader;
            return inputstreamreader;
        }
    }

    public void close()
        throws IOException
    {
        byteStream().close();
    }

    public abstract long contentLength();

    public abstract MediaType contentType();

    public abstract boolean ready()
        throws IOException;

    public Source source()
    {
        Source source1 = source;
        if (source1 != null)
        {
            return source1;
        } else
        {
            Source source2 = Okio.source(byteStream());
            source = source2;
            return source2;
        }
    }

    public final String string()
        throws IOException
    {
        return new String(bytes(), charset().name());
    }

    public ()
    {
    }
}
