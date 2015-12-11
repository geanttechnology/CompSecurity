// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.squareup.okhttp;

import com.squareup.okhttp.internal.Util;
import java.io.Closeable;
import java.io.IOException;
import okio.BufferedSource;

public abstract class ResponseBody
    implements Closeable
{

    public ResponseBody()
    {
    }

    public final byte[] bytes()
        throws IOException
    {
        BufferedSource bufferedsource;
        long l;
        l = contentLength();
        if (l > 0x7fffffffL)
        {
            throw new IOException((new StringBuilder()).append("Cannot buffer entire body for content length: ").append(l).toString());
        }
        bufferedsource = source();
        Object obj = bufferedsource.readByteArray();
        Util.closeQuietly(bufferedsource);
        if (l != -1L && l != (long)obj.length)
        {
            throw new IOException("Content-Length and stream length disagree");
        } else
        {
            return ((byte []) (obj));
        }
        obj;
        Util.closeQuietly(bufferedsource);
        throw obj;
    }

    public void close()
        throws IOException
    {
        source().close();
    }

    public abstract long contentLength()
        throws IOException;

    public abstract BufferedSource source()
        throws IOException;
}
