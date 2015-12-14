// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.squareup.okhttp;

import com.squareup.okhttp.internal.Util;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.charset.Charset;
import okio.f;

// Referenced classes of package com.squareup.okhttp:
//            MediaType

public abstract class ResponseBody
    implements Closeable
{

    private Reader reader;

    public ResponseBody()
    {
    }

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

    public final InputStream byteStream()
    {
        return source().f();
    }

    public final byte[] bytes()
    {
        f f1;
        long l;
        l = contentLength();
        if (l > 0x7fffffffL)
        {
            throw new IOException((new StringBuilder()).append("Cannot buffer entire body for content length: ").append(l).toString());
        }
        f1 = source();
        Object obj = f1.p();
        Util.closeQuietly(f1);
        if (l != -1L && l != (long)obj.length)
        {
            throw new IOException("Content-Length and stream length disagree");
        } else
        {
            return ((byte []) (obj));
        }
        obj;
        Util.closeQuietly(f1);
        throw obj;
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
    {
        source().close();
    }

    public abstract long contentLength();

    public abstract MediaType contentType();

    public abstract f source();

    public final String string()
    {
        return new String(bytes(), charset().name());
    }
}
